/**
 * 
 */
package com.careservices.rest.api;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.json.JSONArray;
import org.json.JSONObject;

import com.careservices.constants.TaskStatusConstants;
import com.careservices.dao.CareUser;
import com.careservices.dao.CareUserDAO;
import com.careservices.dao.ClientTrail;
import com.careservices.dao.ClientTrailDAO;
import com.careservices.dao.Contact;
import com.careservices.dao.ContactDAO;
import com.careservices.dao.EmployeeTask;
import com.careservices.dao.EmployeeTaskDAO;
import com.careservices.dao.HibernateSessionFactory;

/**
 * @author JARVIS
 *
 */
@Path("/trial")
public class RestClientTrailApi {
	
	@Path("/delete/{trial_id}")
	@GET
	@Produces("application/json")
	public Response deleteTrial(@PathParam("trial_id") Integer trialId)
	{
		Session session  = HibernateSessionFactory.getSession();
		ClientTrail trial = (ClientTrail)session.get(ClientTrail.class, trialId);
		EmployeeTask task = (EmployeeTask) session.get(EmployeeTask.class, trial.getRelatedTask().getId()); ;
		task.setStatus(TaskStatusConstants.TRIAL_DELETED);
		task.setUpdatedAt(new Timestamp(System.currentTimeMillis()));		
		trial.setStatus(TaskStatusConstants.DELETED);		
		Transaction orgTransaction1 = null;
		try {
			orgTransaction1 = session.beginTransaction();
			session.merge(trial);
			session.update(task);
			orgTransaction1.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.evict(trial);
			session.evict(task);
			session.clear();			
			session.close();
		}
		
		JSONObject obj = new JSONObject();
		obj.put("message", "Trial Deleted Successfully.");
		return Response.status(200).entity(obj.toString()).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
	}
	
	@Path("/all/{employee_id}")
	@GET
	@Produces("application/json")
	public Response getEmployeeTrialDetails(@PathParam("employee_id") Integer employeeId) throws ParseException {

		Session session = HibernateSessionFactory.getSession();
		JSONObject obj = new JSONObject();
		JSONArray array = new JSONArray();				
		CareUser employee = new CareUserDAO().findById(employeeId);
		
		Criteria criteria = session.createCriteria(ClientTrail.class);
		criteria.createAlias("relatedTask", "task").add(Restrictions.eq("task.actor", employee));
		criteria.addOrder(Order.asc("trailStartDate")).addOrder(Order.asc("time"));				
		List<ClientTrail>trials  = criteria.list();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
		SimpleDateFormat timeFormat24 = new SimpleDateFormat("HH:mm");
		Date minDate = new Date(Long.MAX_VALUE);
		Date maxDate = new Date(Long.MIN_VALUE);
		for(ClientTrail trial : trials)
		{
			if(trial.getStatus().equalsIgnoreCase(TaskStatusConstants.TRIAL))
			{
				String color="primary";
				if(!new Date().before(trial.getTrailStartDate()))
				{
					color="danger";
				}					
				JSONObject o = new JSONObject();
				o.put("id", trial.getId());
				o.put("start_date", sdf.format(trial.getTrailStartDate()));
				o.put("start_time", timeFormat.format(trial.getTime()));
				o.put("start_time_in_format",timeFormat24.format(trial.getTime()));
				o.put("end_date", sdf.format(trial.getTrailEndDate()));
				o.put("segment", trial.getSegment().getName());
				o.put("segment_id", trial.getSegment().getId());
				o.put("color", color);
				if(trial.getTrailStartDate().before(minDate))
				{
					minDate = trial.getTrailStartDate();
				}
				if(trial.getTrailStartDate().after(maxDate))
				{
					maxDate= trial.getTrailStartDate();
				}
				array.put(o);
			}				
		}
		session.clear();
		obj.put("records", array);		
		obj.put("min_date",sdf.format(minDate));
		obj.put("max_date",sdf.format(maxDate));
		return Response.status(200).entity(obj.toString()).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
	}

}

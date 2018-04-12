/**
 * 
 */
package com.careservices.rest.api;

import java.sql.Time;
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
import com.careservices.dao.Segment;
import com.careservices.dao.SegmentDAO;

/**
 * @author JARVIS
 *
 */
@Path("/trial")
public class RestClientTrailApi {
	
	@Path("/submit/{trial_id}")
	@POST
	@Produces("application/json")
	public Response submitTrial(@PathParam("trial_id")Integer trialId, String trialDetailsString)
	{
		/*trial_id=4&segment_id=2&equity_scrip_id=221&derivative_scrip_id=8&
		 * commodity_scrip_id=225&expiry_date=29-03-2018&strike_price=&
		 * lot_size=&quantity=&buy=&sell=&first_target=&second_target=&stop_loss=*/
		
		System.out.println(trialDetailsString);
		String a = trialDetailsString;
		JSONObject obj = new JSONObject(a); 
		
		Integer segmentId = obj.getInt("segment_id");
		Segment segment = new SegmentDAO().findById(segmentId);
		Integer scripId = null;
		if(segment.getName().equalsIgnoreCase("EQUITY"))
		{
			scripId = obj.getInt("equity_scrip_id");
		}
		else if(segment.getName().equalsIgnoreCase("DERIVATIVE"))
		{
			scripId = obj.getInt("derivative_scrip_id");
		}
		else if(segment.getName().equalsIgnoreCase("COMMODITY"))
		{
			scripId = obj.getInt("commodity_scrip_id");
		}
		String expiryDateString = null;//expiry_date
		
		obj.put("message", "Trail started successfully.");
		return Response.status(200).entity(obj.toString()).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
	}
	@Path("/update/{trial_id}")
	@POST
	@Produces("application/json")
	public Response updateTrial(@PathParam("trial_id")Integer trialId, String trialDetailsString)
	{
		System.out.println(trialDetailsString);
		//{"start_date":"2018-02-28","start_time":"06:30","end_date":"2018-03-13","segment_id":"3"}
		Session session = HibernateSessionFactory.getSession();
		ClientTrail trial =(ClientTrail) session.get(ClientTrail.class,trialId);
		JSONObject trialDetails = new JSONObject(trialDetailsString);
		String startDateString = trialDetails.getString("start_date");
		String startTimeString = trialDetails.getString("start_time");
		String endDateString = trialDetails.getString("end_date");
		Integer segmentId = trialDetails.getInt("segment_id"); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
		Date newStartDate = null;
		try {
			newStartDate = sdf.parse(startDateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date newEndDate = null;
		try {
			newEndDate = sdf.parse(endDateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Time time = null;
		try {
			time = new Time(timeFormat.parse(startTimeString).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Segment segment = (Segment)session.get(Segment.class, segmentId);
		trial.setSegment(segment);
		trial.setTime(time);
		trial.setTrailEndDate(newEndDate);
		trial.setTrailStartDate(newStartDate);
		
		Transaction orgTransaction1 = null;
		try {
			orgTransaction1 = session.beginTransaction();			
			session.merge(trial);
			orgTransaction1.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally
		{
			session.clear();
		}
		
		JSONObject obj = new JSONObject();
		obj.put("message", "Trail updated successfully.");
		return Response.status(200).entity(obj.toString()).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
	
	}
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
				o.put("mob", trial.getRelatedTask().getContact().getContactNumber());
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

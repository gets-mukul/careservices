/**
 * 
 */
package com.careservices.rest.api;

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

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.JSONArray;
import org.json.JSONObject;

import com.careservices.constants.TaskStatusConstants;
import com.careservices.dao.CareUser;
import com.careservices.dao.CareUserDAO;
import com.careservices.dao.ClientTrail;
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
	
	
	@Path("/all/{employee_id}")
	@GET
	@Produces("application/json")
	public Response getEmployeeTrialDetails(@PathParam("employee_id") Integer employeeId) throws ParseException {

		Session session = HibernateSessionFactory.getSession();
		JSONObject obj = new JSONObject();
		JSONArray array = new JSONArray();
		CareUser employee = new CareUserDAO().findById(employeeId);
		String hql ="from ClientTrail trial where trial.relatedTask.actor =:actor order by trial.trailStartDate, trial.time";
		Query query = session.createQuery(hql);
		query.setParameter("actor", employee);
		//query.setParameter("status", TaskStatusConstants.TRIAL);
		List<ClientTrail>trials  = query.list();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
		for(ClientTrail trial : trials)
		{
			if(trial.getStatus().equalsIgnoreCase(TaskStatusConstants.TRIAL))
			{
				String color="success";
				if(!new Date().before(trial.getTrailStartDate()))
				{
					color="danger";
				}					
				JSONObject o = new JSONObject();
				o.put("id", trial.getId());
				o.put("start_date", sdf.format(trial.getTrailStartDate()));
				o.put("start_time", timeFormat.format(trial.getTime()));
				o.put("end_date", sdf.format(trial.getTrailEndDate()));
				o.put("segment", trial.getSegment().getName());
				o.put("color", color);
				array.put(o);
			}				
		}
		obj.put("records", array);		
		return Response.status(200).entity(obj.toString()).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
	}

}

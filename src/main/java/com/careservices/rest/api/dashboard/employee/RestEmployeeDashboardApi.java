package com.careservices.rest.api.dashboard.employee;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.hibernate.Query;
import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONObject;

import com.careservices.dao.CareUser;
import com.careservices.dao.CareUserDAO;
import com.careservices.dao.ClientTrail;
import com.careservices.dao.HibernateSessionFactory;
import com.careservices.dao.Segment;

@Path("dashboard/employee/")
public class RestEmployeeDashboardApi {

	@Path("/upcoming_events/{employee_id}")
	@GET
	@Produces("application/json")
	public Response getUpcomingEventsForEmployee(@PathParam("employee_id") Integer employeeId) throws ParseException {
		// find all the trials having date as current date and next day date and status ='TRIAL'
		
		JSONObject jsonObj = new JSONObject();
		Session session = HibernateSessionFactory.getSession();
		CareUser employee = new CareUserDAO().findById(employeeId);
		LocalDate localDate = LocalDate.now();
		String currentDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(localDate);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Calendar today = Calendar.getInstance();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(currentDate);
		today.setTime(date);
		today.add(Calendar.DAY_OF_YEAR, 1);
		String nextDate = format.format(today.getTime());
		
		
		String hql = "from ClientTrail  WHERE trailStartDate between :currentDate AND :nextDate AND status='TRIAL' AND relatedTask.actor =:actor order by trailStartDate, time";
		Query query = session.createQuery(hql);
		
		Date cDate = new SimpleDateFormat("yyyy-MM-dd").parse(currentDate); 
		Date nDate = new SimpleDateFormat("yyyy-MM-dd").parse(nextDate);
		
		query.setParameter("currentDate", cDate);
		query.setParameter("nextDate",nDate );
		query.setParameter("actor", employee);
		
		List<ClientTrail> list = query.list();
		JSONArray jsonArray = new JSONArray();
		for (ClientTrail clientTrail : list) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", clientTrail.getId());
			jsonObject.put("start_date", sdf.format(clientTrail.getTrailStartDate()));
			jsonObject.put("end_date", sdf.format(clientTrail.getTrailEndDate()));
			jsonObject.put("time", clientTrail.getTime());
			jsonArray.put(jsonObject);
		}
		JSONObject jObj = new JSONObject();
		jObj.put("records", jsonArray);

		return Response.status(200).entity(jObj.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
	}
}

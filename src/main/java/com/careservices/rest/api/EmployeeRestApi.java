/**
 * 
 */
package com.careservices.rest.api;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import com.careservices.dao.CareUser;
import com.careservices.dao.CareUserDAO;
import com.careservices.dao.Contact;
import com.careservices.dao.EmployeeTask;
import com.careservices.dao.EmployeeTaskDAO;

/**
 * @author JARVIS
 *
 */
@Path("/employee")
public class EmployeeRestApi {
	@GET
	@Path("/work/{empl_id}")
	@Produces("application/json")
	public Response employeeWorkDone (@PathParam ("empl_id") Integer emplId) {
		String name = "NA";
		String location = "NA";
		Long number = null;
		String status = "NA";
		JSONObject jsonObj = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		CareUser cu = new CareUserDAO().findById(emplId);		
		Set<EmployeeTask> emplTask = cu.getEmployeeTasks();		
		for (EmployeeTask employeeTask : emplTask) {
				
			if(employeeTask.getContact().getContactName()!=null) {
				name = employeeTask.getContact().getContactName();
			}
			
			if(employeeTask.getContact().getContactLocation()!=null) {
				location = employeeTask.getContact().getContactLocation();
			}
			number = employeeTask.getContact().getContactNumber();
			status = employeeTask.getStatus();
			JSONArray jsonArray2  = new JSONArray();
			jsonArray2.put(number);
			jsonArray2.put(status);
			jsonArray2.put(name);
			jsonArray2.put(location);
			
			jsonArray.put(jsonArray2);
		}
		jsonObj.put("data", jsonArray);
		return Response.status(200).entity(jsonObj.toString()).build();
		
	}

}

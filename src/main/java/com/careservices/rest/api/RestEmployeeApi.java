/**
 * 
 */
package com.careservices.rest.api;

import java.util.List;
import java.util.Set;

import javax.json.Json;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import com.careservices.constants.TaskStatusConstants;
import com.careservices.dao.CareUser;
import com.careservices.dao.CareUserDAO;
import com.careservices.dao.ContactDAO;
import com.careservices.dao.EmployeeTask;
import com.careservices.dao.EmployeeTaskDAO;

/**
 * @author JARVIS
 *
 */
@Path("employee")
public class RestEmployeeApi {

	@GET
	@Path("/task_status")
	@Produces("application/json")
	public Response getAllEmployeeTaskStatus()
	{
		JSONArray jArr = new JSONArray();
		JSONObject obj = new JSONObject();
		CareUserDAO dao_obj = new CareUserDAO();
		List<CareUser> cu = dao_obj.findAll();
		
		for (CareUser careUser : cu) {
			String name = careUser.getName();
			Integer totalTask = careUser.getEmployeeTasks().size();
			int completeTask = 0;
			for (EmployeeTask employeeTask : careUser.getEmployeeTasks()) {
				if(!employeeTask.getStatus().equalsIgnoreCase("INCOMPLETE")) {
					completeTask++;
				}
			}
			
			JSONObject j_obj = new JSONObject();
			j_obj.put("name", name);
			j_obj.put("total_task", totalTask);
			j_obj.put("complete_task", completeTask);
			j_obj.put("id", careUser.getId());
			jArr.put(j_obj);
		}
		obj.putOnce("records",jArr);
		return Response.status(200).entity(obj.toString()).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
	}
	
	@GET
	@Path("/contact_cards")
	@Produces("application/json")

	public Response getContactCardDetails()
	{
		JSONObject obj = new JSONObject();
		
		Integer total_contact = 0;
		Integer total_assigned_contact = 0;
		Integer total_unassigned_contact = 0;
		
		List contactList = new ContactDAO().findAll();
		total_contact = contactList.size();
		
		List<EmployeeTask> tasks = new EmployeeTaskDAO().findAll();
		total_assigned_contact = tasks.size();
		
		total_unassigned_contact = total_contact-total_assigned_contact;
		obj.put("total_contacts", total_contact);
		obj.put("total_assigned_contact",total_assigned_contact);
		obj.put("total_uassigned_contacts", total_unassigned_contact);
		
		return Response.status(200).entity(obj.toString()).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
	}
	
	@GET
	@Path("/incomplete/{empl_id}")
	@Produces("application/json")
	public Response employeeWorkDone (@PathParam ("empl_id") Integer emplId) {
		
		JSONObject jsonObj = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		CareUser cu = new CareUserDAO().findById(emplId);		
		Set<EmployeeTask> emplTask = cu.getEmployeeTasks();
		int count =1;
		for (EmployeeTask employeeTask : emplTask) {
			Long number = null;
			
			if(employeeTask.getStatus().equalsIgnoreCase(TaskStatusConstants.INCOMPLETE))
			{
				
				number = employeeTask.getContact().getContactNumber();
				JSONObject obj = new JSONObject();
				obj.put("count",count++);
				obj.put("contact_number",number);
				obj.put("id", employeeTask.getContact().getId());
				jsonArray.put(obj);
			}
			
		}
		jsonObj.put("records", jsonArray);
		return Response.status(200).entity(jsonObj.toString()).build();
		
	}

}

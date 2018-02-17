/**
 * 
 */
package com.careservices.rest.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import com.careservices.dao.CareUser;
import com.careservices.dao.CareUserDAO;
import com.careservices.dao.EmployeeTask;

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
		
		CareUserDAO dao_obj = new CareUserDAO();
		List<CareUser> cu = dao_obj.findAll();
		
		for (CareUser careUser : cu) {
			String name = careUser.getName();
			Integer totalTask = careUser.getEmployeeTasks().size();
			int pendingTask = 0;
			for (EmployeeTask employeeTask : careUser.getEmployeeTasks()) {
				if(employeeTask.getStatus().equalsIgnoreCase("INCOMPLETE")) {
					pendingTask++;
				}
			}
			JSONObject j_obj = new JSONObject();
			j_obj.put("name", name);
			j_obj.put("total_task", totalTask);
			j_obj.put("pending_task", pendingTask);
			j_obj.put("id", careUser.getId());
			jArr.put(j_obj);
		}
		return Response.status(200).entity(jArr.toString()).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
	}
}

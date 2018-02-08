package com.careservices.rest.api;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import com.careservices.dao.Contact;
import com.careservices.dao.ContactDAO;

/**
 * @author JARVIS
 *
 */
@Path("/abc")
public class ContactRestApi {
	@Path("/contact")
	@GET
	@Produces("application/json")
	public Response contact() {
		ContactDAO c = new ContactDAO();
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObj = new JSONObject();
		List<Contact> clist = c.findAll();
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
		for (Contact contact : clist) {
			
			JSONArray JsonArray2 = new JSONArray();
				
			JsonArray2.put(contact.getId());
			JsonArray2.put(contact.getContactNumber());
			JsonArray2.put(sdf.format(contact.getUploadedAt()));
			JsonArray2.put(contact.getUploadedBy().getName());
			String contactName = "NA";
			if(contact.getContactName()!=null)
			{
				contactName = contact.getContactName();
			}
			JsonArray2.put(contactName);
			String location = "NA";
			if(contact.getContactLocation()!=null)
			{
				location = contact.getContactLocation();
			}
			JsonArray2.put(location);
			String assignedTo = "Not Assigned";
			if(contact.getEmployeeTasks().size()>0)
			{
				assignedTo = contact.getEmployeeTasks().iterator().next().getActor().getName();
			}
			JsonArray2.put(assignedTo);	
			jsonArray.put(JsonArray2);
			
		}
		jsonObj.put("data", jsonArray);
		return Response.status(200).entity(jsonObj.toString()).build();
	}

}

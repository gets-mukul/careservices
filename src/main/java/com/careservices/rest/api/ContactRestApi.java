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
		JSONArray ja = new JSONArray();
		JSONObject obj = new JSONObject();
		List<Contact> clist = c.findAll();
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
		for (Contact contact : clist) {
			
			JSONArray a = new JSONArray();
				
			a.put(contact.getId());
			a.put(contact.getContactNumber());
			a.put(sdf.format(contact.getUploadedAt()));
			a.put(contact.getCareUser().getName());
			String contactName = "NA";
			if(contact.getContactName()!=null)
			{
				contactName = contact.getContactName();
			}
			a.put(contactName);
			String location = "NA";
			if(contact.getContactLocation()!=null)
			{
				location = contact.getContactLocation();
			}
			a.put(location);
			String assignedTo = "Not Assigned";
			if(contact.getEmployeeTasks().size()>0)
			{
				assignedTo = contact.getEmployeeTasks().iterator().next().getCareUser().getName();
			}
			a.put(assignedTo);	
			ja.put(a);
			
		}
		obj.put("data", ja);
		return Response.status(200).entity(obj.toString()).build();
	}

}

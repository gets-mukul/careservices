/**
 * 
 */
package com.careservices.rest.api;

import java.lang.reflect.Array;
import java.util.Iterator;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.JSONArray;
import org.json.JSONObject;

import com.careservices.dao.CareUser;
import com.careservices.dao.CareUserDAO;
import com.careservices.dao.Contact;
import com.careservices.dao.ContactDAO;
import com.careservices.dao.EmployeeTask;
import com.careservices.dao.HibernateSessionFactory;

/**
 * @author JARVIS
 *
 */

@Path("/task")
public class AssignContactApi {
	@GET
	@Path("/assign/{emplId}/{adminId}/{contact_string}")
	@Produces("application/json")
	public Response assignContactToEmployee(@PathParam("emplId") Integer emplId, @PathParam("adminId") Integer adminId,
			@PathParam("contact_string") String contactString) {

		Session session = HibernateSessionFactory.getSession();

		String[] jsonArray = contactString.split(",");

		CareUser admin = new CareUserDAO().findById(adminId);
		CareUser user = new CareUserDAO().findById(emplId);
		for (int i = 0; i < jsonArray.length; i++) {

			Contact c = new ContactDAO().findById(Integer.parseInt(jsonArray[i]));
			EmployeeTask empTask = new EmployeeTask();
			empTask.setContact(c);
			empTask.setcreatedBy(admin);
			empTask.setActor(user);
			empTask.setStatus("INCOMPLETE");
			Transaction orgTransaction = null;
			try {
				orgTransaction = session.beginTransaction();
				session.save(empTask);
				orgTransaction.commit();
			} catch (HibernateException e) {
				e.printStackTrace();
			}

		}
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("admin name", admin.getName());
		jsonObj.put("employee name", user.getName());
		jsonObj.put("contact Id", jsonArray);

		return Response.status(200).entity(jsonObj.toString()).build();

	}

}

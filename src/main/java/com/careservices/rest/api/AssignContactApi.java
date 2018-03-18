/**
 * 
 */
package com.careservices.rest.api;

import java.lang.reflect.Array;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.json.JSONArray;
import org.json.JSONObject;

import com.careservices.dao.CareUser;
import com.careservices.dao.CareUserDAO;
import com.careservices.dao.ClientTrail;
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
	@Path("/assign/{emplId}/{adminId}/{contact_count}")
	@Produces("application/json")
	public Response assignContactToEmployee(@PathParam("emplId") Integer emplId, @PathParam("adminId") Integer adminId,
			@PathParam("contact_count") Integer contactCount) {

		Session session = HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(Contact.class);
		criteria.add(Restrictions.sizeEq("employeeTasks", 0));
		criteria.setMaxResults(contactCount);				
		List<Contact>contacts  = criteria.list();
		CareUser admin = new CareUserDAO().findById(adminId);
		CareUser user = new CareUserDAO().findById(emplId);
		HashSet<EmployeeTask> taskToBeAssigned = new HashSet<>();
		for(Contact c : contacts)
		{
			EmployeeTask empTask = new EmployeeTask();
			empTask.setContact(c);
			empTask.setcreatedBy(admin);
			empTask.setActor(user);
			empTask.setStatus("INCOMPLETE");
			empTask.setCreatedAt(new Timestamp(System.currentTimeMillis()));
			empTask.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
			taskToBeAssigned.add(empTask);
		}
		
		Transaction orgTransaction = null;
		try {
			orgTransaction = session.beginTransaction();
			for(EmployeeTask t : taskToBeAssigned)
			{
				session.save(t);
			}
			orgTransaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.clear();
			session.close();
		}

		return Response.status(200).entity("Contact Assigned Successfully").header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();

	}

}

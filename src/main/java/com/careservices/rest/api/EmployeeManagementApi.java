/**
 * 
 */
package com.careservices.rest.api;

import java.util.List;

import javax.json.stream.JsonParser;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;

import com.careservices.dao.CareUser;
import com.careservices.dao.CareUserDAO;
import com.careservices.dao.HibernateSessionFactory;

/**
 * @author JARVIS
 *
 */
@Path("/employee")
public class EmployeeManagementApi {
	@Path("/list")
	@GET
	@Produces("application/json")

	public Response showUserlist() {

		JSONArray jsonArray = new JSONArray();
		CareUserDAO daoObj = new CareUserDAO();
		List<CareUser> cu = daoObj.findAll();
		for (CareUser careUser : cu) {

			JSONObject jsonObj = new JSONObject();
			jsonObj.put("id", careUser.getId());
			jsonObj.put("name", careUser.getName());
			jsonObj.put("email", careUser.getEmail());
			jsonObj.put("mobile", careUser.getMobile());
			jsonObj.put("user_type", careUser.getUserType());
			jsonArray.put(jsonObj);
		}

		return Response.status(200).entity(jsonArray.toString()).build();

	}
	
	@Path("/change_user_type/{user_id}/{type}")
	@GET
	@Produces("application/json")
	
	public Response changeUserType(@PathParam ("user_id") Integer id, @PathParam ("type") String userType ) {
		
		
		Session session = HibernateSessionFactory.getSession();

		CareUser cu = new CareUserDAO().findById(id);
		
		cu.setUserType(userType);
		
		Transaction orgTransaction = null;
		try {
			orgTransaction = session.beginTransaction();
			session.save(cu);
			orgTransaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("id", id);
		jsonObj.put("user_type", userType);
		
		
		return Response.status(200).entity(jsonObj.toString()).build();
		
	}

}

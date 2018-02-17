/**
 * 
 */
package com.careservices.rest.api;

import java.util.List;

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

import com.careservices.constants.AuthenticationConstants;
import com.careservices.constants.CareUserTypes;
import com.careservices.constants.EmployeementManagementConstants;
import com.careservices.dao.CareUser;
import com.careservices.dao.CareUserDAO;
import com.careservices.dao.HibernateSessionFactory;
import com.careservices.exceptions.CareException;

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
			if(!careUser.getUserType().equalsIgnoreCase(CareUserTypes.client)) {
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("id", careUser.getId());
			jsonObj.put("name", careUser.getName());
			jsonObj.put("email", careUser.getEmail());
			jsonObj.put("mobile", careUser.getMobile());
			jsonObj.put("user_type", careUser.getUserType());
			jsonArray.put(jsonObj);
			}
		}

		return Response.status(200).entity(jsonArray.toString()).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();

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
			orgTransaction.rollback();
			return new CareException(EmployeementManagementConstants.SomethingWentWrongInChangingUserType).getMessageAsResponse();
		}		
		JSONObject obj = new JSONObject();
		obj.put("status", true);
		obj.put("message", EmployeementManagementConstants.UserTypeChangedSuccessfully);
		return Response.status(200).entity(obj.toString()).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();		
	}

}

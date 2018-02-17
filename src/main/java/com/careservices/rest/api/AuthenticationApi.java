
package com.careservices.rest.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.JSONObject;

import com.careservices.constants.AuthenticationConstants;
import com.careservices.constants.CareUserTypes;
import com.careservices.dao.CareUser;
import com.careservices.dao.CareUserDAO;
import com.careservices.dao.HibernateSessionFactory;
import com.careservices.exceptions.CareException;

/**
 * @author JARVIS
 *
 */
@Path("/auth")
public class AuthenticationApi {

	@Path("/login/{email}/{password}") ////// check for login
	@GET
	public Response checkUser(@PathParam("email") String email, @PathParam("password") String password) {

		CareUserDAO dao = new CareUserDAO();
		List<CareUser> cu = dao.findByEmail(email);
		JSONObject obj = new JSONObject();

		if (cu.size() == 0) {
			obj.put("message", AuthenticationConstants.EmailNotFound);
			obj.put("status", false);
			
		} else if (cu.size() == 1) {
			CareUser user = cu.get(0);
			if (user.getPassword().equals(password)) {
				obj.put("message", AuthenticationConstants.SuccessfulLogin);
				obj.put("status", true);
				JSONObject userProfile = new JSONObject();
				userProfile.put("id", user.getId());
				userProfile.put("name", user.getName());
				userProfile.put("image_url", user.getImageUrl());
				userProfile.put("user_type", user.getUserType());
				obj.put("user_profile", userProfile);
				
			} else {
				obj.put("message", AuthenticationConstants.PasswordIncorrect);
				obj.put("status", false);
				
			}
		} else {
			obj.put("message", AuthenticationConstants.MoreThanOneUserWithSameEmail);
			obj.put("status", false);
			
		}
		return Response.status(Status.OK).entity(obj.toString()).build();
	}

	@Path("/registration/{name}/{email}/{password}/{mobile}")
	@GET
	public Response registerUser(@PathParam("name") String name, @PathParam("email") String email,
			@PathParam("password") String password, @PathParam("mobile") Long mobile) {

		CareUserDAO dao = new CareUserDAO();
		List<CareUser> cu = dao.findByEmail(email);
		List<CareUser>careUserByMobile = dao.findByMobile(mobile);
		JSONObject obj = new JSONObject();
		if (cu.size() > 0) {
			obj.put("message", AuthenticationConstants.UserAlreadyExist);
			obj.put("status", false);			
		} 
		else if (careUserByMobile.size()>0)
		{
			obj.put("message", AuthenticationConstants.MobileAlreadyExist);
			obj.put("status", false);			
		}
		else {			
			Session session = HibernateSessionFactory.getSession();;
			session.beginTransaction();			
			CareUser careObj = new CareUser();
			careObj.setName(name);
			careObj.setEmail(email);
			careObj.setPassword(password);
			careObj.setMobile(mobile);
			careObj.setUserType(CareUserTypes.employee);
			
			Transaction orgTransaction = null;
			try {
				orgTransaction = session.beginTransaction();
				session.save(careObj);
				orgTransaction.commit();
				while (!orgTransaction.wasCommitted())
		            ;
			} catch (HibernateException e) {
				e.printStackTrace();
				if (orgTransaction != null)
					orgTransaction.rollback();
				return new CareException(AuthenticationConstants.SomeThingWentWrongInSavingCareUser).getMessageAsResponse();	
			} catch (Exception e) {
				e.printStackTrace();
				if (orgTransaction != null)
					orgTransaction.rollback();
				return new CareException(e.getMessage().toString()).getMessageAsResponse();
			}
			finally {
				HibernateSessionFactory.getSession().close();
			}
			obj.put("message", AuthenticationConstants.NewUserCreated);
			obj.put("status", true);			
		}

		return Response.status(Status.OK).entity(obj.toString()).build();
		
	}

}

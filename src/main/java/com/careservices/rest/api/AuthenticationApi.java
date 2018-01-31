
package com.careservices.rest.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.hibernate.Session;
import org.json.JSONObject;

import com.careservices.constants.AuthenticationConstants;
import com.careservices.dao.CareUser;
import com.careservices.dao.CareUserDAO;
import com.careservices.dao.HibernateSessionFactory;

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
			return Response.status(Status.OK).entity(obj.toString()).build();
		} else if (cu.size() == 1) {
			CareUser user = cu.get(0);
			if (user.getPassword().equals(password)) {
				obj.put("message", AuthenticationConstants.SuccessfulLogin);
				obj.put("status", true);
				JSONObject userProfile = new JSONObject();
				userProfile.put("id", user.getId());
				userProfile.put("name", user.getName());
				userProfile.put("image_url", user.getImageUrl());
				obj.put("user_profile", userProfile);
				return Response.status(Status.OK).entity(obj.toString()).build();
			} else {
				obj.put("message", AuthenticationConstants.PasswordIncorrect);
				obj.put("status", false);
				return Response.status(Status.OK).entity(obj.toString()).build();
			}
		} else {
			obj.put("message", AuthenticationConstants.MoreThanOneUserWithSameEmail);
			obj.put("status", false);
			return Response.status(Status.OK).entity(obj.toString()).build();
		}

	}

	@Path("/registration/{name}/{email}/{password}/{mobile}")
	@GET
	public Response registerUser(@PathParam("name") String name, @PathParam("email") String email,
			@PathParam("password") String password, @PathParam("mobile") Integer mobile) {

		CareUserDAO dao = new CareUserDAO();
		List<CareUser> cu = dao.findByEmail(email);
		JSONObject obj = new JSONObject();

		if (cu.size() > 0) {
			obj.put("message", AuthenticationConstants.UserAlreadyExist);
			obj.put("status", false);
			return Response.status(Status.OK).entity(obj.toString()).build();
		} else {

			
			Session session = HibernateSessionFactory.getSession();;
			session.beginTransaction();
			
			CareUser careObj = new CareUser();
			careObj.setName(name);
			careObj.setEmail(email);
			careObj.setPassword(password);
			careObj.setMobile((long) mobile);
			careObj.setUserType(AuthenticationConstants.Employee);
			
			session.save(careObj);
			session.getTransaction().commit();
			session.close();
	
			obj.put("message", AuthenticationConstants.NewUserCreated);
			obj.put("status", true);
			return Response.status(Status.OK).entity(obj.toString()).build();
		}

		// emailvalidation
		// if email is unique
		// create careuser
		// if no error then message
		
	}

}

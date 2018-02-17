/**
 * 
 */
package com.careservices.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.json.JSONObject;

import com.careservices.constants.AuthenticationConstants;

/**
 * @author JARVIS
 *
 */
public class CareException extends Exception {

	String message ;

	public CareException(String message) {
		super();
		this.message = message;
	}
	
	public Response getMessageAsResponse()
	{
		JSONObject obj = new JSONObject();
		obj.put("message", message);
		obj.put("status", false);	
		return Response.status(Status.OK).entity(obj.toString()).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
	}
}

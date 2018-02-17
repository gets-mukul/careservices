/**
 * 
 */
package com.careservices.rest.api;

import java.util.List;

import javax.json.JsonArray;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import com.careservices.dao.ScripCode;
import com.careservices.dao.ScripCodeDAO;

/**
 * @author JARVIS
 *
 */
@Path("/scrip")
public class RestSecripApi {
	
	@GET
	@Path("/code")
	
	
	public Response getSecripCode() {
		
		StringBuffer sb = new StringBuffer();
		ScripCodeDAO daoObj = new ScripCodeDAO();
		List<ScripCode> secripList = daoObj.findAll();
		
		for (ScripCode scripCode : secripList) {
			
			String option ="<option value='"+scripCode.getId()+"'>"+scripCode.getSymbol()+"</option>";
			sb.append(option);
		}
		
		
		return Response.status(200).entity(sb.toString()).build();
		
	}

}

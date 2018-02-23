
/**
 * 
 */
package com.careservices.rest.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashSet;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.careservices.constants.AuthenticationConstants;
import com.careservices.services.SMSUtility;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @author JARVIS
 *
 */
@Path("/sms")
public class SendSms {

	@Path("/send_sms")
	@POST
	@Produces("application/json")
	public Response SendBulkSms(String messageDetails) {

		if(messageDetails!=null)
		{
			JSONObject obj = new JSONObject(messageDetails);
			String mobileList = null;
			String message = null;
			HashSet<String> groupIds = new HashSet<>();
			JSONObject jsonObj = new JSONObject();
			
			if(obj.get("mobile_list")!=null && !obj.getString("mobile_list").equalsIgnoreCase(""))
			{
				mobileList = obj.getString("mobile_list");
			}
			if(obj.get("message")!=null && !obj.getString("message").equalsIgnoreCase(""))
			{
				message = obj.getString("message");
			}
			if(obj.get("group_ids")!=null && obj.getJSONArray("group_ids").length()!=0)
			{
				JSONArray groupsJSON = obj.getJSONArray("group_ids");
				for(int i =0; i< groupsJSON.length();i++)
				{
					Integer gid = groupsJSON.getInt(i);
					groupIds.add(gid+"");
				}	
			}
			SMSUtility utility = new SMSUtility();
			if(message==null)
			{
				jsonObj.put("message", AuthenticationConstants.NoNullMessage);
				return Response.status(200).entity(jsonObj.toString()).build();

			}
			else
			{
				if(mobileList!=null)
				{
					utility.sendSMSToMobiles(mobileList, message);
				}	
				if(groupIds.size()>0)
				{
					for(String gids: groupIds)
					{
						utility.sendSMSToGroup(gids,message);
					}
				}
			}
			
			
		}
		return Response.status(200).entity(messageDetails).build();
	}

	@Path("/create_group")
	@POST
	@Produces("application/json")
	

	public Response createGroup(String groupName) {
		
		JSONObject jsonObj = new JSONObject();
		SMSUtility utility = new SMSUtility();
		
		if(groupName==null) {
			jsonObj.put("message", AuthenticationConstants.GroupNameRequired);
			jsonObj.put("status", false);
		}
		else {
			utility.createNewGroup(groupName);
			jsonObj.put("group_name", groupName);
		}
		
		return Response.status(200).entity(jsonObj.toString()).build();
	}

	@Path("/add_contact/{auth_key}/{contact_name}/{mobile}/{group_id}")
	@GET
	@Produces("application/json")
	// Add contact to group

	public Response addContactToGroup(@PathParam("auth_key") String authKey,
			@PathParam("contact_name") String contactName, @PathParam("mobile") String mobile,
			@PathParam("group_id") String groupId) {

		String s = null;
		URLConnection myURLConnection = null;
		URL myURL = null;
		BufferedReader reader = null;

		String mainUrl = "http://login.yourbulksms.com/api/add_contact.php?";

		StringBuilder sbPostData = new StringBuilder(mainUrl);
		sbPostData.append("authkey=" + authKey);
		sbPostData.append("&name=" + contactName);
		sbPostData.append("&mob_no=" + mobile);
		sbPostData.append("&group=" + groupId);

		mainUrl = sbPostData.toString();
		try {
			// prepare connection
			myURL = new URL(mainUrl);
			myURLConnection = myURL.openConnection();
			myURLConnection.connect();
			reader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
			// reading response
			String response;
			while ((response = reader.readLine()) != null)
			// print response
			{
				s = response;
			}
			// finally close connection
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return Response.status(200).entity(s.toString()).build();
	}

	@Path("/delete_contact/{auth_key}/{contact_id}")
	@GET
	@Produces("application/json")
	// Delete contact from a group

	public Response addContactToGroup(@PathParam("auth_key") String authKey,
			@PathParam("contact_id") String contactId) {

		String s = null;
		URLConnection myURLConnection = null;
		URL myURL = null;
		BufferedReader reader = null;

		String mainUrl = "http://login.yourbulksms.com/api/delete_contact.php?";

		StringBuilder sbPostData = new StringBuilder(mainUrl);
		sbPostData.append("authkey=" + authKey);
		sbPostData.append("&contact_id=" + contactId);

		mainUrl = sbPostData.toString();
		try {
			// prepare connection
			myURL = new URL(mainUrl);
			myURLConnection = myURL.openConnection();
			myURLConnection.connect();
			reader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
			// reading response
			String response;
			while ((response = reader.readLine()) != null)
			// print response
			{
				s = response;
			}
			// finally close connection
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Response.status(200).entity(s.toString()).build();
	}

	@Path("/show_list/{auth_key}/{group_id}")
	@GET
	@Produces("application/json")
	// Show contact list of group

	public Response showContactList(@PathParam("auth_key") String authKey, @PathParam("group_id") String groupId) {

		String s = null;

		URLConnection myURLConnection = null;
		URL myURL = null;
		BufferedReader reader = null;

		String mainUrl = "http://login.yourbulksms.com/api/list_contact.php?";

		StringBuilder sbPostData = new StringBuilder(mainUrl);
		sbPostData.append("authkey=" + authKey);
		sbPostData.append("&group=" + groupId);

		mainUrl = sbPostData.toString();
		try {
			// prepare connection
			myURL = new URL(mainUrl);
			myURLConnection = myURL.openConnection();
			myURLConnection.connect();
			reader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
			// reading response

			String response;
			while ((response = reader.readLine()) != null)
			// print response
			{
				s = response;

			}
			// finally close connection
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JSONArray jsonArr = new JSONArray();
		  try
	        {
	            JSONArray jsonArray = new JSONArray(s);

	            for(int i=0;i<(jsonArray.length()-1);i++)
	            {
	                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
	                JSONObject jsonObj = new JSONObject();
	                
	                String contactid = jsonObject1.optString("contactid");
	                String number = jsonObject1.optString("number");
	                String name = jsonObject1.optString("name");
	                jsonObj.put("contactid", contactid);
	                jsonObj.put("number", number);
	                jsonObj.put("name", name);
	                jsonArr.put(jsonObj);
	                
	            }
	        }
	        catch (JSONException e)
	        {
	            e.printStackTrace();
	        }
	    
		

		return Response.status(200).entity(jsonArr.toString()).build();
	}

	@Path("/send_sms_to_group/{auth_key}/{message}/{sender_id}/{route}/{group_id}")
	@GET
	@Produces("application/json")
	// Send message to group

	public Response sendSmsToGroup(@PathParam("auth_key") String authKey, @PathParam("message") String message,
			@PathParam("sender_id") String senderId, @PathParam("route") String route,
			@PathParam("group_id") String groupId) {

		String s = null;
		URLConnection myURLConnection = null;
		URL myURL = null;
		BufferedReader reader = null;

		// encoding message
		String encoded_message = URLEncoder.encode(message);

		// Send SMS API
		String mainUrl = "http://login.yourbulksms.com/api/sendhttp.php?";

		// Prepare parameter string
		StringBuilder sbPostData = new StringBuilder(mainUrl);

		sbPostData.append("authkey=" + authKey);
		sbPostData.append("&message=" + encoded_message);
		sbPostData.append("&sender=" + route);
		sbPostData.append("&route=" + senderId);
		sbPostData.append("&group_id=" + groupId);

		// final string
		mainUrl = sbPostData.toString();
		try {
			// prepare connection
			myURL = new URL(mainUrl);
			myURLConnection = myURL.openConnection();
			myURLConnection.connect();
			reader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
			// reading response
			String response;
			while ((response = reader.readLine()) != null)
			// print response
			{
				s = response;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return Response.status(200).entity(s.toString()).build();
	}

	@Path("/List_group/{auth_key}")
	@GET
	@Produces("application/json")
	// List of Group

	public Response sendSmsToGroup(@PathParam("auth_key") String authKey) {

		String s = null;
		URLConnection myURLConnection = null;
		URL myURL = null;
		BufferedReader reader = null;

		// Send SMS API
		String mainUrl = "http://login.yourbulksms.com/api/list_group.php?";
		// Prepare parameter string
		StringBuilder sbPostData = new StringBuilder(mainUrl);

		sbPostData.append("authkey=" + authKey);

		// final string
		mainUrl = sbPostData.toString();
		try {
			// prepare connection
			myURL = new URL(mainUrl);
			myURLConnection = myURL.openConnection();
			myURLConnection.connect();
			reader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
			// reading response
			String response;
			while ((response = reader.readLine()) != null)
			// print response
			{
				s = response;
			}
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Response.status(200).entity(s.toString()).build();
	}
	
	@Path("/delete_group/{auth_key}/{group_id}")
	@GET
	@Produces("application/json")
	// Delete group

	public Response removeGroup (@PathParam("auth_key") String authKey,
			@PathParam("group_id") String groupId) {

		String s = null;
		URLConnection myURLConnection = null;
		URL myURL = null;
		BufferedReader reader = null;

		String mainUrl = "http://login.yourbulksms.com/api/delete_group.php?";

		StringBuilder sbPostData = new StringBuilder(mainUrl);
		sbPostData.append("authkey=" + authKey);
		sbPostData.append("&group_id=" + groupId);

		mainUrl = sbPostData.toString();
		try {
			// prepare connection
			myURL = new URL(mainUrl);
			myURLConnection = myURL.openConnection();
			myURLConnection.connect();
			reader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
			// reading response
			String response;
			while ((response = reader.readLine()) != null)
			// print response
			{
				s = response;
			}
			// finally close connection
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Response.status(200).entity(s.toString()).build();
	}
}

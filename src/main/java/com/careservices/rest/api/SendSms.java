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
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.jasper.tagplugins.jstl.core.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.careservices.constants.AuthenticationConstants;
import com.careservices.constants.SmsUtilityConstants;
import com.careservices.dao.Contact;
import com.careservices.dao.EmployeeTask;
import com.careservices.dao.EmployeeTaskDAO;
import com.careservices.dao.HibernateSessionFactory;
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

		JSONObject jsonObj = new JSONObject();

		if (messageDetails != null) {
			JSONObject obj = new JSONObject(messageDetails);
			String mobileList = null;
			String message = null;
			HashSet<String> groupIds = new HashSet<>();
			HashSet<String> customeGroup = new HashSet<>();

			if (obj.get("mobile_list") != null && !obj.getString("mobile_list").equalsIgnoreCase("")) {
				mobileList = obj.getString("mobile_list");
			}
			if (obj.get("message") != null && !obj.getString("message").equalsIgnoreCase("")) {
				message = obj.getString("message");
			}
			if (obj.get("group_ids") != null && obj.getJSONArray("group_ids").length() != 0) {
				JSONArray groupsJSON = obj.getJSONArray("group_ids");
				for (int i = 0; i < groupsJSON.length(); i++) {
					String gid = groupsJSON.getString(i);
					groupIds.add(gid);
				}
			}

			if (obj.get("custome_group") != null && obj.getJSONArray("custome_group").length() != 0) {
				JSONArray customeGroupsJSON = obj.getJSONArray("custome_group");
				for (int i = 0; i < customeGroupsJSON.length(); i++) {
					String group = customeGroupsJSON.getString(i);
					customeGroup.add(group);
				}
			}
			SMSUtility utility = new SMSUtility();
			if (message == null) {
				jsonObj.put("message", AuthenticationConstants.NoNullMessage);
				return Response.status(200).entity(jsonObj.toString()).build();

			} else {
				if (mobileList != null) {
					utility.sendSMSToMobiles(mobileList, message);
				}
				if (groupIds.size() > 0) {
					for (String gids : groupIds) {
						utility.sendSMSToGroup(gids, message);
					}
				}
				if (customeGroup.size() > 0) {
					for (String status : customeGroup) {
						if (status != "Others") {
							List<EmployeeTask> contactList = new EmployeeTaskDAO().findByStatus(status);
							for (EmployeeTask employeeTask : contactList) {
								String mobile = employeeTask.getContact().getContactNumber().toString();
								utility.sendSMSToMobiles(mobile, message);
							}

						} else {
							Session session = HibernateSessionFactory.getSession();
							Query query = session.createQuery("from EmployeeTask where status!='INCOMPLETE' AND status!='NOT_TRADE' AND status!='TRIAL' ");
							
							List<EmployeeTask> list = query.list();  
							for (EmployeeTask object : list) {
								String mobile= object.getContact().getContactNumber().toString();
								String str = mobile.substring(0, (mobile.length()-1));
								utility.sendSMSToMobiles(str, message);
							}
						}

					}
				}
			}
		} else {
			jsonObj.put("message", SmsUtilityConstants.DataIsNull);
			jsonObj.put("status", false);
		}
		return Response.status(Status.OK).entity(messageDetails).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();

	}

	@Path("/create_group")
	@POST
	@Produces("application/json")
	public Response createGroup(String groupName) {

		JSONObject jsonObj = new JSONObject();
		JSONObject jobj = new JSONObject();
		SMSUtility utility = new SMSUtility();
		String groupId = null;
		if (groupName == null) {
			jsonObj.put("message", SmsUtilityConstants.GroupNameRequired);
			jsonObj.put("status", false);
			return Response.status(200).entity(jsonObj.toString()).build();

		} else {
			groupId = utility.createNewGroup(groupName);
			jobj.put("group_name", groupName);
			jobj.put("group_id", groupId);
		}
		
		return Response.status(Status.OK).entity(jobj.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();

	}

	@Path("/add_contact")
	@POST
	@Produces("application/json")

	public Response addContactToGroup(String contactDetails) {

		SMSUtility utility = new SMSUtility();
		JSONObject jsonObj = new JSONObject();
		if (contactDetails != null) {
			JSONObject obj = new JSONObject(contactDetails);
			String name = null;
			String mobile = null;
			String group_id = null;

			if (obj.get("name") != null && !obj.getString("name").equalsIgnoreCase("")) {
				name = obj.getString("name");

			}
			if (obj.get("mobile") != null && !obj.getString("mobile").equalsIgnoreCase("")) {
				mobile = obj.getString("mobile");

			}
			if (obj.get("group_id") != null && !obj.getString("group_id").equalsIgnoreCase("")) {
				group_id = obj.getString("group_id");

			}

			if (name != null && mobile != null && group_id != null) {
				utility.addContactToGroup(name, mobile, group_id);
			} else {
				if (name == null) {
					jsonObj.put("message", SmsUtilityConstants.NameCanNotBeNull);
					jsonObj.put("status", false);
					return Response.status(200).entity(jsonObj.toString()).build();

				} else if (mobile == null) {
					jsonObj.put("message", SmsUtilityConstants.MobileCanNotBeNull);
					jsonObj.put("status", false);
					return Response.status(200).entity(jsonObj.toString()).build();

				} else if (group_id == null) {
					jsonObj.put("message", SmsUtilityConstants.GroupNameRequired);
					jsonObj.put("status", false);
					return Response.status(200).entity(jsonObj.toString()).build();

				}

			}
		} else {
			jsonObj.put("message", SmsUtilityConstants.DataIsNull);
			jsonObj.put("status", false);
			return Response.status(200).entity(jsonObj.toString()).build();

		}

		return Response.status(Status.OK).entity(contactDetails).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();

	}

	@Path("/delete_contact")
	@POST
	@Produces("application/json")

	public Response removeContact(String contactId) {
		JSONObject jsonObj = new JSONObject();
		SMSUtility utility = new SMSUtility();
		String cid = null;
		if (contactId != null && !contactId.equalsIgnoreCase("")) {
			cid = contactId;
			utility.removeContact(cid);
		} else {
			jsonObj.put("message", SmsUtilityConstants.ContactIdNotDefine);
			jsonObj.put("status", false);
			return Response.status(200).entity(jsonObj.toString()).build();
		}

		return Response.status(Status.OK).entity(contactId).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
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
		try {
			JSONArray jsonArray = new JSONArray(s);

			for (int i = 0; i < (jsonArray.length() - 1); i++) {
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
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return Response.status(Status.OK).entity(jsonArr.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
	}

	@Path("/list_group/{auth_key}")
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

		return Response.status(Status.OK).entity(s.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
	}

	@Path("/delete_group/{auth_key}/{group_id}")
	@GET
	@Produces("application/json")
	// Delete group

	public Response removeGroup(@PathParam("auth_key") String authKey, @PathParam("group_id") String groupId) {

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
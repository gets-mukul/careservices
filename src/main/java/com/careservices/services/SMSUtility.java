/**
 * 
 */
package com.careservices.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author JARVIS
 *
 */
public class SMSUtility {

	public String KEY = "4210AWhBuxbuCOF592c07c0";
	public String route = "4";
	public String senderId = "SMINSE";

	public void sendSMSToMobiles(String mobileList, String message) {

		URLConnection myURLConnection = null;
		URL myURL = null;
		BufferedReader reader = null;
		String encoded_message = URLEncoder.encode(message);
		String mainUrl = "http://login.yourbulksms.com/api/sendhttp.php?";
		StringBuilder sbPostData = new StringBuilder(mainUrl);
		sbPostData.append("authkey=" + KEY);
		sbPostData.append("&mobiles=" + mobileList);
		sbPostData.append("&message=" + encoded_message);
		sbPostData.append("&route=" + route);
		sbPostData.append("&sender=" + senderId);
		StringBuffer sb = new StringBuffer();
		mainUrl = sbPostData.toString();
		try {
			myURL = new URL(mainUrl);
			myURLConnection = myURL.openConnection();
			myURLConnection.connect();
			reader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
			String response;
			while ((response = reader.readLine()) != null) {
				sb.append(response);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendSMSToGroup(String gids, String message) {
		URLConnection myURLConnection = null;
		URL myURL = null;
		BufferedReader reader = null;
		String encoded_message = URLEncoder.encode(message);
		String mainUrl = "http://login.yourbulksms.com/api/sendhttp.php?";
		StringBuilder sbPostData = new StringBuilder(mainUrl);
		sbPostData.append("authkey=" + KEY);
		sbPostData.append("&message=" + encoded_message);
		sbPostData.append("&sender=" + senderId);
		sbPostData.append("&route=" + route);
		sbPostData.append("&group_id=" + gids);
		StringBuffer sb = new StringBuffer();
		mainUrl = sbPostData.toString();
		try {

			myURL = new URL(mainUrl);
			myURLConnection = myURL.openConnection();
			myURLConnection.connect();
			reader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
			String response;
			while ((response = reader.readLine()) != null) {
				sb.append(response);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String createNewGroup(String groupName) {

		URLConnection myURLConnection = null;
		URL myURL = null;
		BufferedReader reader = null;
		StringBuffer sb = new StringBuffer();
		String mainUrl = "http://login.yourbulksms.com/api/add_group.php?";
		StringBuilder sbPostData = new StringBuilder(mainUrl);
		sbPostData.append("authkey=" + KEY);
		sbPostData.append("&group_name=" + groupName.toUpperCase());
		mainUrl = sbPostData.toString();
		try {
			myURL = new URL(mainUrl);
			myURLConnection = myURL.openConnection();
			myURLConnection.connect();
			reader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
			String response;
			while ((response = reader.readLine()) != null) {
				sb.append(response);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		JSONObject object = new JSONObject(sb.toString());
		String groupId = object.getString("grpId");	
		return groupId;
	}

	public void addContactToGroup(String name, String mobile, String groupId) {

		URLConnection myURLConnection = null;
		URL myURL = null;
		BufferedReader reader = null;
		String mainUrl = "http://login.yourbulksms.com/api/add_contact.php?";
		StringBuilder sbPostData = new StringBuilder(mainUrl);
		sbPostData.append("authkey=" + KEY);
		sbPostData.append("&name=" + name.toUpperCase());
		sbPostData.append("&mob_no=" + mobile);
		sbPostData.append("&group=" + groupId);
		mainUrl = sbPostData.toString();
		try {
			myURL = new URL(mainUrl);
			myURLConnection = myURL.openConnection();
			myURLConnection.connect();
			StringBuffer sb = new StringBuffer();
			reader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
			String response;
			while ((response = reader.readLine()) != null) {
				sb.append(response);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void removeContact(String cid) {

		StringBuffer sb = new StringBuffer();
		URLConnection myURLConnection = null;
		URL myURL = null;
		BufferedReader reader = null;
		String mainUrl = "http://login.yourbulksms.com/api/delete_contact.php?";
		StringBuilder sbPostData = new StringBuilder(mainUrl);
		sbPostData.append("authkey=" + KEY);
		sbPostData.append("&contact_id=" + cid);
		mainUrl = sbPostData.toString();
		try {
			myURL = new URL(mainUrl);
			myURLConnection = myURL.openConnection();
			myURLConnection.connect();
			reader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
			String response;
			while ((response = reader.readLine()) != null) {
				sb.append(response);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void showList(String groupId) {
		
		StringBuffer sb = new StringBuffer();
		String s = null;
		URLConnection myURLConnection = null;
		URL myURL = null;
		BufferedReader reader = null;
		String mainUrl = "http://login.yourbulksms.com/api/list_contact.php?";
		StringBuilder sbPostData = new StringBuilder(mainUrl);
		sbPostData.append("authkey=" + KEY);
		sbPostData.append("&group=" + groupId);
		mainUrl = sbPostData.toString();
		try {
			myURL = new URL(mainUrl);
			myURLConnection = myURL.openConnection();
			myURLConnection.connect();
			reader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
			String response;
			while ((response = reader.readLine()) != null) {
				sb.append(response);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	public void showGroups() {

		StringBuffer sb = new StringBuffer();
		URLConnection myURLConnection = null;
		URL myURL = null;
		BufferedReader reader = null;
		String mainUrl = "http://login.yourbulksms.com/api/list_group.php?";
		StringBuilder sbPostData = new StringBuilder(mainUrl);
		sbPostData.append("authkey=" + KEY);
		mainUrl = sbPostData.toString();
		try {
			myURL = new URL(mainUrl);
			myURLConnection = myURL.openConnection();
			myURLConnection.connect();
			reader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
			String response;
			while ((response = reader.readLine()) != null) {
				sb.append(response);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	public void removeGroup(String groupId) {

		StringBuffer sb = new StringBuffer();
		URLConnection myURLConnection = null;
		URL myURL = null;
		BufferedReader reader = null;
		String mainUrl = "http://login.yourbulksms.com/api/delete_group.php?";
		StringBuilder sbPostData = new StringBuilder(mainUrl);
		sbPostData.append("authkey=" + KEY);
		sbPostData.append("&group_id=" + groupId);
		mainUrl = sbPostData.toString();
		try {
			myURL = new URL(mainUrl);
			myURLConnection = myURL.openConnection();
			myURLConnection.connect();
			reader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
			String response;
			while ((response = reader.readLine()) != null) {
				sb.append(response);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

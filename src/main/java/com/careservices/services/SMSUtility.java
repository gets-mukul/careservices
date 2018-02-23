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
		String[] contactArray = mobileList.split(",");
		String encoded_message = URLEncoder.encode(message);
		String mainUrl = "http://login.yourbulksms.com/api/sendhttp.php?";
		StringBuilder sbPostData = new StringBuilder(mainUrl);
		sbPostData.append("authkey=" + KEY);
		sbPostData.append("&mobiles=" + contactArray);
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

	}

	public void createNewGroup(String groupName) {

		URLConnection myURLConnection = null;
		URL myURL = null;
		BufferedReader reader = null;
		StringBuffer sb = new StringBuffer();
		String mainUrl = "http://login.yourbulksms.com/api/add_group.php?";
		StringBuilder sbPostData = new StringBuilder(mainUrl);
		sbPostData.append("authkey=" + KEY);
		sbPostData.append("&group_name=" + groupName);
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

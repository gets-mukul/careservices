import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * 
 */

/**
 * @author JARVIS
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String authKey = "4210AWhBuxbuCOF592c07c0";
		String groupId = "5a89598685f909f7318b4599";
		String route = "4";
		String senderId = "SMINSE";
		String message = "hello!!! from BULK SMS ";
		String mobiles = "9425465546";
		
		
		
		URLConnection myURLConnection = null;
		URL myURL = null;
		BufferedReader reader = null;

		// encoding message
		String encoded_message = URLEncoder.encode(message);

		// Send SMS API
		String mainUrl = "http://login.yourbulksms.com/api/sendhttp.php?";

		// Prepare parameter string
		StringBuilder sbPostData = new StringBuilder(mainUrl);

		
		 sbPostData.append("authkey="+authKey);
         sbPostData.append("&mobiles="+mobiles);
         sbPostData.append("&message="+encoded_message);
         sbPostData.append("&route="+route);
         sbPostData.append("&sender="+senderId);

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
				

			// finally close connection
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
	}
}

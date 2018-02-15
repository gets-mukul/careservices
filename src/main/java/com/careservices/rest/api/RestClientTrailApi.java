/**
 * 
 */
package com.careservices.rest.api;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.JSONArray;
import org.json.JSONObject;

import com.careservices.dao.CareUser;
import com.careservices.dao.CareUserDAO;
import com.careservices.dao.ClientTrail;
import com.careservices.dao.Contact;
import com.careservices.dao.ContactDAO;
import com.careservices.dao.HibernateSessionFactory;

/**
 * @author JARVIS
 *
 */
@Path("/client")
public class RestClientTrailApi {
	@Path("/trail")
	@POST
	@Produces("application/json")
	public Response getClientDetail(String clientDetail) throws ParseException {

		JSONObject obj = new JSONObject(clientDetail);

		Session session = HibernateSessionFactory.getSession();
		Long mobile = obj.getLong("mobile");
		ContactDAO dao = new ContactDAO();
		List<Contact> c = dao.findByContactNumber(mobile);

		for (Contact contact : c) {
			contact.setContactName("name");
			contact.setContactLocation("location");

			Transaction orgTransaction = null;
			try {
				orgTransaction = session.beginTransaction();
				session.save(c);
				orgTransaction.commit();
			} catch (HibernateException e) {
				e.printStackTrace();
			}

		}

		System.out.println("contact");

		ContactDAO contactDao = new ContactDAO();
		List<Contact> contact = contactDao.findByContactNumber(mobile);
		JSONArray jsonArray = new JSONArray();
		

		for (Contact contact2 : contact) {
			
			ClientTrail ct = new ClientTrail();
			Session session1 = HibernateSessionFactory.getSession();
		

			Integer id = contact2.getId();

			ct.setId(id);
			ct.setStatus(obj.getString("status"));

			String stringDate = obj.getString("trail_start_date");
			DateFormat formatter = null;
			formatter = new SimpleDateFormat("dd/mm/yyyy");
			ct.setTrailStartDate(formatter.parse(stringDate));

			String stringDate1 = obj.getString("trail_end_date");
			DateFormat formatter1 = null;
			formatter1 = new SimpleDateFormat("dd/mm/yyyy");
			ct.setTrailStartDate(formatter1.parse(stringDate1));

			ct.setSecrip(obj.getString("secrip"));
			ct.setLongShort(obj.getString("long_short"));
			ct.setSegment(obj.getString("segment"));

			String stringDate2 = obj.getString("expiry_date");
			DateFormat formatter2 = null;
			formatter2 = new SimpleDateFormat("dd/mm/yyyy");
			ct.setExpityDate(formatter2.parse(stringDate2));

			ct.setStrikePrice(obj.getDouble("strike_price"));
			ct.setLotSizeQty(obj.getInt("lot_size_qty"));
			ct.setBuySell(obj.getLong("buy_sell"));
			ct.setFirstTarget(obj.getInt("first_target"));
			ct.setSecondTarget(obj.getInt("second_target"));
			ct.setStopLoss(obj.getInt("stop_loss"));

			Transaction orgTransaction1 = null;
			try {
				orgTransaction1 = session.beginTransaction();
				session1.save(ct);
				orgTransaction1.commit();
			} catch (HibernateException e) {
				e.printStackTrace();
			}
			System.out.println("Client trial");
			jsonArray.put(ct);
		}
		

		return Response.status(200).entity(jsonArray).build();
	}

}

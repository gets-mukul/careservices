/**
 * 
 */
package com.careservices.rest.api;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.JSONObject;

import com.careservices.dao.ClientTrail;
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
		ClientTrail ct = new ClientTrail();
		
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

		Transaction orgTransaction = null;
		try {
			orgTransaction = session.beginTransaction();
			session.save(ct);
			orgTransaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		System.out.println("completed");

		return Response.status(200).entity(ct.toString()).build();
	}

}

/**
 * 
 */
package com.careservices.rest.api;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.JSONArray;
import org.json.JSONObject;

import com.careservices.dao.HibernateSessionFactory;
import com.careservices.dao.ScripCode;
import com.careservices.dao.Segment;
import com.careservices.dao.SegmentDAO;
import com.careservices.services.SMSUtility;

/**
 * @author Mayank
 *
 */
@Path("/segment")
public class RestSegmentApi {

	@GET
	@Path("/equity")
	@Produces("application/json")
	public Response getEquityScrip() {
		JSONObject jsonObj = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		Segment segment = null;
		for (Segment s : (List<Segment>) new SegmentDAO().findAll()) {
			if (s.getName().equalsIgnoreCase("EQUITY")) {
				segment = s;
				break;
			}
		}
		Session session = HibernateSessionFactory.getSession();
		ArrayList<Segment> childSegment = new ArrayList<>();
		if (segment != null) {
			String hql = "from Segment s where s.parentId=:parentId order by s.name";
			Query query = session.createQuery(hql);
			query.setParameter("parentId", segment.getId());
			List<Segment> childSegmentList = query.list();
			for (Segment s : childSegmentList) {
				childSegment.add(s);
			}
		}

		for (Segment s : childSegment) {
			JSONObject child = new JSONObject();
			child.put("name", s.getName());
			JSONArray children = new JSONArray();
			for (ScripCode code : s.getScripCodes()) {
				JSONObject childrenObject = new JSONObject();
				childrenObject.put("id", code.getId());
				childrenObject.put("name", code.getSymbol().trim().toUpperCase());
				children.put(childrenObject);
			}
			child.put("children", children);
			jsonArray.put(child);
		}

		jsonObj.put("records", jsonArray);
		return Response.status(200).entity(jsonObj.toString()).build();
	}

	@GET
	@Path("/derivative")
	@Produces("application/json")
	public Response getDerivativeScrip() {
		JSONObject jsonObj = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		Segment segment = null;
		for (Segment s : (List<Segment>) new SegmentDAO().findAll()) {
			if (s.getName().equalsIgnoreCase("DERIVATIVE")) {
				segment = s;
				break;
			}
		}
		Session session = HibernateSessionFactory.getSession();
		ArrayList<Segment> childSegment = new ArrayList<>();
		if (segment != null) {
			String hql = "from Segment s where s.parentId=:parentId order by s.name";
			Query query = session.createQuery(hql);
			query.setParameter("parentId", segment.getId());
			List<Segment> childSegmentList = query.list();
			for (Segment s : childSegmentList) {
				childSegment.add(s);
			}
		}

		for (Segment s : childSegment) {
			JSONObject child = new JSONObject();
			child.put("name", s.getName());
			JSONArray children = new JSONArray();
			for (ScripCode code : s.getScripCodes()) {
				JSONObject childrenObject = new JSONObject();
				childrenObject.put("id", code.getId());
				childrenObject.put("name", code.getSymbol().trim().toUpperCase());
				children.put(childrenObject);
			}
			child.put("children", children);
			jsonArray.put(child);
		}

		jsonObj.put("records", jsonArray);
		return Response.status(200).entity(jsonObj.toString()).build();
	}

	@GET
	@Path("/commodity")
	@Produces("application/json")
	public Response getCommodityScrip() {
		JSONObject jsonObj = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		Segment segment = null;
		for (Segment s : (List<Segment>) new SegmentDAO().findAll()) {
			if (s.getName().equalsIgnoreCase("COMMODITY")) {
				segment = s;
				break;
			}
		}
		Session session = HibernateSessionFactory.getSession();
		ArrayList<Segment> childSegment = new ArrayList<>();
		if (segment != null) {
			String hql = "from Segment s where s.parentId=:parentId order by s.name";
			Query query = session.createQuery(hql);
			query.setParameter("parentId", segment.getId());
			List<Segment> childSegmentList = query.list();
			for (Segment s : childSegmentList) {
				childSegment.add(s);
			}
		}

		for (Segment s : childSegment) {
			JSONObject child = new JSONObject();
			child.put("name", s.getName());
			JSONArray children = new JSONArray();
			for (ScripCode code : s.getScripCodes()) {
				JSONObject childrenObject = new JSONObject();
				childrenObject.put("id", code.getId());
				childrenObject.put("name", code.getSymbol().trim().toUpperCase());
				children.put(childrenObject);
			}
			child.put("children", children);
			jsonArray.put(child);
		}

		jsonObj.put("records", jsonArray);
		return Response.status(200).entity(jsonObj.toString()).build();
	}

	@Path("/parent/{parent_id}")
	@GET
	@Produces("application/json")
	public Response showSegmentList(@PathParam("parent_id") Integer parentId) {

		JSONArray jsonArr = new JSONArray();
		JSONObject jsonObj = new JSONObject();
		Session session = HibernateSessionFactory.getSession();

		if (parentId == -1) {

			String hql = "from Segment where parentId=null";
			Query query = session.createQuery(hql);
			List<Segment> parentList = query.list();
			for (Segment segment : parentList) {
				JSONObject jObj = new JSONObject();
				jObj.put("name", segment.getName());
				jObj.put("id", segment.getId());
				jsonArr.put(jObj);
			}

		} else {
			String hql = "from Segment where parentId=:parentId order by name";
			Query query = session.createQuery(hql);
			query.setParameter("parentId", parentId);

			List<Segment> list = query.list();

			for (Segment segment : list) {
				JSONObject jObj = new JSONObject();
				jObj.put("name", segment.getName());
				jObj.put("id", segment.getId());
				jsonArr.put(jObj);
			}
		}
		jsonObj.put("records", jsonArr);

		return Response.status(200).entity(jsonObj.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();

	}

	@Path("/add_segment/{parent_id}/{segment_name}")
	@GET
	@Produces("application/json")
	public Response addNewSegment(@PathParam("parent_id") Integer parentId,
			@PathParam("segment_name") String segmentName) {

		SMSUtility utility = new SMSUtility();

		String groupId = utility.createNewGroup(segmentName.toUpperCase());

		Session session = HibernateSessionFactory.getSession();

		Segment segmentObj = new Segment();

		JSONObject jsonObj = new JSONObject();

		if (parentId == -1) {
			parentId = null;
		}

		segmentObj.setName(segmentName.toUpperCase());
		segmentObj.setParentId(parentId);
		segmentObj.setGroupId(groupId);
		Transaction orgTransaction = null;
		try {
			orgTransaction = session.beginTransaction();
			session.save(segmentObj);
			orgTransaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		jsonObj.put("name", segmentName.toUpperCase());
		jsonObj.put("parent_id", parentId);
		jsonObj.put("group_id", groupId);
		return Response.status(Status.OK).entity(jsonObj.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
	}

	@Path("/remove_segment/{segment_id}")
	@GET
	@Produces("application/json")
	public Response removeSegment(@PathParam("segment_id") Integer segmentId) {
		
		Session groupSession = HibernateSessionFactory.getSession();
		SMSUtility utility = new SMSUtility();

		String hql = "from Segment where id=:id or parent_id=:id";
		Query query = groupSession.createQuery(hql);
		query.setParameter("id", segmentId);
		
		List<Segment> list = query.list();  
			
		for (Segment segment : list) {
			utility.removeGroup(segment.getGroupId());
		}
		
		
		JSONObject jsonObj = new JSONObject();
		Session childSession = HibernateSessionFactory.getSession();
		Session parentSession = HibernateSessionFactory.getSession();
		hql = "delete Segment where parent_id=:id";
		query = childSession.createQuery(hql);
		query.setParameter("id", segmentId);
		Integer childRow = query.executeUpdate();
		Transaction orgTransaction = null;
		try {
			orgTransaction = childSession.beginTransaction();
			childSession.getTransaction();
			orgTransaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		hql = "delete Segment where id=:id";
		query = parentSession.createQuery(hql);
		query.setParameter("id", segmentId);
		Integer parentRow = query.executeUpdate();
		Transaction parentTransaction = null;
		try {
			parentTransaction = parentSession.beginTransaction();
			parentSession.getTransaction();
			parentTransaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		jsonObj.put("no_of_row_deleted", childRow + parentRow);
		jsonObj.put("status", true);

		return Response.status(Status.OK).entity(jsonObj.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
	}
}

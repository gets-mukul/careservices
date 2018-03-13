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
	@Path("/commodity")
	@Produces("application/json")
	public Response getCommoditySegmentValue() {
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
			String hql = "from Segment s where s.parentId=:parentId order by s.name";
			Query query = session.createQuery(hql);
			query.setParameter("parentId", s.getId());
			List<Segment> childSegmentList = query.list();
			for (Segment grandChild : childSegmentList) {
				JSONObject childrenObject = new JSONObject();
				childrenObject.put("id", grandChild.getId());
				childrenObject.put("name", grandChild.getName());
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
	public Response addNewSegment(@PathParam("parent_id") Integer parentId, @PathParam("segment_name") String segmentName){
		
		Session session = HibernateSessionFactory.getSession();
		SMSUtility utility = new SMSUtility();
		Segment segmentObj = new Segment();
		JSONObject jsonObj = new JSONObject();
		if(parentId==-1) {
			parentId=null;
		}
		
		segmentObj.setName(segmentName.toUpperCase());
		segmentObj.setParentId(parentId);
		Transaction orgTransaction = null;
		try {
			orgTransaction = session.beginTransaction();
			session.save(segmentObj);
			orgTransaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		String groupId = utility.createNewGroup(segmentName.toUpperCase());
		System.out.println(groupId);
		jsonObj.put("name", segmentName.toUpperCase());
		jsonObj.put("parent_id", parentId);
		return Response.status(Status.OK).entity(jsonObj.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
	}
	
	@Path("/remove_segment/{segment_id}")
	@GET
	@Produces("application/json")
	public Response removeSegment(@PathParam("segment_id") Integer segmentId) {
		JSONObject jsonObj = new JSONObject();
		Session childSession = HibernateSessionFactory.getSession();
		Session parentSession = HibernateSessionFactory.getSession();
		String hql = "delete Segment where parent_id=:id";
		Query query = childSession.createQuery(hql);
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
		
		
		jsonObj.put("no_of_row_deleted", childRow+parentRow );
		jsonObj.put("status", true);
		
		return Response.status(Status.OK).entity(jsonObj.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
	}
}

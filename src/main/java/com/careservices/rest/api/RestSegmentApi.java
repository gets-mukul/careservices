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

import org.hibernate.Query;
import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONObject;

import com.careservices.dao.HibernateSessionFactory;
import com.careservices.dao.Segment;
import com.careservices.dao.SegmentDAO;

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
		for(Segment s : (List<Segment>)new SegmentDAO().findAll())
		{
			if(s.getName().equalsIgnoreCase("COMMODITY"))
			{
				segment = s;
				break;
			}	
		}
		Session session = HibernateSessionFactory.getSession();
		ArrayList<Segment>childSegment = new ArrayList<>();
		if(segment!=null)
		{
			String hql ="from Segment s where s.parentId=:parentId order by s.name";
			Query query = session.createQuery(hql);
			query.setParameter("parentId", segment.getId());
			List<Segment>childSegmentList = query.list();
			for(Segment s : childSegmentList)
			{
				childSegment.add(s);
			}			
		}
		
		
		for(Segment s : childSegment)
		{
			JSONObject child = new JSONObject();
			child.put("name", s.getName());
			JSONArray children = new JSONArray();
			String hql ="from Segment s where s.parentId=:parentId order by s.name";
			Query query = session.createQuery(hql);
			query.setParameter("parentId", s.getId());
			List<Segment>childSegmentList = query.list();
			for(Segment grandChild : childSegmentList)
			{
				JSONObject childrenObject = new JSONObject();
				childrenObject.put("id", grandChild.getId());
				childrenObject.put("name", grandChild.getName());
				children.put(childrenObject);
			}
			child.put("children",children);
			jsonArray.put(child);
		}
		
		jsonObj.put("records", jsonArray);
		return Response.status(200).entity(jsonObj.toString()).build();
	}
}

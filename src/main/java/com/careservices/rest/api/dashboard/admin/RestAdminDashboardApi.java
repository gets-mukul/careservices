/**
 * 
 */
package com.careservices.rest.api.dashboard.admin;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.hibernate.Query;
import org.json.JSONArray;
import org.json.JSONObject;

import com.careservices.constants.CareUserTypes;
import com.careservices.constants.TaskStatusConstants;
import com.careservices.dao.CareUser;
import com.careservices.dao.CareUserDAO;
import com.careservices.dao.EmployeeTask;
import com.careservices.dao.EmployeeTaskDAO;
import com.careservices.dao.HibernateSessionFactory;

/**
 * @author JARVIS
 *
 */
@Path("/dashboard/admin")
public class RestAdminDashboardApi {

	@Path("/stats")
	@GET
	@Produces("application/json")
	public Response getStatsCardForAdmin()
	{
		Integer assignedTasks =0;
		Integer completedTasks = 0;
		Integer pendingTasks =0;
		Integer onTrialTasks =0;
		Integer notTrade = 0;
		Integer others = 0;
		List<EmployeeTask> tasks = new EmployeeTaskDAO().findAll();
		assignedTasks = tasks.size();
		for(EmployeeTask t : tasks)
		{
			if(!t.getStatus().equalsIgnoreCase(TaskStatusConstants.INCOMPLETE))
			{
				completedTasks++;
				if(t.getStatus().equalsIgnoreCase(TaskStatusConstants.TRIAL))
				{
					onTrialTasks++;
				}
				else if(t.getStatus().equalsIgnoreCase(TaskStatusConstants.NOT_TRADE))
				{
					notTrade++;
				}
				else {
					others++;
				}
			}
			
		}
		pendingTasks = assignedTasks-completedTasks;
		JSONObject obj = new JSONObject();
		obj.put("ASSIGNED",assignedTasks);
		obj.put("COMPLETED",completedTasks);
		obj.put("PENDING",pendingTasks);
		obj.put("TRIAL",onTrialTasks);
		obj.put("NOT_TRADE",notTrade);
		obj.put("OTHERS",others);		
		return Response.status(200).entity(obj.toString()).build();
	}
	
	
	@Path("/contact_summary_report/{start_date}/{end_date}/{employee_ids}")
	@GET
	@Produces("application/json")
	public Response getContactSummaryReport(@PathParam("start_date") String startDate, @PathParam("end_date") String endDate, 
			@PathParam("employee_ids")String userIds)
	{
		String hql =""
				+ "select  care_user.id , "
				+ "care_user.name, "
				+ "cast (count(employee_task.id) as integer) as assigned, "
				+ "cast (COUNT(CASE WHEN employee_task.status !='INCOMPLETE' THEN 1 END)as integer) AS completed, "
				+ "cast (count(employee_task.id)- COUNT(CASE WHEN employee_task.status !='INCOMPLETE' THEN 1 END) as integer) AS pending, "
				+ "cast (COUNT(CASE WHEN employee_task.status ='TRIAL' THEN 1 END)as integer) AS trial, "
				+ "cast (COUNT(CASE WHEN employee_task.status ='NOT_TRADE' THEN 1 END) as integer) AS not_trade, "
				+ "cast (COUNT(CASE WHEN employee_task.status not in ('TRIAL','INCOMPLETE','NOT_TRADE') THEN 1 END)as integer) AS others "
				+ "from "
				+ "care_user "
				+ "left JOIN employee_task ON (care_user.id = employee_task.user_id) ";
		
		
		if(startDate!=null || endDate!=null || userIds!=null)
		{
			hql+= " where";
			boolean prevFound = false;
			if(startDate!=null)
			{
				
				if(prevFound)
				{
					hql+=" and";
					
				}
				hql+="  employee_task.created_at >=cast ('"+startDate+"' as timestamp)";
				prevFound=true;
			}
			if(endDate!=null)
			{
				
				if(prevFound)
				{
					hql+=" and";
					
				}
				hql+="  employee_task.created_at <="+endDate;
				prevFound=true;
			}
			if(userIds!=null)
			{
				if(prevFound)
				{
					hql+=" and";
					
				}
				hql+=" and care_user.id in ("+userIds+")";
				prevFound=true;
			}
		}
		
		
		hql+= " group by care_user.id , care_user.name "
				+ "order by care_user.name";
		System.out.println(hql);
		//sql not hql
		Query q = HibernateSessionFactory.getSession().createSQLQuery(hql);
		
		return null;
	}
	
	@Path("/employee_list")
	@GET
	public Response getEmployeeList()
	{
		StringBuffer sb = new StringBuffer();
		String hql ="from CareUser u order by u.name";
		Query q = HibernateSessionFactory.getSession().createQuery(hql);
		for(CareUser user : (List<CareUser>)q.list())
		{
			if(user.getUserType().equalsIgnoreCase(CareUserTypes.employee)|| user.getUserType().equalsIgnoreCase(CareUserTypes.admin))
			{
				String option ="<option value='"+user.getId()+"'>"+user.getName()+"</option>";
				sb.append(option);
			}
		}	
		return Response.status(200).entity(sb.toString()).build();
	}
	
}

package com.careservices.rest.api.dashboard.employee;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("dashboard/employee/")
public class RestEmployeeDashboardApi {

	@Path("/upcoming_events/{employee_id}")
	@GET
	@Produces("application/json")
	public Response getUpcomingEventsForEmployee()
	{
		//find all the trials having date as current date and next day date and status ='TRIAL'
		
		return null;
	}
}

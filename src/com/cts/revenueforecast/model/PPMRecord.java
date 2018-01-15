package com.cts.revenueforecast.model;

import java.util.List;
import java.util.Map;

public class PPMRecord {
	private String project_id, task, time_period, resource_name, resource_id, resource_manager, timesheet_status, timesheet_hours, senior_executive,email;
	Map<String,String> timePeriodMap;
	public String getProject_id() {
		return project_id;
	}

	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getTime_period() {
		return time_period;
	}

	public void setTime_period(String time_period) {
		this.time_period = time_period;
	}

	public String getResource_name() {
		return resource_name;
	}

	public void setResource_name(String resource_name) {
		this.resource_name = resource_name;
	}

	public String getResource_id() {
		return resource_id;
	}

	public void setResource_id(String resource_id) {
		this.resource_id = resource_id;
	}

	public String getResource_manager() {
		return resource_manager;
	}

	public void setResource_manager(String resource_manager) {
		this.resource_manager = resource_manager;
	}

	public String getTimesheet_status() {
		return timesheet_status;
	}

	public void setTimesheet_status(String timesheet_status) {
		this.timesheet_status = timesheet_status;
	}

	public String getTimesheet_hours() {
		return timesheet_hours;
	}

	public void setTimesheet_hours(String timesheet_hours) {
		this.timesheet_hours = timesheet_hours;
	}

	public String getSenior_executive() {
		return senior_executive;
	}

	public void setSenior_executive(String senior_executive) {
		this.senior_executive = senior_executive;
	}

	public PPMRecord(String project_id, String task, String time_period, String resource_name, String resource_id,
			String resource_manager, String timesheet_status, String timesheet_hours, String senior_executive,String email) {
		super();
		this.project_id = project_id;
		this.task = task;
		this.time_period = time_period;
		this.resource_name = resource_name;
		this.resource_id = resource_id;
		this.resource_manager = resource_manager;
		this.timesheet_status = timesheet_status;
		this.timesheet_hours = timesheet_hours;
		this.senior_executive = senior_executive;
		this.email = email;
	}

	public PPMRecord() {
		super();
	}

	public Object[] getObjectAsArray() {
		// TODO Auto-generated method stub
		return new Object[]{project_id, task, time_period, resource_name, resource_id, resource_manager, timesheet_status, timesheet_hours, senior_executive,email};
	}
	
	public PPMRecord(List<String> values){
		this.project_id = values.get(0);
		this.task = values.get(1);
		this.time_period = values.get(2);
		this.resource_name = values.get(3);
		this.resource_id = values.get(4);
		this.resource_manager = values.get(5);
		this.timesheet_status = values.get(6);
		this.timesheet_hours = values.get(7);
		this.senior_executive = values.get(8);
		this.email = values.get(9);
	}

	public Map<String, String> getTimePeriodMap() {
		return timePeriodMap;
	}

	public void setTimePeriodMap(Map<String, String> timePeriodMap) {
		this.timePeriodMap = timePeriodMap;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
}

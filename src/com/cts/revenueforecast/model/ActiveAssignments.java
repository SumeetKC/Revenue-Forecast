package com.cts.revenueforecast.model;

import java.util.List;

public class ActiveAssignments {
	private String work_assignment_id, employee_id, name, department, project, description, pm_id, pm_name, customer_id,
			customer_name, customer_vertical, customer_sub_vertical, sub_vertical_description, start_date, end_date,
			project_role, operational_role, department_description, department_practice, practice_description,
			location_code, city, country, associate_billability, employee_status, organizantional_relationship,
			assignment_percent, total_assignment_percent, allocation_status, critical_resource, status;

	public ActiveAssignments() {
		super();
	}

	public ActiveAssignments(String work_assignment_id, String employee_id, String name, String department,
			String project, String description, String pm_id, String pm_name, String customer_id, String customer_name,
			String customer_vertical, String customer_sub_vertical, String sub_vertical_description, String start_date,
			String end_date, String project_role, String operational_role, String department_description,
			String department_practice, String practice_description, String location_code, String city, String country,
			String associate_billability, String employee_status, String organizantional_relationship,
			String assignment_percent, String total_assignment_percent, String allocation_status,
			String critical_resource, String status) {
		super();
		this.work_assignment_id = work_assignment_id;
		this.employee_id = employee_id;
		this.name = name;
		this.department = department;
		this.project = project;
		this.description = description;
		this.pm_id = pm_id;
		this.pm_name = pm_name;
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.customer_vertical = customer_vertical;
		this.customer_sub_vertical = customer_sub_vertical;
		this.sub_vertical_description = sub_vertical_description;
		this.start_date = start_date;
		this.end_date = end_date;
		this.project_role = project_role;
		this.operational_role = operational_role;
		this.department_description = department_description;
		this.department_practice = department_practice;
		this.practice_description = practice_description;
		this.location_code = location_code;
		this.city = city;
		this.country = country;
		this.associate_billability = associate_billability;
		this.employee_status = employee_status;
		this.organizantional_relationship = organizantional_relationship;
		this.assignment_percent = assignment_percent;
		this.total_assignment_percent = total_assignment_percent;
		this.allocation_status = allocation_status;
		this.critical_resource = critical_resource;
		this.status = status;
	}

	public String getWork_assignment_id() {
		return work_assignment_id;
	}

	public void setWork_assignment_id(String work_assignment_id) {
		this.work_assignment_id = work_assignment_id;
	}

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPm_id() {
		return pm_id;
	}

	public void setPm_id(String pm_id) {
		this.pm_id = pm_id;
	}

	public String getPm_name() {
		return pm_name;
	}

	public void setPm_name(String pm_name) {
		this.pm_name = pm_name;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_vertical() {
		return customer_vertical;
	}

	public void setCustomer_vertical(String customer_vertical) {
		this.customer_vertical = customer_vertical;
	}

	public String getCustomer_sub_vertical() {
		return customer_sub_vertical;
	}

	public void setCustomer_sub_vertical(String customer_sub_vertical) {
		this.customer_sub_vertical = customer_sub_vertical;
	}

	public String getSub_vertical_description() {
		return sub_vertical_description;
	}

	public void setSub_vertical_description(String sub_vertical_description) {
		this.sub_vertical_description = sub_vertical_description;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getProject_role() {
		return project_role;
	}

	public void setProject_role(String project_role) {
		this.project_role = project_role;
	}

	public String getOperational_role() {
		return operational_role;
	}

	public void setOperational_role(String operational_role) {
		this.operational_role = operational_role;
	}

	public String getDepartment_description() {
		return department_description;
	}

	public void setDepartment_description(String department_description) {
		this.department_description = department_description;
	}

	public String getDepartment_practice() {
		return department_practice;
	}

	public void setDepartment_practice(String department_practice) {
		this.department_practice = department_practice;
	}

	public String getPractice_description() {
		return practice_description;
	}

	public void setPractice_description(String practice_description) {
		this.practice_description = practice_description;
	}

	public String getLocation_code() {
		return location_code;
	}

	public void setLocation_code(String location_code) {
		this.location_code = location_code;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAssociate_billability() {
		return associate_billability;
	}

	public void setAssociate_billability(String associate_billability) {
		this.associate_billability = associate_billability;
	}

	public String getEmployee_status() {
		return employee_status;
	}

	public void setEmployee_status(String employee_status) {
		this.employee_status = employee_status;
	}

	public String getOrganizantional_relationship() {
		return organizantional_relationship;
	}

	public void setOrganizantional_relationship(String organizantional_relationship) {
		this.organizantional_relationship = organizantional_relationship;
	}

	public String getAssignment_percent() {
		return assignment_percent;
	}

	public void setAssignment_percent(String assignment_percent) {
		this.assignment_percent = assignment_percent;
	}

	public String getTotal_assignment_percent() {
		return total_assignment_percent;
	}

	public void setTotal_assignment_percent(String total_assignment_percent) {
		this.total_assignment_percent = total_assignment_percent;
	}

	public String getAllocation_status() {
		return allocation_status;
	}

	public void setAllocation_status(String allocation_status) {
		this.allocation_status = allocation_status;
	}

	public String getCritical_resource() {
		return critical_resource;
	}

	public void setCritical_resource(String critical_resource) {
		this.critical_resource = critical_resource;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object[] getObjectArray() {
		return new Object[] { work_assignment_id, employee_id, name, department, project, description, pm_id, pm_name,
				customer_id, customer_name, customer_vertical, customer_sub_vertical, sub_vertical_description,
				start_date, end_date, project_role, operational_role, department_description, department_practice,
				practice_description, location_code, city, country, associate_billability, employee_status,
				organizantional_relationship, assignment_percent, total_assignment_percent, allocation_status,
				critical_resource, status };
	}

	public ActiveAssignments(List<String> vl) {
		this.work_assignment_id = vl.get(0);
		this.employee_id = vl.get(1);
		this.name = vl.get(2);
		this.department = vl.get(3);
		this.project = vl.get(4);
		this.description = vl.get(5);
		this.pm_id = vl.get(6);
		this.pm_name = vl.get(7);
		this.customer_id = vl.get(8);
		this.customer_name = vl.get(9);
		this.customer_vertical = vl.get(10);
		this.customer_sub_vertical = vl.get(11);
		this.sub_vertical_description = vl.get(12);
		this.start_date = vl.get(13);
		this.end_date = vl.get(14);
		this.project_role = vl.get(15);
		this.operational_role = vl.get(16);
		this.department_description = vl.get(17);
		this.department_practice = vl.get(18);
		this.practice_description = vl.get(19);
		this.location_code = vl.get(20);
		this.city = vl.get(21);
		this.country = vl.get(22);
		this.associate_billability = vl.get(23);
		this.employee_status = vl.get(24);
		this.organizantional_relationship = vl.get(25);
		this.assignment_percent = vl.get(26);
		this.total_assignment_percent = vl.get(27);
		this.allocation_status = vl.get(28);
		this.critical_resource = vl.get(29);
		this.status = vl.get(30);
	}

}

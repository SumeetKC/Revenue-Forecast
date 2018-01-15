package com.cts.revenueforecast.model;

public class User {

	private Integer user_id;
	private String password, first_name, last_name, mobile_number, location, role, approval_status;

	public User() {

	}

	public User(Integer user_id, String password, String first_name, String last_name, String mobile_number,
			String location, String role, String approval_status) {
		super();
		this.user_id = user_id;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.mobile_number = mobile_number;
		this.location = location;
		this.role = role;
		this.approval_status = approval_status;
	}

	public String getApproval_status() {
		return approval_status;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public String getLocation() {
		return location;
	}

	public String getMobile_number() {
		return mobile_number;
	}

	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setApproval_status(String approval_status) {
		this.approval_status = approval_status;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

}

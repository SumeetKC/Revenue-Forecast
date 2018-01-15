package com.cts.revenueforecast.model;

import java.util.Map;

public class Base {

	private String work_assignment_id, employee_id, name, project, description, pm_id, pm_name, city, // ProjectId_EmpId,city,
			country, associate_billability, AM, Billing_in, ce_id, contractor_number, Current_Bill_Rate_ST_Hr, pto_jan,
			pto_feb, pto_mar, pto_apr, pto_may, pto_june, pto_july, pto_aug, pto_sept, pto_oct, pto_nov, pto_dec,
			total_pto, Onsite_Offshore, billing_hours_per_day, date_stamp, status, allocation_end_date;

	public String getAllocation_end_date() {
		return allocation_end_date;
	}

	public void setAllocation_end_date(String allocation_end_date) {
		this.allocation_end_date = allocation_end_date;
	}

	String sow;
	String sowNumber;
	String workerStartDate, workerEndDate;
	Map<String, String> timePeriodMap;
	boolean checked;
	String email;
	String truefalse;

	String sowEndDate, sowBillRate, practice_name, last_updated_by, enddatebypm;

	public String getEnddatebypm() {
		return enddatebypm;
	}

	public void setEnddatebypm(String enddatebypm) {
		this.enddatebypm = enddatebypm;
	}

	public String getLast_updated_by() {
		return last_updated_by;
	}

	public void setLast_updated_by(String last_updated_by) {
		this.last_updated_by = last_updated_by;
	}

	public String getPractice_name() {
		return practice_name;
	}

	public void setPractice_name(String practice_name) {
		this.practice_name = practice_name;
	}

	public String getSowEndDate() {
		return sowEndDate;
	}

	public void setSowEndDate(String sowEndDate) {
		this.sowEndDate = sowEndDate;
	}

	public String getSowBillRate() {
		return sowBillRate;
	}

	public void setSowBillRate(String sowBillRate) {
		this.sowBillRate = sowBillRate;
	}

	public String getTruefalse() {
		return truefalse;
	}

	public void setTruefalse(String truefalse) {
		this.truefalse = truefalse;
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

	public String getAM() {
		return AM;
	}

	public void setAM(String aM) {
		AM = aM;
	}

	public String getTotal_pto() {
		return total_pto;
	}

	public void setTotal_pto(String total_pto) {
		this.total_pto = total_pto;
	}

	public String getBilling_in() {
		return Billing_in;
	}

	public void setBilling_in(String billing_in) {
		Billing_in = billing_in;
	}

	public String getCe_id() {
		return ce_id;
	}

	public void setCe_id(String ce_id) {
		this.ce_id = ce_id;
	}

	public String getContractor_number() {
		return contractor_number;
	}

	public void setContractor_number(String contractor_number) {
		this.contractor_number = contractor_number;
	}

	public String getCurrent_Bill_Rate_ST_Hr() {
		return Current_Bill_Rate_ST_Hr;
	}

	public void setCurrent_Bill_Rate_ST_Hr(String current_Bill_Rate_ST_Hr) {
		Current_Bill_Rate_ST_Hr = current_Bill_Rate_ST_Hr;
	}

	public String getPto_jan() {
		return pto_jan;
	}

	public void setPto_jan(String pto_jan) {
		this.pto_jan = pto_jan;
	}

	public String getPto_feb() {
		return pto_feb;
	}

	public void setPto_feb(String pto_feb) {
		this.pto_feb = pto_feb;
	}

	public String getPto_mar() {
		return pto_mar;
	}

	public void setPto_mar(String pto_mar) {
		this.pto_mar = pto_mar;
	}

	public String getPto_apr() {
		return pto_apr;
	}

	public void setPto_apr(String pto_apr) {
		this.pto_apr = pto_apr;
	}

	public String getPto_may() {
		return pto_may;
	}

	public void setPto_may(String pto_may) {
		this.pto_may = pto_may;
	}

	public String getPto_june() {
		return pto_june;
	}

	public void setPto_june(String pto_june) {
		this.pto_june = pto_june;
	}

	public String getPto_july() {
		return pto_july;
	}

	public void setPto_july(String pto_july) {
		this.pto_july = pto_july;
	}

	public String getPto_aug() {
		return pto_aug;
	}

	public void setPto_aug(String pto_aug) {
		this.pto_aug = pto_aug;
	}

	public String getPto_sept() {
		return pto_sept;
	}

	public void setPto_sept(String pto_sept) {
		this.pto_sept = pto_sept;
	}

	public String getPto_oct() {
		return pto_oct;
	}

	public void setPto_oct(String pto_oct) {
		this.pto_oct = pto_oct;
	}

	public String getPto_nov() {
		return pto_nov;
	}

	public void setPto_nov(String pto_nov) {
		this.pto_nov = pto_nov;
	}

	public String getPto_dec() {
		return pto_dec;
	}

	public void setPto_dec(String pto_dec) {
		this.pto_dec = pto_dec;
	}

	public String getOnsite_Offshore() {
		return Onsite_Offshore;
	}

	public void setOnsite_Offshore(String onsite_Offshore) {
		Onsite_Offshore = onsite_Offshore;
	}

	public String getBilling_hours_per_day() {
		return billing_hours_per_day;
	}

	public void setBilling_hours_per_day(String billing_hours_per_day) {
		this.billing_hours_per_day = billing_hours_per_day;
	}

	public String getDate_stamp() {
		return date_stamp;
	}

	public void setDate_stamp(String date_stamp) {
		this.date_stamp = date_stamp;
	}

	/*
	 * public String getProjectId_EmpId() { return ProjectId_EmpId; }
	 * 
	 * public void setProjectId_EmpId(String projectId_EmpId) { ProjectId_EmpId
	 * = projectId_EmpId; }
	 */

	public Base() {
		super();
	}

	public Base(String work_assignment_id, String truefalse, String employee_id, String name, String project,
			String description, String pm_id, String pm_name, String city, String country, String associate_billability,
			String aM, String soW, String sowNumber, String billing_in, String ce_id, String contractor_number,
			String workerStartDate, String workerEndDate, String current_Bill_Rate_ST_Hr, String pto_jan,
			String pto_feb, String pto_mar, String pto_apr, String pto_may, String pto_june, String pto_july,
			String pto_aug, String pto_sept, String pto_oct, String pto_nov, String pto_dec, String total_pTO,
			String onsite_Offshore, String billing_hours_per_day, String date_stamp, String status, String email,
			String sowEndDate, String sowBillRate, String practice_name, String last_updated_by, String enddatebypm,
			String allocation_end_date) {
		super();
		this.work_assignment_id = work_assignment_id;
		this.allocation_end_date = allocation_end_date;
		this.practice_name = practice_name;
		this.last_updated_by = last_updated_by;
		this.employee_id = employee_id;
		this.name = name;
		this.project = project;
		this.description = description;
		this.pm_id = pm_id;
		this.pm_name = pm_name;
		this.city = city;
		this.country = country;
		this.associate_billability = associate_billability;
		this.AM = aM;
		this.sow = soW;
		this.sowNumber = sowNumber;
		this.Billing_in = billing_in;
		this.ce_id = ce_id;
		this.contractor_number = contractor_number;
		this.workerStartDate = workerStartDate;
		this.workerEndDate = workerEndDate;
		Current_Bill_Rate_ST_Hr = current_Bill_Rate_ST_Hr;
		this.pto_jan = pto_jan;
		this.pto_feb = pto_feb;
		this.pto_mar = pto_mar;
		this.pto_apr = pto_apr;
		this.pto_may = pto_may;
		this.pto_june = pto_june;
		this.pto_july = pto_july;
		this.pto_aug = pto_aug;
		this.pto_sept = pto_sept;
		this.pto_oct = pto_oct;
		this.pto_nov = pto_nov;
		this.pto_dec = pto_dec;
		this.total_pto = total_pTO;
		Onsite_Offshore = onsite_Offshore;
		this.billing_hours_per_day = billing_hours_per_day;
		this.date_stamp = date_stamp;
		this.status = status;
		this.truefalse = truefalse;
		this.sowBillRate = sowBillRate;
		this.sowEndDate = sowEndDate;
		this.email = email;
		this.enddatebypm = enddatebypm;
	}

	@Override
	public String toString() {
		return work_assignment_id + " " + workerStartDate + " " + workerEndDate;
	}

	public Object[] getAsObjectArray() {
		return new Object[] { work_assignment_id, truefalse, employee_id, name, project, description, pm_id, pm_name, // ProjectId_EmpId,
				city, country, associate_billability, AM, sow, sowNumber, Billing_in, ce_id, contractor_number,
				workerStartDate, workerEndDate, Current_Bill_Rate_ST_Hr, pto_jan, pto_feb, pto_mar, pto_apr, pto_may,
				pto_june, pto_july, pto_aug, pto_sept, pto_oct, pto_nov, pto_dec, total_pto, Onsite_Offshore,
				billing_hours_per_day, date_stamp, status, email, sowEndDate, sowBillRate };
	}

	// Using for downloading Base Excel
	public Object[] getAsObjectArrayBase() {
		return new Object[] { description, project, employee_id, Onsite_Offshore, name, practice_name, city,
				workerStartDate, workerEndDate, Current_Bill_Rate_ST_Hr, sow, sowNumber, pto_jan, pto_feb, pto_mar,
				pto_apr, pto_may, pto_june, pto_july, pto_aug, pto_sept, pto_oct, pto_nov, pto_dec, date_stamp, ce_id,
				AM, pm_name };
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSow() {
		return sow;
	}

	public void setSow(String sow) {
		this.sow = sow;
	}

	public String getSowNumber() {
		return sowNumber;
	}

	public void setSowNumber(String sowNumber) {
		this.sowNumber = sowNumber;
	}

	public String getWorkerStartDate() {
		return workerStartDate;
	}

	public void setWorkerStartDate(String workerStartDate) {
		this.workerStartDate = workerStartDate;
	}

	public String getWorkerEndDate() {
		return workerEndDate;
	}

	public void setWorkerEndDate(String workerEndDate) {
		this.workerEndDate = workerEndDate;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
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

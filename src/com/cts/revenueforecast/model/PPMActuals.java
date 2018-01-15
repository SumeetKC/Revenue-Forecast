package com.cts.revenueforecast.model;

public class PPMActuals {

	String description,project,employee_id, onsite_offshore,name,am, ce_id,pm_id,pm_name, ppmactuals,current_Bill_Rate_ST_Hr,workerStartDate,workerEndDate,sow,sowNumber, enddatebypm,ratebypm,ppmhoursbypm;
	private String pmid,pms;

	public String getPms() {
		return pms;
	}

	public void setPms(String pms) {
		this.pms = pms;
	}

	public String getCurrent_Bill_Rate_ST_Hr() {
		return current_Bill_Rate_ST_Hr;
	}

	public void setCurrent_Bill_Rate_ST_Hr(String current_Bill_Rate_ST_Hr) {
		this.current_Bill_Rate_ST_Hr = current_Bill_Rate_ST_Hr;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getOnsite_offshore() {
		return onsite_offshore;
	}

	public void setOnsite_offshore(String onsite_offshore) {
		this.onsite_offshore = onsite_offshore;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAm() {
		return am;
	}

	public void setAm(String am) {
		this.am = am;
	}

	public String getCe_id() {
		return ce_id;
	}

	public void setCe_id(String ce_id) {
		this.ce_id = ce_id;
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

	public String getPpmactuals() {
		return ppmactuals;
	}

	public void setPpmactuals(String ppmactuals) {
		this.ppmactuals = ppmactuals;
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

	

	public String getEnddatebypm() {
		return enddatebypm;
	}

	public void setEnddatebypm(String enddatebypm) {
		this.enddatebypm = enddatebypm;
	}

	public String getRatebypm() {
		return ratebypm;
	}

	public void setRatebypm(String ratebypm) {
		this.ratebypm = ratebypm;
	}

	public String getPpmhoursbypm() {
		return ppmhoursbypm;
	}

	public void setPpmhoursbypm(String ppmhoursbypm) {
		this.ppmhoursbypm = ppmhoursbypm;
	}

	public Object[] getAsObjectArray() {
		// TODO Auto-generated method stub
		return new Object[]{description,project,employee_id, onsite_offshore,name,am, ce_id,pm_id,pm_name,workerStartDate,workerEndDate,enddatebypm,sow,sowNumber, current_Bill_Rate_ST_Hr,ratebypm,ppmactuals,ppmhoursbypm};
	}

	public String getPmid() {
		return pmid;
	}

	public void setPmid(String pmid) {
		this.pmid = pmid;
	}

	/*@Override
	public String toString() {
		
		return enddatebypm+" "+ratebypm+" "+ppmhoursbypm;
		
	}*/
	
	


}

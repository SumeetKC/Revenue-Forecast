package com.cts.revenueforecast.model;

public class Active {

	private String work_assignment_id, employee_id, name, project, description, pm_id, pm_name, ProjectId_EmpId,city,
	country, associate_billability, AM, sow, sowNumber, Billing_in, ce_id, contractor_number,
	workerStartDate, workerEndDate, Current_Bill_Rate_ST_Hr, pto_jan, pto_feb, pto_mar, pto_apr, pto_may,
	pto_june, pto_july, pto_aug, pto_sept, pto_oct, pto_nov, pto_dec, total_pto, Onsite_Offshore,
	billing_hours_per_day, date_stamp;
	
	private String revJan,revFeb,revMar,revApr,revMay,revJun,revJul,revAug,revSep,revOct,revNov,revDec,totRev;
	private String effort_Jan,effort_Feb,effort_Mar,effort_Apr,effort_May,effort_Jun,effort_Jul,effort_Aug,effort_Sep,effort_Oct,effort_Nov,effort_Dec,tot_effort;
	private String act_revJan,act_revFeb,act_revMar,act_revApr,act_revMay,act_revJun,act_revJul,act_revAug,act_revSep,act_revOct,act_revNov,act_revDec,act_totRev;
	private String act_effort_Jan,act_effort_Feb,act_effort_Mar,act_effort_Apr,act_effort_May,act_effort_Jun,act_effort_Jul,act_effort_Aug,act_effort_Sep,act_effort_Oct,act_effort_Nov,act_effort_Dec,act_tot_effort;
	
	private String sowEndDate,sowBillRate;
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
	public String getProjectId_EmpId() {
		return ProjectId_EmpId;
	}
	public void setProjectId_EmpId(String projectId_EmpId) {
		ProjectId_EmpId = projectId_EmpId;
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
	public String getTotal_pto() {
		return total_pto;
	}
	public void setTotal_pto(String total_pto) {
		this.total_pto = total_pto;
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
	public String getRevJan() {
		return revJan;
	}
	public void setRevJan(String revJan) {
		this.revJan = revJan;
	}
	public String getRevFeb() {
		return revFeb;
	}
	public void setRevFeb(String revFeb) {
		this.revFeb = revFeb;
	}
	public String getRevMar() {
		return revMar;
	}
	public void setRevMar(String revMar) {
		this.revMar = revMar;
	}
	public String getRevApr() {
		return revApr;
	}
	public void setRevApr(String revApr) {
		this.revApr = revApr;
	}
	public String getRevMay() {
		return revMay;
	}
	public void setRevMay(String revMay) {
		this.revMay = revMay;
	}
	public String getRevJun() {
		return revJun;
	}
	public void setRevJun(String revJun) {
		this.revJun = revJun;
	}
	public String getRevJul() {
		return revJul;
	}
	public void setRevJul(String revJul) {
		this.revJul = revJul;
	}
	public String getRevAug() {
		return revAug;
	}
	public void setRevAug(String revAug) {
		this.revAug = revAug;
	}
	public String getRevSep() {
		return revSep;
	}
	public void setRevSep(String revSep) {
		this.revSep = revSep;
	}
	public String getRevOct() {
		return revOct;
	}
	public void setRevOct(String revOct) {
		this.revOct = revOct;
	}
	public String getRevNov() {
		return revNov;
	}
	public void setRevNov(String revNov) {
		this.revNov = revNov;
	}
	public String getRevDec() {
		return revDec;
	}
	public void setRevDec(String revDec) {
		this.revDec = revDec;
	}
	public String getTotRev() {
		return totRev;
	}
	public void setTotRev(String totRev) {
		this.totRev = totRev;
	}
	public String getEffort_Jan() {
		return effort_Jan;
	}
	public void setEffort_Jan(String effort_Jan) {
		this.effort_Jan = effort_Jan;
	}
	public String getEffort_Feb() {
		return effort_Feb;
	}
	public void setEffort_Feb(String effort_Feb) {
		this.effort_Feb = effort_Feb;
	}
	public String getEffort_Mar() {
		return effort_Mar;
	}
	public void setEffort_Mar(String effort_Mar) {
		this.effort_Mar = effort_Mar;
	}
	public String getEffort_Apr() {
		return effort_Apr;
	}
	public void setEffort_Apr(String effort_Apr) {
		this.effort_Apr = effort_Apr;
	}
	public String getEffort_May() {
		return effort_May;
	}
	public void setEffort_May(String effort_May) {
		this.effort_May = effort_May;
	}
	public String getEffort_Jun() {
		return effort_Jun;
	}
	public void setEffort_Jun(String effort_Jun) {
		this.effort_Jun = effort_Jun;
	}
	public String getEffort_Jul() {
		return effort_Jul;
	}
	public void setEffort_Jul(String effort_Jul) {
		this.effort_Jul = effort_Jul;
	}
	public String getEffort_Aug() {
		return effort_Aug;
	}
	public void setEffort_Aug(String effort_Aug) {
		this.effort_Aug = effort_Aug;
	}
	public String getEffort_Sep() {
		return effort_Sep;
	}
	public void setEffort_Sep(String effort_Sep) {
		this.effort_Sep = effort_Sep;
	}
	public String getEffort_Oct() {
		return effort_Oct;
	}
	public void setEffort_Oct(String effort_Oct) {
		this.effort_Oct = effort_Oct;
	}
	public String getEffort_Nov() {
		return effort_Nov;
	}
	public void setEffort_Nov(String effort_Nov) {
		this.effort_Nov = effort_Nov;
	}
	public String getEffort_Dec() {
		return effort_Dec;
	}
	public void setEffort_Dec(String effort_Dec) {
		this.effort_Dec = effort_Dec;
	}
	public String getTot_effort() {
		return tot_effort;
	}
	public void setTot_effort(String tot_effort) {
		this.tot_effort = tot_effort;
	}
	public String getAct_revJan() {
		return act_revJan;
	}
	public void setAct_revJan(String act_revJan) {
		this.act_revJan = act_revJan;
	}
	public String getAct_revFeb() {
		return act_revFeb;
	}
	public void setAct_revFeb(String act_revFeb) {
		this.act_revFeb = act_revFeb;
	}
	public String getAct_revMar() {
		return act_revMar;
	}
	public void setAct_revMar(String act_revMar) {
		this.act_revMar = act_revMar;
	}
	public String getAct_revApr() {
		return act_revApr;
	}
	public void setAct_revApr(String act_revApr) {
		this.act_revApr = act_revApr;
	}
	public String getAct_revMay() {
		return act_revMay;
	}
	public void setAct_revMay(String act_revMay) {
		this.act_revMay = act_revMay;
	}
	public String getAct_revJun() {
		return act_revJun;
	}
	public void setAct_revJun(String act_revJun) {
		this.act_revJun = act_revJun;
	}
	public String getAct_revJul() {
		return act_revJul;
	}
	public void setAct_revJul(String act_revJul) {
		this.act_revJul = act_revJul;
	}
	public String getAct_revAug() {
		return act_revAug;
	}
	public void setAct_revAug(String act_revAug) {
		this.act_revAug = act_revAug;
	}
	public String getAct_revSep() {
		return act_revSep;
	}
	public void setAct_revSep(String act_revSep) {
		this.act_revSep = act_revSep;
	}
	public String getAct_revOct() {
		return act_revOct;
	}
	public void setAct_revOct(String act_revOct) {
		this.act_revOct = act_revOct;
	}
	public String getAct_revNov() {
		return act_revNov;
	}
	public void setAct_revNov(String act_revNov) {
		this.act_revNov = act_revNov;
	}
	public String getAct_revDec() {
		return act_revDec;
	}
	public void setAct_revDec(String act_revDec) {
		this.act_revDec = act_revDec;
	}
	public String getAct_totRev() {
		return act_totRev;
	}
	public void setAct_totRev(String act_totRev) {
		this.act_totRev = act_totRev;
	}
	public String getAct_effort_Jan() {
		return act_effort_Jan;
	}
	public void setAct_effort_Jan(String act_effort_Jan) {
		this.act_effort_Jan = act_effort_Jan;
	}
	public String getAct_effort_Feb() {
		return act_effort_Feb;
	}
	public void setAct_effort_Feb(String act_effort_Feb) {
		this.act_effort_Feb = act_effort_Feb;
	}
	public String getAct_effort_Mar() {
		return act_effort_Mar;
	}
	public void setAct_effort_Mar(String act_effort_Mar) {
		this.act_effort_Mar = act_effort_Mar;
	}
	public String getAct_effort_Apr() {
		return act_effort_Apr;
	}
	public void setAct_effort_Apr(String act_effort_Apr) {
		this.act_effort_Apr = act_effort_Apr;
	}
	public String getAct_effort_May() {
		return act_effort_May;
	}
	public void setAct_effort_May(String act_effort_May) {
		this.act_effort_May = act_effort_May;
	}
	public String getAct_effort_Jun() {
		return act_effort_Jun;
	}
	public void setAct_effort_Jun(String act_effort_Jun) {
		this.act_effort_Jun = act_effort_Jun;
	}
	public String getAct_effort_Jul() {
		return act_effort_Jul;
	}
	public void setAct_effort_Jul(String act_effort_Jul) {
		this.act_effort_Jul = act_effort_Jul;
	}
	public String getAct_effort_Aug() {
		return act_effort_Aug;
	}
	public void setAct_effort_Aug(String act_effort_Aug) {
		this.act_effort_Aug = act_effort_Aug;
	}
	public String getAct_effort_Sep() {
		return act_effort_Sep;
	}
	public void setAct_effort_Sep(String act_effort_Sep) {
		this.act_effort_Sep = act_effort_Sep;
	}
	public String getAct_effort_Oct() {
		return act_effort_Oct;
	}
	public void setAct_effort_Oct(String act_effort_Oct) {
		this.act_effort_Oct = act_effort_Oct;
	}
	public String getAct_effort_Nov() {
		return act_effort_Nov;
	}
	public void setAct_effort_Nov(String act_effort_Nov) {
		this.act_effort_Nov = act_effort_Nov;
	}
	public String getAct_effort_Dec() {
		return act_effort_Dec;
	}
	public void setAct_effort_Dec(String act_effort_Dec) {
		this.act_effort_Dec = act_effort_Dec;
	}
	public String getAct_tot_effort() {
		return act_tot_effort;
	}
	public void setAct_tot_effort(String act_tot_effort) {
		this.act_tot_effort = act_tot_effort;
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
	
	
	
	
}

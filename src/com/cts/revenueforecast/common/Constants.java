package com.cts.revenueforecast.common;

public interface Constants {

	public String comma = ",";
	public String singleQuote = "'";

	public String fixedBitProjects = "'1000165476'";
	public String terminatedEmployeeStatus = "T";
	public String newEmployeeStatus = "N";
	public String existingEmployeeStatus = "E";
	public String offshoreWorkingHrs = "9";
	public String onsiteWorkingHrs = "8";
	public String countryIndia = "India";

	// Base Sheet Generation - SQL Queries

	String newEmployees = "select associateId from allocationreport where associateId not in (SELECT employee_id FROM base)";

	String selectNewBaseDataQuery = "select distinct AA.associateId as employee_id,"
			+ "AA.assignmentID as work_assignment_id,AA.truefalse,AA.associatename as name, "
			+ "AA.projectid as project,AA.projectdescription as description,AA.projectmanagerid as pm_id,AA.projectmanagername as pm_name, "
			+ "AA.City,AA.assgncountry as country,AA.billabilitystatus as associate_billability,PL.AM,SWWD.SOW_Worker_Role as sow, PL.sow_number, " // PL.sow
			+ "PL.billing_in,EVCI.ce_id,EVCI.contractor_number,AA.assignmentStartDate as workerStartDate,"
			+ "AA.assignmentEndDate as allocation_end_date ,SWWD.Worker_End_Date,SWWD.Current_Bill_Rate_ST_Hr, "
			+ "JWN.Worker_End_Date as sowEndDate,JWN.Current_Bill_Rate_Hr as sowBillRate, VD.pto_jan, "
			+ "VD.pto_feb,VD.pto_mar,VD.pto_apr,VD.pto_may,VD.pto_june,VD.pto_july,VD.pto_aug,VD.pto_sept,VD.pto_oct,VD.pto_nov,VD.pto_dec,AA.departmentName as practice_name,'"
			+ newEmployeeStatus + "' as status " + "from allocationreport AA "
			+ "inner join esa_vs_contractor_id EVCI on AA.associateId=EVCI.associate_id  "
			+ "inner join project_list PL on AA.projectid=PL.Project  "
			+ "inner join just_worker_new JWN on EVCI.contractor_number=JWN.Contractor_ID   "
			+ "left join sow_wise_worker_data SWWD on EVCI.contractor_number=SWWD.Contractor_ID "
			+ "left join vacation_details VD on AA.associateId=VD.employee_id " + "where AA.projectId <> "
			+ fixedBitProjects + " " + "and AA.associateId in (" + newEmployees + ")";

	String insertBaseSql = "insert into base (work_assignment_id,employee_id,name, project, description, pm_id, "
			+ "pm_name, city, country, associate_billability, AM, sow, SoW_Number, Billing_in,ce_id, contractor_number,"
			+ " Worker_Start_Date, Worker_End_Date, Current_Bill_Rate_ST_Hr,pto_jan, pto_feb, pto_mar, pto_apr, "
			+ "pto_may, pto_june, pto_july, pto_aug, pto_sept, pto_oct, pto_nov, pto_dec,total_pto,Onsite_Offshore,"
			+ "billing_hours_per_day,date_stamp,status,truefalse,sowbillrate,sowenddate,email,practice_name,allocation_end_date) "
			+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	String[] allocationHeader = { "Sr.No.", "Associate ID", "True/False", "Associate Name", "Designation", "JobCode",
			"Grade HR", "Grade HR - Pyd", "Assignment ID", "SO ID", "SO Line", "Project ID", "Project Description",
			"Project Manager ID", "Project Manager Name", "Account ID", "Account Name", "OD Hierarchy", "Account Group",
			"Sub Vertical", "Pool ID", "Pool Description", "Vertical/Horizontal", "Grade", "Date of Joining",
			"FIN Department ID", "HCM Supervisor ID", "Project Owning Department", "Project Owning Practice",
			"Billability Status", "Critical Flag", "Location ID", "Country", "Onsite/Offshore", "State", "City",
			"Assignment Start Date", "Assignment End Date", "Assignment Status", "Percent Allocation", "Project Role",
			"Operational Role", "Assgn City", "Assgn State", "Assgn Country", "Location Reason code",
			"Project Start Date", "Project End Date", "Project Billability", "Project Type", "Project Status",
			"Associate Base Hiring Location", "Department Name", "HCM SetID", "Project_Solution_Type",
			"Assignment location", "SBU1", "SBU2", "Primary State Tag", "Contractor End Date", "Comment",
			"Competency" };

	String[] esaVsContractorHeader = { "Associate Id", "CE ID", "Contractor number", "Contractor text",
			"Associate Name", "Contractor Name" };

	String[] projectListHeader = { "Project", "Description", "PM ID", "PM Name", "Dev/SSMO", "Project ID text", "Type",
			"AM", "EM", "SVP", "VP IT", "Forecast PoC ID", "SoW", "SoW Number", "Onsite PoC", "Offshore PoC",
			"Discount", "Datestamp", "Billing in" };

	String[] sowWorkerWiseHeader = { "Contractor ID", "Statement of Work", "Worker Status", "Worker ID", "Worker",
			"SOW Worker Role", "Worker End Date", "Current Bill Rate [ST/Hr]", "Worker Start Date",
			"Latest Work Order?" };

	String[] vacationDetailsHeader = { "Empl_ID", "Name", "Email", "PTO Jan 2017", "PTO Feb 2017", "PTO Mar 2017",
			"PTO Apr 2017", "PTO May 2017", "PTO Jun 2017", "PTO Jul 2017", "PTO Aug 2017", "PTO Sep 2017",
			"PTO Oct 2017", "PTO Nov 2017", "PTO Dec 2017" };

	String[] justWorkerNewHeader = { "Contractor ID", "Worker End Date", "Current Bill Rate [ST/Day]",
			"Current Bill Rate [ST/Hr]", "Current Bill Rate [ST/MO]", "Current Bill Rate [OT/Hr]", "Worker Status",
			"Worker ID", "Worker", "Work Order Status", "Work Order ID", "Latest Work Order?" };

	String[] ppmSheetHeader = { "Project ID", "Task", "Time Period", "Resource Name", "Resource ID", "Resource Manager",
			"Timesheet Status", "Timesheet Hours", "Senior Executive", "Email" };

	String[] holidayListHeader = {};
	String check="check";
}

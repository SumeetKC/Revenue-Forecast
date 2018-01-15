package com.cts.revenueforecast.model;

import java.util.List;

public class AllocationReport {
	private String sno, associateId, trueFalse, associateName, designation, jobCode, gradeHR, gradeHRPyd, assignmentID,
			soID, soLine, projectID, projectDescription, projectManagerID, projectManagerName, accountID, accountName,
			odHierarchy, accountGroup, subVertical, poolID, poolDescription, verticalHorizontal, grade, dateOfJoining,
			finDepartmentID, hcmSupervisorID, projectOwningDepartment, projectOwningPractice, billabilityStatus,
			criticalFlag, locationID, country, onsiteOffshore, state, city, assignmentStartDate, assignmentEndDate,
			assignmentStatus, percentAllocation, projectRole, operationalRole, assgnCity, assgnState, assgnCountry,
			locationReasoncode, projectStartDate, projectEndDate, projectBillability, projectType, projectStatus,
			associateBaseHiringLocation, departmentName, hcmSetID, project_Solution_Type, assignmentLocation, sbu1,
			sbu2, primaryStateTag, contractorEndDate, comment, competency;

	public AllocationReport(String sno, String associateId, String trueFalse, String associateName, String designation,
			String jobCode, String gradeHR, String gradeHRPyd, String assignmentID, String soID, String soLine,
			String projectID, String projectDescription, String projectManagerID, String projectManagerName,
			String accountID, String accountName, String odHierarchy, String accountGroup, String subVertical,
			String poolID, String poolDescription, String verticalHorizontal, String grade, String dateOfJoining,
			String finDepartmentID, String hcmSupervisorID, String projectOwningDepartment,
			String projectOwningPractice, String billabilityStatus, String criticalFlag, String locationID,
			String country, String onsiteOffshore, String state, String city, String assignmentStartDate,
			String assignmentEndDate, String assignmentStatus, String percentAllocation, String projectRole,
			String operationalRole, String assgnCity, String assgnState, String assgnCountry, String locationReasoncode,
			String projectStartDate, String projectEndDate, String projectBillability, String projectType,
			String projectStatus, String associateBaseHiringLocation, String departmentName, String hcmSetID,
			String project_Solution_Type, String assignmentLocation, String sbu1, String sbu2, String primaryStateTag,
			String contractorEndDate, String comment, String competency) {
		super();

		this.sno = sno;
		this.associateId = associateId;
		this.trueFalse = trueFalse;
		this.associateName = associateName;
		this.designation = designation;
		this.jobCode = jobCode;
		this.gradeHR = gradeHR;
		this.gradeHRPyd = gradeHRPyd;
		this.assignmentID = assignmentID;
		this.soID = soID;
		this.soLine = soLine;
		this.projectID = projectID;
		this.projectDescription = projectDescription;
		this.projectManagerID = projectManagerID;
		this.projectManagerName = projectManagerName;
		this.accountID = accountID;
		this.accountName = accountName;
		this.odHierarchy = odHierarchy;
		this.accountGroup = accountGroup;
		this.subVertical = subVertical;
		this.poolID = poolID;
		this.poolDescription = poolDescription;
		this.verticalHorizontal = verticalHorizontal;
		this.grade = grade;
		this.dateOfJoining = dateOfJoining;
		this.finDepartmentID = finDepartmentID;
		this.hcmSupervisorID = hcmSupervisorID;
		this.projectOwningDepartment = projectOwningDepartment;
		this.projectOwningPractice = projectOwningPractice;
		this.billabilityStatus = billabilityStatus;
		this.criticalFlag = criticalFlag;
		this.locationID = locationID;
		this.country = country;
		this.onsiteOffshore = onsiteOffshore;
		this.state = state;
		this.city = city;
		this.assignmentStartDate = assignmentStartDate;
		this.assignmentEndDate = assignmentEndDate;
		this.assignmentStatus = assignmentStatus;
		this.percentAllocation = percentAllocation;
		this.projectRole = projectRole;
		this.operationalRole = operationalRole;
		this.assgnCity = assgnCity;
		this.assgnState = assgnState;
		this.assgnCountry = assgnCountry;
		this.locationReasoncode = locationReasoncode;
		this.projectStartDate = projectStartDate;
		this.projectEndDate = projectEndDate;
		this.projectBillability = projectBillability;
		this.projectType = projectType;
		this.projectStatus = projectStatus;
		this.associateBaseHiringLocation = associateBaseHiringLocation;
		this.departmentName = departmentName;
		this.hcmSetID = hcmSetID;
		this.project_Solution_Type = project_Solution_Type;
		this.assignmentLocation = assignmentLocation;
		this.sbu1 = sbu1;
		this.sbu2 = sbu2;
		this.primaryStateTag = primaryStateTag;
		this.contractorEndDate = contractorEndDate;
		this.comment = comment;
		this.competency = competency;
	}

	public AllocationReport(List<String> vl) {
		super();
		this.sno = vl.get(0);
		this.associateId = vl.get(1);
		this.trueFalse = vl.get(2);
		this.associateName = vl.get(3);
		this.designation = vl.get(4);
		this.jobCode = vl.get(5);
		this.gradeHR = vl.get(6);
		this.gradeHRPyd = vl.get(7);
		this.assignmentID = vl.get(8);
		this.soID = vl.get(9);
		this.soLine = vl.get(10);
		this.projectID = vl.get(11);
		this.projectDescription = vl.get(12);
		this.projectManagerID = vl.get(13);
		this.projectManagerName = vl.get(14);
		this.accountID = vl.get(15);
		this.accountName = vl.get(16);
		this.odHierarchy = vl.get(17);
		this.accountGroup = vl.get(18);
		this.subVertical = vl.get(19);
		this.poolID = vl.get(20);
		this.poolDescription = vl.get(21);
		this.verticalHorizontal = vl.get(22);
		this.grade = vl.get(23);
		this.dateOfJoining = vl.get(24);
		this.finDepartmentID = vl.get(25);
		this.hcmSupervisorID = vl.get(26);
		this.projectOwningDepartment = vl.get(27);
		this.projectOwningPractice = vl.get(28);
		this.billabilityStatus = vl.get(29);
		this.criticalFlag = vl.get(30);
		this.locationID = vl.get(31);
		this.country = vl.get(32);
		this.onsiteOffshore = vl.get(33);
		this.state = vl.get(34);
		this.city = vl.get(35);
		this.assignmentStartDate = vl.get(36);
		this.assignmentEndDate = vl.get(37);
		this.assignmentStatus = vl.get(38);
		this.percentAllocation = vl.get(39);
		this.projectRole = vl.get(40);
		this.operationalRole = vl.get(41);
		this.assgnCity = vl.get(42);
		this.assgnState = vl.get(43);
		this.assgnCountry = vl.get(44);
		this.locationReasoncode = vl.get(45);
		this.projectStartDate = vl.get(46);
		this.projectEndDate = vl.get(47);
		this.projectBillability = vl.get(48);
		this.projectType = vl.get(49);
		this.projectStatus = vl.get(50);
		this.associateBaseHiringLocation = vl.get(51);
		this.departmentName = vl.get(52);
		this.hcmSetID = vl.get(53);
		this.project_Solution_Type = vl.get(54);
		this.assignmentLocation = vl.get(55);
		this.sbu1 = vl.get(56);
		this.sbu2 = vl.get(57);
		this.primaryStateTag = vl.get(58);
		this.contractorEndDate = vl.get(59);
		this.comment = vl.get(60);
		this.competency = vl.get(61);
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getAssociateId() {
		return associateId;
	}

	public void setAssociateId(String associateId) {
		this.associateId = associateId;
	}

	public String getTrueFalse() {
		return trueFalse;
	}

	public void setTrueFalse(String trueFalse) {
		this.trueFalse = trueFalse;
	}

	public String getAssociateName() {
		return associateName;
	}

	public void setAssociateName(String associateName) {
		this.associateName = associateName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	public String getGradeHR() {
		return gradeHR;
	}

	public void setGradeHR(String gradeHR) {
		this.gradeHR = gradeHR;
	}

	public String getGradeHRPyd() {
		return gradeHRPyd;
	}

	public void setGradeHRPyd(String gradeHRPyd) {
		this.gradeHRPyd = gradeHRPyd;
	}

	public String getAssignmentID() {
		return assignmentID;
	}

	public void setAssignmentID(String assignmentID) {
		this.assignmentID = assignmentID;
	}

	public String getSoID() {
		return soID;
	}

	public void setSoID(String soID) {
		this.soID = soID;
	}

	public String getSoLine() {
		return soLine;
	}

	public void setSoLine(String soLine) {
		this.soLine = soLine;
	}

	public String getProjectID() {
		return projectID;
	}

	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public String getProjectManagerID() {
		return projectManagerID;
	}

	public void setProjectManagerID(String projectManagerID) {
		this.projectManagerID = projectManagerID;
	}

	public String getProjectManagerName() {
		return projectManagerName;
	}

	public void setProjectManagerName(String projectManagerName) {
		this.projectManagerName = projectManagerName;
	}

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getOdHierarchy() {
		return odHierarchy;
	}

	public void setOdHierarchy(String odHierarchy) {
		this.odHierarchy = odHierarchy;
	}

	public String getAccountGroup() {
		return accountGroup;
	}

	public void setAccountGroup(String accountGroup) {
		this.accountGroup = accountGroup;
	}

	public String getSubVertical() {
		return subVertical;
	}

	public void setSubVertical(String subVertical) {
		this.subVertical = subVertical;
	}

	public String getPoolID() {
		return poolID;
	}

	public void setPoolID(String poolID) {
		this.poolID = poolID;
	}

	public String getPoolDescription() {
		return poolDescription;
	}

	public void setPoolDescription(String poolDescription) {
		this.poolDescription = poolDescription;
	}

	public String getVerticalHorizontal() {
		return verticalHorizontal;
	}

	public void setVerticalHorizontal(String verticalHorizontal) {
		this.verticalHorizontal = verticalHorizontal;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getFinDepartmentID() {
		return finDepartmentID;
	}

	public void setFinDepartmentID(String finDepartmentID) {
		this.finDepartmentID = finDepartmentID;
	}

	public String getHcmSupervisorID() {
		return hcmSupervisorID;
	}

	public void setHcmSupervisorID(String hcmSupervisorID) {
		this.hcmSupervisorID = hcmSupervisorID;
	}

	public String getProjectOwningDepartment() {
		return projectOwningDepartment;
	}

	public void setProjectOwningDepartment(String projectOwningDepartment) {
		this.projectOwningDepartment = projectOwningDepartment;
	}

	public String getProjectOwningPractice() {
		return projectOwningPractice;
	}

	public void setProjectOwningPractice(String projectOwningPractice) {
		this.projectOwningPractice = projectOwningPractice;
	}

	public String getBillabilityStatus() {
		return billabilityStatus;
	}

	public void setBillabilityStatus(String billabilityStatus) {
		this.billabilityStatus = billabilityStatus;
	}

	public String getCriticalFlag() {
		return criticalFlag;
	}

	public void setCriticalFlag(String criticalFlag) {
		this.criticalFlag = criticalFlag;
	}

	public String getLocationID() {
		return locationID;
	}

	public void setLocationID(String locationID) {
		this.locationID = locationID;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getOnsiteOffshore() {
		return onsiteOffshore;
	}

	public void setOnsiteOffshore(String onsiteOffshore) {
		this.onsiteOffshore = onsiteOffshore;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAssignmentStartDate() {
		return assignmentStartDate;
	}

	public void setAssignmentStartDate(String assignmentStartDate) {
		this.assignmentStartDate = assignmentStartDate;
	}

	public String getAssignmentEndDate() {
		return assignmentEndDate;
	}

	public void setAssignmentEndDate(String assignmentEndDate) {
		this.assignmentEndDate = assignmentEndDate;
	}

	public String getAssignmentStatus() {
		return assignmentStatus;
	}

	public void setAssignmentStatus(String assignmentStatus) {
		this.assignmentStatus = assignmentStatus;
	}

	public String getPercentAllocation() {
		return percentAllocation;
	}

	public void setPercentAllocation(String percentAllocation) {
		this.percentAllocation = percentAllocation;
	}

	public String getProjectRole() {
		return projectRole;
	}

	public void setProjectRole(String projectRole) {
		this.projectRole = projectRole;
	}

	public String getOperationalRole() {
		return operationalRole;
	}

	public void setOperationalRole(String operationalRole) {
		this.operationalRole = operationalRole;
	}

	public String getAssgnCity() {
		return assgnCity;
	}

	public void setAssgnCity(String assgnCity) {
		this.assgnCity = assgnCity;
	}

	public String getAssgnState() {
		return assgnState;
	}

	public void setAssgnState(String assgnState) {
		this.assgnState = assgnState;
	}

	public String getAssgnCountry() {
		return assgnCountry;
	}

	public void setAssgnCountry(String assgnCountry) {
		this.assgnCountry = assgnCountry;
	}

	public String getLocationReasoncode() {
		return locationReasoncode;
	}

	public void setLocationReasoncode(String locationReasoncode) {
		this.locationReasoncode = locationReasoncode;
	}

	public String getProjectStartDate() {
		return projectStartDate;
	}

	public void setProjectStartDate(String projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	public String getProjectEndDate() {
		return projectEndDate;
	}

	public void setProjectEndDate(String projectEndDate) {
		this.projectEndDate = projectEndDate;
	}

	public String getProjectBillability() {
		return projectBillability;
	}

	public void setProjectBillability(String projectBillability) {
		this.projectBillability = projectBillability;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public String getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

	public String getAssociateBaseHiringLocation() {
		return associateBaseHiringLocation;
	}

	public void setAssociateBaseHiringLocation(String associateBaseHiringLocation) {
		this.associateBaseHiringLocation = associateBaseHiringLocation;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getHcmSetID() {
		return hcmSetID;
	}

	public void setHcmSetID(String hcmSetID) {
		this.hcmSetID = hcmSetID;
	}

	public String getProject_Solution_Type() {
		return project_Solution_Type;
	}

	public void setProject_Solution_Type(String project_Solution_Type) {
		this.project_Solution_Type = project_Solution_Type;
	}

	public String getAssignmentLocation() {
		return assignmentLocation;
	}

	public void setAssignmentLocation(String assignmentLocation) {
		this.assignmentLocation = assignmentLocation;
	}

	public String getSbu1() {
		return sbu1;
	}

	public void setSbu1(String sbu1) {
		this.sbu1 = sbu1;
	}

	public String getSbu2() {
		return sbu2;
	}

	public void setSbu2(String sbu2) {
		this.sbu2 = sbu2;
	}

	public String getPrimaryStateTag() {
		return primaryStateTag;
	}

	public void setPrimaryStateTag(String primaryStateTag) {
		this.primaryStateTag = primaryStateTag;
	}

	public String getContractorEndDate() {
		return contractorEndDate;
	}

	public void setContractorEndDate(String contractorEndDate) {
		this.contractorEndDate = contractorEndDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCompetency() {
		return competency;
	}

	public void setCompetency(String competency) {
		this.competency = competency;
	}

}

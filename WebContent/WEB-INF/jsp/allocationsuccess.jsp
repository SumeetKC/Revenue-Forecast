<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/buttons/1.4.2/css/buttons.dataTables.min.css">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/buttons/1.4.2/js/dataTables.buttons.min.js"></script>
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/buttons/1.4.2/js/buttons.flash.min.js"></script>
<script type="text/javascript" charset="utf8"
	src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script type="text/javascript" charset="utf8"
	src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/pdfmake.min.js"></script>
<script type="text/javascript" charset="utf8"
	src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/vfs_fonts.js"></script>
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/buttons/1.4.2/js/buttons.html5.min.js"></script>
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/buttons/1.4.2/js/buttons.print.min.js"></script>



<script>
$(document).ready(function(){
    $('#allocationdata').DataTable({
        dom: 'Bfrtip',
        buttons: [
            'copy', 'csv', 'excel', 'pdf', 'print'
        ]
    } );
});
</script>

<style>
.allocationdata tr td, th {
	border: 1px solid #999;
}

/* .ppmReportdata tr th {
	background-color: grey;
} */
TD {
	font-family: Arial;
	font-size: 9pt;
}


h3 {
	font-family: Arial;
	font-size: 16px;
}

thead {
	background-color: lightsalmon;
	font-family: Arial;
	font-size: 10pt;
}

.table {
	overflow: scroll;
	height: 500px;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}
</style>
</head>
<body>
	 <div align="center">
		<h2>Allocation Report</h2>
	</div>
	<br/>
	<div class="table" align="center">
		<table id="allocationdata" border="2" cellpadding="6px"
			class="allocationdata"
			style="border-collapse: collapse; background-color: white; height: 100%; width: 100%">
			<thead style="background-color: lightsalmon">
				<TR style="font-weight: bold;">
					<td>Sr.No.</td>
					<td>Associate ID</td>
					<td>True/False</td>
					<td>Associate Name</td>
					<td>Designation</td>
					<td>JobCode</td>
					<td>Grade HR</td>
					<td>Grade HR - Pyd</td>
					<td>Assignment ID</td>
					<td>SO ID</td>
					<td>SO Line</td>
					<td>Project ID</td>
					<td>Project Description</td>
					<td>Project Manager ID</td>
					<td>Project ManagerName</td>
					<td>Account ID</td>
					<td>Account Name</td>
					<td>OD Hierarchy</td>
					<td>Account Group</td>
					<td>Sub Vertical</td>
					<td>Pool ID</td>
					<td>Pool Description</td>
					<td>Vertical/Horizontal</td>
					<td>Grade</td>
					<td>Date of Joining</td>
					<td>FIN Department ID</td>
					<td>HCM Supervisor ID</td>
					<td>Project Owning Department</td>
					<td>Project Owning Practice</td>
					<td>Billability Status</td>
					<td>Critical Flag</td>
					<td>Location ID</td>
					<td>Country</td>
					<td>Onsite/Offshore</td>
					<td>State</td>
					<td>City</td>
					<td>Assignment Start Date</td>
					<td>Assignment End Date</td>
					<td>Assignment Status</td>
					<td>Percent Allocation</td>
					<td>Project Role</td>
					<td>Operational Role</td>
					<td>Assgn City</td>
					<td>Assgn State</td>
					<td>Assgn Country</td>
					<td>Location Reason code</td>
					<td>Project Start Date</td>
					<td>Project End Date</td>
					<td>Project Billability</td>
					<td>Project Type</td>
					<td>Project Status</td>
					<td>Associate Base Hiring Location</td>
					<td>Department Name</td>
					<td>HCM SetID</td>
					<td>Project_Solution_Type</td>
					<td>Assignment location</td>
					<td>SBU1</td>
					<td>SBU2</td>
					<td>Primary State Tag</td>
					<td>Contractor End Date</td>
					<td>Comment</td>
					<td>Competency</td>
				</TR>
			</thead>
			<tbody id="records" style="overflow: scroll;">
				<c:forEach items="${list}" var="allocation" varStatus="i">
					<tr>
						<td>${i.count}</td>
						<td>${allocation.associateId}</td>
						<td>${allocation.trueFalse}</td>
						<td>${allocation.associateName}</td>
						<td>${allocation.designation}</td>
						<td>${allocation.jobCode}</td>
						<td>${allocation.gradeHR}</td>
						<td>${allocation.gradeHRPyd}</td>
						<td>${allocation.assignmentID}</td>
						<td>${allocation.soID}</td>
						<td>${allocation.soLine}</td>
						<td>${allocation.projectID}</td>
						<td>${allocation.projectDescription}</td>
						<td>${allocation.projectManagerID}</td>
						<td>${allocation.projectManagerName}</td>
						<td>${allocation.accountID}</td>
						<td>${allocation.accountName}</td>
						<td>${allocation.odHierarchy}</td>
						<td>${allocation.accountGroup}</td>
						<td>${allocation.subVertical}</td>
						<td>${allocation.poolID}</td>
						<td>${allocation.poolDescription}</td>
						<td>${allocation.verticalHorizontal}</td>
						<td>${allocation.grade}</td>
						<td>${allocation.dateOfJoining}</td>
						<td>${allocation.finDepartmentID}</td>
						<td>${allocation.hcmSupervisorID}</td>
						<td>${allocation.projectOwningDepartment}</td>
						<td>${allocation.projectOwningPractice}</td>
						<td>${allocation.billailityStatus}</td>
						<td>${allocation.criticalFlag}</td>
						<td>${allocation.locationID}</td>
						<td>${allocation.country}</td>
						<td>${allocation.onsiteOffshore}</td>
						<td>${allocation.state}</td>						
						<td>${allocation.city}</td>
						<td>${allocation.assignmentStartDate}</td>
						<td>${allocation.assignmentEndDate}</td>
						<td>${allocation.assignmentStatus}</td>
						<td>${alloction.percentAllocation}</td>
						<td>${allocation.projectRole}</td>
						<td>${allocation.operationalRole}</td>
						<td>${allocation.assgnCity}</td>
						<td>${allocation.assgnState}</td>
						<td>${allocation.assgnCountry}</td>
						<td>${allocation.locationReasoncode}</td>
						<td>${allocation.projectStartDate}</td>
						<td>${allocation.projectEndDate}</td>
						<td>${allocation.projectBillability}</td>
						<td>${allocation.projectType}</td>
						<td>${allocation.projectStatus}</td>
						<td>${allocation.associateBaseHiringLocation}</td>
						<td>${allocation.departmentName}</td>
						<td>${allocation.hcmSetID}</td>
						<td>${allocation.project_Solution_Type}</td>
						<td>${allocation.assignmentLocation}</td>
						<td>${allocation.sbu1}</td>
						<td>${allocation.sbu2}</td>
						<td>${allocation.primaryStateTag}</td>
						<td>${allocation.contractorEndDate}</td>
						<td>${allocation.comment}</td>
						<td>${allocation.competency}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>
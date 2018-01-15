<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.basedata tr td, th {
	border: 1px solid #999;
	padding: 0.5rem;
}

.basedata tr th {
	background-color: lightsalmon;
}

TD {
	font-family: Arial;
	font-size: 9pt;
}

TH {
	font-family: Arial;
	font-size: 10pt;
	height: 5px;
}
.table {
	overflow: scroll;
	height: 500px;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}

/* TD{
width:"10%";
height:"1";
} */
</style>
</head>
<body>
	
		<h1 align="center">Active Report</h1>
		<div align="center" class="table">
		<table border="2" style="width: 100%; height: 100%; border-collapse: collapse; background-color: white" class="basedata">
			<tr>
				<th>Work Asnm. Id</th>
				<th>Employee id</th>
				<th>Name</th>
				<th>Project Id</th>
				<th>Project Description</th>
				<th>PM Id</th>
				<th>PM Name</th>
				<!-- <th>ProjectId EmpId</th> -->
				<th>City</th>
				<th>Country</th>
				<th>Ass.Billability</th>
				<th>AM</th>
				<!-- <th>SoW</th> -->
				<th>SoW Number</th>
				<th>Billing in</th>
				<!-- <th>Contractor id</th> -->
				<th>Contr.Id</th>
				<th>Start Date</th>
				<th>End Date</th>
				<th>Ct Bill Rate</th>
				<th>sow End Date</th>
				<th>sow Bill Rate</th>
				<th>On/Off</th>
				<th>Bill Hours/Day</th>
				<th>PTO jan</th>
				<th>PTO feb</th>
				<th>PTO mar</th>
				<th>PTO apr</th>
				<th>PTO may</th>
				<th>PTO june</th>
				<th>PTO july</th>
				<th>PTO aug</th>
				<th>PTO sept</th>
				<th>PTO oct</th>
				<th>PTO nov</th>
				<th>PTO dec</th>
				<th>Total PTO</th>
				<th>Rev jan</th>
				<th>Rev feb</th>
				<th>Rev mar</th>
				<th>Rev apr</th>
				<th>Rev may</th>
				<th>Rev june</th>
				<th>Rev july</th>
				<th>Rev aug</th>
				<th>Rev sept</th>
				<th>Rev oct</th>
				<th>Rev nov</th>
				<th>Rev dec</th>
				<th>Total Rev</th>
				<th>Eff jan</th>
				<th>Eff feb</th>
				<th>Eff mar</th>
				<th>Eff apr</th>
				<th>Eff may</th>
				<th>Eff june</th>
				<th>Eff july</th>
				<th>Eff aug</th>
				<th>Eff sept</th>
				<th>Eff oct</th>
				<th>Eff nov</th>
				<th>Eff dec</th>
				<th>Total Eff</th>

			</tr>
			<c:forEach items="${activeData}" var="activeList">
				<tr>
					<td height='9px'>${activeList.work_assignment_id}</td>
					<td>${activeList.employee_id}</td>
					<td>${activeList.name}</td>
					<td>${activeList.project}</td>
					<td>${activeList.description}</td>
					<td>${activeList.pm_id}</td>
					<td>${activeList.pm_name}</td>
					<%-- <td>${basedata.projectId_EmpId}</td> --%>
					<td>${activeList.city}</td>
					<td>${activeList.country}</td>
					<td>${activeList.associate_billability}</td>
					<td>${activeList.AM}</td>
					<%-- <td>${basedata.sow}</td> --%>
					<td>${activeList.sowNumber}</td>
					<td>${activeList.billing_in}</td>
					<%-- <td>${basedata.ce_id}</td> --%>
					<td>${activeList.contractor_number}</td>
					<td>${activeList.workerStartDate}</td>
					<td>${activeList.workerEndDate}</td>

					<td>${activeList.current_Bill_Rate_ST_Hr}</td>
					<td>${activeList.sowEndDate}</td>
					<td>${activeList.sowBillRate}</td>
					<td>${activeList.onsite_Offshore}</td>
					<td>${activeList.billing_hours_per_day}</td>
					<td>${activeList.pto_jan}</td>
					<td>${activeList.pto_feb}</td>
					<td>${activeList.pto_mar}</td>
					<td>${activeList.pto_apr}</td>
					<td>${activeList.pto_may}</td>
					<td>${activeList.pto_june}</td>
					<td>${activeList.pto_july}</td>
					<td>${activeList.pto_aug}</td>
					<td>${activeList.pto_sept}</td>
					<td>${activeList.pto_oct}</td>
					<td>${activeList.pto_nov}</td>
					<td>${activeList.pto_dec}</td>
					<td>${activeList.total_pto}</td>
					<td>${activeList.revJan}</td>
					<td>${activeList.revFeb}</td>
					<td>${activeList.revMar}</td>
					<td>${activeList.revApr}</td>
					<td>${activeList.revMay}</td>
					<td>${activeList.revJun}</td>
					<td>${activeList.revJul}</td>
					<td>${activeList.revAug}</td>
					<td>${activeList.revSep}</td>
					<td>${activeList.revOct}</td>
					<td>${activeList.revNov}</td>
					<td>${activeList.revDec}</td>
					<td>${activeList.totRev}</td>
					<td>${activeList.effort_Jan}</td>
					<td>${activeList.effort_Feb}</td>
					<td>${activeList.effort_Mar}</td>
					<td>${activeList.effort_Apr}</td>
					<td>${activeList.effort_May}</td>
					<td>${activeList.effort_Jun}</td>
					<td>${activeList.effort_Jul}</td>
					<td>${activeList.effort_Aug}</td>
					<td>${activeList.effort_Sep}</td>
					<td>${activeList.effort_Oct}</td>
					<td>${activeList.effort_Nov}</td>
					<td>${activeList.effort_Dec}</td>
					<td>${activeList.tot_effort}</td>
				</tr>

			</c:forEach>

		</table>

	</div>
</body>
</html>
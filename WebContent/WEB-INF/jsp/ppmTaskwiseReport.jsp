<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.ppmReportdata tr td, th {
	border: 1px solid #999;
	padding: 0.5rem;
}

/* .ppmReportdata tr th {
	background-color: grey;
}
 */
TD {
	font-family: Arial;
	font-size: 9pt;
	padding: 3px 10px;
}

TH {
	font-family: Arial;
	font-size: 10pt;
	height: 5px;
	background-color: lightsalmon;
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
	<h2 align="center">PPM Status Task Wise Report</h2>
	<br/>
	<div align="center" class="table">
	<table border="2"
		style="width: 100%; height: 100%; border-collapse: collapse; background-color: white">

		<tr>
			<th>Project Id</th>
			<th>Task</th>
			<th>Time Period</th>
			<th>Resource Name</th>
			<th>Resource Id</th>
			<th>Resource Manager</th>
			<th>TS Status</th>
			<th>TS Hours</th>
			<th>Senior Exe</th>
			<th>Email</th>
		</tr>


		<c:forEach items="${ppmTaskList}" var="ppmReport" varStatus="status">
			<tr>
				<td><c:out value="${ppmReport.project_id}"></c:out></td>
				<td><c:out value="${ppmReport.task}"></c:out></td>
				<td><c:out value="${ppmReport.time_period}"></c:out></td>
				<td><c:out value="${ppmReport.resource_name}"></c:out></td>
				<td><c:out value="${ppmReport.resource_id}"></c:out></td>
				<td><c:out value="${ppmReport.resource_manager}"></c:out></td>
				<td><c:out value="${ppmReport.timesheet_status}"></c:out></td>
				<td><c:out value="${ppmReport.timesheet_hours}"></c:out></td>
				<td><c:out value="${ppmReport.senior_executive}"></c:out></td>
				<td><c:out value="${ppmReport.email}"></c:out></td>
			</tr>
		</c:forEach>

	</table>
	</div>
</body>
</html>
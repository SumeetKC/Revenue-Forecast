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
</head>

<style>
TD {
	font-family: Arial;
	font-size: 9pt;
	padding: 6px 10px;
}

TH {
	font-family: Arial;
	font-size: 10pt;
	height: 5px;
	background-color: lightsalmon;
	padding: 8px;
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

<body>
	<h2 align="center">PPM Status Report</h2>
	<br />
	<div align="center" class="table">
		<table align="center" border="2" id="ppmReportTable"
			class="ppmReportdata"
			style="width: 100%; height: 100%; border-collapse: collapse; background-color: white">

			<tr>
				<th>SNo</th>
				<th>Emp Id</th>
				<th>Contractor Id</th>
				<th>Name</th>
				<th>Project ID</th>
				<th>PM ID</th>
				<th>PM Name</th>
				<th>Worker End Date</th>
				

				<c:forEach items="${uniqueWeek}" var="uniqueWeekVar"
					varStatus="stat">
					<th>${uniqueWeekVar }</th>
				</c:forEach>
				<th>Email</th>
			</tr>


			<c:forEach items="${baseList}" var="ppmReport" varStatus="status">
				<tr>
					<td><c:out value="${status.count}"></c:out></td>
					<td><c:out value="${ppmReport.employee_id}"></c:out></td>
					<td><c:out value="${ppmReport.ce_id }"></c:out></td>
					<td><c:out value="${ppmReport.name}"></c:out></td>
					
					<td><c:out value="${ppmReport.project}"></c:out></td>
					<td><c:out value="${ppmReport.pm_id}"></c:out></td>
					<td><c:out value="${ppmReport.pm_name}"></c:out></td>
					<td><c:out value="${ppmReport.workerEndDate}"></c:out></td>
					
					<c:forEach items="${ppmReport.timePeriodMap}" var="varMap"
						varStatus="s">
						<td><c:out value="${varMap.value}"></c:out></td>
					</c:forEach>
					<td><c:out value="${ppmReport.email}"></c:out></td>
				</tr>



			</c:forEach>

		</table>
	</div>
</body>
</html>
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
<title>Duplicate Report</title>

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(document).ready(function() {
		$('.datepick').each(function() {
			$(this).datepicker({
				dateFormat : 'yy-mm-dd'
			});
		});

	});
</script>


<style>
.duplicatereportdata tr td, th {
	border: 1px solid #999;
	padding: 0.5rem;
}

.duplicatereportdata tr th {
	/* background-color: grey; */
	
}

TH {
	font-family: Arial;
	font-size: 10pt;
	height: 5px;
	background-color: lightsalmon;
}

TD {
	font-family: Arial;
	font-size: 9pt;
	padding: 3px 10px;
}
.table {
	overflow: scroll;
	height: 50%;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}
</style>


</head>
<body>
	<form:form method="post" commandName="baseForm" name="baseForm"
		action="saveduplicatereport.html">

		<h1 align="center">Duplicate Report</h1>
		<div align="center">
			<input style="font-size: 15px; padding: 6px 24px" type="submit"
				value="Save" />
		</div>
		<br />
		<!-- <table border="0" 
			style="width: 100%; height: 100%; font-size: small; font-family: arial; border: thin;"> -->
		<div align="center" class="table">
			<table border="2" id="duplicateReportTable"
				class="duplicatereportdata"
				style="width: 100%; height: 100%; border-collapse: collapse; background-color: white">

				<tr>
					<th>Select</th>
					<th>Work Assn. id</th>
					<th>Emp Id</th>
					<th>Name</th>
					<th>SOW</th>
					<th>Contractor Id</th>
					<th>Start Date</th>
					<th>End Date</th>
					<th>Project Id</th>
					<th>Project Description</th>
					<th>PM Id</th>
					<th>PM Name</th>
				</tr>


				<c:forEach items="${baseList}" var="dupReport" varStatus="status">
					<tr>
						<td><input type="checkbox"
							name="baseList[${status.index}].checked" /></td>
						<td><c:out value="${dupReport.work_assignment_id}"></c:out></td>
						<input type="hidden"
							name="baseList[${status.index}].work_assignment_id"
							value="${dupReport.work_assignment_id}" />
						<td><c:out value="${dupReport.employee_id}"></c:out></td>
						<input type="hidden" name="baseList[${status.index}].employee_id"
							value="${dupReport.employee_id}" />
						<td><c:out value="${dupReport.name}"></c:out></td>
						<td><c:out value="${dupReport.sowNumber}"></c:out></td>
						<td><c:out value="${dupReport.ce_id}"></c:out></td>
						<td><c:out value="${dupReport.workerStartDate}"></c:out></td>
						<%-- <td><input type="text"
							name="dupReport[${status.index}].workerStartDate"
							value="${dupReport.workerStartDate}" class="datepick"
							id="datepicker_[${status.index}]" readonly="readonly"
							style="border: none;" /></td>  --%>
						<%-- <td><c:out value="${dupReport.workerEndDate}"></c:out></td>  --%>
						<td><input style="padding: 3px 15px;" type="text"
							name="baseList[${status.index}].workerEndDate"
							value="${dupReport.workerEndDate}" class="datepick"
							id="datepicker_[${status.index}]" style="border: none;" /></td>
						<td><c:out value="${dupReport.project}"></c:out></td>
						<input type="hidden" name="baseList[${status.index}].project"
							value="${dupReport.project}" />
						<td><c:out value="${dupReport.description}"></c:out></td>
						<td><c:out value="${dupReport.pm_id}"></c:out></td>
						<td><c:out value="${dupReport.pm_name}"></c:out></td>
					</tr>
				</c:forEach>

			</table>
		</div>
	</form:form>
</body>
</html>
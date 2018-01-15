<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	$(document).ready(function() {
		$('#justworkerdata').DataTable({
			dom : 'Bfrtip',
			buttons : [ 'copy', 'csv', 'excel', 'pdf', 'print' ]
		});
	});
</script>

<style>
.justworkerdata tr td, th {
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
		<h2>Just Worker New Report</h2>
	</div>
	<br />
	<div class="table" align="center">
		<table id="justworkerdata" border="2" cellpadding="6px"
			class="justworkerdata"
			style="border-collapse: collapse; background-color: white; height: 100%; width: 100%">
			<thead style="background-color: lightsalmon">
				<TR style="font-weight: bold;">
					<td>Contractor ID</td>
					<td>Worker End Date</td>
					<td>Current Bill Rate [ST/Day]</td>
					<td>Current Bill Rate [ST/Hr]</td>
					<td>Current Bill Rate [ST/MO]</td>
					<td>Current Bill Rate [OT/Hr]</td>
					<td>Worker Status</td>
					<td>Worker ID</td>
					<td>Worker</td>
					<td>Work Order Status</td>
					<td>Work Order ID</td>
					<td>Latest Work Order?</td>
				</TR>
			</thead>
			<tbody id="records" style="overflow: scroll;">
				<c:forEach items="${list}" var="justworker" varStatus="i">
					<tr>
						<td>${justworker.Contractor_ID}</td>
						<td>${justworker.Worker_End_Date}</td>
						<td>${justworker.Current_Bill_Rate_day}</td>
						<td>${justworker.Current_Bill_Rate_Hr}</td>
						<td>${justworker.Current_Bill_Rate_Mo}</td>
						<td>${justworker.Current_Bill_Rate_OT_Hr}</td>
						<td>${justworker.Worker_Status}</td>
						<td>${justworker.Worker_ID}</td>
						<td>${justworker.Worker}</td>
						<td>${justworker.Work_Order_Status}</td>
						<td>${justworker.Work_Order_ID}</td>
						<td>${justworker.Latest_Work_Order}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
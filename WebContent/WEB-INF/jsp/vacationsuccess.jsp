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
		$('#vacationdata').DataTable({
			dom : 'Bfrtip',
			buttons : [ 'copy', 'csv', 'excel', 'pdf', 'print' ]
		});
	});
</script>

<style>
.vacationdata tr td, th {
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
		<h2>Vacation Details</h2>
	</div>
	<br />
	<div class="table" align="center">
		<table id="vacationdata" border="2" cellpadding="6px"
			class="vacationdata"
			style="border-collapse: collapse; background-color: white; height: 100%; width: 100%">
			<thead style="background-color: lightsalmon">
				<TR style="font-weight: bold;">
					<td>Empl_ID</td>
					<td>Name</td>
					<td>Email</td>
					<td>PTO Jan 2017</td>
					<td>PTO Feb 2017</td>
					<td>PTO Mar 2017</td>
					<td>PTO Apr 2017</td>
					<td>PTO May 2017</td>
					<td>PTO Jun 2017</td>
					<td>PTO Jul 2017</td>
					<td>PTO Aug 2017</td>
					<td>PTO Sep 2017</td>
					<td>PTO Oct 2017</td>
					<td>PTO Nov 2017</td>
					<td>PTO Dec 2017</td>
				</TR>
			</thead>
			<tbody id="records" style="overflow: scroll;">
				<c:forEach items="${list}" var="vacation" varStatus="i">
					<tr>
						<td>${vacation.employee_id}</td>
						<td>${vacation.name}</td>
						<td>${vacation.email}</td>
						<td>${vacation.pto_jan}</td>
						<td>${vacation.pto_feb}</td>
						<td>${vacation.pto_mar}</td>
						<td>${vacation.pto_apr}</td>
						<td>${vacation.pto_may}</td>
						<td>${vacation.pto_june}</td>
						<td>${vacation.pto_july}</td>
						<td>${vacation.pto_aug}</td>
						<td>${vacation.pto_sept}</td>
						<td>${vacation.pto_oct}</td>
						<td>${vacation.pto_nov}</td>
						<td>${vacation.pto_dec}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>
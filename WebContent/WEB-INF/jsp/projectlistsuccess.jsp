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
		$('#projectlistdata').DataTable({
			dom : 'Bfrtip',
			buttons : [ 'copy', 'csv', 'excel', 'pdf', 'print' ]
		});
	});
</script>

<style>
.projectlistdata tr td, th {
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
		<h2>Project List Report</h2>
	</div>
	<br />
	<div class="table" align="center">
		<table id="projectlistdata" border="2" cellpadding="6px"
			class="projectlistdata"
			style="border-collapse: collapse; background-color: white; height: 100%; width: 100%">
			<thead style="background-color: lightsalmon">
				<TR style="font-weight: bold;">
					<td>Project</td>
					<td>Description</td>
					<td>PM ID</td>
					<td>PM Name</td>
					<td>Dev/SSMO</td>
					<td>Project ID text</td>
					<td>Type</td>
					<td>AM</td>
					<td>EM</td>
					<td>SVP</td>
					<td>VP IT</td>
					<td>Forecast PoC ID</td>
					<td>SoW</td>
					<td>SoW Number</td>
					<td>Onsite PoC</td>
					<td>Offshore PoC</td>
					<td>Discount</td>
					<td>Datestamp</td>
					<td>Billing in</td>
				</TR>
			</thead>
			<tbody id="records" style="overflow: scroll;">
				<c:forEach items="${list}" var="projectlist" varStatus="i">
					<tr>
						<td>${projectlist.Project}</td>
						<td>${projectlist.Description}</td>
						<td>${projectlist.PM_ID}</td>
						<td>${projectlist.PM_Name}</td>
						<td>${projectlist.New_rate_applies}</td>
						<td>${projectlist.Project_ID_text}</td>
						<td>${projectlist.Type}</td>
						<td>${projectlist.AM}</td>
						<td>${projectlist.EM}</td>
						<td>${projectlist.SVP}</td>
						<td>${projectlist.VP_IT}</td>
						<td>${projectlist.Forecast_PoC_ID}</td>
						<td>${projectlist.SoW}</td>
						<td>${projectlist.SoW_Number}</td>
						<td>${projectlist.Onsite_PoC}</td>
						<td>${projectlist.Offshore_PoC}</td>
						<td>${projectlist.Discount}</td>
						<td>${projectlist.Datestamp}</td>
						<td>${projectlist.Billing_in}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>


</body>
</html>
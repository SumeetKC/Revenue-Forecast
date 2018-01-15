<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<style>
#export {
	background-color: #4CAF50;
	color: white;
	padding: 10px;
	font-size: 13px;
	font-family: Arial;
	border: none;
	cursor: pointer;
}

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

h2 {
	font-family: Arial;
	font-size: 25px;
}
/* TD{
width:"10%";
height:"1";
} */
</style>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/buttons/1.4.2/css/buttons.dataTables.min.css">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/buttons/1.4.2/js/dataTables.buttons.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/buttons/1.4.2/js/buttons.flash.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/pdfmake.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/vfs_fonts.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/buttons/1.4.2/js/buttons.html5.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/buttons/1.4.2/js/buttons.print.min.js"></script>



<script>
$(document).ready(function(){
    $('#basedataid').DataTable({
        dom: 'Bfrtip',
        buttons: [
            'copy', 'csv', 'excel', 'pdf', 'print'
        ]
    } );
});
</script>
</head>
<body>

	<div align="right">
		<form:form action="exportbase.html" method="post">
			<input id="export" type="submit" value="Export To Excel" />
		</form:form>
	</div>
	<h2 align="center">Base Report</h2>
	<br />
	<div align="center"><!--  style="overflow: scroll; height: 500px"> -->
		<table border="2"
			style="width: 100%; height: 100%; border-collapse: collapse; background-color: white;"
			class="basedata" id="basedataid">

			<%-- <tr>
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
				<th>Practice Name</th>
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
				<th>PTO Jan</th>
				<th>PTO Feb</th>
				<th>PTO Mar</th>
				<th>PTO Apr</th>
				<th>PTO May</th>
				<th>PTO June</th>
				<th>PTO July</th>
				<th>PTO Aug</th>
				<th>PTO Sept</th>
				<th>PTO Oct</th>
				<th>PTO Nov</th>
				<th>PTO Dec</th>
				<th>On/Off</th>
				<th>Bill Hours/Day</th>
				<th>Date_stamp</th>
				<th>Status</th>

			</tr>
			<c:forEach items="${baseList}" var="basedata">

				<c:if test="${basedata.status=='E' }">
					<c:set var="bgcolorValue" value="#FFFFFF"></c:set>
				</c:if>
				<c:if test="${basedata.status=='N' }">
					<c:set var="bgcolorValue" value="#00FF00"></c:set>
				</c:if>

				<c:if test="${basedata.status=='O' }">
					<c:set var="bgcolorValue" value="#FF0000"></c:set>
				</c:if>
				<tr bgcolor="${bgcolorValue}">
					<td height='9px'>${basedata.work_assignment_id}</td>
					<td>${basedata.employee_id}</td>
					<td>${basedata.name}</td>
					<td>${basedata.project}</td>
					<td>${basedata.description}</td>
					<td>${basedata.pm_id}</td>
					<td>${basedata.pm_name}</td>
					<td>${basedata.projectId_EmpId}</td>
					<td>${basedata.city}</td>
					<td>${basedata.country}</td>
					<td>${basedata.practice_name}</td>
					<td>${basedata.associate_billability}</td>
					<td>${basedata.AM}</td>
					<td>${basedata.sow}</td>
					<td>${basedata.sowNumber}</td>
					<td>${basedata.billing_in}</td>
					<td>${basedata.ce_id}</td>
					<td>${basedata.contractor_number}</td>
					<td>${basedata.workerStartDate}</td>
					<td>${basedata.workerEndDate}</td>
					<td>${basedata.current_Bill_Rate_ST_Hr}</td>
					<td>${basedata.pto_jan}</td>
					<td>${basedata.pto_feb}</td>
					<td>${basedata.pto_mar}</td>
					<td>${basedata.pto_apr}</td>
					<td>${basedata.pto_may}</td>
					<td>${basedata.pto_june}</td>
					<td>${basedata.pto_july}</td>
					<td>${basedata.pto_aug}</td>
					<td>${basedata.pto_sept}</td>
					<td>${basedata.pto_oct}</td>
					<td>${basedata.pto_nov}</td>
					<td>${basedata.pto_dec}</td>
					<td>${basedata.onsite_Offshore}</td>
					<td>${basedata.billing_hours_per_day}</td>
					<td>${basedata.date_stamp}</td>
					<td>${basedata.status}</td>


				</tr>
			</c:forEach>


 --%>

			<thead>
			<tr>
				<th>SNO</th>
				<th>Project Name</th>
				<th>Project Id</th>
				<th>Associate Id</th>
				<th>Status</th>
				<th>Onsite/Offshore</th>
				<th>Associate Name</th>
				<th>Practice Name</th>
				<th>City</th>
				<th>Start Date</th>
				<th>End Date</th>
				<th>Bill Rate</th>
				<th>Sow Worker Role</th>
				<th>Sow Number</th>
				<th>PTO Jan</th>
				<th>PTO Feb</th>
				<th>PTO Mar</th>
				<th>PTO Apr</th>
				<th>PTO May</th>
				<th>PTO June</th>
				<th>PTO July</th>
				<th>PTO Aug</th>
				<th>PTO Sept</th>
				<th>PTO Oct</th>
				<th>PTO Nov</th>
				<th>PTO Dec</th>
				<th>Expr1</th>
				<th>AM</th>
				<th>CE ID</th>
				<th>PM Name</th>
				<th>Actuals</th>

			</tr>
			</thead>
			<tbody>
			<c:forEach items="${baseList}" var="basedata" varStatus="i">

				<%-- 				<c:if test="${basedata.status=='E' }">
					<c:set var="bgcolorValue" value="#FFFFFF"></c:set>
				</c:if>
				<c:if test="${basedata.status=='N' }">
					<c:set var="bgcolorValue" value="#00FF00"></c:set>
				</c:if>
				<c:if test="${basedata.status=='T' }">
					<c:set var="bgcolorValue" value="#FF0000"></c:set>
				</c:if>
				<c:if test="${basedata.status!='N' }">
					<c:set var="bgcolorValue" value="#FFFFFF"></c:set>
				</c:if>
 --%>

				<c:choose>
					<c:when test="${basedata.status=='E' }">
						<c:set var="bgcolorValue" value="#FFFFFF"></c:set>
					</c:when>
					<c:when test="${basedata.status=='N' }">
						<c:set var="bgcolorValue" value="#00FF00"></c:set>
					</c:when>
					<c:when test="${basedata.status=='T' }">
						<c:set var="bgcolorValue" value="#FF0000"></c:set>
					</c:when>
					<c:otherwise>
						<c:set var="bgcolorValue" value="#FFFFFF"></c:set>
					</c:otherwise>
				</c:choose>


				<tr bgcolor="${bgcolorValue}">
					<td>${i.count}</td>
					<td>${basedata.description}</td>
					<td>${basedata.project}</td>
					<td>${basedata.employee_id}</td>
					<td>${basedata.status}</td>
					<td>${basedata.onsite_Offshore}</td>
					<td>${basedata.name}</td>
					<td>${basedata.practice_name}</td>
					<td>${basedata.city}</td>
					<td>${basedata.workerStartDate}</td>
					<c:choose>
						<c:when test="${empty basedata.workerEndDate}">
							<td>${basedata.sowEndDate}</td>
						</c:when>
						<c:otherwise>
							<td>${basedata.workerEndDate}</td>
						</c:otherwise>
					</c:choose>

					<c:choose>
						<c:when test="${empty basedata.current_Bill_Rate_ST_Hr}">
							<td>${basedata.sowBillRate}</td>
						</c:when>
						<c:otherwise>
							<td>${basedata.current_Bill_Rate_ST_Hr}</td>
						</c:otherwise>
					</c:choose>
					<td>${basedata.sow}</td>
					<td>${basedata.sowNumber}</td>
					<td>${basedata.pto_jan}</td>
					<td>${basedata.pto_feb}</td>
					<td>${basedata.pto_mar}</td>
					<td>${basedata.pto_apr}</td>
					<td>${basedata.pto_may}</td>
					<td>${basedata.pto_june}</td>
					<td>${basedata.pto_july}</td>
					<td>${basedata.pto_aug}</td>
					<td>${basedata.pto_sept}</td>
					<td>${basedata.pto_oct}</td>
					<td>${basedata.pto_nov}</td>
					<td>${basedata.pto_dec}</td>
					<td>${basedata.date_stamp}</td>
					<td>${basedata.AM}</td>
					<td>${basedata.ce_id}</td>
					<td>${basedata.pm_name}</td>
					<td></td>

				</tr>
			</c:forEach>

		</tbody>
		</table>

	</div>
</body>
</html>
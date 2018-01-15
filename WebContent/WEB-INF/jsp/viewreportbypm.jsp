<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"
	integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
	crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>
.basedata tr td, th {
	border: 1px solid #999;
	padding: 0.5rem;
}

.basedata tr th {
	/* background-color: lightsalmon; */
	
}

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
/* TD{
width:"10%";
height:"1";
} */
select {
	width: 300px;
	height: 35px;
	margin: 8px 0;
	border: 2px solid grey;
	padding: 6px 10px;
}

.table {
	overflow: scroll;
	height: 500px;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		/* function setOption(var pmid){
			$('#pms').find('option:selected').prop("selected", false);
			$('#pms option[value='+pmid+']').prop('selected', true);
		} */
		$("#pms").change(function() {

			if ($("#pms").val() == "") {
				alert("Not Valid Project Manager");
				return false;
			} else {
				//$("#pmreportform").attr('action','showreportbypm.html?pm='+$("#pms").val());
				$("#pmreportform").submit();
			}

		});

	});
</script>
</head>
<body>
	<div align="center">
		<form method="post" action="showreportbypm.html" id="pmreportform">
			<!-- target="resframe" -->
			<h2>Project Manager Wise Report</h2>
			<select name="pms" id="pms">
				<option value="">----Select----</option>
				<c:forEach var="pms" items="${pms}">
					<option value="${pms.key}">${pms.key}-${pms.value}</option>
				</c:forEach>

			</select>

			<c:if test="${not empty basedata}">
				<h3>Project Manager ID: ${pmid}</h3>
				<div align="center" class="table">
					<table border="2"
						style="width: 100%; height: 100%; border-collapse: collapse; background-color: white">
						<tr>
							<th>Work Asnm. Id</th>
							<th>Employee id</th>
							<th>Name</th>
							<th>Project Id</th>
							<th>Project Description</th>
							<th>PM Id</th>
							<th>PM Name</th>
							<th>City</th>
							<th>Country</th>
							<th>Ass.Billability</th>
							<th>Act.Manager</th>
							<th>SOW No</th>
							<th>Billing In</th>
						</tr>
						<c:forEach items="${basedata}" var="baselist">
							<tr>
								<td>${baselist.work_assignment_id}</td>
								<td>${baselist.employee_id}</td>
								<td>${baselist.name}</td>
								<td>${baselist.project}</td>
								<td>${baselist.description}</td>
								<td style="background-color: #00FF00">${baselist.pm_id}</td>
								<td style="background-color: #00FF00">${baselist.pm_name}</td>
								<%-- <td>${baselist.projectId_EmpId}</td> --%>
								<td>${baselist.city}</td>
								<td>${baselist.country}</td>
								<td>${baselist.associate_billability}</td>
								<td>${baselist.AM}</td>
								<%-- <td>${baselist.sow}</td> --%>
								<td>${baselist.sowNumber}</td>
								<td>${baselist.billing_in}</td>

							</tr>

						</c:forEach>

					</table>
				</div>
			</c:if>
		</form>
	</div>
	<!-- <iframe name="resframe" style="width:100%;height:100%;">


</iframe> -->
</body>
</html>
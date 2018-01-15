<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<!-- <script type="text/javascript">
	$(document).ready(function() {
		$(".datestamp").datepicker({
			changeMonth : true,
			changeYear : true,
			dateFormat : 'yy-mm'
		});

	});
</script> -->
</head>
<body>
	<div align="center">
		<!-- 	<form id="generatebaseform" action="generatebasefile.html"
			method="post">
			<input style="padding: 6px 24px; font-size: 15px" type="text"
				name="datestamp" id="datestamp" required> <input
				style="font-size: 15px; padding: 6px 10px;" type="submit"
				value="Generate Base Sheet">
		</form> -->
		<table>

			<form id="generatebaseform" action="generatenewemployees.html" method="post">
				<tr>
					<!-- <td><input style="padding: 6px 24px; font-size: 15px"
						type="text" name="datestamp" placeholder="Enter Date"
						class="datestamp" required></td> -->
					<td><input style="font-size: 15px; padding: 6px 10px;"
						type="submit" value="Generate New Added Employees"></td>
				</tr>
			</form>


			<form id="generatebaseform" action="generatebasefile.html"
				method="post">
				<tr>
					<!-- <td><input style="padding: 6px 24px; font-size: 15px"
						type="text" name="datestamp" placeholder="Enter Date"
						class="datestamp" required></td> -->
					<td><input style="font-size: 15px; padding: 6px 10px;"
						type="submit" value="Generate Final Base Sheet"></td>
				</tr>
			</form>
		</table>
	</div>

	<%-- <div align="center">
		<form action="saveContractor.html" method="post"
			name="employeemappingform" modelAttribute="newEmployees">
			<table>
				<tr>
					<th>Associate ID</th>
					<th>Associate Name</th>
					<!-- <th>Contractor ID</th> -->
				</tr>
				<c:forEach var="employees" items="${newEmployees}" varStatus="index">
					<tr>
						<td>${employees.key}</td>
						<td>${employees.value}</td>
						<td><input name="empContratMap['${employees.key}']" style="padding: 4px 15px; font-size: 15px" type="text" /></td>
					</tr>
				</c:forEach>
				<!-- <tr><td colspan="3" align="center"><input style="font-size: 15px; padding: 6px 10px;" type="submit" value="Save Contractor Details" /></td></tr> -->
			</table>
		</form>

		<div align="center"><p style="color:red; font-size: 18px" >Please fill the Contractor ID for the
			corresponding Employees and upload the EsaVsContractor sheet here....<a href="view_up_evcis.html">Upload EsaVsContarctor Sheet</a></p></div>


	</div> --%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<style type="text/css">
#upload {
	background-color: #4CAF50;
	color: white;
	padding: 10px;
	font-size: 15px;
	font-family: Arial;
	border: none;
	cursor: pointer;
}
</style>
</head>
<body>
	<jsp:include page="generatebase.jsp" />

	<div align="center">
		<form action="saveContractor.html" method="post"
			name="employeemappingform" modelAttribute="newEmployees">
			<table>
				<tr>
					<th>Associate ID</th>
					<th>Associate Name</th>
					<!-- <th>Contractor ID</th> -->
				</tr>
				<c:forEach var="employees" items="${newEmployees}">
					<tr>
						<td>${employees.key}</td>
						<td>${employees.value}</td>
						<%-- <td><input name="empContratMap['${employees.key}']" style="padding: 4px 15px; font-size: 15px" type="text" /></td> --%>
					</tr>
				</c:forEach>
				<!-- <tr><td colspan="3" align="center"><input style="font-size: 15px; padding: 6px 10px;" type="submit" value="Save Contractor Details" /></td></tr> -->
			</table>
		</form>

		<div align="center">
			<p style="color: red; font-size: 18px">
				Please fill the Contractor ID for the corresponding Employees and
				upload the EsaVsContractor sheet here....<a id="upload"
					href="view_up_evcis.html">Upload EsaVsContarctor Sheet</a>
			</p>
		</div>

	</div>
</body>
</html>
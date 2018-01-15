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
<style type="text/css">
td {
	font-family: Arial;
	font-size: 9pt;
	padding: 6px 10px;
}

th {
	font-family: Arial;
	font-size: 10pt;
	height: 5px;
	background-color: lightsalmon;
}
</style>
</head>
<body>
	<form:form name="updateproject" id="updateproject"
		commandName="saveprojectdetails" action="saveproject.html">

		<h2 align="center">Update Project Details</h2>
		<table border="2"
			style="background-color: white">
			<tr>
				<th>Project</th>
				<th>Description</th>
				<th>PM ID</th>
				<th>PM Name</th>
			</tr>


			<tr>

				<td><input name="project" type="text" value="${project}"
					readonly="readonly" /></td>
				<td><input name="description" type="text"
					value="${description}" /></td>
				<td><input name="pmID" type="text" value="${pmID}" /></td>
				<td><input name="pmName" type="text" value="${pmName}" /></td>


			</tr>
			<tr>
				<th>new_rate_applies</th>
				<th>project_ID_text</th>
				<th>type</th>
				<th>Account Manager</th>
			</tr>
			<tr>

				<td><input name="new_rate_applies" type="text"
					value="${new_rate_applies}" /></td>
				<td><input name="project_ID_text" type="text"
					value="${project_ID_text}" /></td>
				<td><input name="type" type="text" value="${type}" /></td>
				<td><input name="am" type="text" value="${am}" /></td>


			</tr>

		</table>
		<input type="submit" value="Save"
			onclick="window.close();return true;" />
		<input type="submit" value="Cancel"
			onclick="window.close();return false;   " />
	</form:form>
</body>
</html>
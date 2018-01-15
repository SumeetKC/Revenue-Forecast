<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript">
	function popup(projectid) {

		myWindow = window.open('updateproject.html?projectid=' + projectid,
				'updateproject', 'width=800,height=400');

	}

	function addProject() {
		addProjectWindow = window.open('addnewproject.html', 'addnewproject',
				'width=850,height=450');
	}
</script>
<style>
thead {
	background-color: lightsalmon;
	font-family: Arial;
	font-size: 10pt;
}

.table {
	overflow: auto;
	height: 500px;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}

input[type=submit] {
	background-color: #4CAF50;
	color: white;
	padding: 10px;
	font-size: 13px;
	font-family: Arial;
	border: none;
	cursor: pointer;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:out value="${projectExistInDB}"></c:out>
	<div align="center">
		<form:form name="projectform" id="projectform">
			<input style="font-size: 15px; padding: 6px 15px;" type="submit"
				value="Add New Project" onclick="addProject()" />
		</form:form>
	</div>
	<br />
	<div class="table">
		<table align="center" cellpadding="7px" border="2"
			style="background-color: white; border-collapse: collapse; font-family: Arial; font-size: 12pt; height: 100%; width: 100%">
			<thead>
				<tr>
					<td>Project</td>
					<td>Description</td>
					<td>PM ID</td>
					<td>PM Name</td>
				</tr>
			</thead>
			<c:forEach items="${projects.proj}" var="p" varStatus="status">
				<tbody>
					<tr>
						<td><a href="#" onclick="popup('${p.project}')">${p.project}</a></td>
						<!-- onclick="popup('${p.project}')"  -->
						<%-- <td><input type="text" value="${p.project}" onclick="popup('${p.project}')" /></td> --%>
						<td>${p.description}</td>
						<td>${p.pmID}</td>
						<td>${p.pmName}</td>

						<%-- <td><input name="proj[${status.index}].description" value="${p.description}"/></td>
			<td><input name="proj[${status.index}].pmID" value="${p.pmID}"/></td>
			<td><input name="proj[${status.index}].pmName" value="${p.pmName}"/></td> --%>
					</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>


</body>
</html>
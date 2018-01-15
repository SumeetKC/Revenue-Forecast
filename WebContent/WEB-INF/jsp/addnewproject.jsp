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
<script type="text/javascript">
	function formSubmit() {
		document.getElementById("addnewproject").submit();
		//window.parent.opener.location.reload(true);
		window.close();
		return false;
	}

	function pmNameChange() {
		var name = document.getElementById("PM_IDs").value;
		document.getElementById("pmName").value = name;

	}
</script>
</head>
<body>
	<form name="addnewproject" id="addnewproject" method="post"
		action="addNewProjectDetails.html">


		<h2 align="center">Add New Project</h2>
		<h3>${projectExistInDB }</h3>
		<table align="center" cellpadding="8px" border="2"
		style="background-color: white; border-collapse: collapse;">
			<tr style="background-color: lightsalmon">
				<td>Project</td>
				<td>Description</td>
				<td>PM ID</td>
				<td>PM Name</td>
			</tr>

			<tr>

				<td><input name="project" type="text" value="${project}" /></td>
				<td><input name="description" type="text"
					value="${description}" /></td>
				<td><select name="PM_IDs" id="PM_IDs" onchange="pmNameChange()">
						<option value="">---Select---</option>
						<c:forEach items="${pms}" var="pmID">
							<option value="${pmID.value }">${pmID.key}</option>
						</c:forEach>
				</select> <%-- <input name="pmID" type="text" value="${pmID}" /> --%></td>
				<td><input name="pmName" id="pmName" type="text" <%-- value="${pmName}" --%> /></td>

			</tr>
			<tr>
				<td>New Rate Applies</td>
				<td>Project ID text</td>
				<td>Type</td>
				<td>Account Manager</td>
			</tr>
			<tr>

				<td><input name="new_rate_applies" type="text"
					value="${new_rate_applies}" /></td>
				<td><input name="project_ID_text" type="text"
					value="${project_ID_text}" /></td>
				<td><input name="type" type="text" value="${type}" /></td>
				<td><input name="am" type="text" value="${am}" /></td>


			</tr>

			<tr>
				<td>EM</td>
				<td>SVP</td>
				<td>VP IT</td>
				<td>Forecast PoC ID</td>
			</tr>

			<tr>
				<td><input name="em" type="text" value="${em}" /></td>
				<td><input name="svp" type="text" value="${svp}" /></td>
				<td><input name="vpit" type="text" value="${vpit}" /></td>
				<td><input name="forecastPoCID" type="text"
					value="${forecastPoCID}" /></td>
			</tr>


			<tr>
				<td>SOW</td>
				<td>SoW Number</td>
				<td>Onsite PoC</td>
				<td>Offshore PoC</td>
			</tr>

			<tr>
				<td><input name="soW" type="text" value="${soW}" /></td>
				<td><input name="soW_Number" type="text" value="${soW_Number}" /></td>
				<td><input name="onsitePoC" type="text" value="${onsitePoC}" /></td>
				<td><input name="offshorePoC" type="text"
					value="${offshorePoC}" /></td>
			</tr>

			<tr>
				<td>Discount</td>
				<td>Datestamp</td>
				<td>Billing in</td>
			</tr>

			<tr>
				<td><input name="discount" type="text" value="${discount}" /></td>
				<td><input name="datestamp" type="text" value="${datestamp}" /></td>
				<td><input name="billingin" type="text" value="${billingin}" /></td>
			</tr>


		</table>
		<input type="button" value="Save" onclick="formSubmit()" />
		<!-- onclick="window.close();return true;" -->
		<!-- onclick="window.close();return true;" -->

		<input type="submit" value="Cancel"
			onclick="window.close();return false;   " />
	</form>
</body>
</html>
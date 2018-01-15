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
$(document).ready(function(){
    $('#ppmReportdata').DataTable({
        dom: 'Bfrtip',
        buttons: [
            'copy', 'csv', 'excel', 'pdf', 'print'
        ]
    } );
});
</script>


<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$(".enddatebypm").datepicker({dateFormat:'yy-mm-dd'});
		
		
		$("#pms").change(function(){
			//alert($("#pms").val())
			if($("#pms").val()==""){
				alert("Not Valid Project Manager");
				$("#records").empty();
				return false;
			}/* else if($("#project").val()==""){
				alert("Not Valid Project ID");
				$("#records").empty();
				return false;
			} */else{
				//document.pmform.action = "selectedpm.html";
				$("#pmform").submit();
				/* document.ppmActualsForm.method = "post";
				document.ppmActualsForm.action = "selectedpm";
				document.ppmActualsForm.submit; */
			}
			
		});
		$("#project").change(function(){
			//alert($("#pms").val())
			if($("#project").val()==""){
				alert("Not Valid Project ID");
				$("#records").empty();
				return false;
			}else if($("#pms").val()==""){
				alert("Not Valid Project Manager");
				$("#records").empty();
				return false;
			}else{
				//document.pmform.action = "selectedpm.html";
				$("#projectform").submit();
				/* document.ppmActualsForm.method = "post";
				document.ppmActualsForm.action = "selectedpm";
				document.ppmActualsForm.submit; */
			}
			
		});
		
	});
	</script>
<script type="text/javascript">
	function isNumberKey(evt){
	    var charCode = (evt.which) ? evt.which : event.keyCode
	    if(charCode == 46)
	    	return true;
	    else if (charCode > 31 && (charCode < 48 || charCode > 57))
	    	return false;
	    else
	    	return true;
	}
	
	</script>


<style>
.ppmReportdata tr td, th {
	border: 1px solid #999;
}

/* .ppmReportdata tr th {
	background-color: grey;
} */
TD {
	font-family: Arial;
	font-size: 9pt;
}
/* 
TH {
	font-family: Arial;
	font-size: 9pt;
	height: 5px;
} */
/* TR {
	 font-family: Arial;
	 
} */
#export, input[type=submit] {
	background-color: #4CAF50;
	color: white;
	padding: 10px;
	font-size: 13px;
	font-family: Arial;
	border: none;
	cursor: pointer;
}

select {
	width: 200px;
	height: 30px;
	border: 2px solid grey;
}

input[type=text] {
	/* width: 100px;
	height: 10px; */
	padding: 10px 4px;
	box-sizing: border-box;
	border: 1px solid grey;
	border-radius: 3px;
}

h3 {
	font-family: Arial;
	font-size: 16px;
}

/* tbody {
    display:block;
    overflow:auto;
}
thead, tbody tr {
    display:table;
    width:100%;
    table-layout:fixed;/* even columns width , fix width of table too*/
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

	<div class="mainDiv">

		<div align="right">
			<form:form action="export.html" method="post">
				<input id="export" type="submit" value="Export To Excel" />
			</form:form>
			<br />
		</div>

		<h2 align="center" style="font-family: Arial;">PPM Actuals Sheet</h2>
		<h3 align="center" style="font-family: Arial; color: green">${statusMessage}</h3>

		<table cellpadding="10">
			<tr>
				<form:form name="pmform" id="pmform" method="post"
					action="selectedpm.html">
					<!--  commandName="pmdetails" -->

					<td><h3>Select Project Manager:</h3></td>
					<td><select name="pms" id="pms" path="pms">
							<option value="">---Select---</option>
							<c:forEach var="pms" items="${pms}">
								<option value="${pms.key}"
									${pms.key == sessionScope.selectedPM ? 'selected' : ''}>${pms.key}
									- ${pms.value}</option>

							</c:forEach>
					</select></td>
				</form:form>


				<form:form name="projectform" id="projectform" method="post"
					action="ppmactualsProjectPM.html">
					<td><h3>Select Project:</h3></td>
					<td><select name="project" id="project" path="project">
							<option value="">---Select---</option>
							<c:forEach var="projDetail" items="${projDetails}">
								<option value="${projDetail.key}"
									${projDetail.key == sessionScope.selProject ? 'selected' : ''}>${projDetail.key}
									- ${projDetail.value}</option>
							</c:forEach>
					</select></td>
					<br />
					<br />
				</form:form>
			</tr>
		</table>
		<%-- <form:form name="projform"  id="projform" action="selectedproj.html" method="post" commandName="projdetails" >
Select Project:    
<select name="project" id="project" path="project" >
<option value="">-Select-</option>
<c:forEach var="projDetail" items="${projDetails}">
   <option value="${projDetail.key}">${projDetail.key} - ${projDetail.value}</option>
</c:forEach>

</select>


</form:form> --%>
		<%--<form:form name="ppmActualsForm"  id="ppmActualsForm" commandName="ppmActualsList" action="savePPMActuals.html"  method="post">

 Select Project:    
<select name="project" id="project" path="project" >
<option value="">-Select-</option>
<c:forEach var="projDetail" items="${projDetails}">
   <option value="${projDetail.key}">${projDetail.key} - ${projDetail.value}</option>
</c:forEach>

</select>


<br/>
<br/>
<input type="submit"  value="Submit" align="right" /> 
</form:form>--%>

		<form:form name="ppmActualsForm" id="ppmActualsForm"
			commandName="ppmActualsList" action="savePPMActuals.html"
			method="post">
			<div class="table" align="center">
				<table id="ppmReportdata" border="2" cellpadding="6px" class="ppmReportdata"
					style="border-collapse: collapse; background-color: white; height: 100%; width: 100%">
					<thead style="background-color: lightsalmon">
						<TR style="font-weight: bold;">
							<td>SNo</td>
							<td>Project Description</TD>
							<td>Project</TD>
							<td>Employee Id</TD>
							<td>Onsite/Offshore</TD>
							<td>Name</TD>
							<td>Account Manager</TD>
							<td>CeId</TD>
							<td>PM ID</TD>
							<td>PM Name</TD>
							<td>Worker Start Date</td>
							<td>Worker End Date</TD>
							<td>Worker End Date by PM</TD>
							<td>SoW Role</td>
							<td>SoW Number</TD>
							<td>Bill Rate</td>
							<td>Bill Rate by PM</td>
							<td>PPM Actuals</TD>
							<td>PPM Actuals by PM</TD>

						</TR>
					</thead>
					<tbody id="records" style="overflow: scroll;">
						<c:forEach items="${ppmActualsList.ppmActuals}"
							var="ppmactVariable" varStatus="i">
							<tr>
								<td>${i.count}</td>
								<td>${ppmactVariable.description}</td>
								<td>${ppmactVariable.project}</td>
								<td>${ppmactVariable.employee_id}</td>
								<td>${ppmactVariable.onsite_offshore}</td>
								<td>${ppmactVariable.name}</td>
								<td>${ppmactVariable.am}</td>
								<td>${ppmactVariable.ce_id}</td>
								<td>${ppmactVariable.pm_id}</td>
								<td>${ppmactVariable.pm_name}</td>
								<td>${ppmactVariable.workerStartDate}</td>
								<td>${ppmactVariable.workerEndDate}</td>
								<td><input type="text"
									name="ppmActuals[${i.index}].enddatebypm" class="enddatebypm"
									id="ppmActuals.[${i.index}].enddatebypm"
									value="${ppmactVariable.enddatebypm}" path="enddatebypm" /></td>
								<td>${ppmactVariable.sow}</td>
								<td>${ppmactVariable.sowNumber}</td>
								<td>${ppmactVariable.current_Bill_Rate_ST_Hr}</td>
								<td><input type="text" value="${ppmactVariable.ratebypm}"
									id="ratebypm" name="ppmActuals[${i.index}].ratebypm"
									path="ratebypm" onkeypress="return isNumberKey(event)" /></td>
								<td>${ppmactVariable.ppmactuals}</td>
								<td><input type="text"
									value="${ppmactVariable.ppmhoursbypm}" id="ppmhoursbypm"
									name="ppmActuals[${i.index}].ppmhoursbypm" path="ppmhoursbypm"
									onkeypress="return isNumberKey(event)" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<br />
			<div align="center">
				<input style="font-size: 15px; padding: 6px 24px;" type="submit"
					value="Save" align="right" />
			</div>
		</form:form>


	</div>
</body>
</html>
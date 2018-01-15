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
.tablikelink {
	margin-right:5px;
	color: white;
	background-color: #4CAF50;
	padding:8px;
	font-size: 12px;
	font-family: "Segoe UI";
}
#export {
	background-color: #4CAF50;
	color: white;
	padding: 10px;
	font-size: 13px;
	font-family: "Segoe UI";
	border: none;
	cursor: pointer;
}

.userdata tr td, th {
	border: 1px solid #999;
	padding: 0.5rem;
}

.userdata tr th {
	background-color: lightsalmon;
}

TD {
	font-family:  "Segoe UI";
	font-size: 10pt;
}

TH {
	font-family:  "Segoe UI";
	font-size: 12pt;
	height: 5px;
}

h2 {
	font-family:  "Segoe UI";
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
    $('#userdataid').DataTable({
        dom: 'Bfrtip',
        buttons: [
            'copy', 'csv', 'excel', 'pdf', 'print'
        ]
    } );
	
	/* $(".tablikelink").click(function (){
		
		var action=$(this).html();
		var ids=$(this).parent('td').parent('tr').children(':nth-child(2)').html();
		alert(ids+" "+action);
		
		$.post("updateuserstatus.html",
			    {
	        eid: ids ,
	        action: action
	    },
	    function(data, status){
	        alert("Data: " + data + "\nStatus: " + status);
	    }); 
		
	}); */
});
</script>
</head>
<body>

	
	<h2 align="center">User List</h2>
	<br />
	<div align="center"><!--  style="overflow: scroll; height: 500px"> -->
		<table border="2"
			style="width: 100%; height: 100%; border-collapse: collapse; background-color: white;"
			class="userdata" id="userdataid">

			<thead>
			<tr>
				<th>Sr.No.</th>
				<th>User ID</th>
				<th>Name(First Name,Last Name)</th>
				<th>Mobile Number</th>
				<th>Location</th>
				<th>Role</th>
				<th>Approval Status</th>
				<th>Approve / Reject / Remove</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${userList}" var="userdata" varStatus="i">
				<tr bgcolor="${bgcolorValue}">
					<td>${i.count}</td>
					<td>${userdata.user_id}</td>
					<td>${userdata.first_name},${userdata.last_name}</td>
					<td>${userdata.mobile_number}</td>
					<td>${userdata.location}</td>
					<td>
						<c:choose>
							<c:when test="${userdata.role=='A'}">
								Admin
							</c:when>
							<c:when test="${userdata.role=='M'}">
								Manager
							</c:when>
							<c:otherwise>
								NOT DEFINED ROLE
							</c:otherwise>
						</c:choose>
					<td>${userdata.approval_status}</td>
					<td align="center">
						<select id="approval_status" <%-- ${userdata.approval_status=='PENDING'? 'style="background-color:YELLOW;"' : 'style="background-color:#4CAF50;"' } --%>>
							<option value="${userdata.approval_status}" ${userdata.approval_status=='PENDING'? 'style="background-color:YELLOW;" selected' : '' }>PENDING</option>
							<option value="${userdata.approval_status}" ${userdata.approval_status=='APPROVED'? 'style="background-color:#4CAF50;" selected' : '' }>APPROVED</option>
						</select>
						
					</td>
				</tr>
			</c:forEach>

		</tbody>
		</table>

	</div>
</body>
</html>
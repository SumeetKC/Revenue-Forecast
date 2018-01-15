<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script
	src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		$("#passform").validate({

			rules : {
				currentPass : "required",
				newPass : {
					required : true,
					minlength : 6
				},
				cnfrmPass : {
					required : true,
					minlength : 6,
					equalTo : "#newPass"
				}
			},

			messages : {
				currentPass : "Please Enter Current Password",
				newPass : {
					required : "Please Enter New Password",
					minlength : "Password should be of atleast 6 digits"
				},
				cnfrmPass : {
					required : "Please Confirm Password",
					equalTo : "Password Mismatch"

				}
			},

			submitHandler : function(form) {
				form.submit();
			}

		})
	});
</script>


<style type="text/css">
h2 {
	font-family: Arial;
}

input[type=text], [type=password] {
	/* width: 100px;
	height: 10px; */
	padding: 6px 6px;
	box-sizing: border-box;
	border: 1px solid grey;
	border-radius: 4px;
}

.btn {
	background-color: #4CAF50;
	padding: 8px 10px;
	font-size: 17px;
	font-family: Arial;
	border: none;
	border-radius: 5px;
	cursor: auto;
}

sup, label {
	color: red;
}
</style>

</head>
<body>
	<div align="center">
		<h2>Change Password</h2>
		<br/>
		<span style="color: red;">${message}</span>
		<form method="post" action="savechangepass.html" name="passform"
			id="passform">
			<table cellpadding="8px">
				<tr>
					<td>Enter Current Password<sup> *</sup></td>
					<td><input type="password" name="currentPass" id="currentPass"
						Placeholder="Enter Current Password" /></td>
				</tr>
				<tr>
					<td>Enter New Password<sup> *</sup></td>
					<td><input type="password" name="newPass" id="newPass"
						Placeholder="Enter Password" /></td>
				</tr>
				<tr>
					<td>Confirm Password<sup> *</sup></td>
					<td><input type="password" name="cnfrmPass" id="cnfrmPass"
						Placeholder="Confirm Password" autocomplete="off" /></td>
				</tr>
				<tr>

					<td align="center" colspan="2"><input class="btn"
						type="submit" value="Change Password" />
				</tr>
			</table>
		</form>
	</div>
	<div style="color: red;">* fields are mandatory</div>
</body>
</html>
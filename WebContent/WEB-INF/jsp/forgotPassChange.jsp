<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script
	src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		$("#forgotPass").validate({

			rules : {
				user_Id : {
					required : true,
					number : true
				},
				password : {
					required : true,
					minlength : 6
				},
				cnfrmPass : {
					required : true,
					equalTo : "#password"
				},
				token : {
					required : true,
					number : true
				}
			},

			messages : {
				user_Id : {
					required : "Please Enter User ID",
					number : "Please Enter Digits Only"
				},
				password : {
					required : "Please Enter New Password",
					minlength : "Password should be of atleast 6 digits"
				},
				cnfrmPass : {
					required : "Please Confirm Password",
					equalTo : "Password Mismatch"
				},
				token : {
					required : "Please Enter the Token",
					number : "Please Enter Digits Only"
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
	padding: 7px 15px;
	font-size: 17px;
	font-family: Arial;
	border: none;
	border-radius: 5px;
	cursor: auto;
}

label, sup {
	color: red;
}
</style>

</head>
<body>
	<div align="center">
		<h2>Generate Password</h2>
		<span style="color: red;">${message}</span> <br />
		<form method="post" action="saveforgotpass.html" name="forgotPass"
			id="forgotPass">
			<table cellpadding="6px">
				<tr>
					<td>Enter User ID<sup> *</sup></td>
					<td><input type="text" name="user_Id" id="user_Id"
						value="${user_Id}" Placeholder="Enter User ID" /></td>
				</tr>
				<tr>
					<td>Enter New Password<sup> *</sup></td>
					<td><input type="password" name="password" id="password"
						Placeholder="Enter New Password" /></td>
				</tr>
				<tr>
					<td>Confirm Password<sup> *</sup></td>
					<td><input type="password" name="cnfrmPass" id="cnfrmPass"
						Placeholder="Confirm Password" autocomplete="off" /></td>
				</tr>
				<tr>
					<td>Enter Token<sup> *</sup></td>
					<td><input type="text" name="token" id="token"
						Placeholder="Enter Token" /></td>
				</tr>
			</table>
			<input type="submit" class="btn" value="Change Password" />
		</form>
	</div>
	<div style="color: red;">* fields are mandatory</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
	integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ"
	crossorigin="anonymous">

<link rel="stylesheet" type="text/css" href="Style.css">
<script
	src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#loginForm").validate({

			rules : {
				user_id : {
					required : true,
					number : true
				},
				password : {
					required : true,
					minlength : 6
				}
			},

			messages : {
				user_id : {
					required : "Please Enter User ID",
					number : "Please Enter Digits Only"
				},
				password : {
					required : "Please Enter Password",
					minlength : "Password should be of atleast 6 digits"
				}
			},

			submitHandler : function(form) {
				form.submit();
			}

		})
	});
</script>
<style type="text/css">
.btn {
	background-color: #4CAF50;
	padding: 10px 20px;
	font-size: 17px;
	font-family: Arial;
	border: none;
	border-radius: 5px;
	cursor: auto;
}

input[type=text], [type=password] {
	/* width: 100px;
	height: 10px; */
	padding: 6px 6px;
	box-sizing: border-box;
	border: 1px solid grey;
	border-radius: 4px;
}
.logintable td {
	color: blue;
}

label {
	color: red;
}
</style>
</head>
<body>
	<!-- <div class="jumbotron text-center" style="background:linear-gradient(141deg, #0fb8ad 0%, #1fc8db 51%, #2cb5e8 75%)">
		<h1>Revenue Forecast</h1>
	</div> -->

	<div>
		<h4 align="center">
			Login with your credentials or <small><a
				href="registerform.html" style="text-decoration: blink; color: red">SignUp
					Here</a></small>
		</h4>
		<form name="loginForm" method="POST" commandName="loginForm" id="loginForm"
			autocomplete="off">
			<!--  action="login.html"-->

			<div align="center">
				<table cellpadding="10px" class="logintable">
					<tr>
						<td colspan="3" style="color: red">${msg}</td>
					</tr>
					<tr style="color: blue;">
						<td>User ID</td>
						<td><input type="text" name="user_id" id="user_id"
							placeholder="User Id" /></td>
					</tr>
					<tr style="color: blue;">
						<td>Password</td>
						<td><input type="password" name="password"
							placeholder="Password" /></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td><input class="btn" type="submit" value="Log In" /></td>

					</tr>
				</table>

			</div>

		</form>

		<div align="center">
			<form action="forgotPassView.html" method="post" name="forgotForm"
				id="forgotForm">
				<!-- <input type="hidden" id="hiddenId" /> -->
				<h5>
					Forgot Password ? <input class="btn" type="submit"
						value="Click Here" />
				</h5>
			</form>
		</div>
	</div>

	<!-- <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script> -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"
		integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"
		integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn"
		crossorigin="anonymous"></script>

</body>
</html>
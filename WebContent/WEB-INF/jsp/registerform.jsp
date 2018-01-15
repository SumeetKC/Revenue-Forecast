<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Register Here...</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
	integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ"
	crossorigin="anonymous">
<script type="text/javascript">
 $(document).ready(function(){
	 
	 
	 $("#user_id").keypress(function (e) {
	     //if the letter is not digit then display error and don't type anything
	     if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
	        //display error message
	        $("#errmsg").html("Digits Only").fadeIn('slow').fadeOut('slow');
	               return false;
	    }
	 });
	
 });
 
 function validateForm(){
	 
	 var urdid = document.getElementById('userid').value;
	 if(urdid!=''){
		 document.loginForm.method = "post";
		 document.loginForm.action = "doLogin.html";
		 document.loginForm.submit;	 
	 }else{
		 alert("Please enter valid credentials ..");
	 }
	 
 }
 </script>
<link rel="stylesheet" type="text/css" href="Style.css">
<style type="text/css">
label {
	font-weight: bold;
	color: blue;
}

input[type=text], input[type=password] {
	/* width: 100px;
	height: 10px; */
	padding: 6px 8px;
	box-sizing: border-box;
	border: 1px solid grey;
	border-radius: 3px;
}

.btn {
	background-color: #4CAF50;
	padding: 8px;
	font-size: 17px;
	font-family: Arial;
	border: none;
	border-radius: 5px;
	cursor: default;
}

sup {
	color: red;
	font-size: 13px;
}
</style>
</head>
<body>
	<!-- <div class="jumbotron text-center" style="background:linear-gradient(141deg, #0fb8ad 0%, #1fc8db 51%, #2cb5e8 75%)">
		<h1>Revenue Forecast</h1>
	</div> -->

	<div>
		<h4 align="center">
			Register with your details or <small><a href="doLogin.html"
				style="text-decoration: blink; color: red">Login Here</a></small>
		</h4>
		<hr />

		<form name="registerform" method="POST" commandName="registerform"
			action="signupprocess.html" autocomplete="off">
			<!--  action="login.html"-->

			<div align="center">
				<table cellpadding="6">
					<tr>
						<td colspan="3" style="color: red">${msg}</td>
						<td><span id="errmsg" style="color: red"></span></td>
					</tr>
					<tr style="color: blue">
						<td>User ID<sup>*</sup></td>
						<td><input type="text" name="user_id" id="user_id"
							placeholder="User ID" required /></td>
						<!-- <td><span id="errmsg" style="color: red"></span></td> -->
						<!--  onblur="validateUserId()"  -->
						<td>First Name<sup>*</sup></td>
						<td><input type="text" name="first_name" id="first_name"
							placeholder="First Name" required /></td>
						<td>Last Name</td>
						<td><input type="text" name="last_name" id="last_name"
							placeholder="Last Name" /></td>

					</tr>
					<tr style="color: blue">
						<td>Enter new Password<sup>*</sup></td>
						<td><input type="password" name="password"
							placeholder="Enter Password" required /></td>
						<td>Confirm Password<sup>*</sup></td>
						<td><input type="password" name="confirm_password"
							placeholder="Re-enter Password" required /></td>
						<td></td>
					</tr>
					<tr style="color: blue">
						<td>Role<sup>*</sup></td>
						<td><select name="role" class="form-control" required>
								<option value="M">Manager</option>
								<option value="A">Admin</option>
						</select></td>
						<td>Location</td>
						<td><input type="text" name="location" placeholder="Location" /></td>
						<td>Mobile Number</td>
						<td><input type="text" name="mobile_number"
							placeholder="Mobile Number(10 Digits only)" /></td>

					</tr>
					<tr>

						<td colspan="6" align="center"><input class="btn"
							type="submit" value="Confirm & Save" /> <input class="btn"
							type="reset" value="Reset" /></td>
						<!-- onclick="validateForm()" -->

					</tr>
				</table>

				<div style="color: red" align="left">* mark fields are
					mandatory</div>
			</div>
		</form>
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
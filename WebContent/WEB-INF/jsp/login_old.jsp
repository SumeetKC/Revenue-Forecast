<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript">
 $(document).ready(function(){
	 
	 
	 $("#userid").keypress(function (e) {
	     //if the letter is not digit then display error and don't type anything
	     if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
	        //display error message
	        $("#errmsg").html("Digits Only").show().fadeOut("slow");
	               return false;
	    }
	     
	     
	   });

 });
 
/*  function proceedToForgotPass()
 {
	 var urdid = document.getElementById('userid').value;
	 if(urdid!=''){
		 document.getElementById('hiddenId').value=urdid;
		 document.forgotForm.submit;	 
	 }else{
		 alert("Please enter valid UserID for Password Reset ..");
		 return false;
	 }
	 
 } */
 
 function validateForm(){
	 
	 var urdid = document.getElementById('userid').value;
	 if(urdid!=''){
		 document.loginForm.method = "post";
		 document.loginForm.action = "login.html";
		 document.loginForm.submit;	 
	 }else{
		 alert("Please enter valid credentials ..");
	 }
	 
 }
 </script>

<style type="text/css">
h1 {
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
	padding: 10px 20px;
	font-size: 17px;
	font-family: Arial;
	border: none;
	border-radius: 5px;
	cursor: auto;
}
</style>

</head>
<body>
	<div style="background-color: lightblue">
		<h1 align="center">Login with your credentials</h1>
		<form:form name="loginForm" method="POST" commandName="loginForm">
			<!--  action="login.html"-->
			<div align="center">
				<table>
					<tr>
						<td>User Name</td>
						<td><input type="text" name="userid" id="userid"
							onblur="validateUserid()" /></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" name="password" /></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Submit"
							onclick="validateForm()" /></td>
					</tr>
				</table>
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
		</form:form>

	</div>



</body>
</html>
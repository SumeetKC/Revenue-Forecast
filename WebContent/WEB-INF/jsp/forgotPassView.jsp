<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<!-- <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script
	src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		$("#userform").validate({

			rules : {
				user_id : {
					required : true,
					number : true
				}

			},

			messages : {
				user_id : {
					required : "Please Enter User ID",
					number : "Please Enter Digits Only"
				}
			},

			submitHandler : function(form) {
				form.submit();
			}
		});
	});
</script> -->
 <!-- <script type="text/javascript">

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
	 
	 var urdid = document.getElementById('user_id').value;
	 if(urdid!=''){
		 document.userform.method = "post";
		 document.userform.action = "sendToken.html";
		 document.userform.submit;	 
	 }else{
		 alert("Please enter valid User ID ..");
		 return false;
	 }
	 
}
 
</script> -->

<style type="text/css">
h2 {
	font-family: Arial;
}

input[type=text], [type=password],[type=number] {
	/* width: 100px;
	height: 10px; */
	padding: 8px 10px;
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

label,sup {
	color: red;
}
</style>

</head>
<body>
	<div align="center"
		style="max-width: 400px; padding: 10px 20px; margin: auto;">
		<div align="center">
			<h2>Forgot Password</h2>
		</div>
		<br/>
		<span style="color: red;">${message}</span>
		<form name="userform" id="userform" action="sendToken.html" method="post">
			<!-- action="sendToken.html" method="post" -->
			<table cellpadding="8px">
				<tr>
					<td>User ID<sup> *</sup></td>
					<td align="center"><input type="number" id="user_id" name="user_id"
						placeholder="Enter User ID" required /></td>
				</tr>
			</table>
			<input align="center" type="submit" class="btn"
				value="Send Verification Token" />
		</form>
	</div>
	<div align="center">
		If you have Token, Please proceed to Generate the new Password <a
			href="generatePass.html" class="btn">Generate Password</a>
	</div>

<div style="color: red;">* fields are mandatory</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Revenue Forecast</title>
</head>
<body>
<form method="post" action="ppmtaskforselectedmonth.html" >
<label>Select a month to View the PPM Status</label>
<select name="month" required>
<option value="">--Select a month--</option>
<option value="jan">January</option>
<option value="feb">Febuary</option>
<option value="mar">March</option>
<option value="apr">April</option>
<option value="may">May</option>
<option value="june">June</option>
<option value="july">July</option>
<option value="aug">August</option>
<option value="sept">September</option>
<option value="oct">October</option>
<option value="nov">November</option>
<option value="dec">December</option>
</select>

<hr>
<input type="submit" value="Save"/>
</form>
</body>
</html>
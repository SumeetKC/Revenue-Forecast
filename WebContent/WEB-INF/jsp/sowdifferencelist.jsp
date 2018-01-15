<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Different Sow Records</title>
<style>
li{
font-family: 'Comic Sans MS';
font-size: 1.2em;
}
ul{
list-style: square;
}
</style>

</head>
<body>
 <h2>In Sow Billrate or End date found in Following Employees Ids'<small>Please Check....</small></h2>
 <ul >
 <c:forEach items="${differentEmployees}" var="emp">
 	<li>${emp}</li>
 </c:forEach>
 	
 
 </ul>
 
 
</body>
</html>
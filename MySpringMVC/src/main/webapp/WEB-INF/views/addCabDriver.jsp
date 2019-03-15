<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Partner Driver</title>
</head>
<body>

<form:form action="addDriver" method="post">

<label for=>Driver Id</label>
<form:input path="driverId"/>

<label for=>Driver Name</label>
<form:input path="driverName"/>

<label for=>Mobile Number</label>
<form:input path="mobileNumber"/>

<label for=>Rating</label>
<form:input path="rating"/>

<input type="submit" value="Add Driver"/>


</form:form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en" xml:lang="en">
 
<head>
<meta charset="ISO-8859-1">
<title>Custom jsp</title>

<style>
    .error {
        color: red; font-weight: bold;
    }
</style>

</head>
<body>
<a href="/app">Home</a>
<h1>Create Interviewer</h1>
 
<form:form action="/app/add" method="post" modelAttribute="interviewer" > 
	Username
	<form:input  path="name" />  
	Password
	<form:input type="text" path="password" />
	<br/>
	<br/>
	<input type="submit" value="Submit" />
	
</form:form>
</body>
</html>
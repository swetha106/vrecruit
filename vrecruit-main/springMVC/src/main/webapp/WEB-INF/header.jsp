<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html lang="en">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<style>
.center {
	text-align: center;
}

table {
	font-size: 20px;
		margin-right: auto;
		margin-left: auto;
		
}

.error {
	color: red;
	font-weight: bold;
}

.idash	ul li {
	display: inline-block;
	margin-right: 50px;
	font-size: 20px;
}

#jobListTable tr td{
	padding:7px;
	text-align:center; 
}
#canjobListTable
{

font-size: 15px;
}

.tble tr td{
	padding:7px;
	text-align:center; 
}
.message
{
text-align:center; 
		
}
</style>
<body>
	<div>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<a class="navbar-brand" href="/app">V</font>
				Recruit</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarText" aria-controls="navbarText"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarText">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link" href="/app">Home

					</a></li>
					<!--JSP IF implementation.-->
					
					<%
						if (session.getAttribute("interviewerId") != null) {
					%>
					<li class="nav-item"><a class="nav-link" href="/app/dashboard">Dashboard</a>
						
					<li class="nav-item"><a class="nav-link" href="/app/ilogout">Logout</a>
					</li>
					<%
							}
						%>
					<li class="nav-item"><a class="nav-link" href="#"></a>
					</li>
				</ul>
				<span class="navbar-text"> 
				</span>
			</div>
		</nav>
	</div>
	<br />
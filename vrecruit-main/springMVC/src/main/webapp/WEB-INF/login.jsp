
<%@ include file="header.jsp"%>
<div class="container-fluid ">
	<h1>Interviewer Login</h1>

	<form action="/app/loginAction" method="post">
		E-mail id <input type="text" name="email" />
		<br/> <br/>
		Password <input type="password" name="password" /> 
		<br /> <br /> 
		
		<input class="btn btn-primary" type="submit" value="Submit" />

	</form>
</div>
</body>
</html>
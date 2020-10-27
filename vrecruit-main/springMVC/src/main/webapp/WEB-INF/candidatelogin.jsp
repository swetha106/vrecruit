<%@ include file="header.jsp"%>

<div class="container-fluid idash center">
	

	<div class="center">
	

<form:form id="login"  modelAttribute="user" action="login"
		method="post">

<table >
<caption></caption>
<tr>
<th id="login">LOGIN PAGE </th>
</tr>

			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input  path="email" name="email" id="email" placeholder="aaa@gmail.com"/></td>
			</tr>
			
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:password  path="password" name="password"
						id="password" placeholder="enter password"/></td>
			</tr>
			<tr>
			
				<tr>
				<td><form:button class="btn btn-primary" id="login" name="login">Login</form:button></td>
			</tr>
			<tr></tr>
			<tr>
				<td></td>
				
			</tr>
		</table>
	</form:form>
</div>
</div>
</body>
</html>
<%@ include file="header.jsp"%>

<div class="container-fluid idash center">
	
<div class="container-fluid center" >



<form:form id="regForm"  modelAttribute="user" action="saveuser"
		method="post">

		<table >
		<caption></caption>
		<tr>
		<th id="user"> REGISTER USER</th>
		</tr>
		  <form:hidden path="id" />
		
			<tr>
				<td><form:label path="username">Username</form:label></td>
				<td><form:input  path="username" name="username" id="username" placeholder="enter name"/></td>
				<td><form:errors  path="username" name="username" id="username" /></td>
		
			</tr>
			
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:password  path="password" name="password"
						id="password" placeholder="min 8 characters" /></td>
						<td><form:errors  path="password" name="password" id="password" /></td>
		
			</tr>
				<tr>
				<td>
				Date of birth<fmt:formatDate value="${user.dob}" pattern="dd/MM/yyyy" var="dob"/></td>
				<td><form:input path="dob" value="${dob}" placeholder="dd/mm/yyyy"/></td>
				<td><form:errors  path="dob" name="dob" id="dob" /></td>
		
		
			</tr>
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input path="email" name="email" id="email" placeholder="aaa@gmail.com" /></td>
				<td><form:errors  path="email" name="email" id="email" /></td>
		
			</tr>
			
			
			<tr>
				<td><form:label path="phone">Phone</form:label></td>
				<td><form:input path="phone" name="phone" id="phone" placeholder="10 Digits"/></td>
					<td><form:errors  path="phone" name="phone" id="phone" /></td>
		
			</tr>
						<tr>
				<td></td>
				<td><form:button  class="btn btn-primary" id="register" name="register">Register</form:button></td>
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
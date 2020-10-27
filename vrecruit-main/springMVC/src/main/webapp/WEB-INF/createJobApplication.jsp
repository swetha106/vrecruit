
<%@ include file="header.jsp"%>

<div class="container-fluid center">

	<h1>Create Job Application</h1>
	<br />
	<form:form action="/app/jobApp/add" method="post"
		modelAttribute="jobApp">
			Title
	<form:input path="title" />
		<form:errors path="title" cssClass="error" />

		<br />
		<br /> Category
			<form:select path="category">
			<option selected="selected">select</option>
			<c:forEach items="${categories}" var="c">

				<option><c:out value="${c}" /></option>
			</c:forEach>
		</form:select>
		<div class="error">${CategoryError}</div>
		<br /> Position Type <form:select path="positionType">
		<option selected="selected">select</option>
			<c:forEach items="${positionType}" var="c">

				<option><c:out value="${c}" /></option>
			</c:forEach>
		</form:select>
		<br />
		<br /> Job Description
			<form:textarea path="jobDescription" />
		<br />
		<br /> Rounds
			<form:input path="rounds" />
		<br />
		<br />
		<input class="btn btn-primary" type="submit" value="Submit" />

	</form:form>

</div>
</body>
</html>
<%@ include file="header.jsp"%>

<div class="container-fluid center">

	<h1>Candidate Report</h1>
	<br />

	<form:form action="/app/jobApp/updateCandidateJobProcess" method="post"
		modelAttribute="candidateDetails"> 
			
		Name: <strong>${candidateDetails.user.getUsername()}</strong>
		<form:hidden path="jobid" value="${candidateDetails.jobid}"
			readonly="true" />

		<form:hidden path="user.id" value="${candidateDetails.user.id}"
			readonly="true" />

		<form:hidden path="jobApplication.jid"
			value="${candidateDetails.jobApplication.jid}" readonly="true" />
		<br />
		<br />
	
	Marks:
	<form:input type="number" path="marks" value="${candidateDetails.marks}" max="100"/>
		<br />
		<br />
	
	click to download Resume:
	<a href="/app/jobApp/download/${candidateDetails.jobid}">
			${candidateDetails.resume.getOriginalFilename()} </a>
		<br />
		<br />
	
	
	Selected:
	
	<form:checkbox path="selected" value="${candidateDetails.selected}" />
		<br />
		<br />
	Current Round of candidate
	<form:input type="number" path="currentround"
			value="${candidateDetails.currentround}"
			max="${candidateDetails.jobApplication.rounds}" />
		<br />
		<br />

		<strong> Total rounds: ${candidateDetails.jobApplication.rounds}</strong>

		<br />
		<br />
		<input class="btn btn-primary" type="submit" value="Submit" />


	</form:form>
</div>

</body>
</html>
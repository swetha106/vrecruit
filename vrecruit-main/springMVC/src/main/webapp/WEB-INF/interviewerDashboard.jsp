<%@ include file="header.jsp"%>

<div class="container-fluid idash center">
	<h1>Interviewer Dashboard</h1>


	<div class="center">
		<h3>Welcome <%= session.getAttribute("interviewerName") %> </h3>
		
		<br/>
		<h5>
			Here you can create new job applications, see all job applications or
			which are created by you and see candidates and give them marks <br />
		</h5>
		<br/>
		<br/>
		<ul>
			<li><a class="btn btn-primary" href="jobApp/create">Create
					job Application</a></li>
			<li><a class="btn btn-primary" href="jobApp/view">View/Edit
					Job Applications Created By You</a></li>
			<li><a class="btn btn-primary" href="jobApp/viewAll">View/Edit
					All Job Applications: </a></li>
			
		</ul>
	</div>
</div>

</body>
</html>


<%@ include file="header.jsp"%>

<div class="container-fluid center">

	<h1>Job Applications</h1>

	<table border="1" id="jobListTable">
		<caption>Job Applications List</caption>
		<c:if test="${lst.isEmpty()}">
				<tr>
					<td>No Job Applications Found</td>
				</tr>
		</c:if>  
		<c:forEach items="${lst}" var="i">
			<br />

			<tr>
				<th id="head">Title: <c:out value="${i.title}" /></th>
				<td>Category: <c:out value="${i.category}" /></td>
				<td>Position Type: <c:out value="${i.positionType}" /></td>
				<td>Job Description: <c:out value="${i.jobDescription}" /></td>
				<td>Rounds: <c:out value="${i.rounds}" /></td>
				<td>Interviewer: <c:out value="${i.interviewer.id}" /></td>
				<c:set var="age" value="${i.interviewer.id}" />
				<c:if test="${ interviewerId == age }">
					<td>
						<form action="edit" method="get">
							<input type="hidden" name="id" value="${i.jid}"> <input
								class="btn btn-primary" type="submit" value="Edit">
						</form>
					</td>
					<td>
						<form action="delete" method="get">
							<input type="hidden" name="id" value="${i.jid}"> <input
								class="btn btn-danger" type="submit" value="Delete">
						</form>
					</td>
					<td>
						<!-- It will give job id as requestparameter-->
						<form action="viewCandidates" method="get">
							<input type="hidden" name="id" value="${i.jid}"> <input
								class="btn btn-primary" type="submit" value="view Candidates">
						</form>
					</td>
				</c:if>


			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>
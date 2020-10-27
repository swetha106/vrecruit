<%@ include file="header.jsp"%>

<div class="container-fluid center">
	<h1>Candidate List</h1>

	<div style="margin-left: 100px;">
		<table border="1" class="tble">
			<caption></caption>
			<c:if test="${noApplicationFound==true}">
				<tr>
					<td>No candidates Found</td>
				</tr>
			</c:if>
			<c:if test="${noApplicationFound==false}">
				<c:forEach items="${lst}" var="i">
					<br />

					<tr>
						<th id="canlist"><strong> username: <c:out value="${i.user.username}" /></strong></th>
						<td>marks: <c:out value="${i.marks}" /></td>
						<td>resume: <c:out value="${i.resume.getOriginalFilename()}" /></td>


						<td>selected: <c:out value="${i.selected}" /></td>
						<td>currentround: <c:out value="${i.currentround}" /></td>

						<td>
							<form action="viewCandidateJobProfile" method="get">
								<input type="hidden" name="id" value="${i.jobid}"> <input
									class="btn btn-primary" type="submit"
									value="viewCandidateJobProfile">
							</form>
						</td>
					</tr>
				</c:forEach>

			</c:if>
		</table>
	</div>
</div>
</body>
</html>
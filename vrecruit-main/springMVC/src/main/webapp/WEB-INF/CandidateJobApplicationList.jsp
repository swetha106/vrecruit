<%@ include file="sidebar.jsp"%>
<%@ include file="header.jsp"%>

<div class="container-fluid  center">


	<div class="center ">
 

		<table class="tble" id="canjobListTable" border="1" style="margin-left:150px;font-size:20px">
			<caption></caption>  

			<c:forEach items="${lst}" var="i">  
				<br />
				<tr>
					<th id="canjobListTitle"><strong>Title: <c:out value="${i.title}" />
					</strong></th>
					<td>Category: <c:out value="${i.category}" /></td>
					<td>Position Type: <c:out value="${i.positionType}" /></td>
					<td>Job Description: <c:out value="${i.jobDescription}" /></td>
					<td>Rounds: <c:out value="${i.rounds}" /></td>
					<td>
						<!-- It will give job id as requestparameter-->
						<form action="apply" method="get" style="display: inline;">
							<input type="hidden" name="id" value="${i.jid}"> 
							<input class="btn btn-primary"
  								type="submit" value="apply">
						</form>
					</td>
					<td></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>
<%@ include file="header.jsp"%>
<%@ include file="sidebar.jsp"%>

<div class="container-fluid  center">
	

	<div class="center">
	

	


	<table  class="tble" >
	<caption></caption>
	<tr>
	<th id="status"></th>
		<tr>
			<td>Job Title</td>
			<td>${jobApplication.title }</td>
		</tr>
		<tr>
			<td>Job Title</td>
			<td>${jobApplication.category }</td>
		</tr>
		<tr>
			<td>Job description</td>
			
			<td>${jobApplication.jobDescription }</td>
		</tr>
		
		<tr>
			<td>Status</td>
			<td>${status}</td>
		</tr>
	</table>

  

	
</div>
</div>
</body>
</html>
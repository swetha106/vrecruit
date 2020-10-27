<%@ include file="sidebar.jsp"%>
<%@ include file="header.jsp"%>


<div class="container-fluid  center">
	

	<div class="center">
	
 

     <form:form id="regForm"  modelAttribute="job" action="uploadresume" enctype="multipart/form-data"
		method="post" >
  		<h3>     upload your resume in text format </h3>
		<table ><caption></caption>
		<tr>
		<th id="resume">resume</th>
		</tr>
		
		<tr>
				<td><form:input  type="file" path="resume" name="resume" id="resume" /></td>
			</tr>
		
		<tr>
			
		<td><form:button  class="btn btn-primary" sid="upload" name="upload">upload</form:button></td>
		
				</tr>	
			
		
					
		
		</table>
	</form:form>
	</div>
	</div>
</body>
</html>
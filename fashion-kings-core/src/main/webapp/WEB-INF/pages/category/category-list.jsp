<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<h1>Categories</h1>

<table class="table table-striped">
	<thead>
		<tr>
			<th>Title</th>
	        <th>Description</th>
	        <th>Status</th>
	        <th>Actions</th>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach var="category" items="${categories}" >
			<tr>
				<td>${category.getTitle()}</td>
          		<td>${category.getDescription()}</td>
          		<td>active</td>
          		<td>actions</td>
			</tr>
		</c:forEach>
	</tbody>
</table>



	


       
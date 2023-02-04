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
          		<td>
          			<a class="btn btn-sm btn-warning" href="<c:out value="/category/form/${category.id}"/>">Edit</a>
		          	<a class="btn btn-sm btn-warning" href="<c:out value="/category/${category.id}"/>">View</a>
		          	<a class="btn btn-sm btn-dark" href="<c:out value="/category/${category.id}/products"/>">View products</a>
		          	<a class="btn btn-sm btn-danger" href="/category/${category.getId()}/delete">Delete</a>
          		</td>
			</tr>
		</c:forEach>
	</tbody>
</table>



	


       
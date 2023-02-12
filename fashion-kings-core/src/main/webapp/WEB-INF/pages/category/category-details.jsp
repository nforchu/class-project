<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<div class="mb-4">	
		<a class="btn btn-sm btn-warning" href="<c:out value="/category/form/${category.id}"/>">Edit</a>
		<a class="btn btn-sm btn-danger" href="/category/${category.getId()}/delete">Delete</a>
       	<a class="btn btn-sm btn-dark" href="<c:out value="/category/${category.id}/products"/>">View products</a>
		<a class="btn btn-sm btn-primary" href="/category/form">Add a Category</a>
	</div> 
	
	<div class="row">
		<div class="col-5">
			<div class="row pb-4">
		    	<div class="col-3"><span class="fw-bold">Category title</span></div>    	
		    	<div class="col-9">${category.getTitle()}</div>
		    </div>
		    
		    <div class="row">
		    	<div class="col-sm-3"><span class="fw-bold">Description</span></div>    	
		    	<div class="col-sm-9">${category.getDescription()}</div>
		    </div>
		</div>		
		<div class="col-5">
		    <c:if test="${category.getCover() != null }">
				<div> 
					<img id="cover" src= "/category/images/${category.getCover()}" alt="category cover" />
				</div>
			</c:if>
			<form action="/category/${category.getId()}/upload" method ="POST" enctype="multipart/form-data">
			
				<label for=imgInp id="drop-container">
					<span class="drop-title">
						${ category.getCover() != null ? 'Change Cover' : 'Upload Cover'}
					</span>
					<input name="file" type="file" id="imgInp" required/>
				</label>
			
				<div id="preview-box">
					<img id="imagePreview" src="#" alt="image preview" />
					<div class="mt-2">
						<input type="submit" 
							value="Confirm upload" 
							class="btn btn-light"/>
					</div>
				</div>
				
			</form>
		</div>
		
	</div>
    <script>
    	imgInp.onchange = evnt => {
    		const [file] = imgInp.files
    		if(file) {
    			imagePreview.src = URL.createObjectURL(file);
    			imagePreview.width = 450;
    			document.getElementById("drop-container").style.display = "none";
    			document.getElementById("preview-box").style.display = "block";
    			document.getElementById("cover").style.display = "none";
    		}
    	}
    </script>
    
</div>
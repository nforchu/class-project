<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


    <c:if test="${image != null }">
		<div> 
			<img id="cover" src= "${path}/images/${image}" alt="cover" />
		</div>
	</c:if>
	<form action="${path}/upload" method ="POST" enctype="multipart/form-data">
	
		<label for=imgInp id="drop-container">
			<span class="drop-title">
				${ image != null ? 'Change image' : 'Upload image'}
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
    

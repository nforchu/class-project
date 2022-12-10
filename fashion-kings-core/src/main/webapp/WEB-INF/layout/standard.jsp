<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Title</title>

  </head>
  
  <body>
	<div class="header">
	  <div class=""><h1>Fashion kings CONSOLE</h1></div>
	</div>
	<div class="container-fluid">
        <div class="row pt-2">
            <div class="column middle">
                <tiles:insertAttribute name="body" />
            </div>
        </div>
			
	</div>
  </body>
</html>
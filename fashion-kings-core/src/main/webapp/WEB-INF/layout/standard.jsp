<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<html>
  <head>
    <title>Title</title>
    <link href="/webjars/bootstrap/5.2.2/css/bootstrap.min.css" rel="stylesheet"></link>
    <link href="/css/styles.css" rel="stylesheet"></link>
  </head>
  
  <body>
	<div class="header">
	  <div class="">Fashion kings CONSOLE</div>
	</div>
	<div class="container-fluid">
		<div class=navigation>
			Home | Categories | Products | Orders | Users
		</div>
        <div class="row pt-2">
            <div class="column side vh-100">
            	left menu
            </div>
            <div class="column middle">
                <tiles:insertAttribute name="body" />
           
            </div>
        </div>
			
	</div>
	<script src="/webjars/bootstrap/5.2.2/js/bootstrap.min.js"></script>
	<script src="/webjars/jquery/3.6.1/jquery.min.js"></script>
  </body>
</html>
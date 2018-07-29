<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title> 
${title}
</title>
</head>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-ui.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.11.2.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="js/bootstrap.js"></script>
<body>
<!--main container starts -->
<div class="container">
	
	
	<!--header will be inserted here  -->
	<c:choose>
	<c:when test="${user !=null}">
	<c:import url="userHeader.jsp" />
	</c:when>
	<c:otherwise>
	<c:import url="header.jsp" />
	</c:otherwise>
	</c:choose>
	<hr/>
	<div class="row">
	
	<div class="col-md-2 pull-left table-bordered">
	<c:choose>
	<c:when test="${user.role==1}">
	<c:import url="userMenu.jsp" />
	</c:when>
	<c:when test="${user.role==2}">
	<c:import url="executiveMenu.jsp" />
	</c:when>
	<c:when test="${user.role==3}">
	<c:import url="adminMenu.jsp" />
	</c:when>
	</c:choose>
	</div>
	
	<!--contents will be inserted here  -->
	<div class="col-md-9 col-md-offset-1 pull-right">
	
	
	<c:import url="${body}" />	
	</div>
	</div>
	<hr/>
	<!--footer will be inserted here  -->
	<jsp:include page="footer.html" />	

<!--main container ends  -->	
</div>
</body>
</html>

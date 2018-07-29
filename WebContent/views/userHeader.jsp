<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="row">
	<!--header starts  -->
		<br/>
		<div class="col-md-3"><a id="top" href="#">
			  <img src="images/logo.png" alt="Online Product Management" ></a>
		</div>
		<div class="navbar-right">
				<span class="glyphicon glyphicon-user">&nbsp;Signed in as<c:if test="${user.role eq 1}"> (USER) </c:if>
					<c:if test="${user.role eq 2}"> (EXECUTIVE) </c:if>
					<c:if test="${user.role eq 3}"> (ADMIN)</c:if>&nbsp;
				</span>
				<div class="btn-group">
				<button type="button" class="btn navbar-btn btn-primary dropdown-toggle" data-toggle="dropdown">
				${user.name} <span class="caret"></span>
				</button>
				<ul class="dropdown-menu" role="menu">
				<li><a href="loadProfile.action">Profile</a></li>
				<li class="divider"></li>
				<li><a href="logout.action">Log out</a></li>
				</ul>
				</div>
				</div>
	<!--header ends  -->	
	</div>
	
	
	
	
	
	
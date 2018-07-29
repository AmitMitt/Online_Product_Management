<%@page import="com.swinfosoft.mvc.web.ActionContext"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


 <div class="col-md-12">
 	
	<table class="table table-striped table-bordered">

	<thead>
		<tr class="success">
		<th>User Name</th><th>Product Name</th><th>Message</th><th>Action</th>
		</tr>
		</thead>
	<tbody>
	<c:forEach items="${viewMail}" var="view" varStatus="status">
	<tr>
	<td>${view.user.name}</td>
	<td>${view.product.name}</td>
	<td>${view.message}</td>	
	<td><a href="mailReply.action?id=${view.id}&cid=${view.cId}">Replay</a></td>
	</tr>
	
	</c:forEach>
	</tbody>
	</table>
	
	</div>

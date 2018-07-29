<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 <div class="col-md-12">
 	<hr/>
	<c:if test="${userViewMail !=null}">
	<table class="table table-striped table-bordered">

	<thead>
		<tr class="success">
		<th>Product Name</th><th>Message</th><th>Action</th>
		</tr>
		</thead>
	<tbody>
	<c:forEach items="${userViewMail}" var="uvm" varStatus="status">
	<tr>
	<td><span class="glyphicon glyphicon-certificate">
	</span>&nbsp;&nbsp;&nbsp;${uvm.product.name}</td>	
	<td><span >${uvm.message}</span></td>	
	<td><a href="messageDetails.action?id=${uvm.id}">Message Details</a></td>
	</tr>
	
	</c:forEach>
	</tbody>
	</table>

	</c:if>
	
	</div>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 <div class="col-md-12">
 	<h3>Product List</h3>
 	<hr/>
	<c:if test="${regProduct !=null}">
	<table class="table table-striped table-bordered">

	<thead>
		<tr class="success">
		<th>Name</th><th>Purchase Date</th><th>Price</th><th>Vendor</th><th>Action</th>
		</tr>
		</thead>
	<tbody>
	<c:forEach items="${regProduct}" var="pro" varStatus="status">
	<tr>
	<td><span class="glyphicon glyphicon-certificate">
	</span>&nbsp;&nbsp;&nbsp;${pro.pname}</td>	
	<td>${pro.pDate}</td>
	<td>${pro.pPrice}</td>
	<td>${pro.vendor}</td>	
	<td><a href="warrantyDetails.action?id=${pro.id}">Warranty Details</a></td>
	</tr>
	
	</c:forEach>
	</tbody>
	</table>

	</c:if>
	
	</div>

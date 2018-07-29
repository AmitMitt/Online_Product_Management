<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 <div class="col-md-12">
 	<h3>Product List</h3>
 	<hr/>
	<c:if test="${products !=null}">
	<table class="table table-striped table-bordered">

	<thead>
		<tr class="success">
		<th>Name</th>
		<th>Warranty</th>
		<th>Warranty Type</th>
		<th>Warranty Coverage</th>
		<th>Warranty Exclusion</th>
		<th>Action</th>
		<th>Action</th>
		</tr>
		</thead>
	<tbody>
	<c:forEach items="${products}" var="pro" varStatus="status">
	<tr>
	<td><span class="glyphicon glyphicon-certificate">
	</span>&nbsp;&nbsp;&nbsp;${pro.name}</td>
	<td>${pro.warranty}</td>
	<td>${pro.wType}</td>
	<td>${pro.coverage}</td>
	<td>${pro.exclusion}</td>
	<td><a href="editProduct.action?id=${pro.id}">edit</a></td>
	<td><a href="deleteProduct.action?id=${pro.id}">delete</a></td>
	</tr>
	
	</c:forEach>
	</tbody>
	</table>

	</c:if>
	
	</div>


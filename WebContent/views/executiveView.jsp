<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 <div class="col-md-12">
 	<h3>Executive List</h3>
 	<hr/>
	<c:if test="${executives !=null}">
	<table class="table table-striped table-bordered">

	<thead>
		<tr class="success">
		<th>Name</th>
		<th>LoginId</th>
		<th>Account Opening Date</th>
		<th>Account Status</th>		
		<th>Level</th>
		<th>Action</th>
		<th>Action</th>
		</tr>
		</thead>
	<tbody>
	<c:forEach items="${executives}" var="exe" varStatus="status">
	<tr>
	<td>${exe.name}</td>
	<td>${exe.loginId}</td>
	<td>${exe.acOpeningDate}</td>
	<td>${exe.acStatus}</td>
	<td>
		<c:if test="${exe.level eq 1}">Operator</c:if>
		<c:if test="${exe.level eq 2}">Moderator</c:if>
		<c:if test="${exe.level eq 3}">Manager</c:if>
	</td>
	<td><a href="editExecutive.action?id=${exe.id}">edit</a></td>
	<td><a href="deleteExecutive.action?id=${exe.id}">delete</a></td>
	</tr>
	
	</c:forEach>
	</tbody>
	</table>

	</c:if>
	
	</div>


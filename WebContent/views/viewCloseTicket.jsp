<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 <div class="col-md-12">
 	<h3>Ticket List</h3>
 	<hr/>
	<c:if test="${! empty tickets}">
	<table class="table table-striped table-bordered">

	<thead>
		<tr class="success">
		<th>Title</th>
		<th>Date & Time</th>
		<th>Priority</th>
		<th>Status</th>
		<th>Action</th>
		</tr>
		</thead>
	<tbody>
	<c:forEach items="${tickets}" var="t">
			<tr>
				<td>${t.title}</td>
				<td>${t.ticketDate}</td>
				<td>
					<c:choose>
						<c:when test="${t.priority=='1'}">Low</c:when>
						<c:when test="${t.priority=='2'}">Normal</c:when>
						<c:when test="${t.priority=='3'}">High</c:when>
					</c:choose>
				</td>
				<td>${t.status}</td>
				<td><a href="ticketOpen.action?tid=${t.id}">Open Ticket</a></td>
			</tr>
		</c:forEach>
	</tbody>
	</table>

	</c:if>
	<c:if test="${empty tickets}">No ticket found.</c:if>
	</div>


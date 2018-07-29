<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="col-md-8 col-md-offset-2">
<div class="panel panel-primary">
<div class="panel-heading">

<p class="panel-title">Report Monthly-Wise</p>
</div>
<c:if test="${list !=null}">
<table class="table table-striped table-bordered">

	<thead>
		<tr class="success">
		<th>User Name</th><th>Product Name</th><th>Purchase Date</th><th>Vendor</th>
		</tr>
		</thead>
	<tbody>
	<c:forEach items="${list}" var="list">
	<tr>
	<td>${list.user.name}</td>
	<td>${list.product.name}</td>
	<td>${list.pDate}</td>	
	<td>${list.vendor}</td>
	</tr>
	</c:forEach>
	</tbody>
	</table>
	</c:if>
</div>
	<div class="form-group pull-right" >
	<label for="name" class="control-label">Download Report:</label>
	<a class="btn btn-primary btn-sm" target="_blank" href="monthlyWiseReportGenerate.action?from=${from}&to=${to}">Report</a>
	</div>
</div>

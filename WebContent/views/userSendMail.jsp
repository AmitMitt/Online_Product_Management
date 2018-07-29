<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="col-md-6 col-md-offset-2">
<div class="panel panel-primary">
<div class="panel-heading">
<p class="panel-title">Send Mail</p>
</div>
<div class="panel-body">
	<form action="sendMail.action" class="form-horizontal">
	<div class="form-group">
	<label for="name" class="control-label">Select Product Name</label>
	<select name="pid" class="form-control">
 		<option disabled="disabled">---Select Your Product---</option>
		<c:forEach items="${products}" var="pro">
			<option value="${pro.pid}">${pro.pname}</option>
		</c:forEach>
	</select>
	</div>
	<div class="form-group">
	<label for="message" class="control-label">Message</label>
	<textarea name="message" class="form-control"></textarea>
	</div>
	
	<div class="pull-right">
	<button type="submit" class="btn btn-primary btn-lg">Send Mail</button>
	</div>
	</form>

</div>
</div>
</div>

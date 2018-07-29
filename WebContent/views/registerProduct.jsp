<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="col-md-6 col-md-offset-2">
<div class="panel panel-primary">
<div class="panel-heading">
<p class="panel-title">Register Product</p>
</div>
<div class="panel-body">
	<form action="regProduct.action" class="form-horizontal">
	<div class="form-group">
	<label for="name" class="control-label">Select Product Name</label>
	<select name="pid" class="form-control">
 		<option>---Select Your Product---</option>
		<c:forEach items="${products}" var="pro">
			<option value="${pro.id}">${pro.name}</option>
		</c:forEach>
	</select>
	</div>
	<div class="form-group">
	<label for="pDate" class="control-label">Purchase Date</label>
	<input type="text" name="pDate" id="datepicker" class="form-control">
	</div>
	<div class="form-group">
	<label for="pPrice" class="control-label">Purchase Price</label>
	<input type="text" name="pPrice" id="pPrice" class="form-control">
	</div>
	<div class="form-group">
	<label for="vendor" class="control-label">Vendor</label>
	<input type="text" name="vendor" id="vendor" class="form-control">
	</div>
	<div class="pull-right">
	<button type="submit" class="btn btn-primary btn-lg">Register Product</button>
	</div>
	</form>

</div>
</div>
</div>

<script type="text/javascript">
$(document).ready(function(){
	 $("#datepicker").datepicker({
		 dateFormat: 'dd-mm-yy'		 
	 });
	
});
</script>
<div class="col-md-6 col-md-offset-2">
<div class="panel panel-primary">
<div class="panel-heading">
<p class="panel-title">Edit Product</p>
</div>
<div class="panel-body">
	<form action="updateProduct.action" class="form-horizontal">
	<div class="form-group">
	<label for="name" class="control-label">Name</label>
	<input type="hidden" name="id" value="${product.id}">
	<input type="text" name="name" value="${product.name}" class="form-control">
	</div>
	<div class="form-group">
	<label for="warranty" class="control-label">Warranty (in-Month)</label>
	<input type="text" name="warranty" value="${product.warranty}" class="form-control">
	</div>
	<div class="form-group">
	<label for="wType" class="control-label">Warranty Type (OnSite/OffSite)</label>
	<input type="text" name="wType" value="${product.wType}" class="form-control">
	</div>
	<div class="form-group">
	<label for="coverage" class="control-label">Coverage (Full/Part)</label>
	<input type="text" name="coverage" value="${product.coverage}" class="form-control">
	</div>
	<div class="form-group">
	<label for="exclusion" class="control-label">Exclusion</label>
	<input type="text" name="exclusion" value="${product.exclusion}" class="form-control">
	</div>
	<div class="pull-right">
	<button type="submit" class="btn btn-primary btn-lg">Update</button>
	</div>
	</form>
</div>
</div>
</div>
<div class="col-md-8">
<div class="panel panel-primary">
<div class="panel-heading">
<p class="panel-title">Add Product</p>
</div>
<div class="panel-body">
<form method="get" action="addProduct.action" class="form-horizontal">
	<div class="form-group">
		<label for="name" class="control-label">Product Name</label>
		<input type="text" name="name" placeholder="name" class="form-control">
	</div>
	<div class="form-group">
		<label for="warranty" class="control-label">Warranty (In Months)</label>
		<input type="text" name="warranty" placeholder="Warranty" class="form-control">
	</div>
	<div class="row">
		<label for="warrantyType" class="radio-inline">Warranty Type :  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="radio" name="wType" value="OnSite" id="inlineRadio" checked >OnSite &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="radio" name="wType" value="OffSite" id="inlineRadio" >OffSite &nbsp;<br></label>
	</div>
	<div class="row">
		<label for="Coverage" class="radio-inline">Coverage : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="radio" name="coverage" value="Full" id="inlineRadio" checked >Full Coverage &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="radio" name="coverage" value="part" id="inlineRadio" >Partial Coverage &nbsp;<br></label>
	</div>
	<div class="form-group">
		<label for="exclusion" class="control-label">Exclusion</label>
		<input type="text" name="exclusion" placeholder="Exclusion" class="form-control">
	</div>
	<div class="pull-right">
		<button type="submit" class="btn btn-primary btn-lg">Add Product</button>
	</div>
</form>
</div>
</div>
</div>
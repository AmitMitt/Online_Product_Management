<div class="col-md-6 col-md-offset-2">
<div class="panel panel-primary">
<div class="panel-heading">
<p class="panel-title">Edit Executive</p>
</div>
<div class="panel-body">
	<form action="updateExecutive.action" class="form-horizontal">
	<div class="form-group">
	<label for="name" class="control-label">Name</label>
	<input type="hidden" name="id" value="${executive.id}">
	<input type="text" name="name" value="${executive.name}" class="form-control">
	</div>
	<div class="form-group">
	<label for="loginId" class="control-label">LoginId</label>
	<input type="text" name="loginId" value="${executive.loginId}" class="form-control">
	</div>
	<div class="form-group">
	<label for="target" class="control-label">Target</label>
	<input type="text" name="target" value="${executive.target}" class="form-control">
	</div>
	<div class="form-group">
	<label for="acStatus" class="control-label">Account Status</label>
	<select name="acStatus" class="form-control">
		<option  value="Active" ${executive.acStatus=='Active'?'selected':''}>Active</option>
		<option value="InActive" ${executive.acStatus=='InActive'?'selected':''}>InActive</option>
	</select>
	</div>
	<div class="form-group">
	<label for="level" class="control-label">Level</label>
	<select name="level" class="form-control">
		<option  value="1" ${executive.level=='1'?'selected':''}>Operator</option>
		<option  value="2" ${executive.level=='2'?'selected':''}>Moderator</option>
		<option  value="3" ${executive.level=='3'?'selected':''}>Manager</option>
	</select>
	</div>
	
	<div class="pull-right">
	<button type="submit" class="btn btn-primary btn-lg">Update</button>
	</div>
	</form>
</div>
</div>
</div>
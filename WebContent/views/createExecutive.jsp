<div class="col-md-6 col-md-offset-2">
<div class="panel panel-primary">
<div class="panel-heading">
<p class="panel-title">New Executive Registration</p>
</div>
<div class="panel-body">
	<form action="executiveRegister.action" class="form-horizontal">
	<div class="form-group">
	<label for="name" class="control-label">Name</label>
	<input type="text" name="name" placeholder="name" class="form-control">
	</div>
	<div class="form-group">
	<label for="loginId" class="control-label">LoginId</label>
	<input type="text" name="loginId" placeholder="loginId" class="form-control">
	</div>
	<div class="form-group">
	<label for="password" class="control-label">Password</label>
	<input type="password" name="password" placeholder="Password" class="form-control">
	</div>
	<div class="form-group">
	<label for="level" class="control-label">Level</label>
	<select name="level" class="form-control">
		<option value="1">Operator</option>
		<option value="2">Moderator</option>
		<option value="3">Manager</option>
	</select>
	</div>
	<div class="pull-right">
	<button type="submit" class="btn btn-primary btn-lg">Register</button>
	</div>
	</form>

</div>
</div>
</div>
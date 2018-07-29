<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="col-md-8 col-md-offset-2">
<div class="panel panel-primary">
<div class="panel-heading">
<p class="panel-title">Product By Selected Dates.</p>
</div>
<div class="panel-body">
	<form action="reportMonthlyWise.action" class="form-horizontal">
	<div class="form-group">
	<label for="fDate" class="control-label">From Date:</label>
	<input type="text" name="fDate" id="fDatepicker" class="form-control">
	</div>
	<div class="form-group">
	<label for="tDate" class="control-label">To Date:</label>
	<input type="text" name="tDate" id="tDatepicker" class="form-control">
	</div>
	<div class="pull-right">
		<button type="submit" class="btn btn-primary btn-lg">Submit</button>
	</div>
	</form>
	<hr>

</div>
</div>
</div>

<script type="text/javascript">
$(document).ready(function(){
	 $("#fDatepicker").datepicker({
		 dateFormat: 'dd-mm-yy'		 
	 });
	 $("#tDatepicker").datepicker({
		 dateFormat: 'dd-mm-yy'		 
	 });
	
});
</script>
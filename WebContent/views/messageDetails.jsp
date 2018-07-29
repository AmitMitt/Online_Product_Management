<%@page import="sun.misc.Regexp"%>
<%@page import="entity.Product"%>
<%@page import="com.swinfosoft.mvc.web.ActionContext"%>
<div class="col-md-6 col-md-offset-2">
<div class="panel panel-primary">
<div class="panel-heading">
<p class="panel-title">Message Details</p>
</div>
<div class="panel-body">
	<div class="form-group">
	<label  class="control-label">Sender Name</label>
	<label  class="form-control">${mailDetails.exec.name}</label>
	</div>
	<div class="form-group">
	<label  class="control-label">Product Name</label>
	<label  class="form-control">${mailDetails.product.name}</label>
	</div>
	
	<div class="form-group">
	<label class="control-label">Message</label>
	<textarea rows="4" cols="20"  class="form-control" disabled="disabled">${mailDetails.message}</textarea>

	</div>
</div>
</div>
</div>
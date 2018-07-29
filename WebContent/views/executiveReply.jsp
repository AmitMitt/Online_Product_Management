<%@page import="sun.misc.Regexp"%>
<%@page import="entity.Product"%>
<%@page import="com.swinfosoft.mvc.web.ActionContext"%>
<div class="col-md-6 col-md-offset-2">
<div class="panel panel-primary">
<div class="panel-heading">
<p class="panel-title">Reply</p>
</div>
<div class="panel-body">
<form action="replyMailExec.action" class="form-horizontal">
	<input type="hidden" name="cid" value="${mail.cId}">
	<input type="hidden" name="pid" value="${mail.pId}">
	<div class="form-group">
	<label  class="control-label">User Name</label>
	<label  class="form-control">${mail.user.name}</label>
	</div>
	<div class="form-group">
	<label class="control-label">Message</label>
	<textarea rows="4" cols="20"  class="form-control" disabled="disabled">${mail.message}</textarea>
	</div>
	<div class="form-group">
	<label class="control-label">Reply</label>
	<textarea rows="4" cols="20" name="message" class="form-control"></textarea>
	</div>
	
	<div class="pull-right">
	<button type="submit" class="btn btn-primary btn-lg">Reply</button>
	</div>
	</form>
</div>
</div>
</div>
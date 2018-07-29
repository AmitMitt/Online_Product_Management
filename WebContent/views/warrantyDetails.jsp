<%@page import="sun.misc.Regexp"%>
<%@page import="entity.Product"%>
<%@page import="com.swinfosoft.mvc.web.ActionContext"%>
<div class="col-md-6 col-md-offset-2">
<div class="panel panel-primary">
<div class="panel-heading">
<p class="panel-title">Warranty Details</p>
</div>
<div class="panel-body">
	<div class="form-group">
	<label  class="control-label">Name</label>
	<label  class="form-control">${product.name}</label>
	</div>
	<%
		Product pro=(Product)ActionContext.getAttribute("product");
	String str[]=pro.getWarranty().split(";"); %>
	<div class="form-group">
	<label class="control-label">Warranty (in-Month)</label>
	<label class="form-control"><%=str[0]%></label>
	</div>
	<div class="form-group">
	<label class="control-label">Warranty Details</label>
	<label class="form-control"><%=str[1]%></label>
	</div>
	<div class="form-group">
	<label class="control-label">Warranty Type (OnSite/OffSite)</label>
	<label class="form-control">${product.wType}</label>
	</div>
	<div class="form-group">
	<label class="control-label">Coverage (Full/Part)</label>
	<label class="form-control">${product.coverage}</label>
	</div>
	<div class="form-group">
	<label class="control-label">Exclusion</label>
	<label class="form-control">${product.exclusion}</label>
	</div>
</div>
</div>
</div>
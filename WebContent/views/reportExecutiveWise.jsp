<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="col-md-8 col-md-offset-2">
<div class="panel panel-primary">
<div class="panel-heading">
<p class="panel-title">Report Executive-Wise</p>
</div>
<div class="panel-body">
	<form action="regProduct.action" class="form-horizontal">
	<div class="form-group">
	<label for="name" class="control-label">Select Executive Name</label>
	<select id="pid" name="pid" class="form-control">
 		<option>---Select Your Product---</option>
		<c:forEach items="${executives}" var="exec">
			<option value="${exec.id}">${exec.name}</option>
		</c:forEach>
	</select>
	</div>
	</form>
	<hr>
	<div class="row" id="details">
		<table class="table table-striped table-bordered">
			<thead>
				<tr class="success"><th>Product Name</th><th>Status</th><th>Token Date</th></tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	
	</div>
	<div class="form-group pull-right" >
	<label for="name" class="control-label">Download Report:</label>
	<a id="report" class="btn btn-primary btn-sm" target="_blank" href="">Report</a>
	</div>

</div>
</div>
</div>


<script>
$(document).ready(function(){
	$('#details').hide();
	$('#pid').change(function(){
		var id=$(this).val();
		$.post('statusCheck.action',{'eid':id},function(data){
			 setProductList(data); 
		});
		$('#report').attr("href","executiveWiseReportGenerate.action?eid="+id);
	});
});

function setProductList(object){
	var html='';
	var jsonObject=$.parseJSON(object);
	$(jsonObject).each(function(i,p){
		html+='<tr><td>'+p.product.name+'</td><td>'+p.ticket.status+'</td><td>'+p.ticket.ticketDate+'</td></tr>';
	});
	$('#details table tbody').html(html);
	$('#details').show();
}
</script>
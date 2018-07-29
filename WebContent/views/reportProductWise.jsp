<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="col-md-8 col-md-offset-2">
<div class="panel panel-primary">
<div class="panel-heading">
<p class="panel-title">Report Product-Wise</p>
</div>
<div class="panel-body">
	<form action="regProduct.action" class="form-horizontal">
	<div class="form-group">
	<label for="name" class="control-label">Select Product Name</label>
	<select id="pid" name="pid" class="form-control">
 		<option>---Select Your Product---</option>
		<c:forEach items="${products}" var="pro">
			<option value="${pro.id}">${pro.name}</option>
		</c:forEach>
	</select>
	</div>
	<div class="form-group" id="rCounter">
	<label for="name" class="control-label">Register Counter:</label>
	<label for="name" class="control-label" id="counter"></label>
	</div>
	
	</form>
	<hr>
	<div class="row" id="details">
		<table class="table table-striped table-bordered">
			<thead>
				<tr class="success"><th>Product Registered By</th><th>Purchased On</th></tr>
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
	$('#rCounter').hide();
	
	$('#pid').change(function(){
		var id=$(this).val();
		
		$.post('productCounter.action',{'pid':id},function(data){
			setProductList(data);
		});
		$('#report').attr("href","productWiseReportGenerate.action?pid="+id);
	});
	
});

function setProductList(object){
	var html='';
	var count=0;
	var jsonObject=$.parseJSON(object);
	$(jsonObject).each(function(i,p){
		count=i+1;
		html+='<tr><td>'+p.user.name+'</td><td>'+p.pDate+'</td></tr>';
	});
	$('#counter').html(count);
	$('#details table tbody').html(html);
	$('#rCounter').show();
	$('#details').show();
}
</script>

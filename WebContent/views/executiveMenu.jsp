<div>
<br>
<ul class="nav nav-pills nav-stacked">
<li class="active"><a href="#">Tickets</a></li>
<li ><a href="fetchTicket.action">Fetch Next</a></li>
<li><a href="fetchClosedTicket.action">Completed</a></li>
<li class="divider"></li>
<li class="active"><a href="#">User Products</a></li>
<li><a href="executiveViewProduct.action">View Product</a></li>
<li class="divider"></li>
<li class="active"><a href="#">Mails</a></li>
<li><a href="viewMailExecutive.action">View</a></li>
</ul>
</div>
<script type="text/javascript">
$(document).ready(function(){

	$("#fetchNext").click(function(){
		
		$.get("contents/fetchTicket.jsp",function(data){
			$("#ajaxContents").html(data);
		});
		
	});
});
</script>
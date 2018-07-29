<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="col-md-8">
<div class="panel panel-primary">
<div class="panel-heading">
<p class="panel-title">Open Ticket</p>
</div>
<div class="panel-body">
<form method="post" action="openTicket.action" enctype="multipart/form-data" class="form-horizontal">
	<div class="form-group">
		<label for="title" class="control-label">Title</label>
		<input type="text" name="title" placeholder="Title" class="form-control">
	</div>
	<div class="form-group">
	<label for="name" class="control-label">Select Product Name</label>
	<select id="pid" name="pid" class="form-control">
 		<option>---Select Your Product---</option>
		<c:forEach items="${produts}" var="pro">
			<option value="${pro.pid}">${pro.pname}</option>
		</c:forEach>
	</select>
	</div>
	<div class="form-group">
		<label for="priority" class="control-label">Select Priority</label>
		<select name="priority" class="form-control">
			<option value="1">Low</option>
			<option value="2">Normal</option>
			<option value="3">High</option>
		</select>
	</div>
	
	<div class="form-group">
		<label for="description" class="control-label">Description</label>
		<textarea rows="6" cols="" name="description" class="form-control"></textarea>
	</div>
	
	<div class="form-group">
		<label for="file" class="control-label">Attach File/Image etc.</label>
		<div class="input_fields_wrap">
    		<button class="add_field_button btn btn-primary btn-sm">More Attachments</button>
    		<div><input type="file" name="file1" class="form-control"></div>
		</div>
	</div>
	<div class="pull-right">
		<button type="submit" class="btn btn-primary btn-lg">Open Ticket</button>
	</div>
</form>
</div>
</div>
</div>

<script type="text/javascript">
$(document).ready(function() {
    var max_fields      = 6; //maximum input boxes allowed
    var wrapper         = $(".input_fields_wrap"); //Fields wrapper
    var add_button      = $(".add_field_button"); //Add button ID
    
    var x = 2; //initlal text box count
    $(add_button).click(function(e){ //on add input button click
        e.preventDefault();
        if(x < max_fields){ //max input box allowed            
            $(wrapper).append('<div ><a href="#" class="remove_field">X</a><input type="file" name="file'+x+'" class="form-control"/></div>'); //add input box
            x++; //text box increment
        }
        else{
        	alert("max file upload limit is 5");
        }
    });
    
    $(wrapper).on("click",".remove_field", function(e){ //user click on remove text
        e.preventDefault(); $(this).parent('div').remove(); x--;
    });
});
</script>
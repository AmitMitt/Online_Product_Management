<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="col-md-12">
<div class="panel panel-primary">
<div class="panel-heading">
<p class="panel-title">Ticket Details</p>
</div>
<div class="panel-body">
<c:choose>
	<c:when test="${! empty ticket}">
		<div>
			<form method="post" action="ticketReply.action">
				<h3><b>Ticket</b></h3>
				<fieldset>
					<input type="hidden" name="tid" value="${ticket.id}">
					<input type="hidden" name="tDate" value="${ticket.ticketDate}">
					<table  class="table table-striped table-bordered">
						<tr>
							<td><label for="title">Title</label></td><td><input type="text" name="title" value="${ticket.title}" readonly="readonly"></td>
							<td><label for="priority">Priority</label></td>
							<td><c:choose>
								<c:when test="${ticket.priority=='1'}">Low</c:when>
								<c:when test="${ticket.priority=='2'}">Normal</c:when>
								<c:when test="${ticket.priority=='3'}">High</c:when>
							</c:choose></td>
						</tr>
						<tr>
							<td><label for="description">Description</label></td><td colspan="3"><textarea rows="5" cols="120" name="description" readonly="readonly" style="width:400px; ">${ticket.description}</textarea></td>
						</tr>
						<tr>
							<td><label for="attachments">Attachments</label></td>
							<td colspan="3">
								<c:if test="${! empty attachment}">
									<c:forEach items="${attachment}" var="a">
										<c:choose>
											<c:when test="${a.filePath !='null'}">
												<a href="downloadAttachment.action?aid=${a.attachmentId}">${a.filePath}</a>
											</c:when>
											<c:otherwise>No Attachment Found.</c:otherwise>
										</c:choose>
									</c:forEach>
								</c:if>
							</td>
						</tr>
					</table>
					<h3><b>Replies</b></h3>					
					<c:choose>
						<c:when test="${! empty trlist}">
							<div style="overflow-y: scroll; height:350px;">				
								<c:forEach items="${trlist}" var="tr">
									<table  class="table table-striped table-bordered">
										<tr>
											<td>Date: </td><td><input type="text" name="replyDate" value="${tr.replyDate}" readonly="readonly"></td>
											<td>&nbsp;By:</td><td><input type="text" name="replyBy" value="${tr.replyBy}" readonly="readonly" style="width: 150px;"></td>
										</tr>
										<tr>
											<td>Processing Time:</td>
    										<td colspan="3"><input type="text" name="processTime" value="${tr.processTime}" readonly="readonly" style="width:400px; "></td>
  										</tr>
  										<tr>
  											<td>Executive Reply: </td>
  											<td colspan="3"><textarea rows="5" cols="100" name="replyText" readonly="readonly" style="width:400px; ">${tr.replyText}</textarea></td>
  										</tr>
  										<c:choose>
  											<c:when test="${(tr.customerReplyText) eq null}">
  												<tr>  											
  													<td>Customer Reply: </td>
  													<td>No Reply. </td>
  												</tr>
  											</c:when>
  											<c:otherwise>
  												<tr>
  													<td>Customer Reply: </td>  								
  													<td colspan="3"><textarea rows="5" cols="100" name="customerReplyText" readonly="readonly" style="width:400px; ">${tr.customerReplyText}</textarea></td>
  												</tr>
  											</c:otherwise>
  										</c:choose>  										
  									</table>
									<br>
								</c:forEach>
							</div>					
						</c:when>
					<c:otherwise>No Reply available.....</c:otherwise>
				</c:choose>	<br>		
				<table  class="table table-striped table-bordered">
						<tr><td><label for="reply">Reply</label></td><td><textarea rows="5" cols="60" name="reply"></textarea></td></tr>
						<tr><td></td><td><button type="submit" class="btn btn-primary">Reply</button></td></tr>
				</table>
				</fieldset>
			</form>
		</div>
	</c:when>
	<c:otherwise>
		<p>Ticket Queue is empty .......................</p>
	</c:otherwise>
</c:choose>
</div>
</div>
</div>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="col-md-12">
<div class="panel panel-primary">
<div class="panel-heading">
<p class="panel-title">Ticket Details</p>
</div>
<div class="panel-body">
	<c:choose>
		<c:when test="${! empty ticket}">
		<table class="table table-striped table-bordered col-md-8">
			<tr>
				<td>Title:</td><td><input type="text" name="title" value="${ticket.title}" readonly="readonly"></td>
				<td>&nbsp;Status:</td><td><input type="text" name="status" value="${ticket.status}" readonly="readonly" style="width: 150px;"></td>
			</tr>
			<tr>
				<td>Date:</td><td><input type="text" name="ticketDate" value="${ticket.ticketDate}" readonly="readonly"></td>
				<td>&nbsp;Priority:</td>
				<td><c:choose>
						<c:when test="${ticket.priority=='1'}">Low</c:when>
						<c:when test="${ticket.priority=='2'}">Normal</c:when>
						<c:when test="${ticket.priority=='3'}">High</c:when>
				</c:choose></td>
			</tr>
			<tr>
				<td>Description:</td><td><textarea cols="30" rows="6" name="description" readonly="readonly">${ticket.description}</textarea></td>
				<td>&nbsp;Attachments:</td><td><c:if test="${! empty attachment}">
						<c:forEach items="${attachment}" var="a">
							<c:choose>
								<c:when test="${a.filePath !='null'}">
									<a href="downloadAttachment.action?aid=${a.attachmentId}" >${a.filePath}</a><br>
								</c:when>
								<c:otherwise>No Attachment Found.</c:otherwise>
							</c:choose>
						</c:forEach>
					</c:if></td>
			</tr>
		</table>
		<br>
		<h3><b>Replies</b></h3>
		<div style="overflow-y: scroll; height:350px;">
			<c:choose>
				<c:when test="${! empty trlist}">					
					<c:forEach items="${trlist}" var="tr">
					<form method="post" action="customerReply.action">
						<input type="hidden" name="trId" value="${tr.id}">
						<table  class="table table-striped table-bordered col-md-8">
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
  							<tr>
  								<td>Customer Reply: </td>
  								<c:choose>
  									<c:when test="${(tr.customerReplyText) eq null}">
  										<td colspan="2"><textarea rows="5" cols="100" name="customerReplyText" style="width:300px; "></textarea></td>
  										<td><input type="submit" value="Reply" class="btn btn-primary"></td>
  									</c:when>
  									<c:otherwise>
  										<td colspan="3"><textarea rows="5" cols="100" name="customerReplyText" readonly="readonly" style="width:400px; ">${tr.customerReplyText}</textarea></td>
  									</c:otherwise>
  								</c:choose>
  							</tr>
  						</table>
  						</form>
						<br>
					</c:forEach>					
				</c:when>
				<c:otherwise>No Reply available.....</c:otherwise>
			</c:choose>
		</div>
		</c:when>
	</c:choose>
	</div>
	</div>
</div>

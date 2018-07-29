<%@page import="com.swinfosoft.mvc.web.ActionContext"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

 <div class="col-md-12">
 	<h3>Product List</h3>
 	<hr/>
	<c:if test="${regProduct !=null}">
	<table class="table table-striped table-bordered">

	<thead>
		<tr class="success">
		<th>User Name</th><th>Product Name</th><th>Purchase Date</th><th>Price</th><th>Vendor</th><th>Action</th>
		</tr>
		</thead>
	<tbody>
	<c:forEach items="${regProduct}" var="pro" varStatus="status">
	<tr>
	<%-- <td><%
	String str=(String)ActionContext.getAttribute("pro");
	String str1[]=str.split(";"); 
	%><%=str1[1]%></td> --%>
	
		<c:set var="str" value="${pro.pname}"/>
		<c:forEach var="str1" items="${fn:split(str,';')}">
			<td><c:out value="${str1}"/></td>
		</c:forEach>
	
	<%-- <td><span class="glyphicon glyphicon-certificate">
	</span>&nbsp;&nbsp;&nbsp;${pro.pname}</td> --%>	
	<td>${pro.pDate}</td>
	<td>${pro.pPrice}</td>
	<td>${pro.vendor}</td>	
	<td><a href="warrantyDetails.action?id=${pro.id}">Warranty Details</a></td>
	</tr>
	
	</c:forEach>
	</tbody>
	</table>

	</c:if>
	
	</div>

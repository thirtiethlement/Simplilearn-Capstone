<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page = "header.jsp">
<jsp:param name = "pageName" value = "Admin Order Hub"/>
</jsp:include>

<body>

<jsp:include page = "navbar.jsp">
<jsp:param name = "page" value = "orderHub"/>
</jsp:include>

<div class = "container m-auto my-3">
	<table class = "table table-hover">
		<thead>
			<tr>
				<th scope = "col">Order Id</th>
				<th scope = "col">Status</th>
				<th scope = "col">Associated User</th>
				<th scope = "col">Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:if test = "${count eq 0}">
				<tr><td colspan = "4">There are no active orders in the database</td></tr>
			</c:if>
			<c:if test = "${count ne 0}">
				<c:forEach items = "${listing}" var = "order">
					<tr>
						<td>${order.orderId}</td>
						<td>${order.status}</td>
						<td>${order.user.username}</td>
						<td>
							<form id = "editOrder" action = "/admin/editOrder" method = "post">
								<input type = "hidden" name = "id" value = "${order.orderId}">
								<button type="submit" class="btn btn-success">Edit</button>
							</form>
							<form id = "deleteOrder" action = "/admin/deleteOrder" method = "post">
								<input type = "hidden" name = "id" value = "${order.orderId}">
								<button type="submit" class="btn btn-danger">Delete</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
</div>

<jsp:include page = "footer.jsp"/>
</body>
</html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page = "header.jsp">
<jsp:param name = "pageName" value = "Check Orders"/>
</jsp:include>

<body>

<jsp:include page = "navbar.jsp">
<jsp:param name = "page" value = "checkOrders"/>
</jsp:include>

<div class = "container m-auto my-3">
	<table class = "table table-hover">
		<thead>
			<tr>
				<th scope = "col">Order ID</th>
				<th scope = "col">Status</th>
			</tr>
		</thead>
		<tbody>
			<c:if test = "${count eq 0}">
				<tr><td colspan = "2">You have no active orders</td></tr>
			</c:if>
			<c:if test = "${count ne 0}">
				<c:forEach items = "${orders}" var = "order">
					<tr>
						<td>${order.orderId}</td>
						<td>${order.status}</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
</div>

<jsp:include page = "footer.jsp"/>
</body>
</html>
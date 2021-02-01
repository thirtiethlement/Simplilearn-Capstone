<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page = "header.jsp">
<jsp:param name = "pageName" value = "Edit Order"/>
</jsp:include>

<body>

<jsp:include page = "navbar.jsp">
<jsp:param name = "page" value = "editOrder"/>
</jsp:include>

<div class = "container">
	<form id = "editOrder" action = "/admin/editOrderEndpoint" method = "post">
		<input type = "hidden" name = "id" value = "${order.orderId}">
		<div class = "my-3">
			<label for = "status" class = "form-label">Status</label>
			<input id = "status" class = "form-control" type = "text" name = "status" value = "${order.status}">
		</div>
		<div class = "m-3 text-center d-flex align-items-center">
			<button type="submit" class="btn btn-success">Submit Edit</button>
		</div>
	</form>
</div>

<jsp:include page = "footer.jsp"/>
</body>
</html>
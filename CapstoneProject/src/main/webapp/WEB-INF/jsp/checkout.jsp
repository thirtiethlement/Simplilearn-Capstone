<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page = "header.jsp">
<jsp:param name = "pageName" value = "Checkout"/>
</jsp:include>

<body>

<jsp:include page = "navbar.jsp">
<jsp:param name = "page" value = "checkout"/>
</jsp:include>

<div class = "container m-auto my-3">
	<h2>Please check over your order before confirming it</h2>
	<table class = "table table-hover">
		<thead>
			<tr>
				<th scope = "col" style = "width:200px">Image</th>
				<th scope = "col">Name</th>
				<th scope = "col">Description</th>
				<th scope = "col">Genre</th>
				<th scope = "col">Price</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items = "${sessionScope.cart}" var = "product">
				<tr>
					<td><a href = "/catalog/${product.productId}"><img src = "${product.imageRefLink}" class = "img-fluid" style = "max-height:100px"></a></td>
					<td>${product.productName}</td>
					<td>${product.description}</td>
					<td>${product.genre}</td>
					<td>${product.cost}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<div class = "row align-items-center">
		<div class = "col-6">
			<form id = "addOrder" action = "addOrder" method = "post">
				<button type="submit" class="btn btn-success">Place Order</button>
			</form>
		</div>
		<div class = "col-6">
			<form id = "emptyCart" action = "emptyCart" method = "post">
				<button type = "submit" class = "btn btn-danger">Empty Cart</button>
			</form>
		</div>
	</div>
</div>

<jsp:include page = "footer.jsp"/>
</body>
</html>
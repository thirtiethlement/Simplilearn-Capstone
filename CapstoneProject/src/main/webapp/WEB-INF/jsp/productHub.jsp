<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page = "header.jsp">
<jsp:param name = "pageName" value = "Admin Product Hub"/>
</jsp:include>

<body>

<jsp:include page = "navbar.jsp">
<jsp:param name = "page" value = "productHub"/>
</jsp:include>

<div class = "container m-auto my-3">
	<table class = "table table-hover">
		<thead>
			<tr>
				<th scope = "col" style = "width:200px">Image</th>
				<th scope = "col">Name</th>
				<th scope = "col">Description</th>
				<th scope = "col">Genre</th>
				<th scope = "col">Price</th>
				<th scope = "col">Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:if test = "${count eq 0}">
				<tr><td colspan = "6">There are currently no products in the database.</td></tr>
			</c:if>
			<c:if test = "${count ne 0}">
				<c:forEach items = "${listing}" var = "product">
					<tr>
						<td><a href = "/catalog/${product.productId}"><img src = "${product.imageRefLink}" class = "img-fluid" style = "max-height:100px"></a></td>
						<td>${product.productName}</td>
						<td>${product.description}</td>
						<td>${product.genre}</td>
						<td>${product.cost}</td>
						<td>
							<form id = "editProduct" action = "/admin/editProduct" method = "post">
								<input type = "hidden" name = "id" value = "${product.productId}">
								<button type="submit" class="btn btn-success">Edit</button>
							</form>
							<form id = "deleteProduct" action = "/admin/deleteProduct" method = "post">
								<input type = "hidden" name = "id" value = "${product.productId}">
								<button type="submit" class="btn btn-danger">Delete</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	
	<div class = "col-12">
		<a class="btn btn-success" href="/admin/addProduct" role="button">Add New Product</a>
	</div>
</div>

<jsp:include page = "footer.jsp"/>
</body>
</html>
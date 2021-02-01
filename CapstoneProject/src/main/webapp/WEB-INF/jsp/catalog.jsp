<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page = "header.jsp">
<jsp:param name = "pageName" value = "Product Catalog"/>
</jsp:include>

<body>

<jsp:include page = "navbar.jsp">
<jsp:param name = "page" value = "catalog"/>
</jsp:include>

<form id = "search" action = "search" method = "post">
	<div class="container ms-auto my-3 align-items-center">
  		<div class="col-auto">
    		<label for="search" class="col-form-label">Search:</label>
 		</div>
  		<div class="col-auto">
    		<input type="text" id="search" name = "term" class="form-control">
  		</div>
	</div>
</form>

<div class = "container m-auto my-3">
	<table class = "table table-hover">
		<thead>
			<tr>
				<th scope = "col" style = "width:200px">Image</th>
				<th scope = "col">Name</th>
				<th scope = "col">Description</th>
				<th scope = "col">Genre</th>
				<th scope = "col">Price</th>
				<th scope = "col">Add to Cart</th>
			</tr>
		</thead>
		<tbody>
			<c:if test = "${count eq 0}">
				<tr><td colspan = "6">Your search returned no results.</td></tr>
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
							<form id = "addToCart" action = "/addToCart/${product.productId}" method = "post">
								<button type="submit" class="btn btn-success">Add To Cart</button>
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
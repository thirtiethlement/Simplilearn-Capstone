<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page = "header.jsp">
<jsp:param name = "pageName" value = "${productData.productName}"/>
</jsp:include>

<body>

<div class = "container">
	<table class = "table">
		<tbody>
			<tr>
				<td><a href = "/catalog/${product.productId}"><img src = "${product.imageRefLink}" class = "img-fluid" style = "max-height:100px"></a></td>
				<td>${product.productName}</td>
				<td>${product.description}</td>
				<td>${product.genre}</td>
				<td>${product.price}</td>
				<td>
					<form id = "addToCart" action = "/addToCart/${product.productId}" method = "post">
						<button type="submit" class="btn btn-success">Add To Cart</button>
					</form>
				</td>
			</tr>
		</tbody>
	</table>
</div>

<jsp:include page = "navbar.jsp">
<jsp:param name = "page" value = "productView"/>
</jsp:include>

<jsp:include page = "footer.jsp"/>
</body>
</html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page = "header.jsp">
<jsp:param name = "pageName" value = "Add Product"/>
</jsp:include>

<body>

<jsp:include page = "navbar.jsp">
<jsp:param name = "page" value = "addProduct"/>
</jsp:include>

<div class = "container">
	<form id = "addProduct" action = "/admin/addProductEndpoint" method = "post">
		<div class = "my-3">
			<label for = "productName" class = "form-label">Product Name</label>
			<input id = "productName" class = "form-control" type = "text" name = "productName">
		</div>
		<div class = "my-3">
			<label for = "cost" class = "form-label">Cost</label>
			<input id = "cost" class = "form-control" type = "text" name = "cost">
		</div>
		<div class = "my-3">
			<label for = "description" class = "form-label">Description</label>
			<textarea id = "description" class = "form-control" name = "description" rows = "3"></textarea>
		</div>
		<div class = "my-3">
			<label for = "imageRefLink" class = "form-label">Image Link</label>
			<input id = "imageRefLink" class = "form-control" name = "imageRefLink" type = "text">
		</div>
		<div class = "my-3">
			<label for = "genre" class = "form-label">Genre</label>
			<input id = "genre" class = "form-control" name = "genre" type = "text">
		</div>
		<div class = "m-3 text-center d-flex align-items-center">
			<button type="submit" class="btn btn-success">Add to Database</button>
		</div>
	</form>
</div>

<jsp:include page = "footer.jsp"/>
</body>
</html>

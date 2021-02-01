<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page = "header.jsp">
<jsp:param name = "pageName" value = "Edit User"/>
</jsp:include>

<body>

<jsp:include page = "navbar.jsp">
<jsp:param name = "page" value = "editUser"/>
</jsp:include>

<div class = "container">
	<form id = "editUser" action = "/admin/editUserEndpoint" method = "post">
		<input type = "hidden" name = "id" value = "${user.userId}">
		<div class = "my-3">
			<label for = "username" class = "form-label">Username</label>
			<input id = "username" class = "form-control" type = "text" name = "username" value = "${user.username}">
		</div>
		<div class = "my-3">
			<label for = "password" class = "form-label">Password</label>
			<input id = "password" class = "form-control" type = "text" name = "password" value = "${user.password}">
		</div>
		<div class = "my-3">
			<label for = "emailAddress" class = "form-label">Email Address</label>
			<input id = "emailAddress" class = "form-control" type = "text" name = "emailAddress" value = "${user.emailAddress}">
		</div>
		<div class = "my-3">
			<label for = "billingAddress" class = "form-label">Street Address</label>
			<input id = "billingAddress" class = "form-control" type = "text" name = "billingAddress" value = "${user.billingAddress}">
		</div>
		<div class = "m-3 text-center d-flex align-items-center">
			<button type="submit" class="btn btn-success">Submit Edit</button>
		</div>
	</form>
</div>

<jsp:include page = "footer.jsp"/>
</body>
</html>
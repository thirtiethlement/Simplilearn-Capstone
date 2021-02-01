<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page = "header.jsp">
<jsp:param name = "pageName" value = "Admin User Hub"/>
</jsp:include>

<body>

<jsp:include page = "navbar.jsp">
<jsp:param name = "page" value = "userHub"/>
</jsp:include>

<div class = "container m-auto my-3">
	<table class = "table table-hover">
		<thead>
			<tr>
				<th scope = "col">Username</th>
				<th scope = "col">Password</th>
				<th scope = "col">Email Address</th>
				<th scope = "col">Street Address</th>
				<th scope = "col">Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items = "${listing}" var = "user">
				<tr>
					<td>${user.username}</td>
					<td>${user.password}</td>
					<td>${user.emailAddress}</td>
					<td>${user.billingAddress}</td>
					<td>
						<form id = "editUser" action = "/admin/editUser" method = "post">
							<input type = "hidden" name = "id" value = "${user.userId}">
							<button type="submit" class="btn btn-success">Edit</button>
						</form>
						<form id = "deleteUser" action = "/admin/deleteUser" method = "post">
							<input type = "hidden" name = "id" value = "${user.userId}">
							<button type="submit" class="btn btn-danger">Delete</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<jsp:include page = "footer.jsp"/>
</body>
</html>
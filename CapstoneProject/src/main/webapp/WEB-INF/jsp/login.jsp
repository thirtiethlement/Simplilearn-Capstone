<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page = "header.jsp">
<jsp:param name = "pageName" value = "Log In / Register"/>
</jsp:include>

<body>

<jsp:include page = "navbar.jsp">
<jsp:param name = "page" value = "login"/>
</jsp:include>

<div class = "container">
<div class = "row">
	<div class = "col-12 text-center align-items-center">
		<c:if test = "${registerToken ne null}">
			<h2>Registration successful for user: ${registerToken}</h2>
		</c:if>
		<c:if test = "${registerFailToken ne null}">
			<h2>A user already exists under the name ${registerFailToken}</h2>
		</c:if>
		<c:if test = "${loginFailedToken ne null}">
			<h2>${loginFailedToken}</h2>
		</c:if>
	</div>
</div>
<div class="row">
    <div class="col-6">
        <form id = "login" action = "loginEndpoint" method = "post">
        <div class = "my-3">
			<label for = "username" class = "form-label">Username</label>
			<input id = "username" class = "form-control" type = "text" name = "username">
		</div>
		<div class = "my-3">
			<label for = "password" class = "form-label">Password</label>
			<input id = "password" class = "form-control" type = "text" name = "password">
		</div>
		<div class = "m-3 text-center d-flex align-items-center">
			<button type="submit" class="btn btn-primary">Log In</button>
		</div>
        </form>
    </div>
    <div class="col-6">
        <form id = "register" action = "register" method = "post">
        <div class = "my-3">
			<label for = "username" class = "form-label">Username</label>
			<input id = "username" class = "form-control" type = "text" name = "username">
		</div>
		<div class = "my-3">
			<label for = "password" class = "form-label">Password</label>
			<input id = "password" class = "form-control" type = "text" name = "password">
		</div>
		<div class = "my-3">
			<label for = "emailAddress" class = "form-label">Email Address</label>
			<input id = "emailAddress" class = "form-control" type = "text" name = "emailAddress">
		</div>
		<div class = "my-3">
			<label for = "streetAddress" class = "form-label">Street Addresss</label>
			<input id = "streetAddress" class = "form-control" type = "text" name = "streetAddress">
		</div>
		<div class = "m-3 text-center d-flex align-items-center">
			<button type="submit" class="btn btn-primary">Register</button>
		</div>
        </form>
    </div>
</div>
</div>

<jsp:include page = "footer.jsp"/>
</body>
</html>
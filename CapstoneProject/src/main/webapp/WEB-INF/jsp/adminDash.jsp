<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page = "header.jsp">
<jsp:param name = "pageName" value = "Admin Dashboard"/>
</jsp:include>

<body>

<jsp:include page = "navbar.jsp">
<jsp:param name = "page" value = "admin"/>
</jsp:include>

<div class = "container">
	<div class = "col-4">
		<a class="btn btn-success" href="/admin/productHub" role="button">Product Hub</a>
	</div>
	<div class = "col-4">
		<a class="btn btn-success" href="/admin/userHub" role="button">User Hub</a>
	</div>
	<div class = "col-4">
		<a class="btn btn-success" href="/admin/orderHub" role="button">Order Hub</a>
	</div>
</div>

<jsp:include page = "footer.jsp"/>
</body>
</html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page = "header.jsp">
<jsp:param name = "pageName" value = "Order Successful"/>
</jsp:include>

<body>

<jsp:include page = "navbar.jsp">
<jsp:param name = "page" value = "orderSuccess"/>
</jsp:include>

<div class = "container">
<h2>Order successfully placed</h2>
</div>

<jsp:include page = "footer.jsp"/>
</body>
</html>
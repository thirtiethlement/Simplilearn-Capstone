<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<nav class = "navbar navbar-expand-lg navbar-dark bg-secondary">
	<div class = "container-fluid">
		<a class = "navbar-brand" href = "/">TrackMaster Music</a>
		<ul class = "navbar-nav me-auto">
			<li class = "nav-item"><a class = "nav-link <c:if test = "${param.page == 'home'}">active</c:if>" href = "/">Home</a></li>
			<li class = "nav-item"><a class = "nav-link <c:if test = "${param.page == 'catalog'}">active</c:if>" href = "/catalog">Products</a></li>
			<li class = "nav-item"><a class = "nav-link <c:if test = "${param.page == 'about'}">active</c:if>" href = "#">About Us</a></li>
		</ul>
		<ul class = "navbar-nav me-2">
			<c:if test = "${sessionScope.activeUser eq null}">
				<li class = "nav-item"><a class = "nav-link <c:if test = "${param.page == 'login'}">active</c:if>" href = "/login">Log In / Register</a></li>
			</c:if>
			<c:if test = "${sessionScope.activeUser ne null}">
				<span class = "navbar-text me-3">Welcome, ${sessionScope.activeUser.username}</span>
				<li class = "nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">Options</a>
          			<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            			<li><a class="dropdown-item" href="/checkout">Checkout</a></li>
            			<li><a class="dropdown-item" href="/checkOrders">Active Orders</a></li>
            			<c:if test = "${sessionScope.activeUser.role == 'admin'}">
            				<li><a class="dropdown-item" href = "/admin">Admin Portal</a></li>
            			</c:if>
            			<li><hr class="dropdown-divider"></li>
            			<li><a class="dropdown-item" href="/logout">Log Out</a></li>
            		</ul>
				</li>
				<li class = "nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="cartMenu" role="button" data-bs-toggle="dropdown" aria-expanded="false">Cart</a>
					<ul class = "dropdown-menu pull-right" aria-labelledby = "cartMenu">
						<c:if test = "${sessionScope.count eq 0}">
							<li><span class="dropdown-item-text">Your cart is empty</span></li>
						</c:if>
						<c:if test = "${sessionScope.count ne 0}">
							<c:forEach items = "${sessionScope.cart}" var = "product">
								<li><span class = "dropdown-item-text">${product.productName}, ${product.cost}</span></li>
							</c:forEach>
							<li><hr class = "dropdown-divider"></li>
							<li><a class = "dropdown-item" href = "/emptyCart">Empty Cart</a></li>
						</c:if>
					</ul>
			</c:if>
		</ul>
	</div>
</nav>
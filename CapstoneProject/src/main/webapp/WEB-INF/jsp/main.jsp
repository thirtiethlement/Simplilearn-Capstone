<jsp:include page = "header.jsp">
<jsp:param name = "pageName" value = "TrackMaster Music"/>
</jsp:include>

<body>

<jsp:include page = "navbar.jsp">
<jsp:param name = "page" value = "home"/>
</jsp:include>

<div class = "container-fluid">
	<div id="mainCarousel" class="carousel slide mx-auto my-3" data-bs-ride="carousel" style="max-width:85%">
		<ol class="carousel-indicators">
			<li data-bs-target="#mainCarousel" data-bs-slide-to="0" class="active"></li>
			<li data-bs-target="#mainCarousel" data-bs-slide-to="1"></li>
			<li data-bs-target="#mainCarousel" data-bs-slide-to="2"></li>
		</ol>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="https://s3.amazonaws.com/climb-MusicArts-images-admin/stores/4/3450/storephoto.jpg" class="d-block w-100" alt="no image" style = "max-height: 500px">
			</div>
			<div class="carousel-item">
				<img src="https://cdn.digitaldjtips.com/app/uploads/2012/12/16000058/musicstore-460px11-1204x642.jpg" class="d-block w-100" alt="image failed to load" style = "max-height:500px">
			</div>
			<div class="carousel-item">
				<img src="https://www.liveabout.com/thmb/pwO4o_iDrZRTmmhs7eOfD25Qoqw=/1500x1125/smart/filters:no_upscale()/pop-music-57bce3863df78c87634ea806.jpg" class="d-block w-100" alt="whoops" style = "max-height:500px">
			</div>
		</div>
		<a class="carousel-control-prev" href="#mainCarousel" role="button" data-slide="prev"> 
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> 
			<span class="sr-only">Previous</span>
		</a>
		<a class="carousel-control-next" href="#mainCarousel" role="button" data-slide="next"> 
			<span class="carousel-control-next-icon" aria-hidden="true"></span> 
			<span class="sr-only">Next</span>
		</a>
	</div>
</div>

<jsp:include page = "footer.jsp"/>
</body>
</html>
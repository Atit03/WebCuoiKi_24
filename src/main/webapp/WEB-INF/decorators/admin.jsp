<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/" var="URL"></c:url>

<!DOCTYPE HTML>
<html>
	<head>
	<title>UTESHOP</title>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,500,600,700" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Rokkitt:100,300,400,700" rel="stylesheet">
	
	<!-- Animate.css -->
	<link rel="stylesheet" href="${URL}assets/css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="${URL}assets/css/icomoon.css">
	<!-- Ion Icon Fonts-->
	<link rel="stylesheet" href="${URL}assets/css/ionicons.min.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="${URL}assets/css/bootstrap.min.css">

	<!-- Magnific Popup -->
	<link rel="stylesheet" href="${URL}assets/css/magnific-popup.css">

	<!-- Flexslider  -->
	<link rel="stylesheet" href="${URL}assets/css/flexslider.css">

	<!-- Owl Carousel -->
	<link rel="stylesheet" href="${URL}assets/css/owl.carousel.min.css">
	<link rel="stylesheet" href="${URL}assets/css/owl.theme.default.min.css">
	
	<!-- Date Picker -->
	<link rel="stylesheet" href="${URL}assets/css/bootstrap-datepicker.css">
	<!-- Flaticons  -->
	<link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">

	<!-- Theme style  -->
	<link rel="stylesheet" href="${URL}assets/css/style.css">

	</head>
	<body>
		
	<div class="colorlib-loader"></div>

	<div id="page">
		<%@ include file ="/common/admin/header.jsp" %>

		<sitemesh:write property="body"/>
		
		<footer id="colorlib-footer" role="contentinfo">
			<div class="container">
				<div class="row row-pb-md">
					<div class="col footer-col colorlib-widget">
						<h4>About Footwear</h4>
						<p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life</p>
						<p>
							<ul class="colorlib-social-icons">
								<li><a href="#"><i class="icon-twitter"></i></a></li>
								<li><a href="#"><i class="icon-facebook"></i></a></li>
								<li><a href="#"><i class="icon-linkedin"></i></a></li>
								<li><a href="#"><i class="icon-dribbble"></i></a></li>
							</ul>
						</p>
					</div>
					<div class="col footer-col colorlib-widget">
						<h4>Customer Care</h4>
						<p>
							<ul class="colorlib-footer-links">
								<li><a href="#">Contact</a></li>
								<li><a href="#">Returns/Exchange</a></li>
								<li><a href="#">Gift Voucher</a></li>
								<li><a href="#">Wishlist</a></li>
								<li><a href="#">Special</a></li>
								<li><a href="#">Customer Services</a></li>
								<li><a href="#">Site maps</a></li>
							</ul>
						</p>
					</div>
					<div class="col footer-col colorlib-widget">
						<h4>Information</h4>
						<p>
							<ul class="colorlib-footer-links">
								<li><a href="#">About us</a></li>
								<li><a href="#">Delivery Information</a></li>
								<li><a href="#">Privacy Policy</a></li>
								<li><a href="#">Support</a></li>
								<li><a href="#">Order Tracking</a></li>
							</ul>
						</p>
					</div>

					<div class="col footer-col">
						<h4>News</h4>
						<ul class="colorlib-footer-links">
							<li><a href="blog.html">Blog</a></li>
							<li><a href="#">Press</a></li>
							<li><a href="#">Exhibitions</a></li>
						</ul>
					</div>

					<div class="col footer-col">
						<h4>Contact Information</h4>
						<ul class="colorlib-footer-links">
							<li>291 South 21th Street, <br> Suite 721 New York NY 10016</li>
							<li><a href="tel://1234567920">+ 1235 2355 98</a></li>
							<li><a href="mailto:info@yoursite.com">info@yoursite.com</a></li>
							<li><a href="#">yoursite.com</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="copy">
				<div class="row">
					<div class="col-sm-12 text-center">
						<p>
							<span><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></span> 
							<span class="block">Demo Images: <a href="http://unsplash.co/" target="_blank">Unsplash</a> , <a href="http://pexels.com/" target="_blank">Pexels.com</a></span>
						</p>
					</div>
				</div>
			</div>
		</footer>
	</div>
	<script src="${URL}assets/js/aos.js"></script>
	<script src="${URL}assets/js/jquery.animateNumber.min.js"></script>
	<!-- jQuery -->
	<script src="${URL}assets/js/jquery.min.js"></script>
   <!-- popper -->
   <script src="${URL}assets/js/popper.min.js"></script>
   <!-- bootstrap 4.1 -->
   <script src="${URL}assets/js/bootstrap.min.js"></script>
   <!-- jQuery easing -->
   <script src="${URL}assets/js/jquery.easing.1.3.js"></script>
	<!-- Waypoints -->
	<script src="${URL}assets/js/jquery.waypoints.min.js"></script>
	<!-- Flexslider -->
	<script src="${URL}assets/js/jquery.flexslider-min.js"></script>
	<!-- Owl carousel -->
	<script src="${URL}assets/js/owl.carousel.min.js"></script>
	<!-- Magnific Popup -->
	<script src="${URL}assets/js/jquery.magnific-popup.min.js"></script>
	<script src="${URL}assets/js/magnific-popup-options.js"></script>
	<!-- Date Picker -->
	<script src="${URL}assets/js/bootstrap-datepicker.js"></script>
	<!-- Stellar Parallax -->
	<script src="${URL}assets/js/jquery.stellar.min.js"></script>
	<!-- Main -->
	<script src="${URL}assets/js/main.js"></script>

	</body>
</html>


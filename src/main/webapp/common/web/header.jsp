<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<nav class="colorlib-nav" role="navigation">
		<div class="top-menu">
			<div class="container">
				<div class="row">
					<div class="col-sm-7 col-md-9">
						<div id="colorlib-logo">
							<a href="#">UTESHOP</a>
						</div>
					</div>
					<div class="col-sm-5 col-md-3">
						<form action="${pageContext.request.contextPath}/search" method="post" class="search-wrap">
							<div class="form-group">
								<input name="keyword" type="search" class="form-control search" placeholder="Search">
								<button class="btn btn-primary submit-search text-center" type="submit">
									<span class="material-symbols-outlined" style="margin-top: 6px;"> search</span>
								</button>
							</div>
						</form>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12 text-left menu-1">
						<ul>
							<li class="active"><a href="${pageContext.request.contextPath}/home">Home</a></li>
							<li><a href="${pageContext.request.contextPath}/men">Men</a></li>
							<li><a href="${pageContext.request.contextPath}/women">Women</a></li>
							<li><a href="${pageContext.request.contextPath}/about">About</a></li>
							<li><a href="${pageContext.request.contextPath}/contact">Contact</a></li>


							<li class="cart"><a href="${pageContext.request.contextPath}/login">Login</a></li>

							<li class="cart">
								<a href="${pageContext.request.contextPath}/cart"><span
										class="material-symbols-outlined"
										style="font-size: 16px;vertical-align: middle; line-height: 1; margin-top: -5px;">
										shopping_cart
									</span> Cart </a>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="sale">
			<div class="container">
				<div class="row">
					<div class="col-sm-8 offset-sm-2 text-center">
						<div class="row">
							<div class="owl-carousel2">
								<div class="item">
									<div class="col">
										<h3>
											<a href="#">25% off (Almost) Everything! Use Code: Summer
												Sale</a>
										</h3>
									</div>
								</div>
								<div class="item">
									<div class="col">
										<h3>
											<a href="#">Our biggest sale yet 50% off all summer shoes</a>
										</h3>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</nav>
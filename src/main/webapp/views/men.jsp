<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<div class="breadcrumbs-two">
	<div class="container">
		<div class="row">
			<div class="col">
				<div class="breadcrumbs-img"
					style="background-image: url(${URL}assets/images/nenn.jpg);">
					<h2 style="color: red;">Men's</h2>
				</div>
				<div class="menu text-center">
					<p>
						<a href="${pageContext.request.contextPath}/newM">New Products</a> <a href="${pageContext.request.contextPath}/bestsellerM">Best Sellers</a>
					</p>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="colorlib-featured">
	<div class="container">
		<div class="row">
			<div class="col-sm-4 text-center">
				<div class="featured">
					<div class="featured-img featured-img-2"
						style="background-image: url(${URL}assets/images/ThuongNam.jpg);">
						<h2>Casuals</h2>

					</div>
				</div>
			</div>
			<div class="col-sm-4 text-center">
				<div class="featured">
					<div class="featured-img featured-img-2"
						style="background-image: url(${URL}assets/images/CongsoNam.jpg);">
						<h2>Dress</h2>

					</div>
				</div>
			</div>
			<div class="col-sm-4 text-center">
				<div class="featured">
					<div class="featured-img featured-img-2"
						style="background-image: url(${URL}assets/images/item-11.jpg);">
						<h2>Sports</h2>

					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="colorlib-product">
	<div class="container">
		<div class="row">
			<div class="col-lg-3 col-xl-3">
				<div class="row">
					<div class="col-sm-12">
						<div class="side border mb-1">
							<h3>Brand</h3>
							<ul>
								<c:forEach var="cate" items="${lcate}">
									<li><a
										href="${pageContext.request.contextPath}/categoryM?cid=${cate.categoryid}">${cate.categoryname}</a></li>
								</c:forEach>
							</ul>

						</div>
					</div>

				</div>
			</div>
			<div class="col-lg-9 col-xl-9">
				<div class="row row-pb-md">
					<c:forEach var="product" items="${lproduct}" varStatus="status">
						<div class="col-lg-4 mb-4 text-center">
							<div class="product-entry border">
								<a
									href="${pageContext.request.contextPath}/productDetail?id=${product.productid}"
									class="prod-img"> <img src="${product.image}"
									class="img-fluid" alt="Free html5 bootstrap 4 template">
								</a>
								<div class="desc">
									<h2>
										<a href="#">${product.productname}</a>
									</h2>
									<span class="price">${product.price}</span>
								</div>
							</div>
						</div>


						<!-- Thêm <div class="w-100"></div> sau mỗi 4 sản phẩm -->
						<c:if test="${status.index % 3 == 2}">
							<div class="w-100"></div>
						</c:if>
					</c:forEach>
				</div>
				<div class="row">
					<div class="col-md-12 text-center">
						<div class="block-27">
							<ul>
								<c:if test="${currentPage > 1}">
									<c:if test="${param.cid != null}">
										<li><a
											href="${pageContext.request.contextPath}/categoryM?cid=${param.cid}&page=${currentPage - 1}">&lt;</a></li>
									</c:if>
									<c:if test="${param.cid == null}">
										<li><a
											href="${pageContext.request.contextPath}/men?page=${currentPage - 1}">&lt;</a></li>
									</c:if>
								</c:if>
								<c:forEach var="i" begin="1" end="${totalPages}">
									<li class="${i == currentPage ? 'active' : ''}">
										<c:if test="${param.cid != null}">
										<a href="${pageContext.request.contextPath}/categoryM?cid=${param.cid}&page=${i}">${i}</a>
										</c:if>
										<c:if test="${param.cid == null}">
										<a href="${pageContext.request.contextPath}/men?page=${i}">${i}</a>
										</c:if>
									</li>
								</c:forEach>
								<c:if test="${currentPage < totalPages}">
									<c:if test="${param.cid != null}">
										<li><a
											href="${pageContext.request.contextPath}/categoryM?cid=${param.cid}&page=${currentPage + 1}">&gt;</a></li>
									</c:if>
									<c:if test="${param.cid == null}">
										<li><a
											href="${pageContext.request.contextPath}/men?page=${currentPage + 1}">&gt;</a></li>
									</c:if>
								</c:if>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

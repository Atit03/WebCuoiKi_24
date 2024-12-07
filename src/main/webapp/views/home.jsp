<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<div class="colorlib-intro">
			<div class="container">
				<div class="row">
					<div class="col-sm-12 text-center">
						<h2 class="intro">It started with a simple idea: Create quality, well-designed products that I wanted myself.</h2>
					</div>
				</div>
			</div>
		</div>
<div class="colorlib-product">
			<div class="container-fluid">
				<div class="row">
					<div class="col-sm-6 text-center">
						<div class="featured">
							<a href="${pageContext.request.contextPath}/men" class="featured-img" style="background-image: url(${URL}assets/images/men.jpg);"></a>
							<div class="desc">
								<h2><a href="${pageContext.request.contextPath}/men">Shop Men's Collection</a></h2>
							</div>
						</div>
					</div>
					<div class="col-sm-6 text-center">
						<div class="featured">
							<a href="${pageContext.request.contextPath}/women" class="featured-img" style="background-image: url(${URL}assets/images/women.jpg);"></a>
							<div class="desc">
								<h2><a href="${pageContext.request.contextPath}/woman">Shop Women's Collection</a></h2>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
<div class="colorlib-product">
	<div class="container">
		<div class="row">
			<div class="col-sm-8 offset-sm-2 text-center colorlib-heading">
				<h2>Best Sellers</h2>
			</div>
		</div>
		<div class="row row-pb-md">
			<c:forEach var="product" items="${productList}" varStatus="status">
				<div class="col-lg-3 mb-4 text-center">
					<div class="product-entry border">
						<a
							href="${pageContext.request.contextPath}/productDetail?id=${product.productid}"
							class="prod-img"> <img
							src="${product.image}"
							class="img-fluid" alt="${product.productname}">
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
				<c:if test="${status.index % 4 == 3}">
					<div class="w-100"></div>
				</c:if>
			</c:forEach>
		</div>
	
	</div>
</div>

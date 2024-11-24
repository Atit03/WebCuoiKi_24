<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<div class="colorlib-product">
	<div class="container">
		<div class="row">
			<div class="col-sm-8 offset-sm-2 text-center colorlib-heading">
				<h2>Best Sellers</h2>
			</div>
		</div>
		<div class="row row-pb-md">
			<c:forEach var="product" items="${productList}">
				<div class="col-lg-3 mb-4 text-center">
					<div class="product-entry border">
						<a href="${pageContext.request.contextPath}/productDetail?id=${product.productid}" class="prod-img"> <img
							src="<c:url value='/image?fname=${product.image}'/>"
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
			</c:forEach>
		</div>
		<div class="row">
			<div class="col-md-12 text-center">
				<p>
					<a href="#" class="btn btn-primary btn-lg">Shop All Products</a>
				</p>
			</div>
		</div>
	</div>
</div>
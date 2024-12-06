<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<div class="colorlib-product">
	<div class="container">
		<div class="row row-pb-lg">
			<div class="col-md-12">
				<div class="product-name d-flex">
					<div class="one-forth text-left px-4">
						<span>Product Details</span>
					</div>
					<div class="one-eight text-center">
						<span>Price</span>
					</div>
					<div class="one-eight text-center">
						<span>Quantity</span>
					</div>
				</div>
				<c:forEach var="product" items="${orderdetailList}">
					<div class="product-cart d-flex ">
						<div class="one-forth">
							<div class="product-img"
								style="background-image: url(${product.image});"></div>
							<div class="display-tc">
								<h3>${product.productname}</h3>
							</div>
						</div>
						<div class="one-eight text-center">
							<div class="display-tc">
								<span class="price" id="">${product.price}</span>
							</div>
						</div>
						<div class="one-eight text-center">
							<div class="display-tc">
								<span class="price" id="">${product.quantity}</span>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		
	</div>

	
		
</div>
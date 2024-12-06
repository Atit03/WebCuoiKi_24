<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<div class="colorlib-product">
	<div class="container">
		<div class="row row-pb-lg">
			<div class="col-md-12">
				<div class="product-name d-flex">
					<div class="one-eight text-center">
						<span>Orderid</span>
					</div>
					<div class="one-eight text-center">
						<span>FullName</span>
					</div>
					<div class="one-forth text-left px-4">
						<span>Address</span>
					</div>
					<div class="one-eight text-center">
						<span>Phone</span>
					</div>
					<div class="one-eight text-center">
						<span>Total</span>
					</div>
					<div class="one-eight text-center">
						<span>PaymentMethod</span>
					</div>
					<div class="one-eight text-center">
						<span>Action</span>
					</div>
				</div>
				<c:forEach var="product" items="${orderList}">
					<div class="product-cart d-flex">
						<div class="one-eight text-center">
							<div class="display-tc">
								<h3>${product.orderid}</h3>
							</div>
						</div>
						<div class="one-eight text-center">
							<div class="display-tc">
								<span class="price" id="">${product.fullname}</span>
							</div>
						</div>
						<div class="one-forth">
							<div class="display-tc">
								<span class="prices" id="">${product.address}</span>
							</div>
						</div>
						<div class="one-eight text-center">
							<div class="display-tc">
								<span class="prices" id="">${product.phone}</span>
							</div>
						</div>
						<div class="one-eight text-center">
							<div class="display-tc">
								<span class="prices" id="">${product.total}</span>
							</div>
						</div>
						<div class="one-eight text-center">
							<div class="display-tc">
								<span class="prices" id="">${product.paymentmethod}</span>
							</div>
						</div>
						<div class="one-eight text-center">
							<div class="display-tc">
								<a href="${pageContext.request.contextPath}/orderdetail?id=${product.orderid}" >Xem các sản phẩm</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>
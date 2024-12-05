<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<div class="breadcrumbs">
	<div class="container">
		<div class="row">
			<div class="col">
				<p class="bread">
					<span><a href="index.html">Home</a></span> / <span>Shopping
						Cart</span>
				</p>
			</div>
		</div>
	</div>
</div>


<div class="colorlib-product">
	<div class="container">
		<div class="row row-pb-lg">
			<div class="col-md-10 offset-md-1">
				<div class="process-wrap">
					<div class="process text-center active">
						<p>
							<span>01</span>
						</p>
						<h3>Shopping Cart</h3>
					</div>
					<div class="process text-center">
						<p>
							<span>02</span>
						</p>
						<h3>Checkout</h3>
					</div>
					<div class="process text-center">
						<p>
							<span>03</span>
						</p>
						<h3>Order Complete</h3>
					</div>
				</div>
			</div>
		</div>
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
					<div class="one-eight text-center">
						<span>Total</span>
					</div>
					<div class="one-eight text-center px-4">
						<span>Remove</span>
					</div>
				</div>
				<c:forEach var="product" items="${cartList}">
					<div class="product-cart d-flex product-cart-${product.cartitemid}">
						<div class="one-forth">
							<div class="product-img"
								style="background-image: url(${product.image});"></div>
							<div class="display-tc">
								<h3>${product.productname}</h3>
							</div>
						</div>
						<div class="one-eight text-center">
							<div class="display-tc">
								<span class="price" id="price-${product.cartitemid}">${product.price}</span>
							</div>
						</div>
						<div class="one-eight text-center">
							<div class="display-tc">
								<input type="number" id="quantity-${product.cartitemid}"
									name="quantity" class="form-control input-number text-center"
									value="${product.quantity}" min="1" max="100"
									onchange="updateQuantity(${product.cartitemid}, this.value)">
							</div>
						</div>
						<div class="one-eight text-center">
							<div class="display-tc">
								<span class="prices" id="total-${product.cartitemid}">${product.price * product.quantity}</span>
							</div>
						</div>
						<div class="one-eight text-center">
							<div class="display-tc">
								<a href="#" class="closed"
									onclick="removeFromCart(${product.cartitemid})"></a>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="row row-pb-lg">
			<div class="col-md-12">
				<div class="total-wrap">
					<div class="row">
						<div class="col-sm-8">
							<form action="javascript:void(0);" onsubmit="applyCoupon()">
								<div class="row form-group">
									<div class="col-sm-9">
										<input type="number" name="quantity"
											class="form-control input-number"
											placeholder="Enter your coupon value..." min="0">
									</div>
									<div class="col-sm-3">
										<input type="submit" value="Apply Coupon"
											class="btn btn-primary">
									</div>
								</div>
							</form>
							<!-- Hiển thị danh sách địa chỉ và nút thêm địa chỉ -->
							<div class="address-section mt-4">
								<h3>Select Address</h3>
								<c:forEach var="address" items="${addressList}">
									<div class="form-check">
										<input class="form-check-input" type="radio" name="address"
											id="address-${address.addressid}"
											value="${address.addressid}"> <label
											class="form-check-label" for="address-${address.addressid}">
											${address.fullname}, ${address.phone}, ${address.address} </label>
									</div>
								</c:forEach>
								<button type="button" class="btn btn-secondary mt-3">
									<a href="${pageContext.request.contextPath}/addAddressForm"
										class="text-white text-decoration-none">Add New Address</a>
								</button>

							</div>
						</div>


						<div class="col-lg-4">
							<div class="row">
								<div class="col-md-12">
									<div class="cart-detail">
										<h2>Cart Total</h2>
										<ul>
											<li><span>Subtotal:</span> <span id="totalCart">$200.00</span>
											</li>
											<li><span>Discount:</span> <span id="discountInput">$45.00</span>
											<li><span><strong>Total:</strong></span> <span
												id="cartTotal">$450.00</span></li>
										</ul>

									</div>
								</div>

								<div class="w-100"></div>

								<div class="col-md-12">
									<div class="cart-detail">
										<h2>Payment Method</h2>
										<div class="form-group">
											<div class="col-md-12">
												<div class="radio">
													<label><input type="radio" name="optradio"
														value="COD"> COD</label>
												</div>
											</div>
										</div>

									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12 text-center">
									<p>
										<a href="#" class="btn btn-primary">Place an order</a>
									</p>
									<form action="${pageContext.request.contextPath}/oder" method="POST">
										<!-- Các trường input ẩn để gửi thông tin -->
										<input type="hidden" name="addressid" id="addressid">
										<input type="hidden" name="total" id="total"> <input
											type="hidden" name="paymentmethod" id="paymentmethod">
										<!-- Nút để đặt hàng -->
										<button type="submit" class="btn btn-primary" id="submitOrder">Place
											an order</button>
									</form>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>

		</div>
	</div>

	<div class="row">
		<div
			class="col-sm-8 offset-sm-2 text-center colorlib-heading colorlib-heading-sm">
			<h2>Related Products</h2>
		</div>
	</div>
	<div class="row">
		<div class="col-md-3 col-lg-3 mb-4 text-center">
			<div class="product-entry border">
				<a href="#" class="prod-img"> <img src="images/item-1.jpg"
					class="img-fluid" alt="Free html5 bootstrap 4 template">
				</a>
				<div class="desc">
					<h2>
						<a href="#">Women's Boots Shoes Maca</a>
					</h2>
					<span class="price">$139.00</span>
				</div>
			</div>
		</div>
		<div class="col-md-3 col-lg-3 mb-4 text-center">
			<div class="product-entry border">
				<a href="#" class="prod-img"> <img src="images/item-2.jpg"
					class="img-fluid" alt="Free html5 bootstrap 4 template">
				</a>
				<div class="desc">
					<h2>
						<a href="#">Women's Minam Meaghan</a>
					</h2>
					<span class="price">$139.00</span>
				</div>
			</div>
		</div>
		<div class="col-md-3 col-lg-3 mb-4 text-center">
			<div class="product-entry border">
				<a href="#" class="prod-img"> <img src="images/item-3.jpg"
					class="img-fluid" alt="Free html5 bootstrap 4 template">
				</a>
				<div class="desc">
					<h2>
						<a href="#">Men's Taja Commissioner</a>
					</h2>
					<span class="price">$139.00</span>
				</div>
			</div>
		</div>
		<div class="col-md-3 col-lg-3 mb-4 text-center">
			<div class="product-entry border">
				<a href="#" class="prod-img"> <img src="images/item-4.jpg"
					class="img-fluid" alt="Free html5 bootstrap 4 template">
				</a>
				<div class="desc">
					<h2>
						<a href="#">Russ Men's Sneakers</a>
					</h2>
					<span class="price">$139.00</span>
				</div>
			</div>
		</div>
	</div>
</div>
</div>


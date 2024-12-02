<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<div class="colorlib-product">
	<div class="container">
		<div class="row row-pb-lg product-detail-wrap">
			<div class="col-sm-8">
				<div class="owl-carousel">
                    <c:forEach var="image" items="${product.images}">
                        <div class="item">
                            <div class="product-entry border">
                                <a href="#" class="prod-img">
                                    <img src="${image}" class="img-fluid" alt="Product Image">
                                </a>
                            </div>
                        </div>
                    </c:forEach>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="product-desc">
					<h3>${product.productname}</h3>
					<p class="price">
						<span>${product.price}</span> <span class="rate"> <i
							class="icon-star-full"></i> <i class="icon-star-full"></i> <i
							class="icon-star-full"></i> <i class="icon-star-full"></i> <i
							class="icon-star-half"></i> (74 Rating)
						</span>
					</p>
					<p>${product.description}</p>
					<div class="input-group mb-4">
						<span class="input-group-btn">
							<button type="button" class="quantity-left-minus btn"
								data-type="minus" data-field="" style="padding: 11px;">
								<span class="material-symbols-outlined" style="font-size: 23px; vertical-align: middle; line-height: 1; padding: 0; margin: 0;">arrow_circle_down</span>
							</button>
						</span> <input type="text" id="quantity" name="quantity"
							class="form-control input-number" value="1" min="1" max="100">
						<span class="input-group-btn ml-1">
							<button type="button" class="quantity-right-plus btn"
								data-type="plus" data-field="" style="padding: 11px;">
								<span class="material-symbols-outlined" style="font-size: 23px; vertical-align: middle; line-height: 1; padding: 0; margin: 0;">arrow_circle_up</span>
							</button>
						</span>
					</div>
					<div class="row">
						<div class="col-sm-12 text-center">
							<p class="addtocart">
								<a href="cart.html" class="btn btn-primary btn-addtocart">
								<span class="material-symbols-outlined" style="font-size: 14px;">add_shopping_cart</span></i> Add to Cart</a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
</div>
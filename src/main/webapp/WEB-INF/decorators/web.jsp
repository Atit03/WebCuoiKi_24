<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/" var="URL"></c:url>

<!DOCTYPE HTML>
<html>
<head>
<title>UTESHOP</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:300,400,500,600,700"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Rokkitt:100,300,400,700"
	rel="stylesheet">
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
		<c:choose>
			<c:when test="${sessionScope.account == null}">
				<%@ include file="/common/web/header.jsp"%>
			</c:when>
			<c:when
				test="${sessionScope.account != null && sessionScope.account.roleid == 1}">
				<%@ include file="/common/admin/header.jsp"%>
			</c:when>
			<c:otherwise>
				<%@ include file="/common/user/header.jsp"%>
			</c:otherwise>
		</c:choose>
		<sitemesh:write property="body" />
		<%@ include file="/common/web/brand.jsp"%>
		<footer id="colorlib-footer" role="contentinfo">
			<div class="container">
				<div class="row row-pb-md">
					<div class="col footer-col colorlib-widget">
						<h4>About Footwear</h4>
						<p>Even the all-powerful Pointing has no control about the
							blind texts it is an almost unorthographic life</p>
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
							<li>291 South 21th Street, <br> Suite 721 New York NY
								10016
							</li>
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
							<span> <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
								Copyright &copy;<script>document.write(new Date().getFullYear());</script>
								All rights reserved | This template is made with <i
								class="icon-heart" aria-hidden="true"></i> by <a
								href="https://colorlib.com" target="_blank">Colorlib</a> <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
							</span> <span class="block">Demo Images: <a
								href="http://unsplash.co/" target="_blank">Unsplash</a> , <a
								href="http://pexels.com/" target="_blank">Pexels.com</a></span>
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
	<script>
		$(document).ready(function(){

		var quantitiy=0;
		   $('.quantity-right-plus').click(function(e){
		        
		        // Stop acting like a button
		        e.preventDefault();
		        // Get the field name
		        var quantity = parseInt($('#quantity').val());
		        
		        // If is not undefined
		            
		            $('#quantity').val(quantity + 1);

		          
		            // Increment
		        
		    });

		     $('.quantity-left-minus').click(function(e){
		        // Stop acting like a button
		        e.preventDefault();
		        // Get the field name
		        var quantity = parseInt($('#quantity').val());
		        
		        // If is not undefined
		      
		            // Increment
		            if(quantity>0){
		            $('#quantity').val(quantity - 1);
		            }
		    });
		    
		});
		
	</script>
	<script>
	document.querySelector('.btn-addtocart').addEventListener('click', function(e) {
	    e.preventDefault(); // Ngừng hành động mặc định của button

	    // Lấy giá trị từ form
	    const quantity = document.getElementById('quantity').value;
	    const productid = '${product.productid}'; // Chèn productId từ backend
	    const price = '${product.price}'; // Chèn giá từ backend
	    const productname = '${product.productname}'; // Chèn tên sản phẩm từ backend
	    const image = '${product.images[0]}';
	    // Kiểm tra giá trị của các biến có hợp lệ không
	    if (!quantity || !productid || !price || !productname) {
	        alert('Missing product information!');
	        return;
	    }

	    // Gửi yêu cầu AJAX để thêm sản phẩm vào giỏ hàng
	    fetch('${pageContext.request.contextPath}/add-to-cart', {
	        method: 'POST',
	        headers: {
	            'Content-Type': 'application/json'
	        },
	        body: JSON.stringify({
	            productid: productid, 
	            quantity: quantity,
	            price: price, 
	            productname: productname,
	            image:image
	        })
	    })
	    .then(response => response.text()) // Nhận dữ liệu dưới dạng văn bản thay vì JSON để kiểm tra
	    .then(data => {
	        console.log(data); // Kiểm tra dữ liệu phản hồi từ server
	        try {
	            const jsonData = JSON.parse(data); // Nếu có thể, chuyển nó thành JSON
	            if (jsonData.status === 'success') {
	                alert('Product added to cart!');
	                // Cập nhật giỏ hàng hoặc giao diện sau khi thêm sản phẩm vào giỏ
	            } else {
	                alert('Error adding product to cart , Please log in!');
	            }
	        } catch (error) {
	            console.error('Error parsing JSON:', error);
	            alert('Error parsing server response!');
	        }
	    })
	    .catch(error => {
	        console.error('Error adding to cart:', error);
	        alert('Error adding to cart!');
	    });
	});


	</script>
	<script>
	$(document).ready(function() {
	    updateCartTotal(); // Gọi hàm tính toán tổng giỏ hàng ngay khi trang được tải
	    updateFinalTotal();
	});

	function updateQuantity(cartitemid, newQuantity) {
	    // Kiểm tra số lượng hợp lệ
	    if (newQuantity < 1 || newQuantity > 100) {
	        alert("Số lượng phải nằm trong khoảng 1 đến 100");
	        return;
	    }

	    // Lấy giá của sản phẩm
	    var price = parseFloat($("#price-" + cartitemid).text().replace('$', '').trim()); // Giả sử giá sản phẩm được hiển thị trong một phần tử có id "price-<cartitemid>"
	    
	    // Tính lại tổng giá trị sản phẩm
	    var newTotal = price * newQuantity;
	    $("#total-" + cartitemid).text(newTotal.toFixed(2)); // Cập nhật tổng tiền của sản phẩm

	    // Gửi yêu cầu AJAX để cập nhật số lượng
	    $.ajax({
	        url: "${pageContext.request.contextPath}/updateCartItem", 
	        type: "POST",
	        data: { cartitemid: cartitemid, quantity: newQuantity },
	        success: function(response) {
	            // Chỉ cần cập nhật lại tổng giỏ hàng và sản phẩm nếu cần
	            updateCartTotal();  // Cập nhật tổng giỏ hàng sau khi cập nhật số lượng
	            updateFinalTotal(); // Cập nhật tổng cuối cùng
	        },
	        error: function() {
	            alert("Có lỗi xảy ra khi cập nhật giỏ hàng.");
	        }
	    });
	}
	function removeFromCart(cartitemid) {
	    // Hiển thị hộp thoại xác nhận xóa
	    if (confirm("Bạn có chắc chắn muốn xóa sản phẩm này khỏi giỏ hàng?")) {
	        // Gửi yêu cầu xóa sản phẩm từ giỏ hàng
	        $.ajax({
	            url: "${pageContext.request.contextPath}/removeCartItem", // Địa chỉ URL xóa sản phẩm
	            type: "POST",
	            data: { cartitemid: cartitemid }, // Gửi ID của sản phẩm cần xóa
	            success: function(response) {
	                // Nếu xóa thành công, cập nhật giao diện
	                // Xóa sản phẩm khỏi giao diện
	                $(".product-cart-" + cartitemid).remove(); 

	                // Cập nhật lại tổng giỏ hàng và tổng cuối cùng
	                updateCartTotal(); 
	                updateFinalTotal(); 

	                // Hiển thị thông báo thành công
	                alert("Sản phẩm đã được xóa khỏi giỏ hàng.");
	            },
	            error: function() {
	                // Nếu có lỗi trong quá trình xóa, hiển thị thông báo lỗi
	                alert("Có lỗi xảy ra khi xóa sản phẩm.");
	            }
	        });
	    }
	}



	function updateCartTotal() {
	    var totalCart = 0;

	    // Lặp qua tất cả các sản phẩm trong giỏ hàng để tính tổng
	    $(".product-cart").each(function() {
	        var productTotal = parseFloat($(this).find(".prices").text().replace('$', '').trim()); // Giả sử tổng tiền của mỗi sản phẩm được lưu trong class "prices"
	        totalCart += productTotal;
	    });

	    // Cập nhật tổng giỏ hàng
	    $("#totalCart").text('$' + totalCart.toFixed(2));
	}

	function updateFinalTotal() {
	    // Lấy tổng phụ từ phần tử #totalCart và chuyển đổi sang số thực
	    var subtotal = parseFloat($("#totalCart").text().replace('$', '').trim());

	    // Lấy giá trị giảm giá từ phần tử #discountInput và chuyển đổi sang số thực
	    var discount = parseFloat($("#discountInput").text().replace('$', '').trim());

	    // Kiểm tra giá trị giảm giá hợp lệ
	    if (isNaN(discount) || discount < 0) {
	        discount = 0; // Nếu giá trị giảm giá không hợp lệ, đặt bằng 0
	    }

	    // Tính tổng cuối cùng sau khi áp dụng giảm giá
	    var finalTotal = subtotal - discount;

	    // Đảm bảo tổng cuối cùng không nhỏ hơn 0
	    if (finalTotal < 0) {
	        finalTotal = 0;
	    }

	    // Cập nhật giá trị tổng cuối cùng vào #cartTotal
	    $("#cartTotal").text('$' + finalTotal.toFixed(2));
	}
</script>
	

</body>
</html>


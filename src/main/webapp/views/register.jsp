<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<body class="d-flex flex-column">
	<main class="flex-shrink-0">
		<!-- Page content-->
		<section class="py-5">
			<div class="container px-5">
				<!-- Contact form-->
				<div class="bg-light rounded-3 py-5 px-4 px-md-5 mb-5">
					<div class="text-center mb-5">
						<h1 class="fw-bolder">Đăng Ký</h1>
					</div>
					<div class="row gx-5 justify-content-center">
						<div class="col-lg-8 col-xl-6">
							<form action="${pageContext.request.contextPath}/register"
								method="post" class="form-horizontal form-without-legend"
								role="form">
								<!-- Email input -->
								<div class="form-floating mb-3">
									<label for="email">Email</label> <input class="form-control"
										id="email" name="email" type="text"
										placeholder="Nhập email..." required  />
								</div>
								<!-- Password input -->
								<div class="form-floating mb-3">
									<label for="password">Password</label> <input
										class="form-control" id="password" name="password"
										type="password" placeholder="Nhập mật khẩu..."
										required />
								</div>
								<!-- RePassword input -->
								<div class="form-floating mb-3">
									<label for="re_pass">Password</label> <input
										class="form-control" id="re_pass" name="re_pass"
										type="password" placeholder="Nhập lại mật khẩu..."
										required />
								</div>
								<!-- Name input -->
								<div class="form-floating mb-3">
									<label for="username">Phone</label> <input class="form-control"
										id=""username"" name=""username"" type="text"
										placeholder="Nhập số điện thoại..."
										required />
								</div>
								<!-- Phone input -->
								<div class="form-floating mb-3">
									<label for="phone">Phone</label> <input class="form-control"
										id="phone" name="phone" type="text"
										placeholder="Nhập số điện thoại..."
										required />
								</div>
								<!-- Submit Button -->
								<div class="text-center mb-3">
									<button class="btn btn-primary btn-lg" id="submitButton"
										type="submit">Đăng ký</button>
								</div>
								<!-- Register link -->
								<div class="text-center">
									<p>
										Đã có tài khoản? <a
											href="${pageContext.request.contextPath}/login"
											class="text-primary">Đăng nhập</a>
									</p>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</section>
	</main>

	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<body class="d-flex flex-column">
	<main class="flex-shrink-0">
		<!-- Page content-->
		<section class="py-5">
			<div class="container px-5">
				<!-- Contact form-->
				<form action="${pageContext.request.contextPath}/VerifyCode"
					method="post" class="form-horizontal form-without-legend"
					role="form">
					<div class="form-floating mb-3">
						<label for="phone">Code</label> <input class="form-control"
							name="authcode" type="text" placeholder="Nhập code..." required />
					</div>
					<div class="text-center mb-3">
						<button class="btn btn-primary btn-lg" id="submitButton"
							type="submit">Kich hoat</button>
					</div>

				</form>

			</div>
		</section>
	</main>

	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>

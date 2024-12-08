<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<body class="d-flex flex-column">
	<main class="flex-shrink-0">
		<!-- Page content-->
		<section class="py-5">
			<div class="container px-5">
    <div class="bg-light rounded-3 py-5 px-4 px-md-5 mb-5">
        <div class="text-center mb-5">
            <h1 class="fw-bolder">Chỉnh sửa người dùng</h1>
        </div>
        <c:if test="${not empty error}">
            <div class="alert alert-danger" role="alert">${error}</div>
        </c:if>
        <form action="${pageContext.request.contextPath}/admin/edit-user" method="post">
            <input type="hidden" name="userid" value="${user.userid}" />
            <div class="mb-3">
                <label for="username" class="form-label">Tên đăng nhập</label>
                <input type="text" class="form-control" id="username" name="username" value="${user.username}" required>
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" id="email" name="email" value="${user.email}" required>
            </div>
            <div class="mb-3">
                <label for="phone" class="form-label">Số điện thoại</label>
                <input type="text" class="form-control" id="phone" name="phone" value="${user.phone}" required>
            </div>
            <div class="mb-3">
                <label for="fullname" class="form-label">Họ và tên</label>
                <input type="text" class="form-control" id="fullname" name="fullname" value="${user.fullname}">
            </div>
            <button type="submit" class="btn btn-primary">Lưu thay đổi</button>
            <a href="${pageContext.request.contextPath}/admin/user" class="btn btn-secondary">Hủy</a>
        </form>
    </div>
</div>
			
		</section>
	</main>

	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>

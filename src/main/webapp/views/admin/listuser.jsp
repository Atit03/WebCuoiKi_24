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
						<h1 class="fw-bolder">Danh Sách Người Dùng</h1>
					</div>
					<!-- Hiển thị alert -->
					<c:if test="${not empty alert}">
						<div class="alert alert-danger" role="alert">${alert}</div>
					</c:if>
					<!-- User table -->
					<div class="table-responsive">
						<table class="table table-bordered table-striped">
							<thead class="thead-dark">
								<tr>
									<th scope="col">#</th>
									<th scope="col">Tên đăng nhập</th>
									<th scope="col">Họ tên</th>
									<th scope="col">Email</th>
									<th scope="col">Số điện thoại</th>
									<th scope="col">Hành động</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="user" items="${userList}">
									<tr>
										<td>${user.userid}</td>
										<td>${user.username}</td>
										<td>${user.fullname}</td>
										<td>${user.email}</td>
										<td>${user.phone}</td>
										<td>
											<a href="${pageContext.request.contextPath}/admin/edit-user?id=${user.userid}" class="btn btn-sm btn-warning">Sửa</a>
											<a href="${pageContext.request.contextPath}/admin/delete-user?id=${user.userid}" class="btn btn-sm btn-danger"
												onclick="return confirm('Bạn có chắc chắn muốn xóa người dùng này?');">Xóa</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<!-- Add User Button -->
					<div class="text-center mt-3">
						<a href="${pageContext.request.contextPath}/admin/add-user" class="btn btn-primary">Thêm Người Dùng</a>
					</div>
				</div>
			</div>
		</section>
	</main>

	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>

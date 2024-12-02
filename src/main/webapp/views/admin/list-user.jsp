<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Book List</title>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="colorlib-product">
	<div class="container">
		<h2>Danh sách người dùng</h2>
		<table id="bookTable" class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>Họ tên</th>
					<th>Email</th>
					<th>SĐT</th>
					<th>Vai trò</th>
					<th>Hành động</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${list}">
					<tr>
						<td>${user.username}</td>
						<td>${user.email}</td>
						<td>${user.phone}</td>
						<td>${user.rolename}</td>
						<td>
						<form action="<c:url value='/admin/user/delete' />" method="POST" style="display:inline;">
                			<input type="hidden" name="id" value="${user.userid}" />
                			<button type="submit" class="btn btn-danger">Xóa</button>
           	 			</form>
           	 			</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<!-- Phân trang -->
		<nav>
			<ul class="pagination">
				<c:forEach begin="1" end="${totalPages}" var="pageNum">
					<li class="page-item ${pageNum == currentPage ? 'active' : ''}">

						<a class="page-link"
						href="<c:url value='/admin/user?page=${pageNum}' />">${pageNum}</a>
					</li>
				</c:forEach>
			</ul>
		</nav>
	</div>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<script>
    $(document).ready(function() {
        $('#bookTable').DataTable({
            "paging": true,
            "searching": true,
            "lengthChange": false
        });
    });
</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<form action="${pageContext.request.contextPath}/admin/add-user" method="post">
    <div class="form-group">
        <label for="username">Tên đăng nhập</label>
        <input type="text" class="form-control" id="username" name="username" required>
    </div>
    <div class="form-group">
        <label for="fullname">Họ và tên</label>
        <input type="text" class="form-control" id="fullname" name="fullname" required>
    </div>
    <div class="form-group">
        <label for="email">Email</label>
        <input type="email" class="form-control" id="email" name="email" required>
    </div>
    <div class="form-group">
        <label for="phone">Số điện thoại</label>
        <input type="text" class="form-control" id="phone" name="phone" required>
    </div>
    <div class="form-group">
        <label for="password">Mật khẩu</label>
        <input type="password" class="form-control" id="password" name="password" required>
    </div>
    <div class="form-group">
        <label for="roleId">Vai trò</label>
        <select class="form-control" id="roleId" name="roleId" required>
            <option value="1">Quản trị</option>
            <option value="2">Người dùng</option>
        </select>
    </div>
    <button type="submit" class="btn btn-primary">Thêm</button>
</form>

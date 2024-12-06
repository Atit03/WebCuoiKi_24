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
            <h1 class="fw-bolder">Đăng Nhập</h1>
        </div>
        <!-- Hiển thị alert -->
        <c:if test="${not empty alert}">
            <div class="alert alert-danger" role="alert">
                ${alert}
            </div>
        </c:if>
        <div class="row gx-5 justify-content-center">
            <div class="col-lg-8 col-xl-6">
                <form action="${pageContext.request.contextPath}/login" method="post" class="form-horizontal form-without-legend" role="form">
                    <!-- Email input -->
                    <div class="form-floating mb-3">
                        <label for="email">Email</label>
                        <input class="form-control" id="email" name="email" type="text" placeholder="Enter your email..." />
                    </div>
                    <!-- Password input -->
                    <div class="form-floating mb-3">
                        <label for="password">Password</label>
                        <input class="form-control" id="password" name="password" type="password" placeholder="Enter your password..." />
                    </div>
                    <!-- Submit Button -->
                    <div class="text-center mb-3">
                        <button class="btn btn-primary btn-lg" id="submitButton" type="submit">Đăng nhập</button>
                    </div>
                    <!-- Register link -->
                    <div class="text-center">
                        <p>Chưa có tài khoản? <a href="${pageContext.request.contextPath}/register" class="text-primary">Đăng ký</a></p>
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

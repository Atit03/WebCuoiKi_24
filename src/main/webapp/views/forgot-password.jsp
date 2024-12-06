<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<body class="d-flex flex-column">
    <main class="flex-shrink-0">
        <!-- Page content-->
        <section class="py-5">
            <div class="container px-5">
                <div class="bg-light rounded-3 py-5 px-4 px-md-5 mb-5">
                    <div class="text-center mb-5">
                        <h1 class="fw-bolder">Quên mật khẩu</h1>
                    </div>

                    <!-- Hiển thị thông báo thành công -->
                    <c:if test="${not empty message}">
                        <div class="alert alert-success" role="alert">
                            ${message}
                        </div>
                    </c:if>

                    <!-- Hiển thị thông báo lỗi -->
                    <c:if test="${not empty error}">
                        <div class="alert alert-danger" role="alert">
                            ${error}
                        </div>
                    </c:if>

                    <div class="row gx-5 justify-content-center">
                        <div class="col-lg-8 col-xl-6">
                            <form action="${pageContext.request.contextPath}/forgot-password" method="post" class="form-horizontal form-without-legend" role="form">
                                <!-- Email input -->
                                <div class="form-floating mb-3">
                                    <label for="email">Email</label>
                                    <input class="form-control" id="email" name="email" type="text" placeholder="Enter your email..." />
                                </div>
                                <div class="text-center mb-3">
                                    <button class="btn btn-primary btn-lg" id="submitButton" type="submit">Lấy lại mật khẩu</button>
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

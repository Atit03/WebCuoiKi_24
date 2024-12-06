<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
                                
                                <!-- Username input -->
                                <div class="form-floating mb-3">
                                    <label for="username">Username</label> 
                                    <input class="form-control" id="username" name="username" type="text"
                                        placeholder="Nhập tên tài khoản" required />
                                </div>
                                
                                <!-- Password input -->
                                <div class="form-floating mb-3">
                                    <label for="password">Password</label> 
                                    <input class="form-control" id="password" name="password" type="password"
                                        placeholder="Nhập mật khẩu..." required />
                                </div>
                                
                                <!-- Email input -->
                                <div class="form-floating mb-3">
                                    <label for="email">Email</label> 
                                    <input class="form-control" id="email" name="email" type="text"
                                        placeholder="Nhập email..." required value="${empty email ? '' : email}" />
                                    <span id="emailError" style="color:red;">${error}</span> <!-- Hiển thị lỗi email -->
                                </div>
                                
                                <!-- Fullname input -->
                                <div class="form-floating mb-3">
                                    <label for="fullname">FullName</label> 
                                    <input class="form-control" id="fullname" name="fullname" type="text"
                                        placeholder="Nhập họ và tên..." required />
                                </div>
                                
                                <!-- Submit Button -->
                                <div class="text-center mb-3">
                                    <button class="btn btn-primary btn-lg" id="submitButton"
                                        type="submit">Đăng ký</button>
                                </div>
                                
                                <!-- Register link -->
                                <div class="text-center">
                                    <p>
                                        Đã có tài khoản? <a href="${pageContext.request.contextPath}/login"
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

    <script>
        // Kiểm tra nếu có lỗi khi trang được tải
        window.onload = function() {
            const errorMessage = "<%= request.getAttribute("error") %>";
            
            if (errorMessage) {
                document.getElementById("emailError").innerText = errorMessage;  // Hiển thị thông báo lỗi dưới email
                document.getElementById("email").focus();  // Focus lại trường email
            }
        };
    </script>
    
    <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>

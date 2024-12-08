<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<body class="d-flex flex-column">
    <main class="flex-shrink-0">
        <!-- Page content -->
        <section class="py-5">
            <div class="container px-5">
                <div class="bg-light rounded-3 py-5 px-4 px-md-5 mb-5">
                    <div class="text-center mb-5">
                        <h1 class="fw-bolder">Danh Sách Sản Phẩm</h1>
                    </div>
                    <!-- Hiển thị alert -->
                    <c:if test="${not empty alert}">
                        <div class="alert alert-danger" role="alert">${alert}</div>
                    </c:if>
                    <!-- Product table -->
                    <div class="table-responsive">
                        <table class="table table-bordered table-striped">
                            <thead class="thead-dark">
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Tên sản phẩm</th>
                                    <th scope="col">Danh mục</th>
                                    <th scope="col">Giá</th>
                                    <th scope="col">Tồn kho</th>
                                    <th scope="col">Đánh giá</th>
                                    <th scope="col">Hình ảnh</th>
                                    <th scope="col">Hành động</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="product" items="${productList}">
                                    <tr>
                                        <td>${product.productid}</td>
                                        <td>${product.productname}</td>
                                        <td>${product.categoryid}</td>
                                        <td>${product.price}</td>
                                        <td>${product.stock}</td>
                                        <td>${product.rating}</td>
                                        <td>
                                            <img src="${product.image}" alt="${product.productname}" style="width: 100px; height: auto;">
                                        </td>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/admin/edit-product?id=${product.productid}" class="btn btn-sm btn-warning">Sửa</a>
                                            <a href="${pageContext.request.contextPath}/admin/delete-product?id=${product.productid}" class="btn btn-sm btn-danger"
                                               onclick="return confirm('Bạn có chắc chắn muốn xóa sản phẩm này?');">Xóa</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <!-- Add Product Button -->
                    <div class="text-center mt-3">
                        <a href="${pageContext.request.contextPath}/admin/add-product" class="btn btn-primary">Thêm Sản Phẩm</a>
                    </div>
                </div>
            </div>
        </section>
    </main>

    <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>

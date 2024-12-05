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
                        <h1 class="fw-bolder">ADD ADDRESS</h1>
                    </div>
                    <div class="row gx-5 justify-content-center">
                        <div class="col-lg-8 col-xl-6">
                            <form action="${pageContext.request.contextPath}/addAddress" method="post" class="form-horizontal form-without-legend" role="form">
                                <!-- Email input -->
                                <div class="form-floating mb-3">
                                    <label for="email">FullName</label>
                                    <input class="form-control" id="fname" name="fname" type="text" placeholder="Enter your full name..." data-sb-validations="required" />
                                    <div class="invalid-feedback" data-sb-feedback="name:required">A username is required.</div>
                                </div>
                                <!-- Password input -->
                                <div class="form-floating mb-3">
                                    <label for="email">Address</label>
                                    <input class="form-control" id="address" name="address" type="text" placeholder="Enter your address..." data-sb-validations="required" />
                                    <div class="invalid-feedback" data-sb-feedback="name:required">A username is required.</div>
                                </div>
                                <div class="form-floating mb-3">
                                    <label for="email">Phone</label>
                                    <input class="form-control" id="phone" name="phone" type="text" placeholder="Enter your full phone..." data-sb-validations="required" />
                                    <div class="invalid-feedback" data-sb-feedback="name:required">A username is required.</div>
                                </div>
                                <!-- Submit Button -->
                                <div class="text-center mb-3">
                                    <button class="btn btn-primary btn-lg" id="submitButton" type="submit">ADD</button>
                                </div>
                                <!-- Register link -->
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </main>

    <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>

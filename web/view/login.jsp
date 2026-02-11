<%-- 
    Document   : login
    Created on : Feb 7, 2026, 9:33:45 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

        <!-- Latest compiled JavaScript -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <div class="container mt-5">
            <div class="row justify-content-center">
                <div class="col-md-6 col-lg-5">
                    <div class="card shadow">

                        <div class="card-header bg-primary text-white">
                            <h4 class="mb-0 text-center">Login</h4>
                        </div>
                        <!--Avatar-->
                        <div class="text-center mt-3">
                            <img src="${pageContext.request.contextPath}/images/img_avatar1.png"
                                 class="rounded-circle border"
                                 width="100" height="100"
                                 alt="avatar">
                        </div>
                                 
                        <div class="card-body">
                            <!-- Error -->
                            <c:if test="${not empty requestScope.error}">
                                <div class="text-center text-danger py-2">
                                    ${requestScope.error}
                                </div>
                            </c:if>

                            <form action="${pageContext.request.contextPath}/MainController?action=login"
                                  method="post">

                                <!-- Account -->
                                <div class="mb-3">
                                    <label class="form-label">Account</label>
                                    <input type="text"
                                           name="account"
                                           class="form-control"
                                           placeholder="Enter account"
                                           required>
                                </div>

                                <!-- Password -->
                                <div class="mb-4">
                                    <label class="form-label">Password</label>
                                    <input type="password"
                                           name="pass"
                                           class="form-control"
                                           placeholder="Enter password"
                                           required>
                                </div>

                                <!-- Buttons -->
                                <div class="d-flex justify-content-between">
                                    <button type="submit" class="btn btn-primary">
                                        Login
                                    </button>

                                    <a href="${pageContext.request.contextPath}/MainController?action=index"
                                       class="btn btn-secondary">
                                        Cancel
                                    </a>
                                </div>

                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

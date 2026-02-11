<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Welcome</title>

        <!-- Latest compiled and minified CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

        <!-- Latest compiled JavaScript -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    </head>

    <body  class="d-flex justify-content-center align-items-center min-vh-100"
           style="
           background-image: url('${pageContext.request.contextPath}/images/background.png');
           background-size: cover;
           background-position: center;">
        <div class="d-flex justify-content-center gap-3 flex-wrap">
            <a href="MainController?action=login"
               class="btn btn-danger btn-lg rounded-pill px-4 shadow">
                Login
            </a>
            <a href="MainController?action=product-list"
               class="btn btn-warning btn-lg rounded-pill px-4 shadow text-dark">
                View Products
            </a>
        </div>
    </body>
</html>

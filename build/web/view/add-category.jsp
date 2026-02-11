<%-- 
    Document   : add-category
    Created on : Jan 30, 2026, 8:13:16 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ADD Category</title>
        <!-- Latest compiled and minified CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

        <!-- Latest compiled JavaScript -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <%@include file="../navbar.jspf" %>
        <div class="container mx-auto mt-3 vh-90" style="max-width: 1000px;">
            <div class="bg-secondary-subtle  border border-info border-1 rounded-5 px-5 py-3">
                <h1 class="text-center text-primary mb-3">ADD CATEGORY</h1>
                <c:if test="${not empty error}">
                    <h2 class="text-danger">${error}</h2>
                </c:if>
                    <form action="MainController?action=category-add" class="was-validated" method="post" >
                    <div class="mb-3 mt-3">
                        <label for="categoryN" class="form-label">Category Name</label>
                        <input type="text" class="form-control" id="categoryN" placeholder="Enter category" name="categoryName" required>
                        <div class="invalid-feedback">Please fill out this field.</div>
                    </div>
                    <div class="mb-3">
                        <label for="memo" class="form-label">Memo</label>
                        <input type="text" class="form-control" id="memo" placeholder="Enter products for travel and exploration." name="memo" required>
                        <div class="invalid-feedback">Please fill out this field.</div>
                    </div>
                    <button type="submit" class="btn btn-primary mx-auto d-block">Save</button>
                </form>
            </div>
        </div>
    </body>
</html>

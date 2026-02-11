<%-- 
    Document   : add-product
    Created on : Feb 4, 2026, 7:03:14 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Latest compiled and minified CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

        <!-- Latest compiled JavaScript -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <div class="container mt-5">
            <div class="row justify-content-center">
                <div class="col-md-8">

                    <div class="card shadow">
                        <div class="card-header bg-primary text-white">
                            <h4 class="mb-0">Add New Product</h4>
                        </div>

                        <div class="card-body">
                            <form action="MainController?action=product-add" method="post">
                                <c:if test="${not empty error}">
                                    <h2 style="color: red" class="text-center">${error}</h2>
                                </c:if>
                                <!-- Product ID -->
                                <div class="mb-3">
                                    <label class="form-label">Product ID</label>
                                    <input type="text" name="productId" class="form-control" required>
                                </div>

                                <!-- Product Name -->
                                <div class="mb-3">
                                    <label class="form-label">Product Name</label>
                                    <input type="text" name="productName" class="form-control" required>
                                </div>

                                <!-- Product Image -->
                                <div class="mb-3">
                                    <label class="form-label">Product Image (path)</label>
                                    <input type="text" name="productImage" class="form-control">
                                </div>

                                <!-- Brief -->
                                <div class="mb-3">
                                    <label class="form-label">Brief</label>
                                    <textarea name="brief" class="form-control" rows="3"></textarea>
                                </div>

                                <!-- PostedDate -->
                                <div class="mb-3">
                                    <label class="form-label">Posted Date</label>
                                    <input type="date" name="postedDate" class="form-control"
                                           value="${param.postedDate}" required>
                                </div>

                                <!-- Category -->
                                <div class="mb-3">
                                    <label class="form-label">Category</label>
                                    <select name="typeId" class="form-select" required>
                                        <option value="">-- Select Category --</option>
                                        <c:forEach items="${listCate}" var="c">
                                            <option value="${c.typeId}">
                                                ${c.categoryName}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <!-- Unit -->
                                <div class="mb-3">
                                    <label class="form-label">Unit</label>
                                    <input type="text" name="unit" class="form-control" value="pcs">
                                </div>

                                <!-- Price -->
                                <div class="mb-3">
                                    <label class="form-label">Price</label>
                                    <input type="number" name="price" class="form-control" min="0" required>
                                </div>

                                <!-- Discount -->
                                <div class="mb-3">
                                    <label class="form-label">Discount (%)</label>
                                    <input type="number" name="discount" class="form-control" min="0" max="100" value="0">
                                </div>

                                <!-- Submit -->
                                <div class="text-end">
                                    <button type="submit" class="btn btn-success">
                                        Add Product
                                    </button>
                                    <a href="MainController?action=product-list" 
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

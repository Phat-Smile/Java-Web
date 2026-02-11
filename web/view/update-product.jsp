<%-- 
    Document   : update-product
    Created on : Feb 11, 2026, 9:55:14 PM
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
        <%@include file="../navbar.jspf" %>

        <div class="container mt-5">
            <div class="row justify-content-center">
                <div class="col-md-8">
                    <div class="card shadow rounded-4">
                        <div class="card-header bg-primary text-white rounded-top-4">
                            <h4 class="mb-0 text-center">Update Product</h4>
                        </div>

                        <div class="card-body">
                            <c:if test="${not empty requestScope.error}">
                                <div class="alert alert-danger text-center">
                                    ${requestScope.error}
                                </div>
                            </c:if>

                            <!-- POST thẳng vào servlet UpdateProductController -->
                            <form action="update_product" method="post">

                                <!-- Product ID (readonly) -->
                                <div class="mb-3">
                                    <label class="form-label">Product ID</label>
                                    <input type="text"
                                           name="productId"
                                           class="form-control"
                                           value="${p.productId}"
                                           readonly>
                                </div>

                                <div class="mb-3">
                                    <label class="form-label">Product Name</label>
                                    <input type="text"
                                           name="productName"
                                           class="form-control"
                                           value="${p.productName}"
                                           required>
                                </div>

                                <div class="mb-3">
                                    <label class="form-label">Product Image (path)</label>
                                    <input type="text"
                                           name="productImage"
                                           class="form-control"
                                           value="${p.productImage}">
                                </div>

                                <div class="mb-3">
                                    <label class="form-label">Brief</label>
                                    <textarea name="brief" class="form-control" rows="3">${p.brief}</textarea>
                                </div>

                                <div class="mb-3">
                                    <label class="form-label">Posted Date</label>
                                    <input type="date"
                                           name="postedDate"
                                           class="form-control"
                                           value="${p.postedDate}"
                                           required>
                                </div>

                                <div class="mb-3">
                                    <label class="form-label">Category</label>
                                    <select name="typeId" class="form-select" required>
                                        <option value="">-- Select Category --</option>
                                        <c:forEach items="${listCate}" var="c">
                                            <option value="${c.typeId}"
                                                    <c:if test="${p.typeId.typeId == c.typeId}">selected</c:if>>
                                                ${c.categoryName}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <div class="mb-3">
                                    <label class="form-label">Unit</label>
                                    <input type="text"
                                           name="unit"
                                           class="form-control"
                                           value="${p.unit}"
                                           required>
                                </div>

                                <div class="mb-3">
                                    <label class="form-label">Price</label>
                                    <input type="number"
                                           name="price"
                                           class="form-control"
                                           min="0"
                                           value="${p.price}"
                                           required>
                                </div>

                                <div class="mb-3">
                                    <label class="form-label">Discount (%)</label>
                                    <input type="number"
                                           name="discount"
                                           class="form-control"
                                           min="0" max="100"
                                           value="${p.discount}">
                                </div>

                                <div class="text-end">
                                    <button type="submit" class="btn btn-success">Update Product</button>
                                    <a href="MainController?action=product-list" class="btn btn-secondary">Cancel</a>
                                </div>

                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>


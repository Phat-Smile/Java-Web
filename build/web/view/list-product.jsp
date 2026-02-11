<%-- 
    Document   : list-product
    Created on : Jan 28, 2026
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Product</title>

        <!-- Bootstrap 5 -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <%@include file="../navbar.jspf" %>

        <div class="container mt-4">
            <div class="card shadow-sm rounded-4">
                <div class="card-header bg-primary text-white rounded-top-4">
                    <h1 class="text-center mb-0">List of Product</h1>
                </div>

                <div class="table-responsive">
                    <table class="table table-bordered table-hover align-middle text-center mb-0">
                        <thead class="table-light">
                            <tr>
                                <th>ProductId</th>
                                <th>ProductName</th>
                                <th>ProductImage</th>
                                <th>Brief</th>
                                <th>PostedDate</th>
                                <th>TypeId</th>
                                <th>Account</th>
                                <th>Unit</th>
                                <th>Price</th>
                                <th>Discount</th>
                                <th style="min-width: 180px;">Tools</th>
                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach var="p" items="${requestScope.listPro}">
                                <tr>
                                    <td>${p.productId}</td>
                                    <td>${p.productName}</td>

                                    <td>
                                        <img class="img-thumbnail"
                                             src="${pageContext.request.contextPath}${p.productImage}"
                                             style="max-width: 140px; height: auto;"
                                             alt="${p.productName}">
                                    </td>

                                    <td class="text-start">${p.brief}</td>
                                    <td>${p.postedDate}</td>
                                    <td>${p.typeId.typeId}</td>
                                    <td>${p.account.account}</td>
                                    <td>${p.unit}</td>
                                    <td>${p.price}</td>
                                    <td>${p.discount}</td>

                                    <td>
                                        <div class="d-flex justify-content-center gap-2">
                                            <c:url var="urlUpdate" value="MainController?action=product-upd&productId=${p.productId}">
                                            </c:url>
                                            <a href="${urlUpdate}" class="btn btn-success btn-sm">
                                                Update
                                            </a>

                                            <c:url var="urlDelete" value="MainController?action=product-del&productId=${p.productId}">
                                            </c:url>
                                            <a href="${urlDelete}"
                                               class="btn btn-danger btn-sm"
                                               >
                                                Delete
                                            </a>
                                        </div>
                                    </td>

                                </tr>
                            </c:forEach>

                            <c:if test="${empty requestScope.listPro}">
                                <tr>
                                    <td colspan="11" class="text-muted py-4">
                                        No products found.
                                    </td>
                                </tr>
                            </c:if>
                        </tbody>
                    </table>
                </div>

            </div>
        </div>
    </body>
</html>

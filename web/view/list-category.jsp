<%-- 
    Document   : list-category
    Created on : Jan 28, 2026, 11:19:42 PM
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
        <div class="container mt-4">
            <div class="card shadow-sm rounded-4">
                <div class="card-header bg-primary text-white rounded-top-4">
                    <h1 class="text-center">List of Category</h1>
                </div>
                <table class="table table-bordered table-hover align-middle text-center">
                    <thead>
                        <tr>
                            <th>TypeId</th>
                            <th>CategoryName</th>
                            <th>Meno</th>
                            <th>Tools</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="c" items="${requestScope.listCate}">
                            <tr>
                                <td>${c.typeId}</td>
                                <td>${c.categoryName}</td>
                                <td>${c.memo}</td>
                                <td>
                                    <div>
                                        <img src="${pageContext.request.contextPath}/images/icon_update.png" width="80px" height="80px" alt="update"/>
                                        <c:url var="urlUpdate" value="MainController?action=category-upd&typeId=${c.typeId}"></c:url>
                                        <a href="${urlUpdate}" class="btn btn-success">Update</a>
                                    </div>
                                    <div>
                                        <c:url var="urlDelete" value="MainController?action=category-del&typeId=${c.typeId}"></c:url>
                                        <img src="${pageContext.request.contextPath}/images/icon_delete.png" width="80px" height="80px" alt="delete"/>
                                        <a href="${urlDelete}" class="btn btn-danger">Delete</a>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>

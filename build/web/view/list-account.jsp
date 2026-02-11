<%-- 
    Document   : list-account
    Created on : Jan 28, 2026, 10:18:29 PM
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
                    <h1 class="text-center">List of Account</h1>
                </div>
                <table class="table table-bordered table-hover align-middle text-center">
                    <thead>
                        <tr>
                            <th>Account</th>
                            <th>Pass</th>
                            <th>LastName</th>
                            <th>FirstName</th>
                            <th>Birthday</th>
                            <th>Gender</th>
                            <th>Phone</th>
                            <th>isUse</th>
                            <th>roleInSystem</th>
                            <th>Tools</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="a" items="${requestScope.listAcc}">
                            <tr>
                                <td>${a.account}</td>
                                <td>${a.pass}</td>
                                <td>${a.lastName}</td>
                                <td>${a.firstName}</td>
                                <td>${a.birthday}</td>
                                <td>${a.gender==true?"Male":"Female"}</td>
                                <td>${a.phone}</td>
                                <td>${a.use==true?"used":"prevented"}</td>
                                <td>${a.roleInSystem==1?"admin":"staff"}</td>
                                <td>
                                    <div class="d-flex justify-content-center gap-2">
                                        <c:url var="urlUpdate" value="MainController">
                                            <c:param name="action" value="account-upd"/>
                                            <c:param name="account" value="${a.account}"/>
                                        </c:url>
                                        <a href="${urlUpdate}"
                                           class="btn btn-sm btn-success px-3 rounded-pill">
                                            Update
                                        </a>

                                        <c:url var="urlDelete" value="MainController">
                                            <c:param name="action" value="account-del"/>
                                            <c:param name="account" value="${a.account}"/>
                                        </c:url>
                                        <a href="${urlDelete}"
                                           class="btn btn-sm btn-danger px-3 rounded-pill"
                                           onclick="return confirm('Delete this account?');">
                                            Delete
                                        </a>
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

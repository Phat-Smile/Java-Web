<%-- 
    Document   : update-account
    Created on : Feb 6, 2026, 6:58:08 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <div class="container mx-auto mt-3 vh-90" style="max-width: 1000px;">
            <div class="bg-secondary-subtle  border border-info border-1 rounded-5 px-5 py-3">
                <h1 class="text-center text-primary mb-3">UPDATE ACCOUNT</h1>

                <form action="MainController?action=account-upd" class="was-validated" method="post">
                    <div class="row">
                        <!--UserName-->
                        <div class="col-md-6 mb-3">
                            <label for="user" class="form-label">Username</label>
                            <input type="text" 
                                   class="form-control" 
                                   id="uname" 
                                   placeholder="Enter username" 
                                   name="user" 
                                   value="${account.account}"
                                   required>
                            <div class="invalid-feedback">Please fill out this field.</div>
                        </div>

                        <!--Password-->
                        <div class="col-md-6 mb-3">
                            <label for="pwd" class="form-label">Password</label>
                            <input type="password" 
                                   class="form-control" 
                                   id="pwd" 
                                   placeholder="Enter password" 
                                   name="pass" 
                                   value="${account.pass}"
                                   required>
                            <div class="invalid-feedback">Please fill out this field.</div>
                        </div>
                    </div>

                    <div class="row"> 
                        <!--First Name-->
                        <div class="col-md-6 mb-3">
                            <label for="firstN" class="form-label">First name</label>
                            <input type="text" 
                                   class="form-control" 
                                   id="firstN" 
                                   placeholder="First name" 
                                   name="firstName" 
                                   value="${account.firstName}"
                                   required>
                            <div class="invalid-feedback">Please fill out this field.</div>
                        </div>

                        <!--Last Name-->
                        <div class="col-md-6 mb-3">
                            <label for="lastN" class="form-label">Last name</label>
                            <input type="text" 
                                   class="form-control" 
                                   id="lastN" 
                                   placeholder="Last name" 
                                   name="lastName" 
                                   value="${account.lastName}"
                                   required>
                            <div class="invalid-feedback">Please fill out this field.</div>
                        </div>
                    </div>

                    <!--Phone-->
                    <div class="mb-3">
                        <label for="phone" class="form-label">Phone number</label>
                        <input type="text" 
                               class="form-control" 
                               id="phone" 
                               placeholder="Phone number" 
                               name="phone" 
                               value="${account.phone}"
                               required>
                        <div class="invalid-feedback">Please fill out this field.</div>
                    </div>

                    <div class="row">
                        <!--Birthday-->
                        <div class="col-md-6 mb-3">
                            <label for="dob" class="form-label">Birthday</label>
                            <input type="date" 
                                   class="form-control" 
                                   id="dob" 
                                   placeholder="Phone dob" 
                                   name="dob" 
                                   value="${account.birthday}"
                                   required>
                            <div class="invalid-feedback">Please fill out this field.</div>
                        </div>

                        <div class="col-md-6 mb-3">
                            <label class="form-label fw-semibold">Gender</label>
                            <div class="d-flex my-2 gap-4">
                                <!--Male-->
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="gender" value="true" id="male" required="">
                                    <label class="form-check-label" for="male">Male</label>
                                </div>
                                <!--Female-->
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="gender" value="false" id="female" required="">
                                    <label class="form-check-label" for="female">Female</label>
                                </div>
                            </div>
                        </div>
                    </div>


                    <!--Role In System-->
                    <div class="mb-3">
                        <label for="phone" class="form-label">Role in system</label>
                        <select class="form-select" name="role" >
                            <option class="form-control" 
                                    value="1"
                                    <c:if test="${account.roleInSystem}==1">
                                        selected
                                    </c:if>
                                    > Administrator
                            </option>
                            <option class="form-control" value="0"
                                    <c:if test="${account.roleInSystem}==0">
                                        selected
                                    </c:if>
                                    > Staff</option>
                        </select>
                    </div>


                    <!--is Use or Prevented-->
                    <div class="form-check mb-3">
                        <input class="form-check-input" type="checkbox" id="myCheck" name="isUse" value="${account.use}">
                        <label class="form-check-label" for="myCheck">Is Active</label>
                        <div class="invalid-feedback">Check this checkbox to continue.</div>
                    </div>

                    <button type="submit" class="btn btn-primary mx-auto d-block">Submit</button>
                </form>
            </div>
        </div>
    </body>
</html>

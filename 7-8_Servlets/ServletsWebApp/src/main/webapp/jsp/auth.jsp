<%--
  Created by IntelliJ IDEA.
  User: aivar
  Date: 14.10.2020
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="_header.jsp"%>

    <div class="container">
        <form action="<c:url value="/auth"/>" method="post">
            <div class="form-group">
                <label for="login">Username</label>
                <input type="text" name="login" id="login" placeholder="Enter username">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" name="password" id="password" placeholder="Enter password">
            </div>
            <div class="form-check">
                <label for="remember">Remember me</label>
                <input type="checkbox" name="remember" id="remember">
            </div>
            <input type="submit" value="Sign in">
        </form>
    </div>

<%@ include file="_footer.jsp"%>
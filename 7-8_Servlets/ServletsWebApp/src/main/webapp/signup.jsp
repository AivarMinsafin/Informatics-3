<%@ taglib prefix="c" uri="" %>
<%--
  Created by IntelliJ IDEA.
  User: aivar
  Date: 04.10.2020
  Time: 23:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign up</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/main.css">
</head>
<body>
<div class="container">
    <c:if test = "${not empty message}">
        <h3>${message}</h3>
    </c:if>
    <form action="<c:out value="">" method="post">
        <div class="form-group">
            <label for="login">Login:</label>
            <input type="text" name="login" id="login" placeholder="Login">
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" name="email" id="email" placeholder="Email">
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" name="password" id="password" placeholder="Password">
            <input type="password" name="conf_password" placeholder="Confirm password">
        </div>
        <div class="form-check">
            <input type="checkbox" id="agr" name="agreement">
            <label for="agr">Consent to the processing of personal data</label>
        </div>
        <input type="submit" value="Sign up">
    </form>
    <p>${user}</p>
</div>
</body>
</html>

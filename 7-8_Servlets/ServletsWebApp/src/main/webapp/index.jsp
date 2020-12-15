<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Start</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container" style="text-align: center">
    <h2>Hello</h2>
    <a href="<c:url value="/signup"/>" class="btn" style="background-color: lightskyblue">Try to sing up</a>
    <a href="<c:url value="/auth"/>" class="btn" style="background-color: lightcoral">Try to sign in</a>
</div>
</body>
</html>
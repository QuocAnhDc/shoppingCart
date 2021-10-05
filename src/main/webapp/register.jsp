<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 01/10/2021
  Time: 4:28 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="download" method="post">
        <input type="hidden" name="action" value="registerUser">
        <label class="pad_top">Email:</label>
        <input type="email" name="email" value="${user.email}"><br>
        <label class="pad_top">First name:</label>
        <input type="text" name="firstName" value="${user.firstName}"><br>
        <label class="pad_top">Last name:</label>
        <input type="text" name="lastName" value="${user.lastName}"><br>
        <label>&nbsp;</label>
        <input type="submit" value="Register" class="margin_left">
    </form>
</body>
</html>

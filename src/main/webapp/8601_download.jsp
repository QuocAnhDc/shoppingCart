<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 01/10/2021
  Time: 4:36 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Downloads</h1>
<h2>86 con cac to vkl</h2>
<table>
    <tr>
        <th>Song title</th>
        <th>Audio Format</th>
    </tr>
    <tr>
        <td>You Are a Star</td>
        <td>
            <a href="https://www.youtube.com/watch?v=4mJayYlfcWo&ab_channel=ImagineDragonsVEVO">MP3</a>
        </td>
    </tr>
    <tr>
        <td>You Are a Star</td>
        <td>
            <a href="/music/${productCode}/1.mp3">MP3</a>
        </td>
    </tr>
</table>
<form action="" method="get">
    <input type="hidden" name="action" value="viewAlbums">
    <input type="submit" name="action" value="Return">
</form>
<form action="" method="get">
    <input type="hidden" name="action" value="logOut">
    <input type="submit" name="action" value="LOG OUT">
</form>
<p>Email cookie value: ${cookie.emailCookie.value}</p>
</body>
</html>

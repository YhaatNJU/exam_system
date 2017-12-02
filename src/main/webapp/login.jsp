<%--
  Created by IntelliJ IDEA.
  User: yha
  Date: 2017/11/10
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>欢迎登录</title>
</head>
<body>
<div class="error">${error}</div>
<form id="loginForm" action="" method="post">
    用户名：<input type="text" name="username" id="username">
    密&nbsp;&nbsp;码：<input type="password" name="password" id="password">
    <button type="submit">登录</button>
    <h5 style="color: red">${errorMsg}</h5>
</form>

</body>
</html>

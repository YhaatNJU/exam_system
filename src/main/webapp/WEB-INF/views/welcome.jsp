<%--
  Created by IntelliJ IDEA.
  User: yha
  Date: 2017/11/10
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
<h3>你好，<shiro:principal/></h3>
<h3>欢迎登录考试系统</h3>
</body>
</html>

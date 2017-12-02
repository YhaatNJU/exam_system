<%--
  Created by IntelliJ IDEA.
  User: yha
  Date: 2017/12/1
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
    <title>系统管理</title>
    <%@include file="/WEB-INF/views/include/head.jsp"%>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#addUser").validate({
                submitHandler:function (form) {
                    form.submit();
                }
            })
        });
    </script>
</head>
<body>

<div class="panel center-block" style="width: 70%">
    <ul class="nav nav-tabs">
        <li class="active"><a href="${ctx}/user/users">用户管理</a></li>
        <li ><a href="${ctx}/role/roles">角色管理</a> </li>
        <li ><a href="${ctx}/permission/permissions">权限管理</a></li>
    </ul>
    <div class="page">
        <h3 class="page-header">添加用户</h3>
        <form:form id="addUser" modelAttribute="user" action="${ctx}/user/add" method="post" cssClass="form-horizontal">
            <div class="control-group">
                <label class="control-label">用户名：</label>
                <div class="controls">
                    <form:input path="username" htmlEscape="false" maxlength="20" cssClass="input-medium required"/>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">密码：</label>
                <div class="controls">
                    <form:input path="password" htmlEscape="false" maxlength="20" cssClass="input-medium required"/>
                </div>
            </div>
            <div class="form-actions">
                <input type="submit" class="btn-success" value="提交">
            </div>
        </form:form>
    </div>
    <div class="page">
        <h3 class="page-header">用户列表</h3>
        <table class="table table-bordered">
            <tr>
                <th>用户名</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.username}</td>
                    <td>
                        <a href="${ctx}/user/delete?userId=${user.id}">删除</a>
                        <a href="${ctx}/user/detail?userId=${user.id}">修改</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

</body>
</html>

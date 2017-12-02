<%--
  Created by IntelliJ IDEA.
  User: yha
  Date: 2017/12/1
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
    <title>修改用户信息</title>
    <%@include file="/WEB-INF/views/include/head.jsp"%>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#editUser").validate({
                submitHandler:function (form) {
                    form.submit();
                }
            })
        });
    </script>
</head>
<body>
<div class="panel center-block" style="width: 70%">
    <h3 class="page-header">修改用户</h3>
    <form:form id="editUser" modelAttribute="user" action="${ctx}/user/edit" method="post" cssClass="form-horizontal">
        <form:hidden path="id"/>
        <div class="control-group">
            <label class="control-label">用户名：</label>
            <div class="controls">
                <form:input path="username" htmlEscape="false" maxlength="20" cssClass="input-medium required" disabled="true"/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label">密码：</label>
            <div class="controls">
                <form:password path="password" htmlEscape="false" maxlength="20" cssClass="input-medium required"/>
            </div>
        </div>
        <div class="form-actions">
            <input type="submit" class="btn-success" value="提交">
            <a href="${ctx}/user/users" class="btn btn-default">返回</a>
        </div>
    </form:form>
    <div class="page">
        <h4 class="page-header">角色列表</h4>
        <table class="table table-bordered">
            <tr>
                <th>名称</th>
                <th>描述</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${roles}" var="role">
                <tr>
                    <td>${role.name}</td>
                    <td>${role.description}</td>
                    <td>
                        <a href="${ctx}/user/deleteRole?userId=${user.id}&roleId=${role.id}">删除用户角色</a>
                    </td>
                </tr>
            </c:forEach>
            <c:forEach items="${noRoles}" var="role">
                <tr>
                    <td>${role.name}</td>
                    <td>${role.description}</td>
                    <td>
                        <a href="${ctx}/user/addRole?userId=${user.id}&roleId=${role.id}">添加用户角色</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="page">
        <h4 class="page-header">权限列表</h4>
        <table class="table table-bordered">
            <tr>
                <th>名称</th>
                <th>描述</th>
            </tr>
            <c:forEach items="${permissions}" var="permission">
                <tr>
                    <td>${permission.name}</td>
                    <td>${permission.description}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

</body>
</html>

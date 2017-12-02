<%--
  Created by IntelliJ IDEA.
  User: yha
  Date: 2017/12/1
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
    <title>角色修改</title>
    <%@include file="/WEB-INF/views/include/head.jsp"%>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#editRole").validate({
                submitHandler:function (form) {
                    form.submit();
                }
            })
        });
    </script>
</head>
<body>
<div class="panel center-block" style="width: 70%">
    <div class="page">
        <h3 class="page-header">角色修改</h3>
        <form:form id="editRole" modelAttribute="role" action="${ctx}/role/edit" method="post" cssClass="form-horizontal">
            <form:hidden path="id"/>
            <div class="control-group">
                <label class="control-label">名称：</label>
                <div class="controls">
                    <form:input path="name" htmlEscape="false" maxlength="20" cssClass="input-medium required"/>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">描述：</label>
                <div class="controls">
                    <form:input path="description" htmlEscape="false" maxlength="20" cssClass="input-medium required"/>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">是否可用：</label>
                <div class="controls">
                    <form:checkbox  path="available" htmlEscape="false" maxlength="20" cssClass="input-medium"/>
                </div>
            </div>
            <div class="form-actions">
                <input type="submit" class="btn-success" value="提交">
                <a href="${ctx}/role/roles" class="btn btn-default">返回</a>
            </div>
        </form:form>
    </div>
    <div class="page">
        <h4 class="page-header">权限列表</h4>
        <table class="table table-bordered">
            <tr>
                <th>名称</th>
                <th>描述</th>
                <th>是否可用</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${permissions}" var="permission">
                <tr>
                    <td>${permission.name}</td>
                    <td>${permission.description}</td>
                    <td><input type="checkbox" value="${permission.available}"></td>
                    <td><a href="${ctx}/role/deletePermission?roleId=${role.id}&permissionId=${permission.id}">删除权限</a> </td>
                </tr>
            </c:forEach>
            <c:forEach items="${noPermissions}" var="permission">
                <tr>
                    <td>${permission.name}</td>
                    <td>${permission.description}</td>
                    <td><input type="checkbox" value="${permission.available}"></td>
                    <td><a href="${ctx}/role/addPermission?roleId=${role.id}&permissionId=${permission.id}">添加权限</a> </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

</body>
</html>

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
            $("#addRole").validate({
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
        <li ><a href="${ctx}/user/users">用户管理</a></li>
        <li class="active"><a href="${ctx}/role/roles">角色管理</a> </li>
        <li ><a href="${ctx}/permission/permissions">权限管理</a></li>
    </ul>
    <div class="page">
        <h3 class="page-header">添加角色</h3>
        <form:form id="addRole" modelAttribute="role" action="${ctx}/role/add" method="post" cssClass="form-horizontal">
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
                    <form:checkbox path="available" htmlEscape="false"  cssClass="input-medium"/>
                </div>
            </div>
            <div class="form-actions">
                <input type="submit" class="btn-success" value="提交">
            </div>
        </form:form>
    </div>
    <div class="page">
        <h3 class="page-header">角色列表</h3>
        <table class="table table-bordered">
            <tr>
                <th>名称</th>
                <th>描述</th>
                <th>是否可用</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${roles}" var="role">
                <tr>
                    <td>${role.name}</td>
                    <td>${role.description}</td>
                    <td><input type="checkbox" <c:if test="${role.available}"><c:out value="checked='checked'"/></c:if> disabled="disabled"></td>
                    <td>
                        <a href="${ctx}/role/delete?roleId=${role.id}">删除</a>
                        <a href="${ctx}/role/detail?roleId=${role.id}">修改</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: yha
  Date: 2017/12/2
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
    <title>修改权限</title>
    <%@include file="/WEB-INF/views/include/head.jsp"%>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#editPermission").validate({
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
        <h3 class="page-header">修改权限</h3>
        <form:form id="editPermission" modelAttribute="permission" action="${ctx}/permission/update" method="post" cssClass="form-horizontal">
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
                    <form:checkbox path="available" htmlEscape="false" maxlength="20" cssClass="input-medium"/>
                </div>
            </div>
            <div class="form-actions">
                <input type="submit" class="btn-success" value="提交">
                <a href="${ctx}/permission/permissions" class="btn btn-default">返回</a>
            </div>
        </form:form>
    </div>
</div>

</body>
</html>

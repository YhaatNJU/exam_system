<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ include file="WEB-INF/views/include/taglib.jsp"%>
<html>
<body>
<shiro:guest>
    欢迎游客访问，<a href="${pageContext.request.contextPath}/login.jsp">点击登录</a><br/>
</shiro:guest>
<shiro:user>
    欢迎[<shiro:principal/>]登录，<a href="${pageContext.request.contextPath}/logout">点击退出</a><br/>
</shiro:user>
<shiro:user>
    <a href="${pageContext.request.contextPath}/success.jsp">进入登录成功界面</a>
</shiro:user>
<shiro:hasRole name="admin">
    <a href="${ctx}/user/users">系统管理</a>
</shiro:hasRole>
</body>
</html>

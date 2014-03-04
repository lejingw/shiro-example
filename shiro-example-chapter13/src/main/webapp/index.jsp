<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<body>
<shiro:guest>
    欢迎游客访问，<a href="${pageContext.request.contextPath}/login.jsp">点击登录</a><br/>
</shiro:guest>
<shiro:user>
    欢迎[<shiro:principal/>]登录
	<shiro:authenticated>
	    已身份验证通过<br/>
	</shiro:authenticated>
	<shiro:notAuthenticated>
	    未身份验证通过<br/>
	</shiro:notAuthenticated>
	<br>
	<a href="${pageContext.request.contextPath}/logout">点击退出</a><br/>
</shiro:user>
<br>
<shiro:hasRole name="admin">
    您有角色admin
</shiro:hasRole>
</body>
</html>

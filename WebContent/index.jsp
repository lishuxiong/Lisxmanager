<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<title>这是我写的MVC登录注册</title>
</head>

<body>
	<h1>lisx主页</h1>

	<c:if test="${sessionScope.user == null }">
		<a href="${pageContext.request.contextPath}/register.jsp">注册</a>
		<a href="login.jsp">登录</a>
	</c:if>
	<c:if test="${sessionScope.user != null}">
  欢迎您，${sessionScope.user.username} &nbsp;&nbsp; 
  <a href="${pageContext.request.contextPath}/servlet/ControllerServlet?op=logout" >注销</a>
	</c:if>
</body>
</html>
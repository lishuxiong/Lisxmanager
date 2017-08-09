<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<title>login</title>
</head>
<body>
	<form
		action="${pageContext.request.contextPath}/servlet/ControllerServlet"
		method="post">

		用户名 <input type="text" name="username" /> </br>
		 密码 <input type="password"name="password" /> </br> 
		 <input type="hidden" name="op" value="login" />
		<input type="submit" value="登录" />
	</form>
</body>
</html>
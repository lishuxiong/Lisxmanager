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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Birthday-Calendar.js"></script>
<title>register</title>
</head>

<body>
	<form
		action="${pageContext.request.contextPath}/servlet/ControllerServlet?op=register"
		method="post">
		<table border="1" width="600">
			<tr>
				<td>*用户名</td>
				<td><input type="text" name="username" value="${formBean.username}" />${formBean.errorMsg.username}</td>
			</tr>
			<tr>
				<td>*密码:</td>
				<td><input type="password" name="password"
					value="${formBean.password }" />${formBean.errorMsg.password }</td>
			</tr>
			<tr>
				<td>*确认密码:</td>
				<td><input type="password" name="repass"
					value="${formBean.repass }" />${formBean.errorMsg.repass }</td>
			</tr>
			<tr>
				<td>*Email:</td>
				<td><input type="text" name="email" value="${formBean.email }" />${formBean.errorMsg.email }</td>
			</tr>
			<tr>
				<td>*出生日期:</td>
				<td><input type="text" onclick="new Calendar().show(this);"
					name="birthday" readonly="readonly" value="${formBean.birthday }" />${formBean.errorMsg.birthday }</td>
			</tr>
			<tr>
				<td><input type="submit" value="注册" /></td>
				<td></td>
			</tr>


		</table>


	</form>


</body>
</html>
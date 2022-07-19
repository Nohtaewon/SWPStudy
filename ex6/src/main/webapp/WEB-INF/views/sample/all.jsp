<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta content="text/html; charset="UTF-8" http-equiv="Content-Type">
<title>Insert title here</title>
</head>
<body>
<!-- all or member or admin -->
<h1>/sample/all page</h1>
<security:authorize access="isAnonymous()">
	<a href="/customLogin">로그인</a>
</security:authorize>
<security:authorize access="isAuthenticated()">
	<a href="/customLogout">로그아웃</a>
</security:authorize>
</body>
</html>
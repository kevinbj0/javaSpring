<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 세선 저장소를 찾는다 -->
<c:if test = "${empty sessionScope.sessionId}">
<a href = "/cookie/login/login">로그인</a>
</c:if>

<c:if test = "${not empty sessionScope.sessionId}">
<a href = "/cookie/login/logOut">로그아웃</a>
</c:if>
</body>
</html>
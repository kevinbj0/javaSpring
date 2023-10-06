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
화이팅 메시지 3개 출력
${key} 진짜진짜


<% String value = (String)request.getAttribute("key"); %>
<%=value %>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	function search() {
		alert("조회 성공");
		$.ajax({
			type : "GET",
			url : "${pageContext.request.contextPath}/naverAjax",
			success : function(data) {
				console.log(data);
				let result = toHTML(data);
				$("#result").html(result);
			},
			error : function() { // 여기서 수정이 필요합니다.
				alert("error");
			}
		});
	}

	function toHTML(d) {
		console.log(d);
		let str = "<ul>";
		for (let i = 0; i < d.length; i++) {
			let item = d[i];
			str += "<li>" + item.title + " " + item.link + "</li>";
		}
		str += "</ul>";
		alert(str);
		document.getElementById("result").innerHTML = str;
	}
</script>
</head>
<body>
	<h2>비동기</h2>
	<button onclick="search()">조회</button>
	<div id="result"></div>
</body>
</html>
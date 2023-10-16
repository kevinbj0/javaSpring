<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     
<!DOCTYPE html>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
function search(){
	alert("조회 동작");
	$.ajax({
		type: "GET", // GET 메서드 사용
		url: "${pageContext.request.contextPath}/pCarrot2",
		success: function(data){
			console.log(data);
			let result = toHTML(data);
			$("#result").html(result);
		},
		error: function(){
			alert("error");
		}
	});
}

function toHTML(data){
	//let datalist  = data.Cresult; 
	let str = "<ul>";
	for(let i = 0; i < data.length; i++){
		let item = data[i];
		str += "<li>" + item.goodsName + " " + item.goodsCode + "</li>";
	}
	str += "</ul>";

	alert(str);
	return str;
}
</script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>출력</h1>
<button onclick = "search()"> 조회</button>
<div id = "result"></div>

</body>
</html>
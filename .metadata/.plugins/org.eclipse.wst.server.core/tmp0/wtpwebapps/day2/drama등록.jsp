<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
function register(){
	//alert("sd");
	let name = $("#name").val();
	let actor = $("#actor").val();
	alert(name);
	
	let drama = {name:name, actor:actor}; //==>문자열 바꿔줌
	let dramas = JSON.stringify(drama);//json형태로 바꿔줌
	alert(dramas);//json형태
	console.log(drama);
	
	console.log(dramas)
	//$.ajax();
	$.ajax({
		type:"PUT", 
		url: "/day2/drama",
		data:dramas,
		contentType: "application/json", //필수값..!!
		success:function(data){
			alert(data);
		},
		error:function(){
			alert("에러");
		}
	});
}
</script>
</head>
<body>
	<input type="text" id="name">
	<input type="text" id="actor">
	<button onclick=register()>등록</button>

</body>
</html>
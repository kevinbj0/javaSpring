<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<script>
let data = [
	{name:'무빙', actor:'류승룡'},
	{name:'더글로리', actor:'송혜교'}	
];

let str = "<ul>";

for(let i =0; i<data.length; i++){
	let item = data[i];
	str += "<li>" + item.name +"</li>";
}
str += "</ul>";
alert(str);
console.log(data);

let str2 = "<ul>"
data.forEach(function (item){
	str2 += "<li>" + item.name +"</li>"
});
str2+="</ul>";
alert(str2);
</script>



</body>
</html>
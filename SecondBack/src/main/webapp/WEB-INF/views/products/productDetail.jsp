<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set  var="path"   value="${pageContext.request.contextPath}"/> 
<!--${path} -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>


<body>

	<form action="/testing/products" method="get"
		enctype="multipart/form-data">
		<table border="1">
			<thead>
				<tr>
					<th>제목</th>
					<th>작성일</th>
					<th>지역</th>
					<th>가격</th>
					<th>내용</th>
					<th>조회수</th>
					<th>관심</th>
					<th>이미지</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${product.board_Title}</td>
					<td>${product.board_Date}</td>
					<td>${product.loc_code}/${product.detail_loc}</td>
					<td>${product.board_Price}</td>
					<td>${product.board_Text}</td>
					<td>${product.board_Click }</td>
					<td id = "likes">${likenum}</td>
					<td><img src="<c:url value="/images/${product.board_Img}" />"
						alt="Product Image" style="max-width: 100px; max-height: 100px;">
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	<!-- 관심 버튼 추가 -->
	<button id="like">관심 버튼</button>

	<!-- 삭제 버튼 추가 -->
	<!-- products/delete.jsp -->
	<form action="/testing/products/delete" method="post"
		enctype="multipart/form-data">
		<button type="submit">삭제</button>
		<input type="hidden" name="boardId" value="${product.board_Id}">
	</form>


	<form action="/testing/products/update" method="get"
		enctype="multipart/form-data">
		<button type="submit">수정</button>
		<input type="hidden" name="boardId" value="${product.board_Id}">
	</form>

	<script>
let loading = false; // 추가 데이터 로딩 중 여부
let onClick = ${onClick};
console.log("jsp확인 = " + onClick);
//좋아요
function like(boardId, userId) {
    if (!loading) {
        loading = true;
        $.ajax({
            url: "${path}/products/like", // 서버측 엔드포인트 설정
            type: "POST",              
            data: {boardId:boardId,
            	   userId:userId,
            	   onClick:onClick
            	},
            success: function (data) {
                $("#likes").empty();
                $("#likes").append(data);
              	liketoggle();
                loading = false;
            },
            error: function (error) {
                console.log("Error:", error);
                loading = false;
            }
        });
    }
}

function liketoggle(){
	if(onClick == false){
		$("#like").empty();
		$("#like").append("관심");
	}else if(onClick == true){
		$("#like").empty();
		$("#like").append("관심 해제");
	}
	
}

$(document).ready(function(){
	liketoggle();
    $("#like").click(function(){
    	console.log("토글 " + onClick);
    	like(${product.board_Id},"${user.user_id}");
    	onClick = !onClick;
    });
    
});
</script>
</body>
</html>
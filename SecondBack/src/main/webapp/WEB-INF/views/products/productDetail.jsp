<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.sh.login.domain.LoginDTO"%>
<%@ page import="com.sh.product.domain.ProductDTO"%>
<%@ page import="java.util.*"%>

<c:set  var="path"   value="${pageContext.request.contextPath}"/> 
<!--${path} -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<style>
body {
	display: flex;
	align-items: center;
	justify-content: center;
	height: 100vh;
	margin: 0;
}

.product-container {
	display: flex;
	border: 1px solid black;
	margin-bottom: 20px;
	padding: 10px;
}

.product-details {
	flex-grow: 1;
}

.product-details div {
	margin-bottom: 10px;
}
#like{
	width: 50px;
	hetght:50px;
	background-color: white;
	border: none;
}
#likeImg{
	width: 40px;
	height:40px;
}
</style>
</head>
<body>

	<%
	List<ProductDTO> products = (List<ProductDTO>) session.getAttribute("products");
	List<LoginDTO> selectedUserList = (List<LoginDTO>) session.getAttribute("selectedUser");
	//ProductDTO a = (ProductDTO) request.getAttribute("product");
	//LoginDTO user = (LoginDTO) session.getAttribute("user");
	//if (selectedUserList != null && !selectedUserList.isEmpty() && products != null && !products.isEmpty()) {
		// 수정: selectedUserList에서 selectedUser 가져오기
		LoginDTO selectedUser = selectedUserList.get(0);

		// 수정: products의 첫 번째 아이템 가져오기
		ProductDTO product = products.get(0);
	%>



	<!-- 로그인한 유저 코드와 게시글 작성한 유저 코드가 일치할시 수정/삭제버튼이 나옴 -->
	<c:set var="owner"
		value="${product.user_code  == selectedUser[0].user_code}"></c:set>

	<h2><%=selectedUser.getUser_nickname()%>
		님
	</h2>

	<form action="/testing/products" method="get"
		enctype="multipart/form-data">
		<div>
			<!-- 로그인한 유저 코드와 게시글 유저코드를 불러옴 -->
			<input type="hidden" name="user_code1" id="user_code1"
				value="<%=selectedUser.getUser_code()%>" required> <input
				type="hidden" name="user_code3" id="user_code3"
				value="${product.user_code}" required>

			<div class="product-container">
				<div class="product-image">
					<img src="<c:url value='/images/${product.board_Img}' />"
						alt="Product Image" style="max-width: 500px; max-height: 500px;">
				</div>
				<div class="product-details">
					<div>분류: [${product.board_cate}]</div>
					<div>제목: ${product.board_Title} 작성자: ${product.user_nickname }</div>
					<div>작성일: ${product.board_Date} 조회수: ${product.board_Click}</div>
					<div>지역: ${product.loc_code}/${product.detail_loc}</div>

					<div>내용: ${product.board_Text}</div>
					<div>가격: ${product.board_Price}</div>
					<div id = "likes">관심 : ${likenum} 개</div>
				</div>
			</div>


		</div>
	</form>

	<c:if test="${owner}">
		<!-- 수정부분 -->
		<form action="/testing/products/update" method="get">
			<input type="hidden" name="user_code1" id="user_code1"
				value="<%=selectedUser.getUser_code()%>" required> <input
				type="hidden" name="user_code3" id="user_code3"
				value="<%=product.getUser_code()%>" required> <input
				type="hidden" name="boardId" value="${product.board_Id}">
			<button type="submit">수정</button>
		</form>
		<!-- 삭제부분 -->
		<form action="/testing/products/delete" method="post">
			<input type="hidden" name="user_code1" id="user_code1"
				value="<%=selectedUser.getUser_code()%>" required> <input
				type="hidden" name="user_code3" id="user_code3"
				value="<%=product.getUser_code()%>" required> <input
				type="hidden" name="boardId" value="${product.board_Id}">
			<button type="submit">삭제</button>
		</form>
		<form action="/testing/products/updateDate" method="post"
			id="updateDateForm">
			<input type="hidden" name="boardId" value="${product.board_Id}">
			<button type="submit">날짜 갱신</button>
		</form>

	</c:if>
	<form action="/testing/products/likes" method="post">
		<input type="text" name="user_code1" id="user_code1"
			value="<%=selectedUser.getUser_code()%>" required> <input
			type="hidden" name="boardId" value="${product.board_Id}">

	</form>
	<%
	//} else {
	// products나 selectedUserList가 비어있을 때 예외 처리
	//out.println("상품 정보를 찾을 수 없습니다.");
	//}
	%>
	<!-- 관심 버튼 추가 -->
	<button id="like">관심 버튼</button>

	<form action="/testing/scrollHome">
		<button type="submit">상품</button>
	</form>

	<form action="/testing/order">
		<input type="hidden" name="boardId" value="${product.board_Id}">

		<button type="submit">상품 구매</button>
	</form>

	<form action="/testing/logout" method="post">
		<button type="submit">로그아웃</button>
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
	            	   userId:userId
	            	},
	            success: function (data) {
	                $("#likes").empty();
	                $("#likes").append("관심 : " + data.likenum + " 개");
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
			//빈하트
			$("#like").append(`<img id="likeImg" src="${path}/resources/product/heart.png">`);
		}else if(onClick == true){
			$("#like").empty();
			//꽉찬 하트
			$("#like").append(`<img id="likeImg" src="${path}/resources/product/hfull.png">`);
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
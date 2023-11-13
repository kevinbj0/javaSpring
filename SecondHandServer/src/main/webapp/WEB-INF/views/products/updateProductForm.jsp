<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ page import="com.sh.login.domain.LoginDTO"%>
          <%@ page import="com.sh.product.domain.ProductDTO"%>
          <%@ page import="java.util.*"%>
          
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh; /* 100% 높이 화면 중앙 정렬을 위해 추가 */
        }

        h2 {
            color: #333;
        }

        form {
            max-width: 800px;
            width: 100%;
            margin-top: 20px;
            box-shadow: 0px 0px 5px #ccc;
            padding: 20px;
            border-radius: 8px;
        }

        label {
            margin-bottom: 8px;
            display: block;
        }

        input,
        select,
        textarea {
            width: 100%;
            padding: 8px;
            margin-bottom: 16px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }

        button {
            background-color: #2070eb;
            color: white;
            border: none;
            padding: 10px 20px;
            font-size: 14px;
            font-weight: bold;
            border-radius: 4px;
            cursor: pointer;
        }

        select#detail_loc {
            margin-bottom: 16px;
        }
    </style>
</head>
  <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    
<body>
   <%
   LoginDTO user = (LoginDTO) session.getAttribute("user");
   List<LoginDTO> selectedUser = (List<LoginDTO>) session.getAttribute("selectedUser");
   if (user != null && selectedUser != null && !selectedUser.isEmpty()) {
      LoginDTO firstSelectedUser = selectedUser.get(0); // Assuming you want the first user in the list
   %>
    <h2>상품수정</h2>
    
    <form action="/testing/products/update" method="post" enctype="multipart/form-data">
      	<label for="board_cate">분류:</label>
    	   	 <select id="board_cate" name="board_cate">
     <option value="판매">판매</option>
     <option value="나눔">나눔</option>
     </select>
     
        <label for="board_Title">제목:</label>
        <input type="text" id="board_Title" name="board_Title" required  value="${product.board_Title}"><br>

        <label for="board_Price">가격:</label>
        <input type="number" id="board_Price" name="board_Price" required value="${product.board_Price}"><br>
      
      
     <label for="board_Category">카테고리</label>
     <select id="loc_code" name="loc_code">
    <option value="서울시">서울</option>
    <option value="제주도">제주도</option>
    <option value="경기도">경기도</option>
    <option value="충청도">충청도</option>
    <option value="경상도">경상도</option>
    <option value="전라도">전라도</option>
    <option value="강원도">강원도</option>

</select>

<!--  지역에 따른 중분류 -->
<select id="detail_loc" name="detail_loc">
    <!-- 중분류 옵션은 자바 스크립트에서 처리하고 받아옴 -->
</select><br>

  
        <label for="board_Text">내용:</label>
        <textarea id="board_Text" name="board_Text" required  >${product.board_Text}</textarea><br>
  <input type="hidden" name="boardId" value="${product.board_Id}">
        <label for="board_Img">이미지:</label>
        <input type="file" id="board_Img" name="file" required><br>
 <input type="hidden" name="user_code" id="user_code" value="<%= firstSelectedUser.getUser_code() %>" required>
       <input type="hidden" name="user_nickname" id="user_nickname" value="<%= firstSelectedUser.getUser_nickname() %>" required>
        <button type="submit"> 상품수정</button>
 
    </form>

 <script>
    var categoryData = ${item}; 
    
    console.log(categoryData);

    // 초기에 서울에 해당하는 중분류 추가
    categoryData['서울시'].forEach(function (item) {
        $("#detail_loc").append('<option value="' + item.detail_loc + '">' + item.detail_loc + '</option>');
    });
    

    $("#loc_code").on("change", function () {
        let key = this.value;
        // 선택된 대분류에 따라 중분류 변경
        $("#detail_loc").empty(); // 기존 중분류 옵션 제거
        categoryData[key].forEach(function (item) {
            $("#detail_loc").append('<option value="' + item.detail_loc + '">' + item.detail_loc + '</option>');
        });
    });

    $("#detail_loc").on("change", function () {
        alert("선택: " + $(this).val());
    });
</script>
    <% } %>
</body>
</html>
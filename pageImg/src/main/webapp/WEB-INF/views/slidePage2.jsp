<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.carrot.page.BoardDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<style>
.wrap {
	height: 5000px;
	width: 1000px;
	margin: 0 auto;
}


</style>

<script>
    let page = 1;
    let loading = false; // 추가 데이터 로딩 중 여부
    loadPage(page);
    
  	function  pageToString(list){
    	
    	 console.log( list); 
    	 let sql ="<div ><table style='display:flex;'>"
    	 list.forEach(  ( item) => { 
    		 console.log( item); 
     		 sql += `     	           
                 <tr>
                     <td>
                     <img src='<%= "${item.image1}" %>'
                         style='width: 100px; height: 100px;'></td>
                 </tr>
                 <tr>
                     <td>         [<%= "${item.num}" %>] <%= "${item.content}" %></td>
                 </tr>
              
         `;} );
    	 sql += "</table></div>";
    	
        return sql;
 	}

    // 페이지 로드 함수
    function loadPage(pageNumber) {
        if (!loading) {
            loading = true;
            $.ajax({
                url: "slidelist2?p=" + pageNumber, // 서버측 엔드포인트 설정
                type: "GET",              
                success: function (data) {
                    // 받은 HTML을 .wrap에 추가
                    let list =  data.list;
                    console.log("성공", data);       
                 
                    let sql = pageToString(list);
                    $(".wrap").empty();
                    $(".wrap").append(sql);
                  
                    loading = false;
                },
                error: function (error) {
                    console.log("Error:", error);
                    loading = false;
                }
            });
        }
    }

    // 스크롤 이벤트 리스너
    window.addEventListener("scroll", function () {
        const scrollY = window.scrollY;
        const pageHeight = document.body.scrollHeight;

        if (page === 1 && scrollY >= 1000) {
            page = 2;
            alert(page + " 작동");
            loadPage(page);
            $("html, body").animate({scrollTop: 0}, 500);
        } else if (page === 2 && scrollY >= 2000) {
            page = 3;
			alert(page + " 작동");
            loadPage(page);
   		 	$("html, body").animate({scrollTop: 1000}, 500);
        }else if (page === 3 && scrollY >= 2500) {
            page = 4;
			alert(page + " 작동");
            loadPage(page);
            $("html, body").animate({scrollTop: 2000}, 500);
        }else if (page === 4 && scrollY >= 3000) {
            page = 5;
            loadPage(page);
            $("html, body").animate({scrollTop: 2500}, 500);
        }else if (page === 5 && scrollY >= 3500) {
            page = 6;
			alert(page + " 작동");
            loadPage(page);
            $("html, body").animate({scrollTop: 3000}, 500);
        }
    });
    
    
    $(document).ready(function(){
        // 버튼을 클릭하면 페이지 맨 위로 스크롤합니다.
        $("#myBtn").click(function(){
            $("html, body").animate({scrollTop: 0}, 1000); // 1000은 애니메이션 속도를 나타냅니다. 여기서는 1000ms로 설정했습니다.
        });
    });
</script>
<style>
#myBtn {
	position: fixed;
	bottom: 20px;
	right: 30px;
	z-index: 99;
	border: none;
	outline: none;
	background-color: red;
	color: white;
	cursor: pointer;
	padding: 15px;
	border-radius: 10px;
}

#myBtn:hover {
	background-color: #555;
}
</style>
<body>

	<div class="wrap"></div>

	<button id="myBtn" title="Go to top">Top</button>
	<div
		style="height: 1500px; background-color: black; color: white; padding: 30px">스크롤
		내용...</div>
	<div style="background-color: lightgrey; padding: 30px">스크롤 내용...</div>

</body>
</html>

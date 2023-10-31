<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<style>
.wrap {
	height:1200px;
	width:300px;
	margin: 0 auto;
	dixplay: flex;
	outline: 1px solid black;
}

.imgwrap {
	width: 300px;
	height: 100px;
	border: none;
	outline: 1px solid black;
	display: flex;
	line-height: 100px;
}

.imgBox {
	width: 100px;
	height: 100px;
}

.div2 {
	width: 100%;
}
#myBtn {
	position: fixed;
	bottom: 20px;
	right: 30px;
	z-index: 99;
	border: none;
	outline: none;
	background-color: black;
	color: white;
	cursor: pointer;
	padding: 15px;
	border-radius: 10px;
}

</style>

<script>
	$("html, body").animate({scrollTop: 0}, 0);
    let page = 1; //초기 페이지
    let HeightY = 600; //초기 작동 위치(6칸)
    let cursorH = page*HeightY; //로드 시 스크롤 위치 조정
    let wrapH = HeightY*2; //초기 wrap 높이
    
    let totalPage; // totalpage ajax에서 불러옴
    

    let loading = false; // 추가 데이터 로딩 중 여부
    loadPage(page);
    
  	function  pageToString(list){
    	 console.log( list); 
    	 let sql = "";
    	 list.forEach(  ( item) => { 
    		 console.log( item); 
     		 sql += `     	 
     		<div class="imgwrap">
     			<div class="div1">
     				<img
     					src='<%= "${item.image1}" %>'
     					class="imgBox" />
     			</div>
     			<div class="div2">[<%="${item.num}"%>] <%="${item.content}"%></div>
     		</div>  
    	`;} );
    	
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
                    totalPage = data.totalPage;
                    console.log("성공" + data);     
                    console.log("헨들러" + totalPage);  
                 
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

    // 스크롤 이벤트
    window.addEventListener("scroll", function () {
        const scrollY = window.scrollY;
        const pageHeight = document.body.scrollHeight;
        
        if (scrollY >= HeightY && page < totalPage) {
            page += 1;
            HeightY += cursorH;
            //alert(page + " 작동, " + pageHeight+", " + scrollY);
            $("html, body").animate({scrollTop: (page-1)*cursorH}, 500);
            loadPage(page);
            wrapH += cursorH;
            $(".wrap").css("height", wrapH);
        } 
    });
    
    //맨위로 올리기
    $(document).ready(function(){
    	$("html, body").animate({scrollTop: 0}, 1000);
        // 버튼을 클릭하면 페이지 맨 위로 스크롤합니다.
        $("#myBtn").click(function(){
            $("html, body").animate({scrollTop: 0}, 1000); // 1000은 애니메이션 속도를 나타냅니다. 여기서는 1000ms로 설정했습니다.
        });
    });
</script>
</head>
<body>
	<div class="wrap"></div>

	<button id="myBtn" title="Go to top">Top</button>

</body>
</html>

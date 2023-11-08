<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="path" value="${pageContext.request.contextPath}" />


<!--<c:set  var="path2"   value="<%=request.getContextPath() %>"/> -->


<!--${path} -->
<!--${path2}  -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<style>
.wrap {
	height: 3000px;
	width: 1000px;
	margin: 0 auto;
	dixplay: flex;
}

.imgwrap {
	width: 1000px;
	height: 100px;
	border: none;
	display: flex;
	outline: 1px solid gray;
	line-height: 100px;
}

.imgBox {
	width: 100px;
	height: 100px;
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

#sort {
	width: 1000px;
	margin: 0px auto;
}
</style>
</head>
<body>


	<div
		style='height: 150px; background-color: burlywood; font-size: 20px; color: white'>
	</div>
	<a href="/testing/products/add">Add Product</a>
	<div id="sort">
		<button id="srTime">최신순</button>
		<button id="srClick">인기순</button>
		<button id="srLike">관심상품</button>
		<label for="srSearch">검색:</label><input type="text"
			id="srSearch" value="" /><br>
		<br>
	</div>
	<div class="wrap"></div>
	<button id="myBtn" title="Go to top">Top</button>


	<script>
	//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 설정할 부분
	let HeightY = 600; //페이지당 나오는 아이템들 높이합
	//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

    let page = 1; //초기 페이지
    let sort_mode = ".getListTime"; // 정렬 기본값 : 최신순
    //조회순(인기순) 정렬 : ".getListClick"

    let cursorH = page*HeightY; //로드 시 스크롤 위치 조정
    let wrapH = HeightY*5; //초기 wrap 높이
    let totalPage; // totalpage ajax에서 불러옴
    let loading = false; // 추가 데이터 로딩 중 여부
    
    let userId = "${user.user_id}";
    console.log("유저 : " + userId);
    
   	loadPage(page);
    $("html, body").animate({scrollTop: 0}, 0);

    function loadPage(pageNumber, searchTerm) {
		if (!loading) {
			loading = true;
			$.ajax({
				url: "scroll?p=" + pageNumber + "&mode=" + sort_mode + "&searchTerm=" + searchTerm,
				type: "GET",
				success: function(data) {
					let list = data.list;
					totalPage = data.totalPage;
					let sql = pageToString(list);
					$(".wrap").empty();
					$(".wrap").append(sql);
					loading = false;
				},
				error: function(error) {
					console.log("Error:", error);
					loading = false;
				}
			});
		}
	}
    
    function postLikeList(){
    	if (!loading) {
			loading = true;
			$.ajax({
				url: "${path}/likeList",
				type: "POST",
				data: {userId:userId},
				success: function(data) {
					let list = data;
					let sql = pageToString(list);
					$(".wrap").empty();
					$(".wrap").append(sql);
					loading = false;
				},
				error: function(error) {
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
            $("html, body").animate({scrollTop: (page-1)*cursorH}, 500);
            loadPage(page);
            wrapH += cursorH;
            $(".wrap").css("height", wrapH);
	    } 
        else if(scrollY >= HeightY && page == totalPage){
        	page += 1;
        	$(".wrap").css("height", wrapH-(cursorH*3));
        	let endSql = `     	 
         		<div style = 'height:400px; background-color: gray; font-size:40px; color:white'>
         			Footer
         		</div>  
        	`
        	$("body").append(endSql);
        }
    });
    
    //str문 생성
  	function  pageToString(list){
   	 let str = "";
   	 list.forEach(  ( item) => { 
   			str += `     	 
    		<div class="imgwrap">
    			<div class="div1">
    			<img src="${path}/images/<%="${item.board_img}" %>" alt="Product Image" style="max-width: 100px; max-height: 100px;">
    			</div>
    			<div>&nbsp[<%="${item.num}"%>] <a href="/testing/products/detail?boardId=<%="${item.board_id}" %>"><%="${item.board_title}"%></a> |&nbsp</div>
    			<div><%="${item.board_date}"%> | <%="${item.user_nickname}"%> | <%="${item.loc_code}"%>/<%="${item.detail_loc}"%>
    			| <%="${item.board_price}"%> | 조회수 : <%="${item.board_click}"%> 
    			</div>
    		</div>
   	`
   	;} );
       return str;
	}
    
    //맨위로 올리기
	$(document).ready(function() {
		//초기 스크롤
		$("html, body").animate({scrollTop: 0}, 0);

		//맨 위로
		$("#myBtn").click(function() {
			$("html, body").animate({scrollTop: 0}, 1000);
		});

		//시간순 정렬
		$("#srTime").click(function() {
			sort_mode = ".getListTime";
			loadPage(page);
		});

		//인기순 정렬
		$("#srClick").click(function() {
			sort_mode = ".getListClick";
			loadPage(page);
		});
		
		//관심 상품
		$("#srLike").click(function() {
			 postLikeList();
		});
		
		//검색
		$("#srSearch").on('input', function() {
			let searchTerm = $("#srSearch").val();
			loadSearchResults(searchTerm);
		});

		function loadSearchResults(searchTerm) {
			$.ajax({
				url: "search?searchTerm=" + searchTerm,
				type: "GET",
				success: function(data) {
					let resultHtml = pageToString(data);
					$(".wrap").empty().append(resultHtml);
				},
				error: function(error) {
					console.log("Error:", error);
				}
			});
		}
	});
</script>
</body>
</html>

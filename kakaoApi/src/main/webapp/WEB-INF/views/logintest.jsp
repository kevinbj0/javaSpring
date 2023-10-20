<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <ul>
      <li onclick="kakaoLogin();">
        <a href="javascript:void(0)">
          <span>카카오 로그인</span>
        </a>
      </li>
      <li onclick="kakaoLogout();">
        <a href="javascript:void(0)">
          <span>카카오 로그아웃</span>
        </a>
      </li>
    </ul>
    <!-- 카카오 스크립트 -->
    <script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
    <script>
      Kakao.init("1525702a4d34de37f7fdff0d29fa6442"); //발급받은 키 중 javascript키를 사용해준다.
      console.log(Kakao.isInitialized()); // sdk초기화여부판단
      //카카오로그인
      function kakaoLogin() {
        Kakao.Auth.login({
          success: function (response) {
            Kakao.API.request({
              url: "/v2/user/me",
              success: function (response) {
            	  // 새로운 form 엘리먼트를 생성합니다.
                  var form = document.createElement('form');
                  form.method = 'POST';
                  form.action = '<c:url  value="/memberT"/>'; // 서버 URL을 여기에 입력하세요

                  // response 객체를 JSON 문자열로 변환하여 input 필드로 추가합니다.
                  var input = document.createElement('input');
                  input.type = 'hidden'; // 숨김 필드로 설정
                  input.name = 'kakaoResponse'; // 필드 이름을 설정
                  input.value = JSON.stringify(response); // response 객체를 JSON 문자열로 변환하여 설정

                  // form에 input 필드를 추가합니다.
                  form.appendChild(input);

                  // form을 body에 추가하고 제출합니다.
                  document.body.appendChild(form);
                  form.submit();
              },
              fail: function (error) {
                console.log(error);
              },
            });
          },
          fail: function (error) {
            console.log(error);
          },
        });
      }
      //카카오로그아웃
      function kakaoLogout() {
        if (Kakao.Auth.getAccessToken()) {
          Kakao.API.request({
            url: "/v1/user/unlink",
            success: function (response) {
              console.log(response);
            },
            fail: function (error) {
              console.log(error);
            },
          });
          Kakao.Auth.setAccessToken(undefined);
        }
      }
    </script>
  </body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.sh.saveUser.domain.UserDTO"%>
<%@ page import="com.sh.address.domain.AddressDTO"%>
<%@ page import="com.sh.kakaologin.domain.KakaoUserDTO"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <style>
      #user_pw {
        width: 270px;
      }

      #user_pw_confirm {
        width: 270px;
      }
    </style>
<script>
	function findAddr() {
		new daum.Postcode({
			oncomplete : function(data) {
				console.log(data);
				let roadAddr = data.roadAddress;
				let jibunAddr = data.jibunAddress;
				document.getElementById('member_post').value = data.zonecode;
				if (roadAddr !== '') {
					document.getElementById("member_addr").value = roadAddr;
				} else if (jibunAddr !== '') {
					document.getElementById("member_addr").value = jibunAddr;
				}
			}
		}).open();
	}
</script>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	
	
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        $(document).ready(function () {
        	$("#showPasswordCheckbox").on("change", function () {
    			let isChecked = $(this).is(":checked");
    			let type = isChecked ? "text" : "password";
    			$("#user_pw, #user_pw_confirm").attr("type", type);
    		});

            $("#user_pw, #user_pw_confirm").on("keyup", function () {
                let pass1 = $("#user_pw").val();
                let pass2 = $("#user_pw_confirm").val();

                if (pass1 !== "" || pass2 !== "") {
                    if (
                        pass1.length >= 8 &&
                        /[a-zA-Z]/.test(pass1) &&
                        /[0-9]/.test(pass1) &&
                        /[ `!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?~]/.test(pass1) &&
                        /^\S*$/.test(pass1)
                    ) {
                        if (pass1 === pass2) {
                            $("#checkPw").html("비밀번호가 일치합니다.");
                            $("#checkPw").css("color", "green");
                        } else {
                            $("#checkPw").html("비밀번호가 일치하지 않습니다.");
                            $("#checkPw").css("color", "red");
                        }
                    } else {
                        $("#checkPw").html(
                            "비밀번호는 영어, 숫자, 특수문자를 포함해 총 8글자 이상이어야 합니다."
                            + "<br>"+"단, 공백은 안됩니다."
                        );
                        $("#checkPw").css("color", "red");
                    }
                }
            });
        });
    </script>
	 <script>
      function checkPasswordMatch() {
        let confirmPassword = document.getElementById("user_pw_confirm").value;
        let matchDiv = document.getElementById("passwordMatchResult");
        let validityDiv = document.getElementById("passwordValidityMessage");
        let password = document.getElementById("user_pw").value;

        let passwordRegex =
          /^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*?_])(?!.*\s).{8,16}$/;

        if (passwordRegex.test(password)) {
          validityDiv.innerHTML = "비밀번호가 유효합니다.";
          validityDiv.style.color = "green";

          if (password === confirmPassword) {
            matchDiv.innerHTML = "비밀번호가 일치합니다.";
            matchDiv.style.color = "green";
          } else {
            matchDiv.innerHTML = "비밀번호가 일치하지 않습니다.";
            matchDiv.style.color = "red";
          }
        } else {
          validityDiv.innerHTML =
            "비밀번호는 최소 8자에서 16자까지, 영문자, 숫자 및 특수 문자를 포함해야 합니다.";
          validityDiv.style.color = "red";
          matchDiv.innerHTML = "";
          document.getElementById("user_pw").value = "";
          document.getElementById("user_pw_confirm").value = "";
        }
      }

      $(document).ready(function () {
        let isPasswordShown = false;

        $("#showPasswordCheckbox").on("change", function () {
          isPasswordShown = !isPasswordShown;
          if (isPasswordShown) {
            $("#user_pw, #user_pw_confirm").attr("type", "text");
          } else {
            $("#user_pw, #user_pw_confirm").attr("type", "password");
          }
        });

        $("#user_pw").on("blur", function () {
          checkPasswordMatch();
        });
        $("#user_pw_confirm").on("blur", function () {
          checkPasswordMatch();
        });
      });
    </script>
	<script>
	
	$(document).ready(function () {
	    $('#saveForm').submit(function (e) {
	    	let fields = ['#user_id', '#user_pw', '#user_pw_confirm', '#address', '#phone_num', '#member_post', '#member_addr', '#detailed_address', '#user_birth', '#user_nickname'];

	        for (let i = 0; i < fields.length; i++) {
	            if ($(fields[i]).val() === '') {
	                e.preventDefault();
	                alert('모든 값을 입력해 주세요');
	                return;
	            }
	        }
	    });
	});
	</script>
	
<script>
function checkUserIdAvailability() {
    let userId = $("#user_id").val();
    if (!userId) {
        $("#userIdMessage").text("아이디를 입력하세요.");
        $("#userIdMessage").css("color", "red");
        return;
    }

    $.ajax({
        type: "POST",
        url: "/testing/isUserIdExists",
        data: { user_id: userId },
        success: function (data) {
            if (data) {
                $("#userIdMessage").text("존재하는 아이디입니다. 다시 입력해주세요.");
                $("#userIdMessage").css("color", "red");
                $("#user_id").val("");
            } else {
                $("#userIdMessage").text("사용가능한 아이디 입니다!!!");
                $("#userIdMessage").css("color", "green");
            }
        },
        error: function (xhr, status, error) {
            let errorMessage = xhr.status + ': ' + xhr.statusText;
            alert("아이디 중복 확인에 실패했습니다. 나중에 다시 시도해주세요. 오류: " + errorMessage);
        }
    });
}
</script>
<script>
    var code = "";  /*인증번호 저장할 곳*/
    $(document).ready(function () {
        $('#auth_btn').click(function() {
            var email = $('#address').val();  /*입력한 이메일*/
            console.log('완성된 이메일 : ' + email); /* 이메일 오는지 확인*/
            var checkInput = $('.mail-check-input'); /* 인증번호 입력 */

            $.ajax({
                type: 'GET',
                url: 'testing/mailCheck',
                data: { email: email }, /* 데이터를 객체로 보내도록 수정 */
                success: function(data) {
                    console.log("data : " + data);
                    checkInput.prop('disabled', false); /* 데이터가 성공적으로 들어오면 인증번호 입력란이 활성화되도록 */
                    code = data;
                    alert('인증번호가 전송되었습니다.');
                },
                error: function(xhr, status, error) {
                    console.error("Error:", error);
                    var errorMessage = "이메일 주소 형식이 올바르지 않습니다. 다시 입력해주세요.";
                    alert(errorMessage);
                }
            });
        });
        $('#confirm_btn').click(function() {
        	  var inputCode = $("#verification_code").val();   /* 사용자가 입력한 인증 번호 */
              var checkResult = $("#verification-result");  /* 결과를 표시할 요소 */

              if (inputCode == code) { // 일치할 경우
                  checkResult.html("인증번호가 일치합니다.");
                  checkResult.css("color", "#3781E3");
                  checkResult.css("display", "block");
                  $("#verification_code").css("border", "1.5px solid #3781E3"); // 일치할 경우 테두리 색 변경
                  $("#verification_code").css("color", "#3781E3"); // 일치할 경우 글자 색 변경
              } else {                                            
                  checkResult.html("인증번호가 일치하지 않습니다.");
                  checkResult.css("color", "red");
                  checkResult.css("display", "block");
                  $("#verification_code").css("border", "1.5px solid red");
                  $("#verification_code").css("color", "red");
            }
        });   
    });
</script>
	
<style>
#member_post {
	width: 400px;
}

#member_addr {
	width: 400px;
}
</style>
</head>
<body>


	<form id="saveForm" method="post" action="/testing/saveForm">
        <input type="hidden" id="user_kakao" name="user_kakao" value="${user_kakao}">
        
      <label for="user_id">아이디:</label>
     <input type="text" id="user_id" name="user_id" placeholder="아이디" onfocus="this.placeholder = ''" onblur="checkUserIdAvailability()"><br>
       <span id="userIdMessage"></span><br>
    
    
        <label for="user_pw">비밀번호:</label>
   		 <input type="password" id="user_pw" name="user_pw" placeholder="비밀번호는 최소 8자에서 16자까지, 영문자, 숫자 및 특수 문자를 포함해야 합니다." onfocus="this.placeholder = ''"/><br />
    	 <div id="passwordValidityMessage"></div>
   		 <label for="user_pw_confirm">비밀번호 재확인:</label>
   		 <input
     	 type="password"
     	 id="user_pw_confirm"
      	name="user_pw_confirm"
     	 value=""
      	onkeyup="checkPasswordMatch()"
    		/><br />
    	<div id="passwordMatchResult"></div>

   		 <br />
    	<input type="checkbox" id="showPasswordCheckbox" />
   		 <label for="showPasswordCheckbox">비밀번호 보기</label><br />

        
        <label for="address">이메일:</label>
		<input type="text" id="address" name="address" placeholder="example@gmail.com" onfocus="this.placeholder = ''">
		<button type="button" id="auth_btn">이메일 인증</button><br><br>

		<label for="verification_code">인증번호:</label>
		<input type="text" id="verification_code" name="verification_code" placeholder="인증번호를 입력하세요" onfocus="this.placeholder = ''">
		<button type="button" id="confirm_btn">확인</button>
		<div id="verification-result"></div><br><br>
        
        <label for="phone_num">폰번호:</label>
        <input type="text" id="phone_num" name="phone_num" placeholder="핸드폰 번호" onfocus="this.placeholder = ''"><br>
        <input id="member_post" name="member_post" type="text" placeholder="Zip Code" readonly>
        <input id="member_addr" name="member_addr" type="text" placeholder="Address" readonly><br>
        <label for="detailed_address">상세 주소:</label>
        <input id="detailed_address" name="detailed_address" type="text" placeholder="Detailed Address" onfocus="this.placeholder = ''"><br>
        <button type="button" onclick="findAddr()">주소찾기</button><br>
        
        <label for="user_birth">생일:</label>
        <input type="text" id="user_birth" name="user_birth" placeholder="6자리 생년월일" onfocus="this.placeholder = ''"><br>
        
        <label for="user_nickname">닉네임:</label>
        <input type="text" id="user_nickname" name="user_nickname" value="${nickname}"><br>
        
        <label for="user_image">사용자 이미지:</label>
        <input type="hidden" id="user_image" name="user_image" value="${profile_image}"><br>
        
        <label for="user_heat" ></label>
        <input type="hidden" id="user_heat" name="user_heat" value="평점"><br>
        <button type="submit" form="saveForm">제출하기</button>
    </form>
<!-- 
	<div>Address</div>
	<form id="addressForm" method="post" action="/testing/addressForm">
	</form>

 -->
</body>
</html>
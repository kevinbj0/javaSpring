<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <script>
        let user_heat = ${user_heat};

        function evabtn(value) {
            user_heat += parseFloat(value);
            updateTemperature(user_heat);
        }

        function updateTemperature(temperature) {
            document.getElementById("temperature").innerHTML = '온도: ' + temperature.toFixed(1);
            // 추가: input 요소에 값을 할당
            document.getElementById("temperatureInput").value = temperature.toFixed(1);
        }
    </script>

<h1 id="temperature">온도: <script>document.write(parseFloat(${user_heat}).toFixed(1));</script></h1>
<c:set var="products" value="${sessionScope.products}" />
<!-- 추가: input 요소 -->
    <!-- 수정: input 요소에 name 속성 추가 -->
    <form action="/testing/updateHeat" method="post">
    
    
    
    <input type="hidden" name="user_id" id="user_id" value="" required>
    
   
    
    
        <input type="hidden" id="temperatureInput" name="user_heat" value="">
        <input type="hidden" name="user_code" value="${sell_code}"> 
<button class="eva" value="-0.2" onclick="evabtn(this.value)">1</button>
<button class="eva" value="-0.1" onclick="evabtn(this.value)">2</button>
<button class="eva" value="0" onclick="evabtn(this.value)">3</button>
<button class="eva" value="0.1" onclick="evabtn(this.value)">4</button>
<button class="eva" value="0.2" onclick="evabtn(this.value)">5</button>    </form>


</body>
</html>
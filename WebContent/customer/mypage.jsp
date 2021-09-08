<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Page</title>
<jsp:include page="../common/styleLink.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../common/navbar.jsp"></jsp:include>

<header class="w3-container" style="padding:128px 16px; margin: 0 400px">
<h1>마이페이지</h1>
<h3>${requestScope.customer.SId}님 안녕하세요!</h3> <br>

<button class="w3-button w3-black w3-padding-midium w3-large w3-margin-top">주문 확인</button>
<button onclick="location.href='pizza?command=customerUpdateReq&sId=${requestScope.customer.SId}'" class="w3-button w3-black w3-padding-midium w3-large w3-margin-top">회원 정보 수정</button>
<button onclick="location.href='pizza?command=customerDelete&sId=${requestScope.customer.SId}'"class="w3-button w3-black w3-padding-midium w3-large w3-margin-top">회원 탈퇴</button>
<br>
ID : ${requestScope.customer.SId} <br>
주소 : ${requestScope.customer.address} <br>
전화번호 : ${requestScope.customer.phone} <br>
---------------------<br><br>
</header>

<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>
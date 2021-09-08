<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Detail</title>
<jsp:include page="../common/styleLink.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../common/navbar.jsp"></jsp:include>

<header class="w3-container" style="padding:128px 16px; margin: 0 400px">
<h1>마이페이지</h1>
<h3>${requestScope.customer.SId}님 안녕하세요!</h3> <br>
<h5>회원 정보 수정</h5>
--------------------- <br>
ID : ${requestScope.customer.SId} <br>
주소 : ${requestScope.customer.address} <br>
전화번호 : ${requestScope.customer.phone} <br>
---------------------<br><br>
</header>

<a href="pizza?command=ordersAll&customerId=${requestScope.customer.customerId}">주문내역</a>

<a href="pizza?command=customerUpdateReq&sId=${requestScope.customer.SId}">수정하기</a>

<a href="pizza?command=customerDelete&sId=${requestScope.customer.SId}">탈퇴하기</a>
<br><hr><br>
</body>
</html>
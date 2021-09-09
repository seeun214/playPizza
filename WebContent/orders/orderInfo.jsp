<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>주문 내역</title>
<jsp:include page="../common/styleLink.jsp"></jsp:include>
</head>
<style>
body {
  background-image: url("../images/1.jpg");
  background-size: 1500px;
}
button {
	font-size: 200%;
	font-family: Fantasy;
}
div {
	font-size: 200%;
}
</style>
<body>  
<jsp:include page="../common/navbar.jsp"></jsp:include>

<header class="w3-container" style="padding:128px 16px; margin: 0 20px">
<div>
<h2><%= session.getAttribute("id") %>님의 주문이 완료되었습니다~ &#128523;</h2>
        <ul>
            <li>주문자: <%= session.getAttribute("id") %></li>
            <li>메뉴: <%= request.getParameter("menu") %></li>
            <li>지점명: <%= request.getParameter("branch") %></li>
        </ul>
</div>
        
<br><hr>

<button onclick="location.href='pizza?command=orderDelete&orderId=${requestScope.orderInsert.orderId}'">Cancle!</button>
	
<br><br><br>
</header>
</body>
<jsp:include page="../common/footer.jsp"></jsp:include>
</html>
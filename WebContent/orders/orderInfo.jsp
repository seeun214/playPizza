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
	font-size: 300%;
	font-family: Fantasy;
}
div {
	font-size: 200%;
}
</style>
<body>  
<jsp:include page="../common/navbar.jsp"></jsp:include>

<header class="w3-container" style="padding:128px 16px; margin: 0 20%">
	<div>
		<h2><%= session.getAttribute("id") %>님의 주문이 완료되었습니다. &#128523;</h2>
		<ul style="list-style:none;">
		    <li>메뉴: <%= request.getParameter("menu") %></li>
		    <li>지점명: <%= request.getParameter("branch") %></li>
		</ul>
	</div>
	        
	<hr>
	
	<button onclick="location.href='pizza?command=orderDelete&orderId=${requestScope.orderInsert.orderId}'"
			class="w3-button w3-black w3-padding-medium w3-large w3-margin-top">
			Cancel
	</button>
		
	<br><br><br>
</header>
<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>
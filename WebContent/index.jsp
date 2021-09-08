<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome playPizza</title>
</head>

<header>
	<jsp:include page="common/loginHeader.jsp"></jsp:include>
</header>

<body>

	<form action="pizza?command=customer" method="post">
		고객 ID : <input type="text" name="sId"><input type="submit" value="검색">
	</form>
	
	<br><hr><br>
	
	<audio src="sound/oohyo-pizza.mp3" controls="controls" > </audio> <br>
	
	<a href="pizza?command=branchesAll">1. 모든 지점 검색</a><p>
	<form action="pizza?command=branch" method="post" >
		&nbsp;&nbsp;&nbsp;
		2. 지점명 : <input type="text" name="name"><input type="submit" value="검색">
	</form>
	
	<br><br><br>
	<a href="pizza?command=menuAll">모든 Menu 검색</a><p>
	

	
	<br><br><br>
	
	<br>
	<form action="pizza?command=orders" method="post" >
		
		주문 번호 : <input type="text" name="orderId"><input type="submit" value="검색">
	</form>
</body>
</html>
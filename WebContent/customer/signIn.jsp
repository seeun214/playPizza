<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>회원가입</title>
<jsp:include page="../common/styleLink.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../common/navbar.jsp"></jsp:include>

	<header class="w3-container" style="padding: 128px 16px; margin: 0 20%">
		<h1>Sign In</h1>
		<h5>정확한 정보를 적어주세요 :)</h5>
		<br>

		<form action="../pizza" method="post">
			<input type="hidden" name="command" value="customerInsert"> 
			
			<label for="sId">ID</label>
			<input class="w3-input" type="text" id="sId" name="sId" required style="margin-bottom:20px;">
			
			<label for="password">Password</label>
			<input class="w3-input" type="password" id="password" name="password" required style="margin-bottom:20px;">
				
			<label for="address">주소</label>
			<input class="w3-input" type="text" id="address" name="address" required style="margin-bottom:20px;">
				
			<label for="phone">전화번호</label>
			<input class="w3-input" type="text" id="phone" name="phone" required style="margin-bottom:20px;">
				
			<input class="w3-input w3-red" type="submit" value="가입" style="cursor:pointer;">
		</form>
	</header>

	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>
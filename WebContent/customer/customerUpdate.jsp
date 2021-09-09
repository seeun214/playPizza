<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<jsp:include page="../common/styleLink.jsp"></jsp:include>
</head>
<body>

<jsp:include page="../common/navbar.jsp"></jsp:include>

<header class="w3-container" style="padding:128px 16px; margin: 0 20%">
<h1>회원 정보 수정</h1>
<h3>${requestScope.customer.SId}님의 정보를  변경하실 수 있습니다. (ID 제외)</h3> <br>

	<c:if test="${not empty sessionScope.id}">
		<form action="pizza?command=customerUpdate" method="post">
			ID <input class="w3-input" type="text" name="sId" value="${sessionScope.id}" readonly > <br>
			Password <input class="w3-input" type="password" name="password" required value="${requestScope.customer.password}"> <br>
			address <input class="w3-input" type="text" name="address" required value="${requestScope.customer.address}"> <br>
			phone <input class="w3-input" type="text" name="phone" required value="${requestScope.customer.phone}"> <br>
			
			<input class="w3-input w3-red" type="submit" value="수정" style="cursor:pointer;">
		</form>
	</c:if>
</header>

<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>
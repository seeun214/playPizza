<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>

<header>
	<jsp:include page="../common/loginHeader.jsp"></jsp:include>
</header>
<body>

	<a href="../index.jsp">메인으로 돌아가기</a> <br><hr><br>
	<c:if test="${not empty sessionScope.id}">
		ID : <input type="text" name="sId" value="${sessionScope.id}" readonly > <br>
		address : <input type="text" name="address" value="${sessionScope.address}"> <br>
		phone : <input type="text" name="phone"> <br>
		
		<input type="submit" value="검색">
	</c:if>
	
</body>
</html>
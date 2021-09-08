<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<% 	
	String url = application.getContextPath() + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Menu Detail</title>
<jsp:include page="../common/styleLink.jsp"></jsp:include>
</head>
<body>
${requestScope.successMsg}
<jsp:include page="../common/navbar.jsp"></jsp:include>
<header class="w3-container" style="padding:128px 16px; margin: 0 400px">
<h1>${requestScope.menu.name}</h1>
<h5>${requestScope.menu.price}원</h5>
<img src="images/berry.jpg" class="w3-round" alt="Pizza" style="width: 100%;">
</header>
<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>
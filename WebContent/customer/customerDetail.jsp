<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 	
	String url = application.getContextPath() + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Detail</title>
</head>
<header>
	<jsp:include page="../common/loginHeader.jsp"></jsp:include>
</header>

<body>
회원정보 <br>
--------------------- <br>
ID : ${requestScope.customer.SId} <br>
주소 : ${requestScope.customer.address} <br>
전화번호 : ${requestScope.customer.phone} <br>
---------------------<br><br>


<a href="pizza?command=customerUpdateReq&sId=${requestScope.customer.SId}">수정하기</a>

<a href="pizza?command=customerDelete&sId=${requestScope.customer.SId}">탈퇴하기</a>
<br><hr><br>
<a href="${pageContext.request.contextPath}">메인으로 돌아가기</a> <br>
</body>
</html>
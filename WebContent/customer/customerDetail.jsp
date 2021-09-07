<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
--------------------- <br>
ID : ${requestScope.customer.SId} <br>
주소 : ${requestScope.customer.address} <br>
전화번호 : ${requestScope.customer.phone} <br>
---------------------
</body>
</html>
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
<title>Orders</title>
</head>
<body>
<h1>주문 정보 상세페이지</h1>


${requestScope.successMsg}



<table border="1">
	<tr>
		<th>주문 번호</th><th>메뉴</th><th>지점</th>
	</tr>
 	<tr>
 		<td>${requestScope.orders.orderId}</td>
 		<td>${requestScope.orders.menuId}</td>
 		<td>${requestScope.orders.branchId}</td>
 	</tr>
</table>

</body>
</html>
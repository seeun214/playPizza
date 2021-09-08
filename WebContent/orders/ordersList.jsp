<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<% String url = application.getContextPath() + "/"; %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Orders</title>
</head>
<body>
<h1>전체 주문 정보</h1>

<table border="1">
	<thead>
		<tr>
			<th>주문 번호</th><th>메뉴</th><th>지점</th>
		</tr>
	</thead>
	
	<c:forEach items="${requestScope.orders}" var="data">
		 <tr>
		 	<td>${data.orderId}</td>
 			<td>${data.menuId}</td>
 			<td>${data.branchId}</td>
		 </tr>
	 </c:forEach>

</table>

</body>
</html>
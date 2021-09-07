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

<font color="black">메뉴 이름을 클릭하여 가격을 확인하세요.</font>

<table border="1">
	<thead>
		<tr>
			<th>주문 번호</th><th>고객 이름</th><th>메뉴</th><th>지점명</th>
		</tr>
	</thead>
	
	<c:forEach items="${requestScope.ordersAll}" var="data">
		 <tr>
		 	<td>${data.orderId}</td>
		 	<td>${data.customerId.name}</td>
		 	<td>${data.menuId}</td>
		 	<td>${data.branchId.name}</td>
		 </tr>
	 </c:forEach>

</table>

</body>
</html>
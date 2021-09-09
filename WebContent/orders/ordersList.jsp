<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<% String url = application.getContextPath() + "/"; %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Orders</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<jsp:include page="../common/navbar.jsp"></jsp:include>
<header class="w3-container" style="padding:128px 16px; margin: 0 20%">
	<h1>Order History</h1>
	<hr>
	
	

<table border="1" class="w3-table w3-centered" style="border: 1px solid white;">
	<thead>
		<tr class="w3-red" >
			<th>주문 번호</th><th>메뉴</th><th>가격</th><th>지점</th><th>전화번호</th>
		</tr>
	</thead>
	
	<c:forEach items="${requestScope.orders}" var="data">
		 <tr style="border: 1px solid white;">
		 	<td style="border: none;">${data.orderId}</td>
 			<td>${data.menuId.name}</td>
 			<td>${data.menuId.price}</td>
 			<td>${data.branchId.name}</td>
 			<td>${data.branchId.phone}</td>
		 </tr>
	 </c:forEach>

</table>
<br>
</header>
<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>
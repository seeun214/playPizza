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
<title>Menu</title>
</head>
<body>
<h1>메뉴 상세페이지</h1>


${requestScope.successMsg}



<table border="1">
	<tr>
		<th>메뉴</th><th>가격</th>
	</tr>
 	<tr>
 		<td>${requestScope.menu.name}</td>
 		<td>${requestScope.menu.price}</td>
 	</tr>
</table>

</body>
</html>
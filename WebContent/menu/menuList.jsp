<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<% String url = application.getContextPath() + "/"; %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Menu</title>
</head>
<body>
<h1>Menu</h1>

<font color="black">메뉴 이름을 클릭하여 가격을 확인하세요.</font>

<table border="1">
	<thead>
		<tr>
			<th>링크</th><th>메뉴</th><th>가격</th>
		</tr>
	</thead>
	
	<c:forEach items="${requestScope.allMenu}" var="data">
		 <tr>
		 	<td><a href="${url}pizza?command=oneMenu&name=${data.name}">${data.name}</a></td>
		 	<td>${data.name}</td>
		 	<td>${data.price}</td>
		 </tr>
	 </c:forEach>

</table>

</body>
</html>
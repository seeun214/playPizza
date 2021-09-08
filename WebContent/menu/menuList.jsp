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
<h1>전체 메뉴</h1>

<font color="black">메뉴 이름을 클릭하여 가격을 확인하세요.</font>

<table border="1">
	<thead>
		<tr>
			<th>메뉴</th>
		</tr>
	</thead>
	
	<c:forEach items="${requestScope.menuAll}" var="data">
		 <tr>
		 	<td><a href="${url}pizza?command=menu&name=${data.name}">${data.name}</a></td>
		 </tr>
	 </c:forEach>

</table>

</body>
</html>
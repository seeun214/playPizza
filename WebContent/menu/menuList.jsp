<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<h1>Menu</h1>

	<br>
	<form action="pizza?command=menu" method="post">

		메뉴 이름 : <input type="text" name="name"><input type="submit"
			value="검색">
	</form>
	<br><br>
	<font color="black">메뉴 이름을 클릭하여 가격을 확인하세요.</font>
	<br><br>

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

	<br>
	<hr>
	<a href="${pageContext.request.contextPath}">메인으로 돌아가기</a>
	<br>


</body>
</html>
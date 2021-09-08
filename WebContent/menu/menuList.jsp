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
<jsp:include page="../common/styleLink.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../common/navbar.jsp"></jsp:include>
<header class="w3-container" style="padding:128px 16px; margin: 0 400px">
	<h1>Menu</h1>

	<br>
	<h5>메뉴 검색</h5>
	<form action="pizza?command=menu" method="post">
		<input class="w3-input" type="text" id="name" name="name" placeholder="메뉴명을 입력해주세요." style="width: 75%; display: inline; margin: 20px 0">
		<input class="w3-input w3-red" type="submit" value="검색" style="width: 20%; display: inline;">
	</form>
	<br>
	<h5>메뉴별 정보</h5>

	<table class="w3-table">
		<thead>
			<tr class="w3-red">
				<th style="text-align: center;">메뉴 리스트 Click</th>
			</tr>
		</thead>

		<c:forEach items="${requestScope.menuAll}" var="data">
			<tr>
				<td onclick="location.href='${url}pizza?command=menu&name=${data.name}'" style="border-bottom: 1px solid #ddd; cursor: pointer;">${data.name}</td>
			</tr>
		</c:forEach>
	</table>
</header>
<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>
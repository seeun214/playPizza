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
	<font color="black">주문 하기</font>
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
	
	<form action="/action_page.php">
  <label for="pizza">메뉴를 선택하세요:</label>
  <select name="pizza" id="pizza">
    <option value="pepperoni">페퍼로니 피자</option>
    <option value="cheese">치즈 피자</option>
    <option value="vege">야채 피자</option>
    <option value="berry">베리 피자</option>
    <option value="chicago">시카고 피자</option>
    <option value="tomato">토마토 파스타</option>
    <option value="cola">콜라</option>
    <option value="cider">사이다</option>
    <option value="beer">맥주</option>
    </select>
    <br><br>
  <label for="branch">지점을 선택하세요:</label>
  <select name="branch" id="branch">
    <option value="namsan">남산점</option>
    <option value="itaewon">이태원점</option>
    <option value="sangbong">상봉점</option>
  </select>
  <br><br>
  <input type="submit" value="Submit">
</form>

	<br>
	<hr>
	<a href="${pageContext.request.contextPath}">메인으로 돌아가기</a>
	<br>


</body>
</html>
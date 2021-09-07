<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<% String url = application.getContextPath() + "/"; %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>모든 지점 list 화면</title>
</head>
<body>
<br><br><br>
<center>
<h3>모든 지점 list</h3>
<hr><p>

<table border="1">
	<thead>
		<tr>
			<th>지점 id</th><th>지점명</th><th>주소</th><th>전화번호</th>
		</tr>
	</thead>
	
	<c:forEach items="${requestScope.branchesAll}" var="data">
		 <tr>
		 	<td><a href="${url}probono?command=branch&branchname=${data.branchId}">${data.branchId}</a></td>
		 	<td>${data.name}</td>
		 	<td>${data.address}</td>
		 	<td>${data.phone}</td>
		 </tr>
	 </c:forEach>





</table>

<br><br><br>
&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/index.html">메인 화면 이동</a>

</center>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<% 	
	String url = application.getContextPath() + "/";
%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>지점 상세 정보 화면</title>
</head>
<body>
<br><br><br>
<center>

${requestScope.successMsg}

<h3>지점</h3>
<hr><p> 
 
<table border="1">
	<tr>
		<th>지점 id</th><th>지점명</th><th>주소</th><th>전화번호</th>
	</tr>
 	<tr>
 		<td>${requestScope.branch.branchId}</td>
 		<td>${requestScope.branch.name}</td>
 		<td>${requestScope.branch.address}</td>
 		<td>${requestScope.branch.phone}</td>
 	</tr>
</table>


</center>
</body>
</html>








<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>주문 내역</title>
</head>
<body>

<h3>주문 완료</h3>

<% 
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String menu = request.getParameter("menu");
	String branch = request.getParameter("branch");
	
	if (id != null && id.equals(id)) {
		session.setAttribute("id", id);
	}
	
%>
	
	

</body>
</html>
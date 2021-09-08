<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>로그인 성공</title>
</head>
<body>

<% 
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	if (id != null && id.equals(pwd)) {
		session.setAttribute("id", id);
	}
	
	response.sendRedirect("orderInfo.jsp");
%>

</body>
</html>
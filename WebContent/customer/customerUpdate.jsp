<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>

	<%
		if(session.getAttribute("id") == null) {
			out.println("<a href='login.html'>로그인</a>");
		} else {
			String id = (String) session.getAttribute("id");
			out.println(id + "님 반갑습니다.<br>");
			out.println("<a href='logout.jsp'>로그아웃</a>");
		}
	%>
</body>
</html>
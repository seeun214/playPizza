<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>주문 내역</title>
</head>
<body>

<h3><%= session.getAttribute("id") %>님의 주문이 완료되었습니다~ &#128523;</h3>
        <ul>
            <li>주문자: <%= session.getAttribute("id") %></li>
            <li>메뉴: <%= request.getParameter("menu") %></li>
            <li>지점명: <%= request.getParameter("branch") %></li>
        </ul>
        
        

<br><hr>

	<button onclick="location.href='pizza?command=orderDelete">주문 취소!</button>
	
	

</body>
</html>
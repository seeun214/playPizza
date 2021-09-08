<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>주문 내역</title>
</head>
<body>

<h3>${requestScope.customer.SId}님의 주문이 완료되었습니다~ &#128523;</h3>

<% 
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String menu = request.getParameter("menu");
	String branch = request.getParameter("branch");
	
	if (id != null && id.equals(id)) {
		session.setAttribute("id", id);
	}
	
%>

	<button onclick="location.href='pizza?command=orderDelete&orderId=${requestScope.orders.orderId}'">주문 취소!</button>
	
	

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Detail</title>
</head>
<body>
--------------------- <br>
시퀀스 : ${requestScope.customer.customerId} <br>
ID : ${requestScope.customer.SId} <br>
주소 : ${requestScope.customer.address} <br>
전화번호 : ${requestScope.customer.phone} <br>
---------------------
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${empty sessionScope.id}">
	<a href="${pageContext.request.contextPath}/customer/signIn.html">회원가입</a>
	&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/customer/logIn.html">로그인</a> <br><br>
</c:if>
<c:if test="${not empty sessionScope.id}">
	${sessionScope.id}의 <a href="${pageContext.request.contextPath}/customer/customerUpdate.jsp">My Page</a>
	&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/customer/logout.jsp">로그아웃</a> <br><br>
</c:if>
	

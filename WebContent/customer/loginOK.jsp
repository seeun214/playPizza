<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	if (id != null && id.equals(pwd)) {
		session.setAttribute("id", id);
	}
	
	response.sendRedirect("customerUpdate.jsp");
%>
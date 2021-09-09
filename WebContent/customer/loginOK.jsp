<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.CustomersDAO, model.dto.CustomersDTO ,model.entity.Customers" %>

<% 
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	CustomersDTO customer = CustomersDAO.getInstance().getCustomer(id);
	
	if (customer == null) {
		response.sendRedirect("loginRetry.jsp");
	} else {
		if(pwd.equals(customer.getPassword())) {
			session.setAttribute("id", id);
			response.sendRedirect("../index.jsp");
		} else {
			response.sendRedirect("loginRetry.jsp");
		}
	}
	
%>
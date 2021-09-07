package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Service;
import model.dto.CustomersDTO;

@WebServlet("/pizza")
public class Controller extends HttpServlet {
	
	private static Service service = Service.getInstance();

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String command = request.getParameter("command");
		
		try{
			if(command.equals("customer")){
				customer(request, response);
			} 
		}catch(Exception s){
//			request.setAttribute("errorMsg", s.getMessage());
//			request.getRequestDispatcher("showError.jsp").forward(request, response);
			s.printStackTrace();
		} 
	}

	private void customer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		CustomersDTO c = service.getCustomer(request.getParameter("sId"));
		System.out.println(c);
		if(c != null) {
			request.setAttribute("customer", c);
			url = "customer/customerDetail.jsp";
		} else {
			request.setAttribute("errorMsg", "존재하지 않는 고객 정보입니다.");
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}

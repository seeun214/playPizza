package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Service;
import model.dto.BranchesDTO;
import model.dto.CustomersDTO;
import model.dto.MenuDTO;
import model.dto.OrdersDTO;
import model.entity.Orders;

@WebServlet("/pizza")
public class Controller extends HttpServlet {

	private static Service service = Service.getInstance();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String command = request.getParameter("command");

		try {
			if (command.equals("branchesAll")) {// 모든 지점 검색
				branchesAll(request, response);
			} else if (command.equals("branch")) {// 특정 지점 검색
				branch(request, response);
			} else if (command.equals("menuAll")) {// 모든 Menu 검색
				menuAll(request, response);
			} else if (command.equals("menu")) {// Menu 이름으로 검색
				menu(request, response);
			} else if (command.equals("customer")) {
				customer(request, response);
			} else if (command.equals("ordersAll")) {
				ordersAll(request, response);
			} else if (command.equals("customerInsert")) {
				customerInsert(request, response);
			}else if(command.equals("customerUpdateReq")){
				customerUpdateReq(request, response);
			}else if(command.equals("customerUpdate")){
				customerUpdate(request, response);
			}else if(command.equals("customerDelete")){
				customerDelete(request, response);
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			request.getRequestDispatcher("showError.jsp").forward(request, response);
			s.printStackTrace();
		}

	}

	private void customerInsert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = null;

		String sId = request.getParameter("sId");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");

		if (sId != null && sId.length() != 0 && address != null) {

			CustomersDTO customer = new CustomersDTO(sId, address, phone);
			try {
				boolean result = service.addCustomer(customer);
				if (result) {
					request.setAttribute("customer", customer);
					request.setAttribute("successMsg", "가입 완료");
					url = "/index.jsp";
				} else {
					request.setAttribute("errorMsg", "다시 시도하세요");
				}
			} catch (Exception s) {
				request.setAttribute("errorMsg", s.getMessage());
			}
			request.getRequestDispatcher(url).forward(request, response);
		}
	}

	private void customer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = null;

		try {
			CustomersDTO c = service.getCustomer(request.getParameter("sId"));
			System.out.println(c);
			if (c != null) {
				request.setAttribute("customer", c);
				url = "customer/customerDetail.jsp";
			} else {
				request.setAttribute("errorMsg", "존재하지 않는 고객 정보입니다.");
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public void customerUpdateReq(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("customer", service.getCustomer(request.getParameter("sId")));
			url = "customer/customerUpdate.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void customerUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			boolean result = service.updateCustomer(request.getParameter("sId"), request.getParameter("address"), request.getParameter("phone"));
			if(result) {
				request.setAttribute("customer", service.getCustomer(request.getParameter("sId")));
				url = "customer/customerDetail.jsp";
			}else {
				request.setAttribute("errorMsg", "수정 실패");
			}
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	
	}
	
	public void customerDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			boolean result = service.deleteCustomer(request.getParameter("sId"));
			if(result) {
//				url = "/index.jsp";
				url = "customer/logout.jsp";
			}else {
				request.setAttribute("errorMsg", "삭제 실패");
			}
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 특정 지점 검색
	public void branch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			BranchesDTO b = service.getBranch(request.getParameter("name"));
			if (b != null) {
				request.setAttribute("branch", b);
				url = "branch/branchDetail.jsp";
			} else {
				request.setAttribute("errorMsg", "존재하지 않는 지점입니다.");
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 모든 지점 검색 - 검색된 데이터 출력 화면[branchList.jsp]
	public void branchesAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("branchesAll", service.getAllBranches());
			url = "branch/branchList.jsp";
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 모든 Menu 검색
	public void menuAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("menuAll", service.getAllMenu());
			url = "menu/menuList.jsp";
		} catch (Exception e) {
			request.setAttribute("errorMsg", e.getMessage());
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// Menu 이름으로 검색
	public void menu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			MenuDTO menu = service.getOneMenu(request.getParameter("name"));
			if (menu != null) {
				request.setAttribute("menu", menu);
				url = "menu/menuDetail.jsp";
			} else {
				request.setAttribute("errorMsg", "존재하지 않는 메뉴.");
			}
		} catch (Exception e) {
			request.setAttribute("errorMsg", e.getMessage());
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}


	// 고객 번호로 주문 정보 검색
	public void ordersAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			List<OrdersDTO> orders = service.getAllOrder(Integer.parseInt(request.getParameter("customerId")));
			request.setAttribute("orders", orders);
			url = "orders/ordersList.jsp";
		} catch (Exception e) {
			request.setAttribute("errorMsg", e.getMessage());
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
package controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
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
import model.entity.Branches;
import model.entity.Customers;
import model.entity.Menu;
import model.util.DBUtil;

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
			} else if (command.equals("customerInsert")) {
				customerInsert(request, response);
			} else if (command.equals("customer")) {
				customer(request, response);
			} else if (command.equals("customerUpdateReq")) {
				customerUpdateReq(request, response);
			} else if (command.equals("customerUpdate")) {
				customerUpdate(request, response);
			} else if (command.equals("customerDelete")) {
				customerDelete(request, response);
			} else if (command.equals("ordersAll")) {
				ordersAll(request, response);
			} else if (command.equals("orderDelete")) {
				orderDelete(request, response);
			} else if (command.equals("ordersInsert")) {// 주문 정보 추가
				ordersInsert(request, response);
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			request.getRequestDispatcher("showError.jsp").forward(request, response);
			s.printStackTrace();
		}

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

	private void customerInsert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = null;

		String sId = request.getParameter("sId");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");

		if (sId != null && sId.length() != 0 && password != null && address != null && phone != null) {

			CustomersDTO customer = new CustomersDTO(sId, password, address, phone);
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
				url = "customer/mypage.jsp";
			} else {
				request.setAttribute("errorMsg", "존재하지 않는 고객 정보입니다.");
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void customerUpdateReq(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("customer", service.getCustomer(request.getParameter("sId")));
			url = "customer/customerUpdate.jsp";
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void customerUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			boolean result = service.updateCustomer(request.getParameter("sId"), request.getParameter("password"), request.getParameter("address"), request.getParameter("phone"));
			if (result) {
				request.setAttribute("customer", service.getCustomer(request.getParameter("sId")));
				url = "customer/mypage.jsp";
			} else {
				request.setAttribute("errorMsg", "수정 실패");
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);

	}

	public void customerDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			boolean result = service.deleteCustomer(request.getParameter("sId"));
			if (result) {
				url = "customer/logout.jsp";
			} else {
				request.setAttribute("errorMsg", "삭제 실패");
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void orderDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			boolean result = service.deleteOrder(Integer.parseInt(request.getParameter("orderId")));
			if (result) {
//				url = "orders/ordersList";
			} else {
				request.setAttribute("errorMsg", "삭제 실패");
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 고객 번호로 주문 정보 검색
	public void ordersAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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

	// 주문 정보 추가
	protected void ordersInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		OrdersDTO newOrder = new OrdersDTO();
		Customers customer = null;
		Menu menu = null;
		Branches branch = null;
		
		System.out.println("1");
		String url = "showError.jsp";

		String id = (String) request.getSession().getAttribute("id");
		System.out.println("id" + id);
		String mName = request.getParameter("menu");
		System.out.println("mName" + mName);
		String bName = request.getParameter("branch");
		System.out.println("bName" + bName);

		customer = (Customers) em.createNamedQuery("Customer.findBySId").setParameter("sId", id)
				.getSingleResult();
		menu = (Menu) em.createNamedQuery("Menu.findByMenuName").setParameter("name", mName).getSingleResult();
		branch = (Branches) em.createNamedQuery("Branch.findByName").setParameter("name", bName).getSingleResult();
		

		newOrder.setCustomerId(customer);
		newOrder.setMenuId(menu);
		newOrder.setBranchId(branch);

		// 해킹등으로 불합리하게 요청도 될수 있다는 가정하에 모든 데이터가 제대로 전송이 되었는지를 검증하는 로직
		if (id != null && id.length() != 0 && mName != null && bName != null) {

			try {
				tx.begin();
				url = "orders/order.jsp";
				request.getParameter("orderInsert");
				boolean orders = service.addOrders(newOrder);
				System.out.println("6");
				
				System.out.println("7");
				if (newOrder != null) {
					request.setAttribute("orderInsert", newOrder);
					request.setAttribute("successMsg", "추가 완료");
					tx.commit();
					System.out.println("8");
				} else {
					request.setAttribute("errorMsg", "다시 시도하세요");
				}
			} catch (Exception s) {
				request.setAttribute("errorMsg", s.getMessage());
			}
			request.getRequestDispatcher(url).forward(request, response);
		}
	}
}
package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Service;
import model.dto.CustomersDTO;

import model.dto.BranchesDTO;

import model.dto.MenuDTO;


@WebServlet("/pizza")
public class Controller extends HttpServlet {
	
	private static Service service = Service.getInstance();

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String command = request.getParameter("command");
	
		try{
			if(command.equals("branchesAll")){//모든 지점 검색
				branchesAll(request, response);
			}else if(command.equals("branch")){//특정 지점 검색
				branch(request, response);
      }else if(command.equals("allMenu")) {//모든 Menu 검색
				allMenu(request, response);
			}else if(command.equals("oneMenu")) {//Menu 이름으로 검색
				oneMenu(request, response);
			}else if(command.equals("customer")){
				customer(request, response);
			}
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			request.getRequestDispatcher("showError.jsp").forward(request, response);
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

	//특정 지점 검색
	public void branch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			BranchesDTO b = service.getBranch(request.getParameter("name"));
			if(b != null) {
				request.setAttribute("branch", b);
				url = "branch/branchDetail.jsp";
			}else {
				request.setAttribute("errorMsg", "존재하지 않는 지점입니다.");
			}
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	//모든 지점 검색 - 검색된 데이터 출력 화면[branchList.jsp]
	public void branchesAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("branchesAll", service.getAllBranches());
			url = "branch/branchList.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
  }
	

	//모든 Menu 검색
		public void allMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String url = "showError.jsp";
			try {
				request.setAttribute("allMenu", service.getAllMenu());
				url = "menuList.jsp";
			}catch(Exception e){
				request.setAttribute("errorMsg", e.getMessage());
				e.printStackTrace();
			}
			request.getRequestDispatcher(url).forward(request, response);
		}
	
		//Menu 이름으로 검색
		public void oneMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String url = "showError.jsp";
			try {
				MenuDTO menu = service.getOneMenu(request.getParameter("name"));
				if(menu != null) {
					request.setAttribute("menu", menu);
					url = "menu/menuDetail.jsp";
				}else {
					request.setAttribute("errorMsg", "존재하지 않는 메뉴.");
				}
			}catch(Exception e){
				request.setAttribute("errorMsg", e.getMessage());
				e.printStackTrace();
			}
			request.getRequestDispatcher(url).forward(request, response);
    }
	

}

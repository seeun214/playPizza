package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Service;
import model.dto.MenuDTO;

@WebServlet("/pizza")
public class Controller extends HttpServlet {
	
	private static Service service = Service.getInstance();

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String command = request.getParameter("command");
		
		try {
			if(command.equals("allMenu")) {//모든 Menu 검색
				allMenu(request, response);
			}else if(command.equals("oneMenu")) {//Menu 이름으로 검색
				oneMenu(request, response);
			}
		}catch(Exception e){
			request.setAttribute("errorMsg", e.getMessage());
			request.getRequestDispatcher("showError.jsp").forward(request, response);
			e.printStackTrace();
		}
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

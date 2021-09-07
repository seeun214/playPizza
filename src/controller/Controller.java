package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Service;
import model.dto.BranchesDTO;

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
			}
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			request.getRequestDispatcher("showError.jsp").forward(request, response);
			s.printStackTrace();
		}
		
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
	

	

}

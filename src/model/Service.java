package model;

import java.sql.SQLException;
import java.util.ArrayList;

import exception.NotExistException;
import model.dto.BranchesDTO;
import model.dto.CustomersDTO;
import model.dto.MenuDTO;
import model.dto.OrdersDTO;
import probono.exception.MessageException;

public class Service {
	private static Service instance = new Service();

	private Service() {
	}

	public static Service getInstance() {
		return instance;
	}

	private static CustomersDAO customerDAO = CustomersDAO.getInstance();
	private static MenuDAO menuDAO = MenuDAO.getInstance();
	private static BranchesDAO branchesDAO = BranchesDAO.getInstance();
	private static OrdersDAO ordersDAO = OrdersDAO.getInstance();

	// 고객 ID로 검색
	public CustomersDTO getCustomer(String sId) {
		return customerDAO.getCustomer(sId);
	}
	
	//특정 지점 검색
	// 회원가입
	public static void notExistActivist(String customerId) throws NotExistException, SQLException{
		CustomersDTO customer = customerDAO.getCustomer(customerId);
		if(customer == null){
			throw new NotExistException("검색하는 회원이 미존재합니다.");
		}
	}
	public boolean addCustomer(CustomersDTO customer) throws NotExistException, MessageException {
		return customerDAO.addCustomer(customer);
	}

	// 특정 지점 검색
	public static BranchesDTO getBranch(String name) throws SQLException, NotExistException {
		BranchesDTO branch = branchesDAO.getBranch(name);
		if (branch == null) {
			throw new NotExistException("검색하신 지점이  미 존재합니다.");
		}
		return branch;
	}
	

	// 모든 지점 검색
	public ArrayList<BranchesDTO> getAllBranches() throws SQLException, NotExistException {
		ArrayList<BranchesDTO> branchesAll = branchesDAO.getAllBranches();
		if (branchesAll == null) {
			throw new NotExistException("검색하신 지점이  미 존재합니다.");
		}
		return branchesAll;
	}

	public static void notExistMenu(String name) throws NotExistException, SQLException {
		MenuDTO menu = menuDAO.getOneMenu(name);
		if (menu == null) {
			throw new NotExistException("찾으신 메뉴가 없습니다.");
		}
	}

	// Menu 이름으로 검색
	public MenuDTO getOneMenu(String name) throws SQLException, NotExistException {
		MenuDTO menu = menuDAO.getOneMenu(name);
		if (menu == null) {
			throw new NotExistException();
		}
		return menu;
	}

	// 모든 Menu 검색
	public ArrayList<MenuDTO> getAllMenu() throws SQLException, NotExistException {
		ArrayList<MenuDTO> menuList = menuDAO.getAllMenu();
		if (menuList == null || menuList.size() == 0) {
			throw new NotExistException();
		}
		return menuList;

	}
	
	//주문 번호로 주문 정보 검색 반환
		public OrdersDTO getOneOrder(int orderId) throws SQLException, NotExistException {
			OrdersDTO order = ordersDAO.getOneOrder(orderId);
			if(order == null){
				throw new NotExistException();
			}
			return order;
		}
}

package model;

import java.sql.SQLException;
import java.util.ArrayList;

import exception.NotExistException;
import model.dto.MenuDTO;

public class Service {
	private static Service instance = new Service();
	
	private Service() {}
	
	public static Service getInstance() {
		return instance;
	}
	
	private static CustomersDAO customerDAO = CustomersDAO.getInstance();
	private static MenuDAO menuDAO = MenuDAO.getInstance();
	private static BranchesDAO branchesDAO = BranchesDAO.getInstance();
	private static OrdersDAO ordersDAO = OrdersDAO.getInstance();
	
	//Menu
	public static void notExistMenu(String name) throws NotExistException, SQLException {
		MenuDTO menu = menuDAO.getOneMenu(name);
		if(menu == null){
			throw new NotExistException("찾으신 메뉴가 없습니다.");
		}
	}
	
	//Menu 이름으로 검색
	public MenuDTO getOneMenu(String name) throws SQLException, NotExistException {
		MenuDTO menu = menuDAO.getOneMenu(name);
		if(menu == null){
			throw new NotExistException();
		}
		return menu;
	}
	
	//모든 Menu 검색
	public ArrayList<MenuDTO> getAllMenu() throws SQLException, NotExistException {
		ArrayList<MenuDTO> menuList = menuDAO.getAllMenu();
		if(menuList == null || menuList.size() == 0){
			throw new NotExistException();
		}
		return menuList;
	}
}

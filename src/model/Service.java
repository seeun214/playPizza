package model;

import model.dto.CustomersDTO;

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

	public CustomersDTO getCustomer(String sId) {
		return customerDAO.getCustomer(sId);
	}
}

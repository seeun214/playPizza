package model;

public class CustomersDAO {
	
	private static CustomersDAO instance = new CustomersDAO();
	
	private CustomersDAO() {}
	
	public static CustomersDAO getInstance() {
		return instance;
	}
}

package model;

public class OrdersDAO {
	
	private static OrdersDAO instance = new OrdersDAO();

	private OrdersDAO() {}

	public static OrdersDAO getInstance() {
		return instance;
	}
}

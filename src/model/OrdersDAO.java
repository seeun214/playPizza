package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import model.dto.BranchesDTO;
import model.dto.CustomersDTO;
import model.dto.MenuDTO;
import model.dto.OrdersDTO;
import model.entity.Customers;
import model.entity.Menu;
import model.entity.Orders;
import model.util.DBUtil;

public class OrdersDAO {
	
	private static OrdersDAO instance = new OrdersDAO();

	private OrdersDAO() {}

	public static OrdersDAO getInstance() {
		return instance;
	}
	
	//주문 번호로 주문 정보 검색
	public OrdersDTO getOneOrder(int orderId) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		em.getTransaction().begin();
		System.out.println("-----------");
		OrdersDTO orders = new OrdersDTO();
		Orders o = new Orders();
		
		try {
			
			o = (Orders)em.createNamedQuery("Order.findByOrderId", Orders.class).setParameter("orderId", orderId).getSingleResult();
			
			orders = new OrdersDTO(o.getOrderId(), o.getCustomerId(), o.getMenuId(), o.getBranchId());
			System.out.println("orders---------"+orders);
			
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return orders;
	}
	
//	//고객 아이디로 주문 정보 검색
//	public OrdersDTO getOneOrder(String sId) throws SQLException {
//		EntityManager em = DBUtil.getEntityManager();
//		em.getTransaction().begin();
//		OrdersDTO order = null;
//		CustomersDTO customer = null;
//		System.out.println(customer.getSId());
//		
//		try {
//			Customers c = em.createNamedQuery("Customer.findBySId", Customers.class).setParameter("sId", sId).getSingleResult();
//			Orders o = em.createNamedQuery("Order.findByCustomerId", Orders.class).setParameter("customerId", c).getSingleResult();
//			order = new OrdersDTO(o.getOrderId(), o.getCustomerId(), o.getMenuId(), o.getBranchId());
//		} catch(Exception e) {
//			em.getTransaction().rollback();
//		} finally {
//			em.close();
//			em = null;
//		}
//		return order;
//	}
}
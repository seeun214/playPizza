package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import model.dto.BranchesDTO;
import model.dto.CustomersDTO;
import model.dto.MenuDTO;
import model.dto.OrdersDTO;
import model.entity.Menu;
import model.entity.Orders;
import model.util.DBUtil;

public class OrdersDAO {
	
	private static OrdersDAO instance = new OrdersDAO();

	private OrdersDAO() {}

	public static OrdersDAO getInstance() {
		return instance;
	}
	
	public OrdersDTO getOneOrder(int orderId) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		em.getTransaction().begin();
		OrdersDTO orders = null;

		try {
			
			System.out.println(3 + " " + orderId);
			
			Orders o = em.createNamedQuery("Order.findByOrderId", Orders.class).setParameter("orderId", orderId).getSingleResult();
			
			System.out.println(o);
			
			
			orders = new OrdersDTO();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return orders;
	}
	
//	@SuppressWarnings("unchecked")
//	public ArrayList<OrdersDTO> getAllOrder() throws SQLException {
//		EntityManager em = DBUtil.getEntityManager();
//		List<Orders> list = null;
//		ArrayList<OrdersDTO> arr = new ArrayList<OrdersDTO>();
//		try {
//			list = em.createNativeQuery("SELECT * FROM Orders", Orders.class).getResultList();
//			for(Orders o : list) {
//				arr.add(new OrdersDTO(o.getOrderId(), o.getCustomerId(), o.getMenuId(), o.getBranchId()));
//			}
//		} catch (Exception e) {
//			em.getTransaction().rollback();
//		} finally {
//			em.close();
//		}
//		return arr;
//	}
}

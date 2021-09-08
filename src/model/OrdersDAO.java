package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import javax.persistence.EntityManager;
import javax.servlet.jsp.tagext.IterationTag;

import model.dto.OrdersDTO;
import model.entity.Branches;
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

	//고객 번호로 주문 정보 검색
	public List<OrdersDTO> getAllOrder(int customerId) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		em.getTransaction().begin();
		List<Orders> list = null;
		List<OrdersDTO> orders = new ArrayList<OrdersDTO>();
		
		try {
			list = em.createNamedQuery("Order.findByCustomerId2", Orders.class).setParameter("customerId", customerId).getResultList();
			for(Orders o : list) {
				orders.add(new OrdersDTO(o.getOrderId(), o.getCustomerId(), o.getMenuId(), o.getBranchId()));
			}
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
			em = null;
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
	

	public boolean addOrders(OrdersDTO order) throws SQLException{
		EntityManager em = DBUtil.getEntityManager();
		em.getTransaction().begin();
		boolean result = false;
		
		try {
			em.persist(order.toEntity());
			em.getTransaction().commit();

			result = true;

		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return result;
	} 

}
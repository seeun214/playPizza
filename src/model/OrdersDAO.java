package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.jsp.tagext.IterationTag;

import model.dto.BranchesDTO;
import model.dto.CustomersDTO;
import model.dto.MenuDTO;
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
			list = em.createNamedQuery("Order.findByCustomerId", Orders.class).setParameter("customerId", customerId).getResultList();
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

}
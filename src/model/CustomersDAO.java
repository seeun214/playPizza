package model;

import javax.persistence.EntityManager;

import model.dto.CustomersDTO;
import model.entity.Customers;
import model.util.DBUtil;

public class CustomersDAO {
	
	private static CustomersDAO instance = new CustomersDAO();
	
	private CustomersDAO() {}
	
	public static CustomersDAO getInstance() {
		return instance;
	}
	
	public CustomersDTO getCustomer(String sId) {
		EntityManager em = DBUtil.getEntityManager();
		em.getTransaction().begin();
		CustomersDTO customer = null;
		
		Customers c = em.createNamedQuery("Customer.findBySId", Customers.class).setParameter("sId", sId).getSingleResult();
		customer = new CustomersDTO(c.getCustomerId(), c.getSId(), c.getAddress(), c.getPhone());
		
		System.out.println(customer.getSId());
		return customer;
	}
}

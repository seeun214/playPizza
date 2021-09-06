package model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@SequenceGenerator(name = "ORDERS_SEQ_GENERATOR",
sequenceName = "ORDERS_SEQ", 
initialValue = 1,
allocationSize = 1)
public class Orders {
	@Id
	@Column(name="order_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDERS_SEQ_GENERATOR")
	private int orderId;
	
	@ManyToOne(targetEntity = Customers.class)
	@JoinColumn(name="customer_Id")
	private Customers customerId;
	
	@ManyToOne(targetEntity = Menu.class)
	@JoinColumn(name="menu_Id")
	private Menu menuId;
	
	@ManyToOne(targetEntity = Branches.class)
	@JoinColumn(name="branch_Id")
	private Branches branchId;

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", customerId=" + customerId + ", menuId=" + menuId + ", branchId="
				+ branchId + "]";
	}
	
}

package model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@SequenceGenerator(name = "CUSTOMER_SEQ_GENERATOR",
		sequenceName = "CUSTOMER_SEQ", 
		initialValue = 1,
		allocationSize = 1)
public class Customers {
	@Id
	@Column(name="customer_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMER_SEQ_GENERATOR")
	private int customerId;
	private String sId;
	private String address;
	private String phone;
	
	@OneToMany(mappedBy = "customerId")
	private List<Orders> pizzaOrders;

	@Override
	public String toString() {
		return "Customers [customerId=" + customerId + ", sId=" + sId + ", address=" + address + ", phone=" + phone
				+ "]";
	}
	
	
}

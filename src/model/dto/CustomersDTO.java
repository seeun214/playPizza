package model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.entity.Customers;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CustomersDTO {
	private int customerId;
	private String sId;
	private String address;
	private String phone;
	
	public CustomersDTO(String sId, String address, String phone) {
		super();
		this.sId = sId;
		this.address = address;
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "Customers [customerId=" + customerId + ", sId=" + sId + ", address=" + address + ", phone=" + phone
				+ "]";
	}

	public Customers toEntity() {
		return Customers.builder().customerId(customerId).sId(sId).address(address).phone(phone).build();
	}

}

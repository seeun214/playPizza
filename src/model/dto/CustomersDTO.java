package model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomersDTO {
	private int customerId;
	private String sId;
	private String address;
	private String phone;
	
	@Override
	public String toString() {
		return "Customers [customerId=" + customerId + ", sId=" + sId + ", address=" + address + ", phone=" + phone
				+ "]";
	}
}

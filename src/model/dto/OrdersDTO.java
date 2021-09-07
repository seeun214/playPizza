package model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.entity.Branches;
import model.entity.Customers;
import model.entity.Menu;
import model.entity.Orders;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class OrdersDTO {
	private int orderId;
	private Customers customerId;
	private Menu menuId;
	private Branches branchId;

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("주문번호 : ");
		sb.append(orderId);
		sb.append("고객아이디 : ");
		sb.append(customerId.getSId());
		sb.append("메뉴 : ");
		sb.append(menuId);
		sb.append("지점명 : ");
		sb.append(branchId.getName());
		return sb.toString();
	}
	
	public Orders toEntity() {
		return Orders.builder().orderId(orderId).customerId(customerId).menuId(menuId).branchId(branchId).build();
	}

}

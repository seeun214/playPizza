package model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BranchesDTO {
	
	private int branchId;
	private String name;
	private String address;
	private String phone;
	

	@Override
	public String toString() {
		return "지점id : " + branchId + ", 지점명 : " + name + ", 주소 : " + address + ", 전화번호 : " + phone;
	}

}

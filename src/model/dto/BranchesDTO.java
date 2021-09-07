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
		return "Branches [branchId=" + branchId + ", name=" + name + ", address=" + address + ", phone=" + phone + "]";
	}

}

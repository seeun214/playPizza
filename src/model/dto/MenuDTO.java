package model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.entity.Menu;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class MenuDTO {
	
	private int menuId;
	private String name;
	private int price;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("메뉴 : ");
		builder.append(name);
		builder.append("가격 : ");
		builder.append(price);
		return builder.toString();
	}
	
	public Menu toEntity() {
		return Menu.builder().menuId(menuId).name(name).price(price).build();
	}

}

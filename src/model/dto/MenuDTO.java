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
	private String imgname;
	
	@Override
	public String toString() {
		return "메뉴 : " + name + ", 가격 : " + price;
	}
	
	public Menu toEntity() {
		return Menu.builder().menuId(menuId).name(name).price(price).imgname(imgname).build();
	}

}

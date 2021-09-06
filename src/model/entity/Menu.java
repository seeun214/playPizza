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
@SequenceGenerator(name = "MENU_SEQ_GENERATOR",
			sequenceName = "MENU_SEQ", 
			initialValue = 1,
			allocationSize = 1)
public class Menu {
	@Id
	@Column(name="menu_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MENU_SEQ_GENERATOR")
	private int menuId;
	private String name;
	private int price;
	
	@OneToMany(mappedBy = "menuId")
	private List<Orders> pizzaOrders;

	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", name=" + name + ", price=" + price + "]";
	}
		
}

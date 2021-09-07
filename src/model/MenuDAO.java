package model;

public class MenuDAO {

	private static MenuDAO instance = new MenuDAO();

	private MenuDAO() {}

	public static MenuDAO getInstance() {
		return instance;
	}
}

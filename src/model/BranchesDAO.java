package model;

public class BranchesDAO {
	
	private static BranchesDAO instance = new BranchesDAO();
	
	private BranchesDAO() {}
	
	public static BranchesDAO getInstance() {
		return instance;
	}

}

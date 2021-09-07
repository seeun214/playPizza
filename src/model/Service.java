package model;

import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.BranchesDTO;
import probono.exception.NotExistException;


public class Service {
	private static Service instance = new Service();
	
	private Service() {}
	
	public static Service getInstance() {
		return instance;
	}
	
	private static CustomersDAO customerDAO = CustomersDAO.getInstance();
	private static MenuDAO menuDAO = MenuDAO.getInstance();
	private static BranchesDAO branchesDAO = BranchesDAO.getInstance();
	private static OrdersDAO ordersDAO = OrdersDAO.getInstance();
	
	//특정 지점 검색
	public static BranchesDTO getBranch(String name) throws SQLException, NotExistException{
		BranchesDTO branch = branchesDAO.getBranch(name);
		if(branch == null){
			throw new NotExistException("검색하신 지점이  미 존재합니다.");
		}
		return branch;
	}
	
	//모든 지점 검색
	public ArrayList<BranchesDTO> getAllBranches() throws SQLException,NotExistException{
		ArrayList<BranchesDTO> branchesAll = branchesDAO.getAllBranches();
		if(branchesAll == null){
			throw new NotExistException("검색하신 지점이  미 존재합니다.");
		}
		return branchesAll;
	}
}


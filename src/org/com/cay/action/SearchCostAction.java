package org.com.cay.action;

import java.util.List;

import org.com.cay.dao.CostDAO;
import org.com.cay.dao.DAOFactory;
import org.com.cay.entity.Cost;

public class SearchCostAction implements BaseAction {

	private String name;
	private Integer baseDuration;
	private String status;
	
	private List<Cost> costList;
	
	public List<Cost> getCostList() {
		return costList;
	}

	public void setCostList(List<Cost> costList) {
		this.costList = costList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBaseDuration() {
		return baseDuration;
	}

	public void setBaseDuration(Integer baseDuration) {
		this.baseDuration = baseDuration;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
//		System.out.println(name);
//		System.out.println(baseDuration);
//		System.out.println(status);
		CostDAO costDAO = DAOFactory.getCostDAO();
		costList = costDAO.findCostByConditions(name, baseDuration, status);
		return "success";
	}

}

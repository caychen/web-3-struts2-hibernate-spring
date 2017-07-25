package org.com.cay.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.com.cay.dao.CostDAO;
import org.com.cay.dao.DAOException;
import org.com.cay.entity.Cost;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Controller
@Scope("prototype")
public class ListCostAction {
	private int perPages = 5;
	
	//Input
	private int page = 1;
	
	private Map<String ,String> statusOptions;
	
	public Map<String, String> getStatusOptions() {
		return statusOptions;
	}

	public void setStatusOptions(Map<String, String> statusOptions) {
		this.statusOptions = statusOptions;
	}

	//Output
	private int totalPages; 
	
	private List<Cost> costList;
	
	@Resource
	private CostDAO costDAO;
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public List<Cost> getCostList() {
		return costList;
	}

	public void setCostList(List<Cost> costList) {
		this.costList = costList;
	}
	
	@Transactional(readOnly=true,propagation=Propagation.REQUIRED)
	public String execute() throws DAOException{
		costList = costDAO.findAll(page, perPages);
		totalPages = costDAO.getTotalPages(perPages);
		
		statusOptions = costDAO.getCostStatusOptions();
		return "success";
	}

}

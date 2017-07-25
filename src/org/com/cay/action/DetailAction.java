package org.com.cay.action;

import java.util.Map;

import javax.annotation.Resource;

import org.com.cay.dao.CostDAO;
import org.com.cay.entity.Cost;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Controller
@Scope("prototype")
@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
public class DetailAction implements BaseAction{

	private Integer id;
	private Map<String, String> statusOptions;
	private Cost cost;
	private Integer page;
	
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	@Resource
	private CostDAO costDAO;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cost getCost() {
		return cost;
	}

	public void setCost(Cost cost) {
		this.cost = cost;
	}
	
	public Map<String, String> getStatusOptions() {
		return statusOptions;
	}

	public void setStatusOptions(Map<String, String> statusOptions) {
		this.statusOptions = statusOptions;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		statusOptions = costDAO.getCostStatusOptions();
		cost = costDAO.findById(id);
		return "success";
	}

	
	
}

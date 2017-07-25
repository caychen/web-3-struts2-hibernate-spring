package org.com.cay.action;

import javax.annotation.Resource;

import org.com.cay.dao.CostDAO;
import org.com.cay.entity.Cost;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Controller
@Scope("prototype")
public class ShowCostFormAction implements BaseAction {

	private Integer page;
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	private Cost cost;
	
	@Resource
	private CostDAO costDAO;
	
	public Cost getCost() {
		return cost;
	}

	public void setCost(Cost cost) {
		this.cost = cost;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		cost = costDAO.findById(cost.getId());
		return "success";
	}

}

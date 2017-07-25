package org.com.cay.action;

import javax.annotation.Resource;

import org.com.cay.dao.CostDAO;
import org.com.cay.data.Constance.UpdateType;
import org.com.cay.entity.Cost;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Controller
@Scope("prototpye")
public class AddCostAction implements BaseAction {

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
	@Transactional(propagation=Propagation.REQUIRED)
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		costDAO.update(cost,UpdateType.Save);
		return "success";
	}

}

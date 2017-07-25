package org.com.cay.action;

import javax.annotation.Resource;

import org.com.cay.dao.CostDAO;
import org.com.cay.entity.Cost;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Controller
@Scope("prototpye")
@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
public class ValidateCostName implements BaseAction{

	private String name;
	private boolean ok = false;
	
	@Resource
	private CostDAO costDAO;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		//System.out.println(name);
		Cost cost = costDAO.findByName(name);
		if(cost == null)
			ok = true;
		return "success";
	}

}

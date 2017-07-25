package org.com.cay.action;

import javax.annotation.Resource;

import org.com.cay.dao.CostDAO;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Controller
@Scope("prototype")
public class DeleteCostAction implements BaseAction {

	private Integer id;
	private Integer page;
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	@Resource
	private CostDAO costDAO;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		costDAO.delete(id);
		return "global";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}

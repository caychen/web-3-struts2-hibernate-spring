package org.com.cay.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.com.cay.dao.AdminDAO;
import org.com.cay.dao.DAOException;
import org.com.cay.dao.DAOFactory;
import org.com.cay.data.Constance;
import org.com.cay.entity.Admin;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Controller
@Scope("prototype")
public class LoginAction implements SessionAware{

	private Admin admin;
	private Map<String, Object> session;
	
	private String errMsg;
	
	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	@Resource
	private AdminDAO adminDAO;
	
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public String execute() throws DAOException{
		//System.out.println(admin.getPassword());
		admin = adminDAO.findByCodeAndPwd(admin.getCode(), admin.getPassword());
		if(admin != null){
			//���û���Ϣ�浽session
			session.put(Constance.ADMIN_KEY, admin);
			//System.out.println("success");
			return "success";
		}else{
			return "fail";
		}
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		session = arg0;
	}
}

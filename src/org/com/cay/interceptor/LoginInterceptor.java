package org.com.cay.interceptor;



import java.util.Map;

import org.com.cay.data.Constance;
import org.com.cay.entity.Admin;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		ActionContext ac = arg0.getInvocationContext();
		Map<String, Object> session = ac.getSession();
		Admin admin = (Admin) session.get(Constance.ADMIN_KEY);
		//System.out.println(admin);
		if(admin != null)
			//System.out.println("111");
			arg0.invoke();
		else
			return "fail";
		
		return null;
	}
}

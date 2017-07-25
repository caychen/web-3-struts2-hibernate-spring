package org.com.cay.interceptor;

import org.com.cay.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class OpenSessionInViewInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		// 开启事务
		Transaction ta = session.beginTransaction();
		System.out.println("开启事务");

		try {
			ai.invoke();
			
			ta.commit();
			// 提交事务
			
			System.out.println("提交事务");
			return null;
			
		} catch (Exception e) {
			//回滚事务
			ta.rollback();
			System.out.println("回滚事务");
			e.printStackTrace();
			throw e;
		} finally {
			// 关闭Session
			HibernateUtil.closeSession();
			System.out.println("关闭Session");
		}
		
	}
}

package org.com.cay.dao.impl;


import javax.annotation.Resource;

import org.com.cay.dao.AdminDAO;
import org.com.cay.dao.DAOException;
import org.com.cay.entity.Admin;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope("prototype")
public class AdminDAOHibernateImp implements AdminDAO {

	@Resource
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public Admin findByCodeAndPwd(String code, String pwd) throws DAOException {
		// TODO Auto-generated method stub
		String hql = "from Admin where code=? and password=?";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql);
		query.setString(0, code);
		query.setString(1, pwd);
		Admin admin = (Admin) query.uniqueResult();
		return admin;
	}

}

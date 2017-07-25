package org.com.cay.dao;

import org.com.cay.dao.impl.AdminDAOImpl;
import org.com.cay.dao.impl.CostDAOHibernateImpl;

public class DAOFactory {
	//public static CostDAO costDAO = new CostDAOImpl();
	public static CostDAO costDAO = new CostDAOHibernateImpl();
	public static AdminDAO adminDAO = new AdminDAOImpl();
	
	public static CostDAO getCostDAO(){
		return costDAO;
	}
	
	public static AdminDAO getAdminDAO(){
		return adminDAO;
	}
}

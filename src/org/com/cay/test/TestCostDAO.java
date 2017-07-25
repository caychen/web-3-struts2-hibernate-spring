package org.com.cay.test;

import java.util.List;

import org.com.cay.dao.CostDAO;
import org.com.cay.dao.DAOException;
import org.com.cay.entity.Cost;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCostDAO {

	@Test
	public void test() throws DAOException {
		String conf = "/applicationContext.xml";
		@SuppressWarnings("resource")
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		CostDAO costDao = (CostDAO) ac.getBean("costDAOHibernateImpl");
		List<Cost> costList = costDao.findAll(1, 5);
		for (Cost cost : costList) {
			System.out.println(cost.getId() + "," + cost.getName());
		}
	}

}

package org.com.cay.test;

import org.com.cay.dao.DAOException;
import org.com.cay.dao.DAOFactory;
import org.com.cay.entity.Admin;
import org.junit.Test;

public class TestAdminDAO {

	@Test
	public void test() throws DAOException {
		Admin admin = DAOFactory.getAdminDAO().findByCodeAndPwd("123456", "123456");
		System.out.println(admin.getName());
	}

}

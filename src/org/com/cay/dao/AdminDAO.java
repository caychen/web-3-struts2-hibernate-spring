package org.com.cay.dao;

import org.com.cay.entity.Admin;

public interface AdminDAO {
	public Admin findByCodeAndPwd(String code, String pwd) throws DAOException;
}

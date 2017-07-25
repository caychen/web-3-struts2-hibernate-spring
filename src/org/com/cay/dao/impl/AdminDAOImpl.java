package org.com.cay.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.com.cay.dao.AdminDAO;
import org.com.cay.dao.DAOException;
import org.com.cay.entity.Admin;

public class AdminDAOImpl extends BaseDAO<Admin> implements AdminDAO {

	private static final String findAdmin = "select * from Admin where ADMIN_CODE=? and PASSWORD=?";

	@Override
	public Admin findByCodeAndPwd(String code, String pwd) throws DAOException {
		// TODO Auto-generated method stub
		List<Admin> adminList = query(findAdmin, new Object[] { code, pwd });
		if (adminList != null && adminList.size() > 0) {
			return adminList.get(0);
		} else
			return null;
	}

	@Override
	public Admin toT(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Admin admin = new Admin();
		admin.setId(rs.getInt("ID"));
		admin.setCode(rs.getString("ADMIN_CODE"));
		admin.setPassword(rs.getString("PASSWORD"));
		admin.setName(rs.getString("NAME"));
		admin.setTelephone(rs.getString("TELEPHONE"));
		admin.setEnrollDate(rs.getDate("ENROLLDATE"));
		return admin;
	}

}

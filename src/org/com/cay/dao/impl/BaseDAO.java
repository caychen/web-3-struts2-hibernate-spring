package org.com.cay.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.com.cay.dao.DAOException;
import org.com.cay.dao.DBUtils;

public abstract class BaseDAO<T> {
	protected final List<T> query(String sql, Object[] parameters)
			throws DAOException {
		Connection conn = null;

		try {
			conn = DBUtils.getConnection();

			PreparedStatement stmt = conn.prepareStatement(sql);

			if (parameters != null) {
				for (int i = 0; i < parameters.length; ++i) {
					stmt.setObject(i + 1, parameters[i]);
				}
			}

			ResultSet rs = stmt.executeQuery();
			List<T> objList = new ArrayList<T>();
			while (rs.next()) {
				objList.add(toT(rs));
			}
			return objList;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("数据访问异常", e);
		} finally {
			DBUtils.closeConnection(conn);
		}
	}

	protected final void update(String sql, Object[] params) throws DAOException {
		Connection conn = null;

		try {
			conn = DBUtils.getConnection();

			PreparedStatement stmt = conn.prepareStatement(sql);

			if (params != null) {
				for (int i = 0; i < params.length; ++i) {
					stmt.setObject(i + 1, params[i]);
				}
			}
			
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("数据访问异常", e);
		} finally {
			DBUtils.closeConnection(conn);
		}
	}

	public abstract T toT(ResultSet rs) throws SQLException;
}

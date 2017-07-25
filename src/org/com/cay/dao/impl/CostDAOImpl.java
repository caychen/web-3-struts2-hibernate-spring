package org.com.cay.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.com.cay.dao.CostDAO;
import org.com.cay.dao.DAOException;
import org.com.cay.dao.DBUtils;
import org.com.cay.data.Constance.UpdateType;
import org.com.cay.entity.Cost;

public class CostDAOImpl extends BaseDAO<Cost> implements CostDAO {

	private static final String findAll = "select ID,NAME,BASE_DURATION,BASE_COST,UNIT_COST,STATUS,DESCR,CREATETIME,STARTTIME from COST";
	private static final String findAllByPage = "select ID,NAME,BASE_DURATION,BASE_COST,UNIT_COST,STATUS,DESCR,CREATETIME,STARTTIME from COST limit ?,?";
	private static final String findById = findAll + " where id=?";
	private static final String findByName = findAll + " where name=?";
	private static final String insertCost2DB = "insert into COST(NAME,BASE_DURATION,BASE_COST,UNIT_COST,STATUS,DESCR,CREATETIME) values(?,?,?,?,0,?,?)";
	private static final String deleteCost = "delete from cost where id=?";
	private static final String updateCost = "update cost set NAME=?,BASE_DURATION=?,BASE_COST=?,UNIT_COST=?,DESCR=? where id=?";
	private static final String startCost = "update cost set startTime=?,STATUS=1 where id=?";
	private static final String endCost = "update cost set startTime=null,STATUS=0 where id=?";

	@Override
	public List<Cost> findAll() throws DAOException {
		// TODO Auto-generated method stub
		return query(findAll, null);
	}

	@Override
	public List<Cost> findAll(int page, int rowsPerPage) throws DAOException {
		// TODO Auto-generated method stub
		int begin = (page - 1) * rowsPerPage;

		return query(findAllByPage, new Object[] { begin, rowsPerPage });
	}

	@Override
	public int getTotalPages(int rowsPerPage) throws DAOException {
		// TODO Auto-generated method stub
		int totalPages = 0;
		Connection conn = null;

		try {
			conn = DBUtils.getConnection();

			PreparedStatement stmt = conn
					.prepareStatement("select count(*) from cost");

			ResultSet rs = stmt.executeQuery();
			rs.next();
			int totalRows = rs.getInt(1);
			totalPages = (totalRows % rowsPerPage == 0 ? (totalRows / rowsPerPage)
					: (totalRows / rowsPerPage + 1));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DAOException("数据访问异常", e);
		} finally {
			DBUtils.closeConnection(conn);
		}
		return totalPages;
	}

	@Override
	public Cost findById(Integer id) throws DAOException {
		// TODO Auto-generated method stub
		List<Cost> costList = query(findById, new Object[] { id });
		// System.out.println(costList.size());
		if (costList != null && costList.size() > 0) {
			return costList.get(0);
		} else
			return null;
	}

	@Override
	public Cost toT(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Cost cost = new Cost();
		cost.setId(rs.getInt("ID"));
		cost.setName(rs.getString("NAME"));
		cost.setBaseDuration(rs.getInt("BASE_DURATION"));
		cost.setBaseCost(rs.getFloat("BASE_COST"));
		cost.setUnitCost(rs.getFloat("UNIT_COST"));
		cost.setStatus(rs.getString("STATUS"));
		cost.setDescr(rs.getString("DESCR"));
		cost.setCreateTime(rs.getDate("CREATETIME"));
		cost.setStartTime(rs.getDate("STARTTIME"));
		return cost;
	}

	@Override
	public Map<String, String> getCostStatusOptions() throws DAOException {
		// TODO Auto-generated method stub
		Map<String, String> statusOptions = new LinkedHashMap<String, String>();
		statusOptions.put("1", "开通");
		statusOptions.put("0", "暂停");

		return statusOptions;
	}

	@Override
	public void update(Cost cost, UpdateType type) throws DAOException {
		// TODO Auto-generated method stub
		// NAME,BASE_DURATION,BASE_COST,UNIT_COST,STATUS,DESCR,STARTTIME
		if (type == UpdateType.Save) {
			Object[] objs = { cost.getName(), cost.getBaseDuration(),

			cost.getBaseCost(), cost.getUnitCost(), cost.getDescr(),
					new Date(System.currentTimeMillis()) };
			update(insertCost2DB, objs);

		} else if (type == UpdateType.Update) {
			Object[] objs = { cost.getName(), cost.getBaseDuration(),

			cost.getBaseCost(), cost.getUnitCost(), cost.getDescr(),
					cost.getId() };
			update(updateCost, objs);
		} else if (type == UpdateType.Start) {
			Object[] objs = { new Date(System.currentTimeMillis()),
					cost.getId() };
			update(startCost, objs);
		} else if (type == UpdateType.End) {
			Object[] objs = { cost.getId() };
			update(endCost, objs);
		}
	}

	@Override
	public Cost findByName(String name) throws DAOException {
		// TODO Auto-generated method stub
		List<Cost> costList = query(findByName, new Object[] { name });
		// System.out.println(costList.size());
		if (costList != null && costList.size() > 0) {
			return costList.get(0);
		} else
			return null;
	}

	@Override
	public void delete(Integer id) throws DAOException {
		// TODO Auto-generated method stub
		update(deleteCost, new Object[] { id });
	}

	@Override
	public List<Cost> findCostByConditions(String name, Integer baseTime,
			String status) throws DAOException {
		// TODO Auto-generated method stub
		List<Object> params = new ArrayList<Object>();

		String sql = "select * from cost where 1=1 ";
		if (!"-1".equals(status)) {
			sql += "and status=?";
			params.add(status);
		}
		if (name != null && !name.trim().equals("")) {
			sql += " and name=?";
			params.add(name);
		}
		if (baseTime != null) {
			sql += " and BASE_DURATION=?";
			params.add(baseTime);
		}

		//System.out.println(sql);
		//Object[] arrs =  params.toArray();
	//	System.out.println(arrs[0]);
//		
		List<Cost> costList = query(sql, params.toArray());
		return costList;
	}

}

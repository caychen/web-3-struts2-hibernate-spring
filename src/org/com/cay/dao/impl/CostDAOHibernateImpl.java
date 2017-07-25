package org.com.cay.dao.impl;

import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.com.cay.dao.CostDAO;
import org.com.cay.dao.DAOException;
import org.com.cay.data.Constance.UpdateType;
import org.com.cay.entity.Cost;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope("prototype")
public class CostDAOHibernateImpl implements CostDAO {

	@Resource
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Cost> findAll() throws DAOException {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();

		String hql = "from Cost";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Cost> costList = query.list();

		return costList;
	}

	@Override
	public List<Cost> findAll(int page, int rowsPerPage) throws DAOException {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();

		String hql = "from Cost";
		Query query = session.createQuery(hql);

		// 设置分页查询参数
		int begin = (page - 1) * rowsPerPage;
		query.setFirstResult(begin);// 设置抓取记录起点，
		query.setMaxResults(rowsPerPage);// 设置最大抓取记录条数

		// 返回分页查询数据
		@SuppressWarnings("unchecked")
		List<Cost> costList = query.list();

		return costList;
	}

	@Override
	public int getTotalPages(int rowsPerPage) throws DAOException {
		// TODO Auto-generated method stub

		int totalPages = 0;
		String hql = "select count(*) from Cost";// 分组函数，统计函数保持不变，只要把表名替换成实体类名
		Session session = sessionFactory.openSession();

		Query query = session.createQuery(hql);
		int totalRows = Integer.parseInt(query.uniqueResult().toString());
		session.close();

		totalPages = (totalRows % rowsPerPage == 0 ? (totalRows / rowsPerPage) : (totalRows / rowsPerPage + 1));
		return totalPages;
	}

	@Override
	public Cost findById(Integer id) throws DAOException {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();

		Cost cost = session.load(Cost.class, id);

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
		//Session session = sessionFactory.getCurrentSession();
		
		Session session = sessionFactory.getCurrentSession();

		if (UpdateType.Save == type) {
			cost.setStatus("0");
			cost.setCreateTime(new Date(System.currentTimeMillis()));
			session.save(cost);
		} else if (UpdateType.Update == type) {
			Cost dbCost = session.load(Cost.class, cost.getId());
			dbCost.setName(cost.getName());
			dbCost.setBaseDuration(cost.getBaseDuration());
			dbCost.setBaseCost(cost.getBaseCost());
			// dbCost.setCreateTime(cost.getCreateTime());
			dbCost.setDescr(cost.getDescr());
			// dbCost.setStartTime(cost.getStartTime());
			// dbCost.setStatus(cost.getStatus());
			dbCost.setUnitCost(cost.getUnitCost());
			session.update(dbCost);
		} else if (UpdateType.Start == type) {
			//System.out.println(cost.getId());
			Cost dbCost = session.load(Cost.class, cost.getId());

			//System.out.println(dbCost);
			dbCost.setStatus("1");
			dbCost.setStartTime(new Date(System.currentTimeMillis()));
			session.update(dbCost);
		} else if (UpdateType.End == type) {
			Cost dbCost = session.load(Cost.class, cost.getId());

			dbCost.setStatus("0");
			dbCost.setStartTime(null);
			session.update(dbCost);
		}
	}

	@Override
	public Cost findByName(String name) throws DAOException {
		// TODO Auto-generated method stub
		String hql = "from Cost where name=?";// 此处是name，而不是NAME，与实体类中的属性值一致
		Session session = sessionFactory.openSession();

		Query query = session.createQuery(hql);

		// 填充？的地方，从0开始，而jdbc从1开始
		query.setString(0, name);

		// uniqueResult适用于只返回一条数据的
		Cost cost = (Cost) query.uniqueResult();

		return cost;
	}

	@Override
	public void delete(Integer id) throws DAOException {
		// TODO Auto-generated method stub
		
		//Session session = sessionFactory.getCurrentSession();
		
		Session session = sessionFactory.getCurrentSession();
		Cost cost = new Cost();
		cost.setId(id);

		session.delete(cost);
	}

	@Override
	public List<Cost> findCostByConditions(String name, Integer baseTime, String status) throws DAOException {
		// TODO Auto-generated method stub

		return null;
	}

}

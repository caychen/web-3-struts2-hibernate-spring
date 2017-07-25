package org.com.cay.dao;

import java.util.List;
import java.util.Map;

import org.com.cay.data.Constance.UpdateType;
import org.com.cay.entity.Cost;

public interface CostDAO {
	public List<Cost> findAll() throws DAOException;
	
	public List<Cost> findAll(int page, int rowsPerPage) throws DAOException;
	
	public int getTotalPages(int rowsPerPage) throws DAOException;
	
	public Cost findById(Integer id) throws DAOException;
	
	public Map<String, String> getCostStatusOptions() throws DAOException;
	
	public void update(Cost cost, UpdateType type) throws DAOException;
	
	public Cost findByName(String name) throws DAOException;
	
	public void delete(Integer id) throws DAOException;
	
	public List<Cost> findCostByConditions(String name,Integer baseTime, String status) throws DAOException;
}

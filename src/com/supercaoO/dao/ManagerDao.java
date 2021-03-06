package com.supercaoO.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.supercaoO.bean.Manager;
import com.supercaoO.bean.Page;

public interface ManagerDao {
	
	/**
	 * To save an appointed Manager
	 * @return the Id of this Manager saved
	 * @param manager The Manager to be save
	 */
	int save(Manager manager);
	
	/**
	 * To delete the appointed Manager
	 * @return if delete successfully, return 1, otherwise return -1
	 * @param manager The Manager to be deleted
	 */
	int delete(Manager manager);
	
	/**
	 * To update the appointed Manager
	 * @return if update successfully, return 1, otherwise return -1
	 * @param manager The Manager to be updated
	 */
	int update(Manager manager);
	
	/**
	 * To query Manager by criteria
	 * @return query result
	 * @param criteria query criteria
	 */
	List<Manager> query(DetachedCriteria criteria);

	/**
	 * To query Manager by page and criteria
	 * @param pageNumber the page number
	 * @param pageSize the size of one page
	 * @param criteria query criteria
	 * @return query result
	 */
	Page<Manager> queryByPage(Integer pageNumber, Integer pageSize, DetachedCriteria criteria);

}

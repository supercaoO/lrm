package com.supercaoO.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.supercaoO.bean.Manager;
import com.supercaoO.bean.Page;

public interface ManagerService {
	/**
	 * Manager login
	 * @param criteria the criteria for login
	 * @return manager
	 */
	Manager login(DetachedCriteria criteria);
	
	/**
	 * Get all Managers
	 * @return the list of all Managers
	 */
	List<Manager> list();
	
	/**
	 * Get Managers by criteria
	 * @param criteria query criteria
	 * @return the list of Managers who meet the query criteria
	 */
	List<Manager> list(DetachedCriteria criteria);

	/**
	 * Save a new Manager
	 * @param manager new Manager
	 * @return the ID of new Manager
	 */
	Integer save(Manager manager);

	/**
	 * Change the Manager's password
	 * @param criteria query criteria
	 * @param newManagerPassword new password
	 * @return 1 for modification successful, -1 for modification failure
	 */
	int repwd(DetachedCriteria criteria, String newManagerPassword);

	/**
	 * Query Manager by criteria
	 * @param criteria query criteria
	 * @return Manager queried
	 */
	Manager query(DetachedCriteria criteria);

	/**
	 * Query Managers by Page and criteria
	 * @param pageNumber the page number
	 * @param pageSize the size of one page
	 * @param criteria query criteria
	 * @return query result
	 */
	Page<Manager> queryByPage(Integer pageNumber, Integer pageSize, DetachedCriteria criteria);

	/**
	 * Delete Manager by criteria
	 * @param criteria delete criteria
	 * @return 1 for delete success, -1 for delete failure
	 */
	int delete(DetachedCriteria criteria);

	/**
	 * Save the head image of the appointed Manager
	 * @param manager the appointed Manager
	 * @return the Manager updated
	 */
	Manager headImgSave(Manager manager);
	
}

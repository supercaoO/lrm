package com.supercaoO.service;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.supercaoO.bean.Manager;
import com.supercaoO.bean.Page;
import com.supercaoO.dao.ManagerDao;

@Transactional
public class ManagerServiceImpl implements ManagerService {
	private ManagerDao managerDao;
	public void setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}
	
	/**
	 * Manager login
	 * @param criteria the criteria for login
	 * @return manager
	 */
	public Manager login(DetachedCriteria criteria) {
		List<Manager> managerList = managerDao.query(criteria);
		if(managerList != null && managerList.size() > 0)
			return managerList.get(0);
		return null;
	}

	/**
	 * Get all Managers
	 * @return the list of all Managers
	 */
	public List<Manager> list() {
		return list(null);
	}

	/**
	 * Get Managers by criteria
	 * @param criteria query criteria
	 * @return the list of Managers who meet the query criteria
	 */
	public List<Manager> list(DetachedCriteria criteria) {
		return managerDao.query(criteria);
	}

	/**
	 * Save a new Manager
	 * @param manager new Manager
	 * @return the ID of new Manager
	 */
	public Integer save(Manager manager) {
		return managerDao.save(manager);
	}

	/**
	 * Change the Manager's password
	 * @param criteria query criteria
	 * @param newManagerPassword new password
	 * @return 1 for modification successful, -1 for modification failure
	 */
	public int repwd(DetachedCriteria criteria, String newManagerPassword) {
		List<Manager> managerList = managerDao.query(criteria);
		Manager manager = null;
		if(managerList != null && managerList.size() > 0) {
			manager = managerList.get(0);
			manager.setManagerPassword(newManagerPassword);
			return 1;
		}
		return -1;
	}

	/**
	 * Query Manager by criteria
	 * @param criteria query criteria
	 * @return Manager queried
	 */
	public Manager query(DetachedCriteria criteria) {
		List<Manager> managerList = managerDao.query(criteria);
		Manager manager = null;
		if(managerList != null && managerList.size() > 0) {
			manager = managerList.get(0);
		}
		return manager;
	}

	/**
	 * Query Managers by Page and criteria
	 * @param pageNumber the page number
	 * @param pageSize the size of one page
	 * @param criteria query criteria
	 * @return query result
	 */
	public Page<Manager> queryByPage(Integer pageNumber, Integer pageSize, DetachedCriteria criteria) {
		return managerDao.queryByPage(pageNumber, pageSize, criteria);
	}

	/**
	 * Delete Manager by criteria
	 * @param criteria delete criteria
	 * @return 1 for delete success, -1 for delete failure
	 */
	public int delete(DetachedCriteria criteria) {
		List<Manager> managerList = managerDao.query(criteria);
		Manager manager = null;
		if(managerList != null && managerList.size() > 0) {
			manager = managerList.get(0);
			managerDao.delete(manager);
			return 1;
		}
		return -1;
	}

	/**
	 * Save the head image of the appointed Manager
	 * @param manager the appointed Manager
	 * @return the Manager updated
	 */
	public Manager headImgSave(Manager manager) {
		Manager managerLogining = (Manager) ServletActionContext.getRequest().getSession().getAttribute("manager");
		List<Manager> managerList = managerDao.query(DetachedCriteria.forClass(Manager.class).add(Restrictions.eq("managerId", managerLogining.getManagerId())));
		Manager exitingmanager = null;
		if(managerList != null && managerList.size() > 0) {
			exitingmanager = managerList.get(0);
			exitingmanager.setHeadImgPath(manager.getHeadImgPath());
			managerDao.update(exitingmanager);
			return exitingmanager;
		}
		return null;
	}
}

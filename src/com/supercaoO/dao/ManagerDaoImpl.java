package com.supercaoO.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.supercaoO.bean.Manager;

public class ManagerDaoImpl extends HibernateDaoSupport implements ManagerDao {

	/**
	 * To save an appointed Manager
	 * @return the Id of this Manager saved
	 * @param manager The Manager to be save
	 */
	public int save(Manager manager) {
		return (int) this.getHibernateTemplate().save(manager);
	}

	/**
	 * To delete the appointed Manager
	 * @return if delete successfully, return 1, otherwise return -1
	 * @param manager The Manager to be deleted
	 */
	public int delete(Manager manager) {
		Manager exitingManager = this.getHibernateTemplate().get(Manager.class, manager.getManagerId());
		if(exitingManager != null) {
			exitingManager.setManagerStatus("0");
			return 1;
		}
		return -1;
	}

	/**
	 * To update the appointed Manager
	 * @return if update successfully, return 1, otherwise return -1
	 * @param manager The Manager to be updated
	 */
	public int update(Manager manager) {
		Manager exitingManager = this.getHibernateTemplate().get(Manager.class, manager.getManagerId());
		if(exitingManager != null) {
			manager.setManagerStatus("1");
			this.getHibernateTemplate().update(manager);
			return 1;
		}
		return -1;
	}

	/**
	 * To query Manager by criteria
	 * @return query result
	 * @param criteria query criteria
	 */
	public List<Manager> query(DetachedCriteria criteria) {
		return (List<Manager>) this.getHibernateTemplate().findByCriteria(criteria);
	}

	/*public Manager getManagerByIdAndPwd(DetachedCriteria criteria) {
		List<Manager> list = (List<Manager>) this.getHibernateTemplate().findByCriteria(criteria);
		if(list != null && list.size() == 1 )
			return list.get(0);
		return null;
	}

	public List<Manager> query(DetachedCriteria criteria) {
		List<Manager> managerList = (List<Manager>) this.getHibernateTemplate().findByCriteria(criteria);
		return managerList;
	}

	public Manager getManagerById(String managerId) {
		return this.getHibernateTemplate().get(Manager.class, Integer.valueOf(managerId));
	}

	public Integer save(Manager manager) {
		this.getHibernateTemplate().save(manager);
		return manager.getManagerId();
	}*/

}

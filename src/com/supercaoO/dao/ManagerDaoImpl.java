package com.supercaoO.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.supercaoO.bean.Manager;
import com.supercaoO.bean.Page;

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
	
	/**
	 * To query Manager by Page and criteria
	 * @return query result
	 * @param pageNumber the page number
	 * @param pageSize the size of one page
	 * @param criteria query criteria
	 */
	public Page<Manager> queryByPage(Integer pageNumber, Integer pageSize, DetachedCriteria criteria) {
		Page<Manager> managerPage = new Page<Manager>();
		managerPage.setPageNumber(pageNumber);
		managerPage.setPageSize(pageSize);
		
		//查询数据总条数
		criteria.setProjection(Projections.rowCount());
		List<Number> numList = (List<Number>) this.getHibernateTemplate().findByCriteria(criteria);
		if(numList != null && numList.size() > 0){
			int total = numList.get(0).intValue();
			managerPage.setTotal(total);
		}
		criteria.setProjection(null);
		
		//分页查询
		List<Manager> managerList = (List<Manager>) this.getHibernateTemplate().findByCriteria(criteria, (pageNumber - 1) * pageSize, pageSize);
		managerPage.setPages(managerList);
		return managerPage;
	}
}

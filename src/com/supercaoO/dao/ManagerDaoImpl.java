package com.supercaoO.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.supercaoO.bean.Manager;

public class ManagerDaoImpl extends HibernateDaoSupport implements ManagerDao {

	public Manager getManagerByIdAndPwd(DetachedCriteria criteria) {
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
	}

}

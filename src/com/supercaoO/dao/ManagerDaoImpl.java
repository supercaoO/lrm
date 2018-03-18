package com.supercaoO.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.supercaoO.bean.Manager;

public class ManagerDaoImpl extends HibernateDaoSupport implements ManagerDao {

	public List<Manager> getManagerByIdAndPwd(DetachedCriteria criteria) {
		List<Manager> list = (List<Manager>) this.getHibernateTemplate().findByCriteria(criteria);
		return list;
	}

}

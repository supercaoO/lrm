package com.supercaoO.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.supercaoO.bean.Manager;

public interface ManagerDao {

	Manager getManagerByIdAndPwd(DetachedCriteria criteria);

	List<Manager> query(DetachedCriteria criteria);

	Manager getManagerById(String managerId);

	Integer save(Manager manager);

}

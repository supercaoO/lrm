package com.supercaoO.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.supercaoO.bean.Manager;
import com.supercaoO.dao.ManagerDao;

@Transactional
public class ManagerServiceImpl implements ManagerService {
	private ManagerDao managerDao;
	public void setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}
	
	public List<Manager> login(DetachedCriteria criteria) {
		return managerDao.getManagerByIdAndPwd(criteria);
	}
	
	
	

}

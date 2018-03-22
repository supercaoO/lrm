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
	
	public Manager login(DetachedCriteria criteria) {
		return managerDao.getManagerByIdAndPwd(criteria);
	}

	public List<Manager> query(DetachedCriteria criteria) {
		return managerDao.query(criteria);
	}

	public Manager getManagerById(String managerId) {
		return managerDao.getManagerById(managerId);
	}

	public Integer save(Manager manager) {
		return managerDao.save(manager);
	}

	public int reqwd(DetachedCriteria criteria, String newManagerPassword) {
		Manager manager = managerDao.getManagerByIdAndPwd(criteria);
		if (manager == null) {
			return -1;
		} else {
			manager.setManagerPassword(newManagerPassword);
			return 1;
		}
	}

	

}

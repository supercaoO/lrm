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
		List<Manager> managerList = managerDao.query(criteria);
		if(managerList != null && managerList.size() > 0)
			return managerList.get(0);
		return null;
	}

	public List<Manager> list() {
		return list(null);
	}

	public List<Manager> list(DetachedCriteria criteria) {
		return managerDao.query(criteria);
	}

	public Integer save(Manager manager) {
		return managerDao.save(manager);
	}

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
	
	/*public Manager login(DetachedCriteria criteria) {
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
	}*/

	

}

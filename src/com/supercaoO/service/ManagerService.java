package com.supercaoO.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.supercaoO.bean.Manager;

public interface ManagerService {

	/*Manager login(DetachedCriteria criteria);

	List<Manager> query(DetachedCriteria criteria);

	Manager getManagerById(String managerId);

	Integer save(Manager manager);

	int reqwd(DetachedCriteria criteria, String newManagerPassword);*/
	
	Manager login(DetachedCriteria criteria);
	
	List<Manager> list();
	
	List<Manager> list(DetachedCriteria criteria);
	
	Integer save(Manager manager);

	int repwd(DetachedCriteria criteria, String newManagerPassword);

	Manager query(DetachedCriteria criteria);
	
}

package com.supercaoO.web;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.supercaoO.bean.Manager;
import com.supercaoO.service.ManagerService;

public class ManagerAction extends ActionSupport implements ModelDriven<Manager> {
	private static final long serialVersionUID = 3346627400724315654L;

	private ManagerService managerService;
	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}
	
	private Manager manager = new Manager();
	public Manager getModel() {
		return manager;
	}
	
	public String login() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Manager.class);
		criteria.add(Restrictions.eq("managerId", manager.getManagerId()));
		criteria.add(Restrictions.eq("managerPassword", manager.getManagerPassword()));
		List<Manager> list = managerService.login(criteria);
		if (list.size() == 1) {
			return SUCCESS;
		} else {
			return NONE;
		}
	}
	
}

package com.supercaoO.web;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
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
		criteria.add(Restrictions.eq("managerStatus", "1"));
		Manager manager = managerService.login(criteria);
		if (manager != null) {
			ServletActionContext.getRequest().getSession().setAttribute("manager", manager);
			return SUCCESS;
		} else {
			return "managerLogin";
		}
	}
	
	public String logout() {
		ServletActionContext.getRequest().getSession().removeAttribute("manager");
		return LOGIN;
		
	}
	
	public String query() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Manager.class).add(Restrictions.eq("managerStatus", "1"));
		List<Manager> managerList = managerService.query(criteria);
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		String thisManagerId = ServletActionContext.getRequest().getParameter("thisManagerId");
		if(thisManagerId != null) {
			try {
				thisManagerId = new String(thisManagerId.getBytes("iso-8859-1"), "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			for (int index = 0; index < managerList.size(); index++) {
				if(managerList.get(index).getManagerId().toString().equals(thisManagerId)) {
					managerList.remove(index);
					break;
				}
			}
		}
		valueStack.set("managerList", managerList);
		return "queryDone";
	}
	
	public String save() {
		manager.setManagerPassword("123456");
		manager.setManagerStatus("1");
		Integer managerId = managerService.save(manager);
		ActionContext.getContext().getValueStack().push(managerId.toString());
		return "saveSuccess";
	}
	
	public String list() {
		query();
		return "listDone";
	}
	
	public String repwd() {
		String newManagerPassword = ServletActionContext.getRequest().getParameter("newManagerPassword");
		String confirmManagerPassword = ServletActionContext.getRequest().getParameter("confirmManagerPassword");
		if ( !newManagerPassword.equals(confirmManagerPassword) ) {
			return "repwd";
		} else {
			DetachedCriteria criteria = DetachedCriteria.forClass(Manager.class);
			criteria.add(Restrictions.eq("managerId", manager.getManagerId()));
			criteria.add(Restrictions.eq("managerPassword", manager.getManagerPassword()));
			int i = managerService.reqwd(criteria, newManagerPassword);
			if (i == 1) {
				ActionContext.getContext().getSession().remove("manager");
				return "repwdSuccess";
			}
			else
				return "repwd";
		}
	}
	
}

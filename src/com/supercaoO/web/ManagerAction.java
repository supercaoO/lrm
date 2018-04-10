package com.supercaoO.web;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.caoO.encryption.MD5;
import com.caoO.upload.FileUUIDUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import com.supercaoO.bean.Manager;
import com.supercaoO.bean.Page;
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
	
	private Integer pageNumber = 1;
	public void setPageNumber(Integer pageNumber) {
		if(pageNumber == null){
			pageNumber = 1;
		}
		this.pageNumber = pageNumber;
	}
	
	private Integer pageSize = 10;
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	private File headImg;
	private String headImgFileName;
	private String headImgContentType;
	public void setHeadImg(File headImg) {
		this.headImg = headImg;
	}
	public void setHeadImgFileName(String headImgFileName) {
		this.headImgFileName = headImgFileName;
	}
	public void setHeadImgContentType(String headImgContentType) {
		this.headImgContentType = headImgContentType;
	}

	public String login() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Manager.class);
		criteria.add(Restrictions.eq("managerId", manager.getManagerId()));
		criteria.add(Restrictions.eq("managerPassword", MD5.encrypt(manager.getManagerPassword())));
		criteria.add(Restrictions.eq("managerStatus", "1"));
		Manager exitingManager = managerService.login(criteria);
		if(exitingManager != null) {
			ServletActionContext.getRequest().getSession().setAttribute("manager", exitingManager);
			return "loginSuccess";
		}
		return "managerLogin";
	}
	
	public String list() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Manager.class);
		criteria.add(Restrictions.eq("managerStatus", "1"));
		List<Manager> managerList = managerService.list(criteria);
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		valueStack.set("managerList", managerList);
		return ServletActionContext.getRequest().getParameter("operation");
	}
	
	public String save() {
		manager.setManagerPassword(MD5.encrypt("123456"));
		manager.setManagerStatus("1");
		manager.setHeadImgPath("/headImg/default.jpg");
		Integer managerId = managerService.save(manager);
		ActionContext.getContext().getValueStack().push(managerId.toString());
		return "managerSaveDone";
	}
	
	public String repwd() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Manager.class);
		criteria.add(Restrictions.eq("managerId", manager.getManagerId()));
		criteria.add(Restrictions.eq("managerPassword", MD5.encrypt(manager.getManagerPassword())));
		criteria.add(Restrictions.eq("managerStatus", "1"));
		String newManagerPassword = ServletActionContext.getRequest().getParameter("newManagerPassword");
		if(1 == managerService.repwd(criteria, MD5.encrypt(newManagerPassword))) {
			return "managerRepwdDone";
		}
		return "managerRepwd";
	}
	
	public String listWithProjectId() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Manager.class).add(Restrictions.eq("managerStatus", "1"));
		List<Manager> managerList = managerService.list(criteria);
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
		return "projectUpdate";
	}
	
	public String query() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Manager.class);
		String managerId = ServletActionContext.getRequest().getParameter("managerId");
		criteria.add(Restrictions.eq("managerId", Integer.valueOf(managerId)));
		Manager manager = managerService.query(criteria);
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		valueStack.push(manager);
		return "managerMsg";
	}
	
	public String logout() {
		ServletActionContext.getRequest().getSession().removeAttribute("manager");
		return "managerLogin";
	}
	
	public String queryByPage() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Manager.class);
		criteria.add(Restrictions.eq("managerStatus", "1"));
		Page<Manager> managerPage = managerService.queryByPage(pageNumber, pageSize, criteria);
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.set("managerPage", managerPage);
		int[] pageNums = new int[managerPage.getPageCount()];
		for(int i = 0; i < pageNums.length; i++) {
			pageNums[i] = i + 1;
		}
		vs.set("pageNums", pageNums);
		return ServletActionContext.getRequest().getParameter("operation");
	}
	
	public String delete() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Manager.class);
		String managerId = ServletActionContext.getRequest().getParameter("managerId");
		try {
			managerId = new String(managerId.getBytes("iso-8859-1"), "utf-8");
			criteria.add(Restrictions.eq("managerId", Integer.valueOf(managerId)));
			managerService.delete(criteria);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		queryByPage();
		return "managerList";
	}
	
	public String headImgSave() throws IOException {
		Manager managerLogining = (Manager) ServletActionContext.getRequest().getSession().getAttribute("manager");
		String headImgPath = managerLogining.getHeadImgPath();
		if(headImgFileName != null) {
			if(headImgPath.equals("/headImg/default.jpg")) {
				String uuidFileName = FileUUIDUtils.getFileUUID(headImgFileName);
				headImgPath = "/headImg/" + uuidFileName;
			}
			else {
				int lastIndex = headImgPath.lastIndexOf(".");
				headImgPath = headImgPath.substring(0, lastIndex) + FileUUIDUtils.getSuffix(headImgFileName);
			}
			File file = new File("E:/javaTools/apache-tomcat-7.0.85/webapps" + headImgPath);
			FileUtils.copyFile(headImg, file);
			manager.setHeadImgPath(headImgPath);
			managerService.headImgSave(manager);
			managerLogining.setHeadImgPath(headImgPath);
			return "headImgSave";
		}
		return ERROR;
	}
}

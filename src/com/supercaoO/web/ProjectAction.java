package com.supercaoO.web;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import com.supercaoO.bean.Manager;
import com.supercaoO.bean.Page;
import com.supercaoO.bean.Project;
import com.supercaoO.service.ProjectService;

import sun.print.resources.serviceui;

public class ProjectAction extends ActionSupport implements ModelDriven<Project> {
	private static final long serialVersionUID = 578440647771320843L;
	
	private DateFormat dateFormat;
	public void setDateFormat(DateFormat dateFormat) {
		this.dateFormat = dateFormat;
	}

	private ProjectService projectService;
	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}
	
	private Project project = new Project();
	public Project getModel() {
		return project;
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
	
	/// Save new Project
	public String save() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Manager.class);
		Integer managerId = Integer.valueOf(ServletActionContext.getRequest().getParameter("managerId"));
		criteria.add(Restrictions.eq("managerId", managerId));
		project.setProjectStatus("1");
		project.setLastCommitDate(dateFormat.format(new Date()));
		projectService.save(project, criteria);
		return "projectSaveDone";
	}
	
	/// Get all Projects
	public String list() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Project.class);
		criteria.add(Restrictions.eq("projectStatus", "1"));
		List<Project> projectList = projectService.list(criteria);
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		valueStack.set("projectList", projectList);
		return ServletActionContext.getRequest().getParameter("operation");
	}
	
	/// Get all students who belong to the appointed project
	public String queryStudents() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Project.class);
		criteria.add(Restrictions.eq("projectStatus", "1"));
		String projectId = ServletActionContext.getRequest().getParameter("projectId");
		criteria.add(Restrictions.eq("projectId", Integer.valueOf(projectId)));
		List<Project> projectList = projectService.list(criteria);
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		if(projectList != null && projectList.size() > 0) {
			valueStack.set("studentList", projectList.get(0).getStudents());
			System.out.println(projectList.get(0).getStudents().size());
		}
		return "studentList";
	}
	
	/// Update the appointed Project
	public String update() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Manager.class);
		Integer managerId = Integer.valueOf(ServletActionContext.getRequest().getParameter("managerId"));
		criteria.add(Restrictions.eq("managerId", managerId));
		project.setProjectStatus("1");		
		project.setLastCommitDate(dateFormat.format(new Date()));
		projectService.update(project, criteria);
		list();
		return "projectList";
	}
	
	/// Delete the appointed Project
	public String delete() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Project.class);
		String projectId = ServletActionContext.getRequest().getParameter("projectId");
		try {
			projectId = new String(projectId.getBytes("iso-8859-1"), "utf-8");
			criteria.add(Restrictions.eq("projectId", Integer.valueOf(projectId)));
			projectService.delete(criteria);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		queryByPage();
		return "projectList";
	}
	
	/// Query a Project
	public String query() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Project.class);
		String projectId = ServletActionContext.getRequest().getParameter("projectId");
		criteria.add(Restrictions.eq("projectId", Integer.valueOf(projectId)));
		Project project = projectService.query(criteria);
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		valueStack.push(project);
		return "projectMsg";
	}
	
	/// Query Projects by page
	public String queryByPage() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Project.class);
		criteria.add(Restrictions.eq("projectStatus", "1"));
		Page<Project> projectPage = projectService.queryByPage(pageNumber, pageSize, criteria);
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.set("projectPage", projectPage);
		int[] pageNums = new int[projectPage.getPageCount()];
		for(int i = 0; i < pageNums.length; i++) {
			pageNums[i] = i + 1;
		}
		vs.set("pageNums", pageNums);
		return ServletActionContext.getRequest().getParameter("operation");
	}
}

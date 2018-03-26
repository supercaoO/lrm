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
	
	public String save() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Manager.class);
		Integer managerId = Integer.valueOf(ServletActionContext.getRequest().getParameter("managerId"));
		criteria.add(Restrictions.eq("managerId", managerId));
		project.setProjectStatus("1");
		project.setLastCommitDate(dateFormat.format(new Date()));
		projectService.save(project, criteria);
		return "projectSaveDone";
	}
	
	public String list() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Project.class);
		criteria.add(Restrictions.eq("projectStatus", "1"));
		List<Project> projectList = projectService.list(criteria);
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		valueStack.set("projectList", projectList);
		return ServletActionContext.getRequest().getParameter("operation");
	}
	
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
		list();
		return "projectList";
	}
	
	public String query() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Project.class);
		String projectId = ServletActionContext.getRequest().getParameter("projectId");
		criteria.add(Restrictions.eq("projectId", Integer.valueOf(projectId)));
		Project project = projectService.query(criteria);
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		valueStack.push(project);
		return "projectMsg";
	}
	
	/*public String save() {
		String managerId = ServletActionContext.getRequest().getParameter("managerId");
		project.setProjectStatus("1");
		String currentDate = dateFormat.format(new Date(System.currentTimeMillis()));
		project.setLastCommitDate(currentDate);
		projectService.save(project, managerId);
		return "saveSuccess";
	}
	
	public String query() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Project.class);
		criteria.add(Restrictions.eq("projectStatus", "1"));
		List<Project> projectList = projectService.query(criteria);
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		valueStack.set("projectList", projectList);
		return "queryDone";
	}
	
	public String queryStudentsByProject() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Project.class);
		String projectName = ServletActionContext.getRequest().getParameter("projectName");
		try {
			projectName = new String(projectName.getBytes("iso-8859-1"), "utf-8");
			criteria.add(Restrictions.eq("projectName", projectName));
			List<Project> projectList = projectService.query(criteria);
			ValueStack valueStack = ActionContext.getContext().getValueStack();
			valueStack.set("path", new String[] { "项目", projectName });
			valueStack.set("studentList", projectList.get(0).getStudents());
			return "queryStudentsByProjectDone";
		} catch (UnsupportedEncodingException e) {
			return NONE;
		}
	}
	
	public String update() {
		String currentDate = dateFormat.format(new Date(System.currentTimeMillis()));
		String oldProjectName = ServletActionContext.getRequest().getParameter("oldProjectName");
		DetachedCriteria criteria = DetachedCriteria.forClass(Project.class).add(Restrictions.eq("projectName", oldProjectName));
		project.setLastCommitDate(currentDate);
		String managerId = ServletActionContext.getRequest().getParameter("managerId");
		projectService.update(project, criteria, managerId);
		return list();
	}
	

	public String list() {
		query();
		return "listDone";
	}*/

}

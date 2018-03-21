package com.supercaoO.web;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import com.supercaoO.bean.Manager;
import com.supercaoO.bean.Project;
import com.supercaoO.service.ProjectService;

public class ProjectAction extends ActionSupport implements ModelDriven<Project> {
	private static final long serialVersionUID = 578440647771320843L;
	
	private ProjectService projectService;
	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}
	
	private Project project = new Project();
	public Project getModel() {
		return project;
	}
	
	public String save() {
		String managerId = ServletActionContext.getRequest().getParameter("managerId");
		project.setProjectStatus("1");
		projectService.save(project, managerId);
		return "saveSuccess";
	}
	
	public String query() {
		List<Project> projectList = projectService.query();
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		valueStack.set("projectList", projectList);
		return "queryDone";
	}

}

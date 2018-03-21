package com.supercaoO.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.supercaoO.bean.Manager;
import com.supercaoO.bean.Project;
import com.supercaoO.dao.ProjectDao;

@Transactional
public class ProjectServiceImpl implements ProjectService {
	private ProjectDao projectDao;
	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}
	private ManagerService managerService;
	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}


	public void save(Project project, String managerId) {
		Manager manager = managerService.getManagerById(managerId);
		projectDao.save(project, manager);
	}


	public List<Project> query() {
		return projectDao.query();
	}


	public Project getProjectById(String projectId) {
		return projectDao.getManagerById(projectId);
	}

}

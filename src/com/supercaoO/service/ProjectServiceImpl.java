package com.supercaoO.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.supercaoO.bean.Manager;
import com.supercaoO.bean.Project;
import com.supercaoO.dao.ManagerDao;
import com.supercaoO.dao.ProjectDao;

@Transactional
public class ProjectServiceImpl implements ProjectService {
	private ProjectDao projectDao;
	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}
	
	private ManagerDao managerDao;
	public void setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}
	
	public int save(Project project, DetachedCriteria criteria) {
		List<Manager> managerList = managerDao.query(criteria);
		Manager manager = null;
		if(managerList != null && managerList.size() > 0) {
			manager = managerList.get(0);
			project.setManager(manager);
		}
		return projectDao.save(project);
	}

	public List<Project> list(DetachedCriteria criteria) {
		return projectDao.query(criteria);
	}

	public int update(Project project, DetachedCriteria criteria) {
		List<Manager> managerList = managerDao.query(criteria);
		List<Project> projectList = projectDao.query(DetachedCriteria.forClass(Project.class).add(Restrictions.eq("projectId", project.getProjectId())));
		Manager manager = null;
		Project exitingProject = null;
		if(managerList != null && managerList.size() > 0 && projectList != null && managerList.size() > 0) {
			manager = managerList.get(0);
			exitingProject = projectList.get(0);
			exitingProject.setManager(manager);
			exitingProject.setProjectName(project.getProjectName());
			exitingProject.setProjectIntro(project.getProjectIntro());
			exitingProject.setProjectStatus(project.getProjectStatus());
			exitingProject.setLastCommitDate(project.getLastCommitDate());
		}
		return projectDao.update(exitingProject);
	}

	public int delete(DetachedCriteria criteria) {
		List<Project> projectList = projectDao.query(criteria);
		Project project = null;
		if(projectList != null && projectList.size() > 0) {
			project = projectList.get(0);
			projectDao.delete(project);
			return 1;
		}
		return -1;
	}
	


	/*public void save(Project project, String managerId) {
		Manager manager = managerService.getManagerById(managerId);
		projectDao.save(project, manager);
	}


	public List<Project> query(DetachedCriteria criteria) {
		return projectDao.query(criteria);
	}


	public Project getProjectById(String projectId) {
		return projectDao.getManagerById(projectId);
	}

	public void update(Project project, DetachedCriteria criteria, String managerId) {
		Project p = projectDao.update(project, criteria, managerId);
		Manager manager = managerService.getManagerById(managerId);
		p.setManager(manager);
	}*/

}

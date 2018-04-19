package com.supercaoO.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.supercaoO.bean.Manager;
import com.supercaoO.bean.Page;
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
	
	/**
	 * Save new Project
	 * @param project new Project
	 * @param criteria query criteria for Manager belonged
	 * @return the ID of new Project
	 */
	public int save(Project project, DetachedCriteria criteria) {
		List<Manager> managerList = managerDao.query(criteria);
		Manager manager = null;
		if(managerList != null && managerList.size() > 0) {
			manager = managerList.get(0);
			project.setManager(manager);
		}
		return projectDao.save(project);
	}

	/**
	 * Get Projects by criteria
	 * @param criteria query criteria
	 * @return the list of Projects queried
	 */
	public List<Project> list(DetachedCriteria criteria) {
		return projectDao.query(criteria);
	}

	/**
	 * Update the appointed Project
	 * @param project the appointed Project
	 * @param criteria query criteria for Manager belonged
	 * @return if update successfully, return 1, otherwise return -1
	 */
	public int update(Project project, DetachedCriteria criteria) {
		List<Manager> managerList = managerDao.query(criteria);
		List<Project> projectList = projectDao.query(DetachedCriteria.forClass(Project.class).add(Restrictions.eq("projectId", project.getProjectId())));
		Manager manager = null;
		Project exitingProject = null;
		if(managerList != null && managerList.size() > 0 && projectList != null && projectList.size() > 0) {
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

	/**
	 * Delete Project by criteria
	 * @param criteria delete criteria
	 * @return if delete successfully, return 1, otherwise return -1
	 */
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

	/**
	 * Query Project by criteria
	 * @param criteria query criteria
	 * @return Project queried
	 */
	public Project query(DetachedCriteria criteria) {
		List<Project> projectList = projectDao.query(criteria);
		if(projectList != null && projectList.size() > 0) {
			return projectList.get(0);
		}
		return null;
	}

	/**
	 * Query Projects by page and criteria
	 * @param pageNumber the page number
	 * @param pageSize the size of page
	 * @param criteria query criteria
	 * @return query result
	 */
	public Page<Project> queryByPage(Integer pageNumber, Integer pageSize, DetachedCriteria criteria) {
		return projectDao.queryByPage(pageNumber, pageSize, criteria);
	}
}

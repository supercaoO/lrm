package com.supercaoO.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.supercaoO.bean.Manager;
import com.supercaoO.bean.Project;

public class ProjectDaoImpl extends HibernateDaoSupport implements ProjectDao {

	/**
	 * To save an appointed Project
	 * @return the Id of this Project saved
	 * @param project The Project to be save
	 */
	public int save(Project project) {
		return (int) this.getHibernateTemplate().save(project);
	}
	
	/**
	 * To delete the appointed Project
	 * @return if delete successfully, return 1, otherwise return -1
	 * @param project The Project to be deleted
	 */
	public int delete(Project project) {
		Project exitingProject = this.getHibernateTemplate().get(Project.class, project.getProjectId());
		if(exitingProject != null) {
			exitingProject.setProjectStatus("0");
			return 1;
		}
		return -1;
	}
	
	/**
	 * To update the appointed Project
	 * @return if update successfully, return 1, otherwise return -1
	 * @param project The Project to be updated
	 */
	public int update(Project project) {
		Project exitingProject = this.getHibernateTemplate().get(Project.class, project.getProjectId());
		if(exitingProject != null) {
			this.getHibernateTemplate().update(exitingProject);
			return 1;
		}
		return -1;
	}
	
	/**
	 * To query Project by criteria
	 * @return query result
	 * @param criteria query criteria
	 */
	public List<Project> query(DetachedCriteria criteria){
		return (List<Project>) this.getHibernateTemplate().findByCriteria(criteria);
	}

	/*public void save(Project project, Manager manager) {
		this.getHibernateTemplate().save(project);
		project.setManager(manager);
	}

	public List<Project> query(DetachedCriteria criteria) {
		List<Project> projectList = (List<Project>) this.getHibernateTemplate().findByCriteria(criteria);
		return projectList;
	}

	public Project getManagerById(String projectId) {
		return this.getHibernateTemplate().get(Project.class, Integer.valueOf(projectId));
	}
	
	public Project update(Project project, DetachedCriteria criteria, String managerId) {
		List<Project> projectList = (List<Project>) this.getHibernateTemplate().findByCriteria(criteria);
		Project p = null;
		if(projectList != null && projectList.size() != 0) {
			p = projectList.get(0);
			p.setProjectName(project.getProjectName());
			p.setProjectIntro(project.getProjectIntro());
			p.setLastCommitDate(project.getLastCommitDate());
			this.getHibernateTemplate().update(p);
		}
		return p;
	}*/

}

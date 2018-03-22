package com.supercaoO.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.supercaoO.bean.Manager;
import com.supercaoO.bean.Project;

public class ProjectDaoImpl extends HibernateDaoSupport implements ProjectDao {

	public void save(Project project, Manager manager) {
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
	}

}

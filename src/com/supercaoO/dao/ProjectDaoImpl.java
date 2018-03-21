package com.supercaoO.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.supercaoO.bean.Manager;
import com.supercaoO.bean.Project;

public class ProjectDaoImpl extends HibernateDaoSupport implements ProjectDao {

	public void save(Project project, Manager manager) {
		this.getHibernateTemplate().save(project);
		project.setManager(manager);
	}

	public List<Project> query() {
		List<Project> projectList = (List<Project>) this.getHibernateTemplate().find("from Project where projectStatus = ?", "1");
		return projectList;
	}

	public Project getManagerById(String projectId) {
		return this.getHibernateTemplate().get(Project.class, Integer.valueOf(projectId));
	}

}

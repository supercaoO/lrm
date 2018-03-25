package com.supercaoO.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.supercaoO.bean.Project;

public interface ProjectService {

	/*void save(Project project, String managerId);

	List<Project> query(DetachedCriteria criteria);

	Project getProjectById(String projectId);

	void update(Project project, DetachedCriteria criteria, String managerId);*/
	
	int save(Project project, DetachedCriteria criteria);

	List<Project> list(DetachedCriteria criteria);

	int update(Project project, DetachedCriteria criteria);

	int delete(DetachedCriteria criteria);

}

package com.supercaoO.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.supercaoO.bean.Manager;
import com.supercaoO.bean.Project;

public interface ProjectDao {

	void save(Project project, Manager manager);

	List<Project> query(DetachedCriteria criteria);

	Project getManagerById(String projectId);

	Project update(Project project, DetachedCriteria criteria, String managerId);
}

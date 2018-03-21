package com.supercaoO.dao;

import java.util.List;

import com.supercaoO.bean.Manager;
import com.supercaoO.bean.Project;

public interface ProjectDao {

	void save(Project project, Manager manager);

	List<Project> query();

	Project getManagerById(String projectId);

}

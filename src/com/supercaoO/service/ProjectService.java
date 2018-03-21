package com.supercaoO.service;

import java.util.List;

import com.supercaoO.bean.Project;

public interface ProjectService {

	void save(Project project, String managerId);

	List<Project> query();

	Project getProjectById(String projectId);

}

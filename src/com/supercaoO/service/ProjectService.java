package com.supercaoO.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.supercaoO.bean.Page;
import com.supercaoO.bean.Project;

public interface ProjectService {
	
	int save(Project project, DetachedCriteria criteria);

	List<Project> list(DetachedCriteria criteria);

	int update(Project project, DetachedCriteria criteria);

	int delete(DetachedCriteria criteria);

	Project query(DetachedCriteria criteria);

	Page<Project> queryByPage(Integer pageNumber, Integer pageSize, DetachedCriteria criteria);

}

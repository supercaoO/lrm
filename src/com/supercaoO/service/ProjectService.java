package com.supercaoO.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.supercaoO.bean.Page;
import com.supercaoO.bean.Project;

public interface ProjectService {
	
	/**
	 * Save new Project
	 * @param project new Project
	 * @param criteria query criteria for Manager belonged
	 * @return the ID of new Project
	 */
	int save(Project project, DetachedCriteria criteria);

	/**
	 * Get Projects by criteria
	 * @param criteria query criteria
	 * @return the list of Projects queried
	 */
	List<Project> list(DetachedCriteria criteria);

	/**
	 * Update the appointed Project
	 * @param project the appointed Project
	 * @param criteria query criteria for Manager belonged
	 * @return if update successfully, return 1, otherwise return -1
	 */
	int update(Project project, DetachedCriteria criteria);

	/**
	 * Delete Project by criteria
	 * @param criteria delete criteria
	 * @return if delete successfully, return 1, otherwise return -1
	 */
	int delete(DetachedCriteria criteria);

	/**
	 * Query Project by criteria
	 * @param criteria query criteria
	 * @return Project queried
	 */
	Project query(DetachedCriteria criteria);

	/**
	 * Query Projects by page and criteria
	 * @param pageNumber the page number
	 * @param pageSize the size of page
	 * @param criteria query criteria
	 * @return query result
	 */
	Page<Project> queryByPage(Integer pageNumber, Integer pageSize, DetachedCriteria criteria);

}

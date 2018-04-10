package com.supercaoO.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.supercaoO.bean.Page;
import com.supercaoO.bean.Project;

public interface ProjectDao {

	/**
	 * To save an appointed Project
	 * @return the Id of this Project saved
	 * @param project The Project to be save
	 */
	int save(Project project);
	
	/**
	 * To delete the appointed Project
	 * @return if delete successfully, return 1, otherwise return -1
	 * @param project The Project to be deleted
	 */
	int delete(Project project);
	
	/**
	 * To update the appointed Project
	 * @return if update successfully, return 1, otherwise return -1
	 * @param project The Project to be updated
	 */
	int update(Project project);
	
	/**
	 * To query Project by criteria
	 * @return query result
	 * @param criteria query criteria
	 */
	List<Project> query(DetachedCriteria criteria);

	Page<Project> queryByPage(Integer pageNumber, Integer pageSize, DetachedCriteria criteria);
}

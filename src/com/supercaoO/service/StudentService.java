package com.supercaoO.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.supercaoO.bean.Page;
import com.supercaoO.bean.Student;

public interface StudentService {

	/**
	 * Save new Student
	 * @param student new Student
	 * @param criteria query criteria for Project belonged
	 * @return the ID of new Student
	 */
	int save(Student student, DetachedCriteria criteria);

	/**
	 * Get Students by criteria
	 * @param criteria query criteria
	 * @return the list of Student queried
	 */
	List<Student> list(DetachedCriteria criteria);

	/**
	 * Query Students by page and criteria
	 * @param pageNumber the page number
	 * @param pageSize the size of one page
	 * @param criteria query criteria
	 * @return query result
	 */
	Page<Student> queryByPage(Integer pageNumber, Integer pageSize, DetachedCriteria criteria);

	/**
	 * Delete the appointed Student
	 * @param criteria the appointed Student
	 * @return if delete successfully, return 1, otherwise return -1
	 */
	int delete(DetachedCriteria criteria);
}

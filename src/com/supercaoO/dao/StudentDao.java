package com.supercaoO.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.supercaoO.bean.Page;
import com.supercaoO.bean.Student;

public interface StudentDao {
	
	/**
	 * To save an appointed Student
	 * @return the Id of this Student saved
	 * @param student The Student to be save
	 */
	int save(Student student);
	
	/**
	 * To delete the appointed Student
	 * @return if delete successfully, return 1, otherwise return -1
	 * @param student The Student to be deleted
	 */
	int delete(Student student);
	
	/**
	 * To update the appointed Student
	 * @return if update successfully, return 1, otherwise return -1
	 * @param student The Student to be updated
	 */
	int update(Student student);
	
	/**
	 * To query Student by criteria
	 * @return query result
	 * @param criteria query criteria
	 */
	List<Student> query(DetachedCriteria criteria);

	/**
	 * To query Student by page and criteria
	 * @param pageNumber the page number
	 * @param pageSize the size of one page
	 * @param criteria query criteria
	 * @return query result
	 */
	Page<Student> queryByPage(Integer pageNumber, Integer pageSize, DetachedCriteria criteria);

}

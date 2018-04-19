package com.supercaoO.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.supercaoO.bean.Page;
import com.supercaoO.bean.Project;
import com.supercaoO.bean.Student;
import com.supercaoO.dao.ProjectDao;
import com.supercaoO.dao.StudentDao;

@Transactional
public class StudentServiceImpl implements StudentService {
	private StudentDao studentDao;
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	private ProjectDao projectDao;
	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	/**
	 * Save new Student
	 * @param student new Student
	 * @param criteria query criteria for Project belonged
	 * @return the ID of new Student
	 */
	public int save(Student student, DetachedCriteria criteria) {
		List<Project> projectList = projectDao.query(criteria);
		Project project = null;
		if(projectList != null && projectList.size() > 0) {
			project = projectList.get(0);
			student.getProjects().add(project);
		}
		return studentDao.save(student);
		
	}

	/**
	 * Get Students by criteria
	 * @param criteria query criteria
	 * @return the list of Student queried
	 */
	public List<Student> list(DetachedCriteria criteria) {
		return studentDao.query(criteria);
	}

	/**
	 * Query Students by page and criteria
	 * @param pageNumber the page number
	 * @param pageSize the size of one page
	 * @param criteria query criteria
	 * @return query result
	 */
	public Page<Student> queryByPage(Integer pageNumber, Integer pageSize, DetachedCriteria criteria) {
		return studentDao.queryByPage(pageNumber, pageSize, criteria);
	}

	/**
	 * Delete the appointed Student
	 * @param criteria the appointed Student
	 * @return if delete successfully, return 1, otherwise return -1
	 */
	public int delete(DetachedCriteria criteria) {
		List<Student> studentList = studentDao.query(criteria);
		Student student = null;
		if(studentList != null && studentList.size() > 0) {
			student = studentList.get(0);
			studentDao.delete(student);
			return 1;
		}
		return -1;
	}
}

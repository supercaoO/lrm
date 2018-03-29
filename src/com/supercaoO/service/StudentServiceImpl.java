package com.supercaoO.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.supercaoO.bean.Manager;
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


	public int save(Student student, DetachedCriteria criteria) {
		List<Project> projectList = projectDao.query(criteria);
		Project project = null;
		if(projectList != null && projectList.size() > 0) {
			project = projectList.get(0);
			student.getProjects().add(project);
		}
		return studentDao.save(student);
		
	}

	public List<Student> list(DetachedCriteria criteria) {
		return studentDao.query(criteria);
	}


	public Page<Student> queryByPage(Integer pageNumber, Integer pageSize, DetachedCriteria criteria) {
		return studentDao.queryByPage(pageNumber, pageSize, criteria);
	}


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
	
	/*private ProjectService projectService;
	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}


	public void save(Student student, String projectId) {
		Project project = projectService.getProjectById(projectId);
		studentDao.save(student, project);
	}

	public Student login(DetachedCriteria criteria) {
		return studentDao.getStudentByIdAndPwd(criteria);
	}


	public int reqwd(DetachedCriteria criteria, String newStudentPassword) {
		Student student = studentDao.getStudentByIdAndPwd(criteria);
		if (student == null) {
			return -1;
		} else {
			student.setStudentPassword(newStudentPassword);
			return 1;
		}
	}

	public List<Student> query() {
		return studentDao.query();
	}*/
	

}

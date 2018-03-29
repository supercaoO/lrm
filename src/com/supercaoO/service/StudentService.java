package com.supercaoO.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.supercaoO.bean.Page;
import com.supercaoO.bean.Student;

public interface StudentService {

	int save(Student student, DetachedCriteria criteria);

	List<Student> list(DetachedCriteria criteria);

	Page<Student> queryByPage(Integer pageNumber, Integer pageSize, DetachedCriteria criteria);

	int delete(DetachedCriteria criteria);

	/*void save(Student student, String projectId);

	Student login(DetachedCriteria criteria);

	int reqwd(DetachedCriteria criteria, String newStudentPassword);

	List<Student> query();*/

}

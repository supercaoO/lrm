package com.supercaoO.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.supercaoO.bean.Student;

public interface StudentService {

	void save(Student student, String projectId);

	Student login(DetachedCriteria criteria);

	int reqwd(DetachedCriteria criteria, String newStudentPassword);

	List<Student> query();

}

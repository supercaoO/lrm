package com.supercaoO.service;

import org.hibernate.criterion.DetachedCriteria;

import com.supercaoO.bean.Student;

public interface StudentService {

	void save(Student student, String projectId);

	Student login(DetachedCriteria criteria);

	int reqwd(DetachedCriteria criteria, String newStudentPassword);

}

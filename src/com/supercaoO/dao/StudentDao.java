package com.supercaoO.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.supercaoO.bean.Manager;
import com.supercaoO.bean.Project;
import com.supercaoO.bean.Student;

public interface StudentDao {

	void save(Student student, Project project);

	Student getStudentByIdAndPwd(DetachedCriteria criteria);

	List<Student> query();

}

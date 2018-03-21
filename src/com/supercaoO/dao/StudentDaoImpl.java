package com.supercaoO.dao;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.supercaoO.bean.Project;
import com.supercaoO.bean.Student;

public class StudentDaoImpl extends HibernateDaoSupport implements StudentDao {

	public void save(Student student, Project project) {
		this.getHibernateTemplate().save(student);
		student.getProjects().add(project);
	}

}

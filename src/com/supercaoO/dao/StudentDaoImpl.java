package com.supercaoO.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.supercaoO.bean.Manager;
import com.supercaoO.bean.Project;
import com.supercaoO.bean.Student;

public class StudentDaoImpl extends HibernateDaoSupport implements StudentDao {

	public void save(Student student, Project project) {
		this.getHibernateTemplate().save(student);
		student.getProjects().add(project);
	}

	public Student getStudentByIdAndPwd(DetachedCriteria criteria) {
		List<Student> list = (List<Student>) this.getHibernateTemplate().findByCriteria(criteria);
		if(list != null && list.size() == 1 )
			return list.get(0);
		return null;
	}

}

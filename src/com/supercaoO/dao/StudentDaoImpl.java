package com.supercaoO.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.supercaoO.bean.Manager;
import com.supercaoO.bean.Project;
import com.supercaoO.bean.Student;

public class StudentDaoImpl extends HibernateDaoSupport implements StudentDao {

	/**
	 * To save an appointed Student
	 * @return the Id of this Student saved
	 * @param student The Student to be save
	 */
	public int save(Student student) {
		return (int) this.getHibernateTemplate().save(student);
	}
	
	/**
	 * To delete the appointed Student
	 * @return if delete successfully, return 1, otherwise return -1
	 * @param student The Student to be deleted
	 */
	public int delete(Student student) {
		Student exitingStudent = this.getHibernateTemplate().get(Student.class, student.getStudentId());
		if(exitingStudent != null) {
			exitingStudent.setStudentStatus("0");
			return 1;
		}
		return -1;
	}
	
	/**
	 * To update the appointed Student
	 * @return if update successfully, return 1, otherwise return -1
	 * @param student The Student to be updated
	 */
	public int update(Student student) {
		Student exitingStudent = this.getHibernateTemplate().get(Student.class, student.getStudentId());
		if(exitingStudent != null) {
			student.setStudentStatus("1");
			this.getHibernateTemplate().update(student);
			return 1;
		}
		return -1;
	}
	
	/**
	 * To query Student by criteria
	 * @return query result
	 * @param criteria query criteria
	 */
	public List<Student> query(DetachedCriteria criteria) {
		return (List<Student>) this.getHibernateTemplate().findByCriteria(criteria);
	}
	
	/*public void save(Student student, Project project) {
		this.getHibernateTemplate().save(student);
		student.getProjects().add(project);
	}

	public Student getStudentByIdAndPwd(DetachedCriteria criteria) {
		List<Student> list = (List<Student>) this.getHibernateTemplate().findByCriteria(criteria);
		if(list != null && list.size() == 1 )
			return list.get(0);
		return null;
	}

	public List<Student> query() {
		List<Student> studentList = (List<Student>) this.getHibernateTemplate().find("from Student where studentStatus = ?", "1");
		return studentList;
	}*/

}

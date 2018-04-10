package com.supercaoO.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.supercaoO.bean.Page;
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
	
	/**
	 * To query Student by Page and criteria
	 * @return query result
	 * @param pageNumber the page number
	 * @param pageSize the size of page
	 * @param criteria query criteria
	 */
	public Page<Student> queryByPage(Integer pageNumber, Integer pageSize, DetachedCriteria criteria) {
		Page<Student> studentPage = new Page<Student>();
		studentPage.setPageNumber(pageNumber);
		studentPage.setPageSize(pageSize);
		
		//查询数据总条数
		criteria.setProjection(Projections.rowCount());
		List<Number> numList = (List<Number>) this.getHibernateTemplate().findByCriteria(criteria);
		if(numList != null && numList.size() > 0){
			int total = numList.get(0).intValue();
			studentPage.setTotal(total);
		}
		criteria.setProjection(null);
		
		//分页查询
		List<Student> studentList = (List<Student>) this.getHibernateTemplate().findByCriteria(criteria, (pageNumber - 1) * pageSize, pageSize);
		studentPage.setPages(studentList);
		return studentPage;
	}
}

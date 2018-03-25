package com.supercaoO.web;

import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.caoO.encryption.MD5;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import com.supercaoO.bean.Manager;
import com.supercaoO.bean.Project;
import com.supercaoO.bean.Student;
import com.supercaoO.service.StudentService;

public class StudentAction extends ActionSupport implements ModelDriven<Student> {
	
	private static final long serialVersionUID = 7625923638258068941L;
	
	private StudentService studentService;
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	private Student student = new Student();
	public Student getModel() {
		return student;
	}
	
	public String save() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Project.class);
		Integer projectId = Integer.valueOf(ServletActionContext.getRequest().getParameter("projectId"));
		criteria.add(Restrictions.eq("projectId", projectId));
		student.setStudentStatus("1");
		student.setStudentPassword(MD5.encrypt("123456"));
		studentService.save(student, criteria);
		return "studentSaveDone";
	}
	
	/*public String login() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Student.class);
		if(student != null) {
			criteria.add(Restrictions.eq("studentId", student.getStudentId()));
			criteria.add(Restrictions.eq("studentPassword", student.getStudentPassword()));
			criteria.add(Restrictions.eq("studentStatus", "1"));
			Student student = studentService.login(criteria);
			if (student != null) {
				ServletActionContext.getRequest().getSession().setAttribute("student", student);
				return SUCCESS;
			}
		}
		return "studentLogin";
	}
	
	public String save() {
		String projectId = ServletActionContext.getRequest().getParameter("projectId");
		String studentId = ServletActionContext.getRequest().getParameter("studentId");
		student.setStudentId(Integer.valueOf(studentId));
		student.setStudentPassword("123456");
		student.setStudentStatus("1");
		studentService.save(student, projectId);
		return "saveSuccess";
	}
	
	
	public String query() {
		List<Student> studentList = studentService.query();
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		valueStack.set("studentList", studentList);
		return "queryDone";
	}
	
	public String list() {
		query();
		return "listDone";
	}
	
	public String repwd() {
		String newStudentPassword = ServletActionContext.getRequest().getParameter("newStudentPassword");
		String confirmStudentPassword = ServletActionContext.getRequest().getParameter("confirmStudentPassword");
		if ( !newStudentPassword.equals(confirmStudentPassword) ) {
			return "repwd";
		} else {
			DetachedCriteria criteria = DetachedCriteria.forClass(Student.class);
			criteria.add(Restrictions.eq("studentId", student.getStudentId()));
			criteria.add(Restrictions.eq("studentPassword", student.getStudentPassword()));
			int i = studentService.reqwd(criteria, newStudentPassword);
			if (i == 1) {
				ActionContext.getContext().getSession().remove("student");
				return "repwdSuccess";
			}
			else
				return "repwd";
		}
	}*/

}

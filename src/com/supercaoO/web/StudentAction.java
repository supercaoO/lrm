package com.supercaoO.web;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.supercaoO.bean.Student;
import com.supercaoO.service.StudentService;

public class StudentAction extends ActionSupport implements ModelDriven<Student> {
	private StudentService studentService;
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	private Student student = new Student();
	public Student getModel() {
		return student;
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

}

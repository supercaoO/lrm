package com.supercaoO.web;

import java.io.UnsupportedEncodingException;
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
import com.supercaoO.bean.Page;
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
	
	private Integer pageNumber = 1;
	public void setPageNumber(Integer pageNumber) {
		if(pageNumber == null){
			pageNumber = 1;
		}
		this.pageNumber = pageNumber;
	}
	
	private Integer pageSize = 10;
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
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
	
	public String list() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Student.class);
		criteria.add(Restrictions.eq("studentStatus", "1"));
		List<Student> studentList = studentService.list(criteria);
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		valueStack.set("studentList", studentList);
		return ServletActionContext.getRequest().getParameter("operation");
	}
	
	public String queryByPage() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Student.class);
		criteria.add(Restrictions.eq("studentStatus", "1"));
		Page<Student> studentPage = studentService.queryByPage(pageNumber, pageSize, criteria);
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.set("studentPage", studentPage);
		int[] pageNums = new int[studentPage.getPageCount()];
		for(int i = 0; i < pageNums.length; i++) {
			pageNums[i] = i + 1;
		}
		vs.set("pageNums", pageNums);
		return ServletActionContext.getRequest().getParameter("operation");
	}
	
	public String delete() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Student.class);
		String studentId = ServletActionContext.getRequest().getParameter("studentId");
		try {
			studentId = new String(studentId.getBytes("iso-8859-1"), "utf-8");
			criteria.add(Restrictions.eq("studentId", Integer.valueOf(studentId)));
			studentService.delete(criteria);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		queryByPage();
		return "studentList";
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

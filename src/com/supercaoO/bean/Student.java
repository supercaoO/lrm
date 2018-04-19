package com.supercaoO.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Student Bean
 * @author caoO
 *
 */
public class Student {
	/// the ID
	private Integer studentId;
	/// the name
	private String studentName;
	/// the password
	private String studentPassword;
	/// the status
	private String studentStatus;
	/// the participating projects
	private Set<Project> projects = new HashSet<Project>();
	
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentPassword() {
		return studentPassword;
	}
	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}
	public String getStudentStatus() {
		return studentStatus;
	}
	public void setStudentStatus(String studentStatus) {
		this.studentStatus = studentStatus;
	}
	public Set<Project> getProjects() {
		return projects;
	}
	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

}

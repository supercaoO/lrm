package com.supercaoO.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Project Bean
 * @author caoO
 *
 */
public class Project {
	/// the ID
	private Integer projectId;
	/// the name
	private String projectName;
	/// the introduction
	private String projectIntro;
	/// the status
	private String projectStatus;
	/// the date last committed
	private String lastCommitDate;
	/// the manager belonged
	private Manager manager;
	/// the participating students
	private Set<Student> students = new HashSet<Student>();
	
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectStatus() {
		return projectStatus;
	}
	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}
	public String getProjectIntro() {
		return projectIntro;
	}
	public void setProjectIntro(String projectIntro) {
		this.projectIntro = projectIntro;
	}
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	public String getLastCommitDate() {
		return lastCommitDate;
	}
	public void setLastCommitDate(String lastCommitDate) {
		this.lastCommitDate = lastCommitDate;
	}
	
}

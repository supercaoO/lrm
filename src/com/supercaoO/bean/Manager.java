package com.supercaoO.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Manager Bean
 * @author caoO
 *
 */
public class Manager {
	/// the ID
	private Integer managerId;
	/// the name
	private String managerName;
	/// the password
	private String managerPassword;
	/// the status
	private String managerStatus;
	/// the file path of head image
	private String headImgPath;
	/// the projects managed
	private Set<Project> projects = new HashSet<Project>();
	
	public Integer getManagerId() {
		return managerId;
	}
	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerPassword() {
		return managerPassword;
	}
	public void setManagerPassword(String managerPassword) {
		this.managerPassword = managerPassword;
	}
	public String getManagerStatus() {
		return managerStatus;
	}
	public String getHeadImgPath() {
		return headImgPath;
	}
	public void setHeadImgPath(String headImgPath) {
		this.headImgPath = headImgPath;
	}
	public void setManagerStatus(String managerStatus) {
		this.managerStatus = managerStatus;
	}
	public Set<Project> getProjects() {
		return projects;
	}
	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

}

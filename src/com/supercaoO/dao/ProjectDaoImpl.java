package com.supercaoO.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.supercaoO.bean.Page;
import com.supercaoO.bean.Project;

public class ProjectDaoImpl extends HibernateDaoSupport implements ProjectDao {

	/**
	 * To save an appointed Project
	 * @return the Id of this Project saved
	 * @param project The Project to be save
	 */
	public int save(Project project) {
		return (int) this.getHibernateTemplate().save(project);
	}
	
	/**
	 * To delete the appointed Project
	 * @return if delete successfully, return 1, otherwise return -1
	 * @param project The Project to be deleted
	 */
	public int delete(Project project) {
		Project exitingProject = this.getHibernateTemplate().get(Project.class, project.getProjectId());
		if(exitingProject != null) {
			exitingProject.setProjectStatus("0");
			return 1;
		}
		return -1;
	}
	
	/**
	 * To update the appointed Project
	 * @return if update successfully, return 1, otherwise return -1
	 * @param project The Project to be updated
	 */
	public int update(Project project) {
		Project exitingProject = this.getHibernateTemplate().get(Project.class, project.getProjectId());
		if(exitingProject != null) {
			this.getHibernateTemplate().update(exitingProject);
			return 1;
		}
		return -1;
	}
	
	/**
	 * To query Project by criteria
	 * @return query result
	 * @param criteria query criteria
	 */
	public List<Project> query(DetachedCriteria criteria){
		return (List<Project>) this.getHibernateTemplate().findByCriteria(criteria);
	}

	/**
	 * To query Project by Page and criteria
	 * @return query result
	 * @param pageNumber the page number
	 * @param pageSize the size of one page
	 * @param criteria query criteria
	 */
	public Page<Project> queryByPage(Integer pageNumber, Integer pageSize, DetachedCriteria criteria) {
		Page<Project> projectPage = new Page<Project>();
		projectPage.setPageNumber(pageNumber);
		projectPage.setPageSize(pageSize);
		
		//查询数据总条数
		criteria.setProjection(Projections.rowCount());
		List<Number> numList = (List<Number>) this.getHibernateTemplate().findByCriteria(criteria);
		if(numList != null && numList.size() > 0){
			int total = numList.get(0).intValue();
			projectPage.setTotal(total);
		}
		criteria.setProjection(null);
		
		//分页查询
		List<Project> projectList = (List<Project>) this.getHibernateTemplate().findByCriteria(criteria, (pageNumber - 1) * pageSize, pageSize);
		projectPage.setPages(projectList);
		return projectPage;
	}
}

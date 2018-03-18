package com.supercaoO.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.supercaoO.bean.Manager;

public interface ManagerDao {

	List<Manager> getManagerByIdAndPwd(DetachedCriteria criteria);

}

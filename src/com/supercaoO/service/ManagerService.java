package com.supercaoO.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.supercaoO.bean.Manager;

public interface ManagerService {

	List<Manager> login(DetachedCriteria criteria);

}

package com.cts.revenueforecast.dao;

import java.util.List;

import com.cts.revenueforecast.model.ProjectList;

public interface IProjectListDAO {

	public int storeProjectList(List<ProjectList> pll);
	public List<ProjectList> viewProjectList();

}
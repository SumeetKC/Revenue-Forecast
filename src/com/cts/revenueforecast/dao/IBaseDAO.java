package com.cts.revenueforecast.dao;

import java.util.List;
import java.util.Map;

import com.cts.revenueforecast.model.Base;
import com.cts.revenueforecast.model.ProjectForm;

public interface IBaseDAO {

	/* List<Base> retrieveBaseDetailsList(); */
	Map<String, String> retrieveAllProjectIds();

	List<Base> retrieveBaseRecordsByProjectId(String pid);

	Map<String, String> retrieveAllProjectManagerIds();

	List<Base> retrieveBaseRecordsByProjectManagerId(String pmid);

	Map<String, String> retrieveNewAddedEmployees(String datestamp);

	List<Base> retrieveBaseDetailsList(String datestamp);
	
	public List<Base> retrieveBaseDetailsListForExcel();

	/* List<String> retrieveTerminatedEmployees(String datestamp); */

	List<Base> viewBaseDetailsList();

	int movebasetohistory();

	List<ProjectForm> retrieveAllProject();

	List<ProjectForm> retrieveProject(String projectId);

	int updateProject(ProjectForm projectForm);

	int addNewProject(ProjectForm projectForm);

}

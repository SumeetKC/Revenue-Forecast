package com.cts.revenueforecast.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cts.revenueforecast.dao.IBaseDAO;
import com.cts.revenueforecast.model.ProjectForm;
import com.cts.revenueforecast.model.Projects;

@Controller
public class ProjectController {

	private Logger logger = Logger.getLogger(ProjectController.class.getName());

	@Autowired
	IBaseDAO iBaseDao;

	@RequestMapping("/view_up_pls")
	public String viewstoreProjectList() {
		return "projectlistuploadformview";
	}

	@RequestMapping("/view_update_pl")
	public ModelAndView viewupdateProjectList() {
		ModelAndView modelAndView = new ModelAndView();
		try {
			modelAndView.setViewName("viewupdateproject");
			List<ProjectForm> projectList = iBaseDao.retrieveAllProject();
			Projects projects = new Projects();
			projects.setProj(projectList);
			modelAndView.addObject("projects", projects);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Exception Occured", e);
			return new ModelAndView("error", "message", "Some Error Occurred");
		}

		return modelAndView;
	}

	public void setiBaseDao(IBaseDAO iBaseDao) {
		this.iBaseDao = iBaseDao;
	}

	@RequestMapping("/updateproject")
	public ModelAndView updateProject(String projectid) {

		ModelAndView modelAndView = new ModelAndView();
		try {
			List<ProjectForm> projectList = iBaseDao.retrieveProject(projectid);
			if (projectList.size() > 1) {
				// modelAndView.setViewName("updateproject");
				// more than one project exist with the same project id
			} else if (projectList.size() == 1) {

				modelAndView.setViewName("updateproject");
				for (ProjectForm projForm : projectList) {
					modelAndView.addObject("project", projForm.getProject());
					modelAndView.addObject("description", projForm.getDescription());
					modelAndView.addObject("pmID", projForm.getPmID());
					modelAndView.addObject("pmName", projForm.getPmName());
					modelAndView.addObject("new_rate_applies", projForm.getNew_rate_applies());

					modelAndView.addObject("project_ID_text", projForm.getProject_ID_text());
					modelAndView.addObject("type", projForm.getType());
					modelAndView.addObject("am", projForm.getAm());
					modelAndView.addObject("em", projForm.getEm());
					modelAndView.addObject("svp", projForm.getSvp());

					modelAndView.addObject("vpit", projForm.getVpit());
					modelAndView.addObject("forecastPoCID", projForm.getForecastPoCID());
					modelAndView.addObject("soW", projForm.getSoW());
					modelAndView.addObject("soW_Number", projForm.getSoW_Number());
					modelAndView.addObject("onsitePoC", projForm.getOnsitePoC());

					modelAndView.addObject("offshorePoC", projForm.getOffshorePoC());
					modelAndView.addObject("discount", projForm.getDiscount());
					modelAndView.addObject("datestamp", projForm.getDatestamp());
					modelAndView.addObject("billingin", projForm.getBillingin());

				}
			}
			Projects projects = new Projects();
			projects.setProj(projectList);
			modelAndView.addObject("projects", projects);

			modelAndView.setViewName("updateproject");

		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Exception Occured", e);
			return new ModelAndView("error", "message", "Some Error Occured");
		}

		return modelAndView;
	}

	@RequestMapping("/saveproject")
	public ModelAndView saveProjectDetails(@ModelAttribute("saveprojectdetails") ProjectForm saveprojectdetails) {
		ModelAndView modelAndView = new ModelAndView();
		try {

			modelAndView.setViewName("viewupdateproject");
			iBaseDao.updateProject(saveprojectdetails);
		} catch (Exception e) {
			logger.error("Exception Occured", e);
			return new ModelAndView("error", "message", "Some Error Occured");
		}

		return modelAndView;

	}

	@RequestMapping("/addnewproject")
	public ModelAndView addNewProject() {
		ModelAndView modelAndView = new ModelAndView();
		logger.info("Start of add new Project");
		try {
			Map<String, String> pms = iBaseDao.retrieveAllProjectManagerIds();
			modelAndView.addObject("pms", pms);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Exception Occured", e);
			return new ModelAndView("error", "message", "Some Error Occured");
		}
		modelAndView.setViewName("addnewproject");

		return modelAndView;

	}

	@RequestMapping("/addNewProjectDetails")
	public ModelAndView addNewProjectDetails(@ModelAttribute("addnewproject") ProjectForm addnewProject) {
		ModelAndView modelAndView = new ModelAndView();
		logger.info("Start of add new Project - after clicking submit");
		List<ProjectForm> projectList = iBaseDao.retrieveProject(addnewProject.getProject());
		if (projectList.size() >= 1) {
			modelAndView.setViewName("addnewproject");
			logger.error("Project Id already exist in DB.. Please enter correct project details..");
			// more than one project exist with the same project id
			// System.out.println("Project Id already exist in DB.. Please enter
			// correct project details..");

			modelAndView.addObject("projectExistInDB",
					"Project Id already exist in DB.. Please enter correct project details..");

		} else {
			modelAndView.setViewName("viewupdateproject");
			iBaseDao.addNewProject(addnewProject);
			logger.info("Project added successfully");
		}

		return modelAndView;

	}
}

package com.cts.revenueforecast.model;

import java.util.List;

public class ProjectList {
	String Project, Description, PM_ID, PM_Name, New_rate_applies, Project_ID_text, Type, AM, EM, SVP, VP_IT,
			Forecast_PoC_ID, SoW, SoW_Number, Onsite_PoC, Offshore_PoC, Discount, Datestamp, Billing_in;
	public ProjectList(){
		
	}
	public ProjectList(String project, String description, String pM_ID, String pM_Name, String new_rate_applies,
			String project_ID_text, String type, String aM, String eM, String sVP, String vP_IT, String forecast_PoC_ID,
			String soW, String soW_Number, String onsite_PoC, String offshore_PoC, String discount, String datestamp,
			String billing_in) {
		super();
		Project = project;
		Description = description;
		PM_ID = pM_ID;
		PM_Name = pM_Name;
		New_rate_applies = new_rate_applies;
		Project_ID_text = project_ID_text;
		Type = type;
		AM = aM;
		EM = eM;
		SVP = sVP;
		VP_IT = vP_IT;
		Forecast_PoC_ID = forecast_PoC_ID;
		SoW = soW;
		SoW_Number = soW_Number;
		Onsite_PoC = onsite_PoC;
		Offshore_PoC = offshore_PoC;
		Discount = discount;
		Datestamp = datestamp;
		Billing_in = billing_in;
	}

	public String getProject() {
		return Project;
	}

	public void setProject(String project) {
		Project = project;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getPM_ID() {
		return PM_ID;
	}

	public void setPM_ID(String pM_ID) {
		PM_ID = pM_ID;
	}

	public String getPM_Name() {
		return PM_Name;
	}

	public void setPM_Name(String pM_Name) {
		PM_Name = pM_Name;
	}

	public String getNew_rate_applies() {
		return New_rate_applies;
	}

	public void setNew_rate_applies(String new_rate_applies) {
		New_rate_applies = new_rate_applies;
	}

	public String getProject_ID_text() {
		return Project_ID_text;
	}

	public void setProject_ID_text(String project_ID_text) {
		Project_ID_text = project_ID_text;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getAM() {
		return AM;
	}

	public void setAM(String aM) {
		AM = aM;
	}

	public String getEM() {
		return EM;
	}

	public void setEM(String eM) {
		EM = eM;
	}

	public String getSVP() {
		return SVP;
	}

	public void setSVP(String sVP) {
		SVP = sVP;
	}

	public String getVP_IT() {
		return VP_IT;
	}

	public void setVP_IT(String vP_IT) {
		VP_IT = vP_IT;
	}

	public String getForecast_PoC_ID() {
		return Forecast_PoC_ID;
	}

	public void setForecast_PoC_ID(String forecast_PoC_ID) {
		Forecast_PoC_ID = forecast_PoC_ID;
	}

	public String getSoW() {
		return SoW;
	}

	public void setSoW(String soW) {
		SoW = soW;
	}

	public String getSoW_Number() {
		return SoW_Number;
	}

	public void setSoW_Number(String soW_Number) {
		SoW_Number = soW_Number;
	}

	public String getOnsite_PoC() {
		return Onsite_PoC;
	}

	public void setOnsite_PoC(String onsite_PoC) {
		Onsite_PoC = onsite_PoC;
	}

	public String getOffshore_PoC() {
		return Offshore_PoC;
	}

	public void setOffshore_PoC(String offshore_PoC) {
		Offshore_PoC = offshore_PoC;
	}

	public String getDiscount() {
		return Discount;
	}

	public void setDiscount(String discount) {
		Discount = discount;
	}

	public String getDatestamp() {
		return Datestamp;
	}

	public void setDatestamp(String datestamp) {
		Datestamp = datestamp;
	}

	public String getBilling_in() {
		return Billing_in;
	}

	public void setBilling_in(String billing_in) {
		Billing_in = billing_in;
	}

	public ProjectList(List<String> celldata) {
		super();
		this.Project = celldata.get(0);
		this.Description = celldata.get(1);
		this.PM_ID = celldata.get(2);
		this.PM_Name = celldata.get(3);
		this.New_rate_applies = celldata.get(4);
		this.Project_ID_text = celldata.get(5);
		this.Type = celldata.get(6);
		this.AM = celldata.get(7);
		this.EM = celldata.get(8);
		this.SVP = celldata.get(9);
		this.VP_IT = celldata.get(10);
		this.Forecast_PoC_ID = celldata.get(11);
		this.SoW = celldata.get(12);
		this.SoW_Number = celldata.get(13);
		this.Onsite_PoC = celldata.get(14);
		this.Offshore_PoC = celldata.get(15);
		this.Discount = celldata.get(16);
		;
		this.Datestamp = celldata.get(17);
		;
		this.Billing_in = celldata.get(18);
		;

	}

	public Object[] getObjectAsArray() {
		return new Object[] { Project, Description, PM_ID, PM_Name, New_rate_applies, Project_ID_text, Type, AM, EM,
				SVP, VP_IT, Forecast_PoC_ID, SoW, SoW_Number, Onsite_PoC, Offshore_PoC, Discount, Datestamp,
				Billing_in };
	}

}

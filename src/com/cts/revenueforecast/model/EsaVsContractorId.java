package com.cts.revenueforecast.model;

import java.util.List;

public class EsaVsContractorId {
	private String associate_id,ce_id,contractor_number,contractor_text,associate_name,contractor_name;

	public EsaVsContractorId(String associate_id, String ce_id, String contractor_number, String contractor_text,
			String associate_name, String contractor_name) {
		super();
		this.associate_id = associate_id;
		this.ce_id = ce_id;
		this.contractor_number = contractor_number;
		this.contractor_text = contractor_text;
		this.associate_name = associate_name;
		this.contractor_name = contractor_name;
	}

	public EsaVsContractorId() {
		super();
	}

	public String getAssociate_id() {
		return associate_id;
	}

	public void setAssociate_id(String associate_id) {
		this.associate_id = associate_id;
	}

	public String getCe_id() {
		return ce_id;
	}

	public void setCe_id(String ce_id) {
		this.ce_id = ce_id;
	}

	public String getContractor_number() {
		return contractor_number;
	}

	public void setContractor_number(String contractor_number) {
		this.contractor_number = contractor_number;
	}

	public String getContractor_text() {
		return contractor_text;
	}

	public void setContractor_text(String contractor_text) {
		this.contractor_text = contractor_text;
	}

	public String getAssociate_name() {
		return associate_name;
	}

	public void setAssociate_name(String associate_name) {
		this.associate_name = associate_name;
	}

	public String getContractor_name() {
		return contractor_name;
	}

	public void setContractor_name(String contractor_name) {
		this.contractor_name = contractor_name;
	}

	public Object[] getObjectArray() {
		return new Object[]{associate_id,ce_id,contractor_number,contractor_text,associate_name,contractor_name}; 
	}

	public EsaVsContractorId(List<String> vl){
		this.associate_id=vl.get(0);
		this.ce_id=vl.get(1);
		this.contractor_number=vl.get(2);
		this.contractor_text=vl.get(3);
		this.associate_name=vl.get(4);
		this.contractor_name=vl.get(5);
	}
	

}

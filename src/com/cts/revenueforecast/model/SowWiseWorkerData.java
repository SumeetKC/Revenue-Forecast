package com.cts.revenueforecast.model;

import java.util.List;

public class SowWiseWorkerData {
	String Contractor_ID, Statement_Work, Worker_Status, Worker_ID, Worker, SOW_Worker_Role, Worker_End_Date,
			Current_Bill_Rate_ST_Hr, Worker_Start_Date, Latest_Work_Order;

	public SowWiseWorkerData(String contractor_ID, String statement_Work, String worker_Status, String worker_ID,
			String worker, String sOW_Worker_Role, String worker_End_Date, String current_Bill_Rate_ST_Hr,
			String worker_Start_Date, String latest_Work_Order) {
		super();
		Contractor_ID = contractor_ID;
		Statement_Work = statement_Work;
		Worker_Status = worker_Status;
		Worker_ID = worker_ID;
		Worker = worker;
		SOW_Worker_Role = sOW_Worker_Role;
		Worker_End_Date = worker_End_Date;
		Current_Bill_Rate_ST_Hr = current_Bill_Rate_ST_Hr;
		Worker_Start_Date = worker_Start_Date;
		Latest_Work_Order = latest_Work_Order;
	}

	public String getContractor_ID() {
		return Contractor_ID;
	}

	public void setContractor_ID(String contractor_ID) {
		Contractor_ID = contractor_ID;
	}

	public String getStatement_Work() {
		return Statement_Work;
	}

	public void setStatement_Work(String statement_Work) {
		Statement_Work = statement_Work;
	}

	public String getWorker_Status() {
		return Worker_Status;
	}

	public void setWorker_Status(String worker_Status) {
		Worker_Status = worker_Status;
	}

	public String getWorker_ID() {
		return Worker_ID;
	}

	public void setWorker_ID(String worker_ID) {
		Worker_ID = worker_ID;
	}

	public String getWorker() {
		return Worker;
	}

	public void setWorker(String worker) {
		Worker = worker;
	}

	public String getSOW_Worker_Role() {
		return SOW_Worker_Role;
	}

	public void setSOW_Worker_Role(String sOW_Worker_Role) {
		SOW_Worker_Role = sOW_Worker_Role;
	}

	public String getWorker_End_Date() {
		return Worker_End_Date;
	}

	public void setWorker_End_Date(String worker_End_Date) {
		Worker_End_Date = worker_End_Date;
	}

	public String getCurrent_Bill_Rate_ST_Hr() {
		return Current_Bill_Rate_ST_Hr;
	}

	public void setCurrent_Bill_Rate_ST_Hr(String current_Bill_Rate_ST_Hr) {
		Current_Bill_Rate_ST_Hr = current_Bill_Rate_ST_Hr;
	}

	public String getWorker_Start_Date() {
		return Worker_Start_Date;
	}

	public void setWorker_Start_Date(String worker_Start_Date) {
		Worker_Start_Date = worker_Start_Date;
	}

	public String getLatest_Work_Order() {
		return Latest_Work_Order;
	}

	public void setLatest_Work_Order(String latest_Work_Order) {
		Latest_Work_Order = latest_Work_Order;
	}
	
	public Object[] getObjectAsArray()
	{
		return new Object[]{Contractor_ID, Statement_Work, Worker_Status, Worker_ID, Worker, SOW_Worker_Role, Worker_End_Date,
				Current_Bill_Rate_ST_Hr, Worker_Start_Date, Latest_Work_Order};
	}
	
	public SowWiseWorkerData(List<String> celldata)
	{
		this.Contractor_ID = celldata.get(0);
		this.Statement_Work = celldata.get(1);
		this.Worker_Status = celldata.get(2);
		this.Worker_ID = celldata.get(3);
		this.Worker = celldata.get(4);
		this.SOW_Worker_Role = celldata.get(5);
		this.Worker_End_Date = celldata.get(6);
		this.Current_Bill_Rate_ST_Hr = celldata.get(7);
		this.Worker_Start_Date = celldata.get(8);
		this.Latest_Work_Order = celldata.get(9);
	}

}

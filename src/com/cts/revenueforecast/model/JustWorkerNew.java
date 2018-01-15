package com.cts.revenueforecast.model;

import java.util.List;

public class JustWorkerNew {
	String Contractor_ID, Worker_End_Date, Current_Bill_Rate_day, Current_Bill_Rate_Hr, Current_Bill_Rate_Mo,
			Current_Bill_Rate_OT_Hr, Worker_Status, Worker_ID, Worker, Work_Order_Status, Work_Order_ID,
			Latest_Work_Order;

	public JustWorkerNew(String contractor_ID, String worker_End_Date, String current_Bill_Rate_day,
			String current_Bill_Rate_Hr, String current_Bill_Rate_Mo, String current_Bill_Rate_OT_Hr,
			String worker_Status, String worker_ID, String worker, String work_Order_Status, String work_Order_ID,
			String latest_Work_Order) {
		super();
		Contractor_ID = contractor_ID;
		Worker_End_Date = worker_End_Date;
		Current_Bill_Rate_day = current_Bill_Rate_day;
		Current_Bill_Rate_Hr = current_Bill_Rate_Hr;
		Current_Bill_Rate_Mo = current_Bill_Rate_Mo;
		Current_Bill_Rate_OT_Hr = current_Bill_Rate_OT_Hr;
		Worker_Status = worker_Status;
		Worker_ID = worker_ID;
		Worker = worker;
		Work_Order_Status = work_Order_Status;
		Work_Order_ID = work_Order_ID;
		Latest_Work_Order = latest_Work_Order;
	}

	public String getContractor_ID() {
		return Contractor_ID;
	}

	public void setContractor_ID(String contractor_ID) {
		Contractor_ID = contractor_ID;
	}

	public String getWorker_End_Date() {
		return Worker_End_Date;
	}

	public void setWorker_End_Date(String worker_End_Date) {
		Worker_End_Date = worker_End_Date;
	}

	public String getCurrent_Bill_Rate_day() {
		return Current_Bill_Rate_day;
	}

	public void setCurrent_Bill_Rate_day(String current_Bill_Rate_day) {
		Current_Bill_Rate_day = current_Bill_Rate_day;
	}

	public String getCurrent_Bill_Rate_Hr() {
		return Current_Bill_Rate_Hr;
	}

	public void setCurrent_Bill_Rate_Hr(String current_Bill_Rate_Hr) {
		Current_Bill_Rate_Hr = current_Bill_Rate_Hr;
	}

	public String getCurrent_Bill_Rate_Mo() {
		return Current_Bill_Rate_Mo;
	}

	public void setCurrent_Bill_Rate_Mo(String current_Bill_Rate_Mo) {
		Current_Bill_Rate_Mo = current_Bill_Rate_Mo;
	}

	public String getCurrent_Bill_Rate_OT_Hr() {
		return Current_Bill_Rate_OT_Hr;
	}

	public void setCurrent_Bill_Rate_OT_Hr(String current_Bill_Rate_OT_Hr) {
		Current_Bill_Rate_OT_Hr = current_Bill_Rate_OT_Hr;
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

	public String getWork_Order_Status() {
		return Work_Order_Status;
	}

	public void setWork_Order_Status(String work_Order_Status) {
		Work_Order_Status = work_Order_Status;
	}

	public String getWork_Order_ID() {
		return Work_Order_ID;
	}

	public void setWork_Order_ID(String work_Order_ID) {
		Work_Order_ID = work_Order_ID;
	}

	public String getLatest_Work_Order() {
		return Latest_Work_Order;
	}

	public void setLatest_Work_Order(String latest_Work_Order) {
		Latest_Work_Order = latest_Work_Order;
	}

	public JustWorkerNew(List<String> celldata) {
		super();
		this.Contractor_ID = celldata.get(0);
		this.Worker_End_Date = celldata.get(1);
		this.Current_Bill_Rate_day = celldata.get(2);
		this.Current_Bill_Rate_Hr = celldata.get(3);
		this.Current_Bill_Rate_Mo = celldata.get(4);
		this.Current_Bill_Rate_OT_Hr = celldata.get(5);
		this.Worker_Status = celldata.get(6);
		this.Worker_ID = celldata.get(7);
		this.Worker = celldata.get(8);
		this.Work_Order_Status = celldata.get(9);
		this.Work_Order_ID = celldata.get(10);
		this.Latest_Work_Order = celldata.get(11);

	}
	
	public Object[] getObjectAsArray()
	{
		return new Object[]{Contractor_ID, Worker_End_Date, Current_Bill_Rate_day, Current_Bill_Rate_Hr, Current_Bill_Rate_Mo,
				Current_Bill_Rate_OT_Hr, Worker_Status, Worker_ID, Worker, Work_Order_Status, Work_Order_ID,
				Latest_Work_Order};
	}

}

package com.cts.revenueforecast.dao;

import java.util.List;

import com.cts.revenueforecast.model.HolidayList;

public interface IHolidayListDAO {
	int storeHolidayList(List<HolidayList> parseExcel);
	List<HolidayList> viewHolidayList();
}

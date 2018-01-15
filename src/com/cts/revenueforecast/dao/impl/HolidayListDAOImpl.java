package com.cts.revenueforecast.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cts.revenueforecast.dao.IHolidayListDAO;
import com.cts.revenueforecast.model.HolidayList;

@Repository
public class HolidayListDAOImpl implements IHolidayListDAO{

	@Override
	public int storeHolidayList(List<HolidayList> hl) {
		return 0;
	}

	@Override
	public List<HolidayList> viewHolidayList() {
		// TODO Auto-generated method stub
		return null;
	}

}

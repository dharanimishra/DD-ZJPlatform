package com.ziksana.service.calendar;

import java.util.List;

import com.ziksana.domain.calendar.Calendar;
public interface ICalendarService {
	
	public List<Calendar> getAllCalenderEvents();
	
	public List<Calendar> getTodayCalenderEvents(int pageIndex, int itemsPerPage);

	public void updateCalendarInfo(Calendar cal);

	public void deleteCalendarInfo(Integer id);

	public void saveCalendarObject(Calendar cal);

	public int getCalendarSize();
	
}

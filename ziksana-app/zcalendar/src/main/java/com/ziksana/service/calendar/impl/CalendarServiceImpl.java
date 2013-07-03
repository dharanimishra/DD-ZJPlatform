package com.ziksana.service.calendar.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziksana.domain.calendar.Calendar;
import com.ziksana.persistence.calendar.CalendarMapper;
import com.ziksana.security.util.SecurityTokenUtil;
import com.ziksana.service.calendar.ICalendarService;


@Service
public class CalendarServiceImpl implements ICalendarService {


	@Autowired
	CalendarMapper calenderMapper;
	
	public List<Calendar> getAllCalenderEvents() {
		
		return calenderMapper.getAllCalenderEvents();
	}

	public void updateCalendarInfo(Calendar cal) {
		calenderMapper.updateCalendarInfo(cal);
		
	}

	public void deleteCalendarInfo(Integer id) {
		calenderMapper.deleteCalendarInfo( id);
		
	}

	public void saveCalendarObject(Calendar cal) {
		calenderMapper.saveCalendarObject(cal);
		
	}

	public List<Calendar> getTodayCalenderEvents(int pageIndex, int itemsPerPage) {
		// TODO Auto-generated method stub
		return calenderMapper.getTodayCalenderEvents(Integer.valueOf(SecurityTokenUtil.getToken().getMemberPersonaId().getStorageID()),pageIndex,itemsPerPage);
	}

	public int getCalendarSize() {
		// TODO Auto-generated method stub
		return calenderMapper.getTodayCalendarSize(Integer.valueOf(SecurityTokenUtil.getToken().getMemberPersonaId().getStorageID()));
	}
	
	

}

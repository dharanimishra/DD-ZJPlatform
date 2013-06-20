package com.ziksana.persistence.calendar;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.ziksana.domain.calendar.Calendar;

public interface CalendarMapper {
	
	@Select({
	"select eventid,eventname,startdate,enddate from events" })
	@Results(value = {
	@Result(property = "eventId", column = "eventid"),
	@Result(property = "eventName", column = "eventname"),
	@Result(property = "startDate", column = "startdate"),
	@Result(property = "endDate", column = "enddate")
 })
	public List<Calendar> getAllCalenderEvents();

	
	
	public List<Calendar> getTodayCalenderEvents(@Param("memberRoleId")int memberRoleId,@Param("pageIndex")int pageIndex,@Param("itemsPerPage")int itemsPerPage);
	
	public void updateCalendarInfo(Calendar cal);

	public void deleteCalendarInfo(Integer id);

	public void saveCalendarObject(Calendar cal);


	public int getTodayCalendarSize(int memberRoleId);
}

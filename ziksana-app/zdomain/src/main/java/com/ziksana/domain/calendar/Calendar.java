package com.ziksana.domain.calendar;

import java.util.Date;

/*
 * Calender Library
 * mvn install:install-file -Dfile=C:\Users\vtg-p13\Desktop\demoapp_spring\WEB-INF\lib\javaplanner-v1.2.jar -DgroupId=com.dhtmlx -DartifactId=javaplanner -Dversion=v1.2 -Dpackaging=jar
*/
public class Calendar {
	
	
	private int eventId;

	private String eventName;

	private Date startDate;

	private Date endDate;
	
	private String startTime;
	
	private String endTime;

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}

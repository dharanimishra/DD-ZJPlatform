package com.ziksana.domain.course;

import java.util.Date;
import java.util.List;

public class CourseCatalog {
	
	private String course;
	private Date startDate;
	private Date endDate;
	private String courseStatus;
	private Integer catalogItemId;
	private String module;
	private String chapter;
	private List<String> topicsList;
	
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getChapter() {
		return chapter;
	}
	public void setChapter(String chapter) {
		this.chapter = chapter;
	}
	public List<String> getTopicsList() {
		return topicsList;
	}
	public void setTopicsList(List<String> topicsList) {
		this.topicsList = topicsList;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getCourseStatus() {
		return courseStatus;
	}
	public void setCourseStatus(String courseStatus) {
		this.courseStatus = courseStatus;
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
	public Integer getCatalogItemId() {
		return catalogItemId;
	}
	public void setCatalogItemId(Integer catalogItemId) {
		this.catalogItemId = catalogItemId;
	}
	
	
	

}

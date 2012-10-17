package com.ziksana.domain.utils;

import com.ziksana.id.ZID;

public class Topic {

	private ZID    id;
	private String area;
	private String subject;
	private String topic;
	
	public Topic(ZID id, String area, String subject, String topic) {
		this.id      = id;
		this.area    = area;
		this.subject = subject;
		this.topic   = topic;
	}
	
	public void setArea(String area) {
		this.area = area;
	}
	
	public String getArea() {
		return area;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public String getTopic() {
		return topic;
	}
	
	public String toString() {
		return "Topic [" + topic + "]";
	}
}

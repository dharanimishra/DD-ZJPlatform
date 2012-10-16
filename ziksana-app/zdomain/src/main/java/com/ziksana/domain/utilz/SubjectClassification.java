package com.ziksana.domain.utilz;

import java.util.Date;
import java.util.List;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class SubjectClassification extends AuditHistory{

	public SubjectClassification(String subject, String area, String topic,
			Boolean active) {
		this.subject = subject;
		this.area = area;
		this.topic = topic;
		this.active = active;
	}

	public SubjectClassification() {
	}

	private ZID 		subjClassificationId;
	private Date 		creationDate		= null;
	private String 		area				= null;
	private String 		subject				= null;
	private String 		topic				= null;
	private Boolean 	active				= null;
	
	private List<String> areaList			= null;
	private List<String> subjectList		= null;
	private List<String> topicList			= null;

	
	public List<String> getAreaList() {
		return areaList;
	}
	public void setAreaList(List<String> areaList) {
		this.areaList = areaList;
	}
	public List<String> getSubjectList() {
		return subjectList;
	}
	public void setSubjectList(List<String> subjectList) {
		this.subjectList = subjectList;
	}
	public List<String> getTopicList() {
		return topicList;
	}
	public void setTopicList(List<String> topicList) {
		this.topicList = topicList;
	}

	/**
	 * @return the subjClassificationId
	 */
	public ZID getSubjClassificationId() {
		return subjClassificationId;
	}
	/**
	 * @param subjClassificationId the subjClassificationId to set
	 */
	public void setSubjClassificationId(ZID subjClassificationId) {
		this.subjClassificationId = subjClassificationId;
	}
	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * @return the area
	 */
	public String getArea() {
		return area;
	}
	/**
	 * @param area the area to set
	 */
	public void setArea(String area) {
		this.area = area;
	}
	/**
	 * @return the topic
	 */
	public String getTopic() {
		return topic;
	}
	/**
	 * @param topic the topic to set
	 */
	public void setTopic(String topic) {
		this.topic = topic;
	}
	/**
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "SubjectClassification [subject=" + subject + ", area=" + area
				+ ", topic=" + topic + ", active=" + active + "]";
	}
	
}
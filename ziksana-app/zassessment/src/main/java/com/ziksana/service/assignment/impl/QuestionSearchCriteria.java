package com.ziksana.service.assignment.impl;

import java.util.List;

import com.ziksana.domain.assessment.QuestionType;

/**
 * @author bhashasp
 */
public class QuestionSearchCriteria {
	
	private String 				name 			= null;
	private String 				area 			= null;
	private String 				subject 		= null;
	private String 				topic			= null;
	private List<QuestionType> 	questionTypes 	= null;
	private String				tags			= null;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the tags
	 */
	public String getTags() {
		return tags;
	}
	/**
	 * @param tags the tags to set
	 */
	public void setTags(String tags) {
		this.tags = tags;
	}					
	
	
	public void basicSearch(){
		if(name!=null){
			setName(name);
		}
	}

	public void advancedSearch(){
		if(name!=null){
			setName(name);
		}
		
	}
	/**
	 * @return the questionTypes
	 */
	public List<QuestionType> getQuestionTypes() {
		return questionTypes;
	}
	/**
	 * @param questionTypes the questionTypes to set
	 */
	public void setQuestionTypes(List<QuestionType> questionTypes) {
		this.questionTypes = questionTypes;
	}
}

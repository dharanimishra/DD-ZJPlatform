package com.ziksana.domain.course.subscription;

import java.util.Date;

import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class ParticipationStatistics {
	
	private ZID 				statisticsId;
	private Date 				creationDate 		= null;
	private ParamName 			paramName 			= null;
	private String 				paramValue			= null;
	private SubscriptionCourse 	subscriptionCourse 	= null;
	
	/**
	 * @return the statisticsId
	 */
	public ZID getStatisticsId() {
		return statisticsId;
	}
	/**
	 * @param statisticsId the statisticsId to set
	 */
	public void setStatisticsId(ZID statisticsId) {
		this.statisticsId = statisticsId;
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
	 * @return the paramName
	 */
	public ParamName getParamName() {
		return paramName;
	}
	/**
	 * @param paramName the paramName to set
	 */
	public void setParamName(ParamName paramName) {
		this.paramName = paramName;
	}
	/**
	 * @return the paramValue
	 */
	public String getParamValue() {
		return paramValue;
	}
	/**
	 * @param paramValue the paramValue to set
	 */
	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}
	/**
	 * @return the subscriptionCourse
	 */
	public SubscriptionCourse getSubscriptionCourse() {
		return subscriptionCourse;
	}
	/**
	 * @param subscriptionCourse the subscriptionCourse to set
	 */
	public void setSubscriptionCourse(SubscriptionCourse subscriptionCourse) {
		this.subscriptionCourse = subscriptionCourse;
	}


}

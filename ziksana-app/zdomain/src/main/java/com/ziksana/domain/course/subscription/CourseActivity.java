package com.ziksana.domain.course.subscription;

import java.sql.Timestamp;
import java.util.Date;

import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class CourseActivity {

	private ZID 			activityId;
	private Date 			activityDate 				= null;
	private ActivityType 	activityType 				= null;
	private Timestamp 		startTime 					= null;
	private Timestamp 		endTime 					= null;
	private String 			description 				= null;
	private Boolean 		isZeniSuggested 			= null;
	private Boolean 		isFacilitationNeeded 		= null;
	private Boolean 		isFacilitationCompleted 	= null;
	private Boolean 		isFacilitationUsed 			= null;
	private SubscriptionCourse	subscriptionCourse 		= null;
	
	/**
	 * @return the activityId
	 */
	public ZID getActivityId() {
		return activityId;
	}
	/**
	 * @param activityId the activityId to set
	 */
	public void setActivityId(Integer activityId) {
		this.activityId = new IntegerZID(activityId);
	}
	/**
	 * @return the activityDate
	 */
	public Date getActivityDate() {
		return activityDate;
	}
	/**
	 * @param activityDate the activityDate to set
	 */
	public void setActivityDate(Date activityDate) {
		this.activityDate = activityDate;
	}
	/**
	 * @return the activityType
	 */
	public ActivityType getActivityType() {
		return activityType;
	}
	/**
	 * @param activityType the activityType to set
	 */
	public void setActivityType(ActivityType activityType) {
		this.activityType = activityType;
	}
	/**
	 * @return the startTime
	 */
	public Timestamp getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return the endTime
	 */
	public Timestamp getEndTime() {
		return endTime;
	}
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the isZeniSuggested
	 */
	public Boolean getIsZeniSuggested() {
		return isZeniSuggested;
	}
	/**
	 * @param isZeniSuggested the isZeniSuggested to set
	 */
	public void setIsZeniSuggested(Boolean isZeniSuggested) {
		this.isZeniSuggested = isZeniSuggested;
	}
	/**
	 * @return the isFacilitationNeeded
	 */
	public Boolean getIsFacilitationNeeded() {
		return isFacilitationNeeded;
	}
	/**
	 * @param isFacilitationNeeded the isFacilitationNeeded to set
	 */
	public void setIsFacilitationNeeded(Boolean isFacilitationNeeded) {
		this.isFacilitationNeeded = isFacilitationNeeded;
	}
	/**
	 * @return the isFacilitationCompleted
	 */
	public Boolean getIsFacilitationCompleted() {
		return isFacilitationCompleted;
	}
	/**
	 * @param isFacilitationCompleted the isFacilitationCompleted to set
	 */
	public void setIsFacilitationCompleted(Boolean isFacilitationCompleted) {
		this.isFacilitationCompleted = isFacilitationCompleted;
	}
	/**
	 * @return the isFacilitationUsed
	 */
	public Boolean getIsFacilitationUsed() {
		return isFacilitationUsed;
	}
	/**
	 * @param isFacilitationUsed the isFacilitationUsed to set
	 */
	public void setIsFacilitationUsed(Boolean isFacilitationUsed) {
		this.isFacilitationUsed = isFacilitationUsed;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CourseActivity [activityId=" + activityId + ", activityDate="
				+ activityDate + ", activityType=" + activityType
				+ ", startTime=" + startTime + ", endTime=" + endTime
				+ ", description=" + description + ", isZeniSuggested="
				+ isZeniSuggested + ", isFacilitationNeeded="
				+ isFacilitationNeeded + ", isFacilitationCompleted="
				+ isFacilitationCompleted + ", isFacilitationUsed="
				+ isFacilitationUsed + ", getActivityId()=" + getActivityId()
				+ ", getActivityDate()=" + getActivityDate()
				+ ", getActivityType()=" + getActivityType()
				+ ", getStartTime()=" + getStartTime() + ", getEndTime()="
				+ getEndTime() + ", getDescription()=" + getDescription()
				+ ", getIsZeniSuggested()=" + getIsZeniSuggested()
				+ ", getIsFacilitationNeeded()=" + getIsFacilitationNeeded()
				+ ", getIsFacilitationCompleted()="
				+ getIsFacilitationCompleted() + ", getIsFacilitationUsed()="
				+ getIsFacilitationUsed() + "]";
	}
	
}

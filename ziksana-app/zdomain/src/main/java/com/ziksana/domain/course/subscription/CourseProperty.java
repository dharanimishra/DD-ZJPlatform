package com.ziksana.domain.course.subscription;

import java.util.Date;

import com.ziksana.domain.institution.CurriculumCourseProperty;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class CourseProperty {
	
	private ZID propertyId;
	private Date creationDate = null;
	private SbnCoursePropertyName propertyName = null;
	private String propertyValue	= null;
	private SubscriptionCourse subscriptionCourse = null;
	private CurriculumCourseProperty curriculumCourseProperty = null;
	
	/**
	 * @return the propertyId
	 */
	public ZID getPropertyId() {
		return propertyId;
	}
	/**
	 * @param propertyId the propertyId to set
	 */
	public void setPropertyId(ZID propertyId) {
		this.propertyId = propertyId;
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
	 * @return the propertyName
	 */
	public SbnCoursePropertyName getPropertyName() {
		return propertyName;
	}
	/**
	 * @param propertyName the propertyName to set
	 */
	public void setPropertyName(SbnCoursePropertyName propertyName) {
		this.propertyName = propertyName;
	}
	/**
	 * @return the propertyValue
	 */
	public String getPropertyValue() {
		return propertyValue;
	}
	/**
	 * @param propertyValue the propertyValue to set
	 */
	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
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
	/**
	 * @return the curriculumCourseProperty
	 */
	public CurriculumCourseProperty getCurriculumCourseProperty() {
		return curriculumCourseProperty;
	}
	/**
	 * @param curriculumCourseProperty the curriculumCourseProperty to set
	 */
	public void setCurriculumCourseProperty(CurriculumCourseProperty curriculumCourseProperty) {
		this.curriculumCourseProperty = curriculumCourseProperty;
	}
	
		

}

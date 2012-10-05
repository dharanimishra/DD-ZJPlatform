package com.ziksana.domain.course;

import java.util.Date;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.domain.member.MemberPersona;

/**
 * @author bhashasp
 */
public class CourseAdditionalProperty extends AuditHistory{


	private Integer courseAddnlPropertyId;
	private Date 			creationDate 			= null;
	private Integer 		propertyUsageType 		= null;
	private String 			propertyName 			= null;
	private Integer 		propertyDataType 		= null;
	private String 			propertyValue 			= null;
	private Integer 		sequence 				= null;
	private Boolean 		active 					= null;
	private Course 			course 					= null;
	private MemberPersona 	creatorMemberPersona 	= null;

	/**
	 * @return the value of corcourseadditionalproperty.CourseAddnlPropertyId
	 */
	public Integer getCourseAddnlPropertyId() {
		return courseAddnlPropertyId;
	}

	/**
	 * @param CourseAddnlPropertyId
	 *            the value for corcourseadditionalproperty.CourseAddnlPropertyId
	 */
	public void setCourseAddnlPropertyId(Integer courseAddnlPropertyId) {
		this.courseAddnlPropertyId = courseAddnlPropertyId;
	}

	/**
	 * @return the value of corcourseadditionalproperty.CreationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate
	 *            the value for corcourseadditionalproperty.CreationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the value of corcourseadditionalproperty.PropertyUsageType
	 */
	public Integer getPropertyUsageType() {
		return propertyUsageType;
	}

	/**
	 * @param propertyUsageType
	 *            the value for corcourseadditionalproperty.PropertyUsageType
	 */
	public void setPropertyUsageType(Integer propertyUsageType) {
		this.propertyUsageType = propertyUsageType;
	}

	/**
	 * @return the value of corcourseadditionalproperty.PropertyName
	 */
	public String getPropertyName() {
		return propertyName;
	}

	/**
	 * @param propertyName
	 *            the value for corcourseadditionalproperty.PropertyName
	 */
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName == null ? null : propertyName.trim();
	}

	/**
	 * @return the value of corcourseadditionalproperty.PropertyDataType
	 */
	public Integer getPropertyDataType() {
		return propertyDataType;
	}

	/**
	 * @param propertyDataType
	 *            the value for corcourseadditionalproperty.PropertyDataType
	 */
	public void setPropertyDataType(Integer propertyDataType) {
		this.propertyDataType = propertyDataType;
	}

	/**
	 * @return the value of corcourseadditionalproperty.PropertyValue
	 */
	public String getPropertyValue() {
		return propertyValue;
	}

	/**
	 * @param propertyValue
	 *            the value for corcourseadditionalproperty.PropertyValue
	 */
	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue == null ? null : propertyValue
				.trim();
	}

	/**
	 * @return the value of corcourseadditionalproperty.Sequence
	 */
	public Integer getSequence() {
		return sequence;
	}

	/**
	 * @param sequence
	 *            the value for corcourseadditionalproperty.Sequence
	 */
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	/**
	 * @return the value of corcourseadditionalproperty.Active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * @param active
	 *            the value for corcourseadditionalproperty.Active
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * @return the course
	 */
	public Course getCourse() {
		return course;
	}

	/**
	 * @param course the course to set
	 */
	public void setCourse(Course course) {
		this.course = course;
	}

	/**
	 * @return the creatorMemberPersona
	 */
	public MemberPersona getCreatorMemberPersona() {
		return creatorMemberPersona;
	}

	/**
	 * @param creatorMemberPersona the creatorMemberPersona to set
	 */
	public void setCreatorMemberPersona(MemberPersona creatorMemberPersona) {
		this.creatorMemberPersona = creatorMemberPersona;
	}

}
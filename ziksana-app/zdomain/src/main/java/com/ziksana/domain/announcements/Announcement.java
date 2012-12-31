/**
 * 
 */
package com.ziksana.domain.announcements;

import java.util.Date;

/**
 * @author vtg-p13
 * 
 */
public class Announcement {

	private int announcementId;
	private Date announcementDate;
	private String message;
	private int messageVisibility;
	private String description;
	private Date validUntil;
	private int memberRoleId;
	private int institutionId;
	private int institutionUnitId;
	private int curriculumCourseId;
	private int learningProgramId;
	private int courseId;
	private int courseLearningComponentId;
	/**
	 * @return the announcementId
	 */
	public int getAnnouncementId() {
		return announcementId;
	}
	/**
	 * @param announcementId the announcementId to set
	 */
	public void setAnnouncementId(int announcementId) {
		this.announcementId = announcementId;
	}
	/**
	 * @return the announcementDate
	 */
	public Date getAnnouncementDate() {
		return announcementDate;
	}
	/**
	 * @param announcementDate the announcementDate to set
	 */
	public void setAnnouncementDate(Date announcementDate) {
		this.announcementDate = announcementDate;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the messageVisibility
	 */
	public int getMessageVisibility() {
		return messageVisibility;
	}
	/**
	 * @param messageVisibility the messageVisibility to set
	 */
	public void setMessageVisibility(int messageVisibility) {
		this.messageVisibility = messageVisibility;
	}
	/**
	 * @return the validUntil
	 */
	public Date getValidUntil() {
		return validUntil;
	}
	/**
	 * @param validUntil the validUntil to set
	 */
	public void setValidUntil(Date validUntil) {
		this.validUntil = validUntil;
	}
	/**
	 * @return the memberRoleId
	 */
	public int getMemberRoleId() {
		return memberRoleId;
	}
	/**
	 * @param memberRoleId the memberRoleId to set
	 */
	public void setMemberRoleId(int memberRoleId) {
		this.memberRoleId = memberRoleId;
	}
	/**
	 * @return the institutionId
	 */
	public int getInstitutionId() {
		return institutionId;
	}
	/**
	 * @param institutionId the institutionId to set
	 */
	public void setInstitutionId(int institutionId) {
		this.institutionId = institutionId;
	}
	/**
	 * @return the institutionUnitId
	 */
	public int getInstitutionUnitId() {
		return institutionUnitId;
	}
	/**
	 * @param institutionUnitId the institutionUnitId to set
	 */
	public void setInstitutionUnitId(int institutionUnitId) {
		this.institutionUnitId = institutionUnitId;
	}
	/**
	 * @return the curriculumCourseId
	 */
	public int getCurriculumCourseId() {
		return curriculumCourseId;
	}
	/**
	 * @param curriculumCourseId the curriculumCourseId to set
	 */
	public void setCurriculumCourseId(int curriculumCourseId) {
		this.curriculumCourseId = curriculumCourseId;
	}
	/**
	 * @return the learningProgramId
	 */
	public int getLearningProgramId() {
		return learningProgramId;
	}
	/**
	 * @param learningProgramId the learningProgramId to set
	 */
	public void setLearningProgramId(int learningProgramId) {
		this.learningProgramId = learningProgramId;
	}
	/**
	 * @return the courseId
	 */
	public int getCourseId() {
		return courseId;
	}
	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	/**
	 * @return the courseLearningComponentId
	 */
	public int getCourseLearningComponentId() {
		return courseLearningComponentId;
	}
	/**
	 * @param courseLearningComponentId the courseLearningComponentId to set
	 */
	public void setCourseLearningComponentId(int courseLearningComponentId) {
		this.courseLearningComponentId = courseLearningComponentId;
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
	

	
}

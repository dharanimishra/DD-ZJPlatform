/**
 * 
 */
package com.ziksana.domain.announcements;

import java.util.Date;

/**
 * @author Ratnesh
 * 
 */
public class Announcement {

	private int announcementId;

	private Date announcementDate;

	private String message;

	private int messageVisibility;

	private Date validUntil;

	private int memberRoleId;

	private int institutionId;

	private int institutionUnitId;

	private int curriculumCourseId;

	private int learningProgramId;

	private int courseId;

	private int courseLearningComponentId;

	/**
	 * 
	 */
	public Announcement() {
		super();
	}

	/**
	 * @param announcementId
	 * @param announcementDate
	 * @param message
	 * @param messageVisibility
	 * @param validUntil
	 * @param memberRoleId
	 * @param institutionId
	 * @param institutionUnitId
	 * @param curriculumCourseId
	 * @param learningProgramId
	 * @param courseId
	 * @param courseLearningComponentId
	 */
	public Announcement(int announcementId, Date announcementDate,
			String message, int messageVisibility, Date validUntil,
			int memberRoleId, int institutionId, int institutionUnitId,
			int curriculumCourseId, int learningProgramId, int courseId,
			int courseLearningComponentId) {
		super();
		this.announcementId = announcementId;
		this.announcementDate = announcementDate;
		this.message = message;
		this.messageVisibility = messageVisibility;
		this.validUntil = validUntil;
		this.memberRoleId = memberRoleId;
		this.institutionId = institutionId;
		this.institutionUnitId = institutionUnitId;
		this.curriculumCourseId = curriculumCourseId;
		this.learningProgramId = learningProgramId;
		this.courseId = courseId;
		this.courseLearningComponentId = courseLearningComponentId;
	}

	public int getAnnouncementId() {
		return announcementId;
	}

	public void setAnnouncementId(int announcementId) {
		this.announcementId = announcementId;
	}

	public Date getAnnouncementDate() {
		return announcementDate;
	}

	public void setAnnouncementDate(Date announcementDate) {
		this.announcementDate = announcementDate;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getMessageVisibility() {
		return messageVisibility;
	}

	public void setMessageVisibility(int messageVisibility) {
		this.messageVisibility = messageVisibility;
	}

	public Date getValidUntil() {
		return validUntil;
	}

	public void setValidUntil(Date validUntil) {
		this.validUntil = validUntil;
	}

	public int getMemberRoleId() {
		return memberRoleId;
	}

	public void setMemberRoleId(int memberRoleId) {
		this.memberRoleId = memberRoleId;
	}

	public int getInstitutionId() {
		return institutionId;
	}

	public void setInstitutionId(int institutionId) {
		this.institutionId = institutionId;
	}

	public int getInstitutionUnitId() {
		return institutionUnitId;
	}

	public void setInstitutionUnitId(int institutionUnitId) {
		this.institutionUnitId = institutionUnitId;
	}

	public int getCurriculumCourseId() {
		return curriculumCourseId;
	}

	public void setCurriculumCourseId(int curriculumCourseId) {
		this.curriculumCourseId = curriculumCourseId;
	}

	public int getLearningProgramId() {
		return learningProgramId;
	}

	public void setLearningProgramId(int learningProgramId) {
		this.learningProgramId = learningProgramId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getCourseLearningComponentId() {
		return courseLearningComponentId;
	}

	public void setCourseLearningComponentId(int courseLearningComponentId) {
		this.courseLearningComponentId = courseLearningComponentId;
	}

}

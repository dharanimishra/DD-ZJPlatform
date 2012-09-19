package com.ziksana.domain.course;

import java.util.Date;

	/**
	 * Domain class for the table corAnnouncement
	 */

public class Announcement {
	/**
	 * This field corresponds to the database column corannouncement.anouncementId
	 */
	private Integer anouncementId;

	/**
	 * This field corresponds to the database column
	 * corannouncement.AnnouncementDate
	 */
	private Date announcementDate;

	/**
	 * This field corresponds to the database column corannouncement.Message
	 */
	private String message;

	/**
	 * This field corresponds to the database column
	 * corannouncement.MessageVisibility
	 */
	private Integer messageVisibility;

	/**
	 * This field corresponds to the database column corannouncement.ValidUntil
	 */
	private Date validUntil;

	/**
	 * This field corresponds to the database column
	 * corannouncement.MemberRoleId
	 */
	private Integer memberRoleId;

	/**
	 * This field corresponds to the database column
	 * corannouncement.InstitutionId
	 */
	private Integer institutionId;

	/**
	 * This field corresponds to the database column
	 * corannouncement.InstitutionUnitId
	 */
	private Integer institutionUnitId;

	/**
	 * This field corresponds to the database column
	 * corannouncement.CurriculumCourseId
	 */
	private Integer curriculumCourseId;

	/**
	 * This field corresponds to the database column
	 * corannouncement.LearningProgramId
	 */
	private Integer learningProgramId;

	/**
	 * This field corresponds to the database column corannouncement.CourseId
	 */
	private Integer courseId;

	/**
	 * This field corresponds to the database column
	 * corannouncement.CourseLearningComponentId
	 */
	private Integer courseLearningComponentId;

	/**
	 * This method returns the value of the database column corannouncement.anouncementId
	 * 
	 * @return the value of corannouncement.anouncementId
	 */
	public Integer getAnouncementId() {
		return anouncementId;
	}

	/**
	 * This method sets the value of the database column corannouncement.anouncementId
	 * 
	 * @param anouncementId
	 *            the value for corannouncement.anouncementId
	 */
	public void setAnouncementId(Integer anouncementId) {
		this.anouncementId = anouncementId;
	}

	/**
	 * This method returns the value of the database column
	 * corannouncement.AnnouncementDate
	 * 
	 * @return the value of corannouncement.AnnouncementDate
	 */
	public Date getAnnouncementDate() {
		return announcementDate;
	}

	/**
	 * This method sets the value of the database column
	 * corannouncement.AnnouncementDate
	 * 
	 * @param announcementDate
	 *            the value for corannouncement.AnnouncementDate
	 */
	public void setAnnouncementDate(Date announcementDate) {
		this.announcementDate = announcementDate;
	}

	/**
	 * This method returns the value of the database column
	 * corannouncement.Message
	 * 
	 * @return the value of corannouncement.Message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * This method sets the value of the database column corannouncement.Message
	 * 
	 * @param message
	 *            the value for corannouncement.Message
	 */
	public void setMessage(String message) {
		this.message = message == null ? null : message.trim();
	}

	/**
	 * This method returns the value of the database column
	 * corannouncement.MessageVisibility
	 * 
	 * @return the value of corannouncement.MessageVisibility
	 */
	public Integer getMessageVisibility() {
		return messageVisibility;
	}

	/**
	 * This method sets the value of the database column
	 * corannouncement.MessageVisibility
	 * 
	 * @param messageVisibility
	 *            the value for corannouncement.MessageVisibility
	 */
	public void setMessageVisibility(Integer messageVisibility) {
		this.messageVisibility = messageVisibility;
	}

	/**
	 * This method returns the value of the database column
	 * corannouncement.ValidUntil
	 * 
	 * @return the value of corannouncement.ValidUntil
	 */
	public Date getValidUntil() {
		return validUntil;
	}

	/**
	 * This method sets the value of the database column
	 * corannouncement.ValidUntil
	 * 
	 * @param validUntil
	 *            the value for corannouncement.ValidUntil
	 */
	public void setValidUntil(Date validUntil) {
		this.validUntil = validUntil;
	}

	/**
	 * This method returns the value of the database column
	 * corannouncement.MemberRoleId
	 * 
	 * @return the value of corannouncement.MemberRoleId
	 */
	public Integer getMemberRoleId() {
		return memberRoleId;
	}

	/**
	 * This method sets the value of the database column
	 * corannouncement.MemberRoleId
	 * 
	 * @param memberRoleId
	 *            the value for corannouncement.MemberRoleId
	 */
	public void setMemberRoleId(Integer memberRoleId) {
		this.memberRoleId = memberRoleId;
	}

	/**
	 * This method returns the value of the database column
	 * corannouncement.InstitutionId
	 * 
	 * @return the value of corannouncement.InstitutionId
	 */
	public Integer getInstitutionId() {
		return institutionId;
	}

	/**
	 * This method sets the value of the database column
	 * corannouncement.InstitutionId
	 * 
	 * @param institutionId
	 *            the value for corannouncement.InstitutionId
	 */
	public void setInstitutionId(Integer institutionId) {
		this.institutionId = institutionId;
	}

	/**
	 * This method returns the value of the database column
	 * corannouncement.InstitutionUnitId
	 * 
	 * @return the value of corannouncement.InstitutionUnitId
	 */
	public Integer getInstitutionUnitId() {
		return institutionUnitId;
	}

	/**
	 * This method sets the value of the database column
	 * corannouncement.InstitutionUnitId
	 * 
	 * @param institutionUnitId
	 *            the value for corannouncement.InstitutionUnitId
	 */
	public void setInstitutionUnitId(Integer institutionUnitId) {
		this.institutionUnitId = institutionUnitId;
	}

	/**
	 * This method returns the value of the database column
	 * corannouncement.CurriculumCourseId
	 * 
	 * @return the value of corannouncement.CurriculumCourseId
	 */
	public Integer getCurriculumCourseId() {
		return curriculumCourseId;
	}

	/**
	 * This method sets the value of the database column
	 * corannouncement.CurriculumCourseId
	 * 
	 * @param curriculumCourseId
	 *            the value for corannouncement.CurriculumCourseId
	 */
	public void setCurriculumCourseId(Integer curriculumCourseId) {
		this.curriculumCourseId = curriculumCourseId;
	}

	/**
	 * This method returns the value of the database column
	 * corannouncement.LearningProgramId
	 * 
	 * @return the value of corannouncement.LearningProgramId
	 */
	public Integer getLearningProgramId() {
		return learningProgramId;
	}

	/**
	 * This method sets the value of the database column
	 * corannouncement.LearningProgramId
	 * 
	 * @param learningProgramId
	 *            the value for corannouncement.LearningProgramId
	 */
	public void setLearningProgramId(Integer learningProgramId) {
		this.learningProgramId = learningProgramId;
	}

	/**
	 * This method returns the value of the database column
	 * corannouncement.CourseId
	 * 
	 * @return the value of corannouncement.CourseId
	 */
	public Integer getCourseId() {
		return courseId;
	}

	/**
	 * This method sets the value of the database column
	 * corannouncement.CourseId
	 * 
	 * @param courseId
	 *            the value for corannouncement.CourseId
	 */
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	/**
	 * This method returns the value of the database column
	 * corannouncement.CourseLearningComponentId
	 * 
	 * @return the value of corannouncement.CourseLearningComponentId
	 */
	public Integer getCourseLearningComponentId() {
		return courseLearningComponentId;
	}

	/**
	 * This method sets the value of the database column
	 * corannouncement.CourseLearningComponentId
	 * 
	 * @param courseLearningComponentId
	 *            the value for corannouncement.CourseLearningComponentId
	 */
	public void setCourseLearningComponentId(Integer courseLearningComponentId) {
		this.courseLearningComponentId = courseLearningComponentId;
	}
}
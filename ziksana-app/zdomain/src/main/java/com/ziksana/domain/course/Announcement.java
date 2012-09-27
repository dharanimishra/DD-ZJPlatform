package com.ziksana.domain.course;

import java.util.Date;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.domain.member.MemberPersona;

	/**
	 * Domain class for the table corAnnouncement
	 */

public class Announcement extends AuditHistory{
	
	private Integer anouncementId;
	private Date announcementDate;
	private String message;
	private MessageVisibility messageVisibility;
	private Date validUntil;
	private MemberPersona postingMemberPersona;
	private Institution institution;
	private InstitutionUnit institutionUnit;
	private CurriculumCourse curriculumCourse;
	private LearningProgram learningProgram;
	private Course course;
	private CourseLearningComponent courseLearningComponent;
	/**
	 * @return the anouncementId
	 */
	public Integer getAnouncementId() {
		return anouncementId;
	}
	/**
	 * @param anouncementId the anouncementId to set
	 */
	public void setAnouncementId(Integer anouncementId) {
		this.anouncementId = anouncementId;
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
	public MessageVisibility getMessageVisibility() {
		return messageVisibility;
	}
	/**
	 * @param messageVisibility the messageVisibility to set
	 */
	public void setMessageVisibility(MessageVisibility messageVisibility) {
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
	 * @return the postingMemberPersona
	 */
	public MemberPersona getPostingMemberPersona() {
		return postingMemberPersona;
	}
	/**
	 * @param postingMemberPersona the postingMemberPersona to set
	 */
	public void setPostingMemberPersona(MemberPersona postingMemberPersona) {
		this.postingMemberPersona = postingMemberPersona;
	}
	/**
	 * @return the institution
	 */
	public Institution getInstitution() {
		return institution;
	}
	/**
	 * @param institution the institution to set
	 */
	public void setInstitution(Institution institution) {
		this.institution = institution;
	}
	/**
	 * @return the institutionUnit
	 */
	public InstitutionUnit getInstitutionUnit() {
		return institutionUnit;
	}
	/**
	 * @param institutionUnit the institutionUnit to set
	 */
	public void setInstitutionUnit(InstitutionUnit institutionUnit) {
		this.institutionUnit = institutionUnit;
	}
	/**
	 * @return the curriculumCourse
	 */
	public CurriculumCourse getCurriculumCourse() {
		return curriculumCourse;
	}
	/**
	 * @param curriculumCourse the curriculumCourse to set
	 */
	public void setCurriculumCourse(CurriculumCourse curriculumCourse) {
		this.curriculumCourse = curriculumCourse;
	}
	/**
	 * @return the learningProgram
	 */
	public LearningProgram getLearningProgram() {
		return learningProgram;
	}
	/**
	 * @param learningProgram the learningProgram to set
	 */
	public void setLearningProgram(LearningProgram learningProgram) {
		this.learningProgram = learningProgram;
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
	 * @return the courseLearningComponent
	 */
	public CourseLearningComponent getCourseLearningComponent() {
		return courseLearningComponent;
	}
	/**
	 * @param courseLearningComponent the courseLearningComponent to set
	 */
	public void setCourseLearningComponent(
			CourseLearningComponent courseLearningComponent) {
		this.courseLearningComponent = courseLearningComponent;
	}
}
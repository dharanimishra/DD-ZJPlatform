package com.ziksana.domain.course;

import java.io.Serializable;
import java.util.Date;

public class CurriculumDelivery implements Serializable{

	/**serial versionID
	 */
	private static final long serialVersionUID = -4780651589867472086L;
	/**
	 * This field corresponds to the database column
	 * corcurriculumdelivery.curriculumDeliveryId
	 */
	private Integer curriculumDeliveryId;
	/**
	 * This field corresponds to the database column
	 * corcurriculumdelivery.ParticipatingType
	 */
	private Integer participatingType;
	/**
	 * This field corresponds to the database column
	 * corcurriculumdelivery.StartDate
	 */
	private Date startDate;
	/**
	 * This field corresponds to the database column
	 * corcurriculumdelivery.EndDate
	 */
	private Date endDate;
	/**
	 * This field corresponds to the database column
	 * corcurriculumdelivery.Active
	 */
	private Boolean active;

	/**
	 * This field corresponds to the database column
	 * corcurriculumdelivery.term
	 */
	private Integer term;

	/**
	 * This field corresponds to the database column
	 * corcurriculumdelivery.specialEditionIndicator
	 */
	private boolean specialEditionIndicator;

	/**
	 * This field corresponds to the database column
	 * corcurriculumdelivery.programCurriculumId
	 */
	private Integer programCurriculumId;

	/**
	 * This field corresponds to the database column
	 * corcurriculumdelivery.CurriculumCourseId
	 */
	private Integer curriculumCourseId;
	/**
	 * This field corresponds to the database column
	 * corcurriculumdelivery.MemberRoleId
	 */
	private Integer memberRoleId;

	/**
	 * This method returns the value of the database column
	 * corcurriculumdelivery.curriculumDeliveryId
	 * 
	 * @return the value of corcurriculumdelivery.curriculumDeliveryId
	 */
	public Integer getCurriculumDeliveryId() {
		return curriculumDeliveryId;
	}

	/**
	 * This method sets the value of the database column
	 * corcurriculumdelivery.curriculumDeliveryId
	 * 
	 * @param curriculumDeliveryId
	 *            the value for corcurriculumdelivery.curriculumDeliveryId
	 */
	public void setCurriculumDeliveryId(Integer curriculumDeliveryId) {
		this.curriculumDeliveryId = curriculumDeliveryId;
	}

	/**
	 * This method returns the value of the database column
	 * corcurriculumdelivery.ParticipatingType
	 * 
	 * @return the value of corcurriculumdelivery.ParticipatingType
	 */
	public Integer getParticipatingType() {
		return participatingType;
	}

	/**
	 * This method sets the value of the database column
	 * corcurriculumdelivery.ParticipatingType
	 * 
	 * @param participatingType
	 *            the value for corcurriculumdelivery.ParticipatingType
	 */
	public void setParticipatingType(Integer participatingType) {
		this.participatingType = participatingType;
	}

	/**
	 * This method returns the value of the database column
	 * corcurriculumdelivery.StartDate
	 * 
	 * @return the value of corcurriculumdelivery.StartDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * This method sets the value of the database column
	 * corcurriculumdelivery.StartDate
	 * 
	 * @param startDate
	 *            the value for corcurriculumdelivery.StartDate
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * This method returns the value of the database column
	 * corcurriculumdelivery.EndDate
	 * 
	 * @return the value of corcurriculumdelivery.EndDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * This method sets the value of the database column
	 * corcurriculumdelivery.EndDate
	 * 
	 * @param endDate
	 *            the value for corcurriculumdelivery.EndDate
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * This method returns the value of the database column
	 * corcurriculumdelivery.Active
	 * 
	 * @return the value of corcurriculumdelivery.Active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * This method sets the value of the database column
	 * corcurriculumdelivery.Active
	 * 
	 * @param active
	 *            the value for corcurriculumdelivery.Active
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * This method returns the value of the database column
	 * corcurriculumdelivery.CurriculumCourseId
	 * 
	 * @return the value of corcurriculumdelivery.CurriculumCourseId
	 */
	public Integer getCurriculumCourseId() {
		return curriculumCourseId;
	}

	/**
	 * This method sets the value of the database column
	 * corcurriculumdelivery.CurriculumCourseId
	 * 
	 * @param curriculumCourseId
	 *            the value for corcurriculumdelivery.CurriculumCourseId
	 */
	public void setCurriculumCourseId(Integer curriculumCourseId) {
		this.curriculumCourseId = curriculumCourseId;
	}

	/**
	 * This method returns the value of the database column
	 * corcurriculumdelivery.MemberRoleId
	 * 
	 * @return the value of corcurriculumdelivery.MemberRoleId
	 */
	public Integer getMemberRoleId() {
		return memberRoleId;
	}

	/**
	 * This method sets the value of the database column
	 * corcurriculumdelivery.MemberRoleId
	 * 
	 * @param memberRoleId
	 *            the value for corcurriculumdelivery.MemberRoleId
	 */
	public void setMemberRoleId(Integer memberRoleId) {
		this.memberRoleId = memberRoleId;
	}

	/**
	 * @return the term
	 */
	public Integer getTerm() {
		return term;
	}

	/**
	 * @param term
	 *            the term to set
	 */
	public void setTerm(Integer term) {
		this.term = term;
	}

	/**
	 * @return the specialEditionIndicator
	 */
	public boolean isSpecialEditionIndicator() {
		return specialEditionIndicator;
	}

	/**
	 * @param specialEditionIndicator
	 *            the specialEditionIndicator to set
	 */
	public void setSpecialEditionIndicator(boolean specialEditionIndicator) {
		this.specialEditionIndicator = specialEditionIndicator;
	}

	/**
	 * @return the programCurriculumId
	 */
	public Integer getProgramCurriculumId() {
		return programCurriculumId;
	}

	/**
	 * @param programCurriculumId
	 *            the programCurriculumId to set
	 */
	public void setProgramCurriculumId(Integer programCurriculumId) {
		this.programCurriculumId = programCurriculumId;
	}
}
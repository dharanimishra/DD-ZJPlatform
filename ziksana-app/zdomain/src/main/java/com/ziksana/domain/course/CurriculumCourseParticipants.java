package com.ziksana.domain.course;

import java.util.Date;

public class CurriculumCourseParticipants {
	/**
	 * 
	 * This field corresponds to the database column
	 * corcurriculumcourseparticipants.currCourseParticipantsId
	 * 
	 */
	private Integer currCourseParticipantsId;

	/**
	 * 
	 * This field corresponds to the database column
	 * corcurriculumcourseparticipants.ParticipatingType
	 * 
	 */
	private Integer participatingType;

	/**
	 * 
	 * This field corresponds to the database column
	 * corcurriculumcourseparticipants.StartDate
	 * 
	 */
	private Date startDate;

	/**
	 * 
	 * This field corresponds to the database column
	 * corcurriculumcourseparticipants.EndDate
	 * 
	 */
	private Date endDate;

	/**
	 * 
	 * This field corresponds to the database column
	 * corcurriculumcourseparticipants.Active
	 * 
	 */
	private Boolean active;

	/**
	 * 
	 * This field corresponds to the database column
	 * corcurriculumcourseparticipants.CurriculumCourseId
	 * 
	 */
	private Integer curriculumCourseId;

	/**
	 * 
	 * This field corresponds to the database column
	 * corcurriculumcourseparticipants.MemberRoleId
	 * 
	 */
	private Integer memberRoleId;

	/**
	 * 
	 * This field corresponds to the database column
	 * corcurriculumcourseparticipants.MemberRolePrivilegeId
	 * 
	 */
	private Integer memberRolePrivilegeId;

	/**
	 * 
	 * This field corresponds to the database column
	 * corcurriculumcourseparticipants.CurriculumDeliveryId
	 * 
	 */
	private Integer curriculumDeliveryId;

	/**
	 * 
	 * This method returns the value of the database column
	 * corcurriculumcourseparticipants.currCourseParticipantsId
	 * 
	 * @return the value of corcurriculumcourseparticipants.currCourseParticipantsId
	 * 
	 */
	public Integer getCurrCourseParticipantsId() {
		return currCourseParticipantsId;
	}

	/**
	 * 
	 * This method sets the value of the database column
	 * corcurriculumcourseparticipants.currCourseParticipantsId
	 * 
	 * @param currCourseParticipantsId
	 *            the value for corcurriculumcourseparticipants.currCourseParticipantsId
	 * 
	 */
	public void setCurrCourseParticipantsId(Integer currCourseParticipantsId) {
		this.currCourseParticipantsId = currCourseParticipantsId;
	}

	/**
	 * 
	 * This method returns the value of the database column
	 * corcurriculumcourseparticipants.ParticipatingType
	 * 
	 * @return the value of corcurriculumcourseparticipants.ParticipatingType
	 * 
	 */
	public Integer getParticipatingType() {
		return participatingType;
	}

	/**
	 * 
	 * This method sets the value of the database column
	 * corcurriculumcourseparticipants.ParticipatingType
	 * 
	 * @param participatingType
	 *            the value for
	 *            corcurriculumcourseparticipants.ParticipatingType
	 * 
	 */
	public void setParticipatingType(Integer participatingType) {
		this.participatingType = participatingType;
	}

	/**
	 * 
	 * This method returns the value of the database column
	 * corcurriculumcourseparticipants.StartDate
	 * 
	 * @return the value of corcurriculumcourseparticipants.StartDate
	 * 
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * 
	 * This method sets the value of the database column
	 * corcurriculumcourseparticipants.StartDate
	 * 
	 * @param startDate
	 *            the value for corcurriculumcourseparticipants.StartDate
	 * 
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * 
	 * This method returns the value of the database column
	 * corcurriculumcourseparticipants.EndDate
	 * 
	 * @return the value of corcurriculumcourseparticipants.EndDate
	 * 
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * 
	 * This method sets the value of the database column
	 * corcurriculumcourseparticipants.EndDate
	 * 
	 * @param endDate
	 *            the value for corcurriculumcourseparticipants.EndDate
	 * 
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * 
	 * This method returns the value of the database column
	 * corcurriculumcourseparticipants.Active
	 * 
	 * @return the value of corcurriculumcourseparticipants.Active
	 * 
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * 
	 * This method sets the value of the database column
	 * corcurriculumcourseparticipants.Active
	 * 
	 * @param active
	 *            the value for corcurriculumcourseparticipants.Active
	 * 
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * 
	 * This method returns the value of the database column
	 * corcurriculumcourseparticipants.CurriculumCourseId
	 * 
	 * @return the value of corcurriculumcourseparticipants.CurriculumCourseId
	 * 
	 */
	public Integer getCurriculumCourseId() {
		return curriculumCourseId;
	}

	/**
	 * 
	 * This method sets the value of the database column
	 * corcurriculumcourseparticipants.CurriculumCourseId
	 * 
	 * @param curriculumCourseId
	 *            the value for
	 *            corcurriculumcourseparticipants.CurriculumCourseId
	 * 
	 */
	public void setCurriculumCourseId(Integer curriculumCourseId) {
		this.curriculumCourseId = curriculumCourseId;
	}

	/**
	 * 
	 * This method returns the value of the database column
	 * corcurriculumcourseparticipants.MemberRoleId
	 * 
	 * @return the value of corcurriculumcourseparticipants.MemberRoleId
	 * 
	 */
	public Integer getMemberRoleId() {
		return memberRoleId;
	}

	/**
	 * 
	 * This method sets the value of the database column
	 * corcurriculumcourseparticipants.MemberRoleId
	 * 
	 * @param memberRoleId
	 *            the value for corcurriculumcourseparticipants.MemberRoleId
	 * 
	 */
	public void setMemberRoleId(Integer memberRoleId) {
		this.memberRoleId = memberRoleId;
	}

	/**
	 * 
	 * This method returns the value of the database column
	 * corcurriculumcourseparticipants.MemberRolePrivilegeId
	 * 
	 * @return the value of
	 *         corcurriculumcourseparticipants.MemberRolePrivilegeId
	 * 
	 */
	public Integer getMemberRolePrivilegeId() {
		return memberRolePrivilegeId;
	}

	/**
	 * 
	 * This method sets the value of the database column
	 * corcurriculumcourseparticipants.MemberRolePrivilegeId
	 * 
	 * @param memberRolePrivilegeId
	 *            the value for
	 *            corcurriculumcourseparticipants.MemberRolePrivilegeId
	 * 
	 */
	public void setMemberRolePrivilegeId(Integer memberRolePrivilegeId) {
		this.memberRolePrivilegeId = memberRolePrivilegeId;
	}

	/**
	 * 
	 * This method returns the value of the database column
	 * corcurriculumcourseparticipants.CurriculumDeliveryId
	 * 
	 * @return the value of corcurriculumcourseparticipants.CurriculumDeliveryId
	 * 
	 */
	public Integer getCurriculumDeliveryId() {
		return curriculumDeliveryId;
	}

	/**
	 * 
	 * This method sets the value of the database column
	 * corcurriculumcourseparticipants.CurriculumDeliveryId
	 * 
	 * @param curriculumDeliveryId
	 *            the value for
	 *            corcurriculumcourseparticipants.CurriculumDeliveryId
	 * 
	 */
	public void setCurriculumDeliveryId(Integer curriculumDeliveryId) {
		this.curriculumDeliveryId = curriculumDeliveryId;
	}
}
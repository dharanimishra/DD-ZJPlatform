package com.ziksana.domain.course;

import java.util.Date;

public class WorkflowParticipant {
	/**
	 * This field corresponds to the database column
	 * corworkflowparticipant.workflowParticipantId
	 */
	private Integer workflowParticipantId;

	/**
	 * This field corresponds to the database column
	 * corworkflowparticipant.CommunicatedDate
	 */
	private Date communicatedDate;

	/**
	 * This field corresponds to the database column
	 * corworkflowparticipant.StartDate
	 */
	private Date startDate;

	/**
	 * This field corresponds to the database column
	 * corworkflowparticipant.EndDate
	 */
	private Date endDate;

	/**
	 * This field corresponds to the database column
	 * corworkflowparticipant.ParticipantType
	 */
	private Integer participantType;

	/**
	 * This field corresponds to the database column
	 * corworkflowparticipant.ContentReviewWorkflowId
	 */
	private Integer contentReviewWorkflowId;

	/**
	 * This field corresponds to the database column
	 * corworkflowparticipant.MemberRoleId
	 */
	private Integer memberRoleId;

	/**
	 * This method returns the value of the database column
	 * corworkflowparticipant.workflowParticipantId
	 * 
	 * @return the value of corworkflowparticipant.workflowParticipantId
	 */
	public Integer getWorkflowParticipantId() {
		return workflowParticipantId;
	}

	/**
	 * This method sets the value of the database column
	 * corworkflowparticipant.workflowParticipantId
	 * 
	 * @param workflowParticipantId
	 *            the value for corworkflowparticipant.workflowParticipantId
	 */
	public void setWorkflowParticipantId(Integer workflowParticipantId) {
		this.workflowParticipantId = workflowParticipantId;
	}

	/**
	 * This method returns the value of the database column
	 * corworkflowparticipant.CommunicatedDate
	 * 
	 * @return the value of corworkflowparticipant.CommunicatedDate
	 */
	public Date getCommunicatedDate() {
		return communicatedDate;
	}

	/**
	 * This method sets the value of the database column
	 * corworkflowparticipant.CommunicatedDate
	 * 
	 * @param communicatedDate
	 *            the value for corworkflowparticipant.CommunicatedDate
	 */
	public void setCommunicatedDate(Date communicatedDate) {
		this.communicatedDate = communicatedDate;
	}

	/**
	 * This method returns the value of the database column
	 * corworkflowparticipant.StartDate
	 * 
	 * @return the value of corworkflowparticipant.StartDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * This method sets the value of the database column
	 * corworkflowparticipant.StartDate
	 * 
	 * @param startDate
	 *            the value for corworkflowparticipant.StartDate
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * This method returns the value of the database column
	 * corworkflowparticipant.EndDate
	 * 
	 * @return the value of corworkflowparticipant.EndDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * This method sets the value of the database column
	 * corworkflowparticipant.EndDate
	 * 
	 * @param endDate
	 *            the value for corworkflowparticipant.EndDate
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * This method returns the value of the database column
	 * corworkflowparticipant.ParticipantType
	 * 
	 * @return the value of corworkflowparticipant.ParticipantType
	 */
	public Integer getParticipantType() {
		return participantType;
	}

	/**
	 * This method sets the value of the database column
	 * corworkflowparticipant.ParticipantType
	 * 
	 * @param participantType
	 *            the value for corworkflowparticipant.ParticipantType
	 */
	public void setParticipantType(Integer participantType) {
		this.participantType = participantType;
	}

	/**
	 * This method returns the value of the database column
	 * corworkflowparticipant.ContentReviewWorkflowId
	 * 
	 * @return the value of corworkflowparticipant.ContentReviewWorkflowId
	 */
	public Integer getContentReviewWorkflowId() {
		return contentReviewWorkflowId;
	}

	/**
	 * This method sets the value of the database column
	 * corworkflowparticipant.ContentReviewWorkflowId
	 * 
	 * @param contentReviewWorkflowId
	 *            the value for corworkflowparticipant.ContentReviewWorkflowId
	 */
	public void setContentReviewWorkflowId(Integer contentReviewWorkflowId) {
		this.contentReviewWorkflowId = contentReviewWorkflowId;
	}

	/**
	 * This method returns the value of the database column
	 * corworkflowparticipant.MemberRoleId
	 * 
	 * @return the value of corworkflowparticipant.MemberRoleId
	 */
	public Integer getMemberRoleId() {
		return memberRoleId;
	}

	/**
	 * This method sets the value of the database column
	 * corworkflowparticipant.MemberRoleId
	 * 
	 * @param memberRoleId
	 *            the value for corworkflowparticipant.MemberRoleId
	 */
	public void setMemberRoleId(Integer memberRoleId) {
		this.memberRoleId = memberRoleId;
	}
}
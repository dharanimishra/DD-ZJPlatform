package com.ziksana.domain.course;

import java.util.Date;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class WorkflowParticipant extends AuditHistory {
	
	public WorkflowParticipant(Date communicatedDate, Date startDate,
			Date endDate, ParticipantType participantType,
			ContentReviewWorkflow courseWorkflow,
			WorkflowParticipantComment participantComment) {
		this.communicatedDate = communicatedDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.participantType = participantType;
		this.courseWorkflow = courseWorkflow;
		this.participantComment = participantComment;
	}
	
	private ZID 						participantId;
	private Date 						communicatedDate 		= null;
	private Date 						startDate				= null;
	private Date 						endDate					= null;
	private ParticipantType 			participantType 		= null;
	private ContentReviewWorkflow 		courseWorkflow 			= null;
	private MemberPersona				memberPersona 			= null;
	private WorkflowParticipantComment 	participantComment 		= null;
	private ContentReviewRating			contentReviewRating 	= null;
	
	/**
	 * @return the participantId
	 */
	public ZID getParticipantId() {
		return participantId;
	}
	/**
	 * @param participantId the participantId to set
	 */
	public void setParticipantId(ZID participantId) {
		this.participantId = participantId;
	}
	/**
	 * @return the communicatedDate
	 */
	public Date getCommunicatedDate() {
		return communicatedDate;
	}
	/**
	 * @param communicatedDate the communicatedDate to set
	 */
	public void setCommunicatedDate(Date communicatedDate) {
		this.communicatedDate = communicatedDate;
	}
	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the participantType
	 */
	public ParticipantType getParticipantType() {
		return participantType;
	}
	/**
	 * @param participantType the participantType to set
	 */
	public void setParticipantType(ParticipantType participantType) {
		this.participantType = participantType;
	}
	/**
	 * @return the courseWorkflow
	 */
	public ContentReviewWorkflow getCourseWorkflow() {
		return courseWorkflow;
	}
	/**
	 * @param courseWorkflow the courseWorkflow to set
	 */
	public void setCourseWorkflow(ContentReviewWorkflow courseWorkflow) {
		this.courseWorkflow = courseWorkflow;
	}
	/**
	 * @return the memberPersona
	 */
	public MemberPersona getMemberPersona() {
		return memberPersona;
	}
	/**
	 * @param memberPersona the memberPersona to set
	 */
	public void setMemberPersona(MemberPersona memberPersona) {
		this.memberPersona = memberPersona;
	}
	/**
	 * @return the participantComment
	 */
	public WorkflowParticipantComment getParticipantComment() {
		return participantComment;
	}
	/**
	 * @param participantComment the participantComment to set
	 */
	public void setParticipantComment(WorkflowParticipantComment participantComment) {
		this.participantComment = participantComment;
	}
	/**
	 * @return the contentReviewRating
	 */
	public ContentReviewRating getContentReviewRating() {
		return contentReviewRating;
	}
	/**
	 * @param contentReviewRating the contentReviewRating to set
	 */
	public void setContentReviewRating(ContentReviewRating contentReviewRating) {
		this.contentReviewRating = contentReviewRating;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WorkflowParticipant [communicatedDate=" + communicatedDate
				+ ", startDate=" + startDate + ", endDate=" + endDate
				+ ", participantType=" + participantType + ", courseWorkflow="
				+ courseWorkflow + ", participantComment=" + participantComment
				+ "]";
	}
	
}

package com.ziksana.domain.course;

import java.util.Date;
import java.util.List;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class WorkflowParticipant extends AuditHistory {
	
	public WorkflowParticipant(){
		this.participantType=ParticipantType.PEER_REVIEWER;
	}
	
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
	private Integer			 			participantTypeId 		= null;
	private ContentReviewWorkflow 		courseWorkflow 			= null;
	private MemberPersona				participateMemberRole   = null;
	private WorkflowParticipantComment 	participantComment 		= null;
	private List<ContentReviewRating>	authorReviewRatingList 	= null;
	
	/**
	 * @return the participantId
	 */
	public ZID getParticipantId() {
		return participantId;
	}
	/**
	 * @param participantId the participantId to set
	 */
	public void setParticipantId(Integer participantId) {
		this.participantId = new IntegerZID(participantId);
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
	 * @return the participateMemberRole
	 */
	public MemberPersona getParticipateMemberRole() {
		return participateMemberRole;
	}
	/**
	 * @param participateMemberRole the participateMemberRole to set
	 */
	public void setParticipateMemberRole(MemberPersona participateMemberRole) {
		this.participateMemberRole = participateMemberRole;
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
	@Override
	public String toString() {
		return "WorkflowParticipant [communicatedDate=" + communicatedDate
				+ ", startDate=" + startDate + ", endDate=" + endDate
				+ ", participantType=" + participantType + ", courseWorkflow="
				+ courseWorkflow + ", participantComment=" + participantComment
				+ "]";
	}

	/**
	 * @return the authorReviewRatingList
	 */
	public List<ContentReviewRating> getAuthorReviewRatingList() {
		return authorReviewRatingList;
	}

	/**
	 * @param authorReviewRatingList the authorReviewRatingList to set
	 */
	public void setAuthorReviewRatingList(List<ContentReviewRating> authorReviewRatingList) {
		this.authorReviewRatingList = authorReviewRatingList;
	}

	/**
	 * @return the participantTypeId
	 */
	public Integer getParticipantTypeId() {
		return participantTypeId;
	}

	/**
	 * @param participantTypeId the participantTypeId to set
	 */
	public void setParticipantTypeId(Integer participantTypeId) {
		this.participantTypeId = participantTypeId;
	}
	
}

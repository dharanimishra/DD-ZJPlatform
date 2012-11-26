
package com.ziksana.domain.course;

import java.util.Date;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class WorkflowParticipantComment extends AuditHistory {
	
	public WorkflowParticipantComment(String comment, Date createDate,
			Criticality criticality, String remarks, WorkflowItemStatus status) {
		this.comment = comment;
		this.createDate = createDate;
		this.criticality = criticality;
		this.remarks = remarks;
		this.status = status;
	}
	
	private ZID 				participantCommentId;
	private String 				comment 			= null;
	private Date 				createDate 			= null;
	private Criticality 		criticality 		= null;
	private Integer		 		criticalityId 		= null;
	private String 				remarks 			= null;
	private WorkflowItemStatus 	status 				= null;
	private Integer			 	statusId			= null;
	private WorkflowParticipant participant 		= null;
	
	/**
	 * @return the participantCommentId
	 */
	public ZID getParticipantCommentId() {
		return participantCommentId;
	}
	/**
	 * @param participantCommentId the participantCommentId to set
	 */
	public void setParticipantCommentId(Integer participantCommentId) {
		this.participantCommentId = new IntegerZID(participantCommentId);
	}
	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * @return the criticality
	 */
	public Criticality getCriticality() {
		return criticality;
	}
	/**
	 * @param criticality the criticality to set
	 */
	public void setCriticality(Criticality criticality) {
		if(criticalityId!=null){
			criticality = Criticality.getCriticality(criticalityId);
		}
		this.criticality = criticality;
	}
	/**
	 * @return the criticalityId
	 */
	public Integer getCriticalityId() {
		return criticalityId;
	}
	/**
	 * @param criticalityId the criticalityId to set
	 */
	public void setCriticalityId(Integer criticalityId) {
		this.criticalityId = criticalityId;
	}
	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * @return the status
	 */
	public WorkflowItemStatus getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(WorkflowItemStatus status) {
		if(statusId!=null){
			status = WorkflowItemStatus.getWorkflowItemStatus(statusId);
		}
		this.status = status;
	}
	/**
	 * @return the statusId
	 */
	public Integer getStatusId() {
		return statusId;
	}
	/**
	 * @param statusId the statusId to set
	 */
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	/**
	 * @return the participant
	 */
	public WorkflowParticipant getParticipant() {
		return participant;
	}
	/**
	 * @param participant the participant to set
	 */
	public void setParticipant(WorkflowParticipant participant) {
		this.participant = participant;
	}

	@Override
	public String toString() {
		return "WorkflowParticipantComment [comment=" + comment
				+ ", createDate=" + createDate + ", criticality=" + criticality
				+ ", remarks=" + remarks + ", status=" + status + "]";
	}
	
	

}

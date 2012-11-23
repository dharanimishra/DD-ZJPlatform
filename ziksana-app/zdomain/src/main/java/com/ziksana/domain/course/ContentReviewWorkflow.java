package com.ziksana.domain.course;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class ContentReviewWorkflow extends AuditHistory {
	
	public ContentReviewWorkflow(WorkflowType workflowType, String notes) {
		this.workflowType = workflowType;
		this.notes = notes;
	}

	private ZID 							contentReviewWorkflowId;
	private WorkflowType 					workflowType 			= null;
	private Integer		 					workflowTypeId 			= null;
	private Timestamp 						completeBy 				= null;
	private String 							notes					= null;
	private LearningContentReviewProgress 	reviewProgress 			= null;
	private List<WorkflowParticipant>		reviewerList			= null;
	private Date							createDate				= null;
	/**
	 * @return the contentReviewWorkflowId
	 */
	public ZID getContentReviewWorkflowId() {
		return contentReviewWorkflowId;
	}
	/**
	 * @param contentReviewWorkflowId the contentReviewWorkflowId to set
	 */
	public void setContentReviewWorkflowId(ZID contentReviewWorkflowId) {
		this.contentReviewWorkflowId = contentReviewWorkflowId;
	}
	/**
	 * @return the workflowType
	 */
	public WorkflowType getWorkflowType() {
		return workflowType;
	}
	/**
	 * @return the workflowTypeId
	 */
	public Integer getWorkflowTypeId() {
		return workflowTypeId;
	}
	/**
	 * @param workflowTypeId the workflowTypeId to set
	 */
	public void setWorkflowTypeId(Integer workflowTypeId) {
		this.workflowTypeId = workflowTypeId;
	}
	/**
	 * @param workflowType the workflowType to set
	 */
	public void setWorkflowType(WorkflowType workflowType) {
		
		if(workflowTypeId!=null){
			workflowType = WorkflowType.getWorkflowType(workflowTypeId);
		}
		this.workflowType = workflowType;
	}
	/**
	 * @return the completeBy
	 */
	public Timestamp getCompleteBy() {
		return completeBy;
	}
	/**
	 * @param completeBy the completeBy to set
	 */
	public void setCompleteBy(Timestamp completeBy) {
		this.completeBy = completeBy;
	}
	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}
	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}
	/**
	 * @return the reviewProgress
	 */
	public LearningContentReviewProgress getReviewProgress() {
		return reviewProgress;
	}
	/**
	 * @param reviewProgress the reviewProgress to set
	 */
	public void setReviewProgress(LearningContentReviewProgress reviewProgress) {
		this.reviewProgress = reviewProgress;
	}
	
	/**
	 * @return the reviewerList
	 */
	public List<WorkflowParticipant> getReviewerList() {
		return reviewerList;
	}
	/**
	 * @param reviewerList the reviewerList to set
	 */
	public void setReviewerList(List<WorkflowParticipant> reviewerList) {
		this.reviewerList = reviewerList;
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
	@Override
	public String toString() {
		return "ContentReviewWorkflow [workflowType=" + workflowType
				+ ", completeBy=" + completeBy + ", notes=" + notes + "]";
	}

}

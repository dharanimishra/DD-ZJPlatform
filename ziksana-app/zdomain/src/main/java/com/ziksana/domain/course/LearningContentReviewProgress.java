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
public class LearningContentReviewProgress extends AuditHistory {

	public LearningContentReviewProgress(Date startDate, Date endDate,
			Duration totalDuration, String description) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalDuration = totalDuration;
		this.description = description;
	}

	private ZID 							reviewProgressId;
	private Date 							startDate					= null;
	private Date 							endDate						= null;
	private Duration						totalDuration				= null;
	private Integer 						degreeOfCompletion			= null;
	private String 							description 				= null;
	private Rating 							averageRating 				= null;
	private Course							course						= null;
	private LearningComponent				learningComponent 			= null;
	private LearningComponentContent		learningComponentContent	= null;
	private MemberPersona					authoringMemberRole			= null;
	private List<ContentReviewRating>		contentReviewRatingList		= null;
	private ContentReviewWorkflow			contentReviewWorkflow		= null;
	
	/**
	 * @return the reviewProgressId
	 */
	public ZID getReviewProgressId() {
		return reviewProgressId;
	}
	/**
	 * @param reviewProgressId the reviewProgressId to set
	 */
	public void setReviewProgressId(Integer reviewProgressId) {
		this.reviewProgressId = new IntegerZID(reviewProgressId);
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
	 * @return the totalDuration
	 */
	public Duration getTotalDuration() {
		return totalDuration;
	}
	/**
	 * @param totalDuration the totalDuration to set
	 */
	public void setTotalDuration(Duration totalDuration) {
		this.totalDuration = totalDuration;
	}
	/**
	 * @return the degreeOfCompletion
	 */
	public Integer getDegreeOfCompletion() {
		return degreeOfCompletion;
	}
	/**
	 * @param degreeOfCompletion the degreeOfCompletion to set
	 */
	public void setDegreeOfCompletion(Integer degreeOfCompletion) {
		this.degreeOfCompletion = degreeOfCompletion;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the averageRating
	 */
	public Rating getAverageRating() {
		return averageRating;
	}
	/**
	 * @param averageRating the averageRating to set
	 */
	public void setAverageRating(Rating averageRating) {
		this.averageRating = averageRating;
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
	 * @return the learningComponent
	 */
	public LearningComponent getLearningComponent() {
		return learningComponent;
	}
	/**
	 * @param learningComponent the learningComponent to set
	 */
	public void setLearningComponent(LearningComponent learningComponent) {
		this.learningComponent = learningComponent;
	}
	/**
	 * @return the learningComponentContent
	 */
	public LearningComponentContent getLearningComponentContent() {
		return learningComponentContent;
	}
	/**
	 * @param learningComponentContent the learningComponentContent to set
	 */
	public void setLearningComponentContent(LearningComponentContent learningComponentContent) {
		this.learningComponentContent = learningComponentContent;
	}
	/**
	 * @return the authoringMemberRole
	 */
	public MemberPersona getAuthoringMemberRole() {
		return authoringMemberRole;
	}
	/**
	 * @param authoringMemberRole the authoringMemberRole to set
	 */
	public void setAuthoringMemberRole(MemberPersona authoringMemberRole) {
		this.authoringMemberRole = authoringMemberRole;
	}
	/**
	 * @return the contentRevieweRatingList
	 */
	public List<ContentReviewRating> getContentReviewRatingList() {
		return contentReviewRatingList;
	}
	/**
	 * @param contentRevieweRatingList the contentRevieweRatingList to set
	 */
	public void setContentReviewRatingList(List<ContentReviewRating> contentReviewRatingList) {
		this.contentReviewRatingList = contentReviewRatingList;
	}
	/**
	 * @return the contentRevieweWorkflow
	 */
	public ContentReviewWorkflow getContentReviewWorkflow() {
		return contentReviewWorkflow;
	}
	/**
	 * @param contentRevieweWorkflow the contentRevieweWorkflow to set
	 */
	public void setContentReviewWorkflow(ContentReviewWorkflow contentReviewWorkflow) {
		this.contentReviewWorkflow = contentReviewWorkflow;
	}
	@Override
	public String toString() {
		return "LearningContentReviewProgress [startDate=" + startDate
				+ ", endDate=" + endDate + ", totalDuration=" + totalDuration
				+ ", degreeOfCompletion=" + degreeOfCompletion
				+ ", description=" + description + "]";
	}
	
}

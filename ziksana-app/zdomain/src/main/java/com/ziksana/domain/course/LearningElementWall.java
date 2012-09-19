package com.ziksana.domain.course;

import java.util.Date;

public class LearningElementWall {
	/**
	 * This field corresponds to the database column
	 * corlearningelementwall.elementWallId
	 */
	private Integer elementWallId;

	/**
	 * This field corresponds to the database column
	 * corlearningelementwall.StartDate
	 */
	private Date startDate;

	/**
	 * This field corresponds to the database column
	 * corlearningelementwall.EndDate
	 */
	private Date endDate;

	/**
	 * This field corresponds to the database column
	 * corlearningelementwall.Message
	 */
	private String message;

	/**
	 * This field corresponds to the database column
	 * corlearningelementwall.VotingIndicator
	 */
	private Boolean votingIndicator;

	/**
	 * This field corresponds to the database column
	 * corlearningelementwall.MessageVisibility
	 */
	private Integer messageVisibility;

	/**
	 * This field corresponds to the database column
	 * corlearningelementwall.NumberofResponses
	 */
	private Integer numberofResponses;

	/**
	 * This field corresponds to the database column
	 * corlearningelementwall.ResponseSentiment
	 */
	private Integer responseSentiment;

	/**
	 * This field corresponds to the database column
	 * corlearningelementwall.MessageType
	 */
	private Integer messageType;

	/**
	 * This field corresponds to the database column
	 * corlearningelementwall.LearningComponentId
	 */
	private Integer learningComponentId;

	/**
	 * This field corresponds to the database column
	 * corlearningelementwall.MemberRoleId
	 */
	private Integer memberRoleId;

	/**
	 * This field corresponds to the database column
	 * corlearningelementwall.CurriculumCourseId
	 */
	private Integer curriculumCourseId;

	/**
	 * This field corresponds to the database column
	 * corlearningelementwall.CourseId
	 */
	private Integer courseId;

	/**
	 * This field corresponds to the database column
	 * corlearningelementwall.LearningContentId
	 */
	private Integer learningContentId;

	/**
	 * This field corresponds to the database column
	 * corlearningelementwall.LearningContentId
	 */
	private Integer learningProgramId;

	/**
	 * This method returns the value of the database column
	 * corlearningelementwall.elementWallId
	 * 
	 * @return the value of corlearningelementwall.elementWallId
	 */
	public Integer getElementWallId() {
		return elementWallId;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningelementwall.elementWallId
	 * 
	 * @param elementWallId
	 *            the value for corlearningelementwall.elementWallId
	 */
	public void setElementWallId(Integer elementWallId) {
		this.elementWallId = elementWallId;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningelementwall.StartDate
	 * 
	 * @return the value of corlearningelementwall.StartDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningelementwall.StartDate
	 * 
	 * @param startDate
	 *            the value for corlearningelementwall.StartDate
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningelementwall.EndDate
	 * 
	 * @return the value of corlearningelementwall.EndDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningelementwall.EndDate
	 * 
	 * @param endDate
	 *            the value for corlearningelementwall.EndDate
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningelementwall.Message
	 * 
	 * @return the value of corlearningelementwall.Message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningelementwall.Message
	 * 
	 * @param message
	 *            the value for corlearningelementwall.Message
	 */
	public void setMessage(String message) {
		this.message = message == null ? null : message.trim();
	}

	/**
	 * This method returns the value of the database column
	 * corlearningelementwall.VotingIndicator
	 * 
	 * @return the value of corlearningelementwall.VotingIndicator
	 */
	public Boolean getVotingIndicator() {
		return votingIndicator;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningelementwall.VotingIndicator
	 * 
	 * @param votingIndicator
	 *            the value for corlearningelementwall.VotingIndicator
	 */
	public void setVotingIndicator(Boolean votingIndicator) {
		this.votingIndicator = votingIndicator;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningelementwall.MessageVisibility
	 * 
	 * @return the value of corlearningelementwall.MessageVisibility
	 */
	public Integer getMessageVisibility() {
		return messageVisibility;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningelementwall.MessageVisibility
	 * 
	 * @param messageVisibility
	 *            the value for corlearningelementwall.MessageVisibility
	 */
	public void setMessageVisibility(Integer messageVisibility) {
		this.messageVisibility = messageVisibility;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningelementwall.NumberofResponses
	 * 
	 * @return the value of corlearningelementwall.NumberofResponses
	 */
	public Integer getNumberofResponses() {
		return numberofResponses;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningelementwall.NumberofResponses
	 * 
	 * @param numberofResponses
	 *            the value for corlearningelementwall.NumberofResponses
	 */
	public void setNumberofResponses(Integer numberofResponses) {
		this.numberofResponses = numberofResponses;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningelementwall.ResponseSentiment
	 * 
	 * @return the value of corlearningelementwall.ResponseSentiment
	 */
	public Integer getResponseSentiment() {
		return responseSentiment;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningelementwall.ResponseSentiment
	 * 
	 * @param responseSentiment
	 *            the value for corlearningelementwall.ResponseSentiment
	 */
	public void setResponseSentiment(Integer responseSentiment) {
		this.responseSentiment = responseSentiment;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningelementwall.MessageType
	 * 
	 * @return the value of corlearningelementwall.MessageType
	 */
	public Integer getMessageType() {
		return messageType;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningelementwall.MessageType
	 * 
	 * @param messageType
	 *            the value for corlearningelementwall.MessageType
	 */
	public void setMessageType(Integer messageType) {
		this.messageType = messageType;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningelementwall.LearningComponentId
	 * 
	 * @return the value of corlearningelementwall.LearningComponentId
	 */
	public Integer getLearningComponentId() {
		return learningComponentId;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningelementwall.LearningComponentId
	 * 
	 * @param learningComponentId
	 *            the value for corlearningelementwall.LearningComponentId
	 */
	public void setLearningComponentId(Integer learningComponentId) {
		this.learningComponentId = learningComponentId;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningelementwall.MemberRoleId
	 * 
	 * @return the value of corlearningelementwall.MemberRoleId
	 */
	public Integer getMemberRoleId() {
		return memberRoleId;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningelementwall.MemberRoleId
	 * 
	 * @param memberRoleId
	 *            the value for corlearningelementwall.MemberRoleId
	 */
	public void setMemberRoleId(Integer memberRoleId) {
		this.memberRoleId = memberRoleId;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningelementwall.CurriculumCourseId
	 * 
	 * @return the value of corlearningelementwall.CurriculumCourseId
	 */
	public Integer getCurriculumCourseId() {
		return curriculumCourseId;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningelementwall.CurriculumCourseId
	 * 
	 * @param curriculumCourseId
	 *            the value for corlearningelementwall.CurriculumCourseId
	 */
	public void setCurriculumCourseId(Integer curriculumCourseId) {
		this.curriculumCourseId = curriculumCourseId;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningelementwall.CourseId
	 * 
	 * @return the value of corlearningelementwall.CourseId
	 */
	public Integer getCourseId() {
		return courseId;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningelementwall.CourseId
	 * 
	 * @param courseId
	 *            the value for corlearningelementwall.CourseId
	 */
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningelementwall.LearningContentId
	 * 
	 * @return the value of corlearningelementwall.LearningContentId
	 */
	public Integer getLearningContentId() {
		return learningContentId;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningelementwall.LearningContentId
	 * 
	 * @param learningContentId
	 *            the value for corlearningelementwall.LearningContentId
	 */
	public void setLearningContentId(Integer learningContentId) {
		this.learningContentId = learningContentId;
	}

	/**
	 * @return the learningProgramId
	 */
	public Integer getLearningProgramId() {
		return learningProgramId;
	}

	/**
	 * @param learningProgramId the learningProgramId to set
	 */
	public void setLearningProgramId(Integer learningProgramId) {
		this.learningProgramId = learningProgramId;
	}
}
package com.ziksana.domain.course;

import java.awt.TrayIcon.MessageType;
import java.util.Date;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.domain.member.MemberPersona;

public class LearningElementWall extends AuditHistory{
	
	private Integer elementWallId;
	private Date startDate;
	private Date endDate;
	private String message;
	private Boolean votingIndicator;
	private MessageVisibility messageVisibility;
	private Integer numberofResponses;
	private Integer responseSentiment;
	private MessageType messageType;
	private LearningComponent learningComponent;
	private MemberPersona postingMemberPersona;
	private CurriculumCourse curriculumCourse;
	private Course course;
	private LearningContent learningContent;
	private LearningProgram learningProgram;

	/**
	 * @return the value of corlearningelementwall.elementWallId
	 */
	public Integer getElementWallId() {
		return elementWallId;
	}

	/**
	 * @param elementWallId
	 *            the value for corlearningelementwall.elementWallId
	 */
	public void setElementWallId(Integer elementWallId) {
		this.elementWallId = elementWallId;
	}

	/**
	 * @return the value of corlearningelementwall.StartDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the value for corlearningelementwall.StartDate
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the value of corlearningelementwall.EndDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the value for corlearningelementwall.EndDate
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the value of corlearningelementwall.Message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the value for corlearningelementwall.Message
	 */
	public void setMessage(String message) {
		this.message = message == null ? null : message.trim();
	}

	/**
	 * @return the value of corlearningelementwall.VotingIndicator
	 */
	public Boolean getVotingIndicator() {
		return votingIndicator;
	}

	/**
	 * @param votingIndicator
	 *            the value for corlearningelementwall.VotingIndicator
	 */
	public void setVotingIndicator(Boolean votingIndicator) {
		this.votingIndicator = votingIndicator;
	}

	/**
	 * @return the value of corlearningelementwall.NumberofResponses
	 */
	public Integer getNumberofResponses() {
		return numberofResponses;
	}

	/**
	 * @param numberofResponses
	 *            the value for corlearningelementwall.NumberofResponses
	 */
	public void setNumberofResponses(Integer numberofResponses) {
		this.numberofResponses = numberofResponses;
	}

	/**
	 * @return the value of corlearningelementwall.ResponseSentiment
	 */
	public Integer getResponseSentiment() {
		return responseSentiment;
	}

	/**
	 * @param responseSentiment
	 *            the value for corlearningelementwall.ResponseSentiment
	 */
	public void setResponseSentiment(Integer responseSentiment) {
		this.responseSentiment = responseSentiment;
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
	 * @return the messageType
	 */
	public MessageType getMessageType() {
		return messageType;
	}

	/**
	 * @param messageType the messageType to set
	 */
	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
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
	 * @return the learningContent
	 */
	public LearningContent getLearningContent() {
		return learningContent;
	}

	/**
	 * @param learningContent the learningContent to set
	 */
	public void setLearningContent(LearningContent learningContent) {
		this.learningContent = learningContent;
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
}
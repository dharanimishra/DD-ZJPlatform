package com.ziksana.domain.assessment;

import java.util.Date;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.domain.course.LearningComponent;
import com.ziksana.domain.member.MemberPersona;

public class AssignmentTest extends AuditHistory{

	private Integer assignmentTestId;
	private Boolean active;
	private Date usageStartDate;
	private Date usageEndDate;
	private String name;
	private TestType testType;
	private String assignmentContent;
	private DifficultyLevel dificultyLevel;
	private String instruction;
	private Boolean zeniCreatedIndicator;
	private Boolean learnerCreatedIndicator;
	private Boolean multipleAttemptsAllowedIndicator;
	private Boolean openforPeerEvaluationIndicator;
	private Boolean asynchronousIndicator;
	private Boolean proctoringNeededIndicator;
	private Integer answerWithinTime;
	private AssignmentStatus status;
	private LearningComponent learningComponent;
	private MemberPersona creatorMemberPersona;
	/**
	 * @return the assignmentTestId
	 */
	public Integer getAssignmentTestId() {
		return assignmentTestId;
	}
	/**
	 * @param assignmentTestId the assignmentTestId to set
	 */
	public void setAssignmentTestId(Integer assignmentTestId) {
		this.assignmentTestId = assignmentTestId;
	}
	/**
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}
	/**
	 * @return the usageStartDate
	 */
	public Date getUsageStartDate() {
		return usageStartDate;
	}
	/**
	 * @param usageStartDate the usageStartDate to set
	 */
	public void setUsageStartDate(Date usageStartDate) {
		this.usageStartDate = usageStartDate;
	}
	/**
	 * @return the usageEndDate
	 */
	public Date getUsageEndDate() {
		return usageEndDate;
	}
	/**
	 * @param usageEndDate the usageEndDate to set
	 */
	public void setUsageEndDate(Date usageEndDate) {
		this.usageEndDate = usageEndDate;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the testType
	 */
	public TestType getTestType() {
		return testType;
	}
	/**
	 * @param testType the testType to set
	 */
	public void setTestType(TestType testType) {
		this.testType = testType;
	}
	/**
	 * @return the assignmentContent
	 */
	public String getAssignmentContent() {
		return assignmentContent;
	}
	/**
	 * @param assignmentContent the assignmentContent to set
	 */
	public void setAssignmentContent(String assignmentContent) {
		this.assignmentContent = assignmentContent;
	}
	/**
	 * @return the dificultyLevel
	 */
	public DifficultyLevel getDificultyLevel() {
		return dificultyLevel;
	}
	/**
	 * @param dificultyLevel the dificultyLevel to set
	 */
	public void setDificultyLevel(DifficultyLevel dificultyLevel) {
		this.dificultyLevel = dificultyLevel;
	}
	/**
	 * @return the instruction
	 */
	public String getInstruction() {
		return instruction;
	}
	/**
	 * @param instruction the instruction to set
	 */
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	/**
	 * @return the zeniCreatedIndicator
	 */
	public Boolean getZeniCreatedIndicator() {
		return zeniCreatedIndicator;
	}
	/**
	 * @param zeniCreatedIndicator the zeniCreatedIndicator to set
	 */
	public void setZeniCreatedIndicator(Boolean zeniCreatedIndicator) {
		this.zeniCreatedIndicator = zeniCreatedIndicator;
	}
	/**
	 * @return the learnerCreatedIndicator
	 */
	public Boolean getLearnerCreatedIndicator() {
		return learnerCreatedIndicator;
	}
	/**
	 * @param learnerCreatedIndicator the learnerCreatedIndicator to set
	 */
	public void setLearnerCreatedIndicator(Boolean learnerCreatedIndicator) {
		this.learnerCreatedIndicator = learnerCreatedIndicator;
	}
	/**
	 * @return the multipleAttemptsAllowedIndicator
	 */
	public Boolean getMultipleAttemptsAllowedIndicator() {
		return multipleAttemptsAllowedIndicator;
	}
	/**
	 * @param multipleAttemptsAllowedIndicator the multipleAttemptsAllowedIndicator to set
	 */
	public void setMultipleAttemptsAllowedIndicator(
			Boolean multipleAttemptsAllowedIndicator) {
		this.multipleAttemptsAllowedIndicator = multipleAttemptsAllowedIndicator;
	}
	/**
	 * @return the openforPeerEvaluationIndicator
	 */
	public Boolean getOpenforPeerEvaluationIndicator() {
		return openforPeerEvaluationIndicator;
	}
	/**
	 * @param openforPeerEvaluationIndicator the openforPeerEvaluationIndicator to set
	 */
	public void setOpenforPeerEvaluationIndicator(
			Boolean openforPeerEvaluationIndicator) {
		this.openforPeerEvaluationIndicator = openforPeerEvaluationIndicator;
	}
	/**
	 * @return the asynchronousIndicator
	 */
	public Boolean getAsynchronousIndicator() {
		return asynchronousIndicator;
	}
	/**
	 * @param asynchronousIndicator the asynchronousIndicator to set
	 */
	public void setAsynchronousIndicator(Boolean asynchronousIndicator) {
		this.asynchronousIndicator = asynchronousIndicator;
	}
	/**
	 * @return the proctoringNeededIndicator
	 */
	public Boolean getProctoringNeededIndicator() {
		return proctoringNeededIndicator;
	}
	/**
	 * @param proctoringNeededIndicator the proctoringNeededIndicator to set
	 */
	public void setProctoringNeededIndicator(Boolean proctoringNeededIndicator) {
		this.proctoringNeededIndicator = proctoringNeededIndicator;
	}
	/**
	 * @return the answerWithinTime
	 */
	public Integer getAnswerWithinTime() {
		return answerWithinTime;
	}
	/**
	 * @param answerWithinTime the answerWithinTime to set
	 */
	public void setAnswerWithinTime(Integer answerWithinTime) {
		this.answerWithinTime = answerWithinTime;
	}
	/**
	 * @return the status
	 */
	public AssignmentStatus getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(AssignmentStatus status) {
		this.status = status;
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
	 * @return the creatorMemberPersona
	 */
	public MemberPersona getCreatorMemberPersona() {
		return creatorMemberPersona;
	}
	/**
	 * @param creatorMemberPersona the creatorMemberPersona to set
	 */
	public void setCreatorMemberPersona(MemberPersona creatorMemberPersona) {
		this.creatorMemberPersona = creatorMemberPersona;
	}

}
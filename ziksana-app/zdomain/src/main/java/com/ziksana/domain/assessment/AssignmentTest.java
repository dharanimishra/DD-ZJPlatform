package com.ziksana.domain.assessment;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.domain.course.LearningComponent;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class AssignmentTest extends AuditHistory{


	public AssignmentTest(){
		
	}
	
	public AssignmentTest(String name, TestType testType,
			String assignmentContent, DifficultyLevel dificultyLevel,
			String instruction, Integer totalPoints, Status status) {
		this.name = name;
		this.testType = testType;
		this.assignmentContent = assignmentContent;
		this.dificultyLevel = dificultyLevel;
		this.instruction = instruction;
		this.totalPoints = totalPoints;
		this.status = status;
	}

	private ZID 					assignmentTestId;
	private Boolean 				active 							= null;
	private String 					name 							= null;
	private TestType 				testType 						= null;
	private String 					assignmentContent 				= null;
	private DifficultyLevel 		dificultyLevel 					= null;
	private String 					instruction 					= null;
	private Boolean 				multipleAttemptsAllowedIndicator = null;
	private Boolean 				openforPeerEvaluationIndicator 	= null;
	private Boolean 				asynchronousIndicator 			= null;
	private Integer 				totalPoints 					= null;
	private Boolean 				proctoredIndicator 				= null;
	private Integer 				answerWithinTime 				= null;
	private Status 					status 							= null;
	private AssignmentContentType	assignmentContentType			= null;
	private LearningComponent 		learningComponent 				= null;
	private AssignmentTestSettings 	assignmentTestSettings 			= null;
	private MemberPersona 			creatorMemberPersona			= null;
	private AssignmentTest			test							= null; 
	private AssignmentTestRubric	testRubric						= null;
	
	
	
	/**
	 * @return the assignmentTestId
	 */
	public ZID getAssignmentTestId() {
		return assignmentTestId;
	}
	/**
	 * @param assignmentTestId the assignmentTestId to set
	 */
	public void setAssignmentTestId(ZID assignmentTestId) {
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
	public Status getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
	/**
	 * @return the assignmentContentType
	 */
	public AssignmentContentType getAssignmentContentType() {
		return assignmentContentType;
	}

	/**
	 * @param assignmentContentType the assignmentContentType to set
	 */
	public void setAssignmentContentType(AssignmentContentType assignmentContentType) {
		this.assignmentContentType = assignmentContentType;
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
	/**
	 * @return the totalPoints
	 */
	public Integer getTotalPoints() {
		return totalPoints;
	}
	/**
	 * @param totalPoints the totalPoints to set
	 */
	public void setTotalPoints(Integer totalPoints) {
		this.totalPoints = totalPoints;
	}
	/**
	 * @return the proctoredIndicator
	 */
	public Boolean getProctoredIndicator() {
		return proctoredIndicator;
	}
	/**
	 * @param proctoredIndicator the proctoredIndicator to set
	 */
	public void setProctoredIndicator(Boolean proctoredIndicator) {
		this.proctoredIndicator = proctoredIndicator;
	}
	/**
	 * @return the assignmentTestSettings
	 */
	public AssignmentTestSettings getAssignmentTestSettings() {
		return assignmentTestSettings;
	}
	/**
	 * @param assignmentTestSettings the assignmentTestSettings to set
	 */
	public void setAssignmentTestSettings(AssignmentTestSettings assignmentTestSettings) {
		this.assignmentTestSettings = assignmentTestSettings;
	}

	/**
	 * @return the test
	 */
	public AssignmentTest getTest() {
		return test;
	}

	/**
	 * @param test the test to set
	 */
	public void setTest(AssignmentTest test) {
		this.test = test;
	}

	/**
	 * @return the testRubric
	 */
	public AssignmentTestRubric getTestRubric() {
		return testRubric;
	}

	/**
	 * @param testRubric the testRubric to set
	 */
	public void setTestRubric(AssignmentTestRubric testRubric) {
		this.testRubric = testRubric;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AssignmentTest [name=" + name + ", testType=" + testType
				+ ", assignmentContent=" + assignmentContent
				+ ", dificultyLevel=" + dificultyLevel + ", instruction="
				+ instruction + ", multipleAttemptsAllowedIndicator="
				+ multipleAttemptsAllowedIndicator
				+ ", openforPeerEvaluationIndicator="
				+ openforPeerEvaluationIndicator + ", asynchronousIndicator="
				+ asynchronousIndicator + ", totalPoints=" + totalPoints
				+ ", proctoredIndicator=" + proctoredIndicator
				+ ", answerWithinTime=" + answerWithinTime + ", status="
				+ status + ", assignmentContentType=" + assignmentContentType
				+ ", test=" + test + "]";
	}

}
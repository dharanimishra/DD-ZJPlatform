package com.ziksana.domain.assessment;

import java.util.List;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class Test extends AuditHistory {
	
	public Test(String name, TestType testType, String testContent,
			Status status) {
		this.name = name;
		this.testType = testType;
		this.testContent = testContent;
		this.status = status;
	}

	private ZID 					testId;
	private Boolean 				active 							= null;
	private String 		 			name 							= null;
	private TestType 				testType 						= null;
	private String 					testContent 					= null;
	private DifficultyLevel 		dificultyLevel 					= null;
	private String 					instruction 					= null;
	private Boolean 				isMultipleAttemptsAllowed		= null;
	private Boolean					isZeniCreated					= null;
	private Boolean					isLearnerCreated				= null;
	private Boolean 				isOpenforPeerEvaluation		 	= null;
	private Boolean 				isAsynchronous		 			= null;
	private Integer 				totalPoints 					= null;
	private Boolean 				isProctoringNeeded 				= null;
	private Status 					status 							= null;
	private AssignmentTestSettings 	assignmentTestSettings 			= null;
	private AssignmentTestRubric	testRubric						= null;
	private List<TestQuestion>      testQuestionList				= null;
	private Assignment				assignment						= null;
	
	/**
	 * @return the testId
	 */
	public ZID getTestId() {
		return testId;
	}
	/**
	 * @param testId the testId to set
	 */
	public void setTestId(Integer testId) {
		this.testId = new IntegerZID(testId);
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
	 * @return the testContent
	 */
	public String getTestContent() {
		return testContent;
	}
	/**
	 * @param testContent the testContent to set
	 */
	public void setTestContent(String testContent) {
		this.testContent = testContent;
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
	 * @return the isMultipleAttemptsAllowed
	 */
	public Boolean getIsMultipleAttemptsAllowed() {
		return isMultipleAttemptsAllowed;
	}
	/**
	 * @param isMultipleAttemptsAllowed the isMultipleAttemptsAllowed to set
	 */
	public void setIsMultipleAttemptsAllowed(Boolean isMultipleAttemptsAllowed) {
		this.isMultipleAttemptsAllowed = isMultipleAttemptsAllowed;
	}
	/**
	 * @return the isZeniCreated
	 */
	public Boolean getIsZeniCreated() {
		return isZeniCreated;
	}
	/**
	 * @param isZeniCreated the isZeniCreated to set
	 */
	public void setIsZeniCreated(Boolean isZeniCreated) {
		this.isZeniCreated = isZeniCreated;
	}
	/**
	 * @return the isLearnerCreated
	 */
	public Boolean getIsLearnerCreated() {
		return isLearnerCreated;
	}
	/**
	 * @param isLearnerCreated the isLearnerCreated to set
	 */
	public void setIsLearnerCreated(Boolean isLearnerCreated) {
		this.isLearnerCreated = isLearnerCreated;
	}
	/**
	 * @return the isOpenforPeerEvaluation
	 */
	public Boolean getIsOpenforPeerEvaluation() {
		return isOpenforPeerEvaluation;
	}
	/**
	 * @param isOpenforPeerEvaluation the isOpenforPeerEvaluation to set
	 */
	public void setIsOpenforPeerEvaluation(Boolean isOpenforPeerEvaluation) {
		this.isOpenforPeerEvaluation = isOpenforPeerEvaluation;
	}
	/**
	 * @return the isAsynchronous
	 */
	public Boolean getIsAsynchronous() {
		return isAsynchronous;
	}
	/**
	 * @param isAsynchronous the isAsynchronous to set
	 */
	public void setIsAsynchronous(Boolean isAsynchronous) {
		this.isAsynchronous = isAsynchronous;
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
	 * @return the isProctoringNeeded
	 */
	public Boolean getIsProctoringNeeded() {
		return isProctoringNeeded;
	}
	/**
	 * @param isProctoringNeeded the isProctoringNeeded to set
	 */
	public void setIsProctoringNeeded(Boolean isProctoringNeeded) {
		this.isProctoringNeeded = isProctoringNeeded;
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
	 * @return the assignmentTestSettings
	 */
	public AssignmentTestSettings getAssignmentTestSettings() {
		return assignmentTestSettings;
	}
	/**
	 * @param assignmentTestSettings the assignmentTestSettings to set
	 */
	public void setAssignmentTestSettings(
			AssignmentTestSettings assignmentTestSettings) {
		this.assignmentTestSettings = assignmentTestSettings;
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
	/**
	 * @return the testQuestionList
	 */
	public List<TestQuestion> getTestQuestionList() {
		return testQuestionList;
	}
	/**
	 * @param testQuestionList the testQuestionList to set
	 */
	public void setTestQuestionList(List<TestQuestion> testQuestionList) {
		this.testQuestionList = testQuestionList;
	}

	/**
	 * @return the assignment
	 */
	public Assignment getAssignment() {
		return assignment;
	}
	/**
	 * @param assignment the assignment to set
	 */
	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}
	@Override
	public String toString() {
		return "Test [testId=" + testId + ", active=" + active + ", name="
				+ name + ", testType=" + testType + ", testContent="
				+ testContent + ", dificultyLevel=" + dificultyLevel
				+ ", instruction=" + instruction
				+ ", isMultipleAttemptsAllowed=" + isMultipleAttemptsAllowed
				+ ", isZeniCreated=" + isZeniCreated + ", isLearnerCreated="
				+ isLearnerCreated + ", isOpenforPeerEvaluation="
				+ isOpenforPeerEvaluation + ", isAsynchronous="
				+ isAsynchronous + ", totalPoints=" + totalPoints
				+ ", isProctoringNeeded=" + isProctoringNeeded + ", status="
				+ status + "]";
	}


}

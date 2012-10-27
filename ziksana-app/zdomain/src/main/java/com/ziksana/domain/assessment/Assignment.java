package com.ziksana.domain.assessment;

import java.util.List;
import com.ziksana.domain.common.AuditHistory;
import com.ziksana.domain.course.LearningComponent;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.id.ZID;

/** 
 * This holds the information of Assignment and Test.
 * @author bhashasp
 */
public class Assignment extends AuditHistory{


	public Assignment(String name, String assignmentContent) {
		this.name = name;
		this.assignmentContent = assignmentContent;
	}

	public Assignment(){
		
	}
	
	private ZID 					assignmentId;
	private Boolean 				active 							= null;
	private String 		 			name 							= null;
	private String 					assignmentContent 				= null;
	private Status 					status 							= null;
	private LearningComponent 		learningComponent 				= null;
	private MemberPersona 			creatorMemberPersona			= null;
	private List<Test>				testList						= null;
	
	/**
	 * @return the assignmentTestId
	 */
	public ZID getAssignmentId() {
		return assignmentId;
	}
	/**
	 * @param assignmentTestId the assignmentTestId to set
	 */
	public void setAssignmentTestId(ZID assignmentId) {
		this.assignmentId = assignmentId;
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
	 * @return the testist
	 */
	public List<Test> getTestList() {
		return testList;
	}
	/**
	 * @param testist the testist to set
	 */
	public void setTestList(List<Test> testList) {
		this.testList = testList;
	} 
	
	
	
}
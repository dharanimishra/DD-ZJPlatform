/**
 * 
 */
package com.ziksana.domain.assessment;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class AssignmentTestLink extends AuditHistory {
	
	public AssignmentTestLink(){
		
	}
	

	private ZID 			testLinkId;
	private LinkReason 		linkReason 			= null;
	private String 			description 		= null;
	private Assignment 	sourceAssignmentTest = null;
	private Assignment 	linkedAssignmentTest = null;
	
	
	/**
	 * @return the testLinkId
	 */
	public ZID getTestLinkId() {
		return testLinkId;
	}
	/**
	 * @param testLinkId the testLinkId to set
	 */
	public void setTestLinkId(Integer testLinkId) {
		this.testLinkId = new IntegerZID(testLinkId);
	}
	/**
	 * @return the linkReason
	 */
	public LinkReason getLinkReason() {
		return linkReason;
	}
	/**
	 * @param linkReason the linkReason to set
	 */
	public void setLinkReason(LinkReason linkReason) {
		this.linkReason = linkReason;
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
	 * @return the sourceAssignmentTest
	 */
	public Assignment getSourceAssignmentTest() {
		return sourceAssignmentTest;
	}
	/**
	 * @param sourceAssignmentTest the sourceAssignmentTest to set
	 */
	public void setSourceAssignmentTest(Assignment sourceAssignmentTest) {
		this.sourceAssignmentTest = sourceAssignmentTest;
	}
	/**
	 * @return the linkedAssignmentTest
	 */
	public Assignment getLinkedAssignmentTest() {
		return linkedAssignmentTest;
	}
	/**
	 * @param linkedAssignmentTest the linkedAssignmentTest to set
	 */
	public void setLinkedAssignmentTest(Assignment linkedAssignmentTest) {
		this.linkedAssignmentTest = linkedAssignmentTest;
	}

	@Override
	public String toString() {
		return "AssignmentTestLink [linkReason=" + linkReason
				+ ", description=" + description + "]";
	}

}

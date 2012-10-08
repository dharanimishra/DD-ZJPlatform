/**
 * 
 */
package com.ziksana.domain.assessment;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class AssignmentTestLink extends AuditHistory {
	
	public AssignmentTestLink(){
		
	}
	
	public AssignmentTestLink(String linkReason, String description,
			AssignmentTest sourceAssignmentTest,
			AssignmentTest linkedAssignmentTest) {
		this.linkReason = linkReason;
		this.description = description;
		this.sourceAssignmentTest = sourceAssignmentTest;
		this.linkedAssignmentTest = linkedAssignmentTest;
	}

	private ZID 			testLinkId;
	private String 			linkReason 			= null;
	private String 			description 		= null;
	private AssignmentTest 	sourceAssignmentTest = null;
	private AssignmentTest 	linkedAssignmentTest = null;
	
	
	/**
	 * @return the testLinkId
	 */
	public ZID getTestLinkId() {
		return testLinkId;
	}
	/**
	 * @param testLinkId the testLinkId to set
	 */
	public void setTestLinkId(ZID testLinkId) {
		this.testLinkId = testLinkId;
	}
	/**
	 * @return the linkReason
	 */
	public String getLinkReason() {
		return linkReason;
	}
	/**
	 * @param linkReason the linkReason to set
	 */
	public void setLinkReason(String linkReason) {
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
	public AssignmentTest getSourceAssignmentTest() {
		return sourceAssignmentTest;
	}
	/**
	 * @param sourceAssignmentTest the sourceAssignmentTest to set
	 */
	public void setSourceAssignmentTest(AssignmentTest sourceAssignmentTest) {
		this.sourceAssignmentTest = sourceAssignmentTest;
	}
	/**
	 * @return the linkedAssignmentTest
	 */
	public AssignmentTest getLinkedAssignmentTest() {
		return linkedAssignmentTest;
	}
	/**
	 * @param linkedAssignmentTest the linkedAssignmentTest to set
	 */
	public void setLinkedAssignmentTest(AssignmentTest linkedAssignmentTest) {
		this.linkedAssignmentTest = linkedAssignmentTest;
	}

	@Override
	public String toString() {
		return "AssignmentTestLink [linkReason=" + linkReason
				+ ", description=" + description + "]";
	}

}

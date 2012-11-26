package com.ziksana.domain.assessment;

import java.util.Date;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class PackageTest extends AuditHistory {
	
	private ZID				packageTestId;
	private Date 			creationDate		= null;
	private Boolean 		active 				= null;
	private Assignment 	assignment 		= null;
	private TestPackage		testPackage			= null;
	
	/**
	 * @return the packageTestId
	 */
	public ZID getPackageTestId() {
		return packageTestId;
	}
	/**
	 * @param packageTestId the packageTestId to set
	 */
	public void setPackageTestId(Integer packageTestId) {
		this.packageTestId = new IntegerZID(packageTestId);
	}
	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
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
	 * @return the assignmentTest
	 */
	public Assignment getAssignmentTest() {
		return assignment;
	}
	/**
	 * @param assignment the assignmentTest to set
	 */
	public void setAssignmentTest(Assignment assignment) {
		this.assignment = assignment;
	}
	/**
	 * @return the testPackage
	 */
	public TestPackage getTestPackage() {
		return testPackage;
	}
	/**
	 * @param testPackage the testPackage to set
	 */
	public void setTestPackage(TestPackage testPackage) {
		this.testPackage = testPackage;
	}

}

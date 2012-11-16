package com.ziksana.domain.assessment.member;

import com.ziksana.domain.assessment.Test;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class NextTest {

	private ZID 		nextTestId;
	private Boolean 	active 				= null;
	private TestGrade 	previousTestGrade 	= null;
	private Test		nextTest 			= null;
	
	
	/** 
	 * @return the nextTestId
	 */
	public ZID getNextTestId() {
		return nextTestId;
	}
	/**
	 * @param nextTestId the nextTestId to set
	 */
	public void setNextTestId(ZID nextTestId) {
		this.nextTestId = nextTestId;
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
	 * @return the previousTestGrade
	 */
	public TestGrade getPreviousTestGrade() {
		return previousTestGrade;
	}
	/**
	 * @param previousTestGrade the previousTestGrade to set
	 */
	public void setPreviousTestGrade(TestGrade previousTestGrade) {
		this.previousTestGrade = previousTestGrade;
	}
	/**
	 * @return the nextTest
	 */
	public Test getNextTest() {
		return nextTest;
	}
	/**
	 * @param nextTest the nextTest to set
	 */
	public void setNextTest(Test nextTest) {
		this.nextTest = nextTest;
	}
	
}

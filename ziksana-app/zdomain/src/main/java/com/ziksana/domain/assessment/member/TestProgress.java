package com.ziksana.domain.assessment.member;



import java.sql.Timestamp;

import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class TestProgress {

	private ZID 				testProgressId;
	private Integer 			progress 	= null;
	private Timestamp 			startTime 	= null;
	private Timestamp 			endTime 	= null;
	private StudentTest 		test		= null;
	
	/**
	 * @return the testProgressId
	 */
	public ZID getTestProgressId() {
		return testProgressId;
	}
	/**
	 * @param testProgressId the testProgressId to set
	 */
	public void setTestProgressId(Integer testProgressId) {
		this.testProgressId = new IntegerZID(testProgressId);
	}
	/**
	 * @return the progress
	 */
	public Integer getProgress() {
		return progress;
	}
	/**
	 * @param progress the progress to set
	 */
	public void setProgress(Integer progress) {
		this.progress = progress;
	}
		/**
	 * @return the test
	 */
	public StudentTest getTest() {
		return test;
	}
	/**
	 * @param test the test to set
	 */
	public void setTest(StudentTest test) {
		this.test = test;
	}
	/**
	 * @return the startTime
	 */
	public Timestamp getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return the endTime
	 */
	public Timestamp getEndTime() {
		return endTime;
	}
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	
}

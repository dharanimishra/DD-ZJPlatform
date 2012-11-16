package com.ziksana.domain.assessment.member;

import java.util.Date;

import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class TestProgress {

	private ZID 		testProgressId;
	private Integer 	progress 	= null;
	private Date 		startDate 	= null;
	private Date 		endDate 	= null;
	private StudentTest test		= null;
	
	/**
	 * @return the testProgressId
	 */
	public ZID getTestProgressId() {
		return testProgressId;
	}
	/**
	 * @param testProgressId the testProgressId to set
	 */
	public void setTestProgressId(ZID testProgressId) {
		this.testProgressId = testProgressId;
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
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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

	
}

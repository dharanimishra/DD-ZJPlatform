package com.ziksana.domain.assessment.member;

import java.util.Date;

import com.ziksana.domain.assessment.Test;
import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

/**
 * Holds the Learners Test information. 
 * @author bhashasp
 */
public class StudentTest {
	
	private ZID 				testId;
	private Integer				totalDuration 				= null;
	private Date 				startDate 					= null;
	private Date 				endDate 					= null;
	private Boolean				isAsynchronous      		= null;
	private Boolean 			isProctoringNeeded 			= null;
	private Integer				comparativePosition 		= null;
	private Integer				overAllComparativePosition 	= null;
	private CourseAssignment	subscribedCourseAssignment  = null;
    private Test				learningComponentTest		= null;
    	
    
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
	 * @return the totalDuration
	 */
	public Integer getTotalDuration() {
		return totalDuration;
	}
	/**
	 * @param totalDuration the totalDuration to set
	 */
	public void setTotalDuration(Integer totalDuration) {
		this.totalDuration = totalDuration;
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
	 * @return the comparativePosition
	 */
	public Integer getComparativePosition() {
		return comparativePosition;
	}
	/**
	 * @param comparativePosition the comparativePosition to set
	 */
	public void setComparativePosition(Integer comparativePosition) {
		this.comparativePosition = comparativePosition;
	}
	/**
	 * @return the overAllComparativePosition
	 */
	public Integer getOverAllComparativePosition() {
		return overAllComparativePosition;
	}
	/**
	 * @param overAllComparativePosition the overAllComparativePosition to set
	 */
	public void setOverAllComparativePosition(Integer overAllComparativePosition) {
		this.overAllComparativePosition = overAllComparativePosition;
	}
	/**
	 * @return the subscribedCourseAssignment
	 */
	public CourseAssignment getSubscribedCourseAssignment() {
		return subscribedCourseAssignment;
	}
	/**
	 * @param subscribedCourseAssignment the subscribedCourseAssignment to set
	 */
	public void setSubscribedCourseAssignment(
			CourseAssignment subscribedCourseAssignment) {
		this.subscribedCourseAssignment = subscribedCourseAssignment;
	}
	/**
	 * @return the learningComponentTest
	 */
	public Test getLearningComponentTest() {
		return learningComponentTest;
	}
	/**
	 * @param learningComponentTest the learningComponentTest to set
	 */
	public void setLearningComponentTest(Test learningComponentTest) {
		this.learningComponentTest = learningComponentTest;
	}
    
    
				

	
}

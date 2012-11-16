package com.ziksana.domain.assessment.member;

import java.util.Date;
import java.util.List;
import com.ziksana.domain.course.LearningComponent;
import com.ziksana.domain.course.subscription.SubscriptionCourse;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class CourseAssignment {
	
	private ZID 				courseAssignmentId;
	private String 				name		 		= null;
	private Date 				startDate 			= null;
	private Date 				endDate 			= null;
	private Integer 			duration 			= null;
	private Integer 			progress 			= null;
	private SubscriptionCourse 	subscriptionCourse 	= null;
	private LearningComponent 	learningComponent 	= null;
	private List<StudentTest>  	testList 			= null;
	
	/**
	 * @return the courseAssignmentId
	 */
	public ZID getCourseAssignmentId() {
		return courseAssignmentId;
	}
	/**
	 * @param courseAssignmentId the courseAssignmentId to set
	 */
	public void setCourseAssignmentId(ZID courseAssignmentId) {
		this.courseAssignmentId = courseAssignmentId;
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
	 * @return the duration
	 */
	public Integer getDuration() {
		return duration;
	}
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(Integer duration) {
		this.duration = duration;
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
	 * @return the subscriptionCourse
	 */
	public SubscriptionCourse getSubscriptionCourse() {
		return subscriptionCourse;
	}
	/**
	 * @param subscriptionCourse the subscriptionCourse to set
	 */
	public void setSubscriptionCourse(SubscriptionCourse subscriptionCourse) {
		this.subscriptionCourse = subscriptionCourse;
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
	 * @return the testList
	 */
	public List<StudentTest> getTestList() {
		return testList;
	}
	/**
	 * @param testList the testList to set
	 */
	public void setTestList(List<StudentTest> testList) {
		this.testList = testList;
	}

}

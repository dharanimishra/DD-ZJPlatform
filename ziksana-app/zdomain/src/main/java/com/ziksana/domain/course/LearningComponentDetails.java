package com.ziksana.domain.course;

import java.util.ArrayList;
import java.util.List;

import com.ziksana.common.exception.CourseException;

/**
 * This object contains more information about Course
 * @author bhashasp
 */
public class LearningComponentDetails extends LearningComponent{


	public LearningComponentDetails(LearningComponentType learningComponentType) {
		super(learningComponentType);
	}

	private List<LearningComponentContent> 		learningCompContentList				= null;
	private LearningComponentNest 				learningComponentNest 				= null;
	
	private CourseLearningComponent 			courseLearningComponent				= null;
	//private List<CoursePlaybookView> 			coursePlaybookViewList				= null;
	//private List<LearningElementWall> 			learningElementWallList				= null;
	//private SubscriptionCourseItemCalendar  	subscnCourseItemCalendar			= null; 
/*	private CoursePlaybookView					coursePlaybookView					= null;
	private List<LearningElementWall> 			learningElementWalls				= null;
	private List<LearningContentReviewProgress> learningContentReviewProgressList	= null;
	private List<AssignmentTest> 				assignmentTests						= null;
	//private List<TestPackage> 				testPackageList						= null;
	private List<LearningComponentTagcloud> 	learningComponentTagcloudList		= null;
*/
	/**
	 * Add Learning Component Content as a course learning component.
	 * @param learningComponent
	 */
	public LearningComponentContent getLearningComponentContent(int index) throws CourseException{
		
		if(learningCompContentList==null){
			throw new CourseException("learningCompContents is set null");
		}
		try{
			return learningCompContentList.get(index);
		}catch(Exception e){
			throw new CourseException("Learning Component  Content at index ["+index+"] at not found");
		}
	}

	
	/**
	 * Adding LearningComponentContent to LearningComponent based on
	 * LearningComponent.componenttype
	 * @param learningComponent
	 */
	public void addLearningComponentContent(
			LearningComponentContent learningComponentContent) {
		if(learningCompContentList == null){
			learningCompContentList = new ArrayList<LearningComponentContent>();
		}
			learningComponentContent.setLearningComponent(this);
			
			learningCompContentList.add(learningComponentContent);
	}
	/**
	 * Remove the LearningComponentContent from the list.
	 * 
	 * @param learningComponentId
	 */
	public void removeLearningComponentContent(
			Integer learningComponentContentId) throws CourseException{

		if(learningCompContentList == null){
			throw new CourseException("LearningComponentContent not set in Learning Component ID ["+getLearningComponentId()+"]");
		}
		
		for (LearningComponentContent learningComponentContent : learningCompContentList) {

			if (learningComponentContent.getLearningComponentContentId()
					.equals(learningComponentContentId)) {
				learningCompContentList.remove(learningComponentContent);
			}
		}
	}

	/**
	 * @return the learningComponentNest
	 */
	public LearningComponentNest getLearningComponentNest() {
		return learningComponentNest;
	}

	/**
	 * The attributes(componentNestId, parentLearningComponentId,
	 * nestLearningComponentId) need to add for tree construction.<br>
	 * 
	 * Eg: LearningComponetId:100, having a child of another
	 * Learningcomponentid:200 <br>
	 * componentNestId : 1 , parentLearningComponentId : null ,
	 * nestLearningComponentId : 100<br>
	 * componentNestId : 2 , parentLearningComponentId : 100 ,
	 * nestLearningComponentId : 200
	 * 
	 * @param learningComponentNest
	 *            the learningComponentNest to set
	 */
	public void addLearningComponentNest(
			LearningComponentNest learningComponentNest) {
		this.learningComponentNest = learningComponentNest;
	}

	/**
	 * @return the courseLearningComponent
	 */
	public CourseLearningComponent getCourseLearningComponent() {
		return courseLearningComponent;
	}

	/**
	 * @param courseLearningComponent
	 *            the courseLearningComponent to set
	 */
	public void addCourseLearningComponent(
			CourseLearningComponent courseLearningComponent) {
		this.courseLearningComponent = courseLearningComponent;
	}

	/**
	 * @return the learningCompContentList
	 */
	public List<LearningComponentContent> getLearningCompContentList() {
		return learningCompContentList;
	}

	/**
	 * @param learningCompContentList
	 *            the learningCompContentList to set
	 */
	public void addLearningCompContentList(
			List<LearningComponentContent> learningCompContentList) {
		this.learningCompContentList = learningCompContentList;
	}

/*	*//**
	 * @return the coursePlaybookViewList
	 *//*
	public List<CoursePlaybookView> getCoursePlaybookViewList() {
		return coursePlaybookViewList;
	}

	*//**
	 * @param coursePlaybookViewList the coursePlaybookViewList to set
	 *//*
	public void setCoursePlaybookViewList(
			List<CoursePlaybookView> coursePlaybookViewList) {
		this.coursePlaybookViewList = coursePlaybookViewList;
	}

	*//**
	 * @return the learningElementWallList
	 *//*
	public List<LearningElementWall> getLearningElementWallList() {
		return learningElementWallList;
	}

	*//**
	 * @param learningElementWallList the learningElementWallList to set
	 *//*
	public void setLearningElementWallList(
			List<LearningElementWall> learningElementWallList) {
		this.learningElementWallList = learningElementWallList;
	}

	*//**
	 * @return the subscnCourseItemCalendar
	 *//*
	public SubscriptionCourseItemCalendar getSubscnCourseItemCalendar() {
		return subscnCourseItemCalendar;
	}

	*//**
	 * @param subscnCourseItemCalendar the subscnCourseItemCalendar to set
	 *//*
	public void setSubscnCourseItemCalendar(
			SubscriptionCourseItemCalendar subscnCourseItemCalendar) {
		this.subscnCourseItemCalendar = subscnCourseItemCalendar;
	}

	*//**
	 * @return the coursePlaybookView
	 *//*
	public CoursePlaybookView getCoursePlaybookView() {
		return coursePlaybookView;
	}

	*//**
	 * @param coursePlaybookView the coursePlaybookView to set
	 *//*
	public void setCoursePlaybookView(CoursePlaybookView coursePlaybookView) {
		this.coursePlaybookView = coursePlaybookView;
	}

	*//**
	 * @return the learningElementWalls
	 *//*
	public List<LearningElementWall> getLearningElementWalls() {
		return learningElementWalls;
	}

	*//**
	 * @param learningElementWalls the learningElementWalls to set
	 *//*
	public void setLearningElementWalls(
			List<LearningElementWall> learningElementWalls) {
		this.learningElementWalls = learningElementWalls;
	}

	*//**
	 * @return the learningContentReviewProgressList
	 *//*
	public List<LearningContentReviewProgress> getLearningContentReviewProgressList() {
		return learningContentReviewProgressList;
	}

	*//**
	 * @param learningContentReviewProgressList the learningContentReviewProgressList to set
	 *//*
	public void setLearningContentReviewProgressList(
			List<LearningContentReviewProgress> learningContentReviewProgressList) {
		this.learningContentReviewProgressList = learningContentReviewProgressList;
	}

	*//**
	 * @return the assignmentTests
	 *//*
	public List<AssignmentTest> getAssignmentTests() {
		return assignmentTests;
	}

	*//**
	 * @param assignmentTests the assignmentTests to set
	 *//*
	public void setAssignmentTests(List<AssignmentTest> assignmentTests) {
		this.assignmentTests = assignmentTests;
	}

	*//**
	 * @return the learningComponentTagcloudList
	 *//*
	public List<LearningComponentTagcloud> getLearningComponentTagcloudList() {
		return learningComponentTagcloudList;
	}

	*//**
	 * @param learningComponentTagcloudList the learningComponentTagcloudList to set
	 *//*
	public void setLearningComponentTagcloudList(
			List<LearningComponentTagcloud> learningComponentTagcloudList) {
		this.learningComponentTagcloudList = learningComponentTagcloudList;
	}

*/	/**
	 * @param learningCompContentList the learningCompContentList to set
	 */
	public void setLearningCompContentList(
			List<LearningComponentContent> learningCompContentList) {
		this.learningCompContentList = learningCompContentList;
	}

	/**
	 * @param learningComponentNest the learningComponentNest to set
	 */
	public void setLearningComponentNest(LearningComponentNest learningComponentNest) {
		this.learningComponentNest = learningComponentNest;
	}

	/**
	 * @param courseLearningComponent the courseLearningComponent to set
	 */
	public void setCourseLearningComponent(
			CourseLearningComponent courseLearningComponent) {
		this.courseLearningComponent = courseLearningComponent;
	}

}

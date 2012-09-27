package com.ziksana.domain.course;

import java.util.ArrayList;
import java.util.List;

import com.ziksana.common.exception.CourseException;
import com.ziksana.domain.assessment.AssignmentTest;

/**
 * This contains the association/compositions and course tree construction behavious
 * 
 * @author bhashasp
 */
public class CourseDetails extends Course {

	private List<CourseAdditionalProperty> 			courseAdditionalPropertyList 		= null;
	private List<LearningComponent> 				learningComponents 					= null;
	private List<CourseLearningComponent> 			courseLearningComponentsList 		= null;
	private CoursePlaybook 							coursePlaybook 						= null;
	private List<LearningElementWall> 				learningElementWalls 				= null;
	private List<CourseTagcloud> 					courseTagClouds 					= null;
	private List<CurriculumCourseCalendar> 			currCourseCalendarEntries 			= null;
	private CurriculumCourse 						curriculumCourse 					= null;
	private List<LearningContentReviewProgress> 	learningContentReviewProgressList 	= null;
	private List<AssignmentTest> 					assignmentTests 					= null;
	private List<Announcement> 						announcements 						= null;
	// TODO: below associations/compositions will uncomment later.
	// private CourseContentSecurity 				courseContentSecurity 				= null;
	// private CourseLearningPlanner 				courseLearningPlanner 				= null;
	// private List<Engagement> 					engagements 						= null;
	private LearningComponent 						learningComponent 					= null;
	private LearningComponentContent 				learningComponentContent 			= null;
	private LearningComponentNest 					learningComponentNest 				= null;
	private LearningContent 						learningContent 					= null;

	/**
	 * Add LearningComponent to a course tree.
	 * @param learningComponent
	 */
	public void addLearningComponent(LearningComponentType learningCompType, LearningComponent learningComponent)
			throws CourseException {

		if (learningComponents == null) {
			learningComponents = new ArrayList<LearningComponent>();
		}

		if(learningComponent==null){
			learningComponent = new LearningComponent(learningCompType);
		}
		
		learningComponent.setCourse(this);
		
		// Setting the component nest { parentlearningcomp=null, nestlearncomp=learningComponent }
		learningComponentNest = new LearningComponentNest(null,
				learningComponent);

		learningComponent.getLearningComponentDetails()
				.addLearningComponentNest(learningComponentNest);

		learningComponents.add(learningComponent);
	}

	/**
	 * Adds a child(Learningcomponent/LearningComponentContent) to
	 * parent(LearningComponent) learningcomponent.
	 * 
	 * @param parentLearningCompIndex
	 * @param childLearningCompIndex
	 * @param learningCompContent
	 * @throws CourseException
	 */
	public void addChildNodeToLearningComponent(int parentLearningCompIndex,int childLearningCompIndex, 
			LearningComponentType learningCompType, int learningCompContentIndex,
			LearningComponentContent learningCompContent)
			throws CourseException {
		LearningComponent childLearningComponent = null;

		try {
			if (learningComponents == null) {
				throw new CourseException("Cannot set to Null");
			}
			
			// Adding a Learning component as a child to another
			// learningcomponent
			if (learningCompContent == null && childLearningCompIndex > 0) {

				childLearningComponent = new LearningComponent(learningCompType);

				childLearningComponent
						.setLearningComponentId(childLearningCompIndex);

				learningComponentNest = new LearningComponentNest(
						learningComponent, childLearningComponent);

				// parent learning component nest
				learningComponentNest
						.setLearningComponentParent(learningComponent);

				// learning component as a child
				learningComponentNest
						.setLearningComponentNest(childLearningComponent);

				childLearningComponent.getLearningComponentDetails()
						.addLearningComponentNest(learningComponentNest);
				
				addLearningComponent(learningCompType, childLearningComponent);

			}

			// Adding a Learning caomponentcontent as a child to
			// learningcomponent
			if (learningCompContent != null) {
				
				learningContent = new LearningContent();
				
				List<LearningContentParts> learningContentParts = null;
				learningContent.addLearningContentParts(learningContentParts);
				
				learningCompContent = new LearningComponentContent(childLearningComponent, learningContent);
				
				learningCompContent.getLearrningComponentContentDetails().addLearningContent(learningContent);
				
				learningComponent.getLearningComponentDetails()
						.addLearningComponentContent(learningCompContent);

				learningComponents.add(learningComponent);

			}

		} catch (Exception e) {
			throw new CourseException("Error adding a chlild to learning component ID [ "+parentLearningCompIndex+" ]");
		}

	}

	/**
	 * @param learningComponentId
	 */
	public void removeLearningComponent(Integer learningComponentId)
			throws CourseException {

		if (learningComponents == null) {
			throw new CourseException(
					"LearningComponents not set in Course ID [" + getCourseId()
							+ "]");
		}

		for (LearningComponent learningComponent : learningComponents) {

			if (learningComponent.getLearningComponentId().equals(
					learningComponentId)) {
				learningComponents.remove(learningComponent);
			}
		}
	}

	/**
	 * @param learningComponent
	 */
	public LearningComponent getLearningComponent(int index)
			throws CourseException {

		if (learningComponents == null) {
			throw new CourseException("LearningComponent is set as a null");
		}
		try {
			return learningComponents.get(index);
		} catch (Exception e) {
			throw new CourseException("Learning Component at index [" + index
					+ "] at not found");
		}
	}


	/**
	 * @return the learningComponents
	 */
	public List<LearningComponent> getLearningComponents() {
		return learningComponents;
	}

	/**
	 * @param learningComponents
	 *            the learningComponents to set
	 */
	public void setLearningComponents(List<LearningComponent> learningComponents)
			throws CourseException {

		if (learningComponents == null) {
			throw new CourseException(
					"Cannot set LearningComponents, Course is null");
		}
		this.learningComponents = learningComponents;

		for (LearningComponent learningComponent : learningComponents) {
			learningComponent.setCourse(this);
		}
	}

	/**
	 * @return the curriculumCourse
	 */
	public CurriculumCourse getCurriculumCourse() {
		return curriculumCourse;
	}

	/**
	 * @param curriculumCourse
	 *            the curriculumCourse to set
	 */
	public void setCurriculumCourse(CurriculumCourse curriculumCourse) {
		this.curriculumCourse = curriculumCourse;
	}

	/**
	 * @return the courseLearningComponentsList
	 */
	public List<CourseLearningComponent> getCourseLearningComponentsList() {
		return courseLearningComponentsList;
	}

	/**
	 * @param courseLearningComponentsList
	 *            the courseLearningComponentsList to set
	 */
	public void setCourseLearningComponentsList(
			List<CourseLearningComponent> courseLearningComponentsList) {
		this.courseLearningComponentsList = courseLearningComponentsList;
	}

	/**
	 * @return the coursePlaybook
	 */
	public CoursePlaybook getCoursePlaybook() {
		return coursePlaybook;
	}

	/**
	 * @param coursePlaybook
	 *            the coursePlaybook to set
	 */
	public void setCoursePlaybook(CoursePlaybook coursePlaybook) {
		this.coursePlaybook = coursePlaybook;
	}

	/**
	 * @return the courseAdditionalPropertyList
	 */
	public List<CourseAdditionalProperty> getCourseAdditionalPropertyList() {
		return courseAdditionalPropertyList;
	}

	/**
	 * @param courseAdditionalPropertyList
	 *            the courseAdditionalPropertyList to set
	 */
	public void setCourseAdditionalPropertyList(
			List<CourseAdditionalProperty> courseAdditionalPropertyList) {
		this.courseAdditionalPropertyList = courseAdditionalPropertyList;
	}

	/**
	 * @return the currCourseCalendarEntries
	 */
	public List<CurriculumCourseCalendar> getCurrCourseCalendarEntries() {
		return currCourseCalendarEntries;
	}

	/**
	 * @param currCourseCalendarEntries
	 *            the currCourseCalendarEntries to set
	 */
	public void setCurrCourseCalendarEntries(
			List<CurriculumCourseCalendar> currCourseCalendarEntries) {
		this.currCourseCalendarEntries = currCourseCalendarEntries;
	}

	/**
	 * @return the learningContentReviewProgressList
	 */
	public List<LearningContentReviewProgress> getLearningContentReviewProgressList() {
		return learningContentReviewProgressList;
	}

	/**
	 * @param learningContentReviewProgressList
	 *            the learningContentReviewProgressList to set
	 */
	public void setLearningContentReviewProgressList(
			List<LearningContentReviewProgress> learningContentReviewProgressList) {
		this.learningContentReviewProgressList = learningContentReviewProgressList;
	}

	/**
	 * @return the announcements
	 */
	public List<Announcement> getAnnouncements() {
		return announcements;
	}

	/**
	 * @param announcements
	 *            the announcements to set
	 */
	public void setAnnouncements(List<Announcement> announcements) {
		this.announcements = announcements;
	}

	/**
	 * @return the courseTagClouds
	 */
	public List<CourseTagcloud> getCourseTagClouds() {
		return courseTagClouds;
	}

	/**
	 * @param courseTagClouds
	 *            the courseTagClouds to set
	 */
	public void setCourseTagClouds(List<CourseTagcloud> courseTagClouds) {
		this.courseTagClouds = courseTagClouds;
	}

	/**
	 * @return the learningElementWalls
	 */
	public List<LearningElementWall> getLearningElementWalls() {
		return learningElementWalls;
	}

	/**
	 * @param learningElementWalls
	 *            the learningElementWalls to set
	 */
	public void setLearningElementWalls(
			List<LearningElementWall> learningElementWalls) {
		this.learningElementWalls = learningElementWalls;
	}

	/**
	 * @return the assignmentTests
	 */
	public List<AssignmentTest> getAssignmentTests() {
		return assignmentTests;
	}

	/**
	 * @param assignmentTests
	 *            the assignmentTests to set
	 */
	public void setAssignmentTests(List<AssignmentTest> assignmentTests) {
		this.assignmentTests = assignmentTests;
	}

	/**
	 * @return the learningComponentContent
	 */
	public LearningComponentContent getLearningComponentContent() {
		return learningComponentContent;
	}

	/**
	 * @param learningComponentContent
	 *            the learningComponentContent to set
	 */
	public void setLearningComponentContent(
			LearningComponentContent learningComponentContent) {
		this.learningComponentContent = learningComponentContent;
	}

}

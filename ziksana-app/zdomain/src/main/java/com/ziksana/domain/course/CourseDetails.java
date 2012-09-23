package com.ziksana.domain.course;

import java.util.List;

/**
 * This object contains more information about Course Components
 */
public class CourseDetails {

	private List<CourseLearningComponent> courseLearningComponentsList;
	private CoursePlaybook coursePlaybook;
	//private CourseContentSecurity courseContentSecurity; 
	//private CourseLearningPlanner courseLearningPlanner;
	private List<CourseAdditionalProperty> courseAdditionalPropertyList;

	/**
	 * association with the Learning Component, Course contains the one or more
	 * Learning Components.
	 */
	protected List<LearningComponent> learningComponents;
	
	
	/**
	 * Association relation for Course and CurriculumCourse
	 */
	private CurriculumCourse curriculumCourse;
	
	/**
	 * The Object contains the Course Tree structure related behaviour
	 */
	private CourseTreeCatalog courseTreeCatalog;

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
	public void setLearningComponents(List<LearningComponent> learningComponents) {
		this.learningComponents = learningComponents;
	}

	/**
	 * @return the courseTreeCatalog
	 */
	public CourseTreeCatalog getCourseTreeCatalog() {
		return courseTreeCatalog;
	}

	/**
	 * @param courseTreeCatalog the courseTreeCatalog to set
	 */
	public void setCourseTreeCatalog(CourseTreeCatalog courseTreeCatalog) {
		this.courseTreeCatalog = courseTreeCatalog;
	}

	/**
	 * @return the curriculumCourse
	 */
	public CurriculumCourse getCurriculumCourse() {
		return curriculumCourse;
	}

	/**
	 * @param curriculumCourse the curriculumCourse to set
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
	 * @param courseLearningComponentsList the courseLearningComponentsList to set
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
	 * @param coursePlaybook the coursePlaybook to set
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
	 * @param courseAdditionalPropertyList the courseAdditionalPropertyList to set
	 */
	public void setCourseAdditionalPropertyList(
			List<CourseAdditionalProperty> courseAdditionalPropertyList) {
		this.courseAdditionalPropertyList = courseAdditionalPropertyList;
	}

}

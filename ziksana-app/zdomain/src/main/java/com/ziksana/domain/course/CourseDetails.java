package com.ziksana.domain.course;

import java.util.List;

/**
 * This object contains more information about Course Components
 */
public class CourseDetails {

	// private List<CourseLearningComponent> courseLearningComponents;

	/**
	 * association with the Learning Component, Course contains the one or more
	 * Learning Components.
	 */
	protected List<LearningComponent> learningComponents;
	
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

}

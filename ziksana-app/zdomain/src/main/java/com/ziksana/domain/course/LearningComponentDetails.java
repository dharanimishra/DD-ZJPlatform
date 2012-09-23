package com.ziksana.domain.course;

import java.util.List;

/**
 * This object contains more information about Course
 * 
 * @author bhashasp
 */
public class LearningComponentDetails {

	private LearningComponentNest learningComponentNest;

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
	 * Association for the Learning component content. Each LearningComponent
	 * can have association of one - to - many with LearningComponentContent.
	 */
	private List<LearningComponentContent> learningCompContentList;

	/**
	 * Adding LearningComponentContent to LearningComponent based on
	 * LearningComponent.componenttype
	 * 
	 * @param learningComponent
	 */
	public void addLearningComponentContent(
			LearningComponentContent learningComponentContent) {

		if (learningComponentContent != null
				&& learningComponentContent.getLearningComponentContentId() != null) {

			learningCompContentList.add(learningComponentContent);
		}
	}

	/**
	 * Remove the LearningComponentContent from the list.
	 * 
	 * @param learningComponentId
	 */
	public void removeLearningComponentContent(
			Integer learningComponentContentId) {

		for (LearningComponentContent learningComponentContent : learningCompContentList) {

			if (learningComponentContent.getLearningComponentContentId()
					.equals(learningComponentContentId)) {
				learningCompContentList.remove(learningComponentContent);
			}
		}
	}

	private CourseLearningComponent courseLearningComponent;

	/*
	 * private List<CoursePlaybookView> coursePlaybookViewList;
	 * 
	 * private List<LearningElementWall> learningElementWallList;
	 */

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

}

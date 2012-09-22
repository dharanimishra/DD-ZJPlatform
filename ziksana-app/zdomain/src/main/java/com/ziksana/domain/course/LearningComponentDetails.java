package com.ziksana.domain.course;

import java.util.List;

/**
 * This object contains more information about Course
 * 
 * @author bhashasp
 */
public class LearningComponentDetails {
	

	private List<LearningComponentNest> learningComponentNestList;
	
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
	 */
	public void addLearningComponentNest(
			LearningComponentNest learningComponentNest) {

		if (learningComponentNest != null
				&& learningComponentNest.getComponentNestId() != null) {
			learningComponentNestList.add(learningComponentNest);
		}
	}

	/**
	 * Association for the Learning component content. Each LearningComponent
	 * can have association of one - to - many with LearningComponentContent.
	 */
	private List<LearningComponentContent> learningCompContentList;

	/**
	 * Adding LearningComponentContent to LearningComponent based on LearningComponent.componenttype
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

	 /* 
	  private List<CoursePlaybookView> coursePlaybookViewList;
	  
	  private CourseLearningComponent courseLearningComponent;
	  
	  private List<LearningElementWall> learningElementWallList;
	 */

	/**
	 * @return the learningComponentNestList
	 */
	public List<LearningComponentNest> getLearningComponentNestList() {
		return learningComponentNestList;
	}

	/**
	 * @param learningComponentNestList
	 *            the learningComponentNestList to set
	 */
	public void addLearningComponentNestList(
			List<LearningComponentNest> learningComponentNestList) {
		this.learningComponentNestList = learningComponentNestList;
	}

	/*	*//**
	 * @return the coursePlaybookViewList
	 */
	/*
	 * public List<CoursePlaybookView> getCoursePlaybookViewList() { return
	 * coursePlaybookViewList; }
	 */
	/*
	*//**
	 * @param coursePlaybookViewList
	 *            the coursePlaybookViewList to set
	 */
	/*
	 * public void addCoursePlaybookViewList( List<CoursePlaybookView>
	 * coursePlaybookViewList) { this.coursePlaybookViewList =
	 * coursePlaybookViewList; }
	 *//**
	 * @return the courseLearningComponent
	 */
	/*
	 * public CourseLearningComponent getCourseLearningComponent() { return
	 * courseLearningComponent; }
	 *//**
	 * @param courseLearningComponent
	 *            the courseLearningComponent to set
	 */
	/*
	 * public void addCourseLearningComponent( CourseLearningComponent
	 * courseLearningComponent) { this.courseLearningComponent =
	 * courseLearningComponent; }
	 */
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
	 * @return the learningElementWallList
	 */
	/*
	 * public List<LearningElementWall> getLearningElementWallList() { return
	 * learningElementWallList; }
	 *//**
	 * @param learningElementWallList
	 *            the learningElementWallList to set
	 */
	/*
	 * public void addLearningElementWallList( List<LearningElementWall>
	 * learningElementWallList) { this.learningElementWallList =
	 * learningElementWallList; }
	 */

}

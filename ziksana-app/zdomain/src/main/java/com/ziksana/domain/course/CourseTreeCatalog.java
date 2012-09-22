package com.ziksana.domain.course;

/**
 * The Object contains the Course Tree structure related behaviour
 * 
 * @author bhashasp
 */
public class CourseTreeCatalog extends CourseDetails{
	
	/**
	 * Add Learning Component as a course component.
	 * 
	 * @param learningComponent
	 */
	public void addLearningComponent(LearningComponent learningComponent) {

		if (learningComponent != null
				&& learningComponent.getLearningComponentId() != null) {
			learningComponents.add(learningComponent);
		}
	}

	/**
	 * @param learningComponentId
	 */
	public void removeLearningComponent(Integer learningComponentId) {

		for (LearningComponent learningComponent : learningComponents) {

			if (learningComponent.getLearningComponentId().equals(
					learningComponentId)) {
				learningComponents.remove(learningComponent);
			}
		}
	}


}

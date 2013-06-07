package com.ziksana.persistence.course;

import com.ziksana.domain.course.LearningContentDecoration;

public interface LearningContentDecorationMapper {

	/**
	 * Saves the Learning Content Decoration
	 */
	public LearningContentDecoration saveContentDecoration(LearningContentDecoration learningContentDecoration);

	/**
	 * Updates the Learning Content Decoration
	 */
	public LearningContentDecoration updateContentDecoration(LearningContentDecoration learningContentDecoration);
	
	/**
	 * Retrieves the {@link LearningContentDecoration} by id
	 * @param learningContentDecorationId
	 * @return {@link LearningContentDecoration}
	 */
	public LearningContentDecoration getLearningContentDecoration(Integer learningContentDecorationId);


}
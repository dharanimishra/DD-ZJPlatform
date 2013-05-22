package com.ziksana.service.course;

import java.util.List;

import com.ziksana.domain.course.LearningComponentContent;

public interface LearningComponentContentService {
	
	/**
	 * Saves the collection of learning component content objects to the data base
	 * @param learningComponentContents
	 */
	public void saveLearningComponentContents(List<LearningComponentContent> learningComponentContents);
	
}

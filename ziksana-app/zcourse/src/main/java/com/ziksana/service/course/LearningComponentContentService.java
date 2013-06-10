package com.ziksana.service.course;

import java.util.List;

import com.ziksana.domain.course.LearningComponentContent;

public interface LearningComponentContentService {
	
	/**
	 * Saves the collection of learning component content objects to the data base
	 * @param learningComponentContents
	 */
	public void saveLearningComponentContents(List<LearningComponentContent> learningComponentContents);
	
	/**
	 * This method only marks the specified {@link LearningComponentContent} as deleted
	 * @param learningComponentContentId
	 */
	public void deleteLearningComponentContent(LearningComponentContent learningComponentContent);
	
	public LearningComponentContent getLearningComponentContent(Integer learningComponentContentId);
	
	/**
	 * This method retrieves the learningComponentContent object for the specified
	 * learningComponentId and learningContentId 
	 * @param learningComponentId
	 * @param learningContentId
	 * @return
	 */
	public LearningComponentContent getLearningComponentContent(Integer learningComponentId, Integer learningContentId);
	
	/**
	 * Updates the learning component content
	 * @param learningComponentContent
	 */
	public void update(LearningComponentContent learningComponentContent);
	
	/**
	 * Creates/Saves new LearningComponentContent
	 * @param learningComponentContent
	 */
	public void saveLearningComponentContent(LearningComponentContent learningComponentContent);
	
	}

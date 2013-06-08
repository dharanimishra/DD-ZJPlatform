/**
 * 
 */
package com.ziksana.service.course;

import com.ziksana.domain.course.LearningContentDecoration;

/**
 * @author Arvind
 *	This interface provides methods to do the crud operations on {@link LearningContentDecoration}
 */
public interface LearningContentDecorationService {
	
	
	public void saveLearningContentDecoration(LearningContentDecoration learningContentDecoration);
	
	public void updateLearningContentDecoration(LearningContentDecoration learningContentDecoration);
	
	public void markLearningContentDecorationAsDeleted(LearningContentDecoration learningContentDecoration);

	public LearningContentDecoration getLearningContentDecoration(Integer learningContentDecorationId);
	
}

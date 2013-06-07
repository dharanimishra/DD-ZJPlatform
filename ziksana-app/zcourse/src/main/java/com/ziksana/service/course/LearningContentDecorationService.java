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
	
	
	public LearningContentDecoration saveLearningContentDecoration(LearningContentDecoration learningContentDecoration);
	
	public LearningContentDecoration updateLearningContentDecoration(LearningContentDecoration learningContentDecoration);
	
	public LearningContentDecoration markLearningContentDecorationAsDeleted(LearningContentDecoration learningContentDecoration);

	public LearningContentDecoration getLearningContentDecoration(Integer learningContentDecorationId);
	
}

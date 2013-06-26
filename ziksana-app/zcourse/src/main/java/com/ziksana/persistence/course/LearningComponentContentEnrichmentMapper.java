package com.ziksana.persistence.course;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.ziksana.domain.course.LearningComponentContentEnrichment;

public interface LearningComponentContentEnrichmentMapper {

	/**
	 * Saves the LearningComponentContentEnrichment
	 */
	Integer saveLearningComponentContentEnrichment(LearningComponentContentEnrichment record);

	/**
	 * Updates the LearningComponentContentEnrichment
	 */
	LearningComponentContentEnrichment updateLearningComponentContentEnrichment(LearningComponentContentEnrichment record);


	@Update({ "update LearningComponentContentEnrichment set isdelete = true where ID =  #{learningComponentContentEnrichmentId,jdbcType=INTEGER}" })
	void deleteContentEnrichment(@Param("learningComponentContentEnrichmentId") Integer learningComponentContentEnrichmentId);

}
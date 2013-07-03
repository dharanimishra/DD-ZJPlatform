package com.ziksana.persistence.course;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ziksana.domain.course.ContentEnrichment;
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


	@Update({ "update CorApplyEnrichment set isdelete = true where ID =  #{corApplyEnrichmentId,jdbcType=INTEGER}" })
	void deleteContentEnrichment(@Param("corApplyEnrichmentId") Integer corApplyEnrichmentId);

	@Select({"select cce.id, cce.enrichmentType, cce.StartTime, cce.EndTime," 
			+ " cce.LinkName, cce.LinkDescription, cce.coordinates " 
			+ " from corcontentenrichment cce, CorApplyEnrichment clcce"
			+ " where cce.ID = clcce.enrichmentId"
			+ " and "
			+ " clcce.CourseId=#{courseId,jdbcType=INTEGER}"
			+ " and " 
			+ " clcce.LearningComponentContentId=#{learningComponetContentId,jdbcType=INTEGER}"
			+ " and "
			+ " clcce.CreatorMemberRoleId=#{creatorId,jdbcType=INTEGER}"
			+ " and"
			+ " cce.IsDelete = false"
			+ " and" 
			+ " cce.Active = true"
			})
	@Results(value = {
				@Result(property = "id", column = "id"),
				@Result(property = "enrichmentTypeId", column = "enrichmentType"),
				@Result(property = "startTime", column = "StartTime"),
				@Result(property = "endTime", column = "EndTime"),
				@Result(property = "coordinates", column = "coordinates"),
				@Result(property = "linkName", column = "LinkName"),
				@Result(property = "linkDescription", column = "LinkDescription")})
	List<ContentEnrichment> getEnrichments(@Param("courseId") Integer courseId, @Param("learningComponetContentId")  Integer learningComponetContentId, @Param("creatorId") Integer creatorId);
}
package com.ziksana.persistence.course;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.ziksana.domain.course.LearningContentDecoration;

public interface LearningContentDecorationMapper {

	/**
	 * Saves the Learning Content Decoration
	 */
	public void saveContentDecoration(LearningContentDecoration learningContentDecoration);

	/**
	 * Updates the Learning Content Decoration
	 */
	public void updateContentDecoration(LearningContentDecoration learningContentDecoration);
	
	/**
	 * Retrieves the {@link LearningContentDecoration} by id
	 * @param learningContentDecorationId
	 * @return {@link LearningContentDecoration}
	 */
	@Select({ "select ID, CreationDate, Active, ContentDecorationType, Version, description, VersionRemarks, AuthoringMemberRoleId, RightsOwningMemberRoleId, IsDelete, SubjClassificationId from corlearningcontentdecoration where id=#{learningContentDecorationId,jdbcType=INTEGER} " })
	@Results(value = {
			@Result(property = "id", column = "ID"),
			@Result(property = "contentDecorationTypeId", column = "ContentDecorationType"),
			@Result(property = "active", column = "active"),
			@Result(property = "isDelete", column = "isDelete"),
			@Result(property = "description", column = "description"),
			@Result(property = "version", column = "Version"),
			@Result(property = "numberOfThumbnails", column = "NumberOfThumbnails") })
	public LearningContentDecoration findById(Integer learningContentDecorationId);

}
package com.ziksana.persistence.course;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ziksana.domain.course.LearningComponentContent;

public interface LearningComponentContentMapper {
	/**
	 * This method saves the learning component content
	 */
	Integer saveLearningComponentContent(
			LearningComponentContent learningComponentContent);

	/**
	 * This method Updates the learning component content
	 */
	Integer updateLearningComponentContent(
			LearningComponentContent learningComponentContent);

	@Select({ "select count(*) from corlearningcomponentcontent where learningcomponentid = #{learningComponentId,jdbcType=INTEGER}" })
	int getCompContentByLComponentId(Integer learningComponentId);

	@Select({ "select count(*) from corlearningcomponentcontent where learningcomponentid = #{learningComponentId,jdbcType=INTEGER}" })
	int getContentByLComponentId(Integer learningComponentId);

	@Select({ "select id from corlearningcomponentcontent where isdelete = #{isdelete, jdbcType=BOOLEAN}"
			+ " and learningcomponentid = #{learningComponentId,jdbcType=INTEGER}" })
	@Results(value = { @Result(property = "id", column = "id"), })
	List<Integer> getLearningComponentContentByComponentId(
			@Param("learningComponentId") Integer learningComponentId,
			@Param("isDelete") Boolean isDelete);

	@Select({ "select id from corlearningcomponentcontent where isdelete = #{isdelete, jdbcType=BOOLEAN}"
			+ " and learningcomponentid = #{learningComponentId,jdbcType=INTEGER}" })
	@Results(value = { @Result(property = "id", column = "id"), })
	LearningComponentContent getLearningComponentContentDetails(
			@Param("learningComponentId") Integer learningComponentId,
			@Param("isDelete") Boolean isDelete);

	@Update({ "update corlearningcomponentcontent set isdelete = #{isDelete, jdbcType=BOOLEAN} where "
			+ "ID = #{learningComponentContentId, jdbcType=INTEGER}" })
	void delete(
			@Param("learningComponentContentId") Integer learningComponentContentId,
			@Param("isDelete") Boolean isDelete);

	@Select({ "select id from corlearningcomponentcontent where "
			+ " id = #{learningComponentContentId,jdbcType=INTEGER} and isdelete = false and active = true" })
	@Results(value = { @Result(property = "id", column = "id"), })
	LearningComponentContent getLearningComponentContent(
			Integer learningComponentContentId);

	@Select({ "select ID  from corlearningcomponentcontent where "
			+ " learningComponentId = #{learningComponentId,jdbcType=INTEGER} and "
			+ " learningContentId = #{learningContentId,jdbcType=INTEGER} and isdelete = false and active = true " })
	@Results(value = { @Result(property = "id", column = "ID"), })
	LearningComponentContent findByComponentAndContentId(
			@Param("learningComponentId") Integer learningComponentId,
			@Param("learningContentId") Integer learningContentId);

	@Select({ "select ID  from corlearningcomponentcontent where"
			+ " learningContentId = #{learningContentId,jdbcType=INTEGER} and isdelete = false and active = true " })
	@Results(value = { @Result(property = "id", column = "ID"), })
	LearningComponentContent getAssociatedLearningContent(
			@Param("learningContentId") Integer learningContentId);
}
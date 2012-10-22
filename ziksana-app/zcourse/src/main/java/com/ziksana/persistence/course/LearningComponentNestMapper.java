package com.ziksana.persistence.course;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.ziksana.domain.course.LearningComponentNest;

public interface LearningComponentNestMapper {
	/**
	 * This method corresponds to the database table corlearningcomponentnest
	 */
	@Delete({ "delete from corlearningcomponentnest",
			"where componentNestId = #{componentNestId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer componentNestId);

	/**
	 * This method corresponds to the database table corlearningcomponentnest
	 */
	@Insert({
			"insert into corlearningcomponentnest (componentNestId, CreationDate, ",
			"NestLevel, ParentLearningComponentId, ",
			"NestLearningComponentId)",
			"values (#{componentNestId,jdbcType=INTEGER}, #{creationDate,jdbcType=DATE}, ",
			"#{nestLevel,jdbcType=INTEGER}, #{parentLearningComponentId,jdbcType=INTEGER}, ",
			"#{nestLearningComponentId,jdbcType=INTEGER})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "componentNestId", before = true, resultType = Integer.class)
	void save(LearningComponentNest record);

	/**
	 * This method corresponds to the database table corlearningcomponentnest
	 */
	int insertSelective(LearningComponentNest record);

	/**
	 * This method corresponds to the database table corlearningcomponentnest
	 */
	@Select({
			"select",
			"componentNestId, CreationDate, NestLevel, ParentLearningComponentId, NestLearningComponentId",
			"from corlearningcomponentnest",
			"where componentNestId = #{componentNestId,jdbcType=INTEGER}" })
	@ResultMap("BaseResultMap")
	LearningComponentNest selectByPrimaryKey(Integer componentNestId);

	/**
	 * This method corresponds to the database table corlearningcomponentnest
	 */
	int updateByPrimaryKeySelective(LearningComponentNest record);

	/**
	 * This method corresponds to the database table corlearningcomponentnest
	 */
	@Update({
			"update corlearningcomponentnest",
			"set CreationDate = #{creationDate,jdbcType=DATE},",
			"NestLevel = #{nestLevel,jdbcType=INTEGER},",
			"ParentLearningComponentId = #{parentLearningComponentId,jdbcType=INTEGER},",
			"NestLearningComponentId = #{nestLearningComponentId,jdbcType=INTEGER}",
			"where componentNestId = #{componentNestId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(LearningComponentNest record);
}
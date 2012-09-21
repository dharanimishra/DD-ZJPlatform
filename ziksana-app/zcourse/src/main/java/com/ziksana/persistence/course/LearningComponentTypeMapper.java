package com.ziksana.persistence.course;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ziksana.domain.course.LearningComponentType;

public interface LearningComponentTypeMapper {
	/**
	 * . This method corresponds to the database table corlearningcomponenttype
	 */
	@Delete({ "delete from corlearningcomponenttype",
			"where learningcomponenttypeid = #{learningComponentTypeId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer learningComponentTypeId);

	/**
	 * . This method corresponds to the database table corlearningcomponenttype
	 */
	@Insert({
			"insert into corlearningcomponenttype (learningcomponenttypeid, creationdate, ",
			"componenttypename, componenttypedescription, ",
			"active, memberroleid)",
			"values (#{learningComponentTypeId,jdbcType=INTEGER}, #{creationDate,jdbcType=TIMESTAMP}, ",
			"#{componentTypeName,jdbcType=VARCHAR}, #{componentTypeDescription,jdbcType=VARCHAR}, ",
			"#{active,jdbcType=BIT},  #{memberRoleId,jdbcType=INTEGER})" })
	int insert(LearningComponentType record);

	/**
	 * . This method corresponds to the database table corlearningcomponenttype
	 */
	int insertSelective(LearningComponentType record);

	/**
	 * . This method corresponds to the database table corlearningcomponenttype
	 */
	@Select({
			"select",
			"learningcomponenttypeid, creationdate, componenttypename, componenttypedescription, active, memberroleid",
			"from corlearningcomponenttype",
			"where learningcomponenttypeid = #{learningComponentTypeId,jdbcType=INTEGER}" })
	@ResultMap("BaseResultMap")
	LearningComponentType selectByPrimaryKey(Integer learningComponentTypeId);

	/**
	 * . This method corresponds to the database table corlearningcomponenttype
	 */
	int updateByPrimaryKeySelective(LearningComponentType record);

	/**
	 * . This method corresponds to the database table corlearningcomponenttype
	 */
	@Update({
			"update corlearningcomponenttype",
			"set creationdate = #{creationDate,jdbcType=TIMESTAMP},",
			"componenttypename = #{componentTypeName,jdbcType=VARCHAR},",
			"componenttypedescription = #{componentTypeDescription,jdbcType=VARCHAR},",
			"active = #{active,jdbcType=BIT}",
			"memberroleid={memberRoleId,jdbcType=INTEGER},",
			"where learningcomponenttypeid = #{learningComponentTypeId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(LearningComponentType record);
}
package com.ziksana.persistence.assessment.personality;

import com.ziksana.domain.assessment.personality.PersonalityModel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface PersonalityModelMapper {

	/**
	 * This method corresponds to the database table pstmodel
	 */
	@Delete({ "delete from pstmodel",
			"where ModelId = #{modelId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer modelId);

	/**
	 * This method corresponds to the database table pstmodel
	 */
	@Insert({
			"insert into pstmodel (ModelId, Name, ",
			"Description, Author, ",
			"Version, Active, CostPerUnit, ",
			"Source, Currency)",
			"values (#{modelId,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
			"#{description,jdbcType=VARCHAR}, #{author,jdbcType=VARCHAR}, ",
			"#{version,jdbcType=VARCHAR}, #{active,jdbcType=BIT}, #{costPerUnit,jdbcType=DECIMAL}, ",
			"#{source,jdbcType=INTEGER}, #{currency,jdbcType=INTEGER})" })
	int insert(PersonalityModel record);

	/**
	 * This method corresponds to the database table pstmodel
	 */
	int insertSelective(PersonalityModel record);

	/**
	 * This method corresponds to the database table pstmodel
	 */
	@Select({
			"select",
			"ModelId, Name, Description, Author, Version, Active, CostPerUnit, Source, Currency",
			"from pstmodel", "where ModelId = #{modelId,jdbcType=INTEGER}" })
	@ResultMap("BaseResultMap")
	PersonalityModel selectByPrimaryKey(Integer modelId);

	/**
	 * This method corresponds to the database table pstmodel
	 */
	int updateByPrimaryKeySelective(PersonalityModel record);

	/**
	 * This method corresponds to the database table pstmodel
	 */
	@Update({ "update pstmodel", "set Name = #{name,jdbcType=VARCHAR},",
			"Description = #{description,jdbcType=VARCHAR},",
			"Author = #{author,jdbcType=VARCHAR},",
			"Version = #{version,jdbcType=VARCHAR},",
			"Active = #{active,jdbcType=BIT},",
			"CostPerUnit = #{costPerUnit,jdbcType=DECIMAL},",
			"Source = #{source,jdbcType=INTEGER},",
			"Currency = #{currency,jdbcType=INTEGER}",
			"where ModelId = #{modelId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(PersonalityModel record);
}
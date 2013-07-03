package com.ziksana.persistence.assessment.personality;


public interface PersonalityTestMapper {/*

	*//**
	 * This method corresponds to the database table psttest
	 *//*
	@Delete({ "delete from psttest",
			"where TestId = #{testId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer testId);

	*//**
	 * This method corresponds to the database table psttest
	 *//*
	@Insert({
			"insert into psttest (TestId, Name, ",
			"Description, Geography, ",
			"Version, Active, ModelId)",
			"values (#{testId,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
			"#{description,jdbcType=VARCHAR}, #{geography,jdbcType=INTEGER}, ",
			"#{version,jdbcType=VARCHAR}, #{active,jdbcType=BIT}, #{modelId,jdbcType=INTEGER})" })
	int insert(PersonalityTest record);

	*//**
	 * This method corresponds to the database table psttest
	 *//*
	int insertSelective(PersonalityTest record);

	*//**
	 * This method corresponds to the database table psttest
	 *//*
	@Select({ "select",
			"TestId, Name, Description, Geography, Version, Active, ModelId",
			"from psttest", "where TestId = #{testId,jdbcType=INTEGER}" })
	@ResultMap("BaseResultMap")
	PersonalityTest selectByPrimaryKey(Integer testId);

	*//**
	 * This method corresponds to the database table psttest
	 *//*
	int updateByPrimaryKeySelective(PersonalityTest record);

	*//**
	 * This method corresponds to the database table psttest
	 *//*
	@Update({ "update psttest", "set Name = #{name,jdbcType=VARCHAR},",
			"Description = #{description,jdbcType=VARCHAR},",
			"Geography = #{geography,jdbcType=INTEGER},",
			"Version = #{version,jdbcType=VARCHAR},",
			"Active = #{active,jdbcType=BIT},",
			"ModelId = #{modelId,jdbcType=INTEGER}",
			"where TestId = #{testId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(PersonalityTest record);
*/}
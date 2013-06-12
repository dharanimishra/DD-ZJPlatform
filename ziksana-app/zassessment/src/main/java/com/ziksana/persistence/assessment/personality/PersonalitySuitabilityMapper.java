package com.ziksana.persistence.assessment.personality;


public interface PersonalitySuitabilityMapper {/*

	*//**
	 * This method corresponds to the database table pstsuitability
	 *//*
	@Delete({ "delete from pstsuitability",
			"where SuitabilityId = #{suitabilityId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer suitabilityId);

	*//**
	 * This method corresponds to the database table pstsuitability
	 *//*
	@Insert({
			"insert into pstsuitability (SuitabilityId, SuitabilityType, ",
			"Name, Value, Description, ",
			"Version, Active, CharacteristicId, ",
			"CategoryId)",
			"values (#{suitabilityId,jdbcType=INTEGER}, #{suitabilityType,jdbcType=INTEGER}, ",
			"#{name,jdbcType=INTEGER}, #{value,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR}, ",
			"#{version,jdbcType=INTEGER}, #{active,jdbcType=BIT}, #{characteristicId,jdbcType=INTEGER}, ",
			"#{categoryId,jdbcType=INTEGER})" })
	int insert(PersonalitySuitability record);

	*//**
	 * This method corresponds to the database table pstsuitability
	 *//*
	int insertSelective(PersonalitySuitability record);

	*//**
	 * This method corresponds to the database table pstsuitability
	 *//*
	@Select({
			"select",
			"SuitabilityId, SuitabilityType, Name, Value, Description, Version, Active, CharacteristicId, ",
			"CategoryId", "from pstsuitability",
			"where SuitabilityId = #{suitabilityId,jdbcType=INTEGER}" })
	@ResultMap("BaseResultMap")
	PersonalitySuitability selectByPrimaryKey(Integer suitabilityId);

	*//**
	 * This method corresponds to the database table pstsuitability
	 *//*
	int updateByPrimaryKeySelective(PersonalitySuitability record);

	*//**
	 * This method corresponds to the database table pstsuitability
	 *//*
	@Update({ "update pstsuitability",
			"set SuitabilityType = #{suitabilityType,jdbcType=INTEGER},",
			"Name = #{name,jdbcType=INTEGER},",
			"Value = #{value,jdbcType=VARCHAR},",
			"Description = #{description,jdbcType=VARCHAR},",
			"Version = #{version,jdbcType=INTEGER},",
			"Active = #{active,jdbcType=BIT},",
			"CharacteristicId = #{characteristicId,jdbcType=INTEGER},",
			"CategoryId = #{categoryId,jdbcType=INTEGER}",
			"where SuitabilityId = #{suitabilityId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(PersonalitySuitability record);
*/}
package com.ziksana.persistence.assessment.personality;


public interface PersonalityCategoryMapper {/*

	*//**
	 * This method corresponds to the database table pstcategory
	 *//*
	@Delete({ "delete from pstcategory",
			"where CategoryId = #{categoryId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer categoryId);

	*//**
	 * This method corresponds to the database table pstcategory
	 *//*
	@Insert({
			"insert into pstcategory (CategoryId, Name, ",
			"Version, Active, Description)",
			"values (#{categoryId,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
			"#{version,jdbcType=INTEGER}, #{active,jdbcType=BIT}, #{description,jdbcType=LONGVARCHAR})" })
	int insert(PersonalityCategory record);

	*//**
	 * This method corresponds to the database table pstcategory
	 *//*
	int insertSelective(PersonalityCategory record);

	*//**
	 * This method corresponds to the database table pstcategory
	 *//*
	@Select({ "select", "CategoryId, Name, Version, Active, Description",
			"from pstcategory",
			"where CategoryId = #{categoryId,jdbcType=INTEGER}" })
	@ResultMap("ResultMapWithBLOBs")
	PersonalityCategory selectByPrimaryKey(Integer categoryId);

	*//**
	 * This method corresponds to the database table pstcategory
	 *//*
	int updateByPrimaryKeySelective(PersonalityCategory record);

	*//**
	 * This method corresponds to the database table pstcategory
	 *//*
	@Update({ "update pstcategory", "set Name = #{name,jdbcType=VARCHAR},",
			"Version = #{version,jdbcType=INTEGER},",
			"Active = #{active,jdbcType=BIT},",
			"Description = #{description,jdbcType=LONGVARCHAR}",
			"where CategoryId = #{categoryId,jdbcType=INTEGER}" })
	int updateByPrimaryKeyWithBLOBs(PersonalityCategory record);

	*//**
	 * This method corresponds to the database table pstcategory
	 *//*
	@Update({ "update pstcategory", "set Name = #{name,jdbcType=VARCHAR},",
			"Version = #{version,jdbcType=INTEGER},",
			"Active = #{active,jdbcType=BIT}",
			"where CategoryId = #{categoryId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(PersonalityCategory record);
*/}
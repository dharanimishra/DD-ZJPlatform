package com.ziksana.persistence.assessment.personality;


public interface PersonalityClusterMapper {/*

	*//**
	 * This method corresponds to the database table pstcluster
	 *//*
	@Delete({ "delete from pstcluster",
			"where ClusterId = #{clusterId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer clusterId);

	*//**
	 * This method corresponds to the database table pstcluster
	 *//*
	@Insert({
			"insert into pstcluster (ClusterId, Version, ",
			"Active, CategoryId, ",
			"TestQuestionId, QuestionBankAnswerId)",
			"values (#{clusterId,jdbcType=INTEGER}, #{version,jdbcType=INTEGER}, ",
			"#{active,jdbcType=BIT}, #{categoryId,jdbcType=INTEGER}, ",
			"#{testQuestionId,jdbcType=INTEGER}, #{questionBankAnswerId,jdbcType=INTEGER})" })
	int insert(PersonalityCluster record);

	*//**
	 * This method corresponds to the database table pstcluster
	 *//*
	int insertSelective(PersonalityCluster record);

	*//**
	 * This method corresponds to the database table pstcluster
	 *//*
	@Select({
			"select",
			"ClusterId, Version, Active, CategoryId, TestQuestionId, QuestionBankAnswerId",
			"from pstcluster",
			"where ClusterId = #{clusterId,jdbcType=INTEGER}" })
	@ResultMap("BaseResultMap")
	PersonalityCluster selectByPrimaryKey(Integer clusterId);

	*//**
	 * This method corresponds to the database table pstcluster
	 *//*
	int updateByPrimaryKeySelective(PersonalityCluster record);

	*//**
	 * This method corresponds to the database table pstcluster
	 *//*
	@Update({ "update pstcluster",
			"set Version = #{version,jdbcType=INTEGER},",
			"Active = #{active,jdbcType=BIT},",
			"CategoryId = #{categoryId,jdbcType=INTEGER},",
			"TestQuestionId = #{testQuestionId,jdbcType=INTEGER},",
			"QuestionBankAnswerId = #{questionBankAnswerId,jdbcType=INTEGER}",
			"where ClusterId = #{clusterId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(PersonalityCluster record);
*/}
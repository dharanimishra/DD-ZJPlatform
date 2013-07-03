package com.ziksana.persistence.assessment.personality;


public interface PersonalityMemberPersonalityMapper {/*

	*//**
	 * This method corresponds to the database table pstmemberpersonality
	 *//*
	@Delete({ "delete from pstmemberpersonality",
			"where MemberPersonalityId = #{memberPersonalityId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer memberPersonalityId);

	*//**
	 * This method corresponds to the database table pstmemberpersonality
	 *//*
	@Insert({
			"insert into pstmemberpersonality (MemberPersonalityId, CreationDate, ",
			"PersonalityType, Characteristic, ",
			"Cluster, Quotient, ",
			"Certificate, MemberId, ",
			"MemberRoleId)",
			"values (#{memberPersonalityId,jdbcType=INTEGER}, #{creationDate,jdbcType=DATE}, ",
			"#{personalityType,jdbcType=INTEGER}, #{characteristic,jdbcType=VARCHAR}, ",
			"#{cluster,jdbcType=VARCHAR}, #{quotient,jdbcType=VARCHAR}, ",
			"#{certificate,jdbcType=VARCHAR}, #{memberId,jdbcType=INTEGER}, ",
			"#{memberRoleId,jdbcType=INTEGER})" })
	int insert(PersonalityMemberPersonality record);

	*//**
	 * This method corresponds to the database table pstmemberpersonality
	 *//*
	int insertSelective(PersonalityMemberPersonality record);

	*//**
	 * This method corresponds to the database table pstmemberpersonality
	 *//*
	@Select({
			"select",
			"MemberPersonalityId, CreationDate, PersonalityType, Characteristic, Cluster, ",
			"Quotient, Certificate, MemberId, MemberRoleId",
			"from pstmemberpersonality",
			"where MemberPersonalityId = #{memberPersonalityId,jdbcType=INTEGER}" })
	@ResultMap("BaseResultMap")
	PersonalityMemberPersonality selectByPrimaryKey(Integer memberPersonalityId);

	*//**
	 * This method corresponds to the database table pstmemberpersonality
	 *//*
	int updateByPrimaryKeySelective(PersonalityMemberPersonality record);

	*//**
	 * This method corresponds to the database table pstmemberpersonality
	 *//*
	@Update({ "update pstmemberpersonality",
			"set CreationDate = #{creationDate,jdbcType=DATE},",
			"PersonalityType = #{personalityType,jdbcType=INTEGER},",
			"Characteristic = #{characteristic,jdbcType=VARCHAR},",
			"Cluster = #{cluster,jdbcType=VARCHAR},",
			"Quotient = #{quotient,jdbcType=VARCHAR},",
			"Certificate = #{certificate,jdbcType=VARCHAR},",
			"MemberId = #{memberId,jdbcType=INTEGER},",
			"MemberRoleId = #{memberRoleId,jdbcType=INTEGER}",
			"where MemberPersonalityId = #{memberPersonalityId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(PersonalityMemberPersonality record);
*/}
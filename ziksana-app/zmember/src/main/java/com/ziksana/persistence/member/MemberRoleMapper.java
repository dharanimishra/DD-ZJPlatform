package com.ziksana.persistence.member;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ziksana.domain.member.MemberRole;

public interface MemberRoleMapper {
	/**
	 * . This method corresponds to the database table memmemberrole
	 */
	@Delete({ "delete from memmemberrole", "where memberroleid = #{memberRoleId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer memberRoleId);

	/**
	 * . This method corresponds to the database table memmemberrole
	 */
	@Insert({ "insert into memmemberrole (memberroleid, RoleType, ",
			"RoleStartDate, Active, DoNotMarketIndicator,MemberId, SecRoleId)",
			"values (#{memberRoleId,jdbcType=INTEGER}, #{roleType,jdbcType=INTEGER}, ",
			"#{roleStartDate,jdbcType=TIMESTAMP}, #{active,jdbcType=BIT}, ",
			"#{doNotMarketIndicator,jdbcType=BIT}, #{thumbnailPicturePath,jdbcType=VARCHAR}, #{memberId,jdbcType=INTEGER}"})
	int insert(MemberRole record);

	/**
	 * . This method corresponds to the database table memmemberrole
	 */
	int insertSelective(MemberRole record);

	/**
	 * . This method corresponds to the database table memmemberrole
	 */
	@Select({ "select",
			"memberroleid, RoleType, RoleStartDate, Active, DoNotMarketIndicator, thumbnailPicturePath, MemberId",
			"from memmemberrole", "where memberroleid = #{memberRoleId,jdbcType=INTEGER}" })
	@ResultMap("BaseResultMap")
	MemberRole selectByPrimaryKey(Integer memberRoleId);

	/**
	 * . This method corresponds to the database table memmemberrole
	 */
	int updateByPrimaryKeySelective(MemberRole record);

	/**
	 * . This method corresponds to the database table memmemberrole
	 */
	@Update({ "update memmemberrole",
			"set RoleType = #{roleType,jdbcType=INTEGER},",
			"RoleStartDate = #{roleStartDate,jdbcType=TIMESTAMP},",
			"Active = #{active,jdbcType=BIT},",
			"DoNotMarketIndicator = #{doNotMarketIndicator,jdbcType=BIT}",
			"ThumbnailPicturePath = #{thumbnailPicturePath,jdbcType=VARCHAR}",
			"MemberId = #{memberId,jdbcType=INTEGER}",
			"where memberroleid = #{memberRoleId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(MemberRole record);
}
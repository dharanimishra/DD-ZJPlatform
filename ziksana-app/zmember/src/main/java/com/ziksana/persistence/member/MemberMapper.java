package com.ziksana.persistence.member;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ziksana.domain.member.Member;

public interface MemberMapper {
	/**
	 * . This method corresponds to the database table memmember
	 */
	@Delete({ "delete from memmember", "where memberid = #{memberId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer memberId);

	/**
	 * . This method corresponds to the database table memmember
	 */
	@Insert({
			"insert into memmember (memberid, MemberType, ",
			"RelationshipStatus, JoinedDate, ",
			"FirstName, LastName, ",
			"MiddleName, NickName, ",
			"Salutation, DateofBirth, ",
			"SunSign, MoonSign, ",
			"Active, DoNotDistrubIndicator, ",
			"Gender, PicturePath)",
			"values (#{memberId,jdbcType=INTEGER}, #{memberType,jdbcType=INTEGER}, ",
			"#{relationshipStatus,jdbcType=INTEGER}, #{joinedDate,jdbcType=TIMESTAMP}, ",
			"#{firstName,jdbcType=VARCHAR}, #{lastName,jdbcType=VARCHAR}, ",
			"#{middleName,jdbcType=VARCHAR}, #{nickName,jdbcType=VARCHAR}, ",
			"#{salutation,jdbcType=INTEGER}, #{dateofBirth,jdbcType=DATE}, ",
			"#{sunSign,jdbcType=INTEGER}, #{moonSign,jdbcType=INTEGER}, ",
			"#{active,jdbcType=BIT}, #{doNotDistrubIndicator,jdbcType=BIT}, ",
			"#{gender,jdbcType=INTEGER}, #{picturePath,jdbcType=VARCHAR})"})
	int insert(Member record);

	/**
	 * . This method corresponds to the database table memmember
	 */
	int insertSelective(Member record);

	/**
	 * . This method corresponds to the database table memmember
	 */
	@Select({
			"select",
			"memberid, MemberType, RelationshipStatus, JoinedDate, FirstName, LastName, MiddleName, ",
			"NickName, Salutation, DateofBirth, SunSign, MoonSign, Active, DoNotDistrubIndicator, ",
			"Gender, PicturePath", "from memmember",
			"where memberid = #{memberId,jdbcType=INTEGER}" })
	@ResultMap("BaseResultMap")
	Member selectByPrimaryKey(Integer memberId);

	/**
	 * . This method corresponds to the database table memmember
	 */
	int updateByPrimaryKeySelective(Member record);

	/**
	 * . This method corresponds to the database table memmember
	 */
	@Update({ "update memmember",
			"set MemberType = #{memberType,jdbcType=INTEGER},",
			"RelationshipStatus = #{relationshipStatus,jdbcType=INTEGER},",
			"JoinedDate = #{joinedDate,jdbcType=TIMESTAMP},",
			"FirstName = #{firstName,jdbcType=VARCHAR},",
			"LastName = #{lastName,jdbcType=VARCHAR},",
			"MiddleName = #{middleName,jdbcType=VARCHAR},",
			"NickName = #{nickName,jdbcType=VARCHAR},",
			"Salutation = #{salutation,jdbcType=INTEGER},",
			"DateofBirth = #{dateofBirth,jdbcType=DATE},",
			"SunSign = #{sunSign,jdbcType=INTEGER},",
			"MoonSign = #{moonSign,jdbcType=INTEGER},",
			"Active = #{active,jdbcType=BIT},",
			"DoNotDistrubIndicator = #{doNotDistrubIndicator,jdbcType=BIT},",
			"Gender = #{gender,jdbcType=INTEGER},",
			"PicturePath = #{picturePath,jdbcType=VARCHAR},",
			"where memberid = #{memberId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(Member record);
	
	
	/**
	 * Retrieves the associated collection member role details
	 * @param record
	 * @return
	 */
	List<Member> getListOfMembers();
	
	/**
	 * Member's specific  role type is set
	 * @param memberId
	 * @param memberRoleType
	 * @return
	 */
	@Update({ "update memmember",
		"set MemberType = #{memberType,jdbcType=INTEGER}",
		"where memberid = #{memberId,jdbcType=INTEGER}" })
	int setMemberType(Member member);
}
/**
 * 
 */
package com.ziksana.persistence.security;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ziksana.domain.member.MemberProfile;

/**
 * @author vtg-p13
 *
 */
public interface ProfileMapper {
	

	public List<MemberProfile> getMemberProfileList(int memberId);
	
	public int updateMemberProfile(MemberProfile memberProfile);
	
	public int isProfileCompleted(String userId);

	public MemberProfile getMemberProfile(@Param("userId")String userId,@Param("securityQuestionId")String securityQuestionId);

	public MemberProfile getMemberProfileByMemberId(@Param("memberId")int memberId, @Param("securityQuestionId")String securityQuestionId);

	public List<MemberProfile> getMemberProfileListByRole(int memberRoleId);

	public int updateProfileAlternateMail(@Param("memberId")int memberId,@Param("alternateEmailId")String alternateEmailId);
}

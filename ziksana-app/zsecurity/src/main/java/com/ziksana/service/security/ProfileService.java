/**
 * 
 */
package com.ziksana.service.security;

import java.util.List;

import com.ziksana.domain.member.MemberProfile;

/**
 * @author vtg-p13
 *
 */
public interface ProfileService {


	
	public List<MemberProfile> getMemberProfileList(int memberId);
	
	public int updateMemberProfile(MemberProfile memberProfile);
	
	public int isProfileCompleted(String username);

	public MemberProfile getMemberProfile(String userId,
			String securityQuestionId);
	public MemberProfile getMemberProfileByMemberId(int memberId,
			String securityQuestionId);
	
}

/**
 * 
 */
package com.ziksana.service.security.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziksana.domain.member.MemberProfile;
import com.ziksana.persistence.security.ProfileMapper;
import com.ziksana.service.security.ProfileService;

/**
 * @author vtg-p13
 *
 */
@Service
public class ProfileServiceImpl implements ProfileService {

	
	@Autowired
	ProfileMapper profileMapper;
	
	
	public List<MemberProfile> getMemberProfileList(int memberId) {

		return profileMapper.getMemberProfileList(memberId);
	}
	/* 
	 * update the Profile
	 */
	public int updateMemberProfile(MemberProfile memberProfile) {

		return profileMapper.updateMemberProfile(memberProfile);
	}

	/* 
	 * check is profile is updated or not
	 */
	public int isProfileCompleted(String memberId) {

		return profileMapper.isProfileCompleted(memberId);
	}

	public MemberProfile getMemberProfile(String userId,
			String securityQuestionId) {

		return profileMapper.getMemberProfile(userId,securityQuestionId);
	}
	public MemberProfile getMemberProfileByMemberId(int memberId,
			String securityQuestionId) {
		
		return profileMapper.getMemberProfileByMemberId(memberId, securityQuestionId);
	}
	
	public int updateProfileAlternateMail(int memberId, String alternateEmailId) {
		
		return profileMapper.updateProfileAlternateMail(memberId,alternateEmailId);
	}
	
	

	

}

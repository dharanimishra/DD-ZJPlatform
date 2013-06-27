/**
 * 
 */
package com.ziksana.service.security.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziksana.domain.member.Member;
import com.ziksana.persistence.security.UserMapper;
import com.ziksana.service.security.MemberService;

/**
 * @author prabu
 * 
 */
@Service
public class MemberServiceImpl implements MemberService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ziksana.service.security.MemberService#getMemberByUser(java.lang.
	 * String)
	 */

	@Autowired
	UserMapper userMapper;

	public Member getMemberByUser(String userName) {
		
		return userMapper.getMemberByUser(userName);
	}

	public Member getMemberByMemberId(int memberId) {
		
		return userMapper.getMemberByMemberId(memberId);
	}

	public int isMemberAccountLocked(String username) {
	
		return userMapper.isMemberAccountLocked(username);
	}

	public int lockMemberAccountByUserId(String username) {
	
		return userMapper.lockMemberAccountByUserId(username);
	}

	public Member getMemberByEmailId(String emailId) {
		
		return userMapper.getMemberByEmailId(emailId);
	}

	public int updateMemberProfileImage(String profileImage, int memberId) {
		
		return userMapper.updateMemberProfileImage(profileImage, memberId);
		
	}

	public boolean isUserNameExists(String username) {
		// TODO Auto-generated method stub
		return userMapper.isUserNameExists(username);
	}

	public boolean isPasswordExists(String password) {
		// TODO Auto-generated method stub
		return userMapper.isPasswordExists(password);
	}

	public boolean isPrimaryEmailIdExists(String emailId) {
		// TODO Auto-generated method stub
		return userMapper.isPrimaryEmailIdExists(emailId) ;
	}

	public String getPasswordUpdatedOn(int memberId) {
		// TODO Auto-generated method stub
		return userMapper.getPasswordUpdatedOn(memberId);
	}

	public int deleteMemberProfileImage(int memberId) {
		// TODO Auto-generated method stub
		return userMapper.deleteMemberProfileImage(memberId);
	}

}

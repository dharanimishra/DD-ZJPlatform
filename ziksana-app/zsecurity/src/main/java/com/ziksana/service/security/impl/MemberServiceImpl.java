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

	/* (non-Javadoc)
	 * @see com.ziksana.service.security.MemberService#getMemberByUser(java.lang.String)
	 */
	
	@Autowired
	UserMapper userMapper;
	
	
	@Override
	public Member getMemberByUser(String userName) {
		// TODO Auto-generated method stub
		return userMapper.getMemberByUser(userName);
	}


	@Override
	public Member getMemberByMemberId(int memberId) {
		// TODO Auto-generated method stub
		return userMapper.getMemberByMemberId(memberId);
	}

}

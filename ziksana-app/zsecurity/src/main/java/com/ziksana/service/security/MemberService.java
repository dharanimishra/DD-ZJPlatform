/**
 * 
 */
package com.ziksana.service.security;

import com.ziksana.domain.member.Member;

/**
 * @author prabu
 *
 */
public interface MemberService {
	
	public Member getMemberByUser(String userName);
	
	public Member getMemberByMemberId(int memberId);
}

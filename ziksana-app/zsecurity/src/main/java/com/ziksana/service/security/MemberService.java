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
	
	public int isMemberAccountLocked(String username);

	public int lockMemberAccountByUserId(String username);

	public Member getMemberByEmailId(String emailId);

	public int updateMemberProfileImage(String profileImage, int memberId);

	public boolean isUserNameExists(String username);

	public boolean isPasswordExists(String password);

	public boolean isPrimaryEmailIdExists(String emailId);

	public String getPasswordUpdatedOn(int memberId);
	

}

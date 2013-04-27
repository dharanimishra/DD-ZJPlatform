/**
 * 
 */
package com.ziksana.persistence.security;




import org.apache.ibatis.annotations.Param;

import com.ziksana.domain.member.Member;


/**
 * @author prabu
 *
 */
public interface UserMapper {
	

    public Member getMemberByUser(String userName);
    
    public Member getMemberByMemberId(int memberId);

	public int isMemberAccountLocked(String username);

	public int lockMemberAccountByUserId(String username);

	public String getUserPassword(String userId);

	public void updateSecMemberCredentional(@Param("newPassword")String newPassword,@Param("userId") String userId);

	public Member getMemberByEmailId(String emailId);

	public int updateMemberProfileImage(@Param("profileImage")String profileImage,@Param("memberId") int memberId);

	public boolean isUserNameExists(String username);

	public boolean isPasswordExists(String password);

}

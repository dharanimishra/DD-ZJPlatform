/**
 * 
 */
package com.ziksana.persistence.security;

import org.apache.ibatis.annotations.Param;

/**
 * @author vtg-p13
 *
 */
public interface TroubleLoginMapper {

	public boolean isUserIdExists(String userId);
	
	public boolean isSecretAnswerExists(@Param("answer")String answer, @Param("secretQuestion")String secretQuestion,@Param("memberId") String memberId);

}

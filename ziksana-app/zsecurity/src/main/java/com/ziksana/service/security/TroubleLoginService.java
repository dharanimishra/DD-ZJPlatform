/**
 * 
 */
package com.ziksana.service.security;


/**
 * @author vtg-p13
 *
 */
public interface TroubleLoginService {

	public boolean isUserIdExists(String userId);
	
	public boolean isSecretAnswerExists(String answer, String secretQuestion, String memberId);

}

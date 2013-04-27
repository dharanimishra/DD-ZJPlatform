/**
 * 
 */
package com.ziksana.service.security;

/**
 * @author vtg-p13
 * 
 */
public interface PasswordService {

	public String replaceExistingPassword(String newPassword, String userId);

	public String getUserPassword(String userId);

	public void updateSecMemberCredentional(String newPassword, String userId);

}

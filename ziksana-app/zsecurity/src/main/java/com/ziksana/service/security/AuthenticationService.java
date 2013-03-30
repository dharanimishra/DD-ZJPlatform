/**
 * 
 */
package com.ziksana.service.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author prabu
 *
 */
public  interface AuthenticationService {
	
	public boolean authenticateUser(String userId, String password);


	

}

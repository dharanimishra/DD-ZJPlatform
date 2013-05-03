/**
 * 
 */
package com.ziksana.service.security.impl;

import javax.naming.directory.DirContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.ldap.support.LdapUtils;
import org.springframework.stereotype.Service;

import com.ziksana.service.security.AuthenticationService;

/**
 * @author prabu
 * 
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	private static Logger logger = LoggerFactory
			.getLogger(AuthenticationServiceImpl.class);

	@Value("#{ldapProperties['url']}")
	private String ldapUrl;

	@Value("#{ldapProperties['userid']}")
	private String userDn;

	@Value("#{ldapProperties['pwd']}")
	private String password;


	public boolean authenticateUser(String userId, String pwd) {
		// TODO Auto-generated method s LDAtub
        logger.debug(" entering to LDAP AUTH");
		DirContext ctx = null;
		LdapContextSource contextSource = new LdapContextSource();
		// These values may be given via spring configuration file
		contextSource.setUrl(ldapUrl);
		// contextSource.setBase("ou=system");
		contextSource.setUserDn(userDn);
		contextSource.setPassword(this.password);
		try {
			contextSource.afterPropertiesSet();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			if (contextSource != null) {
				logger.debug(" The context source is not null");
				ctx = contextSource.getContext("uid="+userId+",ou=users,ou=system,dc=test,dc=lan", pwd);
				//ctx = contextSource.getContext("uid="+userId+",ou=users,ou=system", pwd);
				
			}
			// ctx = contextSource.getContext(userid, password);
			return true;
		} catch (Exception e) {
			// Context creation failed - authentication did not succeed
			// logger.error("Login failed", e);
			
			logger.debug(" The exception is " + e);
			return false;
		} finally {
			// It is imperative that the created DirContext instance is always
			// closed
			LdapUtils.closeContext(ctx);
		}

	}

}

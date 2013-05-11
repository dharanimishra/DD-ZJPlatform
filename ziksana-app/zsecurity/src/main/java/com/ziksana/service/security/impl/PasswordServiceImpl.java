/**
 * 
 */
package com.ziksana.service.security.impl;

import org.springframework.stereotype.Service;

import com.ziksana.persistence.security.UserMapper;
import com.ziksana.service.security.PasswordService;
import javax.naming.directory.Attribute;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.DirContext;
import javax.naming.directory.ModificationItem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.ldap.support.LdapUtils;
/**
 * @author vtg-p13
 *
 */
@Service
public class PasswordServiceImpl implements PasswordService {
	private static Logger logger = LoggerFactory
			.getLogger(PasswordServiceImpl.class);
	
	@Autowired
	UserMapper userMapper;
	
	@Value("#{ldapProperties['url']}")
	private String ldapUrl;

	@Value("#{ldapProperties['userid']}")
	private String userDn;

	@Value("#{ldapProperties['pwd']}")
	private String password;
	
	/* 
	 * replace the password in LDAP
	 */
	public String replaceExistingPassword(String newPassword, String userId, String password) {

		String response = "";

        logger.debug(" entering to LDAP AUTH");
		DirContext ctx = null;
		LdapContextSource contextSource = new LdapContextSource();
		// These values may be given via spring configuration file
		contextSource.setUrl("ldap://localhost:10389/ou=system");
		// contextSource.setBase("ou=system");
		contextSource.setUserDn("uid=admin,ou=system");
		contextSource.setPassword("selvan");
		try {
			contextSource.afterPropertiesSet();
		} catch (Exception e1) {
		
			e1.printStackTrace();
		}

		try {
			if (contextSource != null) {
				logger.debug(" The context source is not null");
				//ctx = contextSource.getContext("uid="+userId+",ou=users,ou=system,dc=test,dc=lan", pwd);
				ctx = contextSource.getContext("uid="+userId+",ou=users,ou=system", password);
				
				ModificationItem[] mods = new ModificationItem[1];

			    Attribute mod0 = new BasicAttribute("userPassword", newPassword);
			   
			    mods[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod0);


			    ctx.modifyAttributes("uid="+userId+", ou=users", mods);
			}
			// ctx = contextSource.getContext(userid, password);
			response = "success";
			return response;
		} catch (Exception e) {
			// Context creation failed - authentication did not succeed
			// logger.error("Login failed", e);

			logger.debug(" The exception is " + e);
			response = "fail";
			return response;
		} finally {
			// It is imperative that the created DirContext instance is always
			// closed
			LdapUtils.closeContext(ctx);
		}
		
		
	}
	
	public String getUserPassword(String userId) {
		
		return userMapper.getUserPassword(userId);
	}
	
	public void updateSecMemberCredentional(String newPassword, String userId) {
		userMapper.updateSecMemberCredentional(newPassword,userId);
		
	}

	public String getUserIdByMember(int memberId) {
		// TODO Auto-generated method stub
		return userMapper.getUserIdByMember(memberId);
	}

}

package com.ziksana.service.security.impl;

import javax.naming.directory.Attribute;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.DirContext;
import javax.naming.directory.ModificationItem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.ldap.support.LdapUtils;

public class LdapChangePassword {
	private static Logger logger = LoggerFactory
			.getLogger(LdapChangePassword.class);

	
	
	static String userId = "sandraf";
	static String pwd ="vtgindia"; 
	
	public static void main(String args[]){
		String response = ldapAuthentication();
		
		System.out.println(response);
	}
	
	

	
		
	
	private static  String ldapAuthentication(){
		String response = "";
		// TODO Auto-generated method s LDAtub
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
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			if (contextSource != null) {
				logger.debug(" The context source is not null");
				//ctx = contextSource.getContext("uid="+userId+",ou=users,ou=system,dc=test,dc=lan", pwd);
				ctx = contextSource.getContext("uid="+userId+",ou=users,ou=system", pwd);
				
				/*ModificationItem[] mods = new ModificationItem[1];

			    Attribute mod0 = new BasicAttribute("userPassword", "sathish");
			   
			    mods[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod0);


			    ctx.modifyAttributes("uid=sandraf, ou=users", mods);*/
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
}

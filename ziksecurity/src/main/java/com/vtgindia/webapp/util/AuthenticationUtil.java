package com.vtgindia.webapp.util;

import javax.naming.directory.DirContext;

import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.ldap.support.LdapUtils;

/**
 * Created with IntelliJ IDEA.
 * User: prabu
 * Date: 8/31/12
 * Time: 5:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class AuthenticationUtil {

     
	
	
	
	
	public  static boolean  authenticate(String userid, String password) {

        DirContext ctx = null;
        LdapContextSource contextSource = new LdapContextSource();
        //These values may be given via spring configuration file
        contextSource.setUrl("ldap://localhost:10389/ou=system");
        //contextSource.setBase("ou=system");
        contextSource.setUserDn("uid=admin,ou=system");
        contextSource.setPassword("secret");
        try {
			contextSource.afterPropertiesSet();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


        try {
             if (contextSource != null)
             {
            	 System.out.println(" The context source is not null");
            	 ctx = contextSource.getContext(userid, password);
             }
        	 //ctx = contextSource.getContext(userid, password);
            return true;
        } catch (Exception e) {
            // Context creation failed - authentication did not succeed
            //logger.error("Login failed", e);
        	System.out.println(" The exception is "+e);
            return false;
        } finally {
            // It is imperative that the created DirContext instance is always closed
            LdapUtils.closeContext(ctx);
        }
    }





}

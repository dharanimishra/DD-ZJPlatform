package com.vtgindia.webapp.filter;

import com.vtgindia.webapp.util.AuthenticationUtil;
import com.vtgindia.webapp.util.ThreadLocalObject;
import com.vtgindia.webapp.util.UserSecurityContext;
import org.springframework.ldap.core.ContextSource;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.ldap.support.LdapUtils;

import javax.naming.directory.DirContext;
import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: prabu
 * Date: 8/29/12
 * Time: 2:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class AuthenticationFilter implements Filter {

    private static final String TOKEN_COOKIE_NAME = "SecurityToken";
    private static final String LOGIN_URL = "login";
    private static final String USER_SECURITY_OBJECT_ATTR = "userSecurityObject";

    public void init(FilterConfig filterConfig) throws ServletException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        //get the security token
        String token = getToken(httpRequest);
        String url = httpRequest.getRequestURL().toString();


        if (null == token) {


            if (url.equals(LOGIN_URL)) {
                //Need to extract userid and password ..and authenticate against LDAP server
                String userid = httpRequest.getParameter("userid");
                String password = httpRequest.getParameter("password");

                if (AuthenticationUtil.authenticate(userid, password)) {
                    UserSecurityContext userSecurityContext = new UserSecurityContext();
                    HttpSession httpSession = httpRequest.getSession();
                    httpSession.setAttribute(USER_SECURITY_OBJECT_ATTR, userSecurityContext);


                } else {
                    //Need to redirect to the error login page with proper error message

                }


            } else {
                //Redirect to login page
            }


            /*
              we need to redirect to the login page if the URL is non-login URL. If the URL is login URL, we need to extract
              the user id and password..then we need to authenticate. If the authentication is successful,
              we need to create the token, session ... what else?
              if the authentication is unsuccessful, we need to redirect to the error login page with error message

               */


        } else {
            //This code needs to be revisited
            HttpSession httpSession = httpRequest.getSession();
            UserSecurityContext userSecurityContext = (UserSecurityContext) httpSession.getAttribute(USER_SECURITY_OBJECT_ATTR);
            ThreadLocalObject.set(userSecurityContext);

            // Do we need to find out whether this token is valid or not?
            // If the token is valid, the user should be allowed to continue

        }


        filterChain.doFilter(servletRequest, servletResponse);


        //check whether the user is authenticated user or not
        // If the cookie is present and valid, the user is authenticated user
        // If the cookie is not present, the user is unauthenticated user and we need to authenticate
        // the user using userid and password and create cookie ..


    }

    private boolean authenticate(String userid, String password) {

        DirContext ctx = null;
        LdapContextSource contextSource = new LdapContextSource();
        //These values may be given via spring configuration file
        contextSource.setUrl("URL NEEDS TO BE GIVEN");
        contextSource.setBase(" BASE VALUE");


        try {
            ctx = contextSource.getContext(userid, password);
            return true;
        } catch (Exception e) {
            // Context creation failed - authentication did not succeed
            //logger.error("Login failed", e);
            return false;
        } finally {
            // It is imperative that the created DirContext instance is always closed
            LdapUtils.closeContext(ctx);
        }
    }

    public void destroy() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * This method returns the security token(cookie) from the http request.
     * It returns null if there is no cookie
     *
     * @param httpRequest httpservletrequest
     * @return session cookie of the user
     */
    private String getToken(HttpServletRequest httpRequest) {
        Cookie[] cookies = httpRequest.getCookies();
        if (cookies == null) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(TOKEN_COOKIE_NAME)) {
                return cookie.getValue();
            }
        }
        return null;
    }


    private void createCookie(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

        Cookie cookie = new Cookie("NAME_OF_THE_COOKIE", "COOKIE_VALUE");
        //URL url = new URL(pHttpRequest.getRequestURL().toString());
        cookie.setDomain("NEED TO BE FILLED");
        //cookie.setPath(this.getCookiePath(pHttpRequest));
        //cookie.setComment("user is not eligible to take the survey this time");
        //cookie.setMaxAge(0);

        httpServletResponse.addCookie(cookie);

    }


}

package com.vtgindia.webapp.util;

/**
 * Created with IntelliJ IDEA.
 * User: prabu
 * Date: 8/30/12
 * Time: 5:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class ThreadLocalObject {


    public static final ThreadLocal<UserSecurityContext> userThreadLocal = new ThreadLocal<UserSecurityContext>();

    public static void set(UserSecurityContext user) {
        userThreadLocal.set(user);
    }

    public static void unset() {
        userThreadLocal.remove();
    }

    public static UserSecurityContext get() {
        return userThreadLocal.get();
    }


}

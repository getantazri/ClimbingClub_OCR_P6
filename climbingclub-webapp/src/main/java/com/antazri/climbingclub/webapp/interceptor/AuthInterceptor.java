package com.antazri.climbingclub.webapp.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * AuthInterceptor est un Interceptor Struts2 vérifiant si l'utilisateur est bien connecté en vérifiant la présence de USER dans sa session
 */
public class AuthInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation pActionInvocation) throws Exception {
        String vResult;

        if (pActionInvocation.getInvocationContext().getSession().get("user") != null) {
            vResult = pActionInvocation.invoke();
        } else {
            vResult = "error";
        }

        return vResult;
    }
}

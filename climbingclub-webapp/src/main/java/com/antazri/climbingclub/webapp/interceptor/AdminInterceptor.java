package com.antazri.climbingclub.webapp.interceptor;

import com.antazri.climbingclub.model.beans.Utilisateur;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * AdminInterceptor est un Interceptor Struts2 vérifiant si l'utilisateur est bien connecté en tant qu'Administrateur en vérifiant la présence de USER dans sa session
 */
public class AdminInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation pActionInvocation) throws Exception {
        String vResult;

        if (pActionInvocation.getInvocationContext().getSession().get("admin") != null) {
            vResult = pActionInvocation.invoke();
        } else {
            vResult = "error";
        }

        return vResult;
    }
}

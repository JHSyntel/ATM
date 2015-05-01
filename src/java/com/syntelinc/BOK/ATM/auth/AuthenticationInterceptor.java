package com.syntelinc.BOK.ATM.auth;

import java.util.Map;
 
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
 
public class AuthenticationInterceptor implements Interceptor {
 
    @Override
    public void destroy() {
        //release resources here
    }
 
    @Override
    public void init() {
        // create resources here
    }
 
    @Override
    public String intercept(ActionInvocation actionInvocation)
            throws Exception {
        System.out.println("inside auth interceptor");
        Map<String, Object> sessionAttributes = actionInvocation.getInvocationContext().getSession();
        
        if(sessionAttributes.get("authenticated") == null){
            return Action.LOGIN;
        }else{
            Action action = (Action) actionInvocation.getAction();
            return actionInvocation.invoke();
        }
    }
 
}
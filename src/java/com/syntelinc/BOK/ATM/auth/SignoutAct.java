/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.syntelinc.BOK.ATM.auth;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author EH5024424
 */
public class SignoutAct extends ActionSupport implements SessionAware
{
    SessionMap sessionMap;

    @Override
    public String execute()
    {
        sessionMap = (SessionMap)ActionContext.getContext().getSession();
        sessionMap = null;
        return SUCCESS;
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap)map;
    }
    
}

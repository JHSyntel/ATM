/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.syntelinc.BOK.ATM.menupkg;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author KB5024427
 */
public class PinChangeSelectedAction extends ActionSupport implements SessionAware {
    private Map<String, Object> userSession;
    
    @Override
    public String execute(){
        this.getSession();
        userSession.put("menuSelection", "changepin");
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        userSession = map;
    }
    
    private void getSession() {
        this.userSession = ActionContext.getContext().getSession();
    }
}

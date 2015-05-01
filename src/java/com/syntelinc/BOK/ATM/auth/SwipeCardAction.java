/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.syntelinc.BOK.ATM.auth;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.ParameterNameAware;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author JH5024430
 */
public class SwipeCardAction extends ActionSupport implements SessionAware {
    private int cardNumber;
    
    private Map<String, Object> userSession;

    @Override
    public void setSession(Map<String, Object> map) {
        userSession = map;
    }
    
    private Map<String, Object> getSession() {
        return userSession = ActionContext.getContext().getSession();
    }
    
    public SwipeCardAction()
    {
        
    }
    
    @Override
    public void validate()
    {
        userSession = getSession();
        if(!Authentication.validID(cardNumber))
            addActionError("User not valid");
        if(!"55555".equals(Integer.toString(cardNumber)))
            addActionError("Invalid card number format");
    }
    
    @Override
    public String execute()
    {
        userSession.put("authenticated", true);
        return SUCCESS;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        System.out.println("-------setCardnumber()---------------------cardNumber is " + cardNumber);
        this.cardNumber = cardNumber;
    }
}

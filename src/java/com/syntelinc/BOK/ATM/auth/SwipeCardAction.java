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
        return ActionContext.getContext().getSession();
    }
    
    public SwipeCardAction()
    {
        userSession = getSession();   
    }
    
    @Override
    public void validate()
    {
        if(!Authentication.validID(Integer.toString(cardNumber)))
            addActionError("Invalid card number format");
        if(!Authentication.userExists(Integer.toString(cardNumber)))
            addActionError("User does not exist");
    }
    
    @Override
    public String execute()
    {
        userSession = getSession();
        userSession.put("authenticated", Boolean.TRUE);
        System.out.println("SwipeCardAction - Authenticated: " + userSession.get("authenticated"));
        //cardNumber and userID are equivalent terms
        Authentication.storeUserID(Integer.toString(cardNumber));
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

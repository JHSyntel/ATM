/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.syntelinc.BOK.ATM.auth;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author JH5024430
 */
public class EnterPinNum extends ActionSupport implements SessionAware{
    private int pinNumber;
    
    private Map<String, Object> userSession;

    @Override
    public void setSession(Map<String, Object> map) {
        userSession = map;
    }
    
    private Map<String, Object> getSession() {
        return ActionContext.getContext().getSession();
    }
    
    public EnterPinNum()
    {
        userSession = getSession();
    }
    
    @Override
    public void validate()
    {
        if(!Authentication.pinIsCorrect(Authentication.getUserIDfromSession(), pinNumber))
            addActionError("Pin not valid.");
        if(!Authentication.validPin(pinNumber))
            addActionError("Pin not valid.");
    }
    
    public String redirectToLanding() {
       return "NOTAUTHED";
    }
    
    @Override
    public String execute()
    {
        System.out.println("-----execute()-----------------------pinNumber is " + pinNumber);
        return SUCCESS;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(int pinNumber) {
        System.out.println("-------setPinNumber()---------------------pinNumber is " + pinNumber);
        this.pinNumber = pinNumber;
    }
}

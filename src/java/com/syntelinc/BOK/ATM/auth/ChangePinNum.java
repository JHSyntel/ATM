/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.syntelinc.BOK.ATM.auth;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.syntelinc.BOK.ATM.menupkg.Hibernate;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author JH5024430
 */
public class ChangePinNum extends ActionSupport implements SessionAware{
    private int newPinNumber;
    private int confirmNewPinNumber;
    private int currentPinNumber;
    
    private Map<String, Object> userSession;

    @Override
    public void setSession(Map<String, Object> map) {
        userSession = map;
    }
    
    private Map<String, Object> getSession() {
        return ActionContext.getContext().getSession();
    }
    
    public ChangePinNum()
    {
        userSession = getSession();
    }
    
    @Override
    public void validate()
    {    
        userSession = getSession();
        if(!userSession.containsKey("userid")) {
            addActionError("User session not active");
            return;
        }
        String userID = (String) userSession.get("userid");
        if(!Authentication.pinIsCorrect(userID, currentPinNumber))
            addActionError("Current Pin not correct.");
        if(!Authentication.pinFieldsAreEqual(newPinNumber, confirmNewPinNumber))
            addActionError("Pin fields are not equal.");
        if(!Authentication.validPin(newPinNumber))
            addActionError("New pin must be numeric and 5 digits long");
    }
    
    static public String redirectToSplash() {
        return "NOTAUTHED";
    }
    
    @Override
    public String execute()
    {
        System.out.println(!(boolean)userSession.get("authenticated"));
        Hibernate h = new Hibernate();
        h.setNewPinNumber(Integer.parseInt(Authentication.getUserIDfromSession()), newPinNumber);
        System.out.println("-----execute()-----------------------pinNumber is ");
        return SUCCESS;
    }

    public int getNewPinNumber() {
        return newPinNumber;
    }

    public void setNewPinNumber(int newPinNumber) {
        this.newPinNumber = newPinNumber;
    }

    public int getConfirmNewPinNumber() {
        return confirmNewPinNumber;
    }

    public void setConfirmNewPinNumber(int confirmNewPinNumber) {
        this.confirmNewPinNumber = confirmNewPinNumber;
    }

    public int getCurrentPinNumber() {
        return currentPinNumber;
    }

    public void setCurrentPinNumber(int currentPinNumber) {
        this.currentPinNumber = currentPinNumber;
    }

}

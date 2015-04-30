/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.syntelinc.BOK.ATM.auth;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author JH5024430
 */
public class ChangePinNum extends ActionSupport{
    private int newPinNumber;
    private int confirmNewPinNumber;
    private int currentPinNumber;
    
    public ChangePinNum()
    {
        
    }
    
    @Override
    public void validate()
    {
        
        System.out.println("------validate()----------------------pinNumber is ");
        if(!"55555".equals(Integer.toString(currentPinNumber)))
            addActionError("Pin not valid.");
        System.out.println("------validate()----------------------pinFieldsAreEqual() returns " + pinFieldsAreEqual());
        System.out.println("------validate()----------------------newPinNumber is " + newPinNumber);
        System.out.println("------validate()----------------------confirmNewPinNumber is " + confirmNewPinNumber);
        if(!pinFieldsAreEqual())
            addActionError("Pin fields are not equal.");
    }
    
    public boolean pinFieldsAreEqual() {
        return newPinNumber == confirmNewPinNumber;
    }
    
    @Override
    public String execute()
    {
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

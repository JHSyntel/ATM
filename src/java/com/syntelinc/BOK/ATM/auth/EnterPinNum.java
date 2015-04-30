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
public class EnterPinNum extends ActionSupport{
    private int pinNumber;
    
    public EnterPinNum()
    {
        
    }
    
    @Override
    public void validate()
    {
        
        System.out.println("------validate()----------------------pinNumber is " + pinNumber);
        if(!"55555".equals(Integer.toString(pinNumber)))
            addActionError("Card not valid.");
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

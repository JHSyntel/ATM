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
public class SwipeCardAction extends ActionSupport{
    private int cardNumber;
    
    public SwipeCardAction()
    {
        
    }
    
    @Override
    public void validate()
    {
        
        System.out.println("------validate()----------------------cardNumber is " + cardNumber);
        if(!"55555".equals(Integer.toString(cardNumber)))
            addActionError("Card not valid.");
    }
    
    @Override
    public String execute()
    {
        System.out.println("-----execute()-----------------------cardNumber is " + cardNumber);
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

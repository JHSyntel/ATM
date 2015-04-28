/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package in.syntel.BOK.ATM;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author JH5024430
 */
public class SwipeCard extends ActionSupport{
    private int cardNumber;
    
    public SwipeCard()
    {
        
    }
    
    @Override
    public void validate()
    {
        
        System.out.println("------validate()----------------------cardNumber is" + cardNumber);
        if(cardNumber != 55555)
            addActionError("Card not valid.");
    }
    
    @Override
    public String execute()
    {
        System.out.println("-----execute()-----------------------cardNumber is" + cardNumber);
        return SUCCESS;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        System.out.println("-------setCardnumber()---------------------cardNumber is" + cardNumber);
        this.cardNumber = cardNumber;
    }
}

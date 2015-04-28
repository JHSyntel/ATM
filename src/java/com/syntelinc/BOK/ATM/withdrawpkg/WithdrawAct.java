/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.syntelinc.BOK.ATM.withdrawpkg;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author EH5024424
 */
public class WithdrawAct extends ActionSupport
{
    private int withdrawamt;
    
    public WithdrawAct()
    {
        
    }
    
    @Override
    public void validate()
    {
        if(withdrawamt < 10)
            addActionError("Minimum withdrawal of $10");
    }
    
    @Override
    public String execute()
    {
        //create transaction
        //send transaction to database
        //transaction needs time, account id, location, new balance, debit number, credit? number
        return SUCCESS;
    }

    /**
     * @return the withdrawamt
     */
    public int getWithdrawamt() {
        return withdrawamt;
    }

    /**
     * @param withdrawamt the withdrawamt to set
     */
    public void setWithdrawamt(int withdrawamt) {
        this.withdrawamt = withdrawamt;
    }
}

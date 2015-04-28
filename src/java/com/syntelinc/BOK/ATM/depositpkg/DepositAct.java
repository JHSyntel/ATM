/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.syntelinc.BOK.ATM.depositpkg;

import com.opensymphony.xwork2.ActionSupport;
import com.syntelinc.BOK.ATM.transactionpkg.HibernateTransaction;

/**
 *
 * @author EH5024424
 */
public class DepositAct extends ActionSupport
{
    
    public DepositAct()
    {
        
    }
    
    @Override
    public void validate()
    {
        
    }
    
    @Override
    public String execute()
    {
        try
        {
            new HibernateTransaction();
            return SUCCESS;
        }
        catch(IllegalArgumentException e)
        {
            return ERROR;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.syntelinc.BOK.ATM.depositpkg;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author EH5024424
 */
public class ScanCashAct extends ActionSupport
{
    private int depositcashamt;
    
    public ScanCashAct()
    {
        
    }
    
    @Override
    public void validate()
    {
        
    }
    
    @Override
    public String execute()
    {
        return SUCCESS;
    }

    /**
     * @return the depositcashamt
     */
    public int getDepositcashamt() {
        return depositcashamt;
    }

    /**
     * @param depositcashamt the depositcashamt to set
     */
    public void setDepositcashamt(int depositcashamt) {
        this.depositcashamt = depositcashamt;
    }
    
}

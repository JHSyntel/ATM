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
public class ScanCheckAct extends ActionSupport
{
    private float depositcheckamt;
    
    public ScanCheckAct()
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
     * @return the depositcheckamt
     */
    public float getDepositcheckamt() {
        return depositcheckamt;
    }

    /**
     * @param depositcheckamt the depositcheckamt to set
     */
    public void setDepositcheckamt(float depositcheckamt) {
        this.depositcheckamt = depositcheckamt;
    }
}

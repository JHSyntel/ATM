/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.syntelinc.BOK.ATM.depositpkg;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author EH5024424
 */
public class ScanCheckAct extends ActionSupport implements SessionAware
{
    private SessionMap<String, Object> sessionMap;
    private double depositcheckamt;
    
    public ScanCheckAct()
    {
        
    }
    
    @Override
    public void validate()
    {
        if (depositcheckamt <= 0)
            addActionError("Amount must be numerical value greater than zero.");
        if (depositcheckamt > 1000000)
            addActionError("Our ATM cannot handle deposits of more than one million dollars. Please see a teller.");
    }
    
    @Override
    public String execute()
    {
        sessionMap = (SessionMap)ActionContext.getContext().getSession();
        
        sessionMap.put("depositamt", Double.toString(depositcheckamt));
        sessionMap.put("withdrawamt", Integer.toString(0));
        sessionMap.put("type", "check");
        
        return SUCCESS;
    }

    /**
     * @return the depositcheckamt
     */
    public double getDepositcheckamt() {
        return depositcheckamt;
    }

    /**
     * @param depositcheckamt the depositcheckamt to set
     */
    public void setDepositcheckamt(double depositcheckamt) {
        this.depositcheckamt = depositcheckamt;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap)map;
    }
}

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
        sessionMap = (SessionMap)ActionContext.getContext().getSession();
        //TEST CODE - REMOVE AFTER INTEGRATION WITH ACCOUNT SELECTION
        sessionMap.put("accounttype", "checking");
        sessionMap.put("accountid", "22");
        
        sessionMap.put("depositamt", Double.toString(depositcheckamt));
        sessionMap.put("withdrawamt", Integer.toString(0));
        sessionMap.put("deposittype", "check");
        
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

    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap)map;
    }
}

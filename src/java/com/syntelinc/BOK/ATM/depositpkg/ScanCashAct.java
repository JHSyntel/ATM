/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.syntelinc.BOK.ATM.depositpkg;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author EH5024424
 */
public class ScanCashAct extends ActionSupport implements SessionAware
{
    private SessionMap<String, Object> sessionMap;
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
        sessionMap = (SessionMap)ActionContext.getContext().getSession();
        //TEST CODE - REMOVE AFTER INTEGRATION WITH ACCOUNT SELECTION
        sessionMap.put("accounttype", "checking");
        sessionMap.put("accountid", "22");
        
        sessionMap.put("depositamt", Double.toString(depositcashamt));
        sessionMap.put("withdrawamt", Integer.toString(0));
        sessionMap.put("type", "cash");
        
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

    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap)map;
    }
    
}

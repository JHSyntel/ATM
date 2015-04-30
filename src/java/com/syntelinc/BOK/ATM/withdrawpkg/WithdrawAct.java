/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.syntelinc.BOK.ATM.withdrawpkg;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.syntelinc.BOK.ATM.transactionpkg.HibernateTransaction;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author EH5024424
 */
public class WithdrawAct extends ActionSupport implements SessionAware
{
    private int withdrawamt;
    private SessionMap<String, Object> sessionMap;
    
    public WithdrawAct()
    {
        
    }
    
    @Override
    public void validate()
    {
        if (withdrawamt < 20)
            addActionError("Minimum withdrawal of $20.");
        if (withdrawamt % 20 != 0)
            addActionError("Amount must be divisible by twenty.");
        
        CheckDailyLimit todayTrans = new CheckDailyLimit();
        double amt = todayTrans.getCurrentTotal();
        if (amt >= 1000)
            addActionError("You have already reached your daily withdrawal limit of $1000.");
        else if (amt+withdrawamt > 1000)
            addActionError("Amount would put your over your daily withdrawal limit. Must be less than " + (1000-amt) + ".");
    }
    
    @Override
    public String execute()
    {
        try
        {
            sessionMap = (SessionMap)ActionContext.getContext().getSession();
            //TEST CODE - REMOVE AFTER INTEGRATION WITH ACCOUNT SELECTION
            sessionMap.put("accounttype", "checking");
            sessionMap.put("accountid", "22");

            sessionMap.put("depositamt", Integer.toString(0));
            sessionMap.put("withdrawamt", Double.toString(withdrawamt));
            sessionMap.put("type", "cash");
            new HibernateTransaction();
            return SUCCESS;
        }
        catch(IllegalArgumentException e)
        {
            return ERROR;
        }
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

    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap)map;
    }
}

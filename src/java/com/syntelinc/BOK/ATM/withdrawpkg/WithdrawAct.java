/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.syntelinc.BOK.ATM.withdrawpkg;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.syntelinc.BOK.ATM.transactionpkg.HibernateTransaction;
import java.text.NumberFormat;
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
        sessionMap = (SessionMap)ActionContext.getContext().getSession();
    }
    
    @Override
    public void validate()
    {
        System.out.println("withdrawaing: " + withdrawamt);
        if (withdrawamt < 20)
            addActionError("Withdrawal must be between $20 and your remaining daily limit (max $1000).");
        if (withdrawamt % 20 != 0)
            addActionError("Amount must be divisible by twenty.");
        
        CheckDailyLimit todayTrans = new CheckDailyLimit();
        System.out.println((String)sessionMap.get("accountid"));
        double amt = todayTrans.getCurrentTotal((Integer.parseInt((String)sessionMap.get("accountid"))));
        if (amt >= 1000)
            addActionError("You have already reached your daily withdrawal limit of $1000.");
        else if (amt+withdrawamt > 1000)
        { 
            NumberFormat formatter = NumberFormat.getCurrencyInstance();
            String curr = formatter.format(1000-amt);
            addActionError("Amount would put your over your daily withdrawal limit. Must be less than " + curr + ".");
        }
    }
    
    @Override
    public String execute()
    {
        try
        {
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

package com.syntelinc.BOK.ATM.fastcash;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.syntelinc.BOK.ATM.menupkg.Checkingacct;
import com.syntelinc.BOK.ATM.menupkg.Hibernate;
import com.syntelinc.BOK.ATM.transactionpkg.HibernateTransaction;
import com.syntelinc.BOK.ATM.withdrawpkg.*;
import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

public class FastCash extends ActionSupport  implements SessionAware
{
    private String amount;
    private double withdrawamt;
    private Map<String, Object> userSession;
    
    
    public FastCash()
    {
        
    }

    @Override
    public void validate() {
        
        userSession = ActionContext.getContext().getSession();
        Hibernate hib = new Hibernate();
        // needs to be changed from this hardcoded value
        List l = hib.selectAccounts(0);
        //List l = hib.selectAccounts((int)userSession.get("userid"));
        //CheckDailyLimit lmt = new CheckDailyLimit();
        Checkingacct checkingAccount = (Checkingacct)l.get(l.size()-1);
        //lmt.getCurrentTotal(checkingAccount.getAccountid());
        userSession.put("accountid", Integer.toString(checkingAccount.getAccountid()));
        switch (amount)
        {
            case "$   20" :
                withdrawamt = 20;
                break;
            case "$   40":
                withdrawamt = 40;
                break;
            case "$   60":
                withdrawamt = 60;
                break;
            case "$   80":
                withdrawamt = 80;
                break;
            case "$  100":
                withdrawamt = 100;
                break;
            case "$  200":
                withdrawamt = 200;
                break;
//            default:
//                return "fail";
        }
        
        if (withdrawamt < 20)
            addActionError("Withdrawal must be between $20 and your remaining daily limit (max $1000).");
        if (withdrawamt % 20 != 0)
            addActionError("Amount must be divisible by twenty.");
        
        CheckDailyLimit todayTrans = new CheckDailyLimit();
        //System.out.println((String)userSession.get("accountid"));
        double amt = todayTrans.getCurrentTotal((Integer.parseInt((String)userSession.get("accountid"))));
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
    public String execute() throws Exception 
    {
        userSession = ActionContext.getContext().getSession();
        Hibernate hib = new Hibernate();
        // needs to be changed from this hardcoded value
        List l = hib.selectAccounts(0);
        //List l = hib.selectAccounts((int)userSession.get("userid"));
        //CheckDailyLimit lmt = new CheckDailyLimit();
        Checkingacct checkingAccount = (Checkingacct)l.get(l.size()-1);
        //lmt.getCurrentTotal(checkingAccount.getAccountid());
        userSession.put("accountid", Integer.toString(checkingAccount.getAccountid()));
        
        double withdrawamt = 0;
                System.out.println("fast cash" + withdrawamt);
        
        switch (amount)
        {
            case "$   20" :
                withdrawamt = 20;
                break;
            case "$   40":
                withdrawamt = 40;
                break;
            case "$   60":
                withdrawamt = 60;
                break;
            case "$   80":
                withdrawamt = 80;
                break;
            case "$  100":
                withdrawamt = 100;
                break;
            case "$  200":
                withdrawamt = 200;
                break;
//            default:
//                return "fail";
        }
                System.out.println("fast cash" + withdrawamt);
        try {
            userSession.put("accounttype", "checking");
            userSession.put("depositamt", Integer.toString(0));
            userSession.put("withdrawamt", Double.toString(withdrawamt));
            userSession.put("type", "cash");
            new HibernateTransaction();
            return SUCCESS;
        }
        catch(IllegalArgumentException e)
        {
            return ERROR;
        }
    }
    private double debit;
    
    /**
     * @return the debit
     */
    public double getDebit() {
        return debit;
    }

    /**
     * @param debit the debit to set
     */
    public void setDebit(double debit) {
        this.debit = debit;
    }

    /**
     * @return the amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public void setSession(Map<String, Object> map) {
       userSession = map;
    }
}

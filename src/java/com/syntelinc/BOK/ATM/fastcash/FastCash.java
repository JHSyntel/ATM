package com.syntelinc.BOK.ATM.fastcash;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.syntelinc.BOK.ATM.withdrawpkg.*;
import com.syntelinc.BOK.ATM.menupkg.Checkingacct;
import com.syntelinc.BOK.ATM.transactionpkg.HibernateTransaction;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

public class FastCash extends ActionSupport  implements SessionAware
{
    private String amount;
    private Map<String, Object> userSession;
    
    
    public FastCash()
    {
        
    }

    @Override
    public void validate() {
        super.validate(); 
    }
    

    @Override
    public String execute() throws Exception 
    {
        userSession = ActionContext.getContext().getSession();
        HibernateFastCash hib = new HibernateFastCash();
        // needs to be changed from this hardcoded value
        List l = hib.selectAccounts(0);
        //List l = hib.selectAccounts((int)userSession.get("userid"));
        CheckDailyLimit lmt = new CheckDailyLimit();
        Checkingacct checkingAccount = (Checkingacct)l.get(l.size()-1);
        lmt.getCurrentTotal(checkingAccount.getAccountid());
        userSession.put("accountid", Integer.toString(checkingAccount.getAccountid()));
        
        double withdrawamt = 0;
        
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

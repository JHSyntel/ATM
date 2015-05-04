package com.syntelinc.BOK.ATM.fastcash;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.syntelinc.BOK.ATM.transactionpkg.CheckingTransaction;
import com.syntelinc.BOK.ATM.withdrawpkg.*;
import in.syntel.BOK.ATM.ministatement.Checkingacct;
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
        List l = hib.selectAccounts((int)userSession.get("userid"));
        CheckDailyLimit lmt = new CheckDailyLimit();
        Checkingacct checkingAccount = (Checkingacct)l.get(l.size()-1);
        lmt.getCurrentTotal(checkingAccount.getCheckingid());
        
        
        
        switch (amount)
        {
            case "$   20" :
                
                
                
                break;
            case "$   40":
                break;
            case "$   60":
                break;
            case "$   80":
                break;
            case "$  100":
                break;
            case "$  200":
                break;
//            default:
//                return "fail";
                
        }
       
//        System.out.println("--------excute went thru");
        return SUCCESS;
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

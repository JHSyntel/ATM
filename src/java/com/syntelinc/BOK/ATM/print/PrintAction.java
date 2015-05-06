package com.syntelinc.BOK.ATM.print;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.syntelinc.BOK.ATM.menupkg.Hibernate;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author NN5024428
 */
public class PrintAction extends ActionSupport implements SessionAware
{
    private String balance;
    private Map<String, Object> userSession;
    public PrintAction() 
    {
        
    }
    
    @Override
    public String execute() throws Exception 
    {
        userSession = ActionContext.getContext().getSession();
        Hibernate hib = new Hibernate();
        BigDecimal bal = hib.getBalance(Integer.parseInt((String)userSession.get("accountid")), (String)userSession.get("accounttype"));
        balance = bal.toString();
//        balance = "5";
        System.out.println("Balance from hibernate: "+balance);
        userSession.put("selectedaccountbalance", balance);
        System.out.println("userSession.get(balance): "+userSession.get("selectedaccountbalance"));
        //ActionContext.getContext().getValueStack().push(list);
        List checkingAcctList = hib.selectCheckingAccounts(Integer.parseInt((String)userSession.get("userid")));
        ActionContext.getContext().getValueStack().push(checkingAcctList);
        List savingsAcctList = hib.selectSavingsAccounts(Integer.parseInt((String)userSession.get("userid")));
        ActionContext.getContext().getValueStack().push(savingsAcctList);
        
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        userSession = map;
                
    }

    /**
     * @return the balance
     */
    public String getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(String balance) {
        this.balance = balance;
    }
    
}

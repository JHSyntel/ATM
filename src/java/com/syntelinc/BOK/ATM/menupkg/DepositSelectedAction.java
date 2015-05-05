/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.syntelinc.BOK.ATM.menupkg;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author KB5024427
 */
public class DepositSelectedAction extends ActionSupport implements SessionAware {
    private Map<String, Object> userSession;
    private List accountList;
    private String accountid;
    
    @Override
    public String execute(){
        this.getSession();
        userSession.put("menuSelection", "deposit");
        
        Hibernate hib = new Hibernate();
        String userID = (String)userSession.get("userid");
        this.accountList = hib.selectAccounts(Integer.parseInt(userID));
//        this.accountList = hib.selectAccounts(0);
        ActionContext.getContext().getValueStack().push(accountList);
        
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        userSession = map;
    }
    
    private void getSession() {
        this.userSession = ActionContext.getContext().getSession();
    }

    /**
     * @return the accountid
     */
    public String getAccountid() {
        return accountid;
    }

    /**
     * @param accountid the accountid to set
     */
    public void setAccountid(String accountid) {
        this.accountid = accountid;
    }
}

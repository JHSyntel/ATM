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
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author KB5024427
 */
public class MainMenuAct extends ActionSupport implements SessionAware, RequestAware {
    private Map<String, Object> userSession;
    private Map paramMap;
    private List<String> accountList;
    private boolean Withdraw,
            deposit,
            viewSummary,
            printStatement,
            pinChange,
            logout;
    private String option;

    public MainMenuAct() {
        
    }

    @Override
    public String execute(){
        String result = "";
        userSession = this.getSession();
        System.out.println(userSession.get("userid"));
        System.out.println("EXECUTE AFTER SETTING SESSION");

        if(Withdraw) {
            userSession.put("menuSelection", "withdraw");
            System.out.println("Withdraw = "+Withdraw);
            result = "chooseAccount";
        }
        if(deposit) {
            userSession.put("menuSelection", "deposit");
            result = "chooseAccount";
        }
        if(viewSummary) {
            userSession.put("menuSelection", "viewSummary");
            result = "chooseAccount";
        }
        if(printStatement) {
            userSession.put("menuSelection", "printStatement");
            result = "chooseAccount";
        }
        if(pinChange) {
            userSession.put("menuSelection", "pinChange");
            result = "pinChange";
        }
        if(logout) {
            userSession.put("menuSelection", "logout");
            result = "logout";
        }
        if(result.equals("chooseAccount")) {
            Hibernate hib = new Hibernate();
            this.accountList = hib.selectAccounts((int)userSession.get("userid"));
            //this.accountList = hib.selectAccounts(0);
            System.out.println(accountList.get(0));
            ActionContext.getContext().getValueStack().push(accountList);
        }
        else if(result.equals("")) {
            return "error";
        }
        return result;
    }
    
    
    /**
     * @return the withdraw
     */
    public boolean isWithdraw() {
        return Withdraw;
    }

    /**
     * @param withdraw the withdraw to set
     */
    public void setWithdraw(boolean withdraw) {
        this.Withdraw = withdraw;
    }

    /**
     * @return the deposit
     */
    public boolean isDeposit() {
        return deposit;
    }

    /**
     * @param deposit the deposit to set
     */
    public void setDeposit(boolean deposit) {
        this.deposit = deposit;
    }

    /**
     * @return the viewSummary
     */
    public boolean isViewSummary() {
        return viewSummary;
    }

    /**
     * @param viewSummary the viewSummary to set
     */
    public void setViewSummary(boolean viewSummary) {
        this.viewSummary = viewSummary;
    }

    /**
     * @return the printStatement
     */
    public boolean isPrintStatement() {
        return printStatement;
    }

    /**
     * @param printStatement the printStatement to set
     */
    public void setPrintStatement(boolean printStatement) {
        this.printStatement = printStatement;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        userSession = session;
    }
    
    public Map getSession() {
        return ActionContext.getContext().getSession();
    }

    /**
     * @return the pinChange
     */
    public boolean isPinChange() {
        return pinChange;
    }

    /**
     * @param pinChange the pinChange to set
     */
    public void setPinChange(boolean pinChange) {
        this.pinChange = pinChange;
    }

    /**
     * @return the logout
     */
    public boolean isLogout() {
        return logout;
    }

    /**
     * @param logout the logout to set
     */
    public void setLogout(boolean logout) {
        this.logout = logout;
    }

    /**
     * @return the option
     */
    public String getOption() {
        return option;
    }

    /**
     * @param option the option to set
     */
    public void setOption(String option) {
        this.option = option;
    }

    @Override
    public void setRequest(Map<String, Object> map) {
        this.paramMap = ActionContext.getContext().getParameters();
    }

    /**
     * @return the accountList
     */
    public List<String> getAccountList() {
        return accountList;
    }

    /**
     * @param accountList the accountList to set
     */
    public void setAccountList(List<String> accountList) {
        this.accountList = accountList;
    }

    
}

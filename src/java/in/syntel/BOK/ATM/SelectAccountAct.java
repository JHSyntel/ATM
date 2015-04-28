/*
 * Class for account selection logic
 * Written by Kyle Blair
 */

package in.syntel.BOK.ATM;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author KB5024427
 */
public class SelectAccountAct extends ActionSupport implements SessionAware, RequestAware {
    private Map<String, Object> userSession;
    private Map<String, Object> requests;
    private int userID;
    private int selectedAccountID;
    private boolean checking, savings, cancel;

    
    public SelectAccountAct() {
        
    }
    
    @Override
    public String execute() {
        userSession = this.getSession();
        if(cancel) {
            userSession.remove("menuSelection");
            return "cancel";
        }
        userSession.put("selectedAccountID", getSelectedAccountID());
        if(userSession.containsKey("menuSelection")) {
            String selection = (String)userSession.get("menuSelection");
            return selection;
        }
        else {
            return "noMenuSelection";
        }
        
    }

    @Override
    public void setSession(Map<String, Object> session) {
        userSession = session;
    }
    
    public Map getSession() {
        return ActionContext.getContext().getSession();
    }

    /**
     * @return the userID
     */
    public int getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * @return the selectedAccountID
     */
    public int getSelectedAccountID() {
        return selectedAccountID;
    }

    /**
     * @param selectedAccountID the selectedAccountID to set
     */
    public void setSelectedAccountID(int selectedAccountID) {
        this.selectedAccountID = selectedAccountID;
    }

    @Override
    public void setRequest(Map<String, Object> requestMap) {
        this.requests = requestMap;
    }
    
    public Map getRequest() {
        return ActionContext.getContext().getParameters();
    }

    /**
     * @return the checking
     */
    public boolean isChecking() {
        return checking;
    }

    /**
     * @param checking the checking to set
     */
    public void setChecking(boolean checking) {
        this.checking = checking;
    }

    /**
     * @return the savings
     */
    public boolean isSavings() {
        return savings;
    }

    /**
     * @param savings the savings to set
     */
    public void setSavings(boolean savings) {
        this.savings = savings;
    }

    /**
     * @return the cancel
     */
    public boolean isCancel() {
        return cancel;
    }

    /**
     * @param cancel the cancel to set
     */
    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }
}

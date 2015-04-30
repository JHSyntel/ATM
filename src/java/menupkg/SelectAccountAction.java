/*
 * Class for account selection logic
 * Written by Kyle Blair
 */

package menupkg;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author KB5024427
 */
public class SelectAccountAction extends ActionSupport implements SessionAware, ParameterAware, RequestAware {
    private Map<String, Object> userSession;
    private Map parameters;
    private Map<String, Object> requests;
    private int userID;
    private String accountid;
    private boolean checking, savings, cancel;

    
    public SelectAccountAction() {
        
    }
    
    @Override
    public String execute() {
        this.getSession();
        parameters = this.getParameters();
        requests = this.getRequest();
        if(ActionContext.getContext().getValueStack().peek().getClass().getName().equals("java.util.list")) {
            System.out.println("\n\n LIST MATCHED \n\n");
        }
        if(!userSession.containsKey("menuSelection")) {
            return "noMenuSelection";
        }
        if(cancel) {
            userSession.remove("menuSelection");
            return "cancel";
        }
        else{
            userSession.put("accountid", accountid);
            return userSession.get("menuSelection").toString();
        }
    }

    @Override
    public void setSession(Map<String, Object> session) {
        userSession = session;
    }
    
    private void getSession() {
        this.userSession = ActionContext.getContext().getSession();
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
    
    public Map getParameters() {
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

    @Override
    public void setParameters(Map<String, String[]> maps) {
        this.parameters = maps;
    }

    @Override
    public void setRequest(Map<String, Object> map) {
        this.requests = map;
    }
    
    public Map<String, Object> getRequest() {
        return ActionContext.getContext().getParameters();
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

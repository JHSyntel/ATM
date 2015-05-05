package com.syntelinc.BOK.ATM.print;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.syntelinc.BOK.ATM.menupkg.Hibernate;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author NN5024428
 */
public class PrintAction extends ActionSupport implements SessionAware
{
    private Map<String, Object> userSession;
    
    public PrintAction() 
    {
        
    }
    
    @Override
    public String execute() throws Exception 
    {
        userSession = ActionContext.getContext().getSession();
        Hibernate hib = new Hibernate();
        List accountList = hib.selectAccounts(Integer.parseInt((String)userSession.get("userid")));
        ActionContext.getContext().getValueStack().push(accountList);
        return "SUCCESS";
    }

    @Override
    public void setSession(Map<String, Object> map) {
        userSession = map;
                
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package transactionpkg;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author EH5024424
 */
public class HibernateTransaction {
    
    public HibernateTransaction()
    {
        ValueStack stack = ActionContext.getContext().getValueStack();
        if (stack.findValue("accounttype").equals("checking"))
            CheckingTran();
        else
            SavingsTran();
    }
    
    private void CheckingTran()
    {
        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session s = sf.openSession();
        org.hibernate.Transaction t = s.beginTransaction();
        
        ValueStack stack = ActionContext.getContext().getValueStack();
        
        CheckingTransaction tran = new CheckingTransaction();
        tran.setAcctid((int)stack.findValue("accountid"));
        tran.setTime(new Date());
        tran.setLocation((String)stack.findValue("atmlocation"));
        tran.setBalance((double)stack.findValue("balance"));
        tran.setDebitnumber((double)stack.findValue("debitnumber"));
        
        s.save(tran);
        t.commit();
        s.close();
        sf.close();
    }
    
    private void SavingsTran()
    {
        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session s = sf.openSession();
        org.hibernate.Transaction t = s.beginTransaction();
        
        ValueStack stack = ActionContext.getContext().getValueStack();
        
        SavingsTransaction tran = new SavingsTransaction();
        tran.setAcctid((int)stack.findValue("accountid"));
        tran.setTime(new Date());
        tran.setLocation((String)stack.findValue("atmlocation"));
        tran.setBalance((double)stack.findValue("balance"));
        tran.setDebitnumber((double)stack.findValue("debitnumber"));
        
        s.save(tran);
        t.commit();
        s.close();
        sf.close();
    }
}

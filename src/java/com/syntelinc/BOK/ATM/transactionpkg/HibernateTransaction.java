/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.syntelinc.BOK.ATM.transactionpkg;

import com.opensymphony.xwork2.ActionContext;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author EH5024424
 */
public class HibernateTransaction implements SessionAware
{
    private SessionMap<String, Object> sessionMap;
    public HibernateTransaction() throws IllegalArgumentException
    {
        sessionMap = (SessionMap)ActionContext.getContext().getSession();
        Transaction t = new Transaction();
        AccountTrans(t);
    }
    
    private void AccountTrans(Transaction tran) throws IllegalArgumentException
    {        
        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session s = sf.openSession();
        org.hibernate.Transaction t = s.beginTransaction();
        
        SQLQuery q;
        if (sessionMap.get("accounttype").equals("checking"))
        {
            tran = new CheckingTransaction();
            q = s.createSQLQuery("select balance from checkingtrans where acctid=?");
        }
        else
        {
            tran = new SavingsTransaction();
            q = s.createSQLQuery("select balance from savingstrans where acctid=?");
        }
        
        tran.setAcctid(Integer.parseInt((String)sessionMap.get("accountid")));
        
        q.setInteger(0, tran.getAcctid());
        List ld = q.list();
        BigDecimal bal;
        if (ld.isEmpty())
            bal = new BigDecimal(0);
        else
            bal = (BigDecimal)ld.get(ld.size()-1);
        
        tran.setTime(new Date());
        tran.setLocation((String)sessionMap.get("atmlocation"));
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        tran.setDebitamt(Double.parseDouble((String)sessionMap.get("depositamt")));
        tran.setDebitamt(Double.parseDouble(df.format(tran.getDebitamt())));
        tran.setCreditamt(Double.parseDouble((String)sessionMap.get("withdrawamt")));
        tran.setCreditamt(Double.parseDouble(df.format(tran.getCreditamt())));
        tran.setBalance(bal.doubleValue() + tran.getDebitamt() - tran.getCreditamt());
        tran.setBalance(Double.parseDouble(df.format(tran.getBalance())));
        sessionMap.put("balance", tran.getBalance());
        switch((String)sessionMap.get("type"))
        {
            case "cash":
                tran.setType(1);
                break;
            case "check":
                tran.setType(2);
                break;
            case "default":
                throw new IllegalArgumentException();
        }
        
        s.save(tran);
        t.commit();
        
        s.close();
        sf.close();
    }

    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap)map;
    }
}

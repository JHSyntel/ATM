/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.syntelinc.BOK.ATM.withdrawpkg;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author EH5024424
 */
public class CheckDailyLimit {
    
    public CheckDailyLimit()
    {
        
    }
    
    public double getCurrentTotal()
    {
        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session s = sf.openSession();
        org.hibernate.Transaction t = s.beginTransaction();
        SQLQuery q;
        q = s.createSQLQuery("select creditamt from checkingtrans where acctid=? AND TIME < ? AND TIME > ?");
        q.setInteger(0, 22);
        q.setTimestamp(1, getDayEnd());
        q.setTimestamp(2, getDayStart());
        List<BigDecimal> li = q.list();
        double totalCredit = 0;
        if (li.isEmpty())
            totalCredit = 0;
        else if (li.get(0) == null)
            totalCredit = 0;
        else
        {
            for(BigDecimal cred:li)
            {
                totalCredit += cred.doubleValue();
            }
        }
        
        System.out.println(totalCredit);
        
        if (!li.isEmpty())
            return totalCredit;
        else
            return 0;
    }
    
    private Date getDayStart()
    {
        Calendar dayStart = Calendar.getInstance();
        dayStart.set(Calendar.HOUR_OF_DAY, 0);
        dayStart.set(Calendar.MINUTE, 0);
        dayStart.set(Calendar.SECOND, 0);
        dayStart.set(Calendar.MILLISECOND, 0);
        Date dDayStart = dayStart.getTime();
        System.out.println("first date set: " + dDayStart.toString());
        return dDayStart;
    }
    
    private Date getDayEnd()
    {
        Calendar dayEnd = Calendar.getInstance();
        dayEnd.set(Calendar.HOUR_OF_DAY, 23);
        dayEnd.set(Calendar.MINUTE, 59);
        dayEnd.set(Calendar.SECOND, 59);
        dayEnd.set(Calendar.MILLISECOND, 999);
        Date dDayEnd = dayEnd.getTime();
        System.out.println("second date set: " + dDayEnd.toString());
        return dDayEnd;
    }
}

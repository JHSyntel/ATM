/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.syntelinc.BOK.ATM.menupkg;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author KB5024427
 */
public class Hibernate {
    // Hibernate objects
    Configuration cfg;
    SessionFactory sf;
    Session session;
    Transaction tran;
    Query q;
    
    public Hibernate() {
        cfg  = new Configuration().configure();
        sf = cfg.buildSessionFactory();
        session = sf.openSession();
    }
    
    public List selectAccounts(int userID) {
        q = session.createQuery("from Savingacct where userID = :user");
        q.setParameter("user", userID);
        List sl = q.list();
        q = session.createQuery("from Checkingacct where userID = :user");
        q.setParameter("user", userID);
        List cl = q.list();
        sl.addAll(cl);
        return sl;
    }
    
    public String checkAccountType(String accountID) {
        q = session.createQuery("from Savingacct where accountid = :account");
        int id = Integer.parseInt(accountID);
        q.setParameter("account", id);
        List sl = q.list();
        if(sl.isEmpty()) {
            return "checking";
        }
        else {
            return "savings";
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.syntelinc.BOK.ATM.menupkg;

import com.syntelinc.BOK.ATM.transactionpkg.CheckingTransaction;
import com.syntelinc.BOK.ATM.transactionpkg.SavingsTransaction;
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
        System.out.println(userID);
        q = session.createQuery("from Savingacct where userID = :user");
        q.setParameter("user", userID);
        List sl = q.list();
        q = session.createQuery("from Checkingacct where userID = :user");
        q.setParameter("user", userID);
        List cl = q.list();
        sl.addAll(cl);
        System.out.println(sl.get(0));
        return sl;
    }
    
    public boolean userExists(int userID) {
        q = session.createQuery("from Userdetails where userID = :user");
        q.setParameter("user", userID);
        List sl = q.list();
        return !sl.isEmpty();
    }
    
    public boolean comparePinForUser(int userID, int pinNumber) {
        q = session.createQuery("from Userdetails where userID = :user");
        q.setParameter("user", userID);
        List<Userdetails> sl = q.list();
        return pinNumber == sl.get(0).getPinnum();
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
    
    public List getAccount(int userID, String accountType) {
        //System.out.println(userID);
        if(accountType.equals("checking")) {
            q = session.createQuery("from Checkingacct where userID = :user");
            q.setParameter("user", userID);
            List cl = q.list();
            return cl;
        }
        else {
            q = session.createQuery("from Savingacct where userID = :user");
            q.setParameter("user", userID);
            List sl = q.list();
            return sl;
        }
    }
    
    public List getTransactions(int accountId, String accountType) {
        //System.out.println(userID);
        if(accountType.compareTo("checking") == 0) {
            q = session.createQuery("from CheckingTransaction where acctid = :account").setMaxResults(10);
            q.setParameter("account", accountId);
            List cl = q.list();
            CheckingTransaction ct = (CheckingTransaction)cl.get(0);
            System.out.println(ct.getTransid());
            return cl;
        }
        else {
            q = session.createQuery("from SavingsTransaction where acctid = :account").setMaxResults(10);
            q.setParameter("account", accountId);
            List sl = q.list();
            SavingsTransaction st = (SavingsTransaction)sl.get(0);
            System.out.println(st.getTransid());
            return sl;
        }
    }
    
    
}

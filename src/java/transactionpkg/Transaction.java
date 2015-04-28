/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package transactionpkg;

import java.util.Date;

/**
 *
 * @author EH5024424
 */
public class Transaction
{
    private int acctid;
    private Date time;
    private String location;
    private Double balance;
    private Double debitnumber;
    
    public Transaction()
    {
        
    }

    /**
     * @return the acctid
     */
    public int getAcctid() {
        return acctid;
    }

    /**
     * @param acctid the acctid to set
     */
    public void setAcctid(int acctid) {
        this.acctid = acctid;
    }

    /**
     * @return the time
     */
    public Date getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the balance
     */
    public Double getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    /**
     * @return the debitnumber
     */
    public Double getDebitnumber() {
        return debitnumber;
    }

    /**
     * @param debitnumber the debitnumber to set
     */
    public void setDebitnumber(Double debitnumber) {
        this.debitnumber = debitnumber;
    }
}

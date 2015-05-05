package com.syntelinc.BOK.ATM.fastcash;

import com.syntelinc.BOK.ATM.transactionpkg.*;
import java.util.Date;

public class TransactionFastCash
{
    private int transid;
    private int acctid;
    private Date time;
    private String location;
    private Double balance;
    private Double debitamt;
    private Double creditamt;
    private int type;
    
    public TransactionFastCash()
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
     * @return the debitamt
     */
    public Double getDebitamt() {
        return debitamt;
    }

    /**
     * @param debitamt the debitamt to set
     */
    public void setDebitamt(Double debitamt) {
        this.debitamt = debitamt;
    }

    /**
     * @return the creditamt
     */
    public Double getCreditamt() {
        return creditamt;
    }

    /**
     * @param creditamt the creditamt to set
     */
    public void setCreditamt(Double creditamt) {
        this.creditamt = creditamt;
    }

    /**
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * @return the tranid
     */
    public int getTransid() {
        return transid;
    }

    /**
     * @param tranid the tranid to set
     */
    public void setTransid(int transid) {
        this.transid = transid;
    }
}

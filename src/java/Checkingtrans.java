package hibernate;
// Generated Apr 30, 2015 3:45:12 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * Checkingtrans generated by hbm2java
 */
public class Checkingtrans  implements java.io.Serializable {


     private BigDecimal transid;
     private Checkingacct checkingacct;
     private String location;
     private BigDecimal balance;
     private BigDecimal debit;
     private BigDecimal credit;
     private String details;
     private Date time;

    public Checkingtrans() {
    }

	
    public Checkingtrans(BigDecimal transid, Checkingacct checkingacct, String location, BigDecimal balance, BigDecimal debit, BigDecimal credit) {
        this.transid = transid;
        this.checkingacct = checkingacct;
        this.location = location;
        this.balance = balance;
        this.debit = debit;
        this.credit = credit;
    }
    public Checkingtrans(BigDecimal transid, Checkingacct checkingacct, String location, BigDecimal balance, BigDecimal debit, BigDecimal credit, String details, Date time) {
       this.transid = transid;
       this.checkingacct = checkingacct;
       this.location = location;
       this.balance = balance;
       this.debit = debit;
       this.credit = credit;
       this.details = details;
       this.time = time;
    }
   
    public BigDecimal getTransid() {
        return this.transid;
    }
    
    public void setTransid(BigDecimal transid) {
        this.transid = transid;
    }
    public Checkingacct getCheckingacct() {
        return this.checkingacct;
    }
    
    public void setCheckingacct(Checkingacct checkingacct) {
        this.checkingacct = checkingacct;
    }
    public String getLocation() {
        return this.location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    public BigDecimal getBalance() {
        return this.balance;
    }
    
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    public BigDecimal getDebit() {
        return this.debit;
    }
    
    public void setDebit(BigDecimal debit) {
        this.debit = debit;
    }
    public BigDecimal getCredit() {
        return this.credit;
    }
    
    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }
    public String getDetails() {
        return this.details;
    }
    
    public void setDetails(String details) {
        this.details = details;
    }
    public Date getTime() {
        return this.time;
    }
    
    public void setTime(Date time) {
        this.time = time;
    }




}



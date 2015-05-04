package in.syntel.BOK.ATM.ministatement;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class MiniStatement extends ActionSupport
{
    private Date date;
    String cust;
    private int account;
    private Date tranDate;
    private String Description;
    private double balance;
    
    
    
    
    public MiniStatement()
    {
        
    }
    
    @Override
    public void validate() {
        super.validate(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String execute() throws Exception {
        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session s = sf.openSession();
        Transaction trn = s.beginTransaction();
        
        Query q = s.createQuery(" select ud.name as cust, ud.userID as account, ct.time as checkingTime, st.time as savingTIme, \n" +
"ct.details as checkingDetails, st.details as savingDetails, st.balance as savingBalance, ct.balance as checkingBalance\n" +
"from userdetails ud \n" +
"join checkingacct ca \n" +
"on ud.userid=ca.userid \n" +
"join savingacct sa\n" +
"on ud.userid = ca.userid \n" +
"join checkingtrans ct \n" +
"on ca.checkingid = ct.checkingid\n" +
"join savingtrans st\n" +
"on sa.SAVINGID = st.SAVINGID;");
        List<Userdetails> details = q.list();
       return SUCCESS;
    }

    @Override
    public String input() throws Exception {
        return super.input(); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the accout
     */
    public int getAccount() {
        return account;
    }

    /**
     * @param accout the accout to set
     */
    public void setAccount(int accout) {
        this.account = accout;
    }

    /**
     * @return the tranDate
     */
    public Date getTranDate() {
        return tranDate;
    }

    /**
     * @param tranDate the tranDate to set
     */
    public void setTranDate(Date tranDate) {
        this.tranDate = tranDate;
    }

    /**
     * @return the Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param Description the Description to set
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }

    /**
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
}

package hibernate;
// Generated Apr 30, 2015 3:45:12 PM by Hibernate Tools 4.3.1



/**
 * Atm generated by hbm2java
 */
public class Atm  implements java.io.Serializable {


     private int atmid;
     private Branch branch;
     private char status;
     private int availablecash;

    public Atm() {
    }

    public Atm(int atmid, Branch branch, char status, int availablecash) {
       this.atmid = atmid;
       this.branch = branch;
       this.status = status;
       this.availablecash = availablecash;
    }
   
    public int getAtmid() {
        return this.atmid;
    }
    
    public void setAtmid(int atmid) {
        this.atmid = atmid;
    }
    public Branch getBranch() {
        return this.branch;
    }
    
    public void setBranch(Branch branch) {
        this.branch = branch;
    }
    public char getStatus() {
        return this.status;
    }
    
    public void setStatus(char status) {
        this.status = status;
    }
    public int getAvailablecash() {
        return this.availablecash;
    }
    
    public void setAvailablecash(int availablecash) {
        this.availablecash = availablecash;
    }




}



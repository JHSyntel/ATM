
package in.syntel.BOK.ATM.fastcash;

import com.opensymphony.xwork2.ActionSupport;

public class FastCash extends ActionSupport
{
    private int amount;
    public FastCash()
    {
        
    }

    @Override
    public void validate() {
        super.validate(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String execute() throws Exception 
    {
        switch (getAmount())
        {
            case 20:
                System.out.println("i'm amazing");
                break;
            case 40:
                break;
            case 60:
                break;
            case 80:
                break;
            case 100:
                break;
            case 200:
                break;
//            default:
//                return "fail";
                
        }
       
        System.out.println("--------excute went thru");
        return SUCCESS;
    }
    private double debit;
    
    /**
     * @return the debit
     */
    public double getDebit() {
        return debit;
    }

    /**
     * @param debit the debit to set
     */
    public void setDebit(double debit) {
        this.debit = debit;
    }

    /**
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }
}

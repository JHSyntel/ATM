/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package depositpkg;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author EH5024424
 */
public class DepositAct extends ActionSupport
{
    
    public DepositAct()
    {
        
    }
    
    @Override
    public void validate()
    {
        
    }
    
    @Override
    public String execute()
    {
        System.out.println("depositing");
        ScanCashAct obj = new ScanCashAct();
        System.out.println(obj.getDepositcashamt());
        return SUCCESS;
    }
}

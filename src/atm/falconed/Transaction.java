/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.falconed;

/**
 *
 * @author Dominic
 */

import java.util.Date;

public class Transaction {
    
    /**
     * the size of the transaction
     */
    
    private double amount;
    
    /**
     * time of the transaction using javas date object
     */
    
    private Date timestamp;
    
    /**
     * an optional note about the transaction
     */
    
    private String memo;
    
    /**
     * account form where the transaction originates
     */
    
    private Account inAccount;
    
    /**
     * 
     * @param amount
     * @param inAccount 
     */
    public Transaction(double amount, Account inAccount){
        
        //set value
        this.amount = amount;
        this.inAccount = inAccount;
        this.timestamp = new Date();
        this.memo = "";
        
    }
    /**
     * 
     * @param amount
     * @param memo
     * @param inAccount 
     */
    public Transaction(double amount, String memo, Account inAccount){
        
        //call first constructor
        this(amount, inAccount);
        
        //something 
        this.memo = memo;
        
    }
}

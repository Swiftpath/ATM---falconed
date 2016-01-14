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
import java.util.ArrayList;

public class Account {
    
    /**
     * The type of account
     */
    private String name;
    
  
    /**
     * Unique universal ID, alphanumeric
     */
    private String uuid;
    
    /**
     * The User object associated with the account
     */
    private User holder;
    
    /**
     * A list of all transactions associated with this account
     */
    private ArrayList<Transaction> transactions;
    
    public Account(String name, User holder, Bank theBank) {
        
     this.name = name;
    this.holder = holder;
    
    this.uuid = theBank.getNewAccountUUID();
    
    this.transactions = new ArrayList<>();
    
    //add the holder and the bank
    //holder.addAccount(this);
    //theBank.addAccount(this);
    }
    /**
     * 
     * @return 
     */
    public String getUUID(){
        return this.uuid;
        
    }
    
}

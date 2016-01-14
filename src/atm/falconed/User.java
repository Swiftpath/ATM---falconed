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
import java.security.MessageDigest;
import java.util.ArrayList;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class User {
    
    /**
     * users first name
     */
    private String firstName;
    
    /**
     * users last name
     */
    
    private String lastName;
    
    /**
     * users unique identifier
     */
    
    private String uuid;
    
    /** we'll use Java's MD5 encryption to store pin numbers
     * 
     */
    
    private byte pinHash[];
    
    private ArrayList<Account> accounts;
    
    /**
     * 
     * @param firstName Local variable that will be stored as instance
     * @param lastName 
     * @param pin
     * @param theBank 
     */
    
    public User(String firstName, String lastName, String pin, 
            Bank theBank){
        
        this.firstName = firstName;
            
        this.lastName = lastName;
            
        try {
            
            
            MessageDigest md = MessageDigest.getInstance("MD5");
            this.pinHash = md.digest(pin.getBytes());
        } catch (NoSuchAlgorithmException ex) {
            System.err.println("Caught a NoSuchAlgorithmException");
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            //Kick the user out
            System.exit(1);
        }
        
        //Ask the bank to generate a UUID
        this.uuid = theBank.getNewUserUUID();
        
        //alert the consol of a new user
     
        System.out.printf("New User %s, %s with ID %s created. /n", lastName, 
                firstName, this.uuid);
    }
    
    public void addAccount(Account anAcct){
        this.accounts.add(anAcct);
    }
    /**
     * Accessor method for this user UUID
     * @return 
     */
    public String getUUID(){
        return this.uuid;
        
    }
}

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
import java.util.Random;

public class Bank {

    private String name;
    
    private ArrayList<User> users;
    
    private ArrayList<Account> accounts;
    
    public String getNewUserUUID(){
        //inits
        String uuid;
        Random rng = new Random();
        int len = 6;
        boolean nonUnique;
        
        do {
            uuid = ""; //start with a blank uuid
            //generate a random number
            for (int k = 0; k < len; k++) {
                uuid += ((Integer)rng.nextInt(10)).toString();
            }
            nonUnique = false;
            //check to see if it's unique
            for(User u : this.users){
                if(uuid.compareTo(u.getUUID())== 0) {
                    nonUnique = true;
                    break;
                }
            }
            
        }while(nonUnique);
         return uuid;
    }
        //TODO: FIll
    public String getNewAccountUUID(){
       
        //inits
        String uuid;
        Random rng = new Random();
        int len = 10;
        boolean nonUnique;
        
        do {
            uuid = ""; //start with a blank uuid
            //generate a random number
            for (int k = 0; k < len; k++) {
                uuid += ((Integer)rng.nextInt(10)).toString();
            }
            nonUnique = false;
            //check to see if it's unique
            for(Account a : this.accounts){
                if(uuid.compareTo(a.getUUID())== 0) {
                    nonUnique = true;
                    break;
                }
            }
            
        }while(nonUnique);
        
        return uuid;
    }
    /**
     * 
     * @param anAcct 
     */
     public void addAccount(Account anAcct){
        this.accounts.add(anAcct);
     }
     /**
      * 
      * @param firstName
      * @param lastName
      * @param pin
      * @return 
      */
     public User addUser(String firstName, String lastName, String pin){
        
         //new user object add to list
         User newUser = new User(firstName, lastName, pin, this);
         this.users.add(newUser);
         
         //creat a new savings account for the user
         Account newAccount = new Account("savings", newUser, this);
         this.accounts.add(newAccount);
         
         //return the user
         return newUser;
        
     }
}

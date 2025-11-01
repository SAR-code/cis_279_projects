/*************************************************************
 * Program : CheckingAccount.java
 * Purpose : This file contains the concrete class CheckingAccount
 *           which extends from account
 * Created : 10/31/2025
 * Programmer : D. McCallum
 ******************* Change history *********************
 * Programmer Date Description of change
 *
 * N/A.
 ***********************************************************/

public class CheckingAccount extends Account {

    // Declare constructor to call the base class constructor
    public CheckingAccount(String accountNumber, String fullName, double balance){
        super(accountNumber, fullName, balance);
    }

    // Implements the processTransaction for deposits
    @Override
    public void processTransaction(Transaction t){

        // Conditional logic to handle deposits and checks
         if (t.getTransactionType().equalsIgnoreCase("Deposit")){
             balance += t.getAmount();
         } else if (t.getTransactionType().equalsIgnoreCase("Check")) {
             balance -= t.getAmount();
         }

         // Add transaction to the list
        transaction.add(t);
    }

    @Override
    public String toString(){
        return "Checking Account\n" + super.toString();
    }
}

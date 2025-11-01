/*************************************************************
 * Program : Account.java
 * Purpose : This file contains the class definition and implementation
 *  *           of the Account Class.
 * Created : 10/31/2025
 * Programmer : D. McCallum
 ******************* Change history *********************
 * Programmer Date Description of change
 *
 * N/A.
 ***********************************************************/
import java.util.LinkedList;

public abstract class Account {

    // Declare protected member variables
    protected String accountNumber;
    protected String fullName;
    protected double balance;
    protected double initialBalance;
    protected LinkedList<Transaction> transaction;

    // Declare default constructor
    public Account(String accountNumber, String fullName, double balance) {
        this.accountNumber = accountNumber;
        this.fullName = fullName;
        this.balance = balance;
        this.initialBalance = balance;
        this.transaction = new LinkedList<>();
    }

    // Abstract method to implement
    public abstract void processTransaction(Transaction t);

    // Declare method to print all transactions for this account
    public void displayTransactions(){
        System.out.println("Transactions for account: " + accountNumber);

        // Loop through all transactions and display them
        for (Transaction t : transaction){
            System.out.println(t);
        }
        System.out.println();
    }

    // Display method to show the account summary
    @Override
    public String toString(){
        return "Account Number: " + accountNumber +
                "\nOwner: " + fullName +
                "\nInitial Balance: " + String.format("%.2f", initialBalance) +
                "\nCurrent Balance: " + String.format("%.2f", balance);
    }
}

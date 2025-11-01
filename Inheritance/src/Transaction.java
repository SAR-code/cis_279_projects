/*************************************************************
 * Program : Transaction.java
 * Purpose : This file contains the class definition and implementation
 *  *           of the transaction Class.
 * Created : 10/31/2025
 * Programmer : D. McCallum
 ******************* Change history *********************
 * Programmer Date Description of change
 *
 * N/A.
 ***********************************************************/

import java.time.LocalDate;

public class Transaction {

    // Declare private member variables
    private String transactionType;
    private double amount;
    private LocalDate date;

    // Declare constructor
    public Transaction(String transactionType, double amount){
        this.transactionType = transactionType;
        this.amount = amount;
        this.date = LocalDate.now();
    }

    // Declare getter methods
    public String getTransactionType() {
        return transactionType;
    }

    public double getAmount(){
        return amount;
    }

    // Declare toString method for output
    @Override
    public String toString() {
        return date + " - " + transactionType + ": $" + String.format("%.2f", amount);
    }
}

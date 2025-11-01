/*************************************************************
 * Program : Mortgage.java
 * Purpose : This file contains the concrete class Mortgage
 *           which extends from account
 * Created : 10/31/2025
 * Programmer : D. McCallum
 ******************* Change history *********************
 * Programmer Date Description of change
 *
 * N/A.
 ***********************************************************/

public class Mortgage extends Account {

    // Declare private members specific to mortgage class
    private double annualInterestRate;
    private double monthlyPayment;

    // Constructor to initialize additional fields
    public Mortgage(String accountNumber, String fullName, double balance,
                    double annualInterestRate){
        super(accountNumber, fullName, balance);
        this.annualInterestRate = annualInterestRate;
        this.monthlyPayment = calculateMonthlyPayment();
    }

    // Declare method to calculate monthly payment based on interest rate
    private double calculateMonthlyPayment() {
        double monthlyRate = (annualInterestRate / 100) / 12;
        int numberOfPayments = 360;

        return (balance * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -numberOfPayments));
    }

    // Calculates the monthly interest based on the current balance
    private double calculateMonthlyInterest() {
        return balance * ((annualInterestRate / 100) / 12);
    }

    // Implement abstract methods
    @Override
    public void processTransaction(Transaction t){

        // payments specific to mortgages
        if (t.getTransactionType().equalsIgnoreCase("Payment")) {
            double interest = calculateMonthlyInterest();
            double principal = t.getAmount() - interest;  // Payment minus interest
            balance -= principal; // Reduce loan balance
            transaction.add(t); // Record the transaction
        }
    }

    // Override toString to include interest and payment info
    @Override
    public String toString() {
        return "Mortgage Account\n" + super.toString() +
                "\nAnnual Interest Rate: " + annualInterestRate + "%" +
                "\nMonthly Payment: " + String.format("%.2f", monthlyPayment);
    }


}

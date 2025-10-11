/*************************************************************
 * Program : CreditCardAccount.java
 * Purpose : This file contains the class definition and implementation
 *           of the CreditCardAccount Class. It contains attributes and methods
 *           required for the credit card account
 *
 * Created : 10/10/2025
 * Programmer : D. McCallum
 ******************* Change history *********************
 * Programmer Date Description of change
 *
 * N/A.
 ***********************************************************/
public class CreditCardAccount {

    // Declare private member variables
    private int accountNumber;
    private double beginningBalance;
    private double endingBalance;
    private double creditLimit;
    private double interestRate;
    private Customer customer;

    // Constructor to initialize a new customer object
    public CreditCardAccount(){
        customer = new Customer();
    }

    // Account related setters and getters
    // Account Number
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAccountNumber(){
        return accountNumber;
    }

    // Beginning Balance
    public void setBeginningBalance(double beginningBalance) {
        this.beginningBalance = beginningBalance;
    }

    public double getBeginningBalance(){
        return beginningBalance;
    }

    // Ending Balance
    public void setEndingBalance(double endingBalance) {
        this.endingBalance = endingBalance;
    }

    public double getEndingBalance(){
        return endingBalance;
    }

    // Credit Limit
    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public double getCreditLimit(){
        return creditLimit;
    }

    // Interest Rate
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getInterestRate(){
        return interestRate;
    }

    // Utilize the Customer Class getters and setters
    // Customer Number
    public void setCustomerNumber(int number) {
        customer.setCustomerNumber(number);
    }

    public int getCustomerNumber(){
        return customer.getCustomerNumber();
    }

    // Customer First Name
    public void setCustomerFirstName(String firstName) {
        customer.setFirstName(firstName);
    }

    public String getCustomerFirstName(){
        return customer.getFirstName();
    }

    // Customer Last Name
    public void setCustomerLastName(String lastName) {
        customer.setLastName(lastName);
    }

    public String getCustomerLastName(){
        return customer.getLastName();
    }

    // Customer Credit score
    public void setCustomerCreditScore(int score) {
        customer.setCreditScore(score);
    }

    public int getCustomerCreditScore(){
        return customer.getCreditScore();
    }

    // Method to calculate the average balance
    public double calculateAverageBalance(){
        return (beginningBalance + endingBalance) / 2.0;
    }

    // Method to determine the status of the account
    public String getAccountStatus(){

        // If statement to determine the status
        if (endingBalance <= creditLimit) {
            return "OK";
        } else {
            return "OVER";
        }
    }

    // Method to calculate the penalty for exceeding credit limit
    public double calculatePenalty(){

        // If statement to apply penalty depending on status
        if (endingBalance > creditLimit){
            return endingBalance * 0.05;
        } else {
            return 0.0;
        }

    }

    // Method to output the account summary
    public void displayAccountSummary(){

        // Declare required local variables
        String status = getAccountStatus();
        double balanceAverage = calculateAverageBalance();
        double penalty = calculatePenalty();

        // Display formatted output using printf
        System.out.printf("%-15d %-15d %-15s %-15s %-15d %-15.2f %-15.2f %-15.2f %-15s %-15.2f %-15.2f %-2.0f%%\n",
                accountNumber,
                customer.getCustomerNumber(),
                customer.getLastName(),
                customer.getFirstName(),
                customer.getCreditScore(),
                creditLimit,
                beginningBalance,
                endingBalance,
                status,
                penalty,
                balanceAverage,
                interestRate * 100);
    }

}

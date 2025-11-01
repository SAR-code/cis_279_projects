/*************************************************************
 * Program : Driver.java
 * Purpose : This program demonstrates the use of inheritance,
 *           polymorphism, and abstract classes through the use
 *           of various accounts.
 * Created : 10/31/2025
 * Programmer : D. McCallum
 ******************* Change history *********************
 * Programmer Date Description of change
 *
 * N/A.
 ***********************************************************/
import java.util.LinkedList;

public class Driver {
    public static void main(String[] args) {

        // Declare LinkedList of accounts
        LinkedList<Account> accounts = new LinkedList<>();

        // Create test checking accounts
        CheckingAccount testAccountOne = new CheckingAccount("000123", "Cloud Strife",
                                                            3000.00);
        CheckingAccount testAccountTwo = new CheckingAccount("000456", "Barret Wallace",
                                                            2000.00);

        // Create test mortgage accounts
        Mortgage testMortgageOne = new Mortgage("111456", "Tifa Lockheart",
                                                770000, 7.0);
        Mortgage testMortgageTwo = new Mortgage("111789", "Cid Highwind",
                                                345000, 5.4);

        // Add created accounts to the LinkedList so they will be displayed later
        accounts.add(testAccountOne);
        accounts.add(testAccountTwo);
        accounts.add(testMortgageOne);
        accounts.add(testMortgageTwo);

        // Create and process four transactions for each checking account
        testAccountOne.processTransaction(new Transaction("Deposit", 1000.00, "2025-10-15"));
        testAccountOne.processTransaction(new Transaction("Check", 500.00, "10/20/2025"));
        testAccountOne.processTransaction(new Transaction("Deposit", 2000.00, "2025-10-25"));
        testAccountOne.processTransaction(new Transaction("Check", 700.00, "11-01-2025"));

        testAccountTwo.processTransaction(new Transaction("Deposit", 5000.00, "2025/09/01"));
        testAccountTwo.processTransaction(new Transaction("Check", 300.00, "2025-09-05"));
        testAccountTwo.processTransaction(new Transaction("Deposit", 1000.00, "9-15-2025"));
        testAccountTwo.processTransaction(new Transaction("Check", 2000.00, "2025-09-30"));

        // Create and process four transactions for each mortgage account
        testMortgageOne.processTransaction(new Transaction("Payment", 4700.00, "2025-08-01"));
        testMortgageOne.processTransaction(new Transaction("Payment", 4700.00, "2025-09-01"));
        testMortgageOne.processTransaction(new Transaction("Payment", 4700.00, "2025-10-01"));
        testMortgageOne.processTransaction(new Transaction("Payment", 4700.00, "2025-11-01"));

        testMortgageTwo.processTransaction(new Transaction("Payment", 1875.00, "2025-08-15"));
        testMortgageTwo.processTransaction(new Transaction("Payment", 1875.00, "2025-09-15"));
        testMortgageTwo.processTransaction(new Transaction("Payment", 1875.00, "2025-10-15"));
        testMortgageTwo.processTransaction(new Transaction("Payment", 1875.00, "2025-11-15"));

        // Iterate through the LinkedList and output the results
        for (Account acc : accounts) {
            System.out.println("=======================================");
            System.out.println(acc);
            System.out.println("---------------------------------------");
            acc.displayTransactions();
        }

    }
}
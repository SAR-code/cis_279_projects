import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Output a read-able header
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s\n",
                "AcctNum", "CustID", "LastName", "FirstName", "CreditScore", "Limit",
                "BegBal", "EndBal", "Status", "Penalty", "AvgBal", "IntRate");

        // Implement a try-catch block to handle file operations
        try {
            // Create the required file object
            File file = new File("HW5_Accounts.txt");

            // Create a scanner to read from the accounts file
            Scanner input = new Scanner(file);

            // Initialize a while loop to read through each line of the file
            while (input.hasNext()){

                // Reads through each line
                int accountNum = input.nextInt();
                double begBal = input.nextDouble();
                double endBal = input.nextDouble();
                double limit = input.nextDouble();
                double interestRate = input.nextDouble();
                int customerNum = input.nextInt();
                String lastName = input.next();
                String firstName = input.next();
                int creditScore = input.nextInt();

                // Create a new CreditCardAccount Object
                CreditCardAccount account = new CreditCardAccount();

                // Set the account data
                account.setAccountNumber(accountNum);
                account.setBeginningBalance(begBal);
                account.setEndingBalance(endBal);
                account.setCreditLimit(limit);
                account.setInterestRate(interestRate);

                // Set the customer information
                account.setCustomerNumber(customerNum);
                account.setCustomerLastName(lastName);
                account.setCustomerFirstName(firstName);
                account.setCustomerCreditScore(creditScore);

                // Display the account summary
                account.displayAccountSummary();
            }

            // Closes the file after reading all the lines
            input.close();

        } catch (FileNotFoundException exception){

            // If file doesn't exist
            System.out.println("Error occurred: Cannot find file");
        }


    }
}
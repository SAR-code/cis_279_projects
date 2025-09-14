/*************************************************************
 * Program : Driver.java
 * Purpose : This program calculates the ending balance of
 *           monthly deposits and includes the interest.
 *
 * Created : 9/13/2025
 * Programmer : D. McCallum
 ******************* Change history *********************
 * Programmer Date Description of change
 *
 * N/A.
 ***********************************************************/

import java.util.Scanner;
public class Driver {

	public static void main(String[] args) {
		// Input from user
		Scanner scan = new Scanner(System.in);
		
		// Number of months
		System.out.println("Enter the number of months:");
		int numMonth = scan.nextInt();
		
		// Periodic deposit
		System.out.println("Enter periodic deposit amount: ");
        double depositAmount = scan.nextDouble();

		// Annual interest
        System.out.println("Enter the annual interest rate: ");
        double annualPercent = scan.nextDouble();

        // Convert the percentage into decimal for monthly rate
        double monthlyRate = (annualPercent / 100.00) / 12.0;

        // Declare variables to store the totals
        double totalDeposits = depositAmount * numMonth;
        double endBalance = 0.0;

        // Table Header
        System.out.printf("%-8s %-10s %-20s %-15s %-18s %-12s%n",
                "Month", "Deposit", "Months of Interest", "1+Rate", "(1+Rate)^Months", "Deposit w/Interest");

		// Perform a loop compounds the interest
		for (int index = 1; index <= numMonth; index++){

            // Interest decreasing each month
            int monthsInterest = numMonth - index + 1;

            // Compound interest
            double growthAmount = Math.pow(1 + monthlyRate, monthsInterest);

            // Calculate deposit with included interest
            double depositPlusInterest = depositAmount * growthAmount;

            // Calculate ending balance
            endBalance += depositPlusInterest;

            // Output each row
            System.out.printf("%-8d %-10.2f %-20d %-15.4f %-18.6f %-12.4f%n",
                    index, depositAmount, monthsInterest, (1 + monthlyRate), growthAmount, depositPlusInterest);
        }
		
		// Output monthly values
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.printf("Sum of deposits: %.2f%n", totalDeposits);
        System.out.printf("End-of-year total: %.2f%n", endBalance);

		
		
		scan.close();

	}

}

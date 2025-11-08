import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Payroll {

    // Declare a file path for payroll
    public static final String FILE_NAME = "c:\\data\\payroll.dat";

    public static void main(String[] args) {

        // Declare scanner variable
        Scanner inputFile = null;

        try {
            // Try to open the file for reading
            inputFile = new Scanner(new File(FILE_NAME));

            // Print header for the formatted table
            System.out.printf("%-10s %-12s %-12s %10s %10s %12s %12s %12s%n",
                    "Emp ID", "Last Name", "First Name", "Hours", "Rate", "Reg Pay", "OT Pay", "Total Pay");
            System.out.println("-------------------------------------------------------------------------------------------------");

            // Read until end of file
            while (inputFile.hasNext()) {

                try {
                    // Read each employee's data in the specified order
                    int empID = inputFile.nextInt();
                    String lastName = inputFile.next();
                    String firstName = inputFile.next();
                    double hoursWorked = inputFile.nextDouble();
                    double hourlyRate = inputFile.nextDouble();

                    // Call method to calculate pay
                    double[] payData = calculatePay(hoursWorked, hourlyRate);
                    double regPay = payData[0];
                    double otPay = payData[1];
                    double totalPay = regPay + otPay;

                    // Display formatted output for the employee
                    System.out.printf("%-10d %-12s %-12s %10.2f %10.2f %12.2f %12.2f %12.2f%n",
                            empID, lastName, firstName, hoursWorked, hourlyRate, regPay, otPay, totalPay);

                } catch (InputMismatchException e) {
                    // Handle wrong data type (e.g., expecting double but got string)
                    System.out.println("\n*** ERROR: Invalid data type found in the file. ***");
                    System.out.println("Program terminated due to input format error.");
                    inputFile.close();
                    System.exit(-1);
                }
            }

        } catch (FileNotFoundException e) {
            // Handle file not found exception
            System.out.println("*** ERROR: The file " + FILE_NAME + " was not found. ***");
            System.out.println("Please check the file path and try again.");
            System.exit(-1);

        } finally {
            // Close the file if it was opened
            if (inputFile != null) {
                inputFile.close();
            }
        }
    }

    // Declare a function to calculate regular and overtime pay
    public static double[] calculatePay(double hours, double rate) {
        double regPay, otPay;

        if (hours <= 40) {
            regPay = hours * rate;
            otPay = 0.0;
        } else {
            regPay = 40 * rate;
            otPay = (hours - 40) * rate * 1.5;
        }

        // Return both values in an array
        return new double[]{regPay, otPay};
    }
}
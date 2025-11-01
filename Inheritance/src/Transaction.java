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
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Transaction {

    // Declare private member variables
    private String transactionType;
    private double amount;
    private LocalDate date;


    public Transaction(String transactionType, double amount, String dateString){
        this.transactionType = transactionType;
        this.amount = amount;
        this.date = parseDate(dateString);
    }

    // Parse a date string using common patterns
    private static LocalDate parseDate(String dateString) {
        if (dateString == null || dateString.isBlank()) {
            throw new IllegalArgumentException("Date string cannot be null or empty");
        }


        try {
            return LocalDate.parse(dateString);
        } catch (DateTimeParseException ignored) { }

        String[] patterns = {"M/d/yyyy", "MM/dd/yyyy", "M-d-yyyy", "MM-dd-yyyy", "d-M-yyyy", "d/M/yyyy", "yyyy/MM/dd"};
        for (String p : patterns) {
            try {
                DateTimeFormatter f = DateTimeFormatter.ofPattern(p);
                return LocalDate.parse(dateString, f);
            } catch (DateTimeParseException ignored) { }
        }

        throw new IllegalArgumentException("Unrecognized date format: " + dateString + " (expected yyyy-MM-dd or similar)");
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
        DateTimeFormatter out = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(out) + " - " + transactionType + ": $" + String.format("%.2f", amount);
    }
}

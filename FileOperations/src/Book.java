/*************************************************************
 * Program : Book.java
 * Purpose : This file contains the class definition and implementation
 *           of the Book Class. It contains attributes and methods
 *           required for the book data
 *
 * Created : 11/12/2025
 * Programmer : D. McCallum
 ******************* Change history *********************
 * Programmer Date Description of change
 *
 * N/A.
 ***********************************************************/

import java.io.IOException;
import java.io.RandomAccessFile;

public class Book {

    // Declare fixed lengths for String variables
    public static final int TITLE_LENGTH = 24;
    public static final int ISBN_LENGTH = 13;

    // Declare private member variables
    private String title;
    private String isbn;
    private int yearPublished;
    private double price;

    // Constructor
    public Book (String isbn, String title, int yearPublished, double price) {
        this.isbn = isbn;
        this.title = title;
        this.yearPublished = yearPublished;
        this.price = price;
    }

    // Declare getters and setters

    // Title methods
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // ISBN methods
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    // Year Published methods
    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    // Price methods
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Checks the length of a String variable and adjusts it to fit the fixed length
    public static String adjustLength(String strVar, int numChars){

        if (strVar.length() > numChars) {
            strVar = strVar.substring(0, numChars);
        } else {
            while (strVar.length() < numChars) {
                strVar = strVar + " ";
            }
        }
        return strVar;
    }

    // Write a Book object to a RandomAccessFile
    public void writeBook(RandomAccessFile file) throws IOException {
        file.writeChars(adjustLength(isbn, ISBN_LENGTH));
        file.writeChars(adjustLength(title, TITLE_LENGTH));
        file.writeInt(yearPublished);
        file.writeDouble(price);
    }

    // Read a Book object from a RandomAccessFile
    public static Book readBook(RandomAccessFile file) throws IOException {

        // Read ISBN
        char[] isbnChars = new char[ISBN_LENGTH];
        for (int i = 0; i < ISBN_LENGTH; i++) {
            isbnChars[i] = file.readChar();
        }
        String isbn = new String(isbnChars).trim();

        // Read Title
        char[] titleChars = new char[TITLE_LENGTH];
        for (int i = 0; i < TITLE_LENGTH; i++) {
            titleChars[i] = file.readChar();
        }
        String title = new String(titleChars).trim();

        // Read Year Published
        int yearPublished = file.readInt();

        // Read Price
        double price = file.readDouble();

        return new Book(isbn, title, yearPublished, price);
    }

    // Return the record size of a book in bytes
    public static int getRecordSize() {
        return (ISBN_LENGTH * 2) + (TITLE_LENGTH * 2) + 4 + 8;
    }

    // toString method to display book information
    public String toString() {
        return "ISBN: " + isbn + ", Title: " + title + ", Year Published: " + yearPublished +
                ", Price: $" + String.format("%.2f", price);
    }



}

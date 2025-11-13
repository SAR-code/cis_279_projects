/*************************************************************
 * Program : BookFileManager.java
 * Purpose : This file contains the class definition and implementation
 *           of the BookFileManager Class. It contains attributes and methods
 *           required to manage the book filing data
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

public class BookFileManager {

    // Declare private member variables
    private String filename;

    // Constructor
    public BookFileManager(String filename) {
        this.filename = filename;
    }

    // Declare a method to write a list of books to a file
    public void writeBooksToFile(Book[] books) throws IOException {

        RandomAccessFile file = new RandomAccessFile(filename, "rw");

        // Clear the file before writing
        file.setLength(0);

        // Write each book to the file
        for (Book book : books) {
            book.writeBook(file);
        }

        file.close();

    }

    // Declare a method to read a list of books from a file
    public void readBooks() throws IOException {

        RandomAccessFile file = new RandomAccessFile(filename, "r");

        long numRecords = file.length() / Book.getRecordSize();
        for (int i = 0; i < numRecords; i++) {
            file.seek(i * Book.getRecordSize());
            Book book = Book.readBook(file);
            System.out.println(book);
        }

        file.close();
    }

    // Update a single book's title
    public void updateBookTitle(int recordNumber, String newTitle) throws IOException {

        RandomAccessFile file = new RandomAccessFile(filename, "rw");
        file.seek(recordNumber * Book.getRecordSize());

        // Skips ISBN field first
        file.skipBytes(Book.ISBN_LENGTH * 2);

        // Write the new title
        file.writeChars(Book.adjustLength(newTitle, Book.TITLE_LENGTH));

        file.close();
    }

    // Updates a single book's price
    public void updateBookPrice(int recordNumber, double newPrice) throws IOException {
        RandomAccessFile file = new RandomAccessFile(filename, "rw");
        file.seek(recordNumber * Book.getRecordSize());

        // Skip ISBN, Title, and year fields
        file.skipBytes(Book.ISBN_LENGTH * 2);
        file.skipBytes(Book.TITLE_LENGTH * 2);
        file.skipBytes(4);

        // Write the new price
        file.writeDouble(newPrice);

        file.close();
    }

}

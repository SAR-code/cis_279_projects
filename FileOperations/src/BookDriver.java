/*************************************************************
 * Program : BookDriver.java
 * Purpose : This program demonstrates the use of Text File I/O
 *           by writing 5 book objects to a file.
 * Created : 11/12/2025
 * Programmer : D. McCallum
 ******************* Change history *********************
 * Programmer Date Description of change
 *
 * N/A.
 ***********************************************************/
public class BookDriver {
    public static void main(String[] args) {

        // Create an array of 5 Book objects
        Book[] books = new Book[5];
        books[0] = new Book("9780135166307", "Effective Java", 2018, 45.00);
        books[1] = new Book("9780596009205", "Intro into C#", 2005, 35.50);
        books[2] = new Book("9780132350884", "Rebuilding Rotary Engines", 2008, 40.75);
        books[3] = new Book("9780201633610", "Design Patterns", 1994, 50.25);
        books[4] = new Book("9781617294945", "Rich Dad Poor Dad", 2006, 55.00);

        // Create a BookFileManager object
        BookFileManager fileManager = new BookFileManager("books.dat");

        try {
            // Write the books to the file
            fileManager.writeBooksToFile(books);

            // Read and display the books from the file
            System.out.println("Books read from file:");
            fileManager.readBooks();

            // Update the title of the book in index 4
            fileManager.updateBookTitle(4, "Rich Dad's Guide to Investing");

            // Update the price of the book in index 2
            fileManager.updateBookPrice(2, 77.00);

            // Read and display the updated books from the file
            System.out.println("\nBooks after updates:");
            fileManager.readBooks();

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
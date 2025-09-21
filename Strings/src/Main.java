/*************************************************************
 * Program : Main.java
 * Purpose : This reads the index.html file and outputs a new
 *           index2.html
 *
 * Created : 9/20/2025
 * Programmer : D. McCallum
 ******************* Change history *********************
 * Programmer Date Description of change
 *
 * N/A.
 ***********************************************************/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Declare the file name to be read
        String inputFileName = "index.html";

        // Declare the output file name
        String outputFileName = "index2.html";

        // Implement a try-catch block to handle file operations

        try {
            // Open the requested input file
            File inputFile = new File(inputFileName);
            Scanner scanner = new Scanner(inputFile);

            // Implement the StringBuilder to build the content
            StringBuilder fileContent = new StringBuilder();

            // Read each line of the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Remove the line breaks
                fileContent.append(line);
            }

            // Close the scanner
            scanner.close();

            // Swap "html" with "HTML"
            String updatedText = fileContent.toString().replace("html", "HTML");

            // Take the updated changes and applies them to index2.html
            FileWriter writer = new FileWriter(outputFileName);
            writer.write(updatedText);
            writer.close();

            System.out.println("File process complete! Changes applied to " + outputFileName);
        } catch(IOException exception) {
            // Handle errors if file doesn't exist or corrupt
            System.out.println("File error");
        }
    }
}
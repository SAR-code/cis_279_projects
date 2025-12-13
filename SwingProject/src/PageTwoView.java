/*************************************************************
 * Program : PageTwoView.java
 * Purpose : This program implements the second page view of a
 *           basic website using Swing components.
 * Created : 12/13/2025
 * Programmer : D. McCallum
 ******************* Change history *********************
 * Programmer Date Description of change
 *
 * N/A.
 ***********************************************************/

import javax.swing.*;
import java.awt.*;

public class PageTwoView extends JFrame {
    // Declare text area for displaying received text
    private final JTextArea displayText = new JTextArea(12, 40);

    // Constructor to set up the GUI components
    public PageTwoView() {

        // Utilizes superclass constructor to set the title
        super("Website - Page Two (Display Received Text)");

        // Set label for the text area
        JLabel title = new JLabel("Text received from Page One:");
        title.setFont(title.getFont().deriveFont(Font.BOLD, 16f));

        // Configure the text area
        displayText.setLineWrap(true);
        displayText.setWrapStyleWord(true);
        displayText.setEditable(false);

        // Set up the layout and add components
        JScrollPane scroll = new JScrollPane(displayText);
        setLayout(new BorderLayout(10, 10));
        add(title, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();

        // Center the window on the screen
        setLocationRelativeTo(null);
    }

    // Method to set the text in the display area
    public void setDisplayText(String text) {
        displayText.setText(text);
    }
}

/*************************************************************
 * Program : PageOneView.java
 * Purpose : This program implements the first page view of a
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

public class PageOneView extends JFrame {

    // Declare text area for user input
    private final JTextArea inputText = new JTextArea(12, 40);

    // Constructor to set up the GUI components
    public PageOneView() {

        // Utilizes superclass constructor to set the title
        super("Website - Page One (Live Input)");

        // Set label for the text area
        JLabel title = new JLabel("Enter text to be sent to Page Two:");
        title.setFont(title.getFont().deriveFont(Font.BOLD, 16f));

        inputText.setLineWrap(true);
        inputText.setWrapStyleWord(true);

        // Set up the layout and add components
        JScrollPane scroll = new JScrollPane(inputText);
        setLayout(new BorderLayout(10, 10));
        add(title, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();

        // Center the window on the screen
        setLocationRelativeTo(null);
    }

    // Provide access to the input JTextArea so the controller can attach listeners
    // and read the current text when needed.
    public JTextArea getInputText() {
        return inputText;
    }
}

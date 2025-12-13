/*************************************************************
 * Program : Main.java
 * Purpose : This program demonstrates a basic website that reads
 *           text from one pages and writes it to another page
 *           using Swing components.
 * Created : 12/13/2025
 * Programmer : D. McCallum
 ******************* Change history *********************
 * Programmer Date Description of change
 *
 * N/A.
 ***********************************************************/
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        SwingUtilities.invokeLater(() -> {
            TextComponent component = new TextComponent();
            PageOneView pageOne = new PageOneView();
            PageTwoView pageTwo = new PageTwoView();

            new PageController(component, pageOne, pageTwo);

            pageOne.setVisible(true);
            pageTwo.setVisible(true);
        });
    }
}
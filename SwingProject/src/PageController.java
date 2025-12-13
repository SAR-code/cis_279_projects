/*************************************************************
 * Program : PageController.java
 * Purpose : This program implements the controller for
 *           managing interactions between Page One and Page Two
 * Created : 12/13/2025
 * Programmer : D. McCallum
 ******************* Change history *********************
 * Programmer Date Description of change
 *
 * N/A.
 ***********************************************************/

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class PageController {

    // Declare member variables for the model and views
    private final TextComponent model;
    private final PageOneView pageOne;
    private final PageTwoView pageTwo;

    // Constructor to initialize the controller with model and views
    public PageController(TextComponent model, PageOneView pageOne, PageTwoView pageTwo) {
        this.model = model;
        this.pageOne = pageOne;
        this.pageTwo = pageTwo;

        // Set up event wiring
        wireEvents();
    }

    // Method to wire events between the views and model
    private void wireEvents() {
        // Listen for text changes in Page One's input area
        pageOne.getInputText().getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                pushToModel();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                pushToModel();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                pushToModel();
            }

        });

        // Listen for text changes in the model to update Page Two's display area
        model.addTextChangeListener(pageTwo::setDisplayText);

        // Initialize Page Two with the current text from the model
        model.setText(pageOne.getInputText().getText());
    }

    // Method to push to model
    private void pushToModel() {

        model.setText(pageOne.getInputText().getText());
    }
}

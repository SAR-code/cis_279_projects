/*************************************************************
 * Program : TextComponent.java
 * Purpose : This program demonstrates a basic website that reads
 *           text from one pages and writes it to another page
 *           this class represents the text component used in the application.
 * Created : 12/13/2025
 * Programmer : D. McCallum
 ******************* Change history *********************
 * Programmer Date Description of change
 *
 * N/A.
 ***********************************************************/
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class TextComponent {

    // Declare private member variable to hold text
    private String text ="";
    private final List<Consumer<String>> listeners = new ArrayList<>();

    // Method to get the current text
    public String getText() {
        return text;
    }

    // Method to set new text and notify listeners
    public void setText(String newText)
    {
        // Handle null input
        if (newText == null) {
            newText = "";
        }

        // Notify listeners only if text has changed
        if (!newText.equals(this.text)) {
            this.text = newText;
            notifyListeners();
        }
    }

    // Method to add a listener for text changes
    public void addTextChangeListener(Consumer<String> listener) {
        listeners.add(listener);
    }

    // Method to notify all listeners of text change
    private void notifyListeners() {
        for (Consumer<String> listener : listeners) {
            listener.accept(this.text);
        }
    }
}

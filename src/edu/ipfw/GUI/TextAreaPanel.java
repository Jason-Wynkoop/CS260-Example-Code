package edu.ipfw.GUI;


import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

/**
 * Creats a panels that holds a JTextArea
 * uses setter and getter for the text
 * within the text area
 * @author JasonWynkoop
 *
 */

@SuppressWarnings("serial")
public class TextAreaPanel extends JPanel {

    private JTextArea textBox;
    private JScrollPane scrollPane;

    public TextAreaPanel(TextBoxGUI tbg) {

        textBox = new JTextArea();
        textBox.setWrapStyleWord(true);
        textBox.setLineWrap(true);
        scrollPane = new JScrollPane(textBox);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        scrollPane.setPreferredSize(new Dimension(350, 450));
        add(scrollPane);

    }

    /**
     * Gets the text from the textBox and returns it
     * @return - textBox text
     */
    public String getText(){
        return textBox.getText();
    }

    /**
     * @param newText
     */
    public void setText(String newText){
        textBox.setText(newText);
    }


}
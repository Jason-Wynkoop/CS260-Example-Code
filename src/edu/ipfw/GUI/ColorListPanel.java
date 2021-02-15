package edu.ipfw.GUI;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * ColorListPanel holds the color list and 
 * two buttons to add and delete colors 
 * from the list
 * @author JasonWynkoop
 *
 */
@SuppressWarnings("serial")
public class ColorListPanel extends JPanel {

    private DefaultListModel<Color> list;
    private JList<Color> colorList;
    private JPanel	buttonPanel;
    private JButton deleteColor, addColor;
    private JScrollPane scrollPane;
    private JPanel colorListPanel;
    private Color myColor;
    private TextBoxGUI textAreaBackground;

    /**
     * Creates a new ColorPanel when called in the TextBoxGUI
     * class.  Holds the color list and uses a JColorChooser in
     * order to get the color wanted
     */
    public ColorListPanel(TextBoxGUI textAreaBackground){
        this.textAreaBackground = textAreaBackground;
        //setting the initial layout of the East panel
        setLayout(new GridLayout(2, 1, 0, 0));

        list = new DefaultListModel<Color>();

        colorListPanel = new JPanel();
        colorList = new JList<Color>(list);
        colorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        colorList.setVisibleRowCount(4);
        scrollPane = new JScrollPane(colorList);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        colorListPanel.add(scrollPane);

        //Adding the add and delete buttons to the buttonPanel
        buttonPanel = new JPanel();
        deleteColor = new JButton("Delete Color");
        deleteColor.addActionListener(new ButtonListener());
        addColor = new JButton("Add Color");
        addColor.addActionListener(new ButtonListener());
        buttonPanel.add(addColor);
        buttonPanel.add(deleteColor);


        colorList.addListSelectionListener(new ListListener());

        //adding the panels to the ColorListPanel
        add(colorListPanel);
        add(buttonPanel);


    }

    /**
     *
     * @return - myColor
     */
    public Color getColor(){
        return myColor;
    }

    /**
     * when the user selects a color in the list, this runs
     * It sets the the selected color to type Color
     * @author JasonWynkoop
     *
     */
    private class ListListener implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if(!colorList.getValueIsAdjusting() && colorList.getSelectedIndex() != -1){
                Color selectedColor = colorList.getSelectedValue();
                myColor = selectedColor;
                textAreaBackground.sendText().setBackground(selectedColor);
            }

        }

    }

    /**
     * Runs when the user clicks one of the two buttons
     * in the colorPanel
     * @author JasonWynkoop
     *
     */
    private class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            //Runs when the user clicks the "Add Color"
            //Uses the JColorChooser
            if(e.getActionCommand().equals("Add Color")){
                Color c = JColorChooser.showDialog(null,
                        "Pick a color", Color.blue);

                if(c != null){
                    list.addElement(c);
                }

                //Runs when the user clicks the "delete" button
            }else if(e.getActionCommand().equals("Delete Color")){
                //So we don't get an error when the user clicks delete without selecting a color
                if(colorList.getSelectedIndex() != -1){
                    list.remove(colorList.getSelectedIndex());
                }


            }

        }

    }


}
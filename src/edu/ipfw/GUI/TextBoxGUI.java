package edu.ipfw.GUI;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.*;

/**
 * Main frame in which both panes are help
 * has an instance of both the text area panel and 
 * color list panels.  Uses menu bar for the file, save, and load
 * buttons
 * @author JasonWynkoop
 *
 */
@SuppressWarnings("serial")
public class TextBoxGUI extends JFrame {

    private TextAreaPanel textPane;
    private ColorListPanel colorPanel;
    private JMenuItem menuLoad;
    private JMenuItem menuSave;
    private JMenuItem menuExit;

    /**
     * TextBoxGUI is a frame that holds two panels,
     * and a menu bar.
     */
    public TextBoxGUI(){

        super("Simple Wordpad");
        getContentPane().setLayout(new BorderLayout());
        setSize(700,500);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                String ObjButtons[] = {"Yes","No"};
                int PromptResult = JOptionPane.showOptionDialog(null,
                        "Are you sure you want to exit?","Online Examination System",
                        JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
                if(PromptResult==JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        setLocationRelativeTo(null);

        textPane = new TextAreaPanel(this);
        colorPanel = new ColorListPanel(this);

        getContentPane().add(textPane, BorderLayout.CENTER);
        getContentPane().add(colorPanel, BorderLayout.EAST);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menuFile = new JMenu("File");
        menuBar.add(menuFile);

        menuLoad = new JMenuItem("Load");
        menuLoad.addActionListener(new ButtonHandler());
        menuFile.add(menuLoad);

        menuSave = new JMenuItem("Save");
        menuSave.addActionListener(new ButtonHandler());
        menuFile.add(menuSave);

        menuExit = new JMenuItem("Exit");
        menuExit.addActionListener(new ButtonHandler());
        menuFile.add(menuExit);


        //adding hot keys and tool tips
        menuLoad.setMnemonic(KeyEvent.VK_L);
        menuLoad.setToolTipText("Load a previously saved document.");
        menuSave.setMnemonic(KeyEvent.VK_S);
        menuSave.setToolTipText("Save current text document.");
        menuExit.setMnemonic(KeyEvent.VK_E);
        menuExit.setToolTipText("Exit the application");
        menuFile.setMnemonic(KeyEvent.VK_F);

    }

    public TextBoxGUI sendGUI(){

        return this;
    }

    public TextAreaPanel sendText(){

        return textPane;
    }

    public ColorListPanel sendColor(){

        return colorPanel;
    }

    /**
     * runs when the user clicks on the file button
     * Save - saves the current text in the text area
     * Load - pulls up a file explore to load a text file
     * Exit - exits the program
     * @author JasonWynkoop
     *
     */
    private class ButtonHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Exit")){
                JFileChooser jfc = new JFileChooser();
                int selection = jfc.showSaveDialog(null);
                if(selection == jfc.APPROVE_OPTION){
                    File f = jfc.getSelectedFile();
                    PrintWriter pw = null;
                    try {
                        pw = new PrintWriter(new FileWriter(f.getAbsolutePath()));
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    pw.print(textPane.getText());
                    pw.close();
                }
                System.exit(0);

            }else if(e.getActionCommand().equals("Save")){
                try {
                    JFileChooser jfc = new JFileChooser();
                    int selection = jfc.showSaveDialog(null);
                    if(selection == jfc.APPROVE_OPTION){
                        File f = jfc.getSelectedFile();
                        PrintWriter pw = new PrintWriter(new FileWriter(f.getAbsolutePath()));
                        pw.print(textPane.getText());
                        pw.close();
                    }

                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }else if(e.getActionCommand().equals("Load")){
                try {
                    JFileChooser jfc = new JFileChooser();
                    int selection = jfc.showOpenDialog(null);
                    if(selection == jfc.APPROVE_OPTION){
                        File f = jfc.getSelectedFile();
                        Scanner scan = new Scanner(f);

                        String s = "";
                        while(scan.hasNextLine()){
                            s = scan.nextLine();
                        }
                        textPane.setText(s);
                        scan.close();
                    }

                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }

        }

    }

}
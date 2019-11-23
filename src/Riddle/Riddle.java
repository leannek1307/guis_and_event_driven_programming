/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Riddle;

/**
 *
 * @author leannekim
 */
/*
 * HelloWorldWithGUI2.java from Chapter 10
 * The Hello World application with a button.
 * Lawrenceville Press
 * June 10, 2011
 */


import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;

public class Riddle implements ActionListener {
	static String LABEL_TEXT = "Why did the chicken cross the road?";
	JFrame frame;
	JPanel contentPane;
	JLabel label;
        JLabel label2;
	JButton button;

    public Riddle(){
        /* Create and set up the frame */
        frame = new JFrame("Riddle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Create a content pane */
        contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(2,2,10,5));
        contentPane.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        /* Create and add label */
        label = new JLabel(LABEL_TEXT);
        label.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        contentPane.add(label);

        label2 = new JLabel(" ");
        label2.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        contentPane.add(label2);
        
        /* Create and add button */
        button = new JButton("Answer");
        button.setAlignmentX(JButton.LEFT_ALIGNMENT);
    	button.setActionCommand("Answer");
    	button.addActionListener(this);
        
    	contentPane.add(button);

        /* Add content pane to frame */
        frame.setContentPane(contentPane);

        /* Size and then display the frame. */
        frame.pack();
        frame.setVisible(true);
    }


    /**
     * Handle button click action event
     * pre: none
     * post: Clicked button has different text and label
     * displays message depending on when the button was clicked.
     */
    public void actionPerformed(ActionEvent event) {
        String eventName = event.getActionCommand();

        if (eventName.equals("Answer")) {
            label2.setText("To get to the other side.");
        }
    }


    /**
     * Create and show the GUI.
     */
    private static void runGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);

        Riddle greeting = new Riddle();
    }


    public static void main(String[] args) {
        /* Methods that create and show a GUI should be
           run from an event-dispatching thread */
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                runGUI();
            }
        });
    }
}

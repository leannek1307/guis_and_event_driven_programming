/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NumClicks;

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


import javax.swing.*;
import java.awt.event.*;

public class NumClicks implements ActionListener{
	JFrame frame;
	JPanel contentPane;
	JLabel label;
	JButton button;
        int clickCount = 0;

    public NumClicks(){
        /* Create and set up the frame */
        frame = new JFrame("NumClicks");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Create a content pane */
        contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(50,70,50,70));

        /* Create and add button */
        button = new JButton("Click");
    	button.setActionCommand("Click");
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

        if (eventName.equals("Click")) {
        	clickCount++;
                button.setText("You have clicked " + clickCount + " times.");
        }
    }


    /**
     * Create and show the GUI.
     */
    private static void runGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);

        NumClicks greeting = new NumClicks();
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

package ChangeColour;
/*
 * ColorDemo.java from Chapter 10
 * Displays an application GUI in non-default colors.
 * Lawrenceville Press
 * June 10, 2011
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChangeColour implements ActionListener {
	JFrame frame;
	JPanel contentPane;
	JTextField name;
	JButton displayMessage;
	JLabel textFieldPrompt, hello;

    public ChangeColour(){
        /* Create and set up the frame */
        frame = new JFrame("ColorDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Create a content pane with a BoxLayout and empty borders */
        contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        contentPane.setBackground(Color.white);
        contentPane.setLayout(new GridLayout(0, 2, 5, 10));

		/* Create a text field and a descriptive label */
	    textFieldPrompt = new JLabel("Type your name: ");
	    textFieldPrompt.setForeground(Color.red);
	    contentPane.add(textFieldPrompt);

	    name = new JTextField(10);
	    name.setBackground(Color.pink);
	    name.setForeground(Color.darkGray);
	    contentPane.add(name);

		/* Create a Display Message button */
	    displayMessage = new JButton("Display Message");
	    displayMessage.setBackground(Color.yellow);
	    displayMessage.setForeground(Color.blue);
	    displayMessage.addActionListener(this);
	    contentPane.add(displayMessage);

	    /* Create a label that will display a message */
	    hello = new JLabel(" ");
	    hello.setForeground(Color.green);
	    contentPane.add(hello);

		/* Add content pane to frame */
        frame.setContentPane(contentPane);

        /* Size and then display the frame. */
        frame.pack();
        frame.setVisible(true);
    }


	/**
	 * Handle a the button click
	 * pre: none
	 * post: A message has been displayed.
	 */
    public void actionPerformed(ActionEvent event) {
		String text = name.getText();

		hello.setText("Hello " + text);
    }


    /**
     * Create and show the GUI.
     */
    private static void runGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);

        ChangeColour colorApp = new ChangeColour();
    }


    public static void main(String[] args) {
        /* Methods that create and show a GUI should be
           run from an event-dispatching thread
         */
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                runGUI();
            }
        });
    }
}
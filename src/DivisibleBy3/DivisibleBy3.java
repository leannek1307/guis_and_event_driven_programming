/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DivisibleBy3;

/**
 *
 * @author leannekim
 */

/*
 * SemesterAvg.java from Chapter 10
 * Computes the average of the grades entered by the user.
 * Lawrenceville Press
 * June 10, 2011
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DivisibleBy3 implements ActionListener {
	JFrame frame;
	JPanel contentPane;
	JLabel prompt, message;
	JTextField userInteger;
	JButton checkButton;

    public DivisibleBy3(){
        /* Create and set up the frame */
        frame = new JFrame("Divisible By 3");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Create a content pane with a GridLayout and empty borders */
        contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(0, 2, 10, 5));
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        /* Create and add a prompt and then a text field */
        prompt = new JLabel("Enter an integer: ");
        contentPane.add(prompt);

        userInteger = new JTextField(20);
        contentPane.add(userInteger);

        /* Create and add button "Check" */
        checkButton = new JButton("Check");
        checkButton.setActionCommand("Check");
    	checkButton.addActionListener(this);
    	contentPane.add(checkButton);
        
        /* Create label that will display a message when integer IS divisible by 3 */
        message = new JLabel("");
        contentPane.add(message);
        
        /* Add content pane to frame */
        frame.setContentPane(contentPane);

        /* Size and then display the frame. */
        frame.pack();
        frame.setVisible(true);
    }


    /**
     * Handle button click action event
     * pre: none
     * post: The average of the grades entered has been calculated and displayed.
     */
    public void actionPerformed(ActionEvent event) {
        String eventName = event.getActionCommand();

        if (eventName.equals("Check")) {
        	double avgGrade;
//        	String g1 = grade1.getText();
//        	String g2 = grade2.getText();
//        	String g3 = grade3.getText();
//
//        	avgGrade = (Double.parseDouble(g1) + Double.parseDouble(g2) +
//        				Double.parseDouble(g3))/3;
//        	average.setText(Double.toString(avgGrade));
//            int num;
            String userNum = userInteger.getText();
            if (Integer.parseInt(userNum) % 3 == 0){
                message.setText("Number is divisible by 3.");
            } else {
                message.setText("Number is not divisible by 3.");
            }
        }
    }


    /**
     * Create and show the GUI.
     */
    private static void runGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);

        DivisibleBy3 integer = new DivisibleBy3();
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

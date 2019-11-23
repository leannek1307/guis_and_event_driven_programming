/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetricConversion;

/**
 *
 * @author leannekim
 */
/*
 * LatinPlantNames.java from Chapter 10
 * Displays the latin name for a selected plant.
 * Lawrenceville Press
 * June 10, 2011
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MetricConversion implements ActionListener {
	JFrame frame;
	JPanel contentPane;
	JComboBox conversionTypes;
	JLabel conversionPrompt, conversion;

    public MetricConversion(){
        /* Create and set up the frame */
        frame = new JFrame("Metric Conversion");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Create a content pane with a BoxLayout and empty borders */
        contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        /* Create a combo box and a descriptive label */
        conversionPrompt = new JLabel("Select a conversion type: ");
        conversionPrompt.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        contentPane.add(conversionPrompt);

        String[] conversions = {"inches to centimetres", "feet to metres", "gallons to litres", "pounds to kilograms"};
        conversionTypes = new JComboBox(conversions);
        conversionTypes.setAlignmentX(JComboBox.LEFT_ALIGNMENT);
        conversionTypes.setSelectedIndex(0);
        conversionTypes.addActionListener(this);
        contentPane.add(conversionTypes);

        /* Create and add a label that will display the Latin names */
        conversion = new JLabel("1 inch = 2.54 centimetres");
        conversion.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        contentPane.add(conversion);

        /* Add content pane to frame */
        frame.setContentPane(contentPane);

        /* Size and then display the frame. */
        frame.pack();
        frame.setVisible(true);
    }


	/**
	 * Handle a selection from the combo box
	 * pre: none
	 * post: The Latin name for the selected plant has been displayed.
	 */
    public void actionPerformed(ActionEvent event) {
		JComboBox comboBox = (JComboBox)event.getSource();
		String conversionType = (String)comboBox.getSelectedItem();

		if (conversionType == "inches to centimetres") {
			conversion.setText("1 inch = 2.54 centimetres");
		} else if (conversionType == "feet to metres") {
			conversion.setText("1 foot = 0.3048 metres");
		} else if (conversionType == "gallons to litres") {
			conversion.setText("1 gallon = 4.5461 litres");
		} else if (conversionType == "pounds to kilograms") {
			conversion.setText("1 pound = 0.4536 kilograms");
		} 
    }


    /**
     * Create and show the GUI.
     */
    private static void runGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);

        MetricConversion conversions = new MetricConversion();
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


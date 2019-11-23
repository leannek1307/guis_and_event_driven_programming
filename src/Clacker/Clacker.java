package Clacker;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author leannekim
 */
public class Clacker implements ActionListener{
    // 12 buttons (4 x 3). click to cover them. if covered, display nothing
    // Roll button
    // 2 dice. If any of the 12 buttons are clicked, display nothing
    // New Game button
        // clear dice label, uncover buttons for new game
    
    JFrame frame;
    JPanel contentPane;
    JButton roll, newGame, buttons[];
    JLabel die, die1, die2, message;
    
    public Clacker(){
        /* create and set up frame */
        frame = new JFrame("Clacker Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /* create content pane with a BoxLayout and empty borders */
        contentPane = new JPanel();
        contentPane.setBackground(Color.white);
        contentPane.setLayout(new GridLayout(0,2));
        contentPane.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        
        /* initialize number buttons */
        initNumButtons();
        
        /* create die */
        die = new JLabel();
        die1 = new JLabel();
        die1.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        die2 = new JLabel();
        die2.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        contentPane.add(die1);
        contentPane.add(die2);
        
        /* create two buttons - Roll, New Game */
        roll = new JButton("Roll");
        roll.setActionCommand("Roll");
        roll.addActionListener(this);
        contentPane.add(roll);
        
        newGame = new JButton("New Game");
        newGame.setActionCommand("New Game");
        newGame.addActionListener(this);
        contentPane.add(newGame);
        
        /* add content pane to frame */
        frame.setContentPane(contentPane);
        
        /* size and then display the frame */
        frame.pack();
        frame.setVisible(true);
    }
    
    private void initNumButtons(){
        /* create 12 Jbuttons */
        buttons = new JButton[13];
        for (int i = 1; i < buttons.length; i++){
            String value = Integer.toString(i);
            buttons[i] = new JButton(value);
            buttons[i].setText(value);
            buttons[i].setActionCommand(value);
            buttons[i].addActionListener(this);
            contentPane.add(buttons[i]);
        }
    }
    
    /**
     * roll dice and return value
     * @return 
     */
    private void rollDice(){
        int dieNum;
        dieNum = (int)((12 * Math.random()) + 1);
        
        switch (dieNum) {
            case 1:
                die.setIcon(new ImageIcon("die1.gif"));
                break;
            case 2:
                die.setIcon(new ImageIcon("die2.gif"));
                break;
            case 3:
                die.setIcon(new ImageIcon("die3.gif"));
                break;
            case 4:
                die.setIcon(new ImageIcon("die4.gif"));
                break;
            case 5:
                die.setIcon(new ImageIcon("die5.gif"));
                break;
            case 6:
                die.setIcon(new ImageIcon("die6.gif"));
                break;
            default:
                break;
        }
    }
    
   
    @Override
    public void actionPerformed(ActionEvent event){
        String eventName = event.getActionCommand();
        
        /* if number buttons are clicked, display nothing */
        for (int i = 1; i < buttons.length; i++){
            if (event.getSource() == buttons[i]){
                buttons[i].setText("   ");
            }
        }

        /* roll and display die if Roll button is clicked */
        if ("Roll".equals(eventName)){
            rollDice();
            die = die1;
            rollDice();
            die = die2;
        }
        
        /* restart button is clicked */
        if ("New Game".equals(eventName)){
            for (int i = 1; i < buttons.length; i++){
                String value = Integer.toString(i);
                buttons[i].setText(value);
            }
        }
        
        
    }
    
    /**
     * Create and show GUI
     */
    
    private static void runGUI(){
        JFrame.setDefaultLookAndFeelDecorated(true);
        
        Clacker clackerGame = new Clacker();
    }
    
    public static void main(String[] args){
        /* methods that create and show a GUI should be run from an event-dispatching thread */
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                runGUI();
            }
        });
    }
}

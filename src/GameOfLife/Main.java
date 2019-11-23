/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameOfLife;

/**
 *
 * @author leannekim
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author leannekim
 */

/* GameOfLife GUI. Uses GameOfLife class to play the game, then displays the matching user interface. */

public class Main implements ActionListener {
    
    JFrame frame;
    JPanel contentPane, contentPaneButtons; // JPanel within a JPanel
    JButton buttons[][], next, quit;
    JLabel title, instructions, message;
    GameOfLife gol;
    boolean canClickButton = true; // to make all buttons unclickable if "Quit" is clicked
    int numRounds = 0;      
    int maxNumRounds = 10;   // if player reaches 10 rounds, the game will end
    
    /**
     * constructor
     * pre: none
     * post: frame, contentPane, contentPaneButtons, buttons[][], next, quit, title, message, gol has been initialized.
     */
    public Main(){
        /* initialize GameOfLife */
        gol = new GameOfLife();
        
        /* create and set up frame */
        frame = new JFrame("Game of Life");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /* create content pane with a BoxLayout with empty borders */
        contentPane = new JPanel();
        contentPane.setBackground(Color.white);
        contentPane.setBorder(BorderFactory.createEmptyBorder(20,20,10,10));
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
        
        /* title label of game */
        title = new JLabel("~ Conway's Game of Life ~");
        title.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        title.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        contentPane.add(title);
        
        /* brief instuction of game */
        instructions = new JLabel("Click cell to enliven cell. Max 10 generations.");
        instructions.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        instructions.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        contentPane.add(instructions);
        
        /* create content pane for buttons with a GridLayout and with borders */
        contentPaneButtons = new JPanel();
        contentPaneButtons.setBackground(Color.white);
        contentPaneButtons.setLayout(new GridLayout(20,20));
        contentPaneButtons.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        
        /* create 400 buttons. row 20, column 20 */
        buttons = new JButton[20][20];
        for (int i = 0; i < buttons.length; i++){    // row 
            for (int j = 0; j < buttons[0].length; j++){   // column
                buttons[i][j] = new JButton("O");                
                buttons[i][j].setMargin(new Insets(0, 0, 0, 0)); // set margin of text in Jbutton 0
                buttons[i][j].setBackground(Color.black);        // set colour or button
                buttons[i][j].setForeground(Color.white);        // set colour of button's text
                buttons[i][j].setActionCommand("O");
                buttons[i][j].addActionListener(this);
                contentPaneButtons.add(buttons[i][j]);
            }
        }
        contentPane.add(contentPaneButtons);
        
        /* create next button, center align, set background and foreground colour */
        next = new JButton("Next");
        next.setAlignmentX(JButton.CENTER_ALIGNMENT);
        next.setBackground(Color.yellow);
        next.setForeground(Color.blue);
        next.setActionCommand("Next");
        next.addActionListener(this);
        contentPane.add(next);
        
        /* create quit button, center align, set background and foreground colour */
        quit = new JButton("Quit");
        quit.setAlignmentX(JButton.CENTER_ALIGNMENT);
        quit.setBackground(Color.red);
        quit.setForeground(Color.white);
        quit.setActionCommand("Quit");
        quit.addActionListener(this);
        contentPane.add(quit);
        
        /* create message label */
        message = new JLabel(" ");
        message.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        contentPane.add(message);
        
        /* add content pane to frame */
        frame.setContentPane(contentPane);
        
        /* size and then display the frame */
        frame.pack();
        frame.setVisible(true);
    }      
 
    /**
     * if buttons is clicked, execute code.
     * pre: none
     * post: Code has been executed when a button has been clicked.
     * @param event 
     */
    public void actionPerformed(ActionEvent event){
        String eventName = event.getActionCommand();
        
        /* change button text to "X" and go to coordinate() in GameOfLife to change value of the cell to 1(=alive) */
        if (canClickButton == true){
            if ("O".equals(eventName)){
                for (int i = 0; i < buttons.length; i++){    // row
                    for (int j = 0; j < buttons[0].length; j++){   // column
                        if (event.getSource() == buttons[i][j]){
                            buttons[i][j].setText("X");
                            gol.coordinate(i, j);
                        }
                    }
                }
            }
        }
        
        /* go through array, check if cell is alive or dead, display next generation */
        if (canClickButton == true){
            if ("Next".equals(eventName)){
                if (numRounds <= maxNumRounds){ 
                    gol.nextGen();
                    for (int i = 0; i < buttons.length; i++){    // row
                        for (int j = 0; j < buttons[0].length; j++){   // column
                            if (gol.checkAliveOrDead(i, j) == 1){
                                buttons[i][j].setText("X");     // if alive, X
                            } else if (gol.checkAliveOrDead(i, j) == 0){
                                buttons[i][j].setText("O");     // if dead, O
                            }
                        }
                    }
                    numRounds++;    // increment number of rounds every time
                } else {    // player have reached 10 rounds (maximum)
                    canClickButton = false;
                    message.setText("You have reached the maximum of 10 rounds. ");
                }   
            }
        }
        
        /* go through the array and count the number of live cells, then display message */
        if (canClickButton == true){
            if ("Quit".equals(eventName)){
                int liveCellCounter = 0;
                for (int i = 0; i < buttons.length; i++){    // row
                    for (int j = 0; j < buttons[0].length; j++){   // column
                        if (gol.checkAliveOrDead(i, j) == 1){
                            liveCellCounter++;
                        }
                    }
                }
                canClickButton = false;
                message.setText("You have ended the game with " + liveCellCounter + " live cells.");
            }
        }
    }

    /**
     * Create and show the GUI.
     * pre: none
     * post: GUI has been showed.
     */
    private static void runGUI(){
        JFrame.setDefaultLookAndFeelDecorated(true);
        Main GameOfLife = new Main();
    }
    
    /**
     * Main method
     * @param args 
     */
    public static void main(String[] args){
        /* methods that create and show a GUI should be run from an event-dispatching thread */
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                runGUI();
            }
        });
    }
}


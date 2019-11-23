package BreakAPlate;
/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author leannekim
 */
public class BreakAPlate implements ActionListener{
    static final String FIRST_PRIZE = "tiger plush";
    static final String CONSOLATION_PRIZE = "sticker";
    JFrame frame;
    JPanel contentPane;
    JButton play;
    JLabel plates, prizeWon;
    GameBooth breakAPlate;
    
    public BreakAPlate(){
        /* initialize game booth and player */
        breakAPlate = new GameBooth(0, FIRST_PRIZE, CONSOLATION_PRIZE);
        
        /* create and set up frame */
        frame = new JFrame("Break a plate!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /* create content pane with a BoxLayout and empty borders */
        contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        contentPane.setBackground(Color.white);
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
        
        /* create label that shows the start of the game */
        plates = new JLabel(new ImageIcon("plates.gif"));
        plates.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        plates.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 10));
        contentPane.add(plates);
        
        /* create play button */
        play = new JButton("Play");
        play.setActionCommand("Play");
        play.setAlignmentX(JButton.CENTER_ALIGNMENT);
        play.addActionListener(this);
        contentPane.add(play);
        
        /* create a label that will show prize won */
        prizeWon = new JLabel(new ImageIcon("placeholder.gif"));
        prizeWon.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        prizeWon.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        contentPane.add(prizeWon);
        
        /* add content pane to frame */
        frame.setContentPane(contentPane);
        
        /* size and then display the frame */
        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     * Handle the button click
     * pre: none
     * post: The appropriate image and message are displayed.
     */
    public void actionPerformed(ActionEvent event){
        String eventName = event.getActionCommand();
        String prize;
        
        if (eventName == "Play"){
            prize = breakAPlate.start();
            if (prize.equals(FIRST_PRIZE)){
                plates.setIcon(new ImageIcon("plates_all_broken.gif"));
                prizeWon.setIcon(new ImageIcon("tiger_plush.gif"));
            } else if (prize.equals(CONSOLATION_PRIZE)){
                plates.setIcon(new ImageIcon("plates_two_broken.gif"));
                prizeWon.setIcon(new ImageIcon("sticker.gif"));
            }
            
            play.setText("Play Again");
            play.setActionCommand("Play Again");
        } else if (eventName == "Play Again"){
            plates.setIcon(new ImageIcon("plates.gif"));
            prizeWon.setIcon(new ImageIcon("placeholder.gif"));
            play.setText("Play");
            play.setActionCommand("Play");
        }
    }
    
    /**
     * Create and show GUI
     */
    
    private static void runGUI(){
        JFrame.setDefaultLookAndFeelDecorated(true);
        
        BreakAPlate carnivalGame = new BreakAPlate();
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

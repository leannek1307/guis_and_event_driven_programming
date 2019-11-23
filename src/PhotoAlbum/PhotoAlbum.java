package PhotoAlbum;
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
public class PhotoAlbum implements ActionListener {
    JFrame frame;
    JPanel contentPane;
    JButton next;
    JLabel currentImage;
    int counter = 0;
    
    public PhotoAlbum(){
        /* create and set up frame */
        frame = new JFrame("Photo Album");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /* create content pane with a BoxLayout and empty borders */
        contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        contentPane.setBackground(Color.white);
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
        
        /* create image labels */
        currentImage = new JLabel(new ImageIcon("grayangel.jpg"));
        currentImage.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        contentPane.add(currentImage);
        
        /* create "next" button */
        next = new JButton("Next");
        next.setActionCommand("Next");
        next.setAlignmentX(JButton.CENTER_ALIGNMENT);
        next.addActionListener(this);
        contentPane.add(next);
        
        /* add content pane to frame */
        frame.setContentPane(contentPane);
        
        /* size and then display the frame */
        frame.pack();
        frame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent event){
        String eventName = event.getActionCommand();
        
        if ("Next".equals(eventName) && counter == 0){
            currentImage.setIcon(new ImageIcon("scorpionfish.jpg"));
            counter+=1;
        } else if ("Next".equals(eventName) && counter == 1){
            currentImage.setIcon(new ImageIcon("sponges.jpg"));
            counter+=1;
        } else if ("Next".equals(eventName) && counter == 2){
            currentImage.setIcon(new ImageIcon("starfish.jpg"));
            counter+=1;
        } else if ("Next".equals(eventName) && counter == 3){
            currentImage.setIcon(new ImageIcon("grayangel.jpg"));;
            counter = 0;
        }
    }
    
    /**
     * Create and show GUI
     */
    
    private static void runGUI(){
        JFrame.setDefaultLookAndFeelDecorated(true);
        
        PhotoAlbum photoAlbum = new PhotoAlbum();
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

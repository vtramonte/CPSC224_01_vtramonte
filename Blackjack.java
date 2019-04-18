/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

package blackjack;

/**
 *
 * @author vince
 */
public class Blackjack extends JFrame
{
    private JPanel dealerPanel;
    private JPanel youPanel;
    
    private JLabel dealerLabel;
    private JLabel youLabel;

    Blackjack()
    {
        setTitle("Motion Parallax");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,750);
        setResizable(false);
        
        buildDealerPanel();
        buildPlayerPanel();
        
        
        
        
        
        
        
        
        // Display the window
        setVisible(true);
        
        
    }
    
    private void buildDealerPanel()
    {
        // create new panel
        dealerPanel = new JPanel();
        
        // labels
        dealerLabel = new JLabel("Dealer: ");
        
        // add labels to panel
        dealerPanel.add(dealerLabel);
        
        // add panel to frame
	add(dealerPanel, BorderLayout.NORTH);	
    }
    
    private void buildPlayerPanel()
    {
        // create new panel
        youPanel = new JPanel();
        
        // labels
        youLabel = new JLabel("You: ");
        
        // add labels to panel
        youPanel.add(youLabel);
        
        // add panel to frame
	add(youPanel, BorderLayout.SOUTH);	
    }
    
    public void paint(Graphics g)
    {
        super.paint(g);
        
        g.drawLine(0, 375, 1000, 375);      // draw split screen
        
    }
    
    public static void main(String[] args) 
    {
        new Blackjack();
    }
    
}

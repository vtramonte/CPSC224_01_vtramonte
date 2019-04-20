/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;

package blackjack;

/**
 *
 * @author vince
 */
public class Blackjack extends JFrame
{
    // player and dealer cards
    private int pCard1;
    private int pCard2;
    private int dCard1;
    private int dCard2;
    private int pTotal;
    private int dTotal;
    private int drawnCard[];
    private int drawCount = 0;
    
    // panels
    private JPanel dealerPanel;
    private JPanel youPanel;
    
    // labels
    private JLabel dealerLabel;
    private JLabel youLabel;
    private JLabel pc1Label;
    private JLabel pc2Label;
    private JLabel dc1Label;
    private JLabel dc2Label;
    private JLabel[] playerDrawLabel;
    
    // buttons
    private JButton hitButton;
    private JButton stayButton;
    private JButton doubleButton;
    private JButton splitButton;
    
    
    
    
    

    // constructor
    Blackjack()
    {
        setTitle("Motion Parallax");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,750);
        setResizable(false);
        
        buildDealerPanel();
        buildPlayerPanel();
        
        
        dealCards();
        
        
        
        
        
        
        
        
        
        // Display the window
        setVisible(true);
        
        
    }
    
    public void dealCards()
    {
        Random rand = new Random();
        pCard1 = rand.nextInt(13)+1;
        dCard1 = rand.nextInt(13)+1;
        pCard2 = rand.nextInt(13)+1;
        dCard2 = rand.nextInt(13)+1;
        
        // create player's first card label
        if (pCard1 == 11)
            pc1Label.setText("J");
        else if (pCard1 == 12)
            pc1Label.setText("Q");
        else if (pCard1 == 13)
            pc1Label.setText("K");
        else if (pCard1 == 1)
            pc1Label.setText("A");
        else
            pc1Label.setText("" + pCard1);
        
        // create dealer's first card label
        if (dCard1 == 11)
            dc1Label.setText("J");
        else if (dCard1 == 12)
            dc1Label.setText("Q");
        else if (dCard1 == 13)
            dc1Label.setText("K");
        else if (dCard1 == 1)
            dc1Label.setText("A");
        else
            dc1Label.setText("" + dCard1);
        
        // create player's second card label
        if (pCard2 == 11)
            pc2Label.setText("J");
        else if (pCard2 == 12)
            pc2Label.setText("Q");
        else if (pCard2 == 13)
            pc2Label.setText("K");
        else if (pCard2 == 1)
            pc2Label.setText("A");
        else
            pc2Label.setText("" + pCard2);
        
        // create dealer's second card label
        if (dCard2 == 11)
            dc2Label.setText("J");
        else if (dCard2 == 12)
            dc2Label.setText("Q");
        else if (dCard2 == 13)
            dc2Label.setText("K");
        else if (dCard2 == 1)
            dc2Label.setText("A");
        else
            dc2Label.setText("" + dCard2);
        
    }
    
    public void drawPlayerCard()
    {
        Random rand = new Random();
        drawnCard[drawCount] = rand.nextInt(13)+1;
        
         // create player's first card label
        if (drawnCard[drawCount] == 11)
            pc1Label.setText("J");
        else if (drawnCard[drawCount] == 12)
            pc1Label.setText("Q");
        else if (drawnCard[drawCount] == 13)
            pc1Label.setText("K");
        else if (drawnCard[drawCount] == 1)
            pc1Label.setText("A");
        else
            pc1Label.setText("" + pCard1);
        
        drawCount++;
        
        
        
    }
    
    public void calcTotals()
    {
        pTotal = pCard1 + pCard2;
        dTotal = dCard1 + dCard2;
    }
    
//*** PANEL CREATION ***********************************************************
    
    private void buildDealerPanel()
    {
        // create new panel
        dealerPanel = new JPanel();
        
        // labels
        dealerLabel = new JLabel("Dealer: ");
        dc1Label = new JLabel(" 0");
        dc2Label = new JLabel(" 0");
        
        
        // add labels to panel
        dealerPanel.add(dealerLabel);
        dealerPanel.add(dc1Label);
        dealerPanel.add(dc2Label);
        
        // add panel to frame
	add(dealerPanel, BorderLayout.NORTH);	
    }
    
    private void buildPlayerPanel()
    {
        // create new panel
        youPanel = new JPanel();
        
        // labels
        youLabel = new JLabel("You: ");
        pc1Label = new JLabel(" 0");
        pc2Label = new JLabel(" 0");
        
        
        // add labels to panel
        youPanel.add(youLabel);
        youPanel.add(pc1Label);
        youPanel.add(pc2Label);
        
                
        // add panel to frame
	add(youPanel, BorderLayout.SOUTH);	
    }
    
    private void buildButtonsPanel()
    {
        
    }
    
//** Button Creation **********************************************************
    private void buildButtons()
    {
        hitButton = new JButton("Hit");
        stayButton = new JButton("Stay");
        doubleButton = new JButton("Double");
        splitButton = new JButton("Split");
        
        hitButton.addActionListener(new ButtonListener());
        stayButton.addActionListener(new ButtonListener());
        doubleButton.addActionListener(new ButtonListener());
        splitButton.addActionListener(new ButtonListener());
            
    }
    
    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String actionCommand = e.getActionCommand();
            switch (actionCommand) 
            {
                    case "Hit":
                        drawPlayerCard();
                        
                        
                        
            }
                        


        }
    }
    
//** PAINTING *****************************************************************
    public void paint(Graphics g)
    {
        super.paint(g);
        
        g.drawLine(0, 375, 1000, 375);      // draw split screen
        
    }
 
//** MAIN *********************************************************************
    public static void main(String[] args) 
    {
        new Blackjack();
    }
    
}


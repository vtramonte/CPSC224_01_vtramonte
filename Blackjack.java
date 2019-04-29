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
    private int pDrawnCard[];
    private int dDrawnCard[];
    private int dDrawnCards = 0;
    private int pDrawnCards = 0;
    private int drawCount = 0;
    private boolean playerWins = false;
    private boolean dealerWins = false;
    
    // panels
    private JPanel dealerPanel;
    private JPanel youPanel;
    private JPanel playerButtonPanel;
    
    // labels
    private JLabel dealerLabel;
    private JLabel youLabel;
    private JLabel pc1Label;
    private JLabel pc2Label;
    private JLabel dc1Label;
    private JLabel dc2Label;
    private JLabel playerDrawLabel0;
    private JLabel playerDrawLabel1;
    private JLabel playerDrawLabel2;
    private JLabel playerDrawLabel3;
    private JLabel playerDrawLabel4;
    private JLabel playerDrawLabel5;
    private JLabel playerDrawLabel6;
    private JLabel playerDrawLabel7;
    private JLabel playerDrawLabel8; // worst case: 9 draws
    private JLabel dealerDrawLabel0;
    private JLabel dealerDrawLabel8;
    private JLabel dealerDrawLabel1;
    private JLabel dealerDrawLabel2;
    private JLabel dealerDrawLabel3;
    private JLabel dealerDrawLabel4;
    private JLabel dealerDrawLabel5;
    private JLabel dealerDrawLabel6;
    private JLabel dealerDrawLabel7; // worst case: 9 draws
    
    
    // buttons
    private JButton hitButton;
    private JButton stayButton;
    private JButton doubleButton;
    private JButton splitButton;
    
    
    
    
    

    // constructor
    Blackjack()
    {
        setTitle("Blackjack Attack!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,750);
        setResizable(false);
        
        buildDealerPanel();
        buildPlayerPanel();
        buildButtonsPanel();
        
        // add panel to frame
	add(dealerPanel, BorderLayout.CENTER);
        add(playerButtonPanel, BorderLayout.EAST);
	add(youPanel, BorderLayout.SOUTH);	
	
        
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
        
        if (pCard1 != 1 && pCard1 > 10)
            pCard1 = 10;
        
        if (pCard2 != 1 && pCard2 > 10)
            pCard2 = 10;
        
        if (dCard1 != 1 && dCard1 > 10)
            dCard1 = 10;
        
        if (dCard2 != 1 && dCard2 > 10)
            dCard2 = 10;
        
        
    }
    
    public void drawPlayerCard()        // hit
    {
        Random rand = new Random();
        int drawnCard = rand.nextInt(13)+1;
        
        // create player's first card label
        if (drawCount == 0)
        {
            if (drawnCard == 11)
                playerDrawLabel0.setText("J");
            else if (drawnCard == 12)
                playerDrawLabel0.setText("Q");
            else if (drawnCard == 13)
                playerDrawLabel0.setText("K");
            else if (drawnCard == 1)
                playerDrawLabel0.setText("A");
            else
                playerDrawLabel0.setText("" + drawnCard);
        }
        
        // create player's second card label
        if (drawCount == 1)
        {
            if (drawnCard == 11)
                playerDrawLabel1.setText("J");
            else if (drawnCard == 12)
                playerDrawLabel1.setText("Q");
            else if (drawnCard == 13)
                playerDrawLabel1.setText("K");
            else if (drawnCard == 1)
                playerDrawLabel1.setText("A");
            else
                playerDrawLabel1.setText("" + drawnCard);
        }
        
        // create player's third card label
        if (drawCount == 2)
        {
            if (drawnCard == 11)
                playerDrawLabel2.setText("J");
            else if (drawnCard == 12)
                playerDrawLabel2.setText("Q");
            else if (drawnCard == 13)
                playerDrawLabel2.setText("K");
            else if (drawnCard == 1)
                playerDrawLabel2.setText("A");
            else
                playerDrawLabel2.setText("" + drawnCard);
        }
        
        // create player's fourth card label
        if (drawCount == 3)
        {
            if (drawnCard == 11)
                playerDrawLabel3.setText("J");
            else if (drawnCard == 12)
                playerDrawLabel3.setText("Q");
            else if (drawnCard == 13)
                playerDrawLabel3.setText("K");
            else if (drawnCard == 1)
                playerDrawLabel3.setText("A");
            else
                playerDrawLabel3.setText("" + drawnCard);
        }
        
        // create player's fifth card label
        if (drawCount == 4)
        {
             if (drawnCard == 11)
                playerDrawLabel4.setText("J");
            else if (drawnCard == 12)
                playerDrawLabel4.setText("Q");
            else if (drawnCard == 13)
                playerDrawLabel4.setText("K");
            else if (drawnCard == 1)
                playerDrawLabel4.setText("A");
            else
                playerDrawLabel4.setText("" + drawnCard);
        }
        
        // create player's sixth card label
        if (drawCount == 5)
        {
             if (drawnCard == 11)
                playerDrawLabel5.setText("J");
            else if (drawnCard == 12)
                playerDrawLabel5.setText("Q");
            else if (drawnCard == 13)
                playerDrawLabel5.setText("K");
            else if (drawnCard == 1)
                playerDrawLabel5.setText("A");
            else
                playerDrawLabel5.setText("" + drawnCard);
        }
        
        // create player's seventh card label
        if (drawCount == 6)
        {
             if (drawnCard == 11)
                playerDrawLabel6.setText("J");
            else if (drawnCard == 12)
                playerDrawLabel6.setText("Q");
            else if (drawnCard == 13)
                playerDrawLabel6.setText("K");
            else if (drawnCard == 1)
                playerDrawLabel6.setText("A");
            else
                playerDrawLabel6.setText("" + drawnCard);
        }
        
        // create player's eighth card label
        if (drawCount == 7)
        {
             if (drawnCard == 11)
                playerDrawLabel7.setText("J");
            else if (drawnCard == 12)
                playerDrawLabel7.setText("Q");
            else if (drawnCard == 13)
                playerDrawLabel7.setText("K");
            else if (drawnCard == 1)
                playerDrawLabel7.setText("A");
            else
                playerDrawLabel7.setText("" + drawnCard);
        }
        
        // create player's ninth card label
        if (drawCount == 8)
        {
             if (drawnCard == 11)
                playerDrawLabel8.setText("J");
            else if (drawnCard == 12)
                playerDrawLabel8.setText("Q");
            else if (drawnCard == 13)
                playerDrawLabel8.setText("K");
            else if (drawnCard == 1)
                playerDrawLabel8.setText("A");
            else
                playerDrawLabel8.setText("" + drawnCard);
        }
       
        if (drawnCard != 1 && drawnCard > 10)
            drawnCard = 10;
        
        pDrawnCards = pDrawnCards + drawnCard;
        calcTotals();
        if (pTotal > 21)
        {
            dealerWins = true;
            System.out.println("Dealer wins. Player busted.");
            compareHands();
        }
        drawCount++;
        
        
    }
    
    public void drawDealerCard()        // hit
    {
        Random rand = new Random();
        int drawnCard = rand.nextInt(13)+1;
        
        // create player's first card label
        if (drawCount == 0)
        {
            if (drawnCard == 11)
                dealerDrawLabel0.setText("J");
            else if (drawnCard == 12)
                dealerDrawLabel0.setText("Q");
            else if (drawnCard == 13)
                dealerDrawLabel0.setText("K");
            else if (drawnCard == 1)
                dealerDrawLabel0.setText("A");
            else
                dealerDrawLabel0.setText("" + drawnCard);
        }
        
        // create player's second card label
        if (drawCount == 1)
        {
            if (drawnCard == 11)
                dealerDrawLabel1.setText("J");
            else if (drawnCard == 12)
                dealerDrawLabel1.setText("Q");
            else if (drawnCard == 13)
                dealerDrawLabel1.setText("K");
            else if (drawnCard == 1)
                dealerDrawLabel1.setText("A");
            else
                dealerDrawLabel1.setText("" + drawnCard);
        }
        
        // create player's third card label
        if (drawCount == 2)
        {
            if (drawnCard == 11)
                dealerDrawLabel2.setText("J");
            else if (drawnCard == 12)
                dealerDrawLabel2.setText("Q");
            else if (drawnCard == 13)
                dealerDrawLabel2.setText("K");
            else if (drawnCard == 1)
                dealerDrawLabel2.setText("A");
            else
                dealerDrawLabel2.setText("" + drawnCard);
        }
        
        // create player's fourth card label
        if (drawCount == 3)
        {
            if (drawnCard == 11)
                dealerDrawLabel3.setText("J");
            else if (drawnCard == 12)
                dealerDrawLabel3.setText("Q");
            else if (drawnCard == 13)
                dealerDrawLabel3.setText("K");
            else if (drawnCard == 1)
                dealerDrawLabel3.setText("A");
            else
                dealerDrawLabel3.setText("" + drawnCard);
        }
        
        // create player's fifth card label
        if (drawCount == 4)
        {
            if (drawnCard == 11)
                dealerDrawLabel4.setText("J");
            else if (drawnCard == 12)
                dealerDrawLabel4.setText("Q");
            else if (drawnCard == 13)
                dealerDrawLabel4.setText("K");
            else if (drawnCard == 1)
                dealerDrawLabel4.setText("A");
            else
                dealerDrawLabel4.setText("" + drawnCard);
        }
        
        // create player's sixth card label
        if (drawCount == 5)
        {
            if (drawnCard == 11)
                dealerDrawLabel5.setText("J");
            else if (drawnCard == 12)
                dealerDrawLabel5.setText("Q");
            else if (drawnCard == 13)
                dealerDrawLabel5.setText("K");
            else if (drawnCard == 1)
                dealerDrawLabel5.setText("A");
            else
                dealerDrawLabel5.setText("" + drawnCard);
        }
        
        // create player's seventh card label
        if (drawCount == 6)
        {
            if (drawnCard == 11)
                dealerDrawLabel6.setText("J");
            else if (drawnCard == 12)
                dealerDrawLabel6.setText("Q");
            else if (drawnCard == 13)
                dealerDrawLabel6.setText("K");
            else if (drawnCard == 1)
                dealerDrawLabel6.setText("A");
            else
                dealerDrawLabel6.setText("" + drawnCard);
        }
        
        // create player's eighth card label
        if (drawCount == 7)
        {
            if (drawnCard == 11)
                dealerDrawLabel7.setText("J");
            else if (drawnCard == 12)
                dealerDrawLabel7.setText("Q");
            else if (drawnCard == 13)
                dealerDrawLabel7.setText("K");
            else if (drawnCard == 1)
                dealerDrawLabel7.setText("A");
            else
                dealerDrawLabel7.setText("" + drawnCard);
        }
        
        // create player's ninth card label
        if (drawCount == 8)
        {
            if (drawnCard == 11)
                dealerDrawLabel8.setText("J");
            else if (drawnCard == 12)
                dealerDrawLabel8.setText("Q");
            else if (drawnCard == 13)
                dealerDrawLabel8.setText("K");
            else if (drawnCard == 1)
                dealerDrawLabel8.setText("A");
            else
                dealerDrawLabel8.setText("" + drawnCard);
        }
       
        if (drawnCard != 1 && drawnCard > 10)
            drawnCard = 10;
        
        dDrawnCards = dDrawnCards + drawnCard;
        drawCount++;
    }
    
    public void dealersTurn()
    {
        calcTotals();
        while (dTotal < 17)
        {
            drawDealerCard();
            calcTotals();
            if (dTotal > 21)
                playerWins = true;
        }
        
        if (dTotal == 21)
            System.out.println("Dealer Wins");
            
        else 
            compareHands();
        
    }
    
    public void calcTotals()
    {
        pTotal = pCard1 + pCard2 + pDrawnCards;
        dTotal = dCard1 + dCard2 + dDrawnCards;
        System.out.println("ptotal: " + pTotal + " dTotal: " + dTotal);
    }
    
    public void compareHands()
    {
        if (dealerWins)
        {
            // player busted. This is already accounted for
        }
        else if (playerWins)
            System.out.println("Player wins. Dealer busted");
        else if (pTotal > dTotal)
            System.out.println("Player wins. Dealer pays player.");
        else if (dTotal > pTotal)
            System.out.println("Dealer wins. Dealer takes bet.");
        else
            System.out.println("Push.");
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
        dealerDrawLabel0 = new JLabel();
        dealerDrawLabel1 = new JLabel();
        dealerDrawLabel2 = new JLabel();
        dealerDrawLabel3 = new JLabel();
        dealerDrawLabel4 = new JLabel();
        dealerDrawLabel5 = new JLabel();
        dealerDrawLabel6 = new JLabel();
        dealerDrawLabel7 = new JLabel();
        dealerDrawLabel8 = new JLabel();
        
        
        // add labels to panel
        dealerPanel.add(dealerLabel);
        dealerPanel.add(dc1Label);
        dealerPanel.add(dc2Label);
        dealerPanel.add(dealerDrawLabel0);
        dealerPanel.add(dealerDrawLabel1);
        dealerPanel.add(dealerDrawLabel2);
        dealerPanel.add(dealerDrawLabel3);
        dealerPanel.add(dealerDrawLabel4);
        dealerPanel.add(dealerDrawLabel5);
        dealerPanel.add(dealerDrawLabel6);
        dealerPanel.add(dealerDrawLabel7);
        dealerPanel.add(dealerDrawLabel8);
    
        
        	
    }
    
    private void buildPlayerPanel()
    {
        // create new panel
        youPanel = new JPanel();
        
        // labels
        youLabel = new JLabel("You: ");
        pc1Label = new JLabel(" 0");
        pc2Label = new JLabel(" 0");
        playerDrawLabel1 = new JLabel();
        playerDrawLabel2 = new JLabel();
        playerDrawLabel3 = new JLabel();
        playerDrawLabel4 = new JLabel();
        playerDrawLabel5 = new JLabel();
        playerDrawLabel6 = new JLabel();
        playerDrawLabel7 = new JLabel();
        playerDrawLabel8 = new JLabel();
        playerDrawLabel0 = new JLabel();
        
        // add labels to panel
        youPanel.add(youLabel);
        youPanel.add(pc1Label);
        youPanel.add(pc2Label);
        youPanel.add(playerDrawLabel0);
        youPanel.add(playerDrawLabel1);
        youPanel.add(playerDrawLabel2);
        youPanel.add(playerDrawLabel3);
        youPanel.add(playerDrawLabel4);
        youPanel.add(playerDrawLabel5);
        youPanel.add(playerDrawLabel6);
        youPanel.add(playerDrawLabel7);
        youPanel.add(playerDrawLabel8);
        
        
                
        
    }
    
    private void buildButtonsPanel()
    {
        // create new panel
        playerButtonPanel = new JPanel();
        playerButtonPanel.setLayout(new BoxLayout(playerButtonPanel, BoxLayout.PAGE_AXIS));
        
        buildButtons();
        
        playerButtonPanel.add(hitButton);
        playerButtonPanel.add(stayButton);
        playerButtonPanel.add(doubleButton);
        playerButtonPanel.add(splitButton);
        
        	
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
                        break;
                                          
                    case "Stay":
                        drawCount = 0;
                        dealersTurn();
                        
                        
                    case "Double":
                        
                    case "Split":
                        
                                     
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


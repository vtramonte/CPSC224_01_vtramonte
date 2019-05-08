/*Vincent Tramonte, Vincent Rettke
 * Final Project
 * 5/8/19
 * Creates a BlakcJack GUI for users to play on  
 * */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;


public class Blackjack extends JFrame
{
    // player and dealer cards
    private int pCard1;
    private int pCard2;
    private int dCard1;
    private int dCard2;
    private int pTotal;
    private int dTotal;
    //private int pDrawnCard[];
    //private int dDrawnCard[];
    private int dDrawnCards = 0;
    private int pDrawnCards = 0;
    private int drawCount = 0;
    private int compareHands = 1; 
    public int userChoice; 

    int [] playerPaintCard = new int[11];
    int [] dealerPaintCard = new int[11]; 
    private int pCardLoc = 400;
    private int dCardLoc = 550;
    private boolean playerWins = false;
    private boolean dealerWins = false;
    private static boolean playAgain = true;
    
    // panels
    private JPanel dealerPanel;
    private JPanel youPanel;
    private JPanel playerButtonPanel;
    private JPanel playerCardsPanel;
    
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
       
    // buttons
    private JButton hitButton;
    private JButton stayButton;
    private JButton doubleButton;
    private JButton splitButton;
    
    // image icons
    ImageIcon ace = new ImageIcon("AS.png");
    ImageIcon two = new ImageIcon("2H.png");
    ImageIcon three = new ImageIcon("3C2.png");
    ImageIcon four = new ImageIcon("4H.png");
    ImageIcon five = new ImageIcon("5D.png");
    ImageIcon six = new ImageIcon("6C.png");
    ImageIcon seven = new ImageIcon("7D.png");
    ImageIcon eight = new ImageIcon("8S.png");
    ImageIcon nine = new ImageIcon("9C.png");
    ImageIcon ten = new ImageIcon("10D.png");
    ImageIcon jack = new ImageIcon("JC.png");
    ImageIcon queen = new ImageIcon("QH.png");
    ImageIcon king = new ImageIcon("KD.png");
    ImageIcon deck = new ImageIcon("blue_back-1.png");

    

    // constructor
    Blackjack()
    {
        setTitle("Blackjack Attack!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,750);
        setResizable(false);
        
        
        //buildPlayerCardPanel();
        buildDealerPanel();
        buildPlayerPanel();
        buildButtonsPanel();
        
        // add panel to frame
	    add(dealerPanel, BorderLayout.NORTH);
        add(playerButtonPanel, BorderLayout.EAST);
	    add(youPanel, BorderLayout.SOUTH);	
	    //add(playerCardsPanel, BorderLayout.CENTER);
	
	    //make the panels green
        dealerPanel.setBackground(new Color(0, 122, 0));
        youPanel.setBackground(new Color(0, 122, 0));
        playerButtonPanel.setBackground(new Color(0, 122, 0));
        getContentPane().setBackground(new Color(0, 122, 0));
      
        dealCards();
        //userChoice = menu();
        
            
        //pack();    
        
        // Display the window
        setVisible(true);
        
        
    }
    
    public void dealCards()
    {
        Random rand = new Random();
        pCard1 = rand.nextInt(13)+1;
        playerPaintCard[0] = pCard1;
        
        dCard1 = rand.nextInt(13)+1;
        //dealerPaintCard[0] = 0;
        dealerPaintCard[0] = 15; 
        		//dCard1;
        
        pCard2 = rand.nextInt(13)+1;
        playerPaintCard[1] = pCard2;
        
        dCard2 = rand.nextInt(13)+1;
        dealerPaintCard[1] = dCard2;
        
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

        
    }
    
    public void drawPlayerCard()        // hit
    {
        Random rand = new Random();
        int drawnCard = rand.nextInt(13)+1;
        //paintCard = drawnCard;  // for painting the drawn player card
        
        //repaint();
        
        // create player's first card label
        if (drawCount == 0)
        {
        	playerPaintCard[2] = drawnCard;        	
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
        	playerPaintCard[3] = drawnCard;        	
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
        	playerPaintCard[4] = drawnCard;
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
        	playerPaintCard[5] = drawnCard;
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
        	playerPaintCard[6] = drawnCard;
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
        	playerPaintCard[7] = drawnCard;
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
        	playerPaintCard[8] = drawnCard;
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
        	playerPaintCard[9] = drawnCard;
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
        	playerPaintCard[10] = drawnCard;
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
        
        repaint();
       
        if (drawnCard != 1 && drawnCard > 10)
            drawnCard = 10;
        
        pDrawnCards = pDrawnCards + drawnCard;
        calcTotals();
        if (pTotal > 21)
        {
            dealerWins = true;
            JOptionPane.showMessageDialog(null,"Dealer wins. Player busted.");
            compareHands = compareHands();
        }
        drawCount++;
         
        
    }
    
    public void drawDealerCard()        // hit
    {
        Random rand = new Random();
        int drawnCard = rand.nextInt(13)+1;
        
        // create dealer's first card label
        if (drawCount == 0)
        {
            dealerPaintCard[2] = drawnCard;

        }
        
        // create dealer's second card label
        if (drawCount == 1)
        {
            dealerPaintCard[3] = drawnCard;

        }
        
        // create dealer's third card label
        if (drawCount == 2)
        {
            dealerPaintCard[4] = drawnCard;

        }
        
        // create dealer's fourth card label
        if (drawCount == 3)
        {
            dealerPaintCard[5] = drawnCard;
            
        }
        
        // create dealer's fifth card label
        if (drawCount == 4)
        {
            dealerPaintCard[6] = drawnCard;
            
        }
        
        // create dealer's sixth card label
        if (drawCount == 5)
        {
            dealerPaintCard[7] = drawnCard;     
        }
        
        // create dealer's seventh card label
        if (drawCount == 6)
        {
            dealerPaintCard[8] = drawnCard;
           
        }
        
        // create dealer's eighth card label
        if (drawCount == 7)
        {
            dealerPaintCard[9] = drawnCard;
           
        }
        
        // create dealer's ninth card label
        if (drawCount == 8)
        {
            dealerPaintCard[10] = drawnCard;
        }
        repaint();         
       
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
        
        if (dTotal == 21) {
        	JOptionPane.showMessageDialog(null,"Dealer Wins");
            userChoice = menu(); 
    		if(userChoice == 1) {
    			new Blackjack();
    			repaint(); 
    		}
    		else if(userChoice == 2) {
                JOptionPane.showMessageDialog(null, "GoodBye!");
                //break;
                System.exit(0);
    		}
    		else {
    			JOptionPane.showMessageDialog(null, "Please enter a valid option!");
    		} 	
        }
            
        else {
            compareHands = compareHands();
        }
        
    }
    
    public void calcTotals()
    {
        pTotal = pCard1 + pCard2 + pDrawnCards;
        dTotal = dCard1 + dCard2 + dDrawnCards;
        System.out.println("ptotal: " + pTotal + " dTotal: " + dTotal);
    }
    
    public int compareHands()
    {
    	int outcome = 1; 
        if (dealerWins)
        {
            // player busted. This is already accounted for
        }
        else if (playerWins) {
            JOptionPane.showMessageDialog(null, "Player wins. Dealer busted");
        	outcome = 2;
        }
        else if (pTotal > dTotal) {
            JOptionPane.showMessageDialog(null, "Player wins. Dealer pays player.");
            outcome = 2;
        }
        else if (dTotal > pTotal) {
            JOptionPane.showMessageDialog(null, "Dealer wins. Dealer takes bet.");
            outcome = 1; 
        }
        else {
            JOptionPane.showMessageDialog(null, "Push.");
            outcome = 3; 
        }
        
        userChoice = menu(); 
		if(userChoice == 1) {
			new Blackjack();
			repaint(); 
		}
		else if(userChoice == 2) {
            JOptionPane.showMessageDialog(null, "GoodBye!");
            //break;
            System.exit(0);
		}
		else {
			JOptionPane.showMessageDialog(null, "Please enter a valid option!");
		}       
        
        
        return outcome;  
    }
    
//*** PANEL CREATION ***********************************************************
    private void buildPlayerCardPanel()
    {
    	/*
        playerCardsPanel = new JPanel();
        
        threeL = new JLabel();
        three = new ImageIcon("3C.png");
        Image image3 = three.getImage(); // transform it 
        Image newimg3 = image3.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        three = new ImageIcon(newimg3);  // transform it back
        
        threeL.setIcon(three);
        playerCardsPanel.add(threeL);
        
        pack();
        */
        
    }
    private void buildDealerPanel()
    {
        // create new panel
        dealerPanel = new JPanel();
        
        // labels
        dealerLabel = new JLabel("Dealer: ");
        
        
        
        // add labels to panel
        dealerPanel.add(dealerLabel);
       
    
        
        	
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
        youPanel.add(youLabel, BorderLayout.SOUTH);
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
        
        //youPanel.add(playerCardsPanel);
        
        
              
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
                    	dealerPaintCard[0] = dCard1;
			repaint();
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
        
        g.setColor(Color.blue);
        g.drawRect(0, 0, 1000, 750);
        g.setColor(Color.black);
        g.drawLine(0, 375, 1000, 375);      // draw split screen
        pCardLoc = 400;
        dCardLoc = 550; 
        
        //draw card face down to simulate the deck
        deck.paintIcon(this, g, 275, 100);

        //loops through player card array and paints cards accordingly 
        for(int i = 0; i < playerPaintCard.length; i++) {
        	if(playerPaintCard[i] == 1) {
            	ace.paintIcon(this, g, pCardLoc, 400);
                pCardLoc += 25;      	
        	}
        	else if(playerPaintCard[i] == 2) {
            	two.paintIcon(this, g, pCardLoc, 400);
                pCardLoc += 25;      	
        	}
        	else if(playerPaintCard[i] == 3) {
            	three.paintIcon(this, g, pCardLoc, 400);
                pCardLoc += 25;      	
        	}
        	else if(playerPaintCard[i] == 4) {
            	four.paintIcon(this, g, pCardLoc, 400);
                pCardLoc += 25;      	
        	}        	
        	else if(playerPaintCard[i] == 5) {
            	five.paintIcon(this, g, pCardLoc, 400);
                pCardLoc += 25;      	
        	}
        	else if(playerPaintCard[i] == 6) {
            	six.paintIcon(this, g, pCardLoc, 400);
                pCardLoc += 25; 
        	}  
        	else if(playerPaintCard[i] == 7) {
            	seven.paintIcon(this, g, pCardLoc, 400);
                pCardLoc += 25;      	
        	}
        	else if(playerPaintCard[i] == 8) {
            	eight.paintIcon(this, g, pCardLoc, 400);
                pCardLoc += 25;      	
        	}        	
        	else if(playerPaintCard[i] == 9) {
            	nine.paintIcon(this, g, pCardLoc, 400);
                pCardLoc += 25;      	
        	}        	
        	else if(playerPaintCard[i] == 10) {
            	ten.paintIcon(this, g, pCardLoc, 400);
                pCardLoc += 25;      	
        	}
        	else if(playerPaintCard[i] == 11) {
            	jack.paintIcon(this, g, pCardLoc, 400);
                pCardLoc += 25;      	
        	}        	
        	else if(playerPaintCard[i] == 12) {
            	queen.paintIcon(this, g, pCardLoc, 400);
                pCardLoc += 25;      	
        	}
        	else if(playerPaintCard[i] == 13) {
            	king.paintIcon(this, g, pCardLoc, 400);
                pCardLoc += 25;      	
        	}        	
        } 
        
        
       
        //loops through dealer card array and paints cards accordingly 
        for(int i = 0; i < dealerPaintCard.length; i++) {
        	if(dealerPaintCard[i] == 15) {
            	deck.paintIcon(this, g, dCardLoc, 100);
                dCardLoc += 25;      	
        	}
        	else if(dealerPaintCard[i] == 1) {
            	ace.paintIcon(this, g, dCardLoc, 100);
                dCardLoc += 25;      	
        	}        	
        	else if(dealerPaintCard[i] == 2) {
            	two.paintIcon(this, g, dCardLoc, 100);
                dCardLoc += 25;      	
        	}
        	else if(dealerPaintCard[i] == 3) {
            	three.paintIcon(this, g, dCardLoc, 100);
                dCardLoc += 25;      	
        	}
        	else if(dealerPaintCard[i] == 4) {
            	four.paintIcon(this, g, dCardLoc, 100);
                dCardLoc += 25;      	
        	}        	
        	else if(dealerPaintCard[i] == 5) {
            	five.paintIcon(this, g, dCardLoc, 100);
                dCardLoc += 25;      	
        	}
        	else if(dealerPaintCard[i] == 6) {
            	six.paintIcon(this, g, dCardLoc, 100);
                dCardLoc += 25; 
        	}  
        	else if(dealerPaintCard[i] == 7) {
            	seven.paintIcon(this, g, dCardLoc, 100);
                dCardLoc += 25;      	
        	}
        	else if(dealerPaintCard[i] == 8) {
            	eight.paintIcon(this, g, dCardLoc, 100);
                dCardLoc += 25;      	
        	}        	
        	else if(dealerPaintCard[i] == 9) {
            	nine.paintIcon(this, g, dCardLoc, 100);
                dCardLoc += 25;      	
        	}        	
        	else if(dealerPaintCard[i] == 10) {
            	ten.paintIcon(this, g, dCardLoc, 100);
                dCardLoc += 25;      	
        	}
        	else if(dealerPaintCard[i] == 11) {
            	jack.paintIcon(this, g, dCardLoc, 100);
                dCardLoc += 25;      	
        	}        	
        	else if(dealerPaintCard[i] == 12) {
            	queen.paintIcon(this, g, dCardLoc, 100);
                dCardLoc += 25;      	
        	}
        	else if(dealerPaintCard[i] == 13) {
            	king.paintIcon(this, g, dCardLoc, 100);
                dCardLoc += 25;      	
        	}        	
        }         
       
    }
    
    public static int menu() {
        String userInputNum;
        int userChoice; 
        
        userInputNum = JOptionPane.showInputDialog(null, "Enter 1 to play a hand of BlackJack\n" +
        "Enter 2 to Exit Game");
        userChoice = Integer.parseInt (userInputNum); 
        return userChoice; 
    }     

 
//** MAIN *********************************************************************
    public static void main(String[] args) 
    {
    	new Blackjack(); 
    }
    
}

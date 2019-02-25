

//package tictactoe;

import java.awt.GridLayout;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ticTacToe extends JFrame
{
    // Things in Player 1 Panel
    private JPanel playerPanel;
    private JPanel player1Panel;
    private JLabel player1Title;
    private JLabel player1Name;
    private JTextField player1EnterName;
    private JLabel player1Wins;
    private JLabel player1Losses;
    private int player1NumWins;
    private int player1NumLosses;
    private int player2NumWins;
    private int player2NumLosses;
    
    
    private final int WINDOW_WIDTH = 500;
    private final int WINDOW_HEIGHT = 500;
    
    JButton buttons[] = new JButton[9];
    int alternate = 0;//if this number is a even, then put a X. If it's odd, then put an O
  
    public ticTacToe()
    {
        setTitle ("Tic Tac Toe");

        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //setLayout(new BorderLayout());
        setLayout(new GridLayout(4,3));
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        
        buildPlayerPanel();
        initializebuttons();
        
        add(playerPanel, BorderLayout.NORTH);
        
        setVisible(true);
    }
    
    private void buildPlayerPanel()
    {
        // Create player panel
        playerPanel = new JPanel(new GridLayout(1,2));
        
        // Create things in player 1 panel
        player1Title = new JLabel("Player 1 (X):");
        player1Name = new JLabel("Name:\t");
        player1EnterName = new JTextField(8);
        player1Wins = new JLabel("Wins:\t" + player1NumWins);
        player1Losses = new JLabel("Losses:\t" + player1NumLosses);
        
        // Add to player 1 panel
        player1Panel = new JPanel(new GridLayout(4,1));
        player1Panel.add(player1Title);
        player1Panel.add(player1Name);
        player1Panel.add(player1EnterName);
        player1Panel.add(player1Wins);
        player1Panel.add(player1Losses);
        
        
        // Position inside player 1 panel
        
        
        
        // Position player 1 and player 2 panels
        playerPanel = new JPanel(new BorderLayout());
	playerPanel.add(player1Panel, BorderLayout.WEST);

    }

    public void initializebuttons()
    {
        for(int i = 0; i <= 8; i++)
        {
            buttons[i] = new JButton();
            buttons[i].setText("");
            buttons[i].addActionListener(new buttonListener());

            add(buttons[i]); 
        }
    }
    
    public void resetButtons()
    {
        for(int i = 0; i <= 8; i++)
        {
            buttons[i].setText("");
        }
    }
  
    private class buttonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            JButton buttonClicked = (JButton)e.getSource(); 
            
            if(alternate % 2 == 0)
                buttonClicked.setText("X");
            else
                buttonClicked.setText("O");

            if(checkForWin() == true)
            {
                if (alternate % 2 == 0) {
                    JOptionPane.showConfirmDialog(null, "Game over. Player 1 wins!");
                	player1NumWins++; 
                	player2NumLosses++; 
                }
                else {
                    JOptionPane.showConfirmDialog(null, "Game over. Player 2 wins!");
                	player2NumWins++; 
                	player1NumLosses++; 
                }
                resetButtons();
            }

            alternate++;

        }

        public boolean checkForWin()
        {

            //horizontal win check
            if( checkAdjacent(0,1) && checkAdjacent(1,2) ) 
                return true;
            else if( checkAdjacent(3,4) && checkAdjacent(4,5) )
                return true;
            else if ( checkAdjacent(6,7) && checkAdjacent(7,8))
                return true;

            //vertical win check
            else if ( checkAdjacent(0,3) && checkAdjacent(3,6))
                return true;
            else if ( checkAdjacent(1,4) && checkAdjacent(4,7))
                return true;
            else if ( checkAdjacent(2,5) && checkAdjacent(5,8))
                return true;

            //diagonal win check
            else if ( checkAdjacent(0,4) && checkAdjacent(4,8))
                return true;
            else if ( checkAdjacent(2,4) && checkAdjacent(4,6))
                return true;
            else
                return false;
        }

        public boolean checkAdjacent(int a, int b)
        {
            if ( buttons[a].getText().equals(buttons[b].getText()) && !buttons[a].getText().equals("") )
                return true;
            else
                return false;
        }

    }
  
    public static void main(String[] args)
    {
        new ticTacToe();
    }
}

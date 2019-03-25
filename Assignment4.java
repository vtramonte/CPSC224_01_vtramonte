/***************
Homework #4
Due Date: 3/25/2019
Names: Vincent Tramonte, Vincent Rettke
********************/

package assignment4;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Assignment4 extends JFrame implements ActionListener
{
    private int mouseX = 0;
    private int mouseY = 0;

    private Color tempColor = new Color(255, 255, 255);
    private Color skyColor = new Color(0, 255, 255);
    private Color grassColor = new Color(0, 255, 0);
    private Color mountainColor1 = new Color(0x95, 0x2e, 0x8f); // warm purple 
    private Color mountainColor2 = new Color(0, 0, 0); // black
    private Color sunColor = new Color(0xff, 0xff, 0x14);  // yellow
    
    private int delay = 40;
    private Timer timer;
    
    // parallax values
    private int mountainParallax1 = 50;
    private int mountainParallax2 = 50;
    
    private int moonParallax = 5;
    
    private int grassParallax = 50;
    
    
    
    Assignment4()
    {
        setTitle("Motion Parallax");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,500);
        setResizable(false);

        //Add the Mouse and MouseMotion Listeners
        addMouseListener(new MyMouseListener());
        addMouseMotionListener(new MyMouseMotionListener());
        
        // starts the timer
        timer = new Timer(delay, this);
        timer.start();

        setVisible(true);
    }
    
    public void paint(Graphics g)
    {
      // Call the superclass's paint method.
      super.paint(g);
      
      g.setColor(skyColor);             // set sky Color
      g.fillRect(0, 0, 1000, 350);      // create sky
      
      g.setColor(mountainColor1);        // color purple mountain
      int x[] = {200, 25, 375};         
      int y[] = {75, 350, 350};
      int npoints = 3;
      g.fillPolygon(x, y, npoints);     // create left mountain
      
      g.setColor(mountainColor2);                // color black mountain
      int x1[] = {375, 225, 525};         
      int y1[] = {125, 350, 350};
      int npoints1 = 3;
      g.fillPolygon(x1, y1, npoints1);  // create right mountain
      
      g.setColor(sunColor);               // create sun
      g.fillOval(750, 100, 100, 100);
      
      // calculates the parallax values for all the mountains
      for (int i = 0; i < 3; i++) 
      {
          x[i] += mouseX / mountainParallax1;
          y[i] += mouseY/ mountainParallax1;
          x1[i] += mouseX / mountainParallax2;
          y1[i] += mouseY / mountainParallax2;
      }
      
      // draw new mountains
      g.setColor(mountainColor1);        // color purple mountain
      g.fillPolygon(x, y, npoints);     // create left mountain
      
      g.setColor(mountainColor2);        // color purple mountain
      g.fillPolygon(x1, y1, npoints);     // create left mountain
      
      g.setColor(grassColor);           // set grass color
      g.fillRect(0, 350, 1000, 150);    // create grass
      
      
    }
    
    public void actionPerformed(ActionEvent e) 
    {
      // runs when timer activates
      repaint();
   }
    
    private class MyMouseListener implements MouseListener
    {
        //when the mouse is clicked the mountains flip colors     
        public void mouseClicked(MouseEvent e)
        {
           tempColor = mountainColor1;
           mountainColor1 = mountainColor2;
           mountainColor2 = tempColor;
           repaint();
           
           // might want to write code to change colors back
        }
        
        public void mousePressed(MouseEvent e)
        {

        }

        public void mouseReleased(MouseEvent e)
        {
        }

        //when the mouse enters the screen it becomes night time
        public void mouseEntered(MouseEvent e)
        {
            sunColor = new Color(255, 255, 255);
            skyColor =  new Color(0x00, 0x03, 0x5b);  //  dark blue
            grassColor = new Color(0x03, 0x35, 0x00);  //  dark green
            mountainColor1 = new Color(0x35, 0x06, 0x3e);  //  dark purple 
            mountainColor2 = new Color(0, 0, 0);    //  black
            repaint();
        }

        //when the mouse leaves the screen it reverts back to original daytime 
        public void mouseExited(MouseEvent e) 
        {
            sunColor = new Color(0xff, 0xff, 0x14);
            skyColor = new Color(0, 255, 255);
            grassColor = new Color(0, 255, 0);
            
            
            mountainColor1 = new Color(0x95, 0x2e, 0x8f);
            mountainColor2 = new Color(0, 0, 0);
            repaint();
        }
        
        
    }
    
    private class MyMouseMotionListener implements MouseMotionListener 
    {
        public void mouseDragged(MouseEvent e) 
        {
           
        }

        public void mouseMoved(MouseEvent e) 
        {
           // parallax movement happens when the mouse is moved
           mouseX = e.getX() + 500;
           mouseY = e.getY() + 125;
        }
    }
    
    public static void main(String[] args) 
    {
       new Assignment4();
       
    }
    
}

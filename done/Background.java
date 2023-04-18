import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Background extends JPanel{
   Graphics ag;
   JLabel score;
   gui gui;
   snake mySnakey;

   public Background(Graphics mg){/// , Snake s)
      ag = mg;
   }
   public void draw(Graphics g, boolean drawAble, int maxScore)
   {
      if (drawAble != false){
         g.setColor(new Color(129, 250, 77));
         g.fillRect(0, 50, 500, 500);
         g.setColor(new Color(110, 212, 66));
         for(int x = 50; x < 500; x+=100){
            g.fillRect(x, 50, 50, 50);
            g.fillRect(x, 150, 50, 50);
            g.fillRect(x, 250, 50, 50);
            g.fillRect(x, 350, 50, 50);
            g.fillRect(x, 450, 50, 50);
         }
         for(int x = 0; x < 500; x+=100){
            g.fillRect(x, 100, 50, 50);
            g.fillRect(x, 200, 50, 50);
            g.fillRect(x, 300, 50, 50);
            g.fillRect(x, 400, 50, 50);
            g.fillRect(x, 500, 50, 50);
         }
      }
      
      
      if (drawAble == false)//s.getStatus
      {
       //  System.out.println("this happened");
         
      }
   } 
   
   
   // public void paintComponent(Graphics g){
   //    super.paintComponent(g);
   //    g.setColor(new Color(129, 250, 77));
   //    g.fillRect(0, 0, 500, 500);
   //    g.setColor(new Color(110, 212, 66));
   //    for(int x = 50; x < 500; x+=100){
   //       g.fillRect(x, 0, 50, 50);
   //       g.fillRect(x, 100, 50, 50);
   //       g.fillRect(x, 200, 50, 50);
   //       g.fillRect(x, 300, 50, 50);
   //       g.fillRect(x, 400, 50, 50);
   //    }
   //    for(int x = 0; x < 500; x+=100){
   //       g.fillRect(x, 50, 50, 50);
   //       g.fillRect(x, 150, 50, 50);
   //       g.fillRect(x, 250, 50, 50);
   //       g.fillRect(x, 350, 50, 50);
   //       g.fillRect(x, 450, 50, 50);
   //    }
   // }
}



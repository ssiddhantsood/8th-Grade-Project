import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class mango extends fruit{
   
   public mango(int xpos, int ypos, int width, int height, Color color, Graphics g) {
      super(xpos, ypos, width, height, color, g);
   }
   
   // public void Draw(Snake myApple){
   //    myApple.setcolor(color);
   //    myApple.fillRect(xpos, ypos, width, height);
   // }
   public int whichFruitAmI(){
      return 0;
   }
   public Image getImage(int colorNumber){
      return new ImageIcon("mangoImg.png").getImage();
   }

   
   

}


// class AnimatedPanel extends JPanel
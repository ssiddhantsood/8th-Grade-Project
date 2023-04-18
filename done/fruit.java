import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

// public class Fruit extends JPanel{
// 
//       public void addRandomCircle(Color c)  
   // {
      // int x = (int)(Math.random() * FRAME);
      // int y = (int)(Math.random() * FRAME);
      // int r = (int)(Math.random() * FRAME / 10 + 5);
      // myBuffer.setColor(c);
      // myBuffer.fillOval(x-r, y-r, 2*r, 2*r);
   //    
      // repaint();  
   // }
// }


public abstract class fruit{
   
   private BufferedImage myImage;
   private Graphics myBuffer;
   protected int myX;
   protected int myY;
   protected int myWidth;
   protected int myHeight;
   protected Color myColor;
   private Graphics myG;
   public fruit()
   {
      //Unlike 6-01, we won't draw directly to the panel here.
      //Instead we'll make an image and retrieve a graphics object from it.
      //This graphics object takes all the same methods we learned in 6-01, but
      //instead of writing directly to the panel, it writes to the image.
      //See "paintComponent" below, where that image is drawn to the panel.
      // myImage =  new BufferedImage(500, 600, BufferedImage.TYPE_INT_RGB);
      // myBuffer = myImage.getGraphics();
      // myBuffer.setColor();
      // myBuffer.fillRect(0,0,FRAME,FRAME); 
   }
   
   
   public fruit(int xpos, int ypos, int width, int height, Color color, Graphics g) {
    //  myImage =  new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
      //myBuffer = myImage.getGraphics();
     // myBuffer.setColor(color);
     // myBuffer.fillRect(0,0,width,height); 
      myX = xpos;
      myY = ypos;
      myWidth = width;
      myHeight = height;
      myColor = color;
      myG = g;
   }

// public void paintComponent(Graphics g) {
//    super.paintComponent(g);

//    g.setColor(myColor);
//    g.fillOval(myX, myY, myWidth, myHeight);
//      // g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);  //Draw the buffered image we've stored as a field
        
// }
   public void draw(Graphics mg) 
   {
      mg.setColor(myColor);
      mg.fillOval(myX, myY, myWidth, myHeight);
   }   
   public void setX(int x)
   {
      myX = x;
   }
   public void setY(int y)
   {
      myY = y;
   }
   // public int getX()
   // {
   //    return myX;
   // }
   // public int getY()
   // {
   //    return myY;
   // }
   public void addRandomCircle(Color c)  //This is called by the GUI panel when the user pushes the button.
   {
      int x = (int)(Math.random() * 500);
      int y = (int)(Math.random() * 500);
      int r = (int)(Math.random() * 500 / 10 + 5);
      myBuffer.setColor(c);
      myBuffer.fillOval(x, y, 30, 30);
   //   repaint();  //We don't write "paintComponent"; "repaint" calls "paintComponent" again automatically.
                  //(I know that's a bit confusing).
   }
   //abstract method that below classes will impleemtn
   public abstract int whichFruitAmI();
   public abstract Image getImage(int colorNumber);
   public int getX(){
      return myX;
   }
   public int getY(){
      return myY;
   }
}
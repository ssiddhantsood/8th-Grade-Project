import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;


public class gui extends JPanel{
   //BufferedImage myImage;
   Graphics g;
   Timer t;
   private static final int FRAME = 500;
   Boolean space;
   fruit myFruit = new apple(100, 100, 30, 30, new Color(255, 0, 0), g);
   int whichFruit = 0;
   JButton newGame;
   private BufferedImage myImage;
   int whichColor = 0;
   Color myColor = new Color(255, 0, 0);
   Background gfx; 
   int[][] mySnake = new int[10][10];
   snake mySnakey;
   JLabel score;
   int myDirection = 0; //0 = right, 1 = left, 2 = up, 3 = down
   public Boolean gameover = false;
   Boolean waitForReset = false;
   JPanel center;
   //JLabel score;
   
 
   public gui(){
      myImage =  new BufferedImage(FRAME, FRAME+50, BufferedImage.TYPE_INT_RGB);
   
      
      g = myImage.getGraphics();
      setLayout(new BorderLayout());
      
      //At first this is the same as the BorderGUIDemo.
      JLabel title = new JLabel("snake!");
      title.setFont(new Font("Serif", Font.BOLD, 20));
      title.setHorizontalAlignment(SwingConstants.CENTER);
      add(title, BorderLayout.NORTH);
   
      center = new JPanel();
      center.setSize(100, 100);
      newGame = new JButton("Play Again");
      newGame.addActionListener(new newGameListener());
      center.setAlignmentX(CENTER_ALIGNMENT);
      newGame.setVisible(false);
      center.setSize(100, 100);
      center.add(newGame); 
      center.setVisible(false);
   
      score = new JLabel();
      score.setFont(new Font("Serif", Font.BOLD, 20));    
      score.setHorizontalAlignment(SwingConstants.CENTER);
      center.add(score);
   
      add(center);
   
      gfx = new Background(g);
      gfx.draw(g, true, 0);
      mySnake[2][2] = 4;
      mySnake[2][3] = 3;
      mySnake[2][4] = 2;
      mySnake[2][5] = 1;
      mySnakey = new snake(mySnake);
      mySnakey.createNewFruit();
      int[] coordsForFruit = mySnakey.fruitLocation(); 
      myFruit.setX(coordsForFruit[0]*50);
      myFruit.setY(coordsForFruit[1]*50+50);
      mySnakey.draw(g, myColor, myFruit);
    //  add(gfx);
      //print out hi
    //  System.out.println("hi");
   // g.fillRect(50, 150, 50, 50);
   
      JPanel northSubpanel = new JPanel();
      northSubpanel.setLayout(new GridLayout(1, 2));
      JButton changeColor = new JButton("Change Color");
      changeColor.addActionListener(new changeColorListener());
      northSubpanel.add(changeColor);  //Add the button TO THE SUBPANEL
      addKeyListener(new Key());
      setFocusable(true);
      JButton changeFruit = new JButton("Change Fruit");
      changeFruit.addActionListener(new changeFruitListener());
      northSubpanel.add(changeFruit);  //Add the button TO THE SUBPANEL
      add(northSubpanel, BorderLayout.NORTH);  //Add the SUBPANEL to the PANELs
      t = new Timer(100, new timeListener());
      t.start();
   
   
      // myFruit = new Apple(100, 100, 30, 30, myColor, g);
      // add(myFruit);
     // paint(g);
   }
   public void paintComponent(Graphics g)
   {
      g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
   
   }
   

   private class changeColorListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
            //add in color change
         if(whichColor == 0)
         {
            myColor = new Color(255, 0, 0);
            whichColor = 1;
            //change color to red
         }
         else if(whichColor == 1)
         {
            whichColor = 2;
            //change color to blue
            myColor = new Color(0, 0, 255);
         }
         else if(whichColor == 2)
         {
            whichColor = 3;
            //change color to green
            myColor = new Color(0, 255, 0);
         }
         else if(whichColor == 3)
         {
            whichColor = 0;
            //change color to black
            myColor = new Color(255, 255, 255);
         }
       //  add(myFruit);
       //  paint(g);
         //print out oops
       //  System.out.println("oops");
       //Image tempImage = myFruit.getImage(whichColor);
       //g.fillRect(50, 150, 50, 50);
      //  mySnakey.draw(g, myColor);
      
      ///   g.drawImage(tempImage, myFruit.getX(), myFruit.getY(), 50, 50, null);
       
      //  repaint();
         endGame();
         //gameover = true;
      }
   }
   private class timeListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         //add in movement
         if(!waitForReset)
         {
            if(myDirection == 0)
            {
               if(mySnakey.moveRight() == 0)
               {
                  endGame();
               //gameover = true;
               }
            }
            else if(myDirection == 1)
            {
               if(mySnakey.moveLeft() == 0)
               {
                  endGame();
               //gameover = true;
               }         
            }
            else if(myDirection == 2)
            {
               if(mySnakey.moveUp() == 0)
               {
                  endGame();
               //gameover = true;
               } 
            }
            else if(myDirection == 3)
            {
               if(mySnakey.moveDown() == 0)
               {
                  endGame();
               //gameover = true;
               }          
            }
         
         //print out mySnakey
            if(!waitForReset)
            {
               int[] coordsForFruit = mySnakey.fruitLocation(); 
               myFruit.setX(coordsForFruit[0]*50);
               myFruit.setY(coordsForFruit[1]*50+50);
            // Image tempImage = myFruit.getImage(whichColor);
            //mySnakey.printSnake();
               gfx.draw(g, true, 0);
            // System.out.println(coordsForFruit[0]*50);
            // g.drawImage(tempImage, myFruit.getX(), myFruit.getY(), 50, 50, null);
               mySnakey.draw(g, myColor, myFruit);
               repaint();
            }
         }
         //add in fruit
      //    if(mySnakey.checkFruit(myFruit))
      //    {
      //       mySnakey.eatFruit(myFruit);
      //       myFruit.setX(100);
      //       myFruit.setY(100);
      //       myFruit.setX(myFruit.getX() + (int)(Math.random()*FRAME));
      //       myFruit.setY(myFruit.getY() + (int)(Math.random()*FRAME));
      //       myFruit.setX(myFruit.getX() - (myFruit.getX() % 50));
      //       myFruit.setY(myFruit.getY() - (myFruit.getY() % 50));
      //       myFruit.setX(myFruit.getX() + (int)(Math.random()*FRAME));
      //       myFruit.setY(myFruit.getY() + (int)(Math.random()*FRAME));
      //       myFruit.setX(myFruit.getX() - (myFruit.getX() % 50));
      //       myFruit.setY(myFruit.getY() - (myFruit.getY() % 50));
      //       myFruit.setX(myFruit.getX() + (int)(Math.random()*FRAME));
      //       myFruit.setY(myFruit.getY() + (int)(Math.random()*FRAME));
      //       myFruit.setX(myFruit.getX() - (myFruit.getX() % 50));
      // }
      }
   }
   private class changeFruitListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
            //add fruit change
         if(whichFruit == 0)
         {
            whichFruit = 1;
            myFruit = new apple(100, 100, 30, 30, myColor, g);
         }
         else if(whichFruit == 1)
         {
            whichFruit = 2;
            myFruit = new banana(100, 100, 30, 30, myColor, g);
         }
         else if(whichFruit == 2)
         {
            whichFruit = 3;
            myFruit = new orange(100, 100, 30, 30, myColor, g);
         }
         else if(whichFruit == 3)
         {
            whichFruit = 4;
            myFruit = new mango(100, 100, 30, 30, myColor, g);
         }
         else if(whichFruit == 4)
         {
            whichFruit = 0;
            myFruit = new strawberry(100, 100, 30, 30, myColor, g);
         }
         // else if(whichFruit == 5)
         // {
         //    whichFruit = 0;
         //    myFruit = new watermelon(100, 100, 30, 30, myColor, g);
         // }
        // add(myFruit);
         //myFruit.draw(g);
        // g.fillRect(50, 150, 50, 50);
      
      //   Image tempImage = myFruit.getImage(whichColor);
      //    g.drawImage(tempImage, myFruit.getX(), myFruit.getY(), 50, 50, null);
      //    gfx.draw(g);
         
        // repaint();
         //endGame();
      }
   }
   
   
   // public void endGame(Graphics g)
   // {
      // g.setColor(Color.WHITE);
      // g.fillRect(0, 0, 600, 600);
      // g.setFont(new Font("Monospaced", Font.PLAIN, 20));
      // g.setColor(Color.BLACK);
      // g.drawString("GAME OVER", 100, 100);
      // score = new JLabel("Your score is: " + mySnakey.maxForScore());
      // score.setFont(new Font("Serif", Font.BOLD, 20));    
      // score.setHorizontalAlignment(SwingConstants.CENTER);
      // add(score);
      // repaint();
   // 
   // }
   public boolean endGame()
   {
      center.setVisible(true);
   
      newGame.setVisible(true);
      gfx.draw(g, false, mySnakey.maxForScore());
      waitForReset = true;
      // g.setColor(Color.WHITE);
      // g.fillRect(0, 0, 600, 600);
      // g.setFont(new Font("Monospaced", Font.PLAIN, 20));
      // g.setColor(Color.BLACK);
      // g.drawString("GAME OVER Your score is: " + (mySnakey.maxForScore()-5), 100, 100);
      score.setText("GAME OVER Your score is: " + (mySnakey.maxForScore()-5));
      t.stop();
      // add(score);
      //System.out.println("this happened");
     // repaint();     
   
    
   
      return true;
   }
   private class newGameListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         waitForReset = false;
         center.setVisible(false);
         myDirection = 0;
        // newGame.setVisible(true);
        // mySnakey.reset();
         mySnake = new int[10][10];
         mySnake[2][2] = 4;
         mySnake[2][3] = 3;
         mySnake[2][4] = 2;
         mySnake[2][5] = 1;
        // myFruit.reset();
         mySnakey = new snake(mySnake);
         mySnakey.createNewFruit();
         int[] coordsForFruit = mySnakey.fruitLocation(); 
         myFruit.setX(coordsForFruit[0]*50);
         myFruit.setY(coordsForFruit[1]*50+50);
         mySnakey.draw(g, myColor, myFruit);
         gfx.draw(g, true, 0);
         repaint();
         t.start();
      }
   }
   

   private class Key extends KeyAdapter
   {
      public void keyPressed(KeyEvent e)
      {
         if(e.getKeyCode() == KeyEvent.VK_UP)
         {
            myDirection = 2;
         }
         else if(e.getKeyCode() == KeyEvent.VK_DOWN)
         {
            myDirection = 3; 
         }
         else if(e.getKeyCode() == KeyEvent.VK_LEFT)
         {
            myDirection = 1;
         }
         else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
         {
            myDirection = 0;
         }
      }
   }    
}  
  
   
      
   // public AnimatedPanel(){
   // 
      // myImage = new BufferedImage (500, 500, BufferedImage.TYPE_INT_RGB);
   //    
   // }
   
      
      // int x = (int)Math.floor(Math.random()*(485-0+1)+0);
      // int y = (int)Math.floor(Math.random()*(485-0+1)+0);
   // 
      // g.setColor(Color.RED);
      // g.fillRect(x, y, 30, 30);
   // 
      // x = (int)Math.floor(Math.random()*(485-0+1)+0);
      // y = (int)Math.floor(Math.random()*(485-0+1)+0);
   // 
      // g.setColor(Color.YELLOW);
      // g.fillOval(x, y, 25, 30);
   // 
      // g.setColor(Color.ORANGE);
      // g.fillOval(x, y, 30, 30);
   // 
      // g.setColor(Color.BLUE);
      // g.fillOval(x, y, 30, 30);
    // 
      // g.setColor(Color.MAGENTA.darker());
      // g.fillOval(x, y, 30, 30);
      
           
   //}
   
// }
// 
// private class draw(Graphics g){
//    
// 
// 
// }





// class check extends JPanel
// {
   // public static final int FRAMEX = 500;
   // public static final int FRAMEY = 600;
   // private static final Color BACKGROUND = new Color(129, 250, 77);
   // private static final Color squares = new Color(110, 212, 66);
//    
   // private BufferedImage myBuffer;
   // private Graphics myImage;
//       
   // public check()
   // {
      // myBuffer =  new BufferedImage(FRAMEX, FRAMEY, BufferedImage.TYPE_INT_RGB);
      // myImage = myBuffer.getGraphics();
      // myImage.setColor(BACKGROUND);
      // myImage.fillRect(0,0,FRAMEX,FRAMEY);
      // myImage.setColor(squares);   
      // for(int x = 50; x < 500; x+=100){
         // myImage.fillRect(x, 0, 50, 50);
         // myImage.fillRect(x, 100, 50, 50);
         // myImage.fillRect(x, 200, 50, 50);
         // myImage.fillRect(x, 300, 50, 50);
         // myImage.fillRect(x, 400, 50, 50);
      // }
      // for(int x = 0; x < 500; x+=100){
         // myImage.fillRect(x, 50, 50, 50);
         // myImage.fillRect(x, 150, 50, 50);
         // myImage.fillRect(x, 250, 50, 50);
         // myImage.fillRect(x, 350, 50, 50);
         // myImage.fillRect(x, 450, 50, 50);
      // } 
   // }
   
   // public void paintComponent(Graphics g)  //Required method to paint to the screen
   // {
      // g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);  //Draw the buffered image we've stored as a field
   // }
   
   // public void addRandomCircle(Color c)  //This is called by the GUI panel when the user pushes the button.
   // {
      // int x = (int)(Math.random() * FRAME);
      // int y = (int)(Math.random() * FRAME);
      // int r = (int)(Math.random() * FRAME / 10 + 5);
      // myBuffer.setColor(c);
      // myBuffer.fillOval(x-r, y-r, 2*r, 2*r);
   //    
      // repaint();  //We don't write "paintComponent"; "repaint" calls "paintComponent" again automatically.
   //                //(I know that's a bit confusing).
   // }
//}


// public  graphics(Graphics g){
      // g.setColor(new Color(129, 250, 77));
      // g.fillRect(0, 0, 500, 500);
      // g.setColor(new Color(110, 212, 66));
      // for(int x = 50; x < 500; x+=100){
         // g.fillRect(x, 0, 50, 50);
         // g.fillRect(x, 100, 50, 50);
         // g.fillRect(x, 200, 50, 50);
         // g.fillRect(x, 300, 50, 50);
         // g.fillRect(x, 400, 50, 50);
      // }
      // for(int x = 0; x < 500; x+=100){
         // g.fillRect(x, 50, 50, 50);
         // g.fillRect(x, 150, 50, 50);
         // g.fillRect(x, 250, 50, 50);
         // g.fillRect(x, 350, 50, 50);
         // g.fillRect(x, 450, 50, 50);
      // }
   //    
   // }

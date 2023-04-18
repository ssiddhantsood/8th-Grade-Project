import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class snake{
   int[][] snakeBody;
   public snake()
   {
   
   }
   public snake(int[][] snake){
      snakeBody = snake.clone();
   }
   public void createNewFruit()
   {
      int x = (int)(Math.random()*10);
      int y = (int)(Math.random()*10);
      while(snakeBody[x][y] > 0)
      {
         x = (int)(Math.random()*10);
         y = (int)(Math.random()*10);
      }
      snakeBody[x][y] = -1;
   }
   public int[][] getSnake(){
      return snakeBody;
   }
   public int maxForScore()
   {
      int snakeCount = 0;
      for(int i = 0; i < snakeBody.length; i++){
         for(int j = 0; j < snakeBody[i].length; j++){
            if(snakeBody[i][j] != 0){
               snakeCount++;
            }
         }
      }
      return snakeCount;
   }
   public int[] fruitLocation(){
      for(int i = 0; i < snakeBody.length; i++){
         for(int j = 0; j < snakeBody[i].length; j++){
            if(snakeBody[i][j] < 0){
               return new int[]{i, j};
            }
         }
      }
      return new int[]{-1, -1};
   }
   public void printSnake()
   {
      for(int i = 0; i < snakeBody.length; i++){
         for(int j = 0; j < snakeBody[i].length; j++){
            System.out.print(snakeBody[i][j]);
         }
         System.out.println();
      
      }
      System.out.println();
      System.out.println();
      System.out.println();
   }
   public int moveDown(){
      int maxSnakeValue = 0;
      int minSnakeValue = 1000;
      boolean dontSubtract = false;
      for(int i = 0; i < snakeBody.length; i++){
         for(int j = 0; j < snakeBody[i].length; j++){
            if(snakeBody[i][j] > maxSnakeValue){
               maxSnakeValue = snakeBody[i][j];
            }
            if(snakeBody[i][j] < minSnakeValue && snakeBody[i][j] > 0){
               minSnakeValue = snakeBody[i][j];
            }
            
         }
      }
      for(int i = 0; i < snakeBody.length; i++){
         for(int j = 0; j < snakeBody[0].length; j++){
            if(snakeBody[i][j] == maxSnakeValue){
              // snakeBody[i][j] = 1;
               if(j == snakeBody.length-1 || snakeBody[i][j+1] > 0){
                  return 0;
               }
               else{
                  if(snakeBody[i][j+1] < 0){
                     dontSubtract = true;
                  }
                  snakeBody[i][j+1] = maxSnakeValue+1;
               }
               
            }
            
         }
      }
      for(int i = 0; i < snakeBody.length; i++){
         for(int j = 0; j < snakeBody[0].length; j++){
            if(snakeBody[i][j] == minSnakeValue && !dontSubtract){
               snakeBody[i][j] = 0;
            }
         }
      }
      if(dontSubtract)
      {
         createNewFruit();
      }
      return 1;
   }
   public int moveUp(){
      int maxSnakeValue = 0;
      int minSnakeValue = 1000;
      boolean dontSubtract = false;
      for(int i = 0; i < snakeBody.length; i++){
         for(int j = 0; j < snakeBody[i].length; j++){
            if(snakeBody[i][j] > maxSnakeValue){
               maxSnakeValue = snakeBody[i][j];
            }
            if(snakeBody[i][j] < minSnakeValue && snakeBody[i][j] > 0){
               minSnakeValue = snakeBody[i][j];
            }
         }
      }
      for(int i = 0; i < snakeBody.length; i++){
         for(int j = 0; j < snakeBody[0].length; j++){
            if(snakeBody[i][j] == maxSnakeValue){
             //  snakeBody[i][j] = 1;
               if(j == 0 || snakeBody[i][j-1] > 0){
                  return 0;
               }
               else{
                  if(snakeBody[i][j-1] < 0){
                     dontSubtract = true;
                  }
                  snakeBody[i][j-1] = maxSnakeValue+1;
               }
               
            }
            
         }
      }
      for(int i = 0; i < snakeBody.length; i++){
         for(int j = 0; j < snakeBody[0].length; j++){
            if(snakeBody[i][j] == minSnakeValue && !dontSubtract){
               snakeBody[i][j] = 0;
            }
         }
      }
      if(dontSubtract)
      {
         createNewFruit();
      }
      return 1;
   }
   public int moveLeft(){
      int maxSnakeValue = 0;
      int minSnakeValue = 1000;
      boolean dontSubtract = false;
      for(int i = 0; i < snakeBody.length; i++){
         for(int j = 0; j < snakeBody[i].length; j++){
            if(snakeBody[i][j] > maxSnakeValue){
               maxSnakeValue = snakeBody[i][j];
            }
            if(snakeBody[i][j] < minSnakeValue && snakeBody[i][j] > 0){
               minSnakeValue = snakeBody[i][j];
            }
         }
      }
      for(int i = 0; i < snakeBody.length; i++){
         for(int j = 0; j < snakeBody[0].length; j++){
            if(snakeBody[i][j] == maxSnakeValue){
              // snakeBody[i][j] = 1;
               if(i == 0 || snakeBody[i-1][j] > 0){
                  return 0;
               }
               else{
                  if(snakeBody[i-1][j] < 0){
                     dontSubtract = true;
                  }
                  snakeBody[i-1][j] = maxSnakeValue+1;
               }
               
            }
            
         }
      }
      for(int i = 0; i < snakeBody.length; i++){
         for(int j = 0; j < snakeBody[0].length; j++){
            if(snakeBody[i][j] == minSnakeValue && !dontSubtract){
               snakeBody[i][j] = 0;
            }
         }
      }
      if(dontSubtract)
      {
         createNewFruit();
      }
      return 1;
   }
   public int moveRight(){
      int maxSnakeValue = 0;
      int minSnakeValue = 1000;
      boolean dontSubtract = false;
      for(int i = 0; i < snakeBody.length; i++){
         for(int j = 0; j < snakeBody[i].length; j++){
            if(snakeBody[i][j] > maxSnakeValue){
               maxSnakeValue = snakeBody[i][j];
            }
            if(snakeBody[i][j] < minSnakeValue && snakeBody[i][j] > 0){
               minSnakeValue = snakeBody[i][j];
            }
         }
      }
      for(int i = 0; i < snakeBody.length; i++){
         for(int j = 0; j < snakeBody[0].length; j++){
            if(snakeBody[i][j] == maxSnakeValue){
              // snakeBody[i][j] = 1;
               if(i == snakeBody.length-1 || snakeBody[i+1][j] > 0){
                  return 0;
               }
               else{
                  if(snakeBody[i+1][j] < 0){
                     dontSubtract = true;
                  }
                 // System.out.println("this works?");
                  snakeBody[i+1][j] = maxSnakeValue+1;
               }
            }
         }
      }
      for(int i = 0; i < snakeBody.length; i++){
         for(int j = 0; j < snakeBody[0].length; j++){
            if(snakeBody[i][j] == minSnakeValue && !dontSubtract){
               snakeBody[i][j] = 0;
            }
         }
      }
      if(dontSubtract)
      {
         createNewFruit();
      }
      return 1;
   }
   public void draw(Graphics g, Color color, fruit myFruit){
     //use a for loop to run through all elements in 2d array snake body
      int maxSnakeValue = 0;
      int counter = 0;
      Image tempImage = myFruit.getImage(0);
      g.drawImage(tempImage, myFruit.getX(), myFruit.getY(), 50, 50, null);
   
      for(int i = 0; i < snakeBody.length; i++){
         for(int j = 0; j < snakeBody[i].length; j++){
            if(snakeBody[i][j] > maxSnakeValue){
               maxSnakeValue = snakeBody[i][j];
            }
         }
      }
      for(int i = 0; i < snakeBody.length; i++){
         for(int j = 0; j < snakeBody[i].length; j++){
            g.setColor(color);
            if(snakeBody[i][j] == maxSnakeValue){
               counter++;
               g.fillRect(i*50, j*50+50, 50, 50);
               g.setColor(Color.BLACK);
               g.fillRect(i*50+10, j*50+60, 10, 10);
            }
            else if(snakeBody[i][j] > 0){
               counter++;
               g.fillRect(i*50, j*50+50, 50, 50);
            }
         }
      }
   //     System.out.println(counter);
   
   
     
   }

  
  

}


// class AnimatedPanel extends JPanel

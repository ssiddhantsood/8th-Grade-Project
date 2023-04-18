//Names: Tejesh Dandu, Pranav Panicker, Siddhant Sood
//Date: Semester 2 - 2020-2021 School Year
//Assignment: Accelerated CS Final Project

//Author: Tejesh Dandu
//Importing graphics libraries needed for animation and drawing
//the game space.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class SnakePanel extends JPanel {
   //FRAME represents the game board size
   private static final int FRAME = 600;
   //BACKGROUND represents color of the window or panel the game
   //will be shown on
   private static final Color BACKGROUND = new Color(67, 191, 67);
   //myBuffer will store the image and graphics temporarily and then
   //relay it to myImage, for faster load of graphics
   private BufferedImage myBuffer;
   private Graphics myImage;
   //Timer for intervals needed for animating movement
   private Timer t;
   //Snake and Apple objects so interactions between both objects
   //can be manipulated and can interact with game space.  
   private Snake snake;
   private Apple apple;
   //coordinates[] and temp[] arrays that store the coordinates for the snake and
   //work out the movement of the snake. These arrays make a limit for the score and 
   //snake length.
   private double[] coordinates = new double[4096];
   private double[] temp = new double[4096];
   //snakeLength represents the number of circles that make up the visual representation
   //of the snake. Eight circles make up one segment of the snake, which is added when the score
   //increases by one.
   private int snakeLength = 1;
   //JLabels that appear at the top to provide instructions and a updating scoreboard.
   private JLabel label;
   private JLabel title;
   //counter represents the current score.
   private int counter = 0;
   //SPEED is a variable that represents the number of pixels the snake will move per unit of time. Larger SPEED means
   //faster movement of snake, and vice versa. This allows for SPEED to be changed easily in one place instead of the
   //entire program.
   private int SPEED = 3;
   public SnakePanel() {
      //Sets up basic image of gameboard. Sets up green background of the entire frame.
      myBuffer = new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
      myImage = myBuffer.getGraphics();
      myImage.setColor(BACKGROUND);
      myImage.fillRect(0, 0, FRAME, FRAME);
      //Initializing of apple, snake, and timer objects, as well as title and label JLabels.
      apple = new Apple(300, 300, 60, new Color(255, 0, 0));
      title = new JLabel("Welcome to Snake!");
      title.setFont(new Font("Serif", Font.BOLD, 25));
      title.setForeground(Color.orange);
      add(title);
      label = new JLabel("Press Space to start. Use the Arrow Keys to control the snake.");
      label.setFont(new Font("Serif", Font.BOLD, 25));
      label.setForeground(Color.orange);
      add(label);
      t = new Timer(1, new Listener());
      snake = new Snake(300, 300, new Color(43, 95, 217), 30, 1, 1);
      //Stores initial coordinates into coordinates[] array
      coordinates[0] = snake.getX();
      coordinates[1] = snake.getY();
      //Draws initial instances of snake and apple objects.
      myImage.setColor(snake.getColor());
      snake.draw(myImage);
      myImage.setColor(apple.getColor());
      apple.randomSpot(FRAME, FRAME);
      apple.draw(myImage);
      //Adds Listener that responds to keyboard interactions. Allows for movement of snake.
      addKeyListener(new Key());
      setFocusable(true);
   }
   //Paints graphics and images stored in "g" when called
   public void paintComponent(Graphics g) {
      g.drawImage(myBuffer, 0, 0, getWidth(), getHeight(), null);
   }
   //Basic distance formula to calculate distance between coordinates of objects on gameboard.
   public double distance(double x1, double y1, double x2, double y2) {
      return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));  
   }
   //Listener that occurs every unit of time in Timer object.
   private class Listener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         collide(snake, apple);
         myImage.setColor(BACKGROUND);
         //Draws snake object based off of coordinates stored in coordinates[] array
         for(int j = 0; j < snakeLength; j++) {
            myImage.fillOval((int)coordinates[2 * j], (int)coordinates[2 * j + 1], (int)snake.getRadius(), (int)snake.getRadius());
         }
         //If / Else-If Structure to guide movement of snake based on direction 
         //(this allows for snake to be moving continuously without key being pressed)
         if(snake.getDirection() == 0) {
            snake.setX(snake.getX() + SPEED);
         }
         else if(snake.getDirection() == 1) {
            snake.setY(snake.getY() - SPEED);
         }
         else if(snake.getDirection() == 2) {
            snake.setX(snake.getX() - SPEED);
         }
         else if(snake.getDirection() == 3) {
            snake.setY(snake.getY() + SPEED);
         }
         //Stores coordinates of coordinates[] into temp[] to transfer snake to next position
         for(int a = 0; a < coordinates.length; a++) {
            temp[a] = coordinates[a];
         }
         //Shifts coordinates appropriately to simulate snake movement
         coordinates[0] = snake.getX();
         coordinates[1] = snake.getY();
         for(int i = 0; i < snakeLength - 1; i++) {
            coordinates[2 * i + 2] = temp[2 * i];
            coordinates[2 * i + 3] = temp[2 * i + 1];
         }
         //Draws snake object
         myImage.setColor(snake.getColor());
         for(int j = 0; j < snakeLength; j++) {
            myImage.fillOval((int)coordinates[2 * j], (int)coordinates[2 * j + 1], (int)snake.getRadius(), (int)snake.getRadius());
         }
         //Draws apple object
         myImage.setColor(apple.getColor());
         apple.draw(myImage);
         myImage.setColor(BACKGROUND);
         gameOver(snake);
         repaint();
      }
   }
   //collide(Snake s, Apple a) function sees if snake touches apple, and if so,
   //adds 1 to counter, sets label to new score, and adds new set of coordinates
   //to coordinates[]
   private void collide(Snake s, Apple a) {
      double d = distance(s.getX(), s.getY(), a.getX(), a.getY());
      if(d <= s.getRadius()) {
         myImage.setColor(BACKGROUND);
         apple.draw(myImage);
         myImage.setColor(apple.getColor());
         apple.randomSpot(FRAME, FRAME);
         apple.draw(myImage);
         for(int b = 0; b < 16; b++) {
            coordinates[snakeLength * 2 + b] = -300;
         }
         snakeLength = snakeLength + 8;
         counter = counter + 1;
         label.setText("Score: " + counter);
      }
   }
   //gameOver(Snake s) checks conditions that would make the game end, which are if the snake crashes against the edge of the gameboard,
   //crashes against itself, and if the game reaches the max score of 255. If game ends, JOptionPane guides the game to end, and exits out
   //of program.
   public void gameOver(Snake s) {
      if(s.getX() <= 0 || s.getX() >= FRAME - s.getRadius() || s.getY() <= 0 || s.getY() >= FRAME - s.getRadius()) {
         JOptionPane.showMessageDialog(null, "GAME OVER! Your score was: " + counter);
         System.exit(0);
      }
      double d = 10;
      for(int i = 1; i < snakeLength; i++) {
         d = distance(s.getX(), s.getY(), coordinates[2 * i], coordinates[2 * i + 1]);
         if(d < 3 && snakeLength >= 9) {
            JOptionPane.showMessageDialog(null, "GAME OVER! Your score was: " + counter);
            System.exit(0);  
         }
      }
      if(counter == 255) {
         JOptionPane.showMessageDialog(null, "CONGRATULATIONS! You got the highest score: 256!");
         System.exit(0);
      }
   }
   //Listener that responds to key press, allowing for user
   //control of Snake object when playing the game, and sets direction of snake to
   //appropriate direction argument.
   private class Key extends KeyAdapter {
      public void keyPressed(KeyEvent e) {
         myImage.setColor(BACKGROUND);
         snake.draw(myImage);
         if(e.getKeyCode() == KeyEvent.VK_UP && snake.getDirection() != 3) {
            snake.setDirection(1);
         }
         if(e.getKeyCode() == KeyEvent.VK_LEFT && snake.getDirection() != 0) {
            snake.setDirection(2);
         }
         if(e.getKeyCode() == KeyEvent.VK_DOWN && snake.getDirection() != 1) {
            snake.setDirection(3);
         }
         if(e.getKeyCode() == KeyEvent.VK_RIGHT && snake.getDirection() != 2) {
            snake.setDirection(0);
         }
         if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            t.start();
            label.setText("Score: " + counter);
         }
      }
   }
}
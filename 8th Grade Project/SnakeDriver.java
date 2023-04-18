//Names: Tejesh Dandu, Pranav Panicker, Siddhant Sood
//Date: Semester 2 - 2020-2021 School Year
//Assignment: Accelerated CS Final Project

//Authors: Tejesh Dandu, Pranav Panicker, Siddhant Sood

//Imports necessary packages
import javax.swing.JFrame;
public class SnakeDriver {
   public static void main(String[] args) {
      //Initializes JFrame object, storing SnakePanel()
      JFrame frame = new JFrame("CS Final Project: Snake Game");
      //Sets size and location of the JFrame
      frame.setSize(600, 600);
      frame.setLocation(100, 100);
      //Allows for JFrame to close hen the X is pressed
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //Sets the content of the JFrame on display to SnakePanel()
      frame.setContentPane(new SnakePanel());
      //JFrame can be seen and is visible to users
      frame.setVisible(true);
   }
}
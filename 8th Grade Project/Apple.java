//Names: Tejesh Dandu, Pranav Panicker, Siddhant Sood
//Date: Semester 2 - 2020-2021 School Year
//Assignment: Accelerated CS Final Project

/**
* An Apple is an Object that has information about itself 
* regarding its location (x and y coordinates), diameter,
* radius, and color. These parameters can be returned and 
* set to specific values. It also has functions to draw itself
* as well as jump to a randomly chosen spot, needed for
* spawning apples throughout the Snake game.
* @author Siddhant Sood
*/
import java.awt.*;
public class Apple {
   private double myX;
   private double myY;
   private double myDiameter;
   private Color myColor;
   private double myRadius;
   /**
   * Constructs an Apple object with an initial x position
   * specified by x, initial y position specified by y, 
   * initial diameter specified by d, and initial Color 
   * specified by c.
   * @param x     initial x position
   * @param y     initial y position
   * @param d     initial diameter
   * @param c     initial Color
   */
   public Apple(double x, double y, double d, Color c) {
      myX = x;
      myY = y;
      myDiameter = d;
      myColor = c;
      myRadius = d / 2;
   }
   /**
   * Returns the x position of Apple object.
   * @return x position
   */
   public double getX() {
      return myX;
   }
   /**
   * Returns the y position of Apple object.
   * @return y position
   */
   public double getY() {
      return myY;
   }
   /**
   * Returns the diameter of Apple object.
   * @return diameter
   */
   public double getDiameter() {
      return myDiameter;  
   }
   /**
   * Returns the Color value of the Apple object.
   * @return Color value
   */
   public Color getColor() {
      return myColor;
   }
   /** 
   * Returns the radius of the Apple Object.
   * @return radius
   */
   public double getRadius() {
      return myRadius;
   }
   /**
   * Sets the x position to the input value.
   * @param x     assigns x to myX
   */
   public void setX(double x) {
      myX = x;  
   }
   /**
   * Sets the y position to the input value.
   * @param y     assigns y to myY
   */
   public void setY(double y) {
      myY = y; 
   }
   /**
   * Sets the diameter to the input value.
   * @param d     assigns d to myDiameter
   */
   public void setDiameter(double d) {
      myDiameter = d;
      myRadius = d / 2;
   }
   /**
   * Sets the Color value to the input value.
   * @param c     assigns c to myColor
   */
   public void setColor(Color c) {
      myColor = c;
   }
   /**
   * Sets the radius to the input value.
   * @param r     assigns r to myRadius
   */
   public void setRadius(double r) {
      myRadius = r;
      myDiameter = r * 2;
   }
   /**
   * Sets x and y positions to randomly generated values
   * within Panel bounds, which are parameters.
   * @param xEdge     Panel horizontal bounds
   * @param yEdge     Panel vertical bounds
   */
   public void randomSpot(double xEdge, double yEdge) {
      double adjX = xEdge - this.getDiameter();
      double adjY = yEdge - this.getDiameter();
      myX = (Math.random() * adjX) + this.getRadius();
      myY = (Math.random() * adjY) + this.getRadius();
   }
   /**
   * Draws the Apple object by storing it in the Graphics
   * object, which is a parameter.
   * @param myBuffer     assigns Apple object to myBuffer
   */
   public void draw(Graphics myBuffer) {
      myBuffer.fillOval((int)myX, (int)myY, (int)myRadius, (int)myRadius);
   }
}  
//Names: Tejesh Dandu, Pranav Panicker, Siddhant Sood
//Date: Semester 2 - 2020-2021 School Year
//Assignment: Accelerated CS Final Project

//@author Pranav Panicker
import java.awt.*;
public class Snake {
	private double myX;
	private double myY;
	private Color myColor;
	private double myRadius;
	private int myLength;
	private int myDirection;
	/***************************************************************************************************************************
	 * Constructs Snake object with x, y, diameter, color, radius, length, and direction specified by the respective parameters.
	 * @param x		initial x position of head circle
	 * @param y		initial y position of head circle
	 * @param c		initial color of a snake's body
	 * @param r		initial radius of circles in a snake's body
	 * @param l		initial length of a snakes body in circles
	 * @param d		initial direction of a snake: EAST is 0, NORTH is 1, WEST is 2, SOUTH is 3
	 ***************************************************************************************************************************/

	public Snake(double x, double y, Color c, double r, int l, int d) {
		myX = x;
      myY = y;
      myColor = c;
      myRadius = r;
      myLength = l;
      myDirection = d;
	}

	/***************************************************************************************************************************
	 * Returns the snake's x position
	 * @return x
	 ***************************************************************************************************************************/
	public double getX() {
      return myX;
	}

	/***************************************************************************************************************************
	 * Returns the snake's y position
	 * @return y
	 ***************************************************************************************************************************/
	public double getY() {
      return myY;
	}

	/***************************************************************************************************************************
	 * Returns the snake's color
	 * @return color
	 ***************************************************************************************************************************/
	public Color getColor() {
      return myColor;
	}

	/***************************************************************************************************************************
	 * Returns the snake's radius
	 * @return radius
	 ***************************************************************************************************************************/
	public double getRadius() {
      return myRadius;
	}

	/***************************************************************************************************************************
	 * Returns the snake's length
	 * @return length
	 ***************************************************************************************************************************/
	public int getLength() {
      return myLength;
	}

	/***************************************************************************************************************************
	 * Returns the snake's direction
	 * @return direction
	 ***************************************************************************************************************************/
	public int getDirection() {
      return myDirection;
	}

	/***************************************************************************************************************************
	 * Sets the x position to the input number.
	 * @param x     assigns x to myX
	 ***************************************************************************************************************************/
	public void setX(double x) {
      myX = x;
	}

	/***************************************************************************************************************************
	 * Sets the y position to the input number.
	 * @param y     assigns y to myY
	 ***************************************************************************************************************************/
	public void setY(double y) {
      myY = y;
	}

	/***************************************************************************************************************************
	 * Sets the color to the input color.
	 * @param c     assigns c to myColor
	 ***************************************************************************************************************************/
	public void setColor(Color c) {
      myColor = c;
	}

	/***************************************************************************************************************************
	 * Sets the radius of the circles on the snake to the input number.
	 * @param r     assigns r to myRadius
	 ***************************************************************************************************************************/
	public void setRadius(double r) {
      myRadius = r;
	}

	/***************************************************************************************************************************
	 * Sets the length of the snake to the input number.
	 * @param l     assigns l to myLength
	 ***************************************************************************************************************************/
	public void setLength(int l) {
      myLength = l;
	}

	/***************************************************************************************************************************
	 * Sets the direction to the input number.
	 * @param d     assigns d to myDirection
	 ***************************************************************************************************************************/
	public void setDirection(int d) {
      myDirection = d;
	}

	/***************************************************************************************************************************
	 * Draws the snake object onto the map.
	 * @param myBuffer		creates snake object graphic based off of the fields found within the class 
	 * 						and then adds graphic to the map where the game is played.
	 ***************************************************************************************************************************/
	public void draw(Graphics myBuffer) {
      myBuffer.fillOval((int)(myX), (int)(myY), (int)(myRadius), (int)(myRadius));
   }
}
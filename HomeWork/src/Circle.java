import java.awt.*;
import java.awt.geom.*;

/**
 * @author  Michael Kolling
 * @author  Moti Ben-Ari (v2, v3)
 * @version 1.0  (15 July 2000)
 * @version 2.0  (21 January 2000) Change move methods
 * @version 3.0  (14 July 2001) Erase/draw are not automatic
 */

class Circle
{
    int diameter;    // The diameter of the circle
    int xPosition;   // The x,y coordinates of the upper-left corner
    int yPosition;   //    of a bounding square
    String color;    // The color of the circle
    

    int getxPosition()
    {
    	return xPosition;
    }
    
    int getyPosition()
    {
    	return yPosition;
    }
    int getDiameter()
    {
    	return diameter;
    }
    String getColor()
    {
    	return color;
    }
    // Create a new circle 
    Circle(int xPosition, int yPosition, int diameter, String color)
    {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.diameter  = diameter;
        this.color     = color;
        //draw();
    }
    
    // Move the circle to a new position.
    void moveTo(int newX, int newY)
    {
        xPosition = newX;
        yPosition = newY;
    }   
    // Move the circle by an amount.
    void move(int deltaX, int deltaY)
    {
        xPosition = xPosition + deltaX;
        yPosition = yPosition + deltaY;
    }

    // Change the size to the new size.
    void changeSizeTo(int newDiameter)
    {
        diameter = newDiameter;
    }

    // Change the size by a factor.
    void changeSize(int deltaDiameter)
    {
        diameter = diameter * deltaDiameter;
    }

    // Change the color.
    // Valid colors are "red","yellow","blue","green","magenta" and "black".
    void changeColor(String newColor)
    {
        color = newColor;
    }

    // Draw the circle with current specifications on screen.
    void draw()
    {
        Canvas canvas = Canvas.getCanvas();
        canvas.setForegroundColour(color);
        canvas.fill(new Ellipse2D.Double(
            xPosition, yPosition, diameter, diameter));
        canvas.wait(50);
    }

    // Erase the circle on screen.
    void erase()
    {
        Canvas canvas = Canvas.getCanvas();
        canvas.erase(new Ellipse2D.Double(
            xPosition, yPosition, diameter, diameter));
    }

}

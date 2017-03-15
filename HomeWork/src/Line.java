import java.awt.*;
import java.awt.geom.*;

/**
 * @author  Michael Kolling
 * @author  Moti Ben-Ari (v2, v3)
 * @version 1.0  (15 July 2000)
 * @version 2.0  (21 January 2000) Change move methods
 * @version 3.0  (14 July 2001) Erase/draw are not automatic
 */

class Line
{
    int    xPosition;   // The x,y coordinates of its start
    int    yPosition;
    int    xEnd;        // The x,y coordinates of its end
    int    yEnd;
    String color;       // The color of the line

    // Create a new line 
    Line(int xPosition, int yPosition, int xEnd, int yEnd, String color)
    {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.xEnd      = xEnd;
        this.yEnd      = yEnd;
        this.color     = color;
        //draw();
    }

    // Move the line to a new position.
    void moveTo(int newX, int newY)
    {
        xEnd      = (xEnd-xPosition) + newX;
        yEnd      = (yEnd-yPosition) + newY;
        xPosition = newX;
        yPosition = newY;
    }

    // Move the line by an amount.
    void move(int deltaX, int deltaY)
    {
        xPosition = xPosition + deltaX;
        yPosition = yPosition + deltaY;
        xEnd      = xEnd      + deltaX;
        yEnd      = yEnd      + deltaY;
    }

    // Change the size by a factor.
    void changeSize(int deltaLength)
    {
        xEnd = (xEnd - xPosition) * deltaLength;
        yEnd = (yEnd - yPosition) * deltaLength;
    }

    // Change the size + factor.
    void changeSizeTo(int deltaLength)
    {
        xEnd = xEnd + deltaLength;
    }

    // Change the color.
    // Valid colors are "red","yellow","blue","green","magenta" and "black".
    void changeColor(String newColor)
    {
        color = newColor;
    }

    // Draw the line with current specifications on screen.
    void draw()
    {
        Canvas canvas = Canvas.getCanvas();
        canvas.setForegroundColour(color);
        canvas.drawLine(xPosition, yPosition, xEnd, yEnd);
        canvas.wait(50);
    }

    // Erase the line on screen.
    void erase()
    {
        Canvas canvas = Canvas.getCanvas();
        canvas.eraseLine(xPosition, yPosition, xEnd, yEnd);
    }

}

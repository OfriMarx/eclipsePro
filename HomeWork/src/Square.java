import java.awt.*;

/**
 * @author  Michael Kolling
 * @author  Moti Ben-Ari (v2, v3)
 * @version 1.0  (15 July 2000)
 * @version 2.0  (21 January 2000) Change move methods
 * @version 3.0  (14 July 2001) Erase/draw are not automatic
 */

class Square
{
    int side;        // The side of a side of the square
    int xPosition;   // The x,y coordinates of its top left corner
    int yPosition;
    String color;    // The color of the square

    // Create a new square 
    Square(int xPosition, int yPosition, int side, String color)
    {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.side      = side;
        this.color     = color;
        draw();
    }

    // Move the square to a new position.
    void moveTo(int newX, int newY)
    {
        xPosition = newX;
        yPosition = newY;
    }

    // Move the square by an amount.
    void move(int deltaX, int deltaY)
    {
        xPosition = xPosition + deltaX;
        yPosition = yPosition + deltaY;
    }

    // Change the side to the new side.
    void changeSideTo(int newSide)
    {
        side = newSide;
    }

    // Change the side by a factor.
    void changeSide(int deltaSide)
    {
        side = side * deltaSide;
    }

    // Change the color.
    // Valid colors are "red","yellow","blue","green","magenta" and "black".
    void changeColor(String newColor)
    {
        color = newColor;
    }

    // Draw the square with current specifications on screen.
    void draw()
    {
        Canvas canvas = Canvas.getCanvas();
        canvas.setForegroundColour(color);
        canvas.fill(new Rectangle(xPosition, yPosition, side, side));
        canvas.wait(50);
    }

    // Erase the square on screen.
    void erase()
    {
        Canvas canvas = Canvas.getCanvas();
        canvas.erase(new Rectangle(xPosition, yPosition, side, side));
    }

}

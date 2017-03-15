import java.awt.*;

/**
 * @author  Michael Kolling
 * @author  Moti Ben-Ari (v2, v3)
 * @version 1.0  (15 July 2000)
 * @version 2.0  (21 January 2000) Change move methods
 * @version 3.0  (14 July 2001) Erase/draw are not automatic
 */

class Triangle
{

    int width;       // The width of the triangle
    int height;      // The height of the triangle
    int xPosition;   // The x,y coordinates of its top vertex
    int yPosition;
    String color;    // The color of the triangle

    // Create a new triangle
    Triangle(int xPosition, int yPosition, int width, int height, String color)
    {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.width     = width;
        this.height    = height;
        this.color     = color;
        //draw();
    }

    // Move the triangle to a new position.
    void moveTo(int newX, int newY)
    {
        xPosition = newX;
        yPosition = newY;
    }

    // Move the triangle by an amount.
    void move(int deltaX, int deltaY)
    {
        xPosition = xPosition + deltaX;
        yPosition = yPosition + deltaY;
    }

    // Change the size to the new size.
    void changeSizeTo(int newWidth, int newHeight)
    {
        width  = newWidth;
        height = newHeight;
    }

    // Change the size by a factor.
    void changeSize(int deltaSize)
    {
        width  = width  * deltaSize;
        height = height * deltaSize;
    }

    // Change the color.
    // Valid colors are "red","yellow","blue","green","magenta" and "black".
    void changeColor(String newColor)
    {
        color = newColor;
    }

    // Draw the triangle with current specifications on screen.
    void draw()
    {
        Canvas canvas = Canvas.getCanvas();
        canvas.setForegroundColour(color);
        int[] xpoints =
            { xPosition, xPosition + (width/2), xPosition - (width/2) };
        int[] ypoints =
            { yPosition, yPosition + height, yPosition + height };
        canvas.fill(new Polygon(xpoints, ypoints, 3));
        canvas.wait(50);
    }

    // Erase the triangle on screen.
    void erase()
    {
        Canvas canvas = Canvas.getCanvas();
        int[] xpoints =
            { xPosition, xPosition + (width/2), xPosition - (width/2) };
        int[] ypoints =
            { yPosition, yPosition + height, yPosition + height };
        canvas.erase(new Polygon(xpoints, ypoints, 3));
    }

}

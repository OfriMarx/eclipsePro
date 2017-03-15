

import javax.swing.*;
import java.awt.*;

/**
 * Class Canvas - a class to allow for simple graphical drawing on a canvas.
 * This is a modification of the general purpose Canvas, specially made for
 * the BlueJ "squares" example. The main modification is that this version
 * treats the Canvas as a singleton.
 * 
 * @author: Bruce Quig
 * @author: Michael Kolling (mik)
 * @author: Moti Ben-Ari
 *
 * @version: 1.5
 *
 * changes:
 *   19.11.99   mik     added proper buffering and screen update
 *   19.5.2000  mik     modified for "shapes" example (made singleton)
 *   14.7.2000  mik     modified to accept String colours
 *   21.1.2001  moti	added eraseline
 */

public class Canvas
{
        public static Canvas canvasSingleton;
        public static final int WIDTH = 450;
        public static final int HEIGHT = 300;

     /**
	 * Factory method to get the canvas singleton object.
	 */
	public static Canvas getCanvas()
	{
		if(canvasSingleton == null) {
			canvasSingleton = 
				new Canvas("BlueJ Canvas", 450, 300, Color.white);
			
		}
		canvasSingleton.setVisible(true);
		return canvasSingleton;
	}

	//  ----- instance part -----

    private JFrame frame;
    public CanvasPane canvas;
    public Graphics2D graphic;
    private Color backgroundColour;
    private Image canvasImage;

    /**
     * Create a Canvas.
     * @param title  title to appear in Canvas Frame
     * @param width  the desired width for the canvas
     * @param height  the desired height for the canvas
     * @param bgClour  the desired background colour of the canvas
     */
    private Canvas(String title, int width, int height, Color bgColour)
    {
        frame = new JFrame();
        canvas = new CanvasPane();
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); 
        frame.setTitle(title);
        canvas.setPreferredSize(new Dimension(width, height));
        backgroundColour = bgColour;
        frame.pack();
        frame.toFront();
    }

    /**
     * Sets the canvas visibility and brings canvas to the front of screen
     * when made visible. This method can also be used to bring an already
     * visible canvas to the front of other windows.
     * @param visible  boolean value representing the desired visibility of
     * the canvas (true or false) 
     */
    public void setVisible(boolean visible)
    {
        if(graphic == null) {
            // first time: instantiate the offscreen image and fill it with
            // the background colour
            Dimension size = canvas.getSize();
            canvasImage = canvas.createImage(size.width, size.height);
            graphic = (Graphics2D)canvasImage.getGraphics();
            graphic.setColor(backgroundColour);
            graphic.fillRect(0, 0, size.width, size.height);
            graphic.setColor(Color.black);
        }
        frame.setVisible(visible);
    }

   /**
     * Provides information on visibility of the Canvas.
     * @return  true if canvas is visible, false otherwise
     */
    public boolean isVisible()
    {
        return frame.isVisible();
    }

    /**
     * Draws a given shape onto the canvas.
     * @param  shape  the shape object to be drawn on the canvas
     */
    public void draw(Shape shape)
    {
        graphic.draw(shape);
        canvas.repaint();
    }
 
    /**
     * Fills the internal dimensions of a given shape with the current 
     * foreground colour of the canvas.
     * @param  shape  the shape object to be filled 
     */
    public void fill(Shape shape)
    {
        graphic.fill(shape);
        canvas.repaint();
    }

    /**
     * Erases a given shape's interior on the screen.
     * @param  shape  the shape object to be erased 
     */
    public void erase(Shape shape)
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColour);
        graphic.fill(shape);              // erase by filling background colour
        graphic.setColor(original);
        canvas.repaint();
    }

    /**
     * Erases a given shape's outline on the screen.
     * @param  shape  the shape object to be erased 
     */
    public void eraseOutline(Shape shape)
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColour);
        graphic.draw(shape);  // erase by drawing background colour
        graphic.setColor(original);
        canvas.repaint();
    }

    /**
     * Draws an image onto the canvas.
     * @param  image   the Image object to be displayed 
     * @param  x       x co-ordinate for Image placement 
     * @param  y       y co-ordinate for Image placement 
     * @return  returns boolean value representing whether the image was 
     *          completely loaded 
     */
    public boolean drawImage(Image image, int x, int y)
    {
System.out.println(image);
        boolean result = graphic.drawImage(image, x, y, null);
System.out.println(result);
        canvas.repaint();
        return result;
    }

    /**
     * Draws a String on the Canvas.
     * @param  text   the String to be displayed 
     * @param  x      x co-ordinate for text placement 
     * @param  y      y co-ordinate for text placement
     */
    public void drawString(String text, int x, int y)
    {
        graphic.drawString(text, x, y);   
        canvas.repaint();
    }

    /**
     * Erases a String on the Canvas.
     * @param  text     the String to be displayed 
     * @param  x        x co-ordinate for text placement 
     * @param  y        y co-ordinate for text placement
     */
    public void eraseString(String text, int x, int y)
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColour);
        graphic.drawString(text, x, y);   
        graphic.setColor(original);
        canvas.repaint();
    }

    /**
     * Draws a line on the Canvas.
     * @param  x1   x co-ordinate of start of line 
     * @param  y1   y co-ordinate of start of line 
     * @param  x2   x co-ordinate of end of line 
     * @param  y2   y co-ordinate of end of line 
     */
    public void drawLine(int x1, int y1, int x2, int y2)
    {
        graphic.drawLine(x1, y1, x2, y2);   
        canvas.repaint();
    }

    /**
     * Erases a line on the Canvas.
     * @param  x1   x co-ordinate of start of line 
     * @param  y1   y co-ordinate of start of line 
     * @param  x2   x co-ordinate of end of line 
     * @param  y2   y co-ordinate of end of line 
     */
    public void eraseLine(int x1, int y1, int x2, int y2)
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColour);
        graphic.drawLine(x1, y1, x2, y2);   
        canvas.repaint();
	}

    /**
     * Sets the foreground colour of the Canvas.
     * @param  newColour   the new colour for the foreground of the Canvas 
     */
    public void setForegroundColour(String colourString)
    {
		if(colourString.equals("red"))
			graphic.setColor(Color.red);
		else if(colourString.equals("black"))
			graphic.setColor(Color.black);
		else if(colourString.equals("blue"))
			graphic.setColor(Color.blue);
		else if(colourString.equals("yellow"))
			graphic.setColor(Color.yellow);
		else if(colourString.equals("green"))
			graphic.setColor(Color.green);
		else if(colourString.equals("magenta"))
			graphic.setColor(Color.magenta);
		else if(colourString.equals("white"))
			graphic.setColor(Color.white);
		else if(colourString.length()==9)
		{
			String r=colourString.substring(0, 3),g=colourString.substring(3, 6),b=colourString.substring(6, 9);
			int red=Integer.parseInt(r);
			int green=Integer.parseInt(g);
			int blue=Integer.parseInt(b);
			
			graphic.setColor(new Color(red,green,blue));
			
		}
			
		else
			graphic.setColor(Color.black);
    }

    /**
     * Sets the foreground colour of the Canvas.
     * @param  newColour   the new colour for the foreground of the Canvas 
     */
    public void setForegroundColour(Color newColour)
    {
        graphic.setColor(newColour);
    }

    /**
     * Returns the current colour of the foreground.
     * @return   the colour of the foreground of the Canvas 
     */
    public Color getForegroundColour()
    {
        return graphic.getColor();
    }

    /**
     * Sets the background colour of the Canvas.
     * @param  newColour   the new colour for the background of the Canvas 
     */
    public void setBackgroundColour(Color newColour)
    {
    	
        backgroundColour = newColour;   
        graphic.setBackground(newColour);
        canvas.repaint();
        
       
    }

    /**
     * Returns the current colour of the background
     * @return   the colour of the background of the Canvas 
     */
    public Color getBackgroundColour()
    {
        return backgroundColour;
    }

    /**
     * changes the current Font used on the Canvas
     * @param  newFont   new font to be used for String output
     */
    public void setFont(Font newFont)
    {
        graphic.setFont(newFont);
    }

    /**
     * Returns the current font of the canvas.
     * @return     the font currently in use
     **/
    public Font getFont()
    {
        return graphic.getFont();
    }

    /**
     * Sets the size of the canvas.
     * @param  width    new width 
     * @param  height   new height 
     */
    public void setSize(int width, int height)
    {
        canvas.setPreferredSize(new Dimension(width, height));
        frame.pack();
    }

    /**
     * Returns the size of the canvas.
     * @return     The current dimension of the canvas
     */
    public Dimension getSize()
    {
        return canvas.getSize();
    }

    /**
     * Waits for a specified number of milliseconds before finishing.
     * This provides an easy way to specify a small delay which can be
     * used when producing animations.
     * @param  milliseconds  the number 
     */
    public void wait(int milliseconds)
    {
        try
        {
            Thread.sleep(milliseconds);
        } 
        catch (Exception e)
        {
            // ignoring exception at the moment
        }
    }

    /************************************************************************
     * Nested class CanvasPane - the actual canvas component contained in the
     * Canvas frame. This is essentially a JPanel with added capability to
     * refresh the image drawn on it.
     */
    private class CanvasPane extends JPanel
    {
        public void paint(Graphics g)
        {
            g.drawImage(canvasImage, 0, 0, null);
        }
    }
}

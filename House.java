/** This program draws a house
 *   @author 
 */

// Import a couple of library-packages
import java.awt.*;
import javax.swing.*;

/** class House
 *
 * The important thing that we need to do in this class is finish the
 * 'paint' method.  
 */
public class House extends Canvas
{

    /**
     * the "paint" method, that specifies what to draw on the screen
     */
    public void paint(Graphics g)
    {
        //This line is important, don't remove it!
        super.paint(g);

        //==> Set the background color <==//
        setBackground(Color.cyan); // set background to sky blue

        //==> Draw grass <==//
        g.setColor(Color.green);
        g.fillRect(0,400,600,300);

        //==> Draw house <==//
        g.setColor(Color.magenta);
        g.fillRect(75,150,450,250);

        //==> Draw roof <==//
        g.setColor(Color.white);
        int[] xPoints = {50, 300, 550}; // X coordinates of the triangle's vertices
        int[] yPoints = {150, 20, 150};  // Y coordinates of the triangle's vertices
        int nPoints = 3; // Number of vertices
        g.fillPolygon(xPoints, yPoints, nPoints); 

        //==> Draw door and windows <==//

        //=> Door <=//
        g.setColor(Color.black);
        g.fillRect(245,245, 110,155); // draw door frame

        g.setColor(Color.white);
        g.fillRect(250,250, 100,150); // draw door

        //=> Draw doorknob <=//
        g.setColor(Color.black);
        g.fillOval(325,325,10,10); // draw doorknob

        //=> Windows <=//
        drawWindow(g,125, 225, 100, 100, Color.black, Color.white);
        drawWindow(g,375, 225, 100, 100, Color.black, Color.white);
        
    }//paint

    /** Writing Sample Assignment 
     * 
     *  Justificatin: Java graphics can be confusing to new students and can take 
     *  quite a while for drawing something complex. This method allows students to
     *  use and see how the simple concepts they've learned so far can build complex 
     *  methods or smplify a problem.   
     * 
     *  Context: Students are culminating their skills used in each checkpoint in this 
     *  lab to draw a house which shows their creativity through color and design. 
     *  You can chose whether or not they can edit this method, or if they have to write 
     *  it for extra credit :)
     * 
     *  Importance: This method not only helps students with the checkpoint, it helps the 
     *  instructor show students how they use/manipulate Java graphics medthods, explain 
     *  complex topics in the CS203 curriculum, and assist the TA in explaining 
     *  checkpoints and concepts during lab time. 
     */

    /**
     * Draws a window with a frame and a pane on a graphics context.
     * 
     * @param   g           the Graphics context to draw on
     * @param   x           the x-coordinate of the top-left corner of the window
     * @param   y           the y-coordinate of the top-left corner of the window
     * @param   width       the width of the window
     * @param   height      the height of the window
     * @param   frameColor  the color of the window frame
     * @param   paneColor   the color of the window pane
     */
    public static void drawWindow(Graphics g, int x, int y, int width, int height, Color frameColor, Color paneColor) {
        // Draw the window frame
        g.setColor(frameColor);
        g.fillRect(x, y, width, height);

        // Define the thickness of the frame
        int frameThickness = 4;

        // Draw the window pane
        g.setColor(paneColor);
        g.fillRect(x + frameThickness, y + frameThickness, width - 2 * frameThickness, height - 2 * frameThickness);

        // Add divisions to the window pane (Optional)
        int divisionThickness = 2;
        int centerX = x + width / 2;
        int centerY = y + height / 2;

        // Vertical division
        g.setColor(frameColor);
        g.fillRect(centerX - divisionThickness / 2, y + frameThickness, divisionThickness, height - 2 * frameThickness);

        // Horizontal division
        g.fillRect(x + frameThickness, centerY - divisionThickness / 2, width - 2 * frameThickness, divisionThickness);
    }

    /**
     * main
     *
     * All Java programs start with a method named main.  This class' main
     * method creates the window to display your Java drawing.
     *
     * IMPORTANT:  DO NOT MODIFY THIS METHOD
     */
    public static void main(String[] args)
    {
        //Create a window for this program
        JFrame myFrame = new JFrame();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(600,600);
 
       
        //Put an instance of this class in the window frame
        House myContent = new House();
        myContent.setBackground(Color.gray.brighter());
        myFrame.getContentPane().add(myContent);
        
        //Display the frame
        myFrame.setVisible(true);
        
    }//main

        
    
}//class House

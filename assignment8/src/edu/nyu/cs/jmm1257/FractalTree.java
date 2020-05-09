package edu.nyu.cs.jmm1257;

// import necessary Java Classes to create graphics
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

// import necessary Java Classes that use Swing to create a graphical user interface
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Program that draws a Fractal Tree by extending multiple smaller branches from each 
 * branch using a recursive function.
 *
 * @author Foo Barstein, with comments by Julia McNeill (jmm1257)
 */
public class FractalTree extends JPanel {
	/** The Graphics2D class, an extension of the Graphics class that allows us to render 2D shapes, text, and images */
    public Graphics2D g1;
    /** The maximum angle for the direction of each branch */
    public static final int maxAngle = 360;
    /** The starting x-axis position for first branch */
    public static final int startX = 600;
    /** The starting y-axis position for first branch */
    public static final int startY = 800;
    /** The total number of recursions that determines number of branches and complexity of tree. */
    public static final int numOfRecursions = 9;
    /** The starting angle for the direction of each branch. */
    public static final int startAngle = 0;
    /** An integer that helps to determine how long the branches are. */
    public static final double treeSize = 2;
    /** The benchmark or flag for when numOfRecursions should stop decrementing and the drawFractal should stop 
     * recursively calling itself */
    public static final int Detail = 3;
    /** An integer that is used in conjunction with a random integer to create variance for each branch angle */
    public static final int randFact = 30;
    /** An array of four integers that determine the angle of each of the four recursively called branches in drawFractal */ 
    public static final int[] constFact = {-60, 05, -50, 45};
    
    /** Three integer arrays that provide a list of RGB values to be selectively used for each branch */
    public static int[] red =   {0, 0, 0, 0, 7, 15, 23, 31, 39, 47, 55, 43};
    public static int[] green = {171, 159, 147, 135, 123, 111, 99, 87, 75, 63, 51, 43};
    public static int[] blue =  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};   
     
    /**
     * Convert degrees to radians
     * @param deg Angle degree value passed in from drawFractal
     * @return The angle degree converted to radians for use in sin and cos functions 
     */
    public static double degToRad(int deg) {
        return deg * Math.PI / 180;
    }
    
    /**
     * Recursively draws new branches on the fractal tree, adding on four new branches to the current 
     * branch and calling the function again on each of these branches, then drawing the current branch
     * @param g1 The external Graphics2D class, loaded in at the start
     * @param x The starting x coordinate of the branch
     * @param y The starting y coordinate of the branch
     * @param n Control variable that is decremented to determine how more times branches should be added
     * @param angle Angle that is used to determine the ending x and y coordinate of the branch
     * @return If control variable has reached the value of Detail, end function immediately 
     * @return Else, return function after it has recursively called itself four times and drawn its own branch
     */
    public static void drawFractal(Graphics2D g1, int x, int y, int n, int angle) {
    	// n, or the numOfRecursions, is decremented by 1 for each extended branch. if n has reached the value of flag Detail, 
    	// return immediately and do not recursively create new branches or draw the current branch
        if (n == Detail) return;
        /** An integer that determines the length of the branch, using treeSize to the power of n - 1, with 
         * branches getting shorter as n gets smaller on each recursion */
        int len = (int) Math.round(Math.pow(treeSize, n - 1));
         
        // Two integers that use passed-in angle and calculated length to determine the ending x and y values 
        // of the current branch
        int xn1 = (int) Math.round(x - (2 * len * Math.sin(degToRad(angle))));
        int yn1 = (int) Math.round(y - (2 * len * Math.cos(degToRad(angle))));
        
        // A list of integers that determine the new starting x and y values for the four new branches, called recursively 
        // below, that are branching out from the current branch somewhere along the branch, further along the branch for
        // each of the four new branch */
        int mid1x = (x + xn1) / 2;
        int mid1y = (y + yn1) / 2;
        int mid2x = (mid1x + xn1) / 2;
        int mid2y = (mid1y + yn1) / 2;
        int mid3x = (x + mid1x) / 2;
        int mid3y = (y + mid1y) / 2;
        int mid4x = (mid3x + mid1x) / 2;
        int mid4y = (mid3y + mid1y) / 2;
        
        /** A function that generates a random integer when called */
        java.util.Random r = new java.util.Random();
        // Recursively call the drawFractal function passing in the discussed above variables for starting x and y position
        // The n, originally numOfRecursions, integer is decreased by 1 for this new set of branches and is now 1 closer to 
        // reaching the flag Detail, when the tree will stop recursively creating itself
        // The last argument, angle, is creating using the remainder of the sum of the current angle, a random number that is
        // max 30, and a number from the constFact array divided by the maxAngle
        drawFractal(g1, mid1x, mid1y, n - 1, (angle + r.nextInt(randFact) + constFact[0]) % maxAngle);
        drawFractal(g1, mid2x, mid2y, n - 1, (angle + r.nextInt(randFact) + constFact[1]) % maxAngle);
        drawFractal(g1, mid3x, mid3y, n - 1, (angle + r.nextInt(randFact) + constFact[2]) % maxAngle);
        drawFractal(g1, mid4x, mid4y, n - 1, (angle + r.nextInt(randFact) + constFact[3]) % maxAngle);
         
        /** A generated new color for each branch that as n increases, draws from a higher index in the color integer 
         * arrays, becoming more green each time as the green value in the array increases and the red value decreases */
        Color c = new Color(red[(r.nextInt() % 3) + n], green[(r.nextInt() % 3) + n], blue[(r.nextInt() % 3) + n]);
        // Set the color of the branch
        g1.setColor(c);
        /** The current branch drawn as a 2D Line */
        Line2D L1 = new Line2D.Double(x, y, xn1, yn1);
        // Draw the branch
        g1.draw(L1);
        return;
    }
    
    /**
     * Call drawFractal for the first time
     * @param g The external abstract Graphics class, loaded in at the start
     */
    public void paint(final Graphics g) {
    	/** Cast the Graphics class to Graphics2D, a class which extends Graphics */
        g1 = (Graphics2D) g;
        // calls drawFractal, passing in the relevant starting variables
        drawFractal(g1, startX, startY, numOfRecursions, startAngle);
    }
    
    /**
     * Set up JFrame title, color, visibility, size, etc. and creates new FractalTree which 
     * extends JPanel and therefore calls the paint function
     * @param args Array of command-line arguments
     */
    public static void main(String args[]) {
    	/** A JFrame with title that appears at the top of frame */
        JFrame FF = new JFrame("Drawing a recursive tree");
        // Set the JFrame to exit instead of hide
        FF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /** An instance of the fractal tree created by calling its class */
        FractalTree F = new FractalTree();
        // Set the background color of the frame window
        FF.setBackground(Color.BLACK);
        // Add the fractal tree to the frame window
        FF.add(F);
        // The pack methods sizes the frame to be around the content
        FF.pack();
        // Set the frame to be visible
        FF.setVisible(true);
        // Set the size of the frame
        FF.setSize(1200, 1000);
    }
}

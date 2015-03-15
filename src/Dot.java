import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

/**
 * Created by Cedric on 15.03.2015.
 */
public class Dot {

    /////////////////////////
    //  --- Constants ---  //
    /////////////////////////

    private static final Dimension SIZE = new Dimension(50, 50);


    //////////////////////////////////
    //  --- Instance Variables ---  //
    //////////////////////////////////

    /** AWT Ellipse Object to store the shape of the dot. */
    private Ellipse2D ellipse;

    /** AWT Color Object to store the color of the dot */
    private Color color;


    ///////////////////////
    //  --- Methods ---  //
    ///////////////////////

    public Dot() {
        // Create random number generator from system time
        Random rg = new Random(System.currentTimeMillis());
        // use rg to create randomness
        int r = rg.nextInt(255);
        int g = rg.nextInt(255);
        int b = rg.nextInt(255);

        // Initialize all the stuff
        ellipse = new Ellipse2D.Double(0, 0, Dot.SIZE.getWidth(), Dot.SIZE.getHeight());
        color = new Color(r, g, b);
    }

    public Ellipse2D getEllipse() {
        return ellipse;
    }

    public Color getColor() {
        return color;
    }
}

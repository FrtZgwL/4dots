import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

/**
 * Created by Cedric on 15.03.2015.
 */
public class Dot implements GameColors {

    /////////////////////////
    //  --- Constants ---  //
    /////////////////////////

    private static final Dimension SIZE = new Dimension(40, 40);


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

    /**
     * Constructor for Dot that allows setting of the Color
     * @param color The Color the dot is supposed to have
     */
    public Dot(Color color) {
        // use standard constructor
        this();
        // but allow setting of the color
        this.color = color;
    }

    public Dot() {
        // Create random number generator from system time
        Random rg = new Random(System.currentTimeMillis());
        // the game only has the 4 Colors specified in the GameColors defined in the GameColors Interface,
        // so we just choose a index from 0-3
        int colorIndex = rg.nextInt(3);

        // Initialize all the stuff
        ellipse = new Ellipse2D.Double(0, 0, Dot.SIZE.getWidth(), Dot.SIZE.getHeight());
        this.color = COLORS[colorIndex];
    }

    public Ellipse2D getEllipse() {
        return ellipse;
    }

    public Color getColor() {
        return color;
    }
}
